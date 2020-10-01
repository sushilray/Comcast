package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.ValidationRuleResult;



/**
 * Validator for Package Object
 * 
 * @author Tarek Shalaby
 *
 */
public class PackageValidator extends Validator<com.comcast.ucsi.validation.service.model.Package>{
	
	private static Log logger = LogFactory.getLog(PackageValidator.class);

	public PackageValidator(com.comcast.ucsi.validation.service.model.Package t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
				
		if(vladatee.getProviderId()==null || "".equals(vladatee.getProviderId().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".ProviderId");
			
		}
		
		if(vladatee.getProvider()==null || "".equals(vladatee.getProvider().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Provider");
		}
		
		if(vladatee.getPlatform()==null || vladatee.getPlatform().isEmpty()) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Platform");
						
		}
		
		if(vladatee.getTitle()==null) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Title");
		}
		
		return result;
	}

}
