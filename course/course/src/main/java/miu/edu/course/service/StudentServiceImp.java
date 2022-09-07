package miu.edu.course.service;

import miu.edu.course.dto.CourseDTO;
import miu.edu.course.dto.StudentDTO;
import miu.edu.course.entity.Course;
import miu.edu.course.entity.Student;
import miu.edu.course.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<StudentDTO> getStudents() {
        List<Student> studentList = studentRepo.getStudent();
        return studentList.stream()
                .map(student -> new StudentDTO(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),
                student.getMajor(),student.getGpa(),student.getCoursesTaken()))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        var studentDtoToStudent = modelMapper.map(studentDTO, Student.class);
         studentRepo.saveStudent(studentDtoToStudent);
         return studentDTO;
    }


    @Override
    public Optional<StudentDTO> getStudent(Long id) {
        var student = studentRepo.findStudentById(id);
        var convertToStudentDTO = modelMapper.map(student, StudentDTO.class);

        return Optional.ofNullable(convertToStudentDTO);

    }

    @Override
    public StudentDTO UpdateStudent(Long id, StudentDTO studentDTO) {
        var convertDtoToStudent = modelMapper.map(studentDTO, Student.class);
         studentRepo.updateStudent(id, convertDtoToStudent);
        return studentDTO;
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
