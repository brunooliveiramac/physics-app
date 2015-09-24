package physics.com.physics.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URL;

import physics.com.physics.helper.ResourceHelper;

/**
 * Created by bruno on 23/09/15.
 */
public class ResourceImageTask extends AsyncTask<Object, Object, Boolean> {

    private ResourceHelper helper = new ResourceHelper();
    private ImageView view;
    private String uri;

    public ResourceImageTask(ImageView view, String uri) {
        this.view = view;
        this.uri = uri;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        if(uri != null || !uri.isEmpty()) {
            helper.getResourceAsImage(uri);
            return true;
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        helper.setImageOnUI(view);
    }
}
