package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class Title {

	private String licensingWindowStart;

	private String licensingWindowEnd;

	private Integer versionMajor = 1;

	private Integer versionMinor = 0;

	private List<Asset> asset;

	private String profile;

	private String providerId;

	private String provider;

	private String titleAssetId;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setLicensingWindowStart(String licensingWindowStart) {
		this.licensingWindowStart = licensingWindowStart;
	}

	public String getLicensingWindowStart() {
		return this.licensingWindowStart;
	}

	public void setLicensingWindowEnd(String licensingWindowEnd) {
		this.licensingWindowEnd = licensingWindowEnd;
	}

	public String getLicensingWindowEnd() {
		return this.licensingWindowEnd;
	}

	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}

	public List<Asset> getAsset() {
		return this.asset;
	}

	public Integer getVersionMajor() {
		return versionMajor;
	}

	public void setVersionMajor(Integer versionMajor) {
		this.versionMajor = versionMajor;
	}

	public Integer getVersionMinor() {
		return versionMinor;
	}

	public void setVersionMinor(Integer versionMinor) {
		this.versionMinor = versionMinor;
	}

	public String getTitleAssetId() {
		return titleAssetId;
	}

	public void setTitleAssetId(String titleAssetId) {
		this.titleAssetId = titleAssetId;
	}

}
