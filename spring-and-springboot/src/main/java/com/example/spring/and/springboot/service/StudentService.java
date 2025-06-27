package com.example.spring.and.springboot.service;

import com.example.spring.and.springboot.repository.StudentRepository;
import com.example.spring.and.springboot.entities.Student;
import com.example.spring.and.springboot.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentById(long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);
        return optionalValue.orElseThrow(() -> new NotFoundException("Student with ID: " + studentId + " was not found."));
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }
}