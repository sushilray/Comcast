package com.comcast.ucsi.validation.service.model;

public class SegmentInfo {
	
	private Integer number;

    private String startOfEssence;

    private String startOfMedia;

    private String endOfMedia;

    public void setNumber(Integer number){
        this.number = number;
    }
    public Integer getNumber(){
        return this.number;
    }
    public void setStartOfEssence(String startOfEssence){
        this.startOfEssence = startOfEssence;
    }
    public String getStartOfEssence(){
        return this.startOfEssence;
    }
    public void setStartOfMedia(String startOfMedia){
        this.startOfMedia = startOfMedia;
    }
    public String getStartOfMedia(){
        return this.startOfMedia;
    }
    public void setEndOfMedia(String endOfMedia){
        this.endOfMedia = endOfMedia;
    }
    public String getEndOfMedia(){
        return this.endOfMedia;
    }

}
