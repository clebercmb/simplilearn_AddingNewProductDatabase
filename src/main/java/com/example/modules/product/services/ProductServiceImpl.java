package com.example.modules.product.services;

import com.example.modules.product.dao.ProductDao;
import com.example.modules.product.dao.ProductDaoImpl;
import com.example.modules.product.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements  ProductService{

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public Product add(Product product) {
        logger.debug("add: " + product);

        return productDao.add(product);
    }

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }
}
