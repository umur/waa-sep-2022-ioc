package miu.edu.springdata.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public void setProduct(List<Product> products){
        this.products = products;
        for (Product p:products) {
            p.setCategory(this);
        }
    }
}
