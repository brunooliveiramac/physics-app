package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.Video;
import physics.com.physics.model.YouTubeVideo;
import physics.com.physics.task.ResourceVideoTask;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionYouTubeContent implements YouTubeContent {

    private static final int CONTENT_CODE = 3;
    private List<Video> content = new ArrayList<>();

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();

    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public DiffractionYouTubeContent() {
        this.fillVideoList();
    }

    private void fillVideoList() {
        try {
            content = new ResourceVideoTask().execute(CONTENT_CODE).get();
            for (Video v : content) {
                addItem(new YouTubeVideo(v.getUri(), v.getTitle()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addItem(YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    @Override
    public List<YouTubeVideo> getITEMS() {
        return ITEMS;
    }

    @Override
    public void setContent(List<Video> content) {

    }
}
