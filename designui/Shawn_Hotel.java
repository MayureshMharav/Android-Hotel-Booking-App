package com.firstapp.designui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Shawn_Hotel extends AppCompatActivity {
ImageButton btnback_shawn , btnhome_shawn;
Button single_bed,double_bed,pool,lux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shawn_hotel);

        Intent intent=getIntent();

        btnback_shawn=findViewById(R.id.shawn_back_btn);
        btnhome_shawn=findViewById(R.id.shawn_home_btn);

        btnback_shawn.setOnClickListener(v -> {
            finish();
        });

        btnhome_shawn.setOnClickListener(v -> {
            Intent btnhome_shawn = new Intent(Shawn_Hotel.this, Guest_Home.class);

            // prevents duplicate Home pages
            btnhome_shawn.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            startActivity(btnhome_shawn);
        });

        //Dialog Single bed
        single_bed=findViewById(R.id.single_bed_btn);
        single_bed.setOnClickListener(v -> {

            Dialog dialog_single_bed = new Dialog(Shawn_Hotel.this);
            dialog_single_bed.setContentView(R.layout.dialog_singlebed_details);
            dialog_single_bed.setCancelable(true);

            //Button Logic
            Button BookRoom_single = dialog_single_bed.findViewById(R.id.book_btn_single);

            BookRoom_single.setOnClickListener(view -> {
                dialog_single_bed.dismiss(); // close dialog first

                Intent bk_int = new Intent(Shawn_Hotel.this, MyInvoice.class);
                bk_int.putExtra("ROOM_TYPE", "Single Bed Room");
                bk_int.putExtra("PRICE_PER_DAY", 1500);

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

            Dialog dialog_double_bed = new Dialog(Shawn_Hotel.this);
            dialog_double_bed.setContentView(R.layout.dialog_doublebed_details);
            dialog_double_bed.setCancelable(true);

            //Button Logic
            Button BookRoom_double = dialog_double_bed.findViewById(R.id.book_btn_double);

            BookRoom_double.setOnClickListener(view -> {
                dialog_double_bed.dismiss(); // close dialog first

                Intent bk_int = new Intent(Shawn_Hotel.this, MyInvoice.class);
                startActivity(bk_int);
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

            Dialog dialog_pool_bed = new Dialog(Shawn_Hotel.this);
            dialog_pool_bed.setContentView(R.layout.dialog_withpool_details);
            dialog_pool_bed.setCancelable(true);

            //Button Logic
            Button BookRoom_pool = dialog_pool_bed.findViewById(R.id.book_btn_pool);

            BookRoom_pool.setOnClickListener(view -> {
                dialog_pool_bed.dismiss(); // close dialog first

                Intent bk_int = new Intent(Shawn_Hotel.this, MyInvoice.class);
                startActivity(bk_int);
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

            Dialog dialog_luxury_details = new Dialog(Shawn_Hotel.this);
            dialog_luxury_details.setContentView(R.layout.dialog_luxury_details);
            dialog_luxury_details.setCancelable(true);

            //Button Logic
            Button BookRoom_luxury = dialog_luxury_details.findViewById(R.id.book_btn_luxury);

            BookRoom_luxury.setOnClickListener(view -> {
                dialog_luxury_details.dismiss(); // close dialog first

                Intent bk_int = new Intent(Shawn_Hotel.this, MyInvoice.class);
                startActivity(bk_int);
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