package miu.edu.course.service;

import miu.edu.course.dto.CourseDTO;
import miu.edu.course.entity.Course;
import miu.edu.course.repo.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements CourseService{
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<CourseDTO> getCourses() {
        var listOfCourse = courseRepo.getCourses();

      return listOfCourse.stream()
                .map(dto -> new CourseDTO(dto.getId(), dto.getCode(), dto.getName())).toList();
    }


    @Override
    public Optional<CourseDTO> getCourse(Long id) {
        var course = courseRepo.getOneCourse(id);
        var convertedCourse = modelMapper.map(course, CourseDTO.class);

        return Optional.ofNullable(convertedCourse);
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {

        var convertedCourse = modelMapper.map(courseDTO, Course.class);
        courseRepo.saveCourse(convertedCourse);
        return courseDTO;
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        var convertToCourse = modelMapper.map(courseDTO, Course.class);
        courseRepo.updateCourse(id, convertToCourse);
        return courseDTO;
    }

    @Override
    public Optional<CourseDTO> deleteCourse(Long id) {
        var course = courseRepo.getOneCourse(id);
        var convertedCourse = modelMapper.map(course, CourseDTO.class);
        courseRepo.deleteCourse(id);
        return Optional.ofNullable(convertedCourse);
    }
}
