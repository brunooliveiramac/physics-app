package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import physics.com.physics.model.Video;
import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 28/10/15.
 */
public class RefractionYouTubeContent implements YouTubeContent {

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public RefractionYouTubeContent() {
        addItem(new YouTubeVideo("C18qzn7j4SM", "Um curso de git fera!"));
        addItem(new YouTubeVideo("_Mir2_YlA0g", "Parte 2 do curso de git fera!"));
        addItem(new YouTubeVideo("twNbUHFlwfE", "Parte 3 do curso de git fera!"));
    }

    public void addItem(final YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public List<YouTubeVideo> getITEMS() {
        return ITEMS;
    }

    @Override
    public void setContent(List<Video> content) {

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
//        addItem(new YouTubeVideo("C18qzn7j4SM", "Um curso de git fera!"));
//        addItem(new YouTubeVideo("_Mir2_YlA0g", "Parte 2 do curso de git fera!"));
//        addItem(new YouTubeVideo("twNbUHFlwfE", "Parte 3 do curso de git fera!"));
//    }
//
//
//    private static void addItem(final YouTubeVideo item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }
}
