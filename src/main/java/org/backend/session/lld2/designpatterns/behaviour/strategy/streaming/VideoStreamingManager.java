package org.backend.session.lld2.designpatterns.strategy.streaming;

public class VideoStreamingManager {

    private Video video;
    private QualityAdjustmentStrategy qualityAdjustmentStrategy;

    public VideoStreamingManager(Video video, QualityAdjustmentStrategy qualityAdjustmentStrategy) {
        this.video = video;
        this.qualityAdjustmentStrategy = qualityAdjustmentStrategy;
    }

    public Video streamVideo() {
        switch (video.getVideoQuality()) {
            case LOW:
                video.setCodec(VideoCodec.H264);
                video.setBitrate(500);
                return video;
            case MEDIUM:
                video.setCodec(VideoCodec.H265);
                video.setBitrate(1000);
                return video;
            case HIGH:
                video.setCodec(VideoCodec.VP9);
                video.setBitrate(2000);
                return video;
        }

        throw new IllegalArgumentException("Unsupported video quality!");
    }
}
