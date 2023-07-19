package com.ajay.springbootproject.service;

import com.ajay.springbootproject.entity.Submission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISubmissionService {
    List<Submission> getAllSubmissions();

    Submission createSubmission(Submission submission);

    Submission getSubmissionsById(Long id);

    String deleteSubmissionById(Long id);

    Submission editSubmissionById(Long id, Submission submission);

    List<Submission> getSubmissionsByLeadAndTechnology(Long lead, String technology);
}
