package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LastPage extends AppCompatActivity {
    List finalList = new ArrayList();
    int finalPrice = PriceOption.getPrice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);


    for (String value:MainActivity4.getDietType()) {
    }
    for (String value:MainActivity2.getEatType()) {
        }
    for (String value:MainActivity3.getDietType()) {
        }

    }

}