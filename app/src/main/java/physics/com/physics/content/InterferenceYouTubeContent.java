package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 04/11/15.
 */
public class InterferenceYouTubeContent implements YouTubeContent {

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public InterferenceYouTubeContent() {
        addItem(new YouTubeVideo("AltMeuPkWRs", "Vídeo 1 - teste interferencia"));
        addItem(new YouTubeVideo("Ji9NPW3mi8o", "Vídeo 2 - teste interferencia 2"));
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
}
