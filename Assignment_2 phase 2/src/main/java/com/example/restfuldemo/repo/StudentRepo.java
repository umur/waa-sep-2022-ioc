package com.example.restfuldemo.repo;

import com.example.restfuldemo.entity.Course;
import com.example.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students=new ArrayList<>();

    private static int currentId =2;

    static {


        Student p1=new Student(1,"Afist","Alast","AemailId","Amajor",3.95);
        Student p2=new Student(2,"Bfist","Blast","BemailId","Bmajor",3.95);


        students.add(p1);
        students.add(p2);
    }

    public Student addStudent(Student student){
        student.setId(currentId++);
        students.add(student);

        return student;
    }
    public Student addStudentById(int id, Student student){
        students.add(id, student);
        return student;
    }



    public List<Student> getStudents(){
        return students;
    }

    public Student getStudent(int id){
        return students.stream()
                .filter( c -> c.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void deletStudent(int id){
        students.stream()
                .filter(c -> c.getId() == id)
                .forEach( c -> students.remove(c));
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter( s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.stream()
                .filter( s -> s.getId() == id)
                .findFirst().orElse(null).getCoursesTaken();

    }

}
