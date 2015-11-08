package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import physics.com.physics.R;
import physics.com.physics.model.Video;
import physics.com.physics.task.ResourceVideoTask;

/**
 * Created by bruno on 04/11/15.
 */
public class InterferenceVideosFragment extends Fragment {

    private View view;

    public InterferenceVideosFragment() {
        //Empty
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.interference_youtube_layout, container, false);

        //Check for any issues
        final YouTubeInitializationResult result = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getActivity());

        if (result != YouTubeInitializationResult.SUCCESS) {
            //If there are any issues we can show an error dialog.
            result.getErrorDialog(getActivity(), 0).show();
        }

        return view;
    }
}
