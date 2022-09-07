package miu.edu.course.service;

import miu.edu.course.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    
    List<Course> getCourses();

    Optional<Course> getCourse(Long id);

    Course saveCourse(Course course);

    Course updateCourse(Long id, Course course);

    Optional<Course> deleteCourse(Long id);
}
