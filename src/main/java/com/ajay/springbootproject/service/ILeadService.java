package com.ajay.springbootproject.service;

import com.ajay.springbootproject.entity.Lead;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILeadService {
    List<Lead> getAllLeads();

    Lead createLead(Lead lead);

    Lead getLeadById(Long id);

    String deleteLeadById(Long id);

    Lead editLead(Long id, Lead lead);
}
