package org.backend.session.lld2.designpatterns.strategy.streaming;

public class MediumQuality implements QualityAdjustmentStrategy{
    @Override
    public VideoQuality supportsType() {
        return VideoQuality.MEDIUM;
    }

    @Override
    public Video adjust(Video video) {
        return video;
    }
}
