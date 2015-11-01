package physics.com.physics.model;

/**
 * Created by bruno on 31/10/15.
 * POJO that's represents a YouTube Video
 */
public class YouTubeVideo {

    public String id;
    public String title;


    public YouTubeVideo(String id, String content) {
        this.id = id;
        this.title = content;
    }


    @Override
    public String toString() {
        return title;
    }
}
