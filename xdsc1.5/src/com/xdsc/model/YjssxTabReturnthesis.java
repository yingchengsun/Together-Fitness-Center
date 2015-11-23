package com.xdsc.model;

import java.util.Date;

/**
 * YjssxTabReturnthesis entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class YjssxTabReturnthesis implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabTeachers tabTeachers;
	private TabPostgraduate tabPostgraduate;
	private String FThesisName;
	private String FComment;
	private String FThesisStorePath;
	private String FThesisIsReturn;
	private Date FDate;
	private String FThesisType;
	private String FStatus;
	private String FReason;

	// Constructors

	/** default constructor */
	public YjssxTabReturnthesis() {
	}

	/** full constructor */
	public YjssxTabReturnthesis(TabTeachers tabTeachers,
			TabPostgraduate tabPostgraduate, String FThesisName,
			String FComment, String FThesisStorePath, String FThesisIsReturn,
			Date FDate, String FThesisType, String FStatus, String FReason) {
		this.tabTeachers = tabTeachers;
		this.tabPostgraduate = tabPostgraduate;
		this.FThesisName = FThesisName;
		this.FComment = FComment;
		this.FThesisStorePath = FThesisStorePath;
		this.FThesisIsReturn = FThesisIsReturn;
		this.FDate = FDate;
		this.FThesisType = FThesisType;
		this.FStatus = FStatus;
		this.FReason = FReason;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabPostgraduate getTabPostgraduate() {
		return this.tabPostgraduate;
	}

	public void setTabPostgraduate(TabPostgraduate tabPostgraduate) {
		this.tabPostgraduate = tabPostgraduate;
	}

	public String getFThesisName() {
		return this.FThesisName;
	}

	public void setFThesisName(String FThesisName) {
		this.FThesisName = FThesisName;
	}

	public String getFComment() {
		return this.FComment;
	}

	public void setFComment(String FComment) {
		this.FComment = FComment;
	}

	public String getFThesisStorePath() {
		return this.FThesisStorePath;
	}

	public void setFThesisStorePath(String FThesisStorePath) {
		this.FThesisStorePath = FThesisStorePath;
	}

	public String getFThesisIsReturn() {
		return this.FThesisIsReturn;
	}

	public void setFThesisIsReturn(String FThesisIsReturn) {
		this.FThesisIsReturn = FThesisIsReturn;
	}

	public Date getFDate() {
		return this.FDate;
	}

	public void setFDate(Date FDate) {
		this.FDate = FDate;
	}

	public String getFThesisType() {
		return this.FThesisType;
	}

	public void setFThesisType(String FThesisType) {
		this.FThesisType = FThesisType;
	}

	public String getFStatus() {
		return this.FStatus;
	}

	public void setFStatus(String FStatus) {
		this.FStatus = FStatus;
	}

	public String getFReason() {
		return this.FReason;
	}

	public void setFReason(String FReason) {
		this.FReason = FReason;
	}

}