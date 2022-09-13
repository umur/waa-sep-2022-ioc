package miu.edu.springdata.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer addressId;
    private String street;
    @Column(name = "zip")
    private Integer zipCode;
    private String city;


    @OneToOne(mappedBy = "address") //It will create foreign key to below object
    @JsonIgnore
    private User user;
}
