package physics.com.physics.model;

import java.io.Serializable;

/**
 * Created by bruno on 23/09/15.
 */
public class Content implements Serializable {

    private Long id;
    private Module module;
    private String description;
    private String text;

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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
