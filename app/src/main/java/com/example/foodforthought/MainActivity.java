package com.example.foodforthought;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Wire up button
        //Get Button
        Button btn = findViewById(R.id.btnStart);//creates variable for button btnStrtew
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToFirstPage();
                Toast.makeText(getApplicationContext(),"This button should move me to the next page!",Toast.LENGTH_SHORT).show();


            }
        });
    }
    public void goToFirstPage() {
        Intent intent = new Intent(this, PriceOption.class);
        startActivity(intent);
    }

    }



