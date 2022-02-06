package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PriceOption extends AppCompatActivity {
    private static int price = 0;
    int returnVar = 0;
    //int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_option);

        Button btn1 = findViewById(R.id.lowPrice);
        Button btn2 = findViewById(R.id.mediumPrice);
        Button btn3 = findViewById(R.id.highPrice);
        Button btn4 = findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnVar = 1;
                Toast.makeText(getApplicationContext(),String.format("%d",returnVar),Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnVar = 2;
                Toast.makeText(getApplicationContext(),String.format("%d",returnVar),Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnVar = 3;
                Toast.makeText(getApplicationContext(),String.format("%d",returnVar),Toast.LENGTH_SHORT).show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextPage();

            }
        });




    }
    public void goToNextPage(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    //getter
    public static int getPrice(){
        return price;
    }
}