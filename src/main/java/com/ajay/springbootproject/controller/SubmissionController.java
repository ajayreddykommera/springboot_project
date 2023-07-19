package com.ajay.springbootproject.controller;

import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.service.ISubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private ISubmissionService submissionService;

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public Submission getSubmissionsById(@PathVariable Long id) {
        return submissionService.getSubmissionsById(id);
    }

    @PostMapping
    public Submission createSubmission(@RequestBody Submission submission) {
        return submissionService.createSubmission(submission);
    }

    @DeleteMapping("/{id}")
    public String deleteSubmissionById(@PathVariable Long id) {
        return submissionService.deleteSubmissionById(id);
    }

    @PutMapping("/{id}")
    public Submission editSubmissionById(@PathVariable Long id,@RequestBody Submission submission){
        return submissionService.editSubmissionById(id,submission);
    }
    @GetMapping("/filter")
    public List<Submission> getSubmissionsByLeadAndTechnology(@RequestParam Long leadId, @RequestParam String technology){
         return submissionService.getSubmissionsByLeadAndTechnology(leadId,technology);
    }
}
