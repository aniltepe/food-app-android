package com.homework.foodapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.homework.foodapp.R;
import com.homework.foodapp.model.Product;
import com.homework.foodapp.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends BaseAdapter {
    Context appContext;
    Context actContext;
    List<Product> products = new ArrayList<Product>();
    ShoppingCart cart;
    LayoutInflater inflater;

    public MenuAdapter(Context appContext, Context actContext, List<Product> products, ShoppingCart cart) {
        this.appContext = appContext;
        this.actContext = actContext;
        this.products = products;
        this.cart = cart;
        inflater = (LayoutInflater.from(appContext));
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
        view = inflater.inflate(R.layout.item_product, null);
        TextView name = (TextView) view.findViewById(R.id.menu_text);
        TextView desc = (TextView) view.findViewById(R.id.menu_desc);
        TextView price = (TextView) view.findViewById(R.id.menu_price);
        ImageView icon = (ImageView) view.findViewById(R.id.menu_icon);
        Product product = products.get(i);

        name.setText(product.name);
        desc.setText(product.description);
        price.setText(product.price.toString() + "₺");
        int image_id = this.appContext.getResources().getIdentifier(product.image, "drawable", appContext.getPackageName());
        icon.setImageResource(image_id);

        ImageButton addtocart = (ImageButton) view.findViewById(R.id.add_to_cart);
        TextView quantity = (TextView) view.findViewById(R.id.menu_quantity);
        TextView noofproducts = (TextView) ((Activity) actContext).findViewById(R.id.number_of_products);
        ImageButton removefromcart = (ImageButton) view.findViewById(R.id.remove_from_cart);

        int quant = cart.products.getOrDefault(product, 0);
        if (quant > 1) {
            removefromcart.setVisibility(View.VISIBLE);
            quantity.setVisibility(View.VISIBLE);
            removefromcart.setImageResource(R.drawable.baseline_remove_24);
            addtocart.setImageResource(R.drawable.baseline_add_24);
            quantity.setText(Integer.toString(quant));
        }
        else if (quant == 1) {
            removefromcart.setVisibility(View.VISIBLE);
            removefromcart.setImageResource(R.drawable.outline_delete_24);
            quantity.setVisibility(View.VISIBLE);
            addtocart.setImageResource(R.drawable.baseline_add_24);
            quantity.setText(Integer.toString(quant));
        }
        addtocart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int curr_quantity = cart.products.getOrDefault(product, 0);
                if (curr_quantity == 0) {
                    cart.products.put(product, ++curr_quantity);
                    quantity.setVisibility(View.VISIBLE);
                    removefromcart.setVisibility(View.VISIBLE);
                    addtocart.setImageResource(R.drawable.baseline_add_24);
                }
                else {
                    cart.products.replace(product, ++curr_quantity);
                    removefromcart.setImageResource(R.drawable.baseline_remove_24);
                }
                quantity.setText(Integer.toString(curr_quantity));
                cart.noOfProducts++;
                noofproducts.setText(Integer.toString(cart.noOfProducts));
            }
        });

        removefromcart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int curr_quantity = cart.products.getOrDefault(product, 0);
                if (curr_quantity > 2) {
                    cart.products.replace(product, --curr_quantity);
                }
                else if (curr_quantity > 1) {
                    cart.products.replace(product, --curr_quantity);
                    removefromcart.setImageResource(R.drawable.outline_delete_24);
                }
                else {
                    cart.products.remove(product);
                    quantity.setVisibility(View.INVISIBLE);
                    removefromcart.setVisibility(View.INVISIBLE);
                    addtocart.setImageResource(R.drawable.baseline_add_shopping_cart_24);
                }
                quantity.setText(Integer.toString(curr_quantity));
                cart.noOfProducts--;
                noofproducts.setText(Integer.toString(cart.noOfProducts));
            }
        });

        return view;
    }
}

