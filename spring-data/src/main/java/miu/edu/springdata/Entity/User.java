package miu.edu.springdata.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer userId;
    @Column(name="name")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    private String password;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

//    @OneToMany(mappedBy = "user")
//    private List<Review> reviewList;


}
