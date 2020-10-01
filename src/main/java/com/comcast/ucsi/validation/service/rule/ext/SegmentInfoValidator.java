package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.SegmentInfo;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


/**
 * Validator for SegmentInfo Object
 * 
 * @author Tarek Shalaby
 *
 */
public class SegmentInfoValidator extends Validator<SegmentInfo>{
	
	private static Log logger = LogFactory.getLog(SegmentInfoValidator.class);
	
		

	public SegmentInfoValidator(SegmentInfo t, Object parent) {
		super(t, parent);
		
	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : "+this.getClass().getSimpleName());
		
		
		
		if(vladatee.getNumber()==null){

			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".Number");
			
		}
		
		if(vladatee.getStartOfEssence()==null || "".equals(vladatee.getStartOfEssence().trim())){

			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".StartOfEssence");
			
		}else {
			
			//ToDo check that Start of Essence in SMPTE timecode format, format: HH:MM:SS:FF. 
		}
		
		if(vladatee.getStartOfMedia()==null){

			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".StartOfMedia");
			
		}else {
			
			//ToDo check that Start of Media in SMPTE timecode format, format: HH:MM:SS:FF. 
		}

		if(vladatee.getEndOfMedia()==null){

			return this.addValidationError(result, vladatee.getClass().getSimpleName()+".EndOfMedia");
			
		}else {
			
			//ToDo check that End of Media in SMPTE timecode format, format: HH:MM:SS:FF. 
		}

		
		
		
		return result;
	}
	
	

}
