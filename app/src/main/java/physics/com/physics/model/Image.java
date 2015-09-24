package physics.com.physics.model;

import java.io.Serializable;

/**
 * Created by bruno on 23/09/15.
 */
public class Image implements Serializable {

    private Long id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + description;
    }
}
