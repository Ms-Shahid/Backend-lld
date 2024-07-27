package org.backend.session.lld2.designpatterns.factory.audioplayer;

public class FLACPlayer extends AudioPlayer{


    public FLACPlayer(int volume, double playBackRate) {
        super(volume, playBackRate);
    }


    public MediaFormat supportType() {
        return MediaFormat.FLAC;
    }

    @Override
    public void play() {
        // Simulate playing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Playing FLAC audio");
    }

    @Override
    public void pause() {
        // Simulate pausing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Pausing FLAC audio");
    }

    @Override
    public void stop() {
        // Simulate stopping audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Stopping FLAC audio");
    }



}
