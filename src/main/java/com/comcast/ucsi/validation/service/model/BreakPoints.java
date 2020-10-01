package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class BreakPoints {
	
	private String distributorExtRef;

    private String action;

    private String assetName;

    private String leadBlack;

    private String preRoll;

    private List<String> midRolls;

    private String postRoll;

    private String preRollLocal;

    private List<String> midRollLocals;

    private String postRollLocal;
    
    //Added the generated fields
    private String providerExtRef;
    
    private String providerId;

    private String assetId;
    

    public void setDistributorExtRef(String distributorExtRef){
        this.distributorExtRef = distributorExtRef;
    }
    public String getDistributorExtRef(){
        return this.distributorExtRef;
    }
    public void setAction(String action){
        this.action = action;
    }
    public String getAction(){
        return this.action;
    }
    public void setAssetName(String assetName){
        this.assetName = assetName;
    }
    public String getAssetName(){
        return this.assetName;
    }
    public void setLeadBlack(String leadBlack){
        this.leadBlack = leadBlack;
    }
    public String getLeadBlack(){
        return this.leadBlack;
    }
    public void setPreRoll(String preRoll){
        this.preRoll = preRoll;
    }
    public String getPreRoll(){
        return this.preRoll;
    }
    public void setMidRolls(List<String> midRolls){
        this.midRolls = midRolls;
    }
    public List<String> getMidRolls(){
        return this.midRolls;
    }
    public void setPostRoll(String postRoll){
        this.postRoll = postRoll;
    }
    public String getPostRoll(){
        return this.postRoll;
    }
    public void setPreRollLocal(String preRollLocal){
        this.preRollLocal = preRollLocal;
    }
    public String getPreRollLocal(){
        return this.preRollLocal;
    }
    public void setMidRollLocals(List<String> midRollLocals){
        this.midRollLocals = midRollLocals;
    }
    public List<String> getMidRollLocals(){
        return this.midRollLocals;
    }
    public void setPostRollLocal(String postRollLocal){
        this.postRollLocal = postRollLocal;
    }
    public String getPostRollLocal(){
        return this.postRollLocal;
    }
	public String getProviderExtRef() {
		return providerExtRef;
	}
	public void setProviderExtRef(String providerExtRef) {
		this.providerExtRef = providerExtRef;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	
	
}
