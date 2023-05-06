package com.homework.foodapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.homework.foodapp.adapter.MenuAdapter;
import com.homework.foodapp.adapter.RestaurantAdapter;
import com.homework.foodapp.model.Restaurant;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemview);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(R.string.choose_food);
        actionbar.setDisplayHomeAsUpEnabled(true);

        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");

        TextView name = (TextView) findViewById(R.id.restaurant_text);
        TextView openhours = (TextView) findViewById(R.id.open_hours_text);
        ImageView icon = (ImageView) findViewById(R.id.restaurant_image);
        name.setText(restaurant.name);
        openhours.setText(restaurant.openhours);
        Context context = getApplicationContext();
        int image_id = context.getResources().getIdentifier(restaurant.image, "drawable", context.getPackageName());
        icon.setImageResource(image_id);

        ListView menu = (ListView) findViewById(R.id.menu_view);
        MenuAdapter adapter = new MenuAdapter(getApplicationContext(), restaurant.menu);
        menu.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}