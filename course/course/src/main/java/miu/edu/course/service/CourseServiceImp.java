package miu.edu.course.service;

import miu.edu.course.entity.Course;
import miu.edu.course.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{
    @Autowired
    CourseRepo courseRepo;
    @Override
    public List<Course> getCourses() {
        return courseRepo.getCourses();
    }

    @Override
    public Optional<Course> getCourse(Long id) {
        return courseRepo.getOneCourse(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.saveCourse(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return courseRepo.updateCourse(id, course);
    }

    @Override
    public Optional<Course> deleteCourse(Long id) {
        return courseRepo.deleteCourse(id);
    }
}
