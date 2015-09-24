package physics.com.physics.model;

import java.io.Serializable;

/**
 * Created by bruno on 23/09/15.
 */
public class Module implements Serializable {

    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
