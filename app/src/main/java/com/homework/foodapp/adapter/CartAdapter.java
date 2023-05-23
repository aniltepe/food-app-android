package com.homework.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.homework.foodapp.R;
import com.homework.foodapp.model.Product;
import com.homework.foodapp.model.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartAdapter extends BaseAdapter {
    Context appContext;
    ShoppingCart cart;
    LayoutInflater inflater;

    public CartAdapter(Context appContext, ShoppingCart cart) {
        this.appContext = appContext;
        this.cart = cart;
        inflater = (LayoutInflater.from(appContext));
    }
    @Override
    public int getCount() {
        return cart.products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_cart, null);
        TextView quantity = (TextView) view.findViewById(R.id.product_quantity);
        TextView name = (TextView) view.findViewById(R.id.product_name);
        TextView cost = (TextView) view.findViewById(R.id.product_cost);
        HashMap.Entry<Product, Integer> entry = (HashMap.Entry<Product, Integer>) cart.products.entrySet().toArray()[i];
        name.setText(entry.getKey().name);
        quantity.setText(Integer.toString(entry.getValue()) + "x");
        cost.setText(Float.toString(entry.getValue() * entry.getKey().price) + "₺");
        return view;
    }
}
