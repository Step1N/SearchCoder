package com.searchcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "submissionVO")
public class SubmissionVO {

	@JsonProperty("submissionID")
	private String submissionID;
	@JsonProperty("title")
	private String title;
	@JsonProperty("metadata")
	private String metadata;
	@JsonProperty("source")
	private String source;
	@JsonProperty("status")
	private String status;
	@JsonProperty("language")
	private String language;

	public String getSubmissionID() {
		return submissionID;
	}

	public void setSubmissionID(String submissionID) {
		this.submissionID = submissionID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
