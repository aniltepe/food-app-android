package com.homework.foodapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.homework.foodapp.R;
import com.homework.foodapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends BaseAdapter {
    Context context;
    List<Product> products = new ArrayList<Product>();
    LayoutInflater inflater;

    public MenuAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return products.size();
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
        view = inflater.inflate(R.layout.activity_list2view, null);
        TextView name = (TextView) view.findViewById(R.id.menu_text);
        TextView desc = (TextView) view.findViewById(R.id.menu_desc);
        ImageView icon = (ImageView) view.findViewById(R.id.menu_icon);
        name.setText(products.get(i).name);
        desc.setText(products.get(i).description);
        int image_id = this.context.getResources().getIdentifier(products.get(i).image, "drawable", context.getPackageName());
        icon.setImageResource(image_id);
        return view;
    }
}

