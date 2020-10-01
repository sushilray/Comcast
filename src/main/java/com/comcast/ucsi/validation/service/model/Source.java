package com.comcast.ucsi.validation.service.model;

public class Source {

	private String fileLocator;

	private String fileName;

	private String type;

	private String codec;

	private Integer duration;

	private String container;

	private String screenFormat;

	private String videoQuality;

	private String videoQualityResolution;

	private Boolean hdr;

	private String hdrType;

	private Integer framerate;

	private String language;

	private Integer sequence;

	private SegmentInfo segmentInfo;

	private Boolean embedded;

	private String audioType;

	private String closedCaptionFormat;

	public String getClosedCaptionFormat() {
		return closedCaptionFormat;
	}

	public void setClosedCaptionFormat(String closedCaptionFormat) {
		this.closedCaptionFormat = closedCaptionFormat;
	}

	public String getAudioType() {
		return audioType;
	}

	public void setAudioType(String audioType) {
		this.audioType = audioType;
	}

	public Boolean getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Boolean embedded) {
		this.embedded = embedded;
	}

	public void setFileLocator(String fileLocator) {
		this.fileLocator = fileLocator;
	}

	public String getFileLocator() {
		return this.fileLocator;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public String getCodec() {
		return this.codec;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getContainer() {
		return this.container;
	}

	public void setScreenFormat(String screenFormat) {
		this.screenFormat = screenFormat;
	}

	public String getScreenFormat() {
		return this.screenFormat;
	}

	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public String getVideoQuality() {
		return this.videoQuality;
	}

	public void setVideoQualityResolution(String videoQualityResolution) {
		this.videoQualityResolution = videoQualityResolution;
	}

	public String getVideoQualityResolution() {
		return this.videoQualityResolution;
	}

	public void setFramerate(Integer framerate) {
		this.framerate = framerate;
	}

	public Integer getFramerate() {
		return this.framerate;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getSequence() {
		return this.sequence;
	}

	public void setSegmentInfo(SegmentInfo segmentInfo) {
		this.segmentInfo = segmentInfo;
	}

	public SegmentInfo getSegmentInfo() {
		return this.segmentInfo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getHdr() {
		return hdr;
	}

	public void setHdr(Boolean hdr) {
		this.hdr = hdr;
	}

	public String getHdrType() {
		return hdrType;
	}

	public void setHdrType(String hdrType) {
		this.hdrType = hdrType;
	}

}
