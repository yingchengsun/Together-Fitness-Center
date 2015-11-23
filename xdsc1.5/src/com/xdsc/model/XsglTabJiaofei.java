package com.xdsc.model;

/**
 * XsglTabJiaofei entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabJiaofei implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabStudents tabStudents;
	private String FYear;
	private Integer FTuition;
	private Integer FAccommodation;
	private Integer FTotal;

	// Constructors

	/** default constructor */
	public XsglTabJiaofei() {
	}

	/** full constructor */
	public XsglTabJiaofei(TabStudents tabStudents, String FYear,
			Integer FTuition, Integer FAccommodation, Integer FTotal) {
		this.tabStudents = tabStudents;
		this.FYear = FYear;
		this.FTuition = FTuition;
		this.FAccommodation = FAccommodation;
		this.FTotal = FTotal;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFYear() {
		return this.FYear;
	}

	public void setFYear(String FYear) {
		this.FYear = FYear;
	}

	public Integer getFTuition() {
		return this.FTuition;
	}

	public void setFTuition(Integer FTuition) {
		this.FTuition = FTuition;
	}

	public Integer getFAccommodation() {
		return this.FAccommodation;
	}

	public void setFAccommodation(Integer FAccommodation) {
		this.FAccommodation = FAccommodation;
	}

	public Integer getFTotal() {
		return this.FTotal;
	}

	public void setFTotal(Integer FTotal) {
		this.FTotal = FTotal;
	}

}