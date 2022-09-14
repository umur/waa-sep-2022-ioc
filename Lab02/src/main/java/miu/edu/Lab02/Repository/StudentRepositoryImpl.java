package miu.edu.Lab02.Repository;

import miu.edu.Lab02.Entity.Course;
import miu.edu.Lab02.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private static List<Student> students = new ArrayList<>();
    static {
        Course c1 = new Course(1,"WAA",545);
        Course c2 = new Course(2,"MWA",539);
        Course c3 = new Course(3,"WAP",430);
        Student s1 = new Student(1,"Hamida","Maqsoudi","maqsoudih@gmail.com","Software",4.3,new ArrayList<>(Arrays.asList(c1,c2,c3)));
        Student s2 = new Student(2,"Mekdes","Teffera","mtefera@gmail.com","IT",3.5,new ArrayList<>(Arrays.asList(c1,c2)));
        Student s3 = new Student(3,"Hiwot","Reta","hReta@gmail.com","IT",3.8,new ArrayList<>(Arrays.asList(c1,c2)));
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        List<Student> studentByMajor = students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
        return studentByMajor;
    }

//    @Override
//    public List<Course> getCoursesByStudentId(int studentId) {
//        List<Course> courses = students.stream()
//
//        return null;
//    }
}
