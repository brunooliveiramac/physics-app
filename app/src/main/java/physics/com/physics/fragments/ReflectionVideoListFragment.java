package physics.com.physics.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import physics.com.physics.R;
import physics.com.physics.adapters.VideoListAdapter;
import physics.com.physics.content.ReflectionYouTubeContent;
import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionVideoListFragment extends ListFragment {
    
    public ReflectionVideoListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new VideoListAdapter(getActivity(), new ReflectionYouTubeContent()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final Context context = getActivity();
//        final String DEV_KEY = "AIzaSyCxiUa4wRlUwaJ_x20EsLvUrPq0HFz0ego";
        final String DEV_KEY = getResources().getString(R.string.DEVELOPER_KEY);
//        final YouTubeVideo video = ReflectionYouTubeContent.ITEMS.get(position);

        final YouTubeVideo video = new ReflectionYouTubeContent().getITEMS().get(position);
        startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                DEV_KEY, video.id, 0, true, true));

    }
}
