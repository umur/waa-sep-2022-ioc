package miu.edu.springdata.Controller;

import miu.edu.springdata.Entity.Product;
import miu.edu.springdata.Entity.User;
import miu.edu.springdata.Service.Impl.ProductServiceImpl;
import miu.edu.springdata.Service.ProductService;
import miu.edu.springdata.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("src/")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/products")
    public List<Product> showAll(){
        return productService.findAll();
    }

//    @GetMapping("/products")
//    public List<Product> findProductsMoreThanMinPrice(Double minPrice){
//        return productService.findByMin(minPrice);
//    }

    @PostMapping("/products")
    public void save(@RequestBody Product p){
         productService.save(p);
    }

    @GetMapping("/products/{price}")
    public List<Product> findAllByProductPriceLessThan(@PathVariable Double price ){
        return productService.findAllByProductPriceLessThan(price);
    }

    @GetMapping("/products/id/{id}")
    public List<Product> findAllByProductId(@PathVariable Integer id){
        return productService.findAllByProductId(id);
    };

    @GetMapping("/products")
    public List<Product>findProductByProductNameContaining(@RequestParam String keyword){
        return productService.findProductByProductNameContaining(keyword);
    };

}
