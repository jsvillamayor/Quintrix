package com.James.UFSproject.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Website {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String originalUrl;
	private String tinyUrl;
	private String user;
	private int timesAccessed;
	
	public Website() {
		
	}
	
	public Website(String originalUrl, String tinyUrl, String user, int timesAccessed) {
		this.originalUrl = originalUrl;
		this.tinyUrl = tinyUrl;
		this.user = user;
		this.timesAccessed = timesAccessed;
	}
	
	public Long getId() {
		return id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getTinyUrl() {
		return tinyUrl;
	}
	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getTimesAccessed() {
		return timesAccessed;
	}
	public void setTimesAccessed(int timesAccessed) {
		this.timesAccessed = timesAccessed;
	}

}
