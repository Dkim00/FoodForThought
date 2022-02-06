package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private static boolean spice = false;
    private static boolean deepfry = false;
    private static boolean option = false;
    private static List<String> varList2 = new ArrayList();

    //    boolean spice = false;
//    boolean deepfry= false;
//    boolean option= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button spicy = findViewById(R.id.spicy);
        Button deepFried = findViewById(R.id.deepFried);
        Button option3 = findViewById(R.id.option3);
        Button results = findViewById(R.id.showResults);

        spicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            spice = true;
            }
        });
        deepFried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            deepfry = true;
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            option = true;

            }
        });
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLastPage();


            }
        });


    }
    public void goToLastPage(){
        Intent intent = new Intent(this, LastPage.class);
        startActivity(intent);
    }
    //getter
    public static List<String> getModifierType(){
        if (spice){
            varList2.add("spicy");
        }
        if (deepfry){
            varList2.add("deep fried");
        }
        if (option){
            varList2.add("option3");
        }
        return varList2;
}}