package com.assignment.question;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class QueryBuilderTest {

    private static final Class<?> originalClass = Query.class;
    private static Class<?> outerClass;
    private static Class<?> innerClass;

    @BeforeAll
    public static void setUp() {

        String packageName = QueryBuilderTest.class.getPackageName();
        Reflections reflections = new Reflections(packageName);

        outerClass = loadClass(reflections, WithBuilder.class);
        innerClass = loadInnerClass(outerClass);
    }

    private static Class<?> loadClass(Reflections reflections, Class<? extends Annotation> annotation) {

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(annotation);
        if (classes.isEmpty()) {
            fail("If the builder pattern is implemented, there should be a class annotated with " + annotation.getSimpleName());
        }
        if (classes.size() > 1) {
            fail("There should be exactly one class annotated with " + annotation.getSimpleName());
        }

        return classes.iterator().next();
    }

    private static Class<?> loadInnerClass(Class<?> outerClass) {
        Class<?>[] innerClasses = outerClass.getDeclaredClasses();
        for (Class<?> innerClass : innerClasses) {
            if (Modifier.isStatic(innerClass.getModifiers())) {
                return innerClass;
            }
        }

        return null;
    }

    private static Field getReferenceToOuterClass() {
        Field[] innerClassFields = innerClass.getDeclaredFields();
        return Arrays.stream(innerClassFields).filter(innerField -> innerField.getType().equals(outerClass)).findFirst().orElse(null);
    }

    @Test
    public void testBuilderClassHasStaticClass() {

        Assumptions.assumeTrue(outerClass != null);

        assertNotNull(innerClass, "If the builder pattern is implemented, the builder class should have a static inner class");

        assertTrue(innerClass.isMemberClass(), "If the builder pattern is implemented, the builder class should be an inner class");
        assertTrue(Modifier.isPublic(innerClass.getModifiers()), "If the builder pattern is implemented, the builder class should be public");
        assertTrue(Modifier.isStatic(innerClass.getModifiers()), "If the builder pattern is implemented, the builder class should be static");
    }

    @Test
    public void testBuilderClassHasAllFields() {

        Field[] originalFields = originalClass.getDeclaredFields();
        Field[] builderFields = outerClass.getDeclaredFields();

        boolean allFieldsPresent = Arrays.stream(originalFields).allMatch(originalField -> Arrays.stream(builderFields).anyMatch(builderField -> builderField.getName().equals(originalField.getName()) && builderField.getType().equals(originalField.getType())));

        assertTrue(allFieldsPresent, "If the builder pattern is implemented, the builder class should have a field for each field in the original class");
    }

    @Test
    public void testInnerFields() {

        Assumptions.assumeTrue(outerClass != null && innerClass != null);
        Field[] innerClassFields = innerClass.getDeclaredFields();

        boolean hasReference = getReferenceToOuterClass() != null;

        Field[] originalFields = originalClass.getDeclaredFields();
        Set<String> originalFieldNames = Arrays.stream(originalFields).map(Field::getName).collect(Collectors.toSet());

        Set<String> innerFieldNames = Arrays.stream(innerClassFields).map(Field::getName).collect(Collectors.toSet());

        boolean allFieldsPresent = innerFieldNames.containsAll(originalFieldNames);
        assertTrue(hasReference || allFieldsPresent, "If the builder pattern is implemented, the builder class should have either a reference to the original class or all its fields");
    }

    @Test
    public void testBuilderClassHasBuildMethod() {

        Assumptions.assumeTrue(outerClass != null && innerClass != null);

        Method[] builderMethods = innerClass.getDeclaredMethods();
        Optional<Method> buildMethod = Arrays.stream(builderMethods).filter(method -> method.getName().equals("build")).findFirst();
        assertTrue(buildMethod.isPresent(), "If the builder pattern is implemented, the builder class should have a build method");

        boolean buildMethodReturnsOriginalClass = buildMethod.get().getReturnType().equals(outerClass);
        assertTrue(buildMethodReturnsOriginalClass, "If the builder pattern is implemented, the build method should return an instance of the outer class");
    }


    @Test
    public void testBuildMethodCopiesValues() {
        Assumptions.assumeTrue(outerClass != null && innerClass != null);

        if (getReferenceToOuterClass() == null) {
            testBuildMethodCopiesValuesToOuterClass();
            return;
        }

        testBuildMethodWithReferenceForSpecificFields();

    }

    private void testBuildMethodCopiesValuesToOuterClass() {

        try {
            Class<?> builderClass = Class.forName(innerClass.getName());
            Constructor<?> constructor = builderClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object builderInstance = constructor.newInstance();

            // Set values in the builder using fields
            Field selectField = builderClass.getDeclaredField("select");
            Field fromField = builderClass.getDeclaredField("from");
            Field whereField = builderClass.getDeclaredField("where");

            selectField.setAccessible(true);
            fromField.setAccessible(true);
            whereField.setAccessible(true);

            selectField.set(builderInstance, "id");
            fromField.set(builderInstance, "users");
            whereField.set(builderInstance, "name='Tantia'");

            // Call the build method
            Method buildMethod = innerClass.getDeclaredMethod("build");
            Object builtInstance = buildMethod.invoke(builderInstance);
            assertNotNull(builtInstance, "If the builder pattern is implemented, the build method should return a non-null object");

            // Verify values in the built instance
            Field[] originalFields = outerClass.getDeclaredFields();
            for (Field originalField : originalFields) {
                originalField.setAccessible(true);
                Field builderField = builderClass.getDeclaredField(originalField.getName());
                builderField.setAccessible(true);

                assertEquals(builderField.get(builderInstance), originalField.get(builtInstance), "If the builder pattern is implemented, the build method should copy the values from the builder to the outer class");
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
            fail("An error occurred while testing the build method: " + e.getMessage());
        }
    }

    private void testBuildMethodWithReferenceForSpecificFields() {
        Assumptions.assumeTrue(outerClass != null && innerClass != null && getReferenceToOuterClass() != null);

        try {
            Class<?> builderClass = Class.forName(innerClass.getName());
            Constructor<?> constructor = builderClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object builderInstance = constructor.newInstance();

            // Get the reference field if applicable
            Field referenceField = getReferenceToOuterClass();
            assertNotNull(referenceField, "If the builder pattern is implemented with a reference, the builder class should have a reference field");
            referenceField.setAccessible(true);

            // Set values for select, from, and where in the reference instance
            Class<?> referenceClass = referenceField.getType();
            Constructor<?> referenceConstructor = referenceClass.getDeclaredConstructor();
            referenceConstructor.setAccessible(true);
            Object referenceInstance = referenceConstructor.newInstance();

            Field selectField = referenceClass.getDeclaredField("select");
            Field fromField = referenceClass.getDeclaredField("from");
            Field whereField = referenceClass.getDeclaredField("where");

            selectField.setAccessible(true);
            fromField.setAccessible(true);
            whereField.setAccessible(true);

            selectField.set(referenceInstance, "id");
            fromField.set(referenceInstance, "users");
            whereField.set(referenceInstance, "name='Tantia'");

            referenceField.set(builderInstance, referenceInstance);

            // Call the build method
            Method buildMethod = innerClass.getDeclaredMethod("build");
            Object builtInstance = buildMethod.invoke(builderInstance);
            assertNotNull(builtInstance, "If the builder pattern is implemented, the build method should return a non-null object");

            // Verify values in the built instance using reflection
            Field[] originalFields = outerClass.getDeclaredFields();
            for (Field originalField : originalFields) {
                originalField.setAccessible(true);
                Field builderField = referenceClass.getDeclaredField(originalField.getName());
                builderField.setAccessible(true);

                assertEquals(builderField.get(referenceInstance), originalField.get(builtInstance), "If the builder pattern is implemented with a reference, the build method should copy the values from the reference to the outer class");
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                 ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
            fail("An error occurred while testing the build method: " + e.getMessage());
        }
    }


}