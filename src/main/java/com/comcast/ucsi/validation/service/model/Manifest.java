package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class Manifest {
	
	private List<Source> source;
	
	// Adding the generated fields
    private String id;

    public void setSource(List<Source> source){
        this.source = source;
    }
    public List<Source> getSource(){
        return this.source;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
    

}
