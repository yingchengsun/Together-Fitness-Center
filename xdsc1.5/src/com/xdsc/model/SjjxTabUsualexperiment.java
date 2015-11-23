package com.xdsc.model;

import java.util.Date;

/**
 * SjjxTabUsualexperiment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabUsualexperiment implements java.io.Serializable {

	// Fields

	private Integer FId;
	private SjjxTabLab sjjxTabLab;
	private TabStudents tabStudents;
	private Date FBeginTime;
	private Date FEndTime;

	// Constructors

	/** default constructor */
	public SjjxTabUsualexperiment() {
	}

	/** full constructor */
	public SjjxTabUsualexperiment(SjjxTabLab sjjxTabLab,
			TabStudents tabStudents, Date FBeginTime, Date FEndTime) {
		this.sjjxTabLab = sjjxTabLab;
		this.tabStudents = tabStudents;
		this.FBeginTime = FBeginTime;
		this.FEndTime = FEndTime;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public SjjxTabLab getSjjxTabLab() {
		return this.sjjxTabLab;
	}

	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
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

}