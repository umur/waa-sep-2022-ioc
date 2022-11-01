package miu.edu.Lab02.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    List<Course> coursesTaken;
}
