package com.ajay.springbootproject.repository;

import com.ajay.springbootproject.entity.Leads;
import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.entity.Technologies;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SubmissionRepositoryTest {
    @Autowired
    private SubmissionRepository submissionRepository;

    Submission submission;

    @BeforeEach
    void setUp(){
         submission= Submission.builder()
                .id(1)
                .lead(Leads.vinay)
                .technology(Technologies.java)
                .date("12/13/2022")
                .email("ajay@ajay.com")
                .client("JPMC")
                .mobile("1234567890")
                .payRate(76)
                .implementation("deloite")
                .student("ajay")
                .recruiter("sai")
                .submitted(true)
                .vendor("nytho info")
                .build();

        submissionRepository.save(submission);

    }
    @AfterEach
    void tearDown(){
        submission=null;
        submissionRepository.deleteAll();
    }

    @Test
    public void testGetAllSubmissions_found(){

        List<Submission> submissionList=submissionRepository.findAll();
        System.out.println(submissionList.get(0));
        assertThat(submissionList.get(0).getTechnology()).isEqualTo(submission.getTechnology());

    }
}
