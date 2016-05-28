// package OOAD_hw;

public class RegisterTest {
    public static void main(String args[]) {
        DataOperationPost dataOp = new DataOperationPost();
        dataOp.setUrl(dataOp.getBaseUrl() + "/user/register");
        String json3 = "{\"username\": \"tiankk\", \"password\": \"tiankk\"," +  
                " \"gender\": 1, \"phone\": \"18819473274\", \"tags\": \"action\"}";
        try {
        	dataOp.setJson(json3);
        	System.out.println(dataOp.Do());
    	} catch (Exception e) {
    		System.out.println("Exception");
    	}
    }
}

