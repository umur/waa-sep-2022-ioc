package edu.miu.lab1.basic;

@MyBean
public class ProductController {

    @MyAutowired
    private ProductService productService;

    public String getProductName(String id) {
        return productService.getProductName(id);
    }
}
