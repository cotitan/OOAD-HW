// package OOAD_hw;

/**
 * Created by ljkis_000 on 2015/9/30.
 */
public class DataOperation {
    // static private String baseUrl = "http://222.200.185.14:80";

//     static private String baseUrl = "http://172.19.94.223:8080";
    static private String baseUrl = "http://localhost:8080";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        DataOperation.baseUrl = baseUrl;
    }
}
