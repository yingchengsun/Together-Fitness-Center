package com.xdsc.model;

/**
 * BksxTabSubjectapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabSubjectapply implements java.io.Serializable {

	// Fields

	private Integer id;
	private BksxTabSubstugui bksxTabSubstugui;
	private TabStudents tabStudents;
	private String FStatus;

	// Constructors

	/** default constructor */
	public BksxTabSubjectapply() {
	}

	/** full constructor */
	public BksxTabSubjectapply(BksxTabSubstugui bksxTabSubstugui,
			TabStudents tabStudents, String FStatus) {
		this.bksxTabSubstugui = bksxTabSubstugui;
		this.tabStudents = tabStudents;
		this.FStatus = FStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return this.bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFStatus() {
		return this.FStatus;
	}

	public void setFStatus(String FStatus) {
		this.FStatus = FStatus;
	}

}