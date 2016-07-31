package com.example.maximtian.myapplication;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaximTian on 2016/4/13.
 */
public class HttpUtil {

    public static HttpClient httpClient = new DefaultHttpClient();

    public static String getRequest(String url) throws Exception {
        // 创建HttpGet对象。
        HttpGet get = new HttpGet(url);
        // 发送GET请求
        HttpResponse httpResponse = httpClient.execute(get);
        // 如果服务器成功地返回响应
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            // 获取服务器响应字符串
            String result = EntityUtils.toString(httpResponse.getEntity());
            return result;
        } else {
            return null;
        }
    }

    public static Boolean postRequest(String url, String account, String password)
            throws Exception {
        JSONObject postData = new JSONObject();
        postData.put("username", account);
        postData.put("password", password);

        HttpEntity requestHttpEntity = new StringEntity(postData.toString());
        HttpPost post = new HttpPost(url);  // 创建HttpPost对象
        post.setEntity(requestHttpEntity);

        HttpResponse httpResponse = httpClient.execute(post);

        // 如果服务器成功地返回响应
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            // 获取服务器响应字符串
            String result = EntityUtils.toString(httpResponse.getEntity());
            if (result.indexOf("true") != -1) {
                return true;
            }
        }
        return false;
    }

}
