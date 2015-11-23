package com.xdsc.model;

import java.util.Date;

/**
 * SjjxTabAttendance entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabAttendance implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private String FXueQi;
	private Integer FSerNumber;
	private Date FBeginTime;
	private Date FEndTime;
	private String FState;

	// Constructors

	/** default constructor */
	public SjjxTabAttendance() {
	}

	/** full constructor */
	public SjjxTabAttendance(TabCourse tabCourse, TabStudents tabStudents,
			String FXueQi, Integer FSerNumber, Date FBeginTime, Date FEndTime,
			String FState) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FXueQi = FXueQi;
		this.FSerNumber = FSerNumber;
		this.FBeginTime = FBeginTime;
		this.FEndTime = FEndTime;
		this.FState = FState;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
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

	public String getFXueQi() {
		return this.FXueQi;
	}

	public void setFXueQi(String FXueQi) {
		this.FXueQi = FXueQi;
	}

	public Integer getFSerNumber() {
		return this.FSerNumber;
	}

	public void setFSerNumber(Integer FSerNumber) {
		this.FSerNumber = FSerNumber;
	}

	public Date getFBeginTime() {
		return this.FBeginTime;
	}

	public void setFBeginTime(Date FBeginTime) {
		this.FBeginTime = FBeginTime;
	}

	public Date getFEndTime() {
		return this.FEndTime;
	}

	public void setFEndTime(Date FEndTime) {
		this.FEndTime = FEndTime;
	}

	public String getFState() {
		return this.FState;
	}

	public void setFState(String FState) {
		this.FState = FState;
	}

}