package com.example.restfuldemo.service;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import com.example.restfuldemo.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourceServiceImp implements CourceService{
    @Autowired
    private CourseRepo courseRepo;


    @Override
    public List<Course> getAllCource() {
        return courseRepo.getAllCource();
    }

    @Override
    public Course createCource(Course c) {
        return courseRepo.CreateCource(c);
    }

    @Override
    public Course updateCourse(int id, Course courseReq) {
        Course course=courseRepo.getCourseById(id);
        course.setId(courseReq.getId());
        course.setName(courseReq.getName());
        course.setCode(courseReq.getCode());

        return courseRepo.addCourseById(id,course);
    }

    @Override
    public void deleteCource(int id) {
        courseRepo.deleteCource(id);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public Course addCourseById(int id, Course course) {
        return courseRepo.addCourseById(id,course);
    }
}
