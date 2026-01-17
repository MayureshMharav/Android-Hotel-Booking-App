package com.firstapp.designui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Admin_Home extends AppCompatActivity {
Button User_Admin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        User_Admin = findViewById(R.id.Users_stats);
        User_Admin.setOnClickListener(v -> {
            startActivity(new Intent(this, UserDetails.class));
        });
    }
}
