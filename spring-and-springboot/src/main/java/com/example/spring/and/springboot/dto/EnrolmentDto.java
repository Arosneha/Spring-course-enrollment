package com.example.spring.and.springboot.dto;

import com.example.spring.and.springboot.enums.EnrolmentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EnrolmentDto {

    private long studentId;

    private long courseId;

    private LocalDateTime enrolmentDate;

    private EnrolmentStatus status = EnrolmentStatus.ACTIVE;
}