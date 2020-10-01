package com.comcast.ucsi.validation.service.autofill;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.comcast.ucsi.validation.service.model.Asset;
import com.comcast.ucsi.validation.service.model.CreateIngest;
import com.comcast.ucsi.validation.service.model.CreateIngestRequestWrapper;
import com.comcast.ucsi.validation.service.model.Distribution;
import com.comcast.ucsi.validation.service.model.Package;
import com.comcast.ucsi.validation.service.model.Source;
import com.comcast.ucsi.validation.service.model.Title;

@Component
public class GeneratedFieldsAutoFillerImpl implements GeneratedFieldsAutoFiller {

	private String SKYU = "SKYU";
	private long digits = (long) (Math.random() * 10000000000000000L);
	private String dateFormat ="YYYY-MM-DD T HH:MM:SS";

	public String generateAssetId(String prefix) {
		digits = digits + 1;
		return prefix + String.valueOf(digits);
	}

	@Override
	public Object generateFields(Object data) {

		CreateIngestRequestWrapper createIngestRequestWrapper = (CreateIngestRequestWrapper) data;
		CreateIngest createIngest = createIngestRequestWrapper.getCreateIngest();
		
			

		if (null == createIngest.getUuid() || createIngest.getUuid().isEmpty()) {
			createIngest.setUuid(UUID.randomUUID().toString());
		}

		if (createIngest.getManifest() != null) {
			for (Source s : createIngest.getManifest().getSource()) {
				if (!createIngest.isCaptionsAvailable()
						&& (null == s.getClosedCaptionFormat() || !s.getClosedCaptionFormat().isEmpty())) {
					createIngest.setCaptionsAvailable(true);
				}
			}
		}

		if (!CollectionUtils.isEmpty(createIngest.getDistribution())) {
			for (Distribution distribution : createIngest.getDistribution()) {
				if (distribution.getPackage() != null) {
					Package pack = distribution.getPackage();
					if (null == pack.getPackageAssetId() || pack.getPackageAssetId().isEmpty()) {
						pack.setPackageAssetId(this.generateAssetId(SKYU));
					}

					if (distribution.getPackage().getTitle() != null) {
						Title title = distribution.getPackage().getTitle();
						if (null == title.getTitleAssetId() || title.getTitleAssetId().isEmpty()) {
							title.setTitleAssetId(this.generateAssetId(SKYU));
						}
						for (Asset assest : title.getAsset()) {
							if (assest.getBreakPoints() != null) {
								createIngest.setBreakpointsAvailable(true);
							}
						}
						if (!CollectionUtils.isEmpty(title.getAsset())) {
							for (Asset asset : title.getAsset()) {

								if (null == asset.getContentAssetId() || asset.getContentAssetId().isEmpty()) {
									asset.setContentAssetId(this.generateAssetId(SKYU));
								}
							}
						}

					}

				}
			}

		}
		return data;
	}

}
