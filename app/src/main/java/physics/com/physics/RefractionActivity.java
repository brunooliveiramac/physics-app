package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.helper.RefractionHelper;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 28/08/15.
 */
public class RefractionActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private RefractionHelper helper = new RefractionHelper(RefractionActivity.this);
    private GifImageView gifImageView;
    private static final String API_KEY = "AIzaSyBzS0JjBMoj5lAyXqQ1KRkwsKWtN5gJKts";
    private String LINK = "vzHrjOMfHPY";
    private YouTubePlayerView youtube;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_info_layout);
        helper.initializeElements();

        youtube = (YouTubePlayerView) findViewById(R.id.player_youtube);
        youtube.initialize(API_KEY, this);

//        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
//
//        new GifDataDownloader() {
//            @Override
//            protected void onPostExecute(final byte[] bytes) {
//                gifImageView.setBytes(bytes);
//                gifImageView.startAnimation();
//            }
//        }.execute(BASE_URI + "/2/animation/1");

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean loagAgain) {

                if(!loagAgain){
                    player.cueVideo(LINK);
                }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        //ERRO
    }
}
