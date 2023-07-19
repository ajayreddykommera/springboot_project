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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private String updateText;
    @Column( columnDefinition = "DATE")
    @NotNull
    private LocalDateTime createdDate;
}
