package miu.edu.springdata.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class UserDto {
    String email;
    String password;
}
