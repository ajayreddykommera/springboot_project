package com.ajay.springbootproject.service.ServiceImpl;

import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.repository.SubmissionRepository;
import com.ajay.springbootproject.service.IConsultantService;
import com.ajay.springbootproject.service.ISubmissionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubmissionService implements ISubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;


    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Submission getSubmissionsById(Long id) {
        return submissionRepository.findById(id).get();
    }

    @Override
    public String deleteSubmissionById(Long id) {
         submissionRepository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public Submission editSubmissionById(Long id, Submission submissionDetails) {
        Submission submission=submissionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Submission not found"));
        submission.setConsultantId(submissionDetails.getConsultantId());
        submission.setSubmissionDate(submissionDetails.getSubmissionDate());
        submission.setVendorCompany(submissionDetails.getVendorCompany());
        submission.setVendorName(submissionDetails.getVendorName());
        submission.setVendorEmailAddress(submissionDetails.getVendorEmailAddress());
        submission.setVendorPhoneNumber(submissionDetails.getVendorPhoneNumber());
        submission.setImplementationPartner(submissionDetails.getImplementationPartner());
        submission.setClientName(submissionDetails.getClientName());
        submission.setPayRate(submissionDetails.getPayRate());
        submission.setSubmissionStatus(submissionDetails.getSubmissionStatus());
        submission.setSubmissionType(submissionDetails.getSubmissionType());
        submission.setCity(submissionDetails.getCity());
        submission.setState(submissionDetails.getState());
        submission.setZip(submissionDetails.getZip());
        submission.setTechnology(submissionDetails.getTechnology());

        return submissionRepository.save(submission);
    }

    @Override

    public List<Submission> getSubmissionsByLeadAndTechnology(Long leadId, String technology) {
        return submissionRepository.findByLeadIdAndTechnology();
    }
}
