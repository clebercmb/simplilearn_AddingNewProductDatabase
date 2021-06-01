package com.example.modules.product.dao;


import com.example.modules.product.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("productDao")
public class ProductDaoImpl implements  ProductDao {
    private static final Logger logger = LogManager.getLogger(ProductDaoImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Product add(Product p) {
        System.out.println("####add: " + p);
        logger.debug("add: " + p);
        Session session = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).openSession();

        session.beginTransaction();
        session.save(p);
        //Product newProduct = (Product) session.save(p);

        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public List<Product> list() {

        Session session = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).openSession();

        List<Product> productList = new ArrayList<>();
        // productList = hibernateTemplate.loadAll(Product.class);

        productList= session.createQuery("from Product", Product.class).list();

        session.close();

        return productList;

    }

    @Override
    public Product get(int id) {
        return (Product) hibernateTemplate.get(Product.class, id);

    }

    @Override
    public void delete(int productId) {

        // hibernateTemplate.delete(product);
        logger.debug("$$$*****delete: " + productId);
        System.out.println("$$$$*****delete: " + productId);


        Session session = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).openSession();


        session.beginTransaction();

        Product prod = session.load(Product.class, productId);
        session.delete(prod);

        //Product newProduct = (Product) session.save(p);

        session.getTransaction().commit();
        session.close();

    }


}
