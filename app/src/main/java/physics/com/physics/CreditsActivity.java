package physics.com.physics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by bruno on 04/11/15.
 */
public class CreditsActivity extends AppCompatActivity {

    private ImageButton btnTeam;
    private ImageButton btnReferences;
    private ImageButton btnRecommended;
    private ImageButton btnBibliography;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_layout);
        this.initializeUIElements();

        btnTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = createTeamDialog();
                alert.show();
            }
        });

        btnReferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Referencias foi clickado!", Toast.LENGTH_SHORT).show();
            }
        });

        btnRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Recomendados foi clickado!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBibliography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bibliografia foi clickado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initializeUIElements() {
        btnTeam = (ImageButton) findViewById(R.id.credits_team_btn);
        btnReferences = (ImageButton) findViewById(R.id.credits_references_btn);
        btnRecommended = (ImageButton) findViewById(R.id.credits_recommended_btn);
        btnBibliography = (ImageButton) findViewById(R.id.credits_bibliography_btn);
    }

    public AlertDialog.Builder createTeamDialog() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreditsActivity.this);
        alertDialog.setTitle("Participantes");
        alertDialog.setMessage(getString(R.string.credits_team));

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialog;
    }
}
