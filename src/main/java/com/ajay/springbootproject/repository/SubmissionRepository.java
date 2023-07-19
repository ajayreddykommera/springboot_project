package com.ajay.springbootproject.repository;

import com.ajay.springbootproject.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {

    @Query("SELECT s FROM Submission s JOIN Consultant c on s.consultantId = c.id JOIN Lead l ON c.leadId=l.id WHERE l.id = 1 AND s.technology = 'java'")
    List<Submission> findByLeadIdAndTechnology();
}

