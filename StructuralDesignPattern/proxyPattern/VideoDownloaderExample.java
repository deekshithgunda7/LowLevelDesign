import java.util.HashMap;
import java.util.Map;

interface videoDownloader {
    void downloadVideo(String videoUrl);
}

class RealVideoDownloader implements videoDownloader {
    @Override
    public void downloadVideo(String videoUrl) {
        System.out.println("Downloading video from: " + videoUrl);
    }
}

// Proxy class that controls access to the real video downloader by using caching mechanism to avoid redundant downloads use hashmap for caching
class VideoDownloaderProxy implements videoDownloader {
    private RealVideoDownloader realVideoDownloader;
    private Map<String, String> videoCache;

    public VideoDownloaderProxy() {
        this.realVideoDownloader = new RealVideoDownloader();
        this.videoCache = new HashMap<>();
    }

    @Override
    public void downloadVideo(String videoUrl) {
        if (videoCache.containsKey(videoUrl)) {
            System.out.println("Video already downloaded. Fetching from cache: " + videoUrl);
        } else {
            realVideoDownloader.downloadVideo(videoUrl);
            videoCache.put(videoUrl, "Downloaded");
        }
    }
}

public class VideoDownloaderExample {
    public static void main(String[] args) {
        videoDownloader downloader = new VideoDownloaderProxy();

        // First download - will download the video
        downloader.downloadVideo("http://example.com/video1.mp4");

        // Second download - will fetch from cache
        downloader.downloadVideo("http://example.com/video1.mp4");

        // Downloading another video
        downloader.downloadVideo("http://example.com/video2.mp4");
    }
}

// documentation for the above code
/**
 * This code demonstrates the Proxy Design Pattern in the context of a video downloading system.
 * 
 * The `videoDownloader` interface defines a method for downloading videos. 
 * The `RealVideoDownloader` class implements this interface to provide the actual functionality of downloading videos.
 * The `VideoDownloaderProxy` class acts as a proxy to control access to the real video downloader. It uses a caching mechanism (a HashMap) to store previously downloaded videos and avoid redundant downloads.
 * 
 * In the `main` method, we create an instance of `VideoDownloaderProxy` and attempt to download the same video twice. The first time, it will download the video, and the second time, it will fetch it from the cache, demonstrating the proxy's functionality.
 */
