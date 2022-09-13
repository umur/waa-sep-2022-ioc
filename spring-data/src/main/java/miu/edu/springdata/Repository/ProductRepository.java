package miu.edu.springdata.Repository;

import miu.edu.springdata.Entity.Product;
import miu.edu.springdata.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    List<Product> findAll();

    List<Product> findAllByPriceGreaterThan(Double minPrice);
    List<Product> findAllByProductPriceLessThan(Double maxPrice);
    List<Product> findAllByProductId(Integer id);

    List<Product> findProductByProductNameContaining(String keyword);


}
