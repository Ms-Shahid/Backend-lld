package org.backend.session.lld2.designpatterns.strategy.ridesharingapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PricingManagerTest {

    private static Constructor<?> getStrategyConstructor() {
        Class<?> pricingManagerClass = PricingManager.class;
        Constructor<?>[] constructors = pricingManagerClass.getDeclaredConstructors();

        return Stream.of(constructors).filter(constructor -> constructor.getParameterCount() == 2 && constructor.getParameterTypes()[0] == PricingType.class && constructor.getParameterTypes()[1] == PricingStrategy.class).findFirst().orElse(null);
    }

    @Test
    public void testConcreteStrategies() {
        Reflections reflections = new Reflections(PricingManagerTest.class.getPackageName(), new SubTypesScanner(false));
        Set<Class<? extends PricingStrategy>> subTypes = reflections.getSubTypesOf(PricingStrategy.class);

        assertEquals(3, subTypes.size(), "If the strategy pattern is implemented correctly, there should be 3 concrete strategies for each pricing type.");
    }

    @Test
    public void testCalculatePriceStrategyMethod() {

        Class<?> strategyClass = PricingStrategy.class;
        Method[] methods = strategyClass.getDeclaredMethods();

        boolean hasCalculatePriceMethod = Stream.of(methods).anyMatch(method -> method.getParameterCount() == 1 && method.getParameterTypes()[0] == RideDetails.class && method.getReturnType() == Double.class);

        assertTrue(hasCalculatePriceMethod, "If the strategy pattern is implemented correctly, PricingStrategy should have a method that accepts a RideDetails object and returns a Double.");
    }

    @Test
    public void testPricingManagerFields() {
        Class<?> pricingManagerClass = PricingManager.class;
        Field[] fields = pricingManagerClass.getDeclaredFields();

        boolean hasStrategyField = Stream.of(fields).anyMatch(field -> Modifier.isPrivate(field.getModifiers()) && field.getType() == PricingStrategy.class);

        assertTrue(hasStrategyField, "If the strategy pattern is implemented correctly, PricingManager should have a private field of type PricingStrategy.");
    }

    @Test
    public void testPricingManagerConstructor() {
        assertNotNull(getStrategyConstructor(), "If the strategy pattern is implemented correctly, PricingManager should have a constructor that accepts a PricingStrategy object.");
    }

    @Test
    public void testPricingStrategy() throws Exception {
        Constructor<?> constructor = getStrategyConstructor();
        assertNotNull(constructor, "If the strategy pattern is implemented correctly, PricingManager should have a constructor that accepts a PricingType and PricingStrategy object.");
        // Get all subtypes of PricingStrategy using reflection
        Reflections reflections = new Reflections(PricingManagerTest.class.getPackageName(), new SubTypesScanner(false));
        Set<Class<? extends PricingStrategy>> subTypes = reflections.getSubTypesOf(PricingStrategy.class);

        // Iterate over the subtypes
        for (Class<?> strategyClass : subTypes) {
            // Dynamically create an instance of the concrete strategy using reflection
            Constructor<?> strategyConstructor = strategyClass.getDeclaredConstructor();
            PricingStrategy strategy = (PricingStrategy) strategyConstructor.newInstance();

            // Create a video streaming manager with the concrete strategy
            PricingType pricingType = strategy.supportsType();
            PricingManager pricingManager = (PricingManager) constructor.newInstance(pricingType, strategy);

            // Call the adjust method on the video streaming manager
            RideDetails rideDetails = new RideDetails(10, 60);
            Double price = pricingManager.calculatePrice(rideDetails);

            if (pricingType == PricingType.DISTANCE_BASED) {
                assertEquals(25.0, price, "If the strategy pattern is implemented correctly, the price should be 25.0 for a distance of 10 km.");
            } else if (pricingType == PricingType.TIME_BASED) {
                assertEquals(35.0, price, "If the strategy pattern is implemented correctly, the price should be 35.0 for a duration of 60 minutes.");
            } else if (pricingType == PricingType.SURGE) {
                assertEquals(10.0, price, "If the strategy pattern is implemented correctly, the price should be 10.0 for surge pricing.");
            }
        }
    }
}