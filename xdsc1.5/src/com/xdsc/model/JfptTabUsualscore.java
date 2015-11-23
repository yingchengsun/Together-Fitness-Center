package com.xdsc.model;

/**
 * JfptTabUsualscore entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabUsualscore implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private Integer FScore;
	private String FXueQi;
	private String FType;

	// Constructors

	/** default constructor */
	public JfptTabUsualscore() {
	}

	/** full constructor */
	public JfptTabUsualscore(TabCourse tabCourse, TabStudents tabStudents,
			Integer FScore, String FXueQi, String FType) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FScore = FScore;
		this.FXueQi = FXueQi;
		this.FType = FType;
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

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public Integer getFScore() {
		return this.FScore;
	}

	public void setFScore(Integer FScore) {
		this.FScore = FScore;
	}

	public String getFXueQi() {
		return this.FXueQi;
	}

	public void setFXueQi(String FXueQi) {
		this.FXueQi = FXueQi;
	}

	public String getFType() {
		return this.FType;
	}

	public void setFType(String FType) {
		this.FType = FType;
	}

}