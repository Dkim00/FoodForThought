package com.example.foodforthought;


import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationProvider;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class Place {
};

public class PlaceFinder extends Service {
    private Map<String, JSONObject> items = new HashMap<String, JSONObject>();
    private Map<String, Integer> scores = new HashMap<String, Integer>();

    public PlaceFinder() {}


    public PlaceFinder(String[] keywords, int price, Location location) {
        ArrayList<JSONArray> responses= new ArrayList<JSONArray>();
        for(int i = 0; i < keywords.length; i++) {
            Response response = requestGoogle(keywords[i], location);

            try {
                String data = response.body().string();
                JSONObject jObject = new JSONObject(data);
                JSONArray jArray = jObject.getJSONArray("results");
                responses.add(jArray);

                for(int j = 0; j < jArray.length(); j++) {
                    try {
                        if(jArray.getJSONObject(i).getInt("price_level") == price) {
                            if(scores.get(jArray.getJSONObject(j).getString("place_id")) == null) {
                                scores.put(jArray.getJSONObject(j).getString("place_id"), 1);
                            } else {
                                scores.put(jArray.getJSONObject(j).getString("place_id"), scores.get(jArray.getJSONObject(j).getString("place_id"))+1);
                            }
                        }
                    } catch (JSONException e) {

                    }

                    if(scores.get(jArray.getJSONObject(j).getString("place_id")) == null) {
                        scores.put(jArray.getJSONObject(j).getString("place_id"), 1);
                    } else {
                        scores.put(jArray.getJSONObject(j).getString("place_id"), scores.get(jArray.getJSONObject(j).getString("place_id"))+1);
                    }
                    if(items.get(jArray.getJSONObject(j).getString("place_id")) == null) {
                        scores.put(jArray.getJSONObject(j).getString("place_id"), scores.get(jArray.getJSONObject(j)));
                    }

                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

        }

    }

    public JSONObject[] getTop10() {
        JSONObject[] list = new JSONObject[10];
        int cur = 0;
        ArrayList<String> keys = new ArrayList<String>();
        while(keys.size() < 10 && keys.size() < items.size()) {
            int max = Collections.max(scores.values());
            for(Map.Entry<String,Integer> entry: scores.entrySet()) {
                if(entry.getValue() == max){
                    keys.add(entry.getKey());
                    list[cur] = items.get(entry.getKey());
                    cur++;
                }
            }
        }

        return list;
    }

    public static Response requestGoogle(String keyword, Location location) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location.getLatitude()+ "%2C" + location.getLongitude();
            url = url + "&radius=10000&type=restaurant&keyword=" + keyword + "&key=AIzaSyCXx_DTO0uwKocui6Mvh9HMs_GjCRtb0rI";

            Request request = new Request.Builder()
                    .url(url)
                    .method("GET", null)
                    .build();
            class Foo implements Runnable {
                private volatile Response response;

                @Override
                public void run() {
                    try {
                        response = client.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                public Response getResponse() {
                    return response;
                }
            };
            Foo foo = new Foo();
            Thread thread = new Thread(foo);
            thread.start();
            thread.join();
            return foo.getResponse();
        } catch (InterruptedException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    public static Response requestGoogle(Location location) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location.getLatitude()+ "%2C" + location.getLongitude();
            url = url + "&radius=10000&type=restaurant&key=AIzaSyCXx_DTO0uwKocui6Mvh9HMs_GjCRtb0rI";

            Request request = new Request.Builder()
                    .url(url)
                    .method("GET", null)
                    .build();
            class Foo implements Runnable {
                private volatile Response response;

                @Override
                public void run() {
                    try {
                        response = client.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                public Response getResponse() {
                    return response;
                }
            };
            Foo foo = new Foo();
            Thread thread = new Thread(foo);
            thread.start();
            thread.join();
            return foo.getResponse();
        } catch (InterruptedException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}