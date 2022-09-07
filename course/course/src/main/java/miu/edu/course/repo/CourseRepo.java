package miu.edu.course.repo;

import miu.edu.course.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    public static List<Course> courses = new ArrayList<>();
    public static int currentId = 4;


    static {
        Course course1 = new Course(1,"modern programing","MPP");
        Course course2 = new Course(2,"enterprise architecture","EA");
        Course course3 = new Course(3,"web application architecture","WAA");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Optional<Course> getOneCourse(long id) {
       Optional<Course> course = courses.stream()
               .filter(course1 -> course1.getId() == id)
               .findFirst();
       return course;
    }

    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(Long id, Course course) {
        Optional<Course> course1 = getOneCourse(id);
        int index =  courses.indexOf(course1.get());
        courses.set(index, course);
        return course;
    }


    public Optional<Course> deleteCourse(Long id) {
        Optional<Course> course = getOneCourse(id);
        int index =  courses.indexOf(course.get());
        courses.remove(index);
        return course;
    }
}
