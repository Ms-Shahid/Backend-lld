package org.backend.session.lld2.designpatterns.factory.audioplayer;

import static org.backend.session.lld2.designpatterns.factory.audioplayer.MediaFormat.*;

public class AudioPlayerFactory {

    public static AudioPlayer getAudioPlayer(MediaFormat audioType, int volume, double playBackRate) {

        return switch (audioType) {
            case MP3 -> new MP3Player(volume, playBackRate);
            case FLAC -> new FLACPlayer(volume, playBackRate);
            case WAV -> new WAVPlayer(volume, playBackRate);
        };
    }
}
