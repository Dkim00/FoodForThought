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

    //generate final list
    for (String diet:MainActivity4.getDietType()) {
        finalList.add(diet);
    }
    for (String eat:MainActivity2.getEatType()) {
        finalList.add(eat);
        }
    for (String mod:MainActivity3.getModifierType()) {
        finalList.add(mod);
        }

    }


}