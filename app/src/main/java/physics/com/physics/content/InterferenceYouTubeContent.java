package physics.com.physics.content;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import physics.com.physics.fragments.InterferenceVideoListFragment;
import physics.com.physics.fragments.InterferenceVideosFragment;
import physics.com.physics.model.Video;
import physics.com.physics.model.YouTubeVideo;
import physics.com.physics.task.ResourceVideoTask;
import physics.com.physics.util.ContentChangeListener;

/**
 * Created by bruno on 04/11/15.
 */
public class InterferenceYouTubeContent implements YouTubeContent {

    private List<Video> content = new ArrayList<>();
    private static final int CONTENT_CODE = 1;
    private Context mContext;

    /**
     * An array of YouTube videos
     */
    private List<YouTubeVideo> ITEMS = new ArrayList<>();


    /**
     * A map of YouTube videos, by ID.
     */
    private Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    public InterferenceYouTubeContent() {
        this.fillVideoList();

    }

    private void fillVideoList() {
        try {
            content = new ResourceVideoTask().execute(CONTENT_CODE).get();
//            new ResourceVideoTask(this).execute(CONTENT_CODE);
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

    public void setContent(List<Video> content) {
        this.content = content;
    }

//    @Override
//    public void onContentCompleted(List<Video> result) {
//        Log.d("AQUIIIIIIIIIII", "" + result.size());
//        this.content = result;
//    }

//    @Override
//    public void onContentErrors(String error) {
//
//    }
}
