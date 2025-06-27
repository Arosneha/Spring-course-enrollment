package com.example.spring.and.springboot.mappers;

import com.example.spring.and.springboot.dto.CourseDto;
import com.example.spring.and.springboot.entities.Course;
import com.example.spring.and.springboot.entities.Mentor;
import com.example.spring.and.springboot.exceptions.NotFoundException;
import com.example.spring.and.springboot.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto) {
        Course course = new Course();
        Mentor mentor = this.mentorRepository.findById(dto.getMentorId()).orElseThrow(() ->  new NotFoundException("Cannot find mentor with ID: " + dto.getMentorId()));
        course.setName(dto.getName());
        course.setPrice(dto.getPrice());
        course.setCapacity(dto.getCapacity());
        course.setNoOfDays(dto.getNoOfDays());
        course.setStartDate(dto.getStartDate());
        course.setDescription(dto.getDescription());
        course.setMentor(mentor);
        course.setEnrolmentEndDate(dto.getEnrolmentEndDate());
        return course;
    }
}