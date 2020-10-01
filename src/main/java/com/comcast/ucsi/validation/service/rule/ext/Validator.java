package com.comcast.ucsi.validation.service.rule.ext;

import java.util.List;

import org.springframework.stereotype.Component;

import com.comcast.ucsi.validation.service.model.ValidationRuleResult;
import com.comcast.ucsi.validation.service.rule.ErrorMessageLoader;
import com.comcast.ucsi.validation.service.rule.IErrorMessageLoader;



/**
 * Validator is a validator template
 * for all object validation logic
 * 
 * 
 * @author Tarek Shalaby
 *
 * 
 */
@Component
public abstract class Validator <T>{
	
	protected Object validateeParent=null;
	protected T vladatee;
	
	private IErrorMessageLoader errorMessageLoader=ErrorMessageLoader.getInstance();
	
	public Validator(T t, Object parent) {
		this.vladatee=t;
		this.validateeParent=parent;
	}

	
	protected List<ValidationRuleResult> addValidationError(List<ValidationRuleResult> validationResult,
			String objectName) {
			
				
			validationResult.add(new ValidationRuleResult(
			((errorMessageLoader.getValue(objectName+".title"))!=null) ? (errorMessageLoader.getValue(objectName+".title")): "Title message not found"	,
			((errorMessageLoader.getValue(objectName+".status"))!=null) ? (errorMessageLoader.getValue(objectName+".status")): "Status message not found",
			((errorMessageLoader.getValue(objectName+".message"))!=null) ? (errorMessageLoader.getValue(objectName+".message")): "Detailed message not found"
			));
			
			return validationResult;
			}
	
	
	
	public abstract List<ValidationRuleResult> doValiadtion();
}
