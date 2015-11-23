package com.xdsc.model;

/**
 * MhqxTabPicture entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabPicture implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabInformation tabInformation;
	private String FPicTitle;
	private String FPicContent;
	private String FZuiXin;

	// Constructors

	/** default constructor */
	public MhqxTabPicture() {
	}

	/** full constructor */
	public MhqxTabPicture(TabInformation tabInformation, String FPicTitle,
			String FPicContent, String FZuiXin) {
		this.tabInformation = tabInformation;
		this.FPicTitle = FPicTitle;
		this.FPicContent = FPicContent;
		this.FZuiXin = FZuiXin;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabInformation getTabInformation() {
		return this.tabInformation;
	}

	public void setTabInformation(TabInformation tabInformation) {
		this.tabInformation = tabInformation;
	}

	public String getFPicTitle() {
		return this.FPicTitle;
	}

	public void setFPicTitle(String FPicTitle) {
		this.FPicTitle = FPicTitle;
	}

	public String getFPicContent() {
		return this.FPicContent;
	}

	public void setFPicContent(String FPicContent) {
		this.FPicContent = FPicContent;
	}

	public String getFZuiXin() {
		return this.FZuiXin;
	}

	public void setFZuiXin(String FZuiXin) {
		this.FZuiXin = FZuiXin;
	}

}