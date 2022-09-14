package miu.edu.Lab02.Service;

import miu.edu.Lab02.Entity.Course;
import miu.edu.Lab02.Entity.Student;
import miu.edu.Lab02.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

//    @Override
//    public List<Course> getCoursesByStudentId(int studentId) {
//        return studentRepository.getCoursesByStudentId(studentId);
//    }


}
