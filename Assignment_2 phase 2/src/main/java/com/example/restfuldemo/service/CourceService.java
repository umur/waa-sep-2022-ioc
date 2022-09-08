package com.example.restfuldemo.service;

import com.example.restfuldemo.entity.Course;

import java.util.List;

public interface CourceService {
    List<Course> getAllCource();

    Course createCource(Course student);

    Course updateCourse(int id, Course student);

    void deleteCource(int id);

    Course getCourseById(int id);

    Course addCourseById(int id, Course course);
}
