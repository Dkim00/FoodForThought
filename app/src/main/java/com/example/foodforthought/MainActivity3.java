package com.example.foodforthought;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private static boolean spice = false;
    private static boolean deepfry = false;
    private static boolean option = false;
    private static List<String> varList2 = new ArrayList();
    public JSONObject[] list;
    List<String> finalList = new ArrayList<>();
    JSONObject finalChoice;
    private ProgressBar spinner;

    //    boolean spice = false;
//    boolean deepfry= false;
//    boolean option= false;

    private FusedLocationProviderClient fusedLocationClient;
    private OnSuccessListener<Location> listener = new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                PlaceFinder finder = new PlaceFinder(finalList.toArray(new String[0]), PriceOption.getPrice(), location);
                list = finder.getTop10();
                int ran = (int) (Math.random()*10);
                finalChoice = list[ran];
                goToLastPage();
            }else {
                Toast.makeText(getApplicationContext(),"Could not get your location, please try again later!",Toast.LENGTH_SHORT).show();
                spinner.setVisibility(View.GONE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button spicy = findViewById(R.id.spicy);
        Button deepFried = findViewById(R.id.deepFried);
        Button option3 = findViewById(R.id.option3);
        Button results = findViewById(R.id.showResults);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

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
                    for (String diet:MainActivity4.getDietType()) {
                        finalList.add(diet);
                    }
                    for (String eat:MainActivity2.getEatType()) {
                        finalList.add(eat);
                    }
                    for (String mod:MainActivity3.getModifierType()) {
                        finalList.add(mod);
                    }
                    Log.i("myApp", "This button is working!");
                    spinner.setVisibility(View.VISIBLE);
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        System.out.println("Permission already granted");
                        fusedLocationClient.getLastLocation()
                                .addOnSuccessListener(MainActivity3.this, listener);
                    } else {
                        ActivityCompat.requestPermissions(MainActivity3.this, new String [] {Manifest.permission.ACCESS_COARSE_LOCATION}, 16169);
                    }

            }
        });


    }
    public void goToLastPage(){
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/?api=1&query="+ finalChoice.getString("vicinity") +"&query_place_id=" + finalChoice.getString("place_id")));
            startActivity(intent);
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "There was an error, please try again!", Toast.LENGTH_SHORT).show();
        }
        spinner.setVisibility(View.GONE);
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
            varList2.add("seafood");
        }
        return varList2;
}
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 16169) {
            // Checking whether user granted the permission or not.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Showing the toast message
                Toast.makeText(MainActivity3.this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationClient.getLastLocation()
                            .addOnSuccessListener(MainActivity3.this, listener);
                }
            }
            else {
                Toast.makeText(MainActivity3.this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
                spinner.setVisibility(View.GONE);
            }
        }
    }
}