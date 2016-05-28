import sun.misc.BASE64Decoder;
import java.util.ArrayList;
import src.main.java.tickets.DataModel.Movie;

// import com.google.gson.Gson;

public class TestMovie {
    public static void main(String[] args) {
	    DataOperationGet dataOp = new DataOperationGet();
	    dataOp.setUrl(dataOp.getBaseUrl() + "/movie/onView");
    	String response;
	    try {
            response = dataOp.Do();
	    } catch (Exception e) {
	        System.out.println("Exception");
	    }
	    ArrayList<Movie> arr = new Gson().fromJson(response);
    }
}
