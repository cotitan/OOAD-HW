package mainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maximtian.myapplication.R;
import com.google.gson.Gson;

import Database.DBManager;
import Database.PublicID;
import datamodel.User;
import datamodel.ServerMsg;
import services.MyServiceConnection;
import services.serviceClient;

/**
 * Created by WILLIAM on 2016/7/13.
 */
public class Register_Activity extends Activity {
    private Button registerBtn;
    private EditText account;
    private EditText password;
    private EditText confirm_password;

    private DBManager dbManager;
    private MyServiceConnection conn = new MyServiceConnection();
    private Handler handler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        dbManager = new DBManager(this);

        registerBtn = (Button)findViewById(R.id.register_registerBtn);
        account = (EditText)findViewById(R.id.register_account);
        password = (EditText)findViewById(R.id.register_password);
        confirm_password = (EditText)findViewById(R.id.register_confirm);

        handler = new Handler() {
            public void handleMessage(Message msg1) {
                String json = msg1.obj.toString();
                ServerMsg serverMsg = new Gson().fromJson(json, ServerMsg.class);
                if (serverMsg.getStatus()) {
                    Toast.makeText(Register_Activity.this, "Register successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(Register_Activity.this, serverMsg.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        
        Intent intent = new Intent(this, serviceClient.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
        
        /*
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(confirm_password.getText().toString()) &&
                        !password.getText().toString().equals("")) {
                    String ps = password.getText().toString();
                    String ac = account.getText().toString();
                    if (dbManager.QueryUser(ac) != null) {
                        Toast.makeText(Register_Activity.this, "���û����Ѵ���", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User(PublicID.getUser_id(), ac, ps);
                        dbManager.addUserSQL(user);
                        Toast.makeText(Register_Activity.this, "ע��ɹ�", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register_Activity.this, Register_activity.class);
                        startActivity(intent);
                        finish();
                    }
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(Register_Activity.this, "����������", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Register_Activity.this, "�����������벻һ��", Toast.LENGTH_LONG).show();
                }
            }
        });
        */
    }
    
    public void listenerRegister(View v) {
        String username = account.getText().toString();
        String password1 = password.getText().toString();
        String confirm = confirm_password.getText().toString();
        
        User user = new User();
        if (username.isEmpty()) {
            Toast.makeText(Register_Activity.this, "请输入账户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password1.isEmpty()) {
            Toast.makeText(Register_Activity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (confirm.equals(password1) == false) {
            Toast.makeText(Register_Activity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        
        user.setUsername(username);
        user.setPassword(password1);
        Message msg = new Message();
        msg.what = 0x1;
        msg.obj = new Gson().toJson(user);
        conn.getMyBinder().setHandler(handler);
        conn.getMyBinder().sendMessage(msg);
    }
    
}
