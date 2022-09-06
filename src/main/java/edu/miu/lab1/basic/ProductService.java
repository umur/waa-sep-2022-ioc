package edu.miu.lab1.basic;

@MyBean
public class ProductService {

    @MyAutowired
    private ProductRepository productRepository;

    public String getProductName(String id) {
        return this.productRepository.getProductName(id);
    }
}
