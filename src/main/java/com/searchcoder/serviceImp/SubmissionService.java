package com.searchcoder.serviceImp;

import com.searchcoder.expception.SearchCoderException;
import com.searchcoder.model.SubmissionFilterVO;
import com.searchcoder.model.SubmissionSearchVO;
import com.searchcoder.model.SubmissionVOs;

public interface SubmissionService {
	
	SubmissionVOs fetchSubmissions() throws SearchCoderException;
	
	SubmissionVOs filterSubmissions(SubmissionSearchVO searchVO) throws SearchCoderException;
	
	SubmissionFilterVO SearchSubmissions(int pageNumber, int pageSize) throws SearchCoderException;
}
