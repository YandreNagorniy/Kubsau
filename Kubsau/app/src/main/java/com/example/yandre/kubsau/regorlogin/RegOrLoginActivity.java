package com.example.yandre.kubsau.regorlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.login.LoginActivity;
import com.example.yandre.kubsau.main.MainActivity;
import com.example.yandre.kubsau.signup.SignupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegOrLoginActivity extends AppCompatActivity {

    @BindView(R.id.btnGoToSignUp) Button btnGoToSignUp;
    @BindView(R.id.btnGoToLogin) Button btnGoToLogin;
    @BindView(R.id.btnSignUpOffline) Button btnSignUpOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_or_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnGoToSignUp, R.id.btnGoToLogin, R.id.btnSignUpOffline})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGoToSignUp: {
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnGoToLogin: {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnSignUpOffline: {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
