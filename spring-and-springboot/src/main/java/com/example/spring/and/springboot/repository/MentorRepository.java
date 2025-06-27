package com.example.spring.and.springboot.repository;


import com.example.spring.and.springboot.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<
        Mentor, Long> {
}