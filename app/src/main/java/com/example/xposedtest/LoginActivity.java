package com.example.xposedtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString();
                String pwd = etPassword.getText().toString();
                if (verifyLogin(account, pwd)) {
                    Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean verifyLogin(String account, String pwd) {
        if (account.equals("leory") && pwd.equals("123")) {
            return true;
        }
        return false;
    }
}
