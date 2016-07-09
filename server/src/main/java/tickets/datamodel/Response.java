package tickets.datamodel;
//package tickets;

public class Response {
    
    private boolean status;
    private String message;

    public Response() {
	status = false;
    }

    public boolean getStatus() {
	return status;
    }

    public String getMessage() {
	return message;
    }

    public void setStatus(boolean status) {
	this.status = status;
    }

    public void setMessage(String msg) {
	this.message = msg;
    }
}


