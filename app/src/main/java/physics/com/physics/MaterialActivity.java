package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;

import physics.com.physics.helper.MaterialHelper;

/**
 * Created by bruno on 28/08/15.
 */
public class MaterialActivity extends Activity {

    private MaterialHelper helper = new MaterialHelper(MaterialActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_layout);
        helper.initializeElements();
    }
}
