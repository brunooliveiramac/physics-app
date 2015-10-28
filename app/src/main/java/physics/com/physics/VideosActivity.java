package physics.com.physics;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import physics.com.physics.fragments.YoutubePlayerFragment;

/**
 * Created by bruno on 28/10/15.
 */
public class VideosActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyCxiUa4wRlUwaJ_x20EsLvUrPq0HFz0ego";
    private String LINK = "vzHrjOMfHPY";
    private YouTubePlayerView videoPlayer;
    private YouTubePlayerFragment ytFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_layout);
        videoPlayer = (YouTubePlayerView) findViewById(R.id.youtube);
        videoPlayer.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean loadAgain) {
        if(!loadAgain)
            youTubePlayer.cueVideo(LINK);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
        Log.e("YT_API_ERROR: ", "exception: " + error);
    }
}
