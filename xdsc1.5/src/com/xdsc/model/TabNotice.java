package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TabNotice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabNotice implements java.io.Serializable {

	// Fields

	private Integer FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private Date FInfoStartTime;
	private String FModuleId;
	private String FInfoType;
	private String FInfoPath;
	private String FInfoFrom;
	private Set tabNoticetosbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabNotice() {
	}

	/** full constructor */
	public TabNotice(String FInfoTitle, String FInfoContet,
			Date FInfoStartTime, String FModuleId, String FInfoType,
			String FInfoPath, String FInfoFrom, Set tabNoticetosbs) {
		this.FInfoTitle = FInfoTitle;
		this.FInfoContet = FInfoContet;
		this.FInfoStartTime = FInfoStartTime;
		this.FModuleId = FModuleId;
		this.FInfoType = FInfoType;
		this.FInfoPath = FInfoPath;
		this.FInfoFrom = FInfoFrom;
		this.tabNoticetosbs = tabNoticetosbs;
	}

	// Property accessors

	public Integer getFInfoId() {
		return this.FInfoId;
	}

	public void setFInfoId(Integer FInfoId) {
		this.FInfoId = FInfoId;
	}

	public String getFInfoTitle() {
		return this.FInfoTitle;
	}

	public void setFInfoTitle(String FInfoTitle) {
		this.FInfoTitle = FInfoTitle;
	}

	public String getFInfoContet() {
		return this.FInfoContet;
	}

	public void setFInfoContet(String FInfoContet) {
		this.FInfoContet = FInfoContet;
	}

	public Date getFInfoStartTime() {
		return this.FInfoStartTime;
	}

	public void setFInfoStartTime(Date FInfoStartTime) {
		this.FInfoStartTime = FInfoStartTime;
	}

	public String getFModuleId() {
		return this.FModuleId;
	}

	public void setFModuleId(String FModuleId) {
		this.FModuleId = FModuleId;
	}

	public String getFInfoType() {
		return this.FInfoType;
	}

	public void setFInfoType(String FInfoType) {
		this.FInfoType = FInfoType;
	}

	public String getFInfoPath() {
		return this.FInfoPath;
	}

	public void setFInfoPath(String FInfoPath) {
		this.FInfoPath = FInfoPath;
	}

	public String getFInfoFrom() {
		return this.FInfoFrom;
	}

	public void setFInfoFrom(String FInfoFrom) {
		this.FInfoFrom = FInfoFrom;
	}

	public Set getTabNoticetosbs() {
		return this.tabNoticetosbs;
	}

	public void setTabNoticetosbs(Set tabNoticetosbs) {
		this.tabNoticetosbs = tabNoticetosbs;
	}

}