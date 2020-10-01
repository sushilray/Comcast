package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Title;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * Validator for Title Object
 * 
 * @author Tarek Shalaby
 *
 */
public class TitleValidator extends Validator<Title> {

	private static Log logger = LogFactory.getLog(TitleValidator.class);
	
	public TitleValidator(Title t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		if(vladatee.getProviderId()!=null && !("".equals(vladatee.getProviderId().trim()))) {
			
			if(!((com.comcast.ucsi.validation.service.model.Package)this.validateeParent).getProviderId()
					.equalsIgnoreCase(vladatee.getProviderId()))
			return addValidationError(result, vladatee.getClass().getSimpleName()+".ProviderId"+".value");
		
		}
		
		
		if(vladatee.getProvider()!=null && !("".equals(vladatee.getProvider().trim()))) {
			
			if(!((com.comcast.ucsi.validation.service.model.Package)this.validateeParent).getProvider()
					.equalsIgnoreCase(vladatee.getProvider()))
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Provider"+".value");
		
		}

		
		if(vladatee.getLicensingWindowStart()==null || "".equals(vladatee.getLicensingWindowStart().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".LicensingWindowStart");
		
		}
		
		if(vladatee.getLicensingWindowEnd()==null || "".equals(vladatee.getLicensingWindowEnd().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".LicensingWindowEnd");
		}
		
		if(vladatee.getAsset()==null || vladatee.getAsset().isEmpty()) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Asset");
			
		}
		
		if(vladatee.getProfile()!=null && 
				!vladatee.getProfile().equalsIgnoreCase("Entertainment") &&
				!vladatee.getProfile().equalsIgnoreCase("Sports") &&
				!vladatee.getProfile().equalsIgnoreCase("Movies")) {
			return addValidationError(result, vladatee.getClass().getSimpleName()+".Profile"+".Enum");
			
		}
		
		
		return result;
	}

}
