package com.xdsc.model;

/**
 * XsglTabJiaofeigather entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabJiaofeigather implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabClasses tabClasses;
	private String FName;
	private String FYear;
	private Integer FTotalNum;
	private Integer FAmount;
	private String FRemark;

	// Constructors

	/** default constructor */
	public XsglTabJiaofeigather() {
	}

	/** full constructor */
	public XsglTabJiaofeigather(TabClasses tabClasses, String FName,
			String FYear, Integer FTotalNum, Integer FAmount, String FRemark) {
		this.tabClasses = tabClasses;
		this.FName = FName;
		this.FYear = FYear;
		this.FTotalNum = FTotalNum;
		this.FAmount = FAmount;
		this.FRemark = FRemark;
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

	public String getFYear() {
		return this.FYear;
	}

	public void setFYear(String FYear) {
		this.FYear = FYear;
	}

	public Integer getFTotalNum() {
		return this.FTotalNum;
	}

	public void setFTotalNum(Integer FTotalNum) {
		this.FTotalNum = FTotalNum;
	}

	public Integer getFAmount() {
		return this.FAmount;
	}

	public void setFAmount(Integer FAmount) {
		this.FAmount = FAmount;
	}

	public String getFRemark() {
		return this.FRemark;
	}

	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}

}