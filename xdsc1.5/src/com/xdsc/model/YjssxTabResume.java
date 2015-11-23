package com.xdsc.model;

/**
 * YjssxTabResume entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class YjssxTabResume implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabCompany tabCompany;
	private TabPostgraduate tabPostgraduate;
	private String FFilePath;

	// Constructors

	/** default constructor */
	public YjssxTabResume() {
	}

	/** full constructor */
	public YjssxTabResume(TabCompany tabCompany,
			TabPostgraduate tabPostgraduate, String FFilePath) {
		this.tabCompany = tabCompany;
		this.tabPostgraduate = tabPostgraduate;
		this.FFilePath = FFilePath;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabCompany getTabCompany() {
		return this.tabCompany;
	}

	public void setTabCompany(TabCompany tabCompany) {
		this.tabCompany = tabCompany;
	}

	public TabPostgraduate getTabPostgraduate() {
		return this.tabPostgraduate;
	}

	public void setTabPostgraduate(TabPostgraduate tabPostgraduate) {
		this.tabPostgraduate = tabPostgraduate;
	}

	public String getFFilePath() {
		return this.FFilePath;
	}

	public void setFFilePath(String FFilePath) {
		this.FFilePath = FFilePath;
	}

}