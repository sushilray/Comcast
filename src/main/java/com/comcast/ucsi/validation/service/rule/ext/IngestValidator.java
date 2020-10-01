package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.CreateIngest;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * 
 * Validator for Ingest Object
 * 
 * @author Tarek Shalaby
 *
 */
public class IngestValidator extends Validator<CreateIngest>{

	private static Log logger = LogFactory.getLog(IngestValidator.class);
	
	
	
	public IngestValidator(CreateIngest t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		if(vladatee.getPartner()==null || "".equals(vladatee.getPartner().trim())) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".Partner");
		}
		
		if(vladatee.getManifestId()==null || "".equals(vladatee.getManifestId().trim())) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".ManifestId");
		}
		
		if(vladatee.getTitle()==null || "".equals(vladatee.getTitle().trim())) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".Title");
		}
		
		if(vladatee.getManifest()==null) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".Manifest");
		}
		
		if(vladatee.getDistribution()==null || vladatee.getDistribution().isEmpty()) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".Distribution");
		}
		
		
		return result;
	}
	
	
}
