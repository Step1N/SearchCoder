package com.searchcoder.rest;

import com.searchcoder.expception.SearchCoderException;
import com.searchcoder.model.SubmissionFilterVO;
import com.searchcoder.model.SubmissionVOs;


public interface SearchCoderResource {
	SubmissionVOs fetchSubmissions() throws SearchCoderException;
	SubmissionVOs SearchSubmissions(String name, String value, int pageNumber,int pageSize) throws SearchCoderException;
	SubmissionFilterVO filterSubmissions(int pageNumber,int pageSize) throws SearchCoderException;
}
