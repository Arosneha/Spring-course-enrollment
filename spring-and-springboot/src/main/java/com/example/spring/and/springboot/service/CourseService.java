package com.example.spring.and.springboot.service;

import com.example.spring.and.springboot.entities.Course;
import com.example.spring.and.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(long courseId) {
        return this.courseRepository.findById(courseId).orElse(null);
    }
}