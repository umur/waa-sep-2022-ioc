package edu.miu.lab1.basic;

@MyBean
public class ProductRepository {

    public String getProductName(String id) {
        return "Product-" + id;
    }
}
