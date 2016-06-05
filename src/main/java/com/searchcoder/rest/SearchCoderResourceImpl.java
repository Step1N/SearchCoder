package com.searchcoder.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.searchcoder.expception.SearchCoderException;
import com.searchcoder.model.SubmissionFilterVO;
import com.searchcoder.model.SubmissionSearchVO;
import com.searchcoder.model.SubmissionVOs;
import com.searchcoder.serviceImp.SubmissionService;


@Controller
@Path("/coder")
public class SearchCoderResourceImpl implements SearchCoderResource{

	@Autowired
	SubmissionService submissionService;
	
	@Path("/submissions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SubmissionVOs fetchSubmissions() throws SearchCoderException{
		
		return submissionService.fetchSubmissions();
	}

	@Path("/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SubmissionVOs SearchSubmissions(@QueryParam(value="name") String name, 
			@QueryParam(value="value") String value,
			@QueryParam(value="pageNumber") int pageNumber,
			@QueryParam(value="pageSize") int pageSize)
			throws SearchCoderException {
		
		SubmissionSearchVO searchVO = new SubmissionSearchVO();
		searchVO.setName(name);
		searchVO.setValue(value);
		searchVO.setPageNumber(pageNumber);
		searchVO.setPageSize(pageSize);
		return submissionService.filterSubmissions(searchVO);
	}
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SubmissionFilterVO filterSubmissions(@QueryParam(value="pageNumber") int pageNumber, @QueryParam(value="pageSize") int pageSize) throws SearchCoderException {
	
		return submissionService.SearchSubmissions(pageNumber, pageSize);
	}

	public void setSubmissionService(SubmissionService submissionService) {
		this.submissionService = submissionService;
	}
}
