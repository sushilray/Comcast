package com.comcast.ucsi.validation.service.model;

public class ValidationRuleResult {
	
	private String title;
	private String status;
	private String message;
	
	
	public ValidationRuleResult() {}
	
	
	public ValidationRuleResult(String title, String status, String message) {
		
		this.title = title;
		this.status = status;
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
