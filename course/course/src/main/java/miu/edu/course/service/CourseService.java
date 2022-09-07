package miu.edu.course.service;

import miu.edu.course.dto.CourseDTO;
import miu.edu.course.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    
    List<CourseDTO> getCourses();

    Optional<CourseDTO> getCourse(Long id);

    CourseDTO saveCourse(CourseDTO course);

    CourseDTO updateCourse(Long id, CourseDTO course);

    Optional<CourseDTO> deleteCourse(Long id);
}
