package com.example.spring.and.springboot.repository;

import com.example.spring.and.springboot.entities.Course;
import com.example.spring.and.springboot.entities.Enrolment;
import com.example.spring.and.springboot.entities.Student;
import com.example.spring.and.springboot.enums.EnrolmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    long countByCourse(Course course);

    List<Enrolment> findByStudent(Student student);

    List<Enrolment> findByStudentAndStatus(Student student, EnrolmentStatus status);

    // write a function that takes studentId as param and find all the enrollments for that student
}