package edu.miu.lab1.basic;

public class MyIOCApplication {
    public static void main( String[] args ) {
        ProductController productController = (ProductController) MyInjector.getBean(ProductController.class);
        System.out.println(productController.getProductName("1"));
    }
}
