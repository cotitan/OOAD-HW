package datamodel;

/**
 * Created by tiankk on 16-7-31.
 */
public class ServerMsg {
    private boolean status;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
