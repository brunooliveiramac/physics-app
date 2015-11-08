package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.Video;
import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 31/10/15.
 * Contract for YouTubeContent implementation classes
 */
public interface YouTubeContent {
    List<Video> content = new ArrayList<>();
    List<YouTubeVideo> ITEMS = new ArrayList<>();
    Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();


    void addItem(final YouTubeVideo item);

    List<YouTubeVideo> getITEMS();

    void setContent(List<Video> content);

}
