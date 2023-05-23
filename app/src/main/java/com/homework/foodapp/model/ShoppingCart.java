package com.homework.foodapp.model;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ShoppingCart implements Serializable {
    public Restaurant restaurant;
    public HashMap<Product, Integer> products = new HashMap<>();
    public int noOfProducts = 0;
    public Float totalCost;
}
