package com.homework.foodapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.foodapp.adapter.RestaurantAdapter;
import com.homework.foodapp.model.*;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(R.string.choose_restaurant);

        try {
            InputStream is = getApplicationContext().getAssets().open("data.json");
            Restaurants restaurants = new ObjectMapper().readValue(is, Restaurants.class);

            ListView listview = (ListView) findViewById(R.id.restaurant_view);
            RestaurantAdapter adapter = new RestaurantAdapter(getApplicationContext(), restaurants.restaurants);
            listview.setAdapter(adapter);

            listview.setOnItemClickListener((adptr, v, i, arg3) -> {
                Restaurant selected = (Restaurant) adptr.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("restaurant", selected);
                startActivity(intent);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}