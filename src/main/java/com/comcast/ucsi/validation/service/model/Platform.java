package com.comcast.ucsi.validation.service.model;

public class Platform {

	private String eligiblePlatform;

    private String window;

    public void setEligiblePlatform(String eligiblePlatform){
        this.eligiblePlatform = eligiblePlatform;
    }
    public String getEligiblePlatform(){
        return this.eligiblePlatform;
    }
    public void setWindow(String window){
        this.window = window;
    }
    public String getWindow(){
        return this.window;
    }
}
