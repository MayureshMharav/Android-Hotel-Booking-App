package com.firstapp.designui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Hotel_paradise extends AppCompatActivity {
    ImageButton btnBack_paradise,btnhome_paradise;
    Button single_bed,double_bed,pool,lux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_paradise);

        //Back button
        btnBack_paradise = findViewById(R.id.paradise_back_btn);
        btnBack_paradise.setOnClickListener(v -> {
            finish();
        });

        // Home button
        btnhome_paradise = findViewById(R.id.paradise_home_btn);

        btnhome_paradise.setOnClickListener(v -> {
            Intent btnhome_paradise = new Intent(Hotel_paradise.this, Guest_Home.class);

            // prevents duplicate Home pages
            btnhome_paradise.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            startActivity(btnhome_paradise);
        });

        //Dialog Single bed
        single_bed=findViewById(R.id.single_bed_btn);
        single_bed.setOnClickListener(v -> {

            Dialog dialog_single_bed = new Dialog(Hotel_paradise.this);
            dialog_single_bed.setContentView(R.layout.dialog_singlebed_details);
            dialog_single_bed.setCancelable(true);

            //Dialog Button Logic
            Button BookRoom_single = dialog_single_bed.findViewById(R.id.book_btn_single);

            BookRoom_single.setOnClickListener(view -> {
                dialog_single_bed.dismiss(); // close dialog first

                Intent bk_int = new Intent(Hotel_paradise.this, MyInvoice.class);
                bk_int.putExtra("HOTEL", "Hotel Paradise");
                bk_int.putExtra("ROOMTYPE", "Single Bed Room");
                bk_int.putExtra("PRICE", 1500);
                startActivity(bk_int);
            });
            // Make background transparent
            dialog_single_bed.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );
            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog_single_bed.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog_single_bed.getWindow().getAttributes().setBlurBehindRadius(15);
            }
            dialog_single_bed.show();
        });

        //Dialog Double bed
        double_bed=findViewById(R.id.double_bed_btn);
        double_bed.setOnClickListener(v -> {

            Dialog dialog_double_bed = new Dialog(Hotel_paradise.this);
            dialog_double_bed.setContentView(R.layout.dialog_doublebed_details);
            dialog_double_bed.setCancelable(true);

            //Button Logic
            Button BookRoom_double = dialog_double_bed.findViewById(R.id.book_btn_double);

            BookRoom_double.setOnClickListener(view -> {
                dialog_double_bed.dismiss(); // close dialog first

                Intent bk_d_int = new Intent(Hotel_paradise.this, MyInvoice.class);
                bk_d_int.putExtra("HOTEL", "Hotel Paradise");
                bk_d_int.putExtra("ROOMTYPE", "Double Bed Room");
                bk_d_int.putExtra("PRICE", 2200);
                startActivity(bk_d_int);
            });
            // Make background transparent
            dialog_double_bed.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );
            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog_double_bed.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog_double_bed.getWindow().getAttributes().setBlurBehindRadius(15);
            }
            dialog_double_bed.show();
        });

        //Dialog Pool bed
        pool=findViewById(R.id.pool_btn);
        pool.setOnClickListener(v -> {

            Dialog dialog_pool_bed = new Dialog(Hotel_paradise.this);
            dialog_pool_bed.setContentView(R.layout.dialog_withpool_details);
            dialog_pool_bed.setCancelable(true);

            //Button Logic
            Button BookRoom_pool = dialog_pool_bed.findViewById(R.id.book_btn_pool);

            BookRoom_pool.setOnClickListener(view -> {
                dialog_pool_bed.dismiss(); // close dialog first

                Intent bk_p_int = new Intent(Hotel_paradise.this, MyInvoice.class);
                bk_p_int.putExtra("HOTEL", "Hotel Paradise");
                bk_p_int.putExtra("ROOMTYPE", "Room with Pool");
                bk_p_int.putExtra("PRICE", 4000);
                startActivity(bk_p_int);
            });

            // Make background transparent
            dialog_pool_bed.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog_pool_bed.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog_pool_bed.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog_pool_bed.show();
        });

        //Dialog Luxury bed
        lux=findViewById(R.id.lux_btn);
        lux.setOnClickListener(v -> {

            Dialog dialog_luxury_details = new Dialog(Hotel_paradise.this);
            dialog_luxury_details.setContentView(R.layout.dialog_luxury_details);
            dialog_luxury_details.setCancelable(true);

            //Button Logic
            Button BookRoom_luxury = dialog_luxury_details.findViewById(R.id.book_btn_luxury);

            BookRoom_luxury.setOnClickListener(view -> {
                dialog_luxury_details.dismiss(); // close dialog first

                Intent bk_l_int = new Intent(Hotel_paradise.this, MyInvoice.class);
                bk_l_int.putExtra("HOTEL", "Hotel Paradise");
                bk_l_int.putExtra("ROOMTYPE", "Luxury Room");
                bk_l_int.putExtra("PRICE", 6000);
                startActivity(bk_l_int);
            });

            // Make background transparent
            dialog_luxury_details.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );

            // Blur background (Android 12+)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                dialog_luxury_details.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog_luxury_details.getWindow().getAttributes().setBlurBehindRadius(15);
            }

            dialog_luxury_details.show();
        });
    }
}
