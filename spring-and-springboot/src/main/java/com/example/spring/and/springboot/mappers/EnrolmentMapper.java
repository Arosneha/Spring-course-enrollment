package com.example.spring.and.springboot.mappers;

import com.example.spring.and.springboot.dto.EnrolmentDto;
import com.example.spring.and.springboot.entities.Course;
import com.example.spring.and.springboot.entities.Enrolment;
import com.example.spring.and.springboot.entities.Student;
import com.example.spring.and.springboot.exceptions.NotFoundException;
import com.example.spring.and.springboot.repository.CourseRepository;
import com.example.spring.and.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrolmentMapper {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrolmentMapper(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrolment mapToModel(EnrolmentDto dto) {
        Student student = this.studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException("Student with ID: " + dto.getStudentId() + " doesn't exist"));
        Course course = this.courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course with ID: " + dto.getCourseId() + " doesn't exist"));
        Enrolment enrolment = new Enrolment();
        enrolment.setCourse(course);
        enrolment.setStudent(student);
        enrolment.setEnrolmentDate(dto.getEnrolmentDate());
        enrolment.setStatus(dto.getStatus());
        return enrolment;

    }
}

