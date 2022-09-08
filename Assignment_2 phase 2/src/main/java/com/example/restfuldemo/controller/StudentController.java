package com.example.restfuldemo.controller;

import com.example.restfuldemo.dto.CourseDto;
import com.example.restfuldemo.dto.StudentDto;
import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import com.example.restfuldemo.repo.StudentRepo;
import com.example.restfuldemo.service.StudentService;
import com.example.restfuldemo.service.StudentServicesImpl;
import lombok.RequiredArgsConstructor;
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
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudens().stream().map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());

    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id){
            Student student= studentService.getStudentById(id);

        StudentDto studentRes = modelMapper.map(student, StudentDto.class);

        return ResponseEntity.ok().body(studentRes);
    }


    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
        Student studentRequest=modelMapper.map(studentDto, Student.class);
        Student student= studentService.createStudent(studentRequest);

        StudentDto studentDtoRes=modelMapper.map(student, StudentDto.class);

        return new ResponseEntity<>(studentDtoRes, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto){
        Student studentReq= modelMapper.map(studentDto, Student.class);
        Student student= studentService.updateStudent(id,studentReq);

        StudentDto studentRes = modelMapper.map(student, StudentDto.class);

        return ResponseEntity.ok().body(studentRes);
    }

    @DeleteMapping("/{id}")
    public void deleteStudents(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{major}")
    public ResponseEntity<List<StudentDto>> getStudentsByMajor(String major){
        List<Student> students= studentService.getStudentsByMajor(major);
        List<StudentDto> studentsdto= Collections.singletonList(modelMapper.map(students, StudentDto.class));
        return ResponseEntity.ok().body(studentsdto);
    }

    @GetMapping("/students/{id}/courses")
    public ResponseEntity<List<CourseDto>> getStudentsById(int id){
        List<Course> course= studentService.getCoursesByStudentId(id);
        List<CourseDto> coursedto= Collections.singletonList(modelMapper.map(course, CourseDto.class));
        return ResponseEntity.ok().body(coursedto);
    }
}
