package edu.miu.lab1.advanced;

import edu.miu.lab1.advanced.annotation.MyComponentScan;
import edu.miu.lab1.advanced.controller.ProductController;
import edu.miu.lab1.advanced.injection.MyInjector;


@MyComponentScan("edu.miu.lab1.advanced")
public class DIApplication {

    public static void main(String[] args) {
        MyInjector.initialize(DIApplication.class);
        ProductController productController = (ProductController) MyInjector.getBean(ProductController.class);
        System.out.println(productController.getProductName("1"));
        System.out.println(productController.getSpecialProductName("2"));
    }
}
