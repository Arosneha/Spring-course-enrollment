package com.example.spring.and.springboot.controllers;

import com.example.spring.and.springboot.dto.EnrolmentDto;
import com.example.spring.and.springboot.entities.Enrolment;
import com.example.spring.and.springboot.mappers.EnrolmentMapper;
import com.example.spring.and.springboot.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;
    private final EnrolmentMapper enrolmentMapper;

    @Autowired
    public EnrolmentController(EnrolmentService enrolmentService, EnrolmentMapper enrolmentMapper) {
        this.enrolmentService = enrolmentService;
        this.enrolmentMapper = enrolmentMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrolment(@RequestBody EnrolmentDto enrolmentDto) {
        Enrolment enrolment = this.enrolmentMapper.mapToModel(enrolmentDto);
        return new ResponseEntity<>(this.enrolmentService.addEnrolment(enrolment), HttpStatus.CREATED);
    }
}