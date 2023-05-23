package com.homework.foodapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.homework.foodapp.adapter.MenuAdapter;
import com.homework.foodapp.databinding.ActivityRestaurantBinding;
import com.homework.foodapp.model.Restaurant;
import com.homework.foodapp.model.ShoppingCart;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRestaurantBinding binding = ActivityRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ShoppingCart cart = new ShoppingCart();

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(R.string.choose_food);
        actionbar.setDisplayHomeAsUpEnabled(true);

        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("restaurant");
        cart.restaurant = restaurant;
        TextView name = (TextView) findViewById(R.id.restaurant_text);
        TextView openhours = (TextView) findViewById(R.id.open_hours_text);
        ImageView icon = (ImageView) findViewById(R.id.restaurant_image);
        name.setText(restaurant.name);
        openhours.setText(restaurant.openhours);
        Context context = getApplicationContext();
        int image_id = context.getResources().getIdentifier(restaurant.image, "drawable", context.getPackageName());
        icon.setImageResource(image_id);

        ListView menu = (ListView) findViewById(R.id.menu_view);
        MenuAdapter adapter = new MenuAdapter(getApplicationContext(), this, restaurant.menu, cart);
        menu.setAdapter(adapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemActivity.this, CartActivity.class);
                intent.putExtra("order", cart);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}