package org.backend.session.lld2.designpatterns.singelton.logger;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.boot.logging.LogLevel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerSolutionTest {
    private static Class<? extends Logger> implementationClass;

    @TempDir
    private Path tempDir;

    private File logFile;

    @BeforeAll
    public static void setUpClass() {
        // Get the package name of the test class
        String packageName = LoggerTest.class.getPackageName();

        // Use Reflections to scan for classes within the package
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends Logger>> subTypes = reflections
                .getSubTypesOf(Logger.class);

        // Find a non-abstract implementation of Logger
        for (Class<?> clazz : subTypes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                implementationClass = (Class<? extends Logger>) clazz;
                break;
            }
        }
    }

    @Test
    public void preTestConfigurationManagerImplementationFound() {
        assertNotNull(implementationClass,
                "If an implementation of Logger exists, it should be found");

        Constructor<?>[] constructors = implementationClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            assertFalse(Modifier.isPublic(constructor.getModifiers()),
                    "If an implementation of Logger exists, it should not have a public constructor");
        }

        try {
            Method getInstanceMethod = implementationClass.getDeclaredMethod("getInstance");
            assertTrue(Modifier.isStatic(getInstanceMethod.getModifiers()),
                    "If getInstance() is present, it should be a static method");
        } catch (NoSuchMethodException e) {
            fail("If an implementation of Logger exists, it should have a static getInstance() method");
        }

        try {
            Method resetInstanceMethod = implementationClass.getDeclaredMethod("resetInstance");
            assertTrue(Modifier.isStatic(resetInstanceMethod.getModifiers()),
                    "If resetInstance() is present, it should be a static method");

        } catch (NoSuchMethodException e) {
            fail("If an implementation of Logger exists, it should have a static resetInstance() method");
        }
    }

    @BeforeEach
    public void setUp(TestInfo info) throws IOException {
        if (info.getDisplayName().startsWith("preTest")) {
            return;
        }

        resetInstance();
        logFile = Files.createTempFile(tempDir, "test", ".log").toFile();
    }

    private static void resetInstance() {
        try {
            Method resetInstanceMethod = implementationClass.getDeclaredMethod("resetInstance");
            resetInstanceMethod.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetInstanceMethod() {

        Assumptions.assumeTrue(implementationClass != null);

        Logger instance = getInstance();
        assertNotNull(instance, "If getInstance() is called, it should return a non-null instance");
    }

    private static Logger getInstance() {
        try {

            Method getInstanceMethod = implementationClass.getDeclaredMethod("getInstance");
            Logger instance = (Logger) getInstanceMethod.invoke(null);
            return instance;
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testSingletonBehavior() {

        Assumptions.assumeTrue(implementationClass != null);

        Logger instance1 = getInstance();
        Assumptions.assumeTrue(instance1 != null);

        Logger instance2 = getInstance();

        assertSame(instance1, instance2,
                "If getInstance() is called multiple times, it should return the same instance");
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void testSingletonThreadSafety() throws InterruptedException {

        Assumptions.assumeTrue(implementationClass != null);

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);
        Logger[] instances = new Logger[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            executorService.submit(() -> {
                instances[index] = getInstance();
                latch.countDown();
            });
        }

        latch.await();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        Logger referenceInstance = instances[0];
        for (int i = 1; i < numThreads; i++) {
            assertSame(referenceInstance, instances[i],
                    "If getInstance() is called by multiple threads, it should return the same instance");
        }
    }

    @Test
    public void testResetInstanceMethod() {

        Assumptions.assumeTrue(implementationClass != null);

        Logger instance1 = getInstance();
        Assumptions.assumeTrue(instance1 != null);

        resetInstance();

        Logger instance2 = getInstance();

        assertNotSame(instance1, instance2,
                "If resetInstance() is called, getInstance() should return a new instance");
    }

    @Test
    public void testLogMethod() {
        Assumptions.assumeTrue(implementationClass != null);

        Logger logger = getInstance();
        Assumptions.assumeTrue(logger != null);

        logger.setLogFile(logFile.getAbsolutePath());

        LogLevel level = LogLevel.INFO;
        String message = "Test log message";

        logger.log(level, message);
        logger.flush();
        // Verify that the log file contains the log message
        String logContents;
        try {
            logContents = Files.readString(logFile.toPath());
            assertTrue(logContents.contains(message), logContents);
        } catch (IOException e) {
            fail("Failed to read log file: " + e.getMessage());
        }
    }

    @Test
    public void testSetLogFile() {
        Assumptions.assumeTrue(implementationClass != null);

        Logger logger = getInstance();
        Assumptions.assumeTrue(logger != null);

        String filePath = logFile.getAbsolutePath();

        logger.setLogFile(filePath);
        String actualFilePath = logger.getLogFile();

        assertEquals(filePath, actualFilePath, "Setting log file path should be reflected in getLogFile()");
    }

    @Test
    public void testFlushMethod() {
        Assumptions.assumeTrue(implementationClass != null);

        Logger logger = getInstance();
        Assumptions.assumeTrue(logger != null);

        logger.setLogFile(logFile.getAbsolutePath());

        LogLevel level = LogLevel.INFO;
        String message = "Test log message";

        logger.log(level, message);
        logger.flush();

        // Verify that the log contents are flushed to the log file
        String logContents;
        try {
            logContents = Files.readString(logFile.toPath());
            assertTrue(logContents.contains(message), "Log message should be present in the log file after flush");
        } catch (IOException e) {
            fail("Failed to read log file: " + e.getMessage());
        }
    }

    @Test
    public void testCloseMethod() {
        Assumptions.assumeTrue(implementationClass != null);

        Logger logger = getInstance();
        Assumptions.assumeTrue(logger != null);

        logger.setLogFile(logFile.getAbsolutePath());

        // Close the logger
        logger.close();

        // Assert that IllegalStateException is thrown when log() is called
        assertThrows(IllegalStateException.class, () -> logger.log(LogLevel.INFO, "Test log message"),
                "Calling log() after close() should throw IllegalStateException");
    }

}