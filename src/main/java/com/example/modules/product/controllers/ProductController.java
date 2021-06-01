package com.example.modules.product.controllers;

import com.example.modules.product.dao.ProductDaoImpl;
import com.example.modules.product.model.Product;
import com.example.modules.product.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.RequestDispatcher;
import java.util.List;

@Controller
public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);


    @Autowired
    private ProductService productService;

    @RequestMapping("dashboard")  // default GET
    public String showDashboard(Model model) {
        System.out.println("dashboard");
        List<Product> productList = productService.list();

        model.addAttribute("products", productList);

        return "dashboard";
    }

    @RequestMapping("registerProduct")  // default GET
    public String showRegisterProduct(Model model) {
        System.out.println("Register Product");
        model.addAttribute("productCommand", new Product());
        return "registerProduct";
    }


    @RequestMapping(value="addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productCommand") Product product, ModelMap map) {
        System.out.println("addProduct: " + product);
        map.addAttribute("product", product);

        productService.add(product);

        return "success";
    }


    @RequestMapping("deleteProduct")  // default GET
    public String deletePProduct(@RequestParam String id) {
        logger.debug("deletePProduct");
        logger.debug("%%%% id=" + id);

        //Product product = productService.get(Integer.parseInt(id));

        logger.debug("%%%% deletePProduct.product="+id);
        productService.delete(Integer.parseInt(id));

        return "redirect:/dashboard";
    }




}
