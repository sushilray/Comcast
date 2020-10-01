package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Asset;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * 
 * Validator for Asset Object
 * 
 * @author Tarek Shalaby
 *
 */
public class AssetValidator extends Validator<Asset>{

	private static Log logger = LogFactory.getLog(AssetValidator.class);
	
	public AssetValidator(Asset t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		
		if(vladatee.getProviderId()!=null && !("".equals(vladatee.getProviderId().trim()))) {
			
			if((((com.comcast.ucsi.validation.service.model.Title)this.validateeParent).getProviderId() !=null) && 
					!((com.comcast.ucsi.validation.service.model.Title)this.validateeParent).getProviderId()
					.equalsIgnoreCase(vladatee.getProviderId()))
			return addValidationError(result, vladatee.getClass().getSimpleName()+".ProviderId"+".value");
		
		}
		
		
		if(vladatee.getProvider()!=null && !("".equals(vladatee.getProvider().trim()))) {
			
			if((((com.comcast.ucsi.validation.service.model.Title)this.validateeParent).getProvider() !=null) &&
					!((com.comcast.ucsi.validation.service.model.Title)this.validateeParent).getProvider()
					.equalsIgnoreCase(vladatee.getProvider()))
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Provider"+".value");
		
		}
		
		
		if(vladatee.get_Class()==null || "".equals(vladatee.get_Class().trim())) {
			
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Class");
			
		}else{
			if(!vladatee.get_Class().equalsIgnoreCase("movie") && !(vladatee.get_Class().equalsIgnoreCase("preview"))) {
				return addValidationError(result, vladatee.getClass().getSimpleName()+".Class"+".Enum");
			}
		}
		
				
		return result;
	}

}
