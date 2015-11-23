package com.xdsc.model;

/**
 * XsglTabPartygather entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabPartygather implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabClasses tabClasses;
	private String FName;
	private Integer FMaleNum;
	private Integer FFemaleNum;
	private Integer FTotalNum;
	private String FYear;

	// Constructors

	/** default constructor */
	public XsglTabPartygather() {
	}

	/** full constructor */
	public XsglTabPartygather(TabClasses tabClasses, String FName,
			Integer FMaleNum, Integer FFemaleNum, Integer FTotalNum,
			String FYear) {
		this.tabClasses = tabClasses;
		this.FName = FName;
		this.FMaleNum = FMaleNum;
		this.FFemaleNum = FFemaleNum;
		this.FTotalNum = FTotalNum;
		this.FYear = FYear;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabClasses getTabClasses() {
		return this.tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public Integer getFMaleNum() {
		return this.FMaleNum;
	}

	public void setFMaleNum(Integer FMaleNum) {
		this.FMaleNum = FMaleNum;
	}

	public Integer getFFemaleNum() {
		return this.FFemaleNum;
	}

	public void setFFemaleNum(Integer FFemaleNum) {
		this.FFemaleNum = FFemaleNum;
	}

	public Integer getFTotalNum() {
		return this.FTotalNum;
	}

	public void setFTotalNum(Integer FTotalNum) {
		this.FTotalNum = FTotalNum;
	}

	public String getFYear() {
		return this.FYear;
	}

	public void setFYear(String FYear) {
		this.FYear = FYear;
	}

}