package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class CreateIngestErrorResponseWrapper {
	
	
	private String status="ERROR";
	private List<ValidationRuleResult> errors;
	
	

    
	public List<ValidationRuleResult> getErrors() {
		return errors;
	}




	public void setErrors(List<ValidationRuleResult> errors) {
		this.errors = errors;
	}




	public String getStatus() {
		return status;
	}
	
    
    

}
