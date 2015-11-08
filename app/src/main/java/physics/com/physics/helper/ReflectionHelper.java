package physics.com.physics.helper;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import physics.com.physics.R;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionHelper {

    private View view;

    public ReflectionHelper(View view) {
        this.view = view;
    }

    public void initializeUIElements() {
        final RelativeLayout container = (RelativeLayout) view.findViewById(R.id.reflection_material_relative);

        for (int i = 0; i < 4; i ++) {
            TextView text = new TextView(view.getContext());
            text.setId(i);
            text.setText("Text number " + i);
            container.addView(text);
        }
    }
}
