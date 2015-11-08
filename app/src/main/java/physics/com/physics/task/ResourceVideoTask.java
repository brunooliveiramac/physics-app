package physics.com.physics.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import physics.com.physics.config.AppConfig;
import physics.com.physics.content.InterferenceYouTubeContent;
import physics.com.physics.content.YouTubeContent;
import physics.com.physics.model.Video;
import physics.com.physics.model.VideoResponse;
import physics.com.physics.util.ContentChangeListener;

/**
 * Created by bruno on 06/11/15.
 */
public class ResourceVideoTask extends AsyncTask <Integer, Void, List<Video>> {

    private List<Video> result;
//    private final ContentChangeListener mListener;

//    public ResourceVideoTask(ContentChangeListener listener){
//        this.mListener = listener;
//    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Video> doInBackground(Integer... params) {

        try {
            int contentId = params[0];
            final String uri = AppConfig.LOCAL_URI + "/videos/" + contentId;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            result = restTemplate.getForObject(uri, VideoResponse.class).getVideos();

            return result;
        } catch (Exception e) {
            Log.e("[ERROR] => ", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Video> videos) {
//        if(mListener != null) {
//            mListener.onContentCompleted(videos);
//        }

    }
}
