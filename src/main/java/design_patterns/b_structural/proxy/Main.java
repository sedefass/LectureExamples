package design_patterns.b_structural.proxy;

import design_patterns.b_structural.proxy.a.MediaFile;
import design_patterns.b_structural.proxy.c.ProxyMediaFile;

public class Main {
    public static void main(String[] args) {
        MediaFile mediaFile = new ProxyMediaFile("movie.mp4");

        mediaFile.openFile();

        System.out.println();

        mediaFile.openFile();
    }
}