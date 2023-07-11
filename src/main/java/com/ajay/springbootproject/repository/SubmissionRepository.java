package com.ajay.springbootproject.repository;

import com.ajay.springbootproject.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
    List<Submission> findByLeadAndTechnology(String lead, String technology);
}

