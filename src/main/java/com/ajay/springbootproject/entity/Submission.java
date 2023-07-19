package com.ajay.springbootproject.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "submissions")
@Data

public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long consultantId;
    @Column( columnDefinition = "DATE")
    @NotNull
    private LocalDate submissionDate;

    private String vendorCompany;

    private String vendorName;

    private String vendorEmailAddress;

    private String vendorPhoneNumber;

    private String implementationPartner;

    private String clientName;

    private BigDecimal payRate;

    private String submissionStatus;

    private String submissionType;

    private String city;

    private String state;

    private String zip;

    private String technology;

}
