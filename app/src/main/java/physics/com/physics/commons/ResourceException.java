package physics.com.physics.commons;

/**
 * Created by bruno on 02/11/15.
 */
public class ResourceException extends RuntimeException {

    private String msg;

    public ResourceException() {
        super("An server communication failure has occured! please check if server is up an running.");
    }

    public ResourceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
