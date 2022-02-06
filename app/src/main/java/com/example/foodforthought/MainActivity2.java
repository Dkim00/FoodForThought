package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List varList = new ArrayList();
    boolean dineIn = false;
    boolean driveThrough = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Button btn2 = findViewById(R.id.dineIn);
        Button btn3 = findViewById(R.id.driveThrough);
        Button btn4 = findViewById(R.id.nextPage1);
        //create 3 button variables btn1-3 so that we can sue with setOnClickListner
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dineIn = true;
                Toast.makeText(getApplicationContext(),"This button Works!",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                driveThrough = true;
                Toast.makeText(getApplicationContext(),"This button Works!",Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdPage();
                Toast.makeText(getApplicationContext(),"This button Works!",Toast.LENGTH_SHORT).show();
            }
        });}
    public void goToThirdPage() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void makeAList(){
        List returnList = new ArrayList();
        if (dineIn){
            returnList.add("dine-in");
        }
        if (driveThrough){
            returnList.add("drive through");

        }
    }
    //getter
    public List getEatType(){
        return varList;
    }



}
