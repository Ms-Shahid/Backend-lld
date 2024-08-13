package org.backend.session.lld2.designpatterns.strategy.streaming;

public class HighQuality implements QualityAdjustmentStrategy{
    @Override
    public VideoQuality supportsType() {

        return VideoQuality.HIGH;
    }

    @Override
    public Video adjust(Video video) {
        return video;
    }
}
