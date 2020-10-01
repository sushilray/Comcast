package com.comcast.ucsi.validation.service.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comcast.ucsi.validation.service.autofill.GeneratedFieldsAutoFiller;
import com.comcast.ucsi.validation.service.model.*;
import com.comcast.ucsi.validation.service.rule.*;
import com.comcast.ucsi.validation.service.rule.ext.ValidationManager;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;




/**
 * 
 * 
 * This is an implementation of the Processor 
 * so the processing starts here
 * 
 * @author Tarek Shalaby
 *
 */
@Component
public class ValidationServiceProcessor implements Processor {
	
	private static Log logger = LogFactory.getLog(ValidationServiceProcessor.class);
	
	@Autowired
	private ObjectMapper mapper;
	
		
	private Object inputData=null;
	
		
	@Autowired
	private ValidationManager validationManager;
	
	@Autowired
	GeneratedFieldsAutoFiller generatedFieldsAutoFiller;
	
	
	private Object unmarshalData(InputStream data) {
		Object result=null;
		
		try {
			//ToDO accept addtion properties
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			//ToDo allow non numberic and accept the invalid values for integer 
		    mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
		   // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		    mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		    
		    mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);

			
			result=mapper.readValue(data, CreateIngestRequestWrapper.class);
			
		}catch(Exception e) {}
		
		return result;
	}

	@Override
	public Object process(InputStream dataStream){
		
		
		
		this.inputData=unmarshalData(dataStream);
		
		if(inputData==null ||!this.isValidCreateIngestPayload(inputData)){
			logger.info("Invalid CreateIngest Payload");
			return this.handleInvalidCreateIngestPayload();
		}
		else {
			
			List<ValidationRuleResult> errorMessages=this.fireValidationRules();
			if(errorMessages==null || errorMessages.size()==0) {
				return this.autoFillGeneratedFields();
			}else {
				return this.handleErrorValiadtionMessage(errorMessages);
			}
		}
		

	}
	
	
	private Boolean isValidCreateIngestPayload (Object data) {
		
		try {
		CreateIngestRequestWrapper req=(CreateIngestRequestWrapper)data;
		if (req.getCreateIngest()==null)return Boolean.FALSE;
		else return Boolean.TRUE;
		}catch(ClassCastException cce) {
			return Boolean.FALSE;
		}
	}
	
	private Object handleInvalidCreateIngestPayload() {
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		logger.info("Invalid request: not valid CreatIngest payload.");
		return new org.springframework.http.ResponseEntity<String>("Invalid request: not valid CreatIngest payload.", 
				responseHeaders, 
				org.springframework.http.HttpStatus.BAD_REQUEST);
		
	}
	
	private Object handleErrorValiadtionMessage(List<ValidationRuleResult> errorMessages) {
		
		CreateIngestErrorResponseWrapper createIngestResponseWrapper=new CreateIngestErrorResponseWrapper();
		createIngestResponseWrapper.setErrors(errorMessages);
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		
		
		return new org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>(createIngestResponseWrapper, 
				responseHeaders, 
				org.springframework.http.HttpStatus.OK);
		
		
		
	}
	
	//ToDo accept exception a aparameter and genrate en error respose
	public Object HandleGloableError(String errorMessage) {
		
		org.springframework.http.HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		//ToDo log the error message and error cause and the stacktrace
		logger.error(errorMessage);
		
		return new org.springframework.http.ResponseEntity<String>(errorMessage, 
				responseHeaders, 
				org.springframework.http.HttpStatus.EXPECTATION_FAILED);
		
	}
	//ToDo get Ingest object as a aparameter not as a local variable
	private List<ValidationRuleResult> fireValidationRules(){
		
//		ValidationContext validationContext=new ValidationContext();
//		validationRuleHandler.validateIngest(((CreateIngestRequestWrapper)inputData).getCreateIngest(), validationContext);
//		return validationContext.getValidationRuleResult();
		
		
		return validationManager.validate(((CreateIngestRequestWrapper)inputData).getCreateIngest());
	}
	
	private Object autoFillGeneratedFields() {
		
		//ToDo autofile generated fields
		return generatedFieldsAutoFiller.generateFields(this.inputData);
	}

}

