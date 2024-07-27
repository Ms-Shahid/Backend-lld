package org.backend.session.lld2.designpatterns.factory.audioplayer;

public abstract class AudioPlayer {

    private int volume;
    private double playBackRate;

    public AudioPlayer(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    public abstract MediaFormat supportType();

    public abstract void play();

    public abstract void stop();

    public abstract void pause();

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }

    public int getVolume() {
        return volume;
    }

    public double getPlayBackRate() {
        return playBackRate;
    }
}
