package miu.edu.Lab02.Service;

import miu.edu.Lab02.Entity.Course;
import miu.edu.Lab02.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

     List<Student> findAll();
     List<Student> getStudentsByMajor(String major);
//     List<Course> getCoursesByStudentId(int studentId);


}
