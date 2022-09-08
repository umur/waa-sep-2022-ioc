package com.example.restfuldemo.controller;

import com.example.restfuldemo.dto.CourseDto;
import com.example.restfuldemo.dto.StudentDto;
import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import com.example.restfuldemo.repo.CourseRepo;
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
    public List<CourseDto> getAllCource() {
        return courceService.getAllCource().stream().map(s -> modelMapper.map(s, CourseDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourceById(@PathVariable int id) {
        Course course = courceService.getCourseById(id);
        CourseDto courseDto = modelMapper.map(course, CourseDto.class);

        return ResponseEntity.ok().body(courseDto);
    }

    @PostMapping
    public ResponseEntity<CourseDto> addCource(@RequestBody CourseDto courseDto) {
        Course courseReq = modelMapper.map(courseDto, Course.class);

        Course course = courceService.createCource(courseReq);

        CourseDto courseDtores = modelMapper.map(course, CourseDto.class);

        return ResponseEntity.ok().body(courseDtores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable int id, @RequestBody CourseDto courseDto) {
        Course courseReq = modelMapper.map(courseDto, Course.class);
        Course course = courceService.updateCourse(id, courseReq);
        CourseDto courceRes = modelMapper.map(course, CourseDto.class);

        return ResponseEntity.ok().body(courseDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCource(@PathVariable int id){
        courceService.deleteCource(id);
    }

}
