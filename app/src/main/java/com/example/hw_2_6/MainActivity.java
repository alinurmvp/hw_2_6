package com.example.hw_2_6;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvWelcome, tvEnter, tvSignIn, tvForgotPassword, tvClickHere;
    private EditText etLogin, etPassword;
    private Button btnEnter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvWelcome = findViewById(R.id.welcomeText);
        tvEnter = findViewById(R.id.Text);
        tvSignIn = findViewById(R.id.tv_loginText);
        tvForgotPassword= findViewById(R.id.forgotPasswordText);
        tvClickHere=findViewById(R.id.forgotPasswordText2);
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.passwordText);

        btnEnter = findViewById(R.id.buttonLogin);

        etLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (etPassword.getText().toString().isEmpty()){
                    btnEnter.setBackgroundColor(Color.GRAY);
                }else {
                    btnEnter.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                }
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (etLogin.getText().toString().isEmpty()){
                    btnEnter.setBackgroundColor(Color.GRAY);
                }else {
                    btnEnter.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                }
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
                    btnEnter.setVisibility(View.GONE);
                    tvEnter.setVisibility(View.GONE);
                    tvClickHere.setVisibility(View.GONE);
                    tvForgotPassword.setVisibility(View.GONE);
                    tvSignIn.setVisibility(View.GONE);
                    etPassword.setVisibility(View.GONE);
                    etLogin.setVisibility(View.GONE);
                    Toast.makeText(this, "Вы успешно зарегистрировались",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Неверный пароль и логин", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}