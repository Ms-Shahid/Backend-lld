package org.backend.session.lld2.designpatterns.strategy.streaming;

public class LowQuality implements QualityAdjustmentStrategy{
    @Override
    public VideoQuality supportsType() {
        return VideoQuality.LOW;
    }

    @Override
    public Video adjust(Video video) {
        return video;
    }
}
