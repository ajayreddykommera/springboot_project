package com.ajay.springbootproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "submission_update")
@Data
public class SubmissionUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long submissionId;
    private String updateText;
    @Column( columnDefinition = "DATE")
    private LocalDateTime createdDate;
}
