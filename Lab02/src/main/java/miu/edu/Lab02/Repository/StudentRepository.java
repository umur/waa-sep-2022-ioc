package miu.edu.Lab02.Repository;

import miu.edu.Lab02.Entity.Course;
import miu.edu.Lab02.Entity.Student;
import miu.edu.Lab02.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository {

     List<Student> findAll();
     List<Student> getStudentsByMajor(String major);
//    List<Course> getCoursesByStudentId(int studentId);

}
