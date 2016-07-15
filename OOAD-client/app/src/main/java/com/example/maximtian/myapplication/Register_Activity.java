package com.example.maximtian.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBManager;
import Database.PublicID;
import Database.User;

/**
 * Created by WILLIAM on 2016/7/13.
 */
public class Register_Activity extends Activity {
    private Button registerBtn;
    private EditText acount;
    private EditText password;
    private EditText confirm_password;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        dbManager = new DBManager(this);

        registerBtn = (Button)findViewById(R.id.register_registerBtn);
        acount = (EditText)findViewById(R.id.register_account);
        password = (EditText)findViewById(R.id.register_password);
        confirm_password = (EditText)findViewById(R.id.register_confirm);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(confirm_password.getText().toString()) &&
                        !password.getText().toString().equals("")) {
                    String ps = password.getText().toString();
                    String ac = acount.getText().toString();
                    if (dbManager.QueryUser(ac) != null) {
                        Toast.makeText(Register_Activity.this, "该用户名已存在", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User(PublicID.getUser_id(), ac, ps);
                        dbManager.addUserSQL(user);
                        Toast.makeText(Register_Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register_Activity.this, login_activity.class);
                        startActivity(intent);
                        finish();
                    }
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(Register_Activity.this, "请输入密码", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Register_Activity.this, "两次输入密码不一样", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
