package com.xdsc.model;

import java.util.Date;

/**
 * JfptTabUploadfile entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabUploadfile implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private TabCourse tabCourse;
	private MhqxTabUser mhqxTabUser;
	private Date FUpTime;
	private String FFileName;
	private String FFileDetail;
	private String FInfoPath;

	// Constructors

	/** default constructor */
	public JfptTabUploadfile() {
	}

	/** full constructor */
	public JfptTabUploadfile(TabCourse tabCourse, MhqxTabUser mhqxTabUser,
			Date FUpTime, String FFileName, String FFileDetail, String FInfoPath) {
		this.tabCourse = tabCourse;
		this.mhqxTabUser = mhqxTabUser;
		this.FUpTime = FUpTime;
		this.FFileName = FFileName;
		this.FFileDetail = FFileDetail;
		this.FInfoPath = FInfoPath;
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

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public Date getFUpTime() {
		return this.FUpTime;
	}

	public void setFUpTime(Date FUpTime) {
		this.FUpTime = FUpTime;
	}

	public String getFFileName() {
		return this.FFileName;
	}

	public void setFFileName(String FFileName) {
		this.FFileName = FFileName;
	}

	public String getFFileDetail() {
		return this.FFileDetail;
	}

	public void setFFileDetail(String FFileDetail) {
		this.FFileDetail = FFileDetail;
	}

	public String getFInfoPath() {
		return this.FInfoPath;
	}

	public void setFInfoPath(String FInfoPath) {
		this.FInfoPath = FInfoPath;
	}

}