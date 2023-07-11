package com.ajay.springbootproject.service;

import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;
    public Submission addSubmission(Submission submission) {

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmission() {
        return  submissionRepository.findAll();
    }

    public void deleteSubmission(int id) {
        submissionRepository.deleteById(id);
    }


    public Submission getSubmissionById(int id) {

        return submissionRepository.findById(id).get();
    }

    public List<Submission> getSubmissionByLeadAndTechnology(String lead, String technology) {
        return submissionRepository.findByLeadAndTechnology(lead,technology);
    }

    public Submission editSubmission(int id,Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        submission.setDate(submissionDetails.getDate());
        submission.setTechnology(submissionDetails.getTechnology());
        submission.setVendor(submissionDetails.getVendor());
        submission.setEmail(submissionDetails.getEmail());
        submission.setEmail(submissionDetails.getEmail());
        submission.setMobile(submission.getMobile());
        submission.setClient(submission.getClient());
        submission.setImplementation(submission.getImplementation());
        submission.setLead(submissionDetails.getLead());
        submission.setStudent(submissionDetails.getStudent());
        submission.setRecruiter(submissionDetails.getRecruiter());
        submission.setPayRate(submissionDetails.getPayRate());
        submission.setSubmitted(submissionDetails.getSubmitted());

        return submission;
    }
}

