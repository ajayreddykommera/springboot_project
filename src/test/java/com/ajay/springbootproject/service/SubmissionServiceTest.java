package com.ajay.springbootproject.service;

import com.ajay.springbootproject.entity.Leads;
import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.entity.Technologies;
import com.ajay.springbootproject.repository.SubmissionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

class SubmissionServiceTest {

    @Mock
    private SubmissionRepository submissionRepository;
    @InjectMocks
    private SubmissionService submissionService;
    AutoCloseable autoCloseable;
    Submission submission;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
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

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testAddSubmission() {
        when(submissionRepository.save(submission)).thenReturn(submission);
        assertThat(submissionService.addSubmission(submission)).isEqualTo(submission);

    }

    @Test
    void testGetAllSubmission() {
        when(submissionRepository.findAll()).thenReturn(List.of(submission) );
        List<Submission> submissionList = submissionService.getAllSubmission();
        assertThat(submissionList).isNotNull();
        assertThat(submissionList.size()).isEqualTo(1);
    }

    @Test
    void testDeleteSubmission() {
        willDoNothing().given(submissionRepository).deleteById(1);
        submissionService.deleteSubmission(1);
        verify(submissionRepository,times(1)).deleteById(1);

    }

    @Test
    void testGetSubmissionById() {
        when(submissionRepository.findById(1)).thenReturn(Optional.ofNullable(submission));
        assertThat(submissionService.getSubmissionById(1)).isEqualTo(submission);
        assertThat(submissionService.getSubmissionById(1).getId()).isEqualTo(1);
    }

    @Test
    void getSubmissionByLeadAndTechnology() {
    }

    @Test
    void editSubmission() {
        when(submissionRepository.save(submission)).thenReturn(submission);

        submission.setPayRate(100);
        Submission updatedSubmission=submissionService.editSubmission(1,submission);
        assertThat(updatedSubmission.getPayRate()).isEqualTo(100);

    }
}