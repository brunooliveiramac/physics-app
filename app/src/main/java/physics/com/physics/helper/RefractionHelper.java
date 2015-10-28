package physics.com.physics.helper;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.R;
import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 22/09/15.
 */
public class RefractionHelper {

    private Activity activity;
    private ResourceHelper resourceHelper;
    private ImageView imageTest;
    private GifImageView gifTest;
    private ImageView imageTest2;
    private ImageView imageTest3;
    private TextView bodyText1;

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public RefractionHelper(Activity activity) {
        this.activity = activity;
        resourceHelper = new ResourceHelper();
    }

    public void initializeElements() {

        imageTest = (ImageView) activity.findViewById(R.id.image_test);
        imageTest2 = (ImageView) activity.findViewById(R.id.image_test2);
        imageTest3 = (ImageView) activity.findViewById(R.id.image_test3);
        gifTest = (GifImageView) activity.findViewById(R.id.gifImageView);
        bodyText1 = (TextView) activity.findViewById(R.id.text_content);
        bodyText1.setText(R.string.teste2);

        new ResourceImageTask(imageTest, BASE_URL + "/2/image/1")
                .execute();

        new GifDataDownloader(gifTest)
                .execute(BASE_URL + "/2/animation/1");
    }
}
