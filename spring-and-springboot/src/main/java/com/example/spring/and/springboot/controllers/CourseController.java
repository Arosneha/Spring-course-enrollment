package com.example.spring.and.springboot.controllers;

import com.example.spring.and.springboot.dto.CourseDto;
import com.example.spring.and.springboot.entities.Course;
import com.example.spring.and.springboot.mappers.CourseMapper;
import com.example.spring.and.springboot.service.CourseService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto) {
        Course course = this.courseMapper.mapToModel(courseDto);
        return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
    }
}