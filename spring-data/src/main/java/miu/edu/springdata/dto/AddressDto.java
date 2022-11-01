package miu.edu.springdata.dto;

import lombok.Data;

import javax.persistence.Id;
@Data
public class AddressDto {
    String City;
    Integer zipCode;
}
