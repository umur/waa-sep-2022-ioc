package miu.edu.course.controller;

import miu.edu.course.dto.CourseDTO;
import miu.edu.course.entity.Course;
import miu.edu.course.service.CourseService;
import org.modelmapper.ModelMapper;
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
    List<CourseDTO> listOfCourse(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    Optional<CourseDTO> getOneCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    CourseDTO saveCourse(@RequestBody CourseDTO course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    CourseDTO UpdateCourse(@PathVariable Long id, @RequestBody CourseDTO course){
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    Optional<CourseDTO> deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }
}
