package com.homework.foodapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.homework.foodapp.adapter.CartAdapter;
import com.homework.foodapp.model.ShoppingCart;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicReference;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ShoppingCart cart = (ShoppingCart) getIntent().getSerializableExtra("order");

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        TextView placeholder = (TextView) findViewById(R.id.empty_cart);
        TextView restaurant = (TextView) findViewById(R.id.confirm_restaurant);
        TextView totalcost = (TextView) findViewById(R.id.total_cost);
        ListView list = (ListView) findViewById(R.id.cart_list_view);
        if (cart.products.size() > 0) {
            actionbar.setTitle(R.string.confirm_order);
            placeholder.setVisibility(View.GONE);
            restaurant.setText(cart.restaurant.name);
            CartAdapter adapter = new CartAdapter(getApplicationContext(), cart);
            list.setAdapter(adapter);
            AtomicReference<Float> total = new AtomicReference<>((float) 0);
            cart.products.forEach((key, value) -> {
                total.updateAndGet(v -> new Float((float) (v + key.price * value)));
            });
//            totalcost.setText("Toplam: " + Float.toString(total.get()) + "₺");
            totalcost.setText("Toplam: " + new DecimalFormat("0.00").format(total.get()) + "₺");
        }
        else {
            actionbar.setTitle("");
            placeholder.setVisibility(View.VISIBLE);
            restaurant.setVisibility(View.GONE);
            list.setVisibility(View.GONE);
            totalcost.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}