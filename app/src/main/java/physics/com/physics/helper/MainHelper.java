package physics.com.physics.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import physics.com.physics.CreditsActivity;
import physics.com.physics.RefractionActivity;
import physics.com.physics.MaterialActivity;
import physics.com.physics.R;
import physics.com.physics.YoutubeActivity;
import physics.com.physics.util.ConnectionDetector;

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

        txtCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCreditsSection();
            }
        });

        txtMaterial = (TextView) activity.findViewById(R.id.material);
        txtMaterial.setClickable(true);

        txtMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!new ConnectionDetector(activity).isConnected()){
                    Toast.makeText(activity, "Você precisa estar conectado a internet para acessar o conteúdo",
                            Toast.LENGTH_LONG).show();
                } else {
                    callMaterialSection();
                }
            }
        });
    }

    private void callCreditsSection() {
        Intent goToCredits = new Intent(activity, CreditsActivity.class);
        activity.startActivity(goToCredits);
    }

    private void callMaterialSection() {
        Intent goToMaterial = new Intent(activity, MaterialActivity.class);
        activity.startActivity(goToMaterial);
    }
}
