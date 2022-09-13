package miu.edu.springdata.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productRating;


    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    private Category category;


}
