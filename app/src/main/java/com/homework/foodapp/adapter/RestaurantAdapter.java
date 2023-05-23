package com.homework.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.homework.foodapp.R;
import com.homework.foodapp.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends BaseAdapter {
    Context context;
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    LayoutInflater inflater;

    public RestaurantAdapter(Context context, List<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int i) {
        return this.restaurants.get(i);
    }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_restaurant, null);
        TextView name = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        name.setText(restaurants.get(i).name);
        int image_id = this.context.getResources().getIdentifier(restaurants.get(i).image, "drawable", context.getPackageName());
        icon.setImageResource(image_id);
        return view;
    }
}

