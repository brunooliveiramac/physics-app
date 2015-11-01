package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionYouTubeContent implements YouTubeContent {


    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public ReflectionYouTubeContent() {
        addItem(new YouTubeVideo("fj_LaS2JWUk", "Vídeo 1 - teste teste teste"));
        addItem(new YouTubeVideo("YhgkqnhicKk", "Vídeo 2 - teste teste teste"));
    }

    public void addItem(final YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public List<YouTubeVideo> getITEMS() {
        return ITEMS;
    }

    // OLD
//    /**
//     * An array of YouTube videos
//     */
//    public static List<YouTubeVideo> ITEMS = new ArrayList<>();
//
//
//    /**
//     * A map of YouTube videos, by ID.
//     */
//    public static Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();
//
//
//    static {
//        addItem(new YouTubeVideo("fj_LaS2JWUk", "Vídeo 1 - teste teste teste"));
//        addItem(new YouTubeVideo("YhgkqnhicKk", "Vídeo 2 - teste teste teste"));
//    }
//
//
//    private static void addItem(final YouTubeVideo item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }

}
