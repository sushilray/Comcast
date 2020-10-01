package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Asset;
import com.comcast.ucsi.validation.service.model.BreakPoints;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * Validator for BreakPoints Object
 * 
 * @author Tarek Shalaby
 *
 */
public class BreakPointsValidator extends Validator<BreakPoints>{
	
	private static Log logger = LogFactory.getLog(BreakPointsValidator.class);
	private String ingestPartner=null;
	
	public BreakPointsValidator(BreakPoints t, Object parent) {
		super(t, parent);
		
	}
	
	public BreakPointsValidator(BreakPoints t, Object parent, String ingestPartner) {
		super(t, parent);
		this.ingestPartner=ingestPartner;
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		if(vladatee.getDistributorExtRef()!=null &&
				!(vladatee.getDistributorExtRef().trim().equals("")) &&
				ingestPartner!=null
				//((Asset)this.validateeParent).getProvider()!=null
				) {
			if(!vladatee.getDistributorExtRef().equalsIgnoreCase(ingestPartner)){
				return addValidationError(result, vladatee.getClass().getSimpleName()+".DistributorExtRef"+".value");}
		}
		
		return result;
	}

}
