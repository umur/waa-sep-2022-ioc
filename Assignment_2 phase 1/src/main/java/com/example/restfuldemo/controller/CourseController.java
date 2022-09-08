package com.example.restfuldemo.controller;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.service.CourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourceService courceService;

    @GetMapping
    public List<Course> getAllCource() {
        return courceService.getAllCource();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourceById(@PathVariable int id) {
        Course course = courceService.getCourseById(id);
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<Course> addCource(@RequestBody Course courseReq) {
        Course course = courceService.createCource(courseReq);
        return ResponseEntity.ok().body(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course courseReq) {
        Course course = courceService.updateCourse(id, courseReq);
        return ResponseEntity.ok().body(course);
    }
    @DeleteMapping("/{id}")
    public void deleteCource(@PathVariable int id){
        courceService.deleteCource(id);
    }

}
