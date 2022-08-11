package design_patterns.b_structural.adapter.example02.c;

import design_patterns.b_structural.adapter.example02.a.AdvancedMediaPlayer;
import design_patterns.b_structural.adapter.example02.a.MediaPlayer;
import design_patterns.b_structural.adapter.example02.b.Mp4Player;
import design_patterns.b_structural.adapter.example02.b.VlcPlayer;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();

        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}