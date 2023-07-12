package com.ajay.springbootproject.controller;


import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/submission")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @PostMapping
    public ResponseEntity<Submission> addSubmission(@RequestBody Submission submission){
        return ResponseEntity.status(HttpStatus.CREATED).body(submissionService.addSubmission(submission));

    }
    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmission(){
        return ResponseEntity.status(HttpStatus.OK).body(submissionService.getAllSubmission());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(submissionService.getSubmissionById(id));
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Submission>> getSubmissionByLeadAndTechnology(@RequestParam String lead, @RequestParam String technology){
        return ResponseEntity.status(HttpStatus.OK).body(submissionService.getSubmissionByLeadAndTechnology(lead,technology));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubmission(@PathVariable int id){
        submissionService.deleteSubmission(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted submission successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Submission> editSubmission(@PathVariable int id,@RequestBody Submission submission){
        return ResponseEntity.status(HttpStatus.OK).body(submissionService.editSubmission(id,submission));
    }
}
