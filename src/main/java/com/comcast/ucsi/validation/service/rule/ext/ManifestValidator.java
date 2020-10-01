package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Manifest;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * Validator for  Manifest Object
 * 
 * @author Tarek Shalaby
 *
 */
public class ManifestValidator extends Validator<Manifest>{

	private static Log logger = LogFactory.getLog(ManifestValidator.class);
	
	
	
	public ManifestValidator(Manifest t, Object parent) {
		super(t, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		
		
		if(vladatee.getSource()==null || vladatee.getSource().isEmpty()) {
			this.addValidationError(result, vladatee.getClass().getSimpleName()+".Source");
			
		}
		
		return result;
	}

	
	
}
