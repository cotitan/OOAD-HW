package serverConnector;

/**
 * Created by ljkis_000 on 2015/9/30.
 */
public class DataOperation {
    // static private String baseUrl = "http://localhost:8080";
    static private String baseUrl = "http://172.18.41.130:8080";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        DataOperation.baseUrl = baseUrl;
    }
}
