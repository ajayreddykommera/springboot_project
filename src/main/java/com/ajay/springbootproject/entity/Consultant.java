package com.ajay.springbootproject.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "consultants")
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long leadId;

}