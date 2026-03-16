import java.util.*;

class Video {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

interface Playlist {
    PlayListIterator createIterator();
}

class YouTubePlaylist implements Playlist {
    private List<Video> videos;

    public YouTubePlaylist() {
        videos = new ArrayList<>();
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    @Override
    public PlayListIterator createIterator() {
        return new YouTubePlaylistIterator(videos);
    }
}

interface PlayListIterator {
    boolean hasNext();
    Video next();
}

class YouTubePlaylistIterator implements PlayListIterator {
    private List<Video> videos;
    private int position;

    public YouTubePlaylistIterator(List<Video> videos) {
        this.videos = videos;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    @Override
    public Video next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return videos.get(position++);
    }
}


public class YouTubePlayListExample {
    public static void main(String[] args) {

        YouTubePlaylist playlist = new YouTubePlaylist();

        playlist.addVideo(new Video("Video 1"));
        playlist.addVideo(new Video("Video 2"));
        playlist.addVideo(new Video("Video 3"));

        PlayListIterator iterator = playlist.createIterator();

        while (iterator.hasNext()) {
            Video video = iterator.next();
            System.out.println(video.getTitle());
        }
    }
}

//create documentation for the above code
/**
 * This code demonstrates the Iterator Design Pattern using a YouTube playlist example.
 * 
 * The main components of the code are:
 * 
 * 1. Video Class: Represents a video with a title.
 * 2. Playlist Interface: Defines a method to create an iterator for the playlist.
 * 3. YouTubePlaylist Class: Implements the Playlist interface and manages a list of videos.
 * 4. PlayListIterator Interface: Defines methods for iterating through the playlist.
 * 5. YouTubePlaylistIterator Class: Implements the PlayListIterator interface to iterate through the videos in the playlist.
 * 6. YouTubePlayListExample Class: Contains the main method to demonstrate the functionality of the playlist and iterator.
 * 
 * The YouTubePlaylist class allows adding videos to the playlist and creating an iterator to traverse through the videos. The YouTubePlaylistIterator class provides the implementation for iterating through the list of videos, allowing clients to access each video without exposing the underlying structure of the playlist.
 */





//create UML diagram for the above code
/*
 * YouTubePlaylistExample UML Diagram
 * 
 * +---------------------+
 * |     Video           |
 * +---------------------+
 * | - title: String     |
 * +---------------------+
 * | + getTitle(): String|
 * +---------------------+
 * 
 * +---------------------+
 * |    Playlist         |
 * +---------------------+
 * | + createIterator(): PlayListIterator |
 * +---------------------+
 * 
 * +--------------------------+
 * |  YouTubePlaylist         |
 * +--------------------------+
 * | - videos: List<Video>   |
 * +--------------------------+
 * | + addVideo(video: Video)|
 * | + createIterator(): PlayListIterator |
 * +--------------------------+
 * 
 * +--------------------+
 * | PlayListIterator   |
 * +--------------------+
 * | + hasNext(): boolean|
 * | + next(): Video     |
 * +--------------------+
 * 
 * +-------------------------------+
 * | YouTubePlaylistIterator       |
 * +-------------------------------+
 * | - videos: List<Video>        |
 * | - position: int               |
 * +-------------------------------+
 * | + constructor(videos: List<Video>)|
 * | + hasNext(): boolean           |
 * | + next(): Video                |
 * +-------------------------------+
 */