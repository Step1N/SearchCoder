package com.searchcoder.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="submissionVOs")
public class SubmissionVOs {
	
	@JsonProperty("submissions")
	private List<SubmissionVO> submissions = new ArrayList<SubmissionVO>();
	
	@JsonProperty("count")
	private int count;
	

	public List<SubmissionVO> getSubmissions() {
		if(submissions == null){
			return new ArrayList<SubmissionVO>();
		}
		
		return submissions;
	}


	public int getCount() {
		if(count == 0){
			count = submissions.size()+1;
		}
		
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
}
