package com.example.maximtian.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by MaximTian on 2016/4/13.
 */
public class login_Service extends IntentService {

    public login_Service() {
        super("HelloService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Boolean flag = false;
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
//        Log.d("HHHH", "TTTT");
        flag = doLogin(account, password);

/*        Intent start_main = new Intent(this, main_activity.class);
        start_main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(start_main);
*/    }

    private Boolean doLogin(String account, String password) {
        String url = "http://172.18.41.200:8080/user/login";
        Boolean strFlag = false;
        try {
            strFlag = HttpUtil.postRequest(url, account, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strFlag;
    }
}
