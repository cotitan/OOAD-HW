package com.example.maximtian.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import mainActivity.Register_Activity;
import mainActivity.main_activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();
    }

    private void initView() {
        ed_account = (EditText) findViewById(R.id.account);
        ed_password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        registerBtn = (Button)findViewById(R.id.register);

        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                account = ed_account.getText().toString();
                password = ed_password.getText().toString();

/*                Intent intent = new Intent(login_activity.this, login_Service.class);
                Bundle bundle = new Bundle();
                bundle.putString("account", account);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startService(intent);
*/
/*                if (account.contentEquals("1234") && password.contentEquals("1234")) {
                    Toast.makeText(login_activity.this, "HHHH", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login_activity.this, "TTTT", Toast.LENGTH_SHORT).show();
                } */
                Intent start_main = new Intent(login_activity.this, main_activity.class);
                startActivity(start_main);
                finish();
            }
        });

        registerBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_main = new Intent(login_activity.this, Register_Activity.class);
                startActivity(start_main);
            }
        });
    }

}
