package com.homework.foodapp.model;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {
    public String id;
    public String name;
    public String openhours;
    public String image;
    public List<Product> menu;
}
