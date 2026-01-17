package com.firstapp.designui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Login extends AppCompatActivity {

    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etPassword = findViewById(R.id.et_Admin_Password);
        btnLogin = findViewById(R.id.btn_Admin_Login);

        btnLogin.setOnClickListener(v -> {
            if (etPassword.getText().toString().equals("admin123")) {

                SharedPreferences sp = getSharedPreferences("APP_PREFS", MODE_PRIVATE);
                sp.edit()
                        .putBoolean("IS_LOGGED_IN", true)
                        .putString("ROLE", "ADMIN")
                        .apply();

                startActivity(new Intent(this, Admin_Home.class));
                finish();
            } else {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
