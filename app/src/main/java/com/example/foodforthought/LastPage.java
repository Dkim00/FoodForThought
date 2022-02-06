package com.example.foodforthought;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LastPage extends AppCompatActivity {
    int finalPrice = PriceOption.getPrice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

    //generate final list

        TextView addressView = findViewById(R.id.addressView);
        TextView titleView = findViewById(R.id.titleText);
        TextView ratingView = findViewById(R.id.ratingView);
        TextView priceView = findViewById(R.id.priceView);



    }


}