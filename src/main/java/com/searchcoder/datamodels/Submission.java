package com.searchcoder.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="submissions")
public class Submission {

	@Id
	@Column(name="submission_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer submissionID;
	
	private String title;
	private String metadata;
	private String source;
	private String status;
	private String language;
	
	public Integer getSubmissionID() {
		return submissionID;
	}
	public void setSubmissionID(Integer submissionID) {
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
