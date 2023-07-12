package com.ajay.springbootproject;

import com.ajay.springbootproject.entity.Leads;
import com.ajay.springbootproject.entity.Submission;
import com.ajay.springbootproject.entity.Technologies;
import com.ajay.springbootproject.repository.SubmissionRepository;
import com.ajay.springbootproject.service.SubmissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringbootProjectApplicationTests {
	@Autowired
	private SubmissionRepository submissionRepository= Mockito.mock(SubmissionRepository.class);





	@Test
	void testPostSubmission(){
		var submission= Submission.builder()
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

		Submission savedSub=submissionRepository.save(submission);
		System.out.println(savedSub);
		Assertions.assertNotNull(savedSub);

	}

	@Test
	void testGetSubmissionById(){
		var submission= Submission.builder()
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
		Submission savedSub=submissionRepository.save(submission);
		Submission getSub=submissionRepository.findById(1).get();
		System.out.println(savedSub);
		System.out.println(getSub);
		assertEquals(submission.getId(),getSub.getId());


	}
	@Test
	void testGetAllSubmission(){
		var submission1= Submission.builder()
				.id(11)
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
		var submission2= Submission.builder()
				.id(12)
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
		submissionRepository.save(submission1);
		submissionRepository.save(submission2);
		List<Submission> savedSub=(List<Submission>)submissionRepository.findAll();
		System.out.println(savedSub);
		Assertions.assertNotNull(savedSub);
	}
	@Test
	void testDeleteSubmissionById(){
		var submission= Submission.builder()
				.id(11)
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
		Submission savedSub=submissionRepository.save(submission);
		submissionRepository.deleteById(11);
		Optional optional = submissionRepository.findById(submission.getId());
		assertEquals(Optional.empty(), optional);

	}

}
