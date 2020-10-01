package com.comcast.ucsi.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Asset {
	
	@JsonProperty("class")
	private String _class;
	
	private String providerId;
    
    
	private String provider;

    private BreakPoints breakPoints;
    
    private String contentAssetId;
    
    private Integer versionMajor = 1;;
    
    private Integer versionMinor = 0;

    public void setClass(String _class){
        this._class = _class;
    }
    public String get_Class(){
        return this._class;
    }
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
    public void setBreakPoints(BreakPoints breakPoints){
        this.breakPoints = breakPoints;
    }
    public BreakPoints getBreakPoints(){
        return this.breakPoints;
    }
    public String getContentAssetId() {
		return contentAssetId;
	}
	public void setContentAssetId(String contentAssetId) {
		this.contentAssetId = contentAssetId;
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
