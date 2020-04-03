package design_patterns.b_structural.proxy;

public class ProxyMediaFile implements MediaFile {

    private MediaFileImpl mediaFileImpl;
    private String fileName;

    public ProxyMediaFile(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void openFile() {
        if(mediaFileImpl == null){
            mediaFileImpl = new MediaFileImpl(fileName);
            mediaFileImpl.downloadFile(fileName);
        }
        mediaFileImpl.openFile();
    }
}