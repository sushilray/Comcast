package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Platform;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * Valdiator for 
 * 
 * @author Tarek Shalaby Platform Object
 *
 */
public class PlatformValidator extends Validator<Platform>{
	
	private static Log logger = LogFactory.getLog(PlatformValidator.class);

	public PlatformValidator(Platform t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		if(vladatee.getEligiblePlatform()==null || "".equals(vladatee.getEligiblePlatform().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".EligiblePlatform");
		}else if(!vladatee.getEligiblePlatform().equalsIgnoreCase("OTT") &&
				!vladatee.getEligiblePlatform().equalsIgnoreCase("TITLEVI") &&
				!vladatee.getEligiblePlatform().equalsIgnoreCase("DL2GO")) {
						
			return addValidationError(result, vladatee.getClass().getSimpleName()+".EligiblePlatform"+".Enum");
			
		}
		
		if(vladatee.getWindow()==null || "".equals(vladatee.getWindow().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Window");
		}
		
		
		return result;
	}

}
