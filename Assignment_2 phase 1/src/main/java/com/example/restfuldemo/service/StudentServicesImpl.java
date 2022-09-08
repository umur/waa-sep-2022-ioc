package com.example.restfuldemo.service;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import com.example.restfuldemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServicesImpl implements StudentService {

//    @Autowired
    private StudentRepo studentRepo;

    public StudentServicesImpl(StudentRepo studentRepo) {
        super();
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudens() {
        return studentRepo.getStudents();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.addStudent(student);
    }

    @Override
    public Student updateStudent(int id, Student studentRequest) {
           Student student=studentRepo.getStudent(id);
           student.setGpa(studentRequest.getGpa());
           student.setFirstName(studentRequest.getFirstName());
           student.setLastName(studentRequest.getLastName());
           student.setEmailId(studentRequest.getEmailId());
           student.setMajor(studentRequest.getMajor());
           student.setGpa(studentRequest.getGpa());
           student.setCoursesTaken(studentRequest.getCoursesTaken());

           return studentRepo.addStudentById(id,student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deletStudent(id);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.getStudent(id);
    }
    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
