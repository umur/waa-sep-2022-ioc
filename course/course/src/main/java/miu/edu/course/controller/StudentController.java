package miu.edu.course.controller;



import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;
import miu.edu.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> listOfStudent(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    Optional<Student> getOneStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    Student saveStudent(@RequestBody Student student){
       return studentService.save(student);
    }

    @PutMapping
    Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.UpdateStudent(id, student);
    }

    @GetMapping("/filter")
    List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    List<Course> getCoursesByStudentId(@PathVariable Long studentId){
        return studentService.getCoursesByStudentId(studentId);
    }




}
