package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;

import physics.com.physics.helper.RefractionHelper;
import physics.com.physics.task.ResourceListTask;

/**
 * Created by bruno on 28/08/15.
 */
public class RefractionActivity extends Activity {

    private RefractionHelper helper = new RefractionHelper(RefractionActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_info_layout);
        helper.initializeElements();

    }

    @Override
    protected void onStart() {
        super.onStart();
        new ResourceListTask(this).execute();
    }
}
