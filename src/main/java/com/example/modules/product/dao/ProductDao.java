package com.example.modules.product.dao;

import com.example.modules.product.model.Product;

import java.util.List;

public interface ProductDao {

    public Product add(Product product);

    public List<Product> list();

    public Product get(int id);

    public void delete(int product);

}
