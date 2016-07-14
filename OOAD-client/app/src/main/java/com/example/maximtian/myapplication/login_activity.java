package com.example.maximtian.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.List;

import Database.DBManager;
import Database.PublicID;
import Database.User;
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

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();
        dbManager = new DBManager(this);
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

                if (account.equals("")) {
                    Toast.makeText(login_activity.this, "«Î ‰»Î’À∫≈", Toast.LENGTH_LONG).show();
                } else if (password.equals("")) {
                    Toast.makeText(login_activity.this, "«Î ‰»Î√‹¬Î", Toast.LENGTH_LONG).show();
                } else {
                    User user = dbManager.QueryUser(account);
                    Toast.makeText(login_activity.this, account, Toast.LENGTH_SHORT).show();
                    if (user == null) {
                        Toast.makeText(login_activity.this, "ƒ˙ ‰»Îµƒ’À∫≈≤ª¥Ê‘⁄", Toast.LENGTH_SHORT).show();
                    } else if (account.contentEquals(user.getName())
                            && password.contentEquals(user.getPassword())) {
                        Intent start_main = new Intent(login_activity.this, main_activity.class);
                        startActivity(start_main);
                        finish();
                    } else {
                        Toast.makeText(login_activity.this, "ƒ˙ ‰»Îµƒ’À∫≈ªÚ√‹¬Î¥ÌŒÛ", Toast.LENGTH_SHORT).show();
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

}
