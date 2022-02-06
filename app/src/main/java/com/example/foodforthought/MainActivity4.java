package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    boolean vegan = false;
    boolean vegetarian = false;
    boolean keto = false;
    List varList1 = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button btn = findViewById(R.id.vegan);
        Button btn1 = findViewById(R.id.vegetarian);
        Button btn2 = findViewById(R.id.keto);
        Button btn3 = findViewById(R.id.skip);
        Button btn5 = findViewById(R.id.button5);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegan = true;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegetarian = true;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keto = true;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFourthPage();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Nothing
            }
        });
    }
    public void gotoFourthPage(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }
    //getter
    public List getDietType(){
        if (vegan){
            varList1.add("vegan");
                    }
        if (vegetarian){
            varList1.add("vegetarian");
        }
        if (keto){
            varList1.add("keto")
        }
        return varList1;
    }




}