package com.example.modules.product.services;

import com.example.modules.product.model.Product;

import java.util.List;

public interface ProductService {
    public Product add(Product product);

    public List<Product> list();

    public Product get(int id);

    public void delete(int id);
}
