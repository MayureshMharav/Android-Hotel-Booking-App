package com.firstapp.designui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Book_Room extends AppCompatActivity {
Button h1,h2,h3,h4,h5,home,details1,details2,details3,details4,details5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_room);

        Intent intent=getIntent();
        h1=findViewById(R.id.s1_button);
        h2=findViewById(R.id.s2_button);
        h3=findViewById(R.id.s3_button);
        h4=findViewById(R.id.s4_button);
        h5=findViewById(R.id.s5_button);
        home=findViewById(R.id.home_btn);
        details1=findViewById(R.id.d1_btn);
        details2=findViewById(R.id.d2_btn);
        details3=findViewById(R.id.d3_btn);
        details4=findViewById(R.id.d4_btn);
        details5=findViewById(R.id.d5_btn);

        h1.setOnClickListener(v -> {
            Intent h1b = new Intent(this, Hotel_paradise.class);
            startActivity(h1b);
        });

        h2.setOnClickListener(v -> {
            Intent h2b = new Intent(this, Karls_Hotel.class);
            startActivity(h2b);
        });

        h3.setOnClickListener(v -> {
            Intent h3b = new Intent(this, Shawn_Hotel.class);
            startActivity(h3b);
        });

        h4.setOnClickListener(v -> {
            Intent h4b = new Intent(this, Royals_Hotel.class);
            startActivity(h4b);
        });

        h5.setOnClickListener(v -> {
            Intent h5b = new Intent(this, Ratans_Hotel.class);
            startActivity(h5b);
        });

        home.setOnClickListener(v -> {
            Intent hb = new Intent(this, Guest_Home.class);
            finish();
        });

        //Details Button 1
        details1.setOnClickListener(v -> {

            Dialog dialog = new Dialog(Book_Room.this);
            dialog.setContentView(R.layout.dialog_paradise_details);
            dialog.setCancelable(true);

            // Make background transparent
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog.show();
        });

        //Details Button 2
        details2.setOnClickListener(v -> {

            Dialog dialog = new Dialog(Book_Room.this);
            dialog.setContentView(R.layout.dialog_karls_details);
            dialog.setCancelable(true);

            // Make background transparent
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog.show();
        });

        //Details Button 3
        details3.setOnClickListener(v -> {

            Dialog dialog = new Dialog(Book_Room.this);
            dialog.setContentView(R.layout.dialog_shawn_details);
            dialog.setCancelable(true);

            // Make background transparent
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog.show();
        });

        //Details Button 4
        details4.setOnClickListener(v -> {

            Dialog dialog = new Dialog(Book_Room.this);
            dialog.setContentView(R.layout.dialog_royals_details);
            dialog.setCancelable(true);

            // Make background transparent
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog.show();
        });

        //Details Button 5
        details5.setOnClickListener(v -> {

            Dialog dialog = new Dialog(Book_Room.this);
            dialog.setContentView(R.layout.dialog_ratans_details);
            dialog.setCancelable(true);

            // Make background transparent
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog.show();
        });
    }
}