package com.example.modules.product.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Product implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String name;
    private String category;
    private double price;


    public Product() {
    }

    public Product(int productID, String name, String category, double price) {
        super();
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
