package com.example.restfuldemo.controller;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import com.example.restfuldemo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ModelMapper modelMapper;


    private StudentService studentService;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudens();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
            Student student= studentService.getStudentById(id);

        return ResponseEntity.ok().body(student);
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student studentReq){
        Student student= studentService.createStudent(studentReq);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentReq){
        Student student= studentService.updateStudent(id,studentReq);

        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudents(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(String major){
        List<Student> students= studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/students/{id}/courses")
    public ResponseEntity<List<Course>> getStudentsById(int id){
        List<Course> course= studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(course);
    }
}
