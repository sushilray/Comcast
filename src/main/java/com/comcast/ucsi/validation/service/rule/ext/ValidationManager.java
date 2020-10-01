package com.comcast.ucsi.validation.service.rule.ext;

import java.util.List;

import com.comcast.ucsi.validation.service.model.CreateIngest;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;



/**
 * @author Tarek Shalaby
 *
 */
public interface ValidationManager {
	
	public List<ValidationRuleResult> validate(CreateIngest ingest);

}
