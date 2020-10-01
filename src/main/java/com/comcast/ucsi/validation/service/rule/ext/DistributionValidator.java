package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Distribution;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * 
 * Validator for Distribution Object
 * 
 * @author Tarek Shalaby
 *
 */
public class DistributionValidator extends Validator<Distribution>{
	
	private static Log logger = LogFactory.getLog(DistributionValidator.class);
	
	enum VideoQuality{SD,HD,UHD};

	public DistributionValidator(Distribution t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		
		if(vladatee.getGuid()==null || "".equals(vladatee.getGuid().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Guid");
		}
		
		if(vladatee.getVideoQuality()==null || "".equals(vladatee.getVideoQuality().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".VideoQuality");
		}else {
			
		
			if(!VideoQuality.SD.name().equalsIgnoreCase(vladatee.getVideoQuality()) &&
				!VideoQuality.HD.name().equalsIgnoreCase(vladatee.getVideoQuality()) &&
				!VideoQuality.UHD.name().equalsIgnoreCase(vladatee.getVideoQuality())) {
			
			return addValidationError(result, vladatee.getClass().getSimpleName()+".VideoQuality"+".Enum");}
			
			
		}
		
		if(vladatee.getPackage()==null) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Package");
		}
		
		
		return result;
	}

}
