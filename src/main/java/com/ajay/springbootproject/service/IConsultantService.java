package com.ajay.springbootproject.service;

import com.ajay.springbootproject.entity.Consultant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConsultantService {
    List<Consultant> getAllConsultants();

    Consultant getAllConsultantsById(Long id);

    Consultant createConsultant(Consultant consultant);

    String deleteConsultantById(Long id);

    Consultant editConsultant(Long id, Consultant consultant);
}
