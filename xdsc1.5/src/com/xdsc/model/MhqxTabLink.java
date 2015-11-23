package com.xdsc.model;

/**
 * MhqxTabLink entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabLink implements java.io.Serializable {

	// Fields

	private Integer FLinkId;
	private String FLinkTitle;
	private String FLinkUrl;
	private Integer FLinkPriority;

	// Constructors

	/** default constructor */
	public MhqxTabLink() {
	}

	/** full constructor */
	public MhqxTabLink(String FLinkTitle, String FLinkUrl, Integer FLinkPriority) {
		this.FLinkTitle = FLinkTitle;
		this.FLinkUrl = FLinkUrl;
		this.FLinkPriority = FLinkPriority;
	}

	// Property accessors

	public Integer getFLinkId() {
		return this.FLinkId;
	}

	public void setFLinkId(Integer FLinkId) {
		this.FLinkId = FLinkId;
	}

	public String getFLinkTitle() {
		return this.FLinkTitle;
	}

	public void setFLinkTitle(String FLinkTitle) {
		this.FLinkTitle = FLinkTitle;
	}

	public String getFLinkUrl() {
		return this.FLinkUrl;
	}

	public void setFLinkUrl(String FLinkUrl) {
		this.FLinkUrl = FLinkUrl;
	}

	public Integer getFLinkPriority() {
		return this.FLinkPriority;
	}

	public void setFLinkPriority(Integer FLinkPriority) {
		this.FLinkPriority = FLinkPriority;
	}

}