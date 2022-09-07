package miu.edu.course.controller;

import miu.edu.course.entity.Course;
import miu.edu.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping
    List<Course> listOfCourse(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    Optional<Course> getOneCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    Course UpdateCourse(@PathVariable Long id, @RequestBody Course course){
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    Optional<Course> deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }
}
