package physics.com.physics.helper;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import physics.com.physics.R;
import physics.com.physics.task.ResourceImageTask;
import physics.com.physics.task.ResourceListTask;

/**
 * Created by bruno on 22/09/15.
 */
public class RefractionHelper {

    private Activity activity;
    private ResourceHelper resourceHelper;
    private ImageView imageTest;
    private ImageView imageTest2;
    private ImageView imageTest3;
    private TextView bodyText1;

    public RefractionHelper(Activity activity) {
        this.activity = activity;
        resourceHelper = new ResourceHelper();
    }

    public void initializeElements() {
        imageTest = (ImageView) activity.findViewById(R.id.image_test);
        imageTest2 = (ImageView) activity.findViewById(R.id.image_test2);
        imageTest3 = (ImageView) activity.findViewById(R.id.image_test3);
        bodyText1 = (TextView) activity.findViewById(R.id.text_content);
        bodyText1.setText(R.string.teste2);

        new ResourceImageTask(imageTest, "http://192.168.0.108:8080/physics-api/content/1/image/1")
                .execute();
        new ResourceImageTask(imageTest2, "http://192.168.0.108:8080/physics-api/content/1/image/2")
                .execute();
//        new ResourceImageTask(imageTest3, "http://192.168.0.108:8080/physics-api/content/1/image/10")
//                .execute();

    }
}
