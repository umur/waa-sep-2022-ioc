package miu.edu.Lab02.Controller;

import lombok.RequiredArgsConstructor;
import miu.edu.Lab02.Entity.Course;
import miu.edu.Lab02.Entity.Student;
import miu.edu.Lab02.Service.StudentService;
import miu.edu.Lab02.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

//    @GetMapping("/{id}/course")
//    public List<Course> getCoursesByStudentId(int studentId){
//        return studentService.getCoursesByStudentId(studentId);
//    }
}
