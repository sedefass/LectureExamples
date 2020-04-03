package design_patterns.b_structural.proxy;

public class Main {
    public static void main(String[] args) {
        MediaFile mediaFile = new ProxyMediaFile("movie.mp4");

        mediaFile.openFile();
        mediaFile.openFile();
    }
}