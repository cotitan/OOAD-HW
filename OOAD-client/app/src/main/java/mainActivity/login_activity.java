package mainActivity;

import services.MyServiceConnection;
import services.serviceClient;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBManager;

import com.example.maximtian.myapplication.R;
import com.google.gson.Gson;
import datamodel.ServerMsg;
import datamodel.User;

/**
 * Created by MaximTian on 2016/4/12.
 */
public class login_activity extends Activity {

    private EditText ed_account;
    private EditText ed_password;
    private String account;
    private String password;
    private Button loginBtn;
    private Button registerBtn;
    private DBManager dbManager;

    private Handler handler;
    private MyServiceConnection conn = new MyServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        handler = new Handler() {
            public void handleMessage(Message msg1) {
                String json = msg1.obj.toString();
                ServerMsg serverMsg = new Gson().fromJson(json, ServerMsg.class);
                if (serverMsg.getStatus()) {
                    Toast.makeText(login_activity.this, "login successfully", Toast.LENGTH_SHORT).show();
                    Intent start_main = new Intent(login_activity.this, main_activity.class);
                    startActivity(start_main);
                    finish();
                }
                else {
                    Toast.makeText(login_activity.this, serverMsg.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };

        final Intent intent = new Intent(this, serviceClient.class);
        bindService(intent, conn, Service.BIND_AUTO_CREATE);

        // initView();
        dbManager = new DBManager(this);
    }

    public void listenerLogin(View v) {
        ed_account = (EditText) findViewById(R.id.account);
        ed_password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        registerBtn = (Button)findViewById(R.id.register);
        account = ed_account.getText().toString();
        password = ed_password.getText().toString();

        if (account.equals("")) {
            Toast.makeText(login_activity.this, "请输入账户名", Toast.LENGTH_LONG).show();
        } else if (password.equals("")) {
            Toast.makeText(login_activity.this, "请输入密码", Toast.LENGTH_LONG).show();
        } else {
            User user = new User();
            user.setUsername(account);
            user.setPassword(password);

            Message msg = new Message();
            msg.what = 0x3;
            msg.obj = new Gson().toJson(user);
            try {
                conn.getMyBinder().setHandler(handler);
                conn.getMyBinder().sendMessage(msg);
            } catch (Exception e) {
                Toast.makeText(login_activity.this, "binder==null", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void listenerRegister(View v) {
        Intent start_reg = new Intent(login_activity.this, Register_Activity.class);
        startActivity(start_reg);
    }

    /*
    private void initView() {
        ed_account = (EditText) findViewById(R.id.account);
        ed_password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        registerBtn = (Button)findViewById(R.id.register);

        /*
        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                account = ed_account.getText().toString();
                password = ed_password.getText().toString();

                if (account.equals("")) {
                    Toast.makeText(login_activity.this, "�������˺�", Toast.LENGTH_LONG).show();
                } else if (password.equals("")) {
                    Toast.makeText(login_activity.this, "����������", Toast.LENGTH_LONG).show();
                } else {
                    String user = "{\"username\":\"tiankk\", \"password\":\"tiankk\"";

                    Message msg = new Message();
                    msg.what = 0x3;
                    msg.obj = user;
                    binder.setHandler(handler);
                    binder.sendMessage(msg);


                    User user = dbManager.QueryUser(account);
                    if (user == null) {
                        Toast.makeText(login_activity.this, "��������˺Ų�����", Toast.LENGTH_SHORT).show();
                    } else if (account.contentEquals(user.getName())
                            && password.contentEquals(user.getPassword())) {
                        Intent start_main = new Intent(login_activity.this, main_activity.class);
                        startActivity(start_main);
                        finish();
                    } else {
                        Toast.makeText(login_activity.this, "��������˺Ż��������", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        registerBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_main = new Intent(login_activity.this, Register_Activity.class);
                startActivity(start_main);
                finish();
            }
        });
    }
    */

    protected  void onDestroy() {
        unbindService(conn);
        super.onDestroy();
    }

}
