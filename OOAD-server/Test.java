// package OOAD_hw;

public class Test {
    public static void main(String args[]) {
        DataOperationPost dataOp = new DataOperationPost();
        dataOp.setUrl(dataOp.getBaseUrl() + "/user/login");
        String json1 = "{\"username\": \"1234\", \"password123\": \"12345\"}";
        String json2 = "{\"username\": \"1234\", \"password\": \"12345\"}";
        String json3 = "{\"username\": \"tiankk\", \"password\": \"tiankk\"}";
        try {
        	dataOp.setJson(json1);
        	// System.out.println(dataOp.Do());

        	dataOp.setJson(json2);
        	// System.out.println(dataOp.Do());

        	dataOp.setJson(json3);
        	System.out.println(dataOp.Do());
    	} catch (Exception e) {
    		System.out.println("Exception");
    	}
    }
}

