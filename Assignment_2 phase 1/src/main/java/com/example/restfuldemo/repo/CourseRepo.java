package com.example.restfuldemo.repo;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses= new ArrayList<>();
    static  {
        Course c1 = new Course(1,"WAA",545);
        Course c2 = new Course(2,"WAp",472);
        courses.add(c1);
        courses.add(c2);

    }
    public List<Course> getAllCource() {
        return courses;
    }

    public void deleteCource(int id) {

        courses.stream()
                .filter(c -> c.getId() == id)
                .forEach( c -> courses.remove(c));
    }
    public Course getCourseById(int id) {
        return courses.stream()
                .filter( c -> c.getId()==id)
                .findFirst()
                .orElse(null);
    }
    public Course addCourseById(int id, Course course){
        courses.add(id, course);
        return courses.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }


    public Course CreateCource(Course c) {
        var checkIfCourseExists = courses
                .stream()
                .noneMatch(l -> l.getId() == c.getId());
        if(checkIfCourseExists){
            courses.add(c);
        }
        return c;
    }
}
