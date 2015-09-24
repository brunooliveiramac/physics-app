package physics.com.physics.model;
import java.io.Serializable;

/**
 * Created by bruno on 30/08/15.
 */

public class Text implements Serializable {

    private Long id;
    private String title;
    private Text content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }
}
