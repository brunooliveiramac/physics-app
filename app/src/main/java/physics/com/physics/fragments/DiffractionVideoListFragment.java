package physics.com.physics.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import physics.com.physics.R;
import physics.com.physics.adapters.VideoListAdapter;
import physics.com.physics.content.DiffractionYouTubeContent;
import physics.com.physics.content.RefractionYouTubeContent;
import physics.com.physics.model.YouTubeVideo;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionVideoListFragment extends ListFragment {

    public DiffractionVideoListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new VideoListAdapter(getActivity(), new DiffractionYouTubeContent()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        final Context context = getActivity();
        final String DEV_KEY = getResources().getString(R.string.DEVELOPER_KEY);
        final YouTubeVideo video = new RefractionYouTubeContent().getITEMS().get(position);

        startActivity(YouTubeStandalonePlayer.createVideoIntent(getActivity(),
                DEV_KEY, video.id, 0, true, true));

    }
}
