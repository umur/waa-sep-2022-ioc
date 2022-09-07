package miu.edu.course.service;

import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;
import miu.edu.course.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> getStudents() {
        return studentRepo.getStudent();
    }

    @Override
    public Student save(Student student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public Student update() {
        return null;
    }

    @Override
    public Student delete() {
        return null;
    }

    @Override
    public Optional<Student> getStudent(Long id) {
       return studentRepo.findStudentById(id);

    }

    @Override
    public Student UpdateStudent(Long id, Student student) {
        return studentRepo.updateStudent(id, student);
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
