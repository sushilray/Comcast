package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.comcast.ucsi.validation.service.model.Asset;
import com.comcast.ucsi.validation.service.model.CreateIngest;
import com.comcast.ucsi.validation.service.model.Distribution;
import com.comcast.ucsi.validation.service.model.Platform;
import com.comcast.ucsi.validation.service.model.Source;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;


@Component
public class ValidationManagerImpl implements ValidationManager{
	
	private static Log logger = LogFactory.getLog(ValidationManagerImpl.class);
	
	private List<Validator> validatorJobList=null;
	
	private void buildValidatorJobList(CreateIngest ingest) {
		logger.info("building Validator Job List.");
		this.validatorJobList=new ArrayList<Validator>();
		
		IngestValidator ingestValidator=new IngestValidator(ingest,null);
		
		validatorJobList.add(ingestValidator);
		
		if(ingest.getManifest()!=null) {
		ManifestValidator manifestValidator=new ManifestValidator(ingest.getManifest(),ingest);
		validatorJobList.add(manifestValidator);
		if(ingest.getManifest().getSource()!=null) {
		for(Source source: ingest.getManifest().getSource()) {
			
			SourceValidator sourceValidator=new SourceValidator(source, ingest.getManifest());
			validatorJobList.add(sourceValidator);
			
			if(source.getSegmentInfo()!=null) {
				
				validatorJobList.add(new SegmentInfoValidator(source.getSegmentInfo(),source));
			}
		}}
		
		
		
		}
		//ToDO Check the type of Distribution as a List<Distribution>
		if(ingest.getDistribution()!=null){
			
			for(Distribution distribution: ingest.getDistribution()) {
				validatorJobList.add(new DistributionValidator(distribution,ingest));
				
				//ToDo check the if the package object of type Package
				if(distribution.getPackage()!=null && 
				(distribution.getPackage() instanceof com.comcast.ucsi.validation.service.model.Package)) {
					validatorJobList.add(new PackageValidator(distribution.getPackage(),distribution));
					
					if(distribution.getPackage().getPlatform()!=null) {
						
						for(Platform platform: distribution.getPackage().getPlatform()) {
							validatorJobList.add(new PlatformValidator(platform,distribution.getPackage()));
							
						}
						
					}
					
					if(distribution.getPackage().getTitle()!=null) {
						validatorJobList.add(new TitleValidator(distribution.getPackage().getTitle(), distribution.getPackage()));
						
						if(distribution.getPackage().getTitle().getAsset()!=null) {
						List<Asset> assetList=distribution.getPackage().getTitle().getAsset();
						
						for(Asset asset : assetList) {
							
							validatorJobList.add(new AssetValidator(asset,distribution.getPackage().getTitle()));
							
							if(asset.getBreakPoints()!=null) {
								validatorJobList.add(new BreakPointsValidator(asset.getBreakPoints(),asset, ingest.getPartner()));
							}
							
						}
						
						}
					}
				}
			}
		}
		
		
		
		logger.info("validatorJobList size: "+validatorJobList.size());
	}

	@Override
	public List<ValidationRuleResult> validate(CreateIngest ingest) {
		
		List<ValidationRuleResult> result=new ArrayList<ValidationRuleResult>();
		
		this.buildValidatorJobList(ingest);
		
		
		logger.info("Satring the validation process");
		for(Validator validator: validatorJobList) {
			
			List<ValidationRuleResult> temp=validator.doValiadtion();
			if(temp!=null && !temp.isEmpty()) {
				return temp;
			}
			
//			//ToDo in case of doing full validation (non-stopping)
//			if(temp!=null && !temp.isEmpty()) {
//				result.addAll(temp);
//			}
			
		}
		
		return result;
	}
	
	private Boolean checkInstanceType(Class type, Object instance) {
		
		return type.isInstance(instance);
	}

}
