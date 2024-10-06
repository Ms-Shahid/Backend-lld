package org.backend.session.lld2.designpatterns.strategy.streaming;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class VideoStreamingManagerTest {

    @Test
    public void testConcreteStrategies() {
        Reflections reflections = new Reflections(VideoStreamingManagerTest.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends QualityAdjustmentStrategy>> subTypes =
                reflections.getSubTypesOf(QualityAdjustmentStrategy.class);

        assertEquals(3, subTypes.size(), "If the strategy pattern is implemented correctly, there should be 3 concrete strategies for each video quality.");
    }

    @Test
    public void testQualityAdjustmentStrategyMethod() {

        Class<?> strategyClass = QualityAdjustmentStrategy.class;
        Method[] methods = strategyClass.getDeclaredMethods();

        boolean hasAdjustQualityMethod = Stream.of(methods)
                .anyMatch(method -> method.getParameterCount() == 1 && method.getParameterTypes()[0] == Video.class && method.getReturnType() == Video.class);

        assertTrue(hasAdjustQualityMethod, "If the strategy pattern is implemented correctly, QualityAdjustmentStrategy should have a method that accepts a Video object and returns a Video object.");
    }

    @Test
    public void testVideoStreamingManagerFields() {
        Class<?> videoStreamingManagerClass = VideoStreamingManager.class;
        Field[] fields = videoStreamingManagerClass.getDeclaredFields();

        boolean hasStrategyField = Stream.of(fields)
                .anyMatch(field -> Modifier.isPrivate(field.getModifiers()) && field.getType() == QualityAdjustmentStrategy.class);

        assertTrue(hasStrategyField, "If the strategy pattern is implemented correctly, VideoStreamingManager should have a private field of type QualityAdjustmentStrategy.");
    }

    @Test
    public void testVideoStreamingManagerConstructor() {
        Class<?> videoStreamingManagerClass = VideoStreamingManager.class;
        Constructor<?>[] constructors = videoStreamingManagerClass.getDeclaredConstructors();

        boolean hasVideoStreamingManagerConstructor = Stream.of(constructors)
                .anyMatch(constructor -> constructor.getParameterCount() == 2 && constructor.getParameterTypes()[0] == Video.class && constructor.getParameterTypes()[1] == QualityAdjustmentStrategy.class);

        assertTrue(hasVideoStreamingManagerConstructor, "If the strategy pattern is implemented correctly, VideoStreamingManager should have a constructor that accepts a QualityAdjustmentStrategy object.");
    }

    @Test
    public void testStreamingStrategy() throws Exception {
        // Get all subtypes of QualityAdjustmentStrategy using reflection
        Reflections reflections = new Reflections(VideoStreamingManagerTest.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends QualityAdjustmentStrategy>> subTypes =
                reflections.getSubTypesOf(QualityAdjustmentStrategy.class);

        // Iterate over the subtypes
        for (Class<?> strategyClass : subTypes) {
            // Dynamically create an instance of the concrete strategy using reflection
            Constructor<?> strategyConstructor = strategyClass.getDeclaredConstructor();
            QualityAdjustmentStrategy strategy = (QualityAdjustmentStrategy) strategyConstructor.newInstance();

            // Create a video streaming manager with the concrete strategy
            VideoQuality quality = strategy.supportsType();
            Video video = new Video("url", quality);
            VideoStreamingManager manager = new VideoStreamingManager(video, strategy);

            // Call the adjust method on the video streaming manager
            Video adjustedVideo = manager.streamVideo();
            if (quality == VideoQuality.LOW) {
                assertEquals(VideoCodec.H264, adjustedVideo.getCodec(), "If the strategy pattern is implemented correctly, the codec should be H264 for low quality videos.");
                assertEquals(500, adjustedVideo.getBitrate(), "If the strategy pattern is implemented correctly, the bitrate should be 500 for low quality videos.");
            } else if (quality == VideoQuality.MEDIUM) {
                assertEquals(VideoCodec.H265, adjustedVideo.getCodec(), "If the strategy pattern is implemented correctly, the codec should be H265 for medium quality videos.");
                assertEquals(1000, adjustedVideo.getBitrate(), "If the strategy pattern is implemented correctly, the bitrate should be 1000 for medium quality videos.");
            } else if (quality == VideoQuality.HIGH) {
                assertEquals(VideoCodec.VP9, adjustedVideo.getCodec(), "If the strategy pattern is implemented correctly, the codec should be VP9 for high quality videos.");
                assertEquals(2000, adjustedVideo.getBitrate(), "If the strategy pattern is implemented correctly, the bitrate should be 2000 for high quality videos.");
            }

        }
    }
}