package com.example.spring.and.springboot.service;


import com.example.spring.and.springboot.entities.Mentor;
import com.example.spring.and.springboot.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {
        return this.mentorRepository.save(mentor);
    }

}