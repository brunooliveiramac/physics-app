package physics.com.physics.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import physics.com.physics.adapters.VideoListAdapter;
import physics.com.physics.content.YouTubeContent;

/**
 * Created by bruno on 28/10/15.
 */
public class VideoListFragment extends ListFragment {

    public VideoListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new VideoListAdapter(getActivity()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final Context context = getActivity();
        final String DEV_KEY = "AIzaSyCxiUa4wRlUwaJ_x20EsLvUrPq0HFz0ego";
        final YouTubeContent.YouTubeVideo video = YouTubeContent.ITEMS.get(position);

//        if(YouTubeIntents.canResolvePlayVideoIntent(getActivity())) {
//            startActivity(YouTubeIntents.createPlayVideoIntent(context, video.id));
            startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                    DEV_KEY, video.id, 0, true, true));

//        }
    }
}
