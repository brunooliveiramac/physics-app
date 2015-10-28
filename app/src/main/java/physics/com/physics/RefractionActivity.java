package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import physics.com.physics.fragments.YoutubePlayerFragment;
import physics.com.physics.helper.RefractionHelper;


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

//        YoutubePlayerFragment ytFragment = YoutubePlayerFragment.newInstance("fI757OOTZfM");
//        this.getSupportFragmentManager().beginTransaction().replace(R.id.youtube_frame, ytFragment).commit();

    }
}
