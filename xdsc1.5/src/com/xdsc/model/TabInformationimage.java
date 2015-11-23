package com.xdsc.model;

/**
 * TabInformationimage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabInformationimage implements java.io.Serializable {

	// Fields

	private Integer FImgId;
	private TabInformation tabInformation;
	private String FImgPath;

	// Constructors

	/** default constructor */
	public TabInformationimage() {
	}

	/** full constructor */
	public TabInformationimage(TabInformation tabInformation, String FImgPath) {
		this.tabInformation = tabInformation;
		this.FImgPath = FImgPath;
	}

	// Property accessors

	public Integer getFImgId() {
		return this.FImgId;
	}

	public void setFImgId(Integer FImgId) {
		this.FImgId = FImgId;
	}

	public TabInformation getTabInformation() {
		return this.tabInformation;
	}

	public void setTabInformation(TabInformation tabInformation) {
		this.tabInformation = tabInformation;
	}

	public String getFImgPath() {
		return this.FImgPath;
	}

	public void setFImgPath(String FImgPath) {
		this.FImgPath = FImgPath;
	}

}