package physics.com.physics.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import physics.com.physics.DiffractionActivity;
import physics.com.physics.InterferenceActivity;
import physics.com.physics.ReflectionActivity;
import physics.com.physics.RefractionActivity;
import physics.com.physics.R;
import physics.com.physics.ResonanceActivity;

/**
 * Created by bruno on 28/08/15.
 */
public class MaterialHelper {

    private Activity activity;
    private LinearLayout clickableAreaReflection;
    private LinearLayout clickableAreaRefraction;
    private LinearLayout clickableAreaDiffraction;
    private LinearLayout clickableAreaResonance;
    private LinearLayout clickableAreaInterference;
    private ProgressBar progressBar;
    private TextView loadingText;

    public MaterialHelper(Activity activity) {
        this.activity = activity;
    }

    public void initializeElements() {
        loadingText = (TextView) activity.findViewById(R.id.material_loading_label);
        progressBar = (ProgressBar) activity.findViewById(R.id.material_progress);
        clickableAreaReflection = (LinearLayout) activity.findViewById(R.id.clickable_area);
        clickableAreaRefraction = (LinearLayout) activity.findViewById(R.id.clickable_area2);
        clickableAreaDiffraction = (LinearLayout) activity.findViewById(R.id.clickable_area3);
        clickableAreaResonance = (LinearLayout) activity.findViewById(R.id.clickable_area4);
        clickableAreaInterference = (LinearLayout) activity.findViewById(R.id.clickable_area5);
        clickableAreaReflection.setClickable(true);
        clickableAreaRefraction.setClickable(true);
        clickableAreaDiffraction.setClickable(true);
        clickableAreaResonance.setClickable(true);
        clickableAreaInterference.setClickable(true);

        clickableAreaReflection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIntent(activity, ReflectionActivity.class);
            }
        });

        clickableAreaRefraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIntent(activity, RefractionActivity.class);

            }
        });

        clickableAreaDiffraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIntent(activity, DiffractionActivity.class);
            }
        });

        clickableAreaResonance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIntent(activity, ResonanceActivity.class);
            }
        });

        clickableAreaInterference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                loadingText.setVisibility(View.VISIBLE);
                callIntent(activity, InterferenceActivity.class);
            }
        });
    }

    //Global method to call intents
    private void callIntent(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

}
