package physics.com.physics.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruno on 28/10/15.
 */
public class YouTubeContent {
    /**
     * An array of YouTube videos
     */
    public static List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    public static Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();


    static {
        addItem(new YouTubeVideo("C18qzn7j4SM", "Um curso de git fera!"));
        addItem(new YouTubeVideo("_Mir2_YlA0g", "Parte 2 do curso de git fera!"));
        addItem(new YouTubeVideo("twNbUHFlwfE", "Parte 3 do curso de git fera!"));
    }


    private static void addItem(final YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A POJO representing a YouTube video
     */
    public static class YouTubeVideo {
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
}
