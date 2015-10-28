package physics.com.physics.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import physics.com.physics.MaterialActivity;
import physics.com.physics.R;

/**
 * Created by bruno on 28/08/15.
 */
public class MainHelper {

    private Activity activity;
    private TextView txtCredits;
    private TextView txtMaterial;


    public MainHelper(Activity activity) {
        this.activity = activity;
    }

    public void initializeElements() {
        txtCredits = (TextView) activity.findViewById(R.id.credits);
        txtCredits.setClickable(true);
        txtMaterial = (TextView) activity.findViewById(R.id.material);
        txtMaterial.setClickable(true);

        txtMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMaterialSection();
            }
        });
    }

    public void callCreditsSection() {
        //TODO implement credits intent
    }

    public void callMaterialSection() {
        Intent goToMaterial = new Intent(activity, MaterialActivity.class);
        activity.startActivity(goToMaterial);
    }
}
