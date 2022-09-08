package com.example.restfuldemo.service;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudens();

    Student createStudent(Student student);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);

}
