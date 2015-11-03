package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionYouTubeContent implements YouTubeContent {

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();

    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public DiffractionYouTubeContent() {
        addItem(new YouTubeVideo("gLI_jopCS3Y", "Thiengo babando..."));
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
