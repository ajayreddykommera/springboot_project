package com.ajay.springbootproject.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    @NotNull(message = "technology should not be empty")
    private String technology;
    @NotNull(message = "vendor should not be empty")
    private String vendor;
    @NotNull(message = "email should not be empty")
    @Email(message = "must be an email ")
    private String email;
    @NotNull(message = "mobile should not be empty")
    @Size(min = 10,max = 10)
    private String mobile;
    @NotNull(message = "client should not be empty")
    private String client;
    private String implementation;
    @NotNull(message = "lead should not be empty")
    private String lead;
    @NotNull(message = "student should not be empty")
    private String student;
    @NotNull(message = "recruiter should not be empty")
    private String recruiter;
    @Positive(message = "pay rate should not be positive")
    private long payRate;
    @NotNull(message = "technology should not be empty")
    private Boolean submitted;

}
