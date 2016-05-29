import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ljkis_000 on 2015/9/30.
 */
public class DataOperationGet extends DataOperation {
    private static int timeOut = 10000;
    private static String codeMode = "utf-8";
    private String detail;
    private String url;
    private String query;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private void processUrl() {
        if (getQuery() != null)
            setUrl(getUrl()+getQuery());
    }

    public String Do() {
        String result = "";
        BufferedReader reader = null;
        try {
            // initial connection
            processUrl();
            URL url = new URL(this.getUrl());
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");

            // message to back
            connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("content-type", "application/json");

            // connect
            connection.setConnectTimeout(timeOut);
            connection.connect();

            // message to front
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                result += line;
            }
            result = URLDecoder.decode(result, codeMode);

        } catch (Exception e) {
            System.out.println("Send Get Fail!");
            result = "{\"status\": false, \"message\": \"Send Get Fail!\" }";
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
