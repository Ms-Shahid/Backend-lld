package org.backend.session.lld2.designpatterns.strategy.streaming;

public interface QualityAdjustmentStrategy {

    VideoQuality supportsType();
    Video adjust(Video video);
}
