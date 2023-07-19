package com.ajay.springbootproject.service.ServiceImpl;

import com.ajay.springbootproject.entity.Lead;
import com.ajay.springbootproject.repository.LeadRepository;
import com.ajay.springbootproject.service.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LeadService implements ILeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).get();
    }

    @Override
    public String deleteLeadById(Long id) {
        leadRepository.deleteById(id);
        return "deleted Successfully";
    }

    @Override
    public Lead editLead(Long id, Lead leadDetails) {
        Lead lead = leadRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Lead not found"));
        lead.setFirstName(leadDetails.getFirstName());
        lead.setLastName(leadDetails.getLastName());
        lead.setEmail(leadDetails.getEmail());
        lead.setPhone(leadDetails.getPhone());
        leadRepository.save(lead);
        return lead;
    }


}
