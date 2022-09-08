package miu.edu.course.service;

import miu.edu.course.dto.CourseDTO;
import miu.edu.course.dto.StudentDTO;
import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> getStudents();
    StudentDTO save(StudentDTO student);

    Optional<StudentDTO> getStudent(Long id);

    StudentDTO UpdateStudent(Long id, StudentDTO student);

    List<Student> getStudentByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);

    Optional<Student> deleteStudent(Long id);
}
