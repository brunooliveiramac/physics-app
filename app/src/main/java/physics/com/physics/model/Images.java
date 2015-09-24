package physics.com.physics.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bruno on 23/09/15.
 */
public class Images implements Serializable {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return images.toString();
    }
}
