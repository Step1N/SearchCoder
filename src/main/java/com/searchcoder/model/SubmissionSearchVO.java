package com.searchcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "submissionSearchVO")
public class SubmissionSearchVO {

	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private String value;
	@JsonProperty("pageNumber")
	private int pageNumber;
	@JsonProperty("pageSize")
	private int pageSize;

	public int getMaxResult() {

		return (pageNumber - 1)*pageSize;
	}

	public int getPageNumber() {
		if (pageNumber == 0) {
			pageNumber = 1;
		}
		
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		if(pageSize == 0){
			pageSize =10;
		}
		
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
