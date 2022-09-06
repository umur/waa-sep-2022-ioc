package edu.miu.lab1.advanced.service;


import edu.miu.lab1.advanced.annotation.MyAutowired;
import edu.miu.lab1.advanced.annotation.MyBean;
import edu.miu.lab1.advanced.repository.ProductRepository;

@MyBean
public class ProductService {

    @MyAutowired
    private ProductRepository productRepository;

    public String getProductName(String id) {
        return this.productRepository.getProductName(id);
    }
}
