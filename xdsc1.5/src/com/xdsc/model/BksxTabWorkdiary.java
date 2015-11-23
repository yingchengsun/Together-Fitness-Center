package com.xdsc.model;

import java.util.Date;

/**
 * BksxTabWorkdiary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabWorkdiary implements java.io.Serializable {

	// Fields

	private Integer FWid;
	private BksxTabSubstugui bksxTabSubstugui;
	private String FDiaryAuthor;
	private Date FDiaryDate;
	private String FDiaryTitle;
	private String FDiaryContent;

	// Constructors

	/** default constructor */
	public BksxTabWorkdiary() {
	}

	/** full constructor */
	public BksxTabWorkdiary(BksxTabSubstugui bksxTabSubstugui,
			String FDiaryAuthor, Date FDiaryDate, String FDiaryTitle,
			String FDiaryContent) {
		this.bksxTabSubstugui = bksxTabSubstugui;
		this.FDiaryAuthor = FDiaryAuthor;
		this.FDiaryDate = FDiaryDate;
		this.FDiaryTitle = FDiaryTitle;
		this.FDiaryContent = FDiaryContent;
	}

	// Property accessors

	public Integer getFWid() {
		return this.FWid;
	}

	public void setFWid(Integer FWid) {
		this.FWid = FWid;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return this.bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public String getFDiaryAuthor() {
		return this.FDiaryAuthor;
	}

	public void setFDiaryAuthor(String FDiaryAuthor) {
		this.FDiaryAuthor = FDiaryAuthor;
	}

	public Date getFDiaryDate() {
		return this.FDiaryDate;
	}

	public void setFDiaryDate(Date FDiaryDate) {
		this.FDiaryDate = FDiaryDate;
	}

	public String getFDiaryTitle() {
		return this.FDiaryTitle;
	}

	public void setFDiaryTitle(String FDiaryTitle) {
		this.FDiaryTitle = FDiaryTitle;
	}

	public String getFDiaryContent() {
		return this.FDiaryContent;
	}

	public void setFDiaryContent(String FDiaryContent) {
		this.FDiaryContent = FDiaryContent;
	}

}