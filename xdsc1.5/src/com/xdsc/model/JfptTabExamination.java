package com.xdsc.model;

/**
 * JfptTabExamination entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabExamination implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabCourse tabCourse;
	private String FZhiShiDian;
	private String FType;
	private String FNanDu;
	private String FQuestion;
	private String FAnswer;

	// Constructors

	/** default constructor */
	public JfptTabExamination() {
	}

	/** full constructor */
	public JfptTabExamination(TabCourse tabCourse, String FZhiShiDian,
			String FType, String FNanDu, String FQuestion, String FAnswer) {
		this.tabCourse = tabCourse;
		this.FZhiShiDian = FZhiShiDian;
		this.FType = FType;
		this.FNanDu = FNanDu;
		this.FQuestion = FQuestion;
		this.FAnswer = FAnswer;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFZhiShiDian() {
		return this.FZhiShiDian;
	}

	public void setFZhiShiDian(String FZhiShiDian) {
		this.FZhiShiDian = FZhiShiDian;
	}

	public String getFType() {
		return this.FType;
	}

	public void setFType(String FType) {
		this.FType = FType;
	}

	public String getFNanDu() {
		return this.FNanDu;
	}

	public void setFNanDu(String FNanDu) {
		this.FNanDu = FNanDu;
	}

	public String getFQuestion() {
		return this.FQuestion;
	}

	public void setFQuestion(String FQuestion) {
		this.FQuestion = FQuestion;
	}

	public String getFAnswer() {
		return this.FAnswer;
	}

	public void setFAnswer(String FAnswer) {
		this.FAnswer = FAnswer;
	}

}