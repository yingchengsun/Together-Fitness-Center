package com.xdsc.model;

/**
 * MhqxTabNavigation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabNavigation implements java.io.Serializable {

	// Fields

	private Integer FNavigationId;
	private String FNavigationName;
	private String FNavigationPicUrl;
	private String FNavigationUrl;
	private Integer FNavigationPriority;

	// Constructors

	/** default constructor */
	public MhqxTabNavigation() {
	}

	/** full constructor */
	public MhqxTabNavigation(String FNavigationName, String FNavigationPicUrl,
			String FNavigationUrl, Integer FNavigationPriority) {
		this.FNavigationName = FNavigationName;
		this.FNavigationPicUrl = FNavigationPicUrl;
		this.FNavigationUrl = FNavigationUrl;
		this.FNavigationPriority = FNavigationPriority;
	}

	// Property accessors

	public Integer getFNavigationId() {
		return this.FNavigationId;
	}

	public void setFNavigationId(Integer FNavigationId) {
		this.FNavigationId = FNavigationId;
	}

	public String getFNavigationName() {
		return this.FNavigationName;
	}

	public void setFNavigationName(String FNavigationName) {
		this.FNavigationName = FNavigationName;
	}

	public String getFNavigationPicUrl() {
		return this.FNavigationPicUrl;
	}

	public void setFNavigationPicUrl(String FNavigationPicUrl) {
		this.FNavigationPicUrl = FNavigationPicUrl;
	}

	public String getFNavigationUrl() {
		return this.FNavigationUrl;
	}

	public void setFNavigationUrl(String FNavigationUrl) {
		this.FNavigationUrl = FNavigationUrl;
	}

	public Integer getFNavigationPriority() {
		return this.FNavigationPriority;
	}

	public void setFNavigationPriority(Integer FNavigationPriority) {
		this.FNavigationPriority = FNavigationPriority;
	}

}