package miu.edu.course.repo;

import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    public static List<Student> students = new ArrayList<>();
    public static int currentId = 4;


    static {
        Student student1 = new Student(1L,"zelalem","tsige","zelalembe10@gmail.com","compro",
                3.9, CourseRepo.courses);
        Student student2 = new Student(2L,"dagi","shiferaw","dagi10@gmail.com","cs",
                3.9, CourseRepo.courses);

        students.add(student1);
        students.add(student2);
    }

    public List<Student> getStudent(){
        return students;
    }

    public Student saveStudent(Student student){
        students.add(student);
        return student;
    }



    public Optional<Student> findStudentById(long id) {
        Optional<Student> course = students.stream()
                .filter(course1 -> course1.getId() == id)
                .findFirst();
        return course;
    }


    public Student updateStudent(Long id, Student student) {
        Optional<Student> student1 = findStudentById(id);
        int index =  students.indexOf(student1.get());
        students.set(index, student);
        return student;
    }

    public List<Student> getStudentByMajor(String major) {
        return students.stream()
                .filter(m -> m.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return students.stream()
                .filter(student1 -> student1.getId().equals(studentId))
                .flatMap(c -> c.getCoursesTaken().stream())
                .collect(Collectors.toList());

    }

    public Optional<Student> deleteStudent(Long id) {
        Optional<Student> student = findStudentById(id);
        int index =  students.indexOf(student.get());
        students.remove(index);
        return student;
    }

}
