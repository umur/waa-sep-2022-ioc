package miu.edu.course.service;

import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getStudents();
    Student save(Student student);
    Student update();
    Student delete();

    Optional<Student> getStudent(Long id);

    Student UpdateStudent(Long id, Student student);

    List<Student> getStudentByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);
}
