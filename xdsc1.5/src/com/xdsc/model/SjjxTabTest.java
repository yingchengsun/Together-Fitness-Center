package com.xdsc.model;

import java.util.Date;

/**
 * SjjxTabTest entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabTest implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private Integer FTestNumber;
	private Integer FTestScore;
	private Date FStartTime;
	private Date FFinishTime;
	private Date FLimitTime;

	// Constructors

	/** default constructor */
	public SjjxTabTest() {
	}

	/** full constructor */
	public SjjxTabTest(TabCourse tabCourse, TabStudents tabStudents,
			Integer FTestNumber, Integer FTestScore, Date FStartTime,
			Date FFinishTime, Date FLimitTime) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FTestNumber = FTestNumber;
		this.FTestScore = FTestScore;
		this.FStartTime = FStartTime;
		this.FFinishTime = FFinishTime;
		this.FLimitTime = FLimitTime;
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

	public Integer getFTestNumber() {
		return this.FTestNumber;
	}

	public void setFTestNumber(Integer FTestNumber) {
		this.FTestNumber = FTestNumber;
	}

	public Integer getFTestScore() {
		return this.FTestScore;
	}

	public void setFTestScore(Integer FTestScore) {
		this.FTestScore = FTestScore;
	}

	public Date getFStartTime() {
		return this.FStartTime;
	}

	public void setFStartTime(Date FStartTime) {
		this.FStartTime = FStartTime;
	}

	public Date getFFinishTime() {
		return this.FFinishTime;
	}

	public void setFFinishTime(Date FFinishTime) {
		this.FFinishTime = FFinishTime;
	}

	public Date getFLimitTime() {
		return this.FLimitTime;
	}

	public void setFLimitTime(Date FLimitTime) {
		this.FLimitTime = FLimitTime;
	}

}