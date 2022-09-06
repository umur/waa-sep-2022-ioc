package edu.miu.lab1.advanced.controller;


import edu.miu.lab1.advanced.annotation.MyAutowired;
import edu.miu.lab1.advanced.annotation.MyBean;
import edu.miu.lab1.advanced.service.ProductService;
import edu.miu.lab1.advanced.service.special.SpecialProductService;

@MyBean
public class ProductController {

    @MyAutowired
    private ProductService productService;

    @MyAutowired
    private SpecialProductService specialProductService;

    public String getProductName(String id) {
        return productService.getProductName(id);
    }

    public String getSpecialProductName(String id) {
        return specialProductService.getSpecialProductName(id);
    }
}
