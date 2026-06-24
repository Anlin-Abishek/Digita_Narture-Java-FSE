
interface Video {
    void play();
}

class RealVideo implements Video {
    private String filename;

    public RealVideo(String filename) {
        this.filename = filename;
        loadFromDisk(); 
    }

    private void loadFromDisk() {
        System.out.println("⏳ Loading heavy video file '" + filename + "' from disk... (Takes 3 seconds)");
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public void play() {
        System.out.println("▶️ Playing video: " + filename);
    }
}
class VideoProxy implements Video {
    private RealVideo realVideo;
    private String filename;

    public VideoProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(filename);
        }
        realVideo.play();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Setting up Video Playlist ---");
        Video video1 = new VideoProxy("tutorial_class_1.mp4");
        Video video2 = new VideoProxy("interview_prep.mp4");
        System.out.println("Playlist created successfully. No heavy files loaded yet.\n");

        System.out.println("--- User clicks 'Play' on Video 1 ---");
        video1.play();        
        System.out.println("\n--- User clicks 'Play' on Video 1 again ---");
        video1.play(); 
        System.out.println("\n--- Application Closing ---");
    }
}
