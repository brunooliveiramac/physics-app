package physics.com.physics;

import android.app.Activity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.helper.RefractionHelper;

/**
 * Created by bruno on 28/08/15.
 */
public class RefractionActivity extends Activity {

    private RefractionHelper helper = new RefractionHelper(RefractionActivity.this);
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_info_layout);
        helper.initializeElements();

        gifImageView = (GifImageView) findViewById(R.id.gifImageView);

        new GifDataDownloader() {
            @Override
            protected void onPostExecute(final byte[] bytes) {
                gifImageView.setBytes(bytes);
                gifImageView.startAnimation();
            }
        }.execute("http://192.168.1.32:8080/physics-api/animations/1/1");



    }





}
