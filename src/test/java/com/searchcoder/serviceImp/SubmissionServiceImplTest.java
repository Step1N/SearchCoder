package com.searchcoder.serviceImp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

import com.searchcoder.datamodels.Submission;
import com.searchcoder.datamodels.SubmissionDAOImpl;
import com.searchcoder.expception.SearchCoderException;
import com.searchcoder.model.ModelMapper;
import com.searchcoder.model.SubmissionVOs;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:test-context.xml"})
@Configuration
public class SubmissionServiceImplTest {

	@Mock
	private SubmissionDAOImpl submissionDAOImpl;
	
	@Mock
	private ModelMapper mapper;

	@InjectMocks
	private SubmissionServiceImpl submissionService;

	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	 
	@Test
	public void testFetchSubmissions() throws SearchCoderException {
		List<Submission> vOs = new ArrayList<Submission>();
		vOs.addAll(getMockData());
		when(submissionDAOImpl.getSubmissions()).thenReturn(vOs);
		SubmissionVOs submissionVOs = submissionService.fetchSubmissions();
		assertNotNull(submissionVOs);
	}
	
	private List<Submission> getMockData(){
		
		List<Submission> daos = new ArrayList<Submission>();
		Submission submissionDAO = new Submission();
		submissionDAO.setSubmissionID(1);
		submissionDAO.setStatus("Accepted");
		submissionDAO.setMetadata("Meta data");
		submissionDAO.setLanguage("Java 7");
		daos.add(submissionDAO);
		
		return daos;
	}

}
