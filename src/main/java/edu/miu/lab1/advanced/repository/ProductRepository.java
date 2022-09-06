package edu.miu.lab1.advanced.repository;


import edu.miu.lab1.advanced.annotation.MyBean;

@MyBean
public class ProductRepository {

    public String getProductName(String id) {
        return "Product-" + id;
    }
}
