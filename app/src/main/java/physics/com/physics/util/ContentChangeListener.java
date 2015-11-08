package physics.com.physics.util;

import java.util.List;

import physics.com.physics.model.Video;

/**
 * Created by bruno on 07/11/15.
 */
public interface ContentChangeListener {

    void onContentCompleted(List<Video> result);
    void onContentErrors(String error);
}
