package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class Package {

	private String packageAssetId;

	private String providerId;

	private String provider;

	private Integer versionMajor = 1;

	private Integer versionMinor = 0;

	private Title title;

	private List<Platform> platform;

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderId() {
		return this.providerId;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setPlatform(List<Platform> platform) {
		this.platform = platform;
	}

	public List<Platform> getPlatform() {
		return this.platform;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Title getTitle() {
		return this.title;
	}

	public String getPackageAssetId() {
		return packageAssetId;
	}

	public void setPackageAssetId(String packageAssetId) {
		this.packageAssetId = packageAssetId;
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

}
