package com.xdsc.model;

/**
 * XsglTabJiangzhugather entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabJiangzhugather implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabClasses tabClasses;
	private String FName;
	private String FYear;
	private Integer FAmount;
	private Integer FTotalNum;

	// Constructors

	/** default constructor */
	public XsglTabJiangzhugather() {
	}

	/** full constructor */
	public XsglTabJiangzhugather(TabClasses tabClasses, String FName,
			String FYear, Integer FAmount, Integer FTotalNum) {
		this.tabClasses = tabClasses;
		this.FName = FName;
		this.FYear = FYear;
		this.FAmount = FAmount;
		this.FTotalNum = FTotalNum;
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

	public Integer getFAmount() {
		return this.FAmount;
	}

	public void setFAmount(Integer FAmount) {
		this.FAmount = FAmount;
	}

	public Integer getFTotalNum() {
		return this.FTotalNum;
	}

	public void setFTotalNum(Integer FTotalNum) {
		this.FTotalNum = FTotalNum;
	}

}