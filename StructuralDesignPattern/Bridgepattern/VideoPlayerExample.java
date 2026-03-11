interface videoQuality {
    void load(String title);
}

class SDQuality implements videoQuality {
    @Override
    public void load(String title) {
        System.out.println("Loading " + title + " in SD quality.");
    }
}

class HDQuality implements videoQuality {
    @Override
    public void load(String title) {
        System.out.println("Loading " + title + " in HD quality.");
    }
}

class   FourKQuality implements videoQuality {
    @Override
    public void load(String title) {
        System.out.println("Loading " + title + " in 4K quality.");
    }
}


abstract class VideoPlayer {
    protected videoQuality quality;

    public VideoPlayer(videoQuality quality) {
        this.quality = quality;
    }

    public abstract void play(String title);
}

class MoviePlayer extends VideoPlayer {
    public MoviePlayer(videoQuality quality) {
        super(quality);
    }

    @Override
    public void play(String title) {
        quality.load(title);
        System.out.println("Playing movie: " + title);
    }
}

class TVShowPlayer extends VideoPlayer {
    public TVShowPlayer(videoQuality quality) {
        super(quality);
    }

    @Override
    public void play(String title) {
        quality.load(title);
        System.out.println("Playing TV show: " + title);
    }
}


public class VideoPlayerExample{
    public static void main(String[] args) {

        videoQuality sdQuality = new SDQuality();
        videoQuality hdQuality = new HDQuality();
        videoQuality fourKQuality = new FourKQuality();

        VideoPlayer moviePlayerSD = new MoviePlayer(sdQuality);
        VideoPlayer moviePlayerHD = new MoviePlayer(hdQuality);
        VideoPlayer moviePlayer4K = new MoviePlayer(fourKQuality);

        VideoPlayer tvShowPlayerSD = new TVShowPlayer(sdQuality);
        VideoPlayer tvShowPlayerHD = new TVShowPlayer(hdQuality);
        VideoPlayer tvShowPlayer4K = new TVShowPlayer(fourKQuality);

        moviePlayerSD.play("Inception");
        moviePlayerHD.play("Inception");
        moviePlayer4K.play("Inception");

        tvShowPlayerSD.play("Breaking Bad");
        tvShowPlayerHD.play("Breaking Bad");
        tvShowPlayer4K.play("Breaking Bad");
    }
}


// Documentation for the above code
/**
 * This code demonstrates the Bridge Design Pattern in the context of a video player application.
 * 
 * The `videoQuality` interface defines a common method for loading videos in different qualities (SD, HD, 4K).
 * The `VideoPlayer` abstract class represents the abstraction that can play videos, and it holds a reference to a `videoQuality` implementation.
 * The `MoviePlayer` and `TVShowPlayer` classes are concrete implementations of the `VideoPlayer` abstraction, allowing them to play movies and TV shows respectively.
 * 
 * In the `main` method, we create instances of different video qualities and use them to play both movies and TV shows, demonstrating the decoupling of abstraction and implementation.
 */