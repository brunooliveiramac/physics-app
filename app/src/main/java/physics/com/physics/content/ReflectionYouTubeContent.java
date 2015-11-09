package physics.com.physics.content;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.Video;
import physics.com.physics.model.YouTubeVideo;
import physics.com.physics.task.ResourceVideoTask;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionYouTubeContent implements YouTubeContent {

    private static final int CONTENT_CODE = 1;
    private List<Video> content = new ArrayList<>();

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public ReflectionYouTubeContent() {
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

    public void addItem(final YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public List<YouTubeVideo> getITEMS() {
        return ITEMS;
    }

    public List<Video> getContent() {
        return content;
    }

    @Override
    public void setContent(List<Video> content) {

    }
}
