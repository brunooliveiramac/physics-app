package physics.com.physics.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import physics.com.physics.model.Image;
import physics.com.physics.model.Images;

/**
 * Created by bruno on 23/09/15.
 */
public class ResourceListTask extends AsyncTask<Object, Object, byte[]> {

    private Activity activity;

    private List<byte[]> imagesList;

    public ResourceListTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected byte[] doInBackground(Object... params) {
        final String url = "http://192.168.1.35:8080/physics-api/content/1/images";
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

//            Image[] images = restTemplate.getForObject(url, Image[].class);
//            Images images = restTemplate.getForObject(url, Images.class);
//            imagesList = Arrays.asList(images);
              byte[] images = restTemplate.getForObject(url, byte[].class);
              imagesList = Arrays.asList(images);
            return images;
        } catch (Exception e) {
            Log.e("ResourceTaskList", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(byte[] images) {
        super.onPostExecute(images);
        Log.d("API_SERVICE_WARNING", "LIST=>" + images);
    }
}
