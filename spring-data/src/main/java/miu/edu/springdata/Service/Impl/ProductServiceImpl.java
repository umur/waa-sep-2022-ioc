package miu.edu.springdata.Service.Impl;

import miu.edu.springdata.Entity.Product;
import miu.edu.springdata.Repository.ProductRepository;
import miu.edu.springdata.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }


//    public List<Product> findByMin(Double minPrice){
//        return productRepository.findAllByPriceGreaterThan(minPrice);
//    }

    public Product save(Product p){
        return productRepository.save(p);
    }

    public  List<Product> findAllByProductPriceLessThan(Double maxPrice){
        return productRepository.findAllByProductPriceLessThan(maxPrice);
    }

    public List<Product> findAllByProductId(Integer id){
        return productRepository.findAllByProductId(id);
    };

    public List<Product> findProductByProductNameContaining(String keyword){
        return productRepository.findProductByProductNameContaining(keyword);
    };


}
