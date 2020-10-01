package com.comcast.ucsi.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Distribution {

	@JsonProperty("package")
	private Package _package;
	// Adding the generated fields
	private String id;
	private String guid;
	private String videoQuality;

	public Package getPackage() {
		return this._package;
	}

	public void setPackage(Package _package) {
		this._package = _package;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public String getVideoQuality() {
		return this.videoQuality;
	}

}
