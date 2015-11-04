package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import physics.com.physics.R;
import physics.com.physics.helper.InterferenceHelper;

/**
 * Created by bruno on 04/11/15.
 */
public class InterferenceMaterialFragment extends Fragment {

    private View view;
    private InterferenceHelper helper;

    public InterferenceMaterialFragment() {
        //Empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.interference_material_layout, container, false);

        helper = new InterferenceHelper(view);
        helper.initializeUIElements();

        return view;
    }
}
