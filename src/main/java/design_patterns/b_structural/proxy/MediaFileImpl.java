package design_patterns.b_structural.proxy;

public class MediaFileImpl implements MediaFile {
    private String fileName;

    public MediaFileImpl(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void openFile() {
        System.out.println("Opening " + fileName);
    }

    public void downloadFile(String fileName){
        System.out.println("Downloading " + fileName);
    }
}