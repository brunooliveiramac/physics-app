package physics.com.physics.fragments;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by bruno on 28/10/15.
 */
public class YoutubePlayerFragment extends YouTubePlayerSupportFragment {
    private String VIDEO_ID = "fI757OOTZfM";
    private YouTubePlayer activePlayer;
    private static final String API_KEY = "AIzaSyCxiUa4wRlUwaJ_x20EsLvUrPq0HFz0ego";


    public static YoutubePlayerFragment newInstance(String url) {

        YoutubePlayerFragment youtubePlayerFragment = new YoutubePlayerFragment();

        Bundle bundle = new Bundle();
        bundle.putString("url", url);

        youtubePlayerFragment.setArguments(bundle);

        return youtubePlayerFragment;
    }

    private void init() {
        initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                activePlayer = player;
                activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                if (!wasRestored)
                    activePlayer.loadVideo(getArguments().get("url").toString(), 0);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {

            }
        });
    }
}
