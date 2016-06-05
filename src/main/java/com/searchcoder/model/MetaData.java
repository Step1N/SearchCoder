package com.searchcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="metadata")
public class MetaData {
	
	@JsonProperty("level")
	public String level;
	@JsonProperty("rating")
	public Integer rating;
	@JsonProperty("users_attempted")
	public Integer attempted;
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getAttempted() {
		return attempted;
	}
	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}
}
