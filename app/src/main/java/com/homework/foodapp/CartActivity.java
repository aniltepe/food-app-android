package com.homework.foodapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.homework.foodapp.model.Restaurant;
import com.homework.foodapp.model.ShoppingCart;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ShoppingCart cart = (ShoppingCart) getIntent().getSerializableExtra("order");

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(R.string.choose_food);
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}