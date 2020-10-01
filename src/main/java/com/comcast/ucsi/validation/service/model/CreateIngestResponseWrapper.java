package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class CreateIngestResponseWrapper {
	
	
	private CreateIngest createIngest;
	private List<ValidationRuleResult> validationErrerMessages;
	
	

    public List<ValidationRuleResult> getValidationErrerMessages() {
		return validationErrerMessages;
	}
	public void setValidationErrerMessages(List<ValidationRuleResult> validationErrerMessages) {
		this.validationErrerMessages = validationErrerMessages;
	}
	public void setCreateIngest(CreateIngest createIngest){
        this.createIngest = createIngest;
    }
    public CreateIngest getCreateIngest(){
        return this.createIngest;
    }
    
    

}
