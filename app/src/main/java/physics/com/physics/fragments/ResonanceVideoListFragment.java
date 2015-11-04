package physics.com.physics.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import physics.com.physics.R;
import physics.com.physics.adapters.VideoListAdapter;
import physics.com.physics.content.ResonanceYouTubeContent;
import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 04/11/15.
 */
public class ResonanceVideoListFragment extends ListFragment {

    public ResonanceVideoListFragment() {
        //Empty constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new VideoListAdapter(getActivity(), new ResonanceYouTubeContent()));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final Context context = getActivity();
        final String DEV_KEY = getResources().getString(R.string.DEVELOPER_KEY);
        final YouTubeVideo video = new ResonanceYouTubeContent().getITEMS().get(position);

        startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                DEV_KEY, video.id, 0, true, true));
    }
}
