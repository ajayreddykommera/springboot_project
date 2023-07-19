package com.ajay.springbootproject.service.ServiceImpl;

import com.ajay.springbootproject.entity.Consultant;
import com.ajay.springbootproject.repository.ConsultantRepository;
import com.ajay.springbootproject.service.IConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultantService implements IConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;
    @Override
    public List<Consultant> getAllConsultants() {
        return consultantRepository.findAll();
    }

    @Override
    public Consultant getAllConsultantsById(Long id) {
        return consultantRepository.findById(id).get();
    }

    @Override
    public Consultant createConsultant(Consultant consultant) {
        return consultantRepository.save(consultant);
    }

    @Override
    public String deleteConsultantById(Long id) {
        consultantRepository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public Consultant editConsultant(Long id, Consultant consultantDetails) {
        Consultant consultant=consultantRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Consultant not found"));
        consultant.setFirstName(consultantDetails.getFirstName());
        consultant.setLastName(consultantDetails.getLastName());
        consultant.setEmail(consultantDetails.getEmail());
        consultant.setPhone(consultantDetails.getPhone());
        consultant.setLeadId(consultantDetails.getLeadId());
        return consultantRepository.save(consultant);
    }
}
