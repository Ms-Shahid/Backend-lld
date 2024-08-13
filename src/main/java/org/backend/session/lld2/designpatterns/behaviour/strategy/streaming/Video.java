package org.backend.session.lld2.designpatterns.strategy.streaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {
    private String videoUrl;
    private VideoQuality videoQuality;
    private VideoCodec codec;
    private Integer bitrate;

    public Video(String videoUrl, VideoQuality videoQuality) {
        this.videoUrl = videoUrl;
        this.videoQuality = videoQuality;
    }
}
