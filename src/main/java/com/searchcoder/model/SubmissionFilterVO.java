package com.searchcoder.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "submissionFilterVO")
public class SubmissionFilterVO {

	@JsonProperty("submissionPerLevel")
	private List<ElementVO> submissionPerLevel = new ArrayList<ElementVO>();
	@JsonProperty("submissionsAttempted")
	private List<ElementVO> submissionsAttempted= new ArrayList<ElementVO>();
	@JsonProperty("laguageUsed")
	private List<ElementVO> languageUsed= new ArrayList<ElementVO>();
	@JsonProperty("totalSubmitions")
	private String totalSubmitions;
	@JsonProperty("count")
	private Integer count;
	
	public List<ElementVO> getSubmissionPerLevel() {
		if (submissionPerLevel == null) {
			submissionPerLevel = new ArrayList<ElementVO>();
		}
		return submissionPerLevel;
	}

	public List<ElementVO> getSubmissionsAttempted() {
		if (submissionsAttempted == null) {
			submissionsAttempted = new ArrayList<ElementVO>();
		}
		return submissionsAttempted;
	}
	public List<ElementVO> getLanguageUsed() {
		if (languageUsed == null) {
			languageUsed = new ArrayList<ElementVO>();
		}
		return languageUsed;
	}
	public String getTotalSubmitions() {
		return totalSubmitions;
	}
	public void setTotalSubmitions(String totalSubmitions) {
		this.totalSubmitions = totalSubmitions;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
