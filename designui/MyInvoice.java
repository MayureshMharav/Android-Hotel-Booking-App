package com.firstapp.designui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firstapp.designui.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MyInvoice extends AppCompatActivity {
Button CheckIn , CheckOut , btnConfirm;
TextView Description , Days , Amount;

Calendar CheckInCal = Calendar.getInstance();
Calendar CheckOutCal = Calendar.getInstance();

String ROOMTYPE, HOTEL;
int PRICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_invoice);

        CheckIn = findViewById(R.id.checkin_date);
        CheckOut = findViewById(R.id.checkout_date);
        btnConfirm = findViewById(R.id.btnConfirmBooking);

        Description = findViewById(R.id.tvDescription);
        Days = findViewById(R.id.tvDays);
        Amount =findViewById(R.id.tvAmount);

        ROOMTYPE = getIntent().getStringExtra("ROOMTYPE");
        HOTEL = getIntent().getStringExtra("HOTEL");
        PRICE = getIntent().getIntExtra("PRICE", 0);

        updateDescription(0);

        CheckIn.setOnClickListener(v -> {
            Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    //Calendar Logic
    private void openCalendar(boolean isCheckIn){
        Calendar cal = isCheckIn ? CheckInCal : CheckOutCal;

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    cal.set(year, month, dayOfMonth);
                    updateDatebuttons();
                    calculateDaysAndAmount();
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }

    //1 Update button text
    private void updateDatebuttons(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        CheckIn.setText(sdf.format(CheckInCal.getTime()));
        CheckOut.setText(sdf.format(CheckOutCal.getTime()));
    }

    //Calculate days & Amount
    private void calculateDaysAndAmount(){
        long diffMillis = CheckOutCal.getTimeInMillis() - CheckInCal.getTimeInMillis();

        if(diffMillis <= 0){
            Days.setText("0 Days");
            Amount.setText("₹ 0");
            return;
        }

        long days = TimeUnit.MILLISECONDS.toDays(diffMillis);
        int totalAmount = (int) (days * PRICE);

        Days.setText(days + "Days");
        Amount.setText("₹" + totalAmount);

        updateDescription(days);
    }

    //Dynamic Description
    private void updateDescription(long days){
        String desc =
                ROOMTYPE + "\n" +
                        HOTEL + "\n" +
                        (days > 0 ? days + "Days" : "Select Dates");

        Description.setText(desc);
    }
}
