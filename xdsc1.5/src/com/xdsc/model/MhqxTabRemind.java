package com.xdsc.model;

import java.util.Date;

/**
 * MhqxTabRemind entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabRemind implements java.io.Serializable {

	// Fields

	private Integer FId;
	private MhqxTabModule mhqxTabModule;
	private String FRemindType;//UserNumber
	private Date FRemindTime;
	private String FRemindUrl;//css path

	// Constructors

	/** default constructor */
	public MhqxTabRemind() {
	}

	/** full constructor */
	public MhqxTabRemind(MhqxTabModule mhqxTabModule, String FRemindType,
			Date FRemindTime, String FRemindUrl) {
		this.mhqxTabModule = mhqxTabModule;
		this.FRemindType = FRemindType;
		this.FRemindTime = FRemindTime;
		this.FRemindUrl = FRemindUrl;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public MhqxTabModule getMhqxTabModule() {
		return this.mhqxTabModule;
	}

	public void setMhqxTabModule(MhqxTabModule mhqxTabModule) {
		this.mhqxTabModule = mhqxTabModule;
	}

	public String getFRemindType() {
		return this.FRemindType;
	}

	public void setFRemindType(String FRemindType) {
		this.FRemindType = FRemindType;
	}

	public Date getFRemindTime() {
		return this.FRemindTime;
	}

	public void setFRemindTime(Date FRemindTime) {
		this.FRemindTime = FRemindTime;
	}

	public String getFRemindUrl() {
		return this.FRemindUrl;
	}

	public void setFRemindUrl(String FRemindUrl) {
		this.FRemindUrl = FRemindUrl;
	}

}