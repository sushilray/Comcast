package com.comcast.ucsi.validation.service.model;

import java.util.List;

public class CreateIngest {

	private boolean captionsAvailable = false;

	private String partner;

	// Adding the generated fields
	private String uuid;

	private boolean breakpointsAvailable = false;

	private Manifest manifest;

	private String manifestId;

	private String title;

	private List<Distribution> distribution;

	// private String replaceUuid;
	//
	// private Date added;
	//
	// private Date updated;
	//
	// private String priority;
	//
	// private String providerId;
	//
	// private String assetId;

	public boolean isCaptionsAvailable() {
		return captionsAvailable;
	}

	public void setCaptionsAvailable(boolean captionsAvailable) {
		this.captionsAvailable = captionsAvailable;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPartner() {
		return this.partner;
	}

	public boolean isBreakpointsAvailable() {
		return breakpointsAvailable;
	}

	public void setBreakpointsAvailable(boolean breakpointsAvailable) {
		this.breakpointsAvailable = breakpointsAvailable;
	}

	public void setManifestId(String manifestId) {
		this.manifestId = manifestId;
	}

	public String getManifestId() {
		return this.manifestId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}

	public Manifest getManifest() {
		return this.manifest;
	}

	public void setDistribution(List<Distribution> distribution) {
		this.distribution = distribution;
	}

	public List<Distribution> getDistribution() {
		return this.distribution;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	// public String getReplaceUuid() {
	// return replaceUuid;
	// }
	//
	// public void setReplaceUuid(String replaceUuid) {
	// this.replaceUuid = replaceUuid;
	// }
	//
	// public Date getAdded() {
	// return added;
	// }
	//
	// public void setAdded(Date added) {
	// this.added = added;
	// }
	//
	// public Date getUpdated() {
	// return updated;
	// }
	//
	// public void setUpdated(Date updated) {
	// this.updated = updated;
	// }
	//
	// public String getPriority() {
	// return priority;
	// }
	//
	// public void setPriority(String priority) {
	// this.priority = priority;
	// }
	//
	// public String getProviderId() {
	// return providerId;
	// }
	//
	// public void setProviderId(String providerId) {
	// this.providerId = providerId;
	// }
	//
	// public String getAssetId() {
	// return assetId;
	// }
	//
	// public void setAssetId(String assetId) {
	// this.assetId = assetId;
	// }
	//
	//
	// public boolean isBreakpointsAvailable() {
	// return breakpointsAvailable;
	// }
	//
	// public void setBreakpointsAvailable(boolean breakpointsAvailable) {
	// this.breakpointsAvailable = breakpointsAvailable;
	// }

}
