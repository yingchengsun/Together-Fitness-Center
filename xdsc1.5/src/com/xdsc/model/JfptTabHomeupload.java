package com.xdsc.model;

import java.util.Date;

/**
 * JfptTabHomeupload entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabHomeupload implements java.io.Serializable {

	// Fields

	private Integer FHomeId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private String FHomeTitle;
	private String FHomeContet;
	private Date FHomeTime;
	private String FFilePath;
	private String FRead;
	private String FReply;
	private String FReplyRead;

	// Constructors

	/** default constructor */
	public JfptTabHomeupload() {
	}

	/** full constructor */
	public JfptTabHomeupload(TabCourse tabCourse, TabStudents tabStudents,
			String FHomeTitle, String FHomeContet, Date FHomeTime,
			String FFilePath, String FRead, String FReply, String FReplyRead) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FHomeTitle = FHomeTitle;
		this.FHomeContet = FHomeContet;
		this.FHomeTime = FHomeTime;
		this.FFilePath = FFilePath;
		this.FRead = FRead;
		this.FReply = FReply;
		this.FReplyRead = FReplyRead;
	}

	// Property accessors

	public Integer getFHomeId() {
		return this.FHomeId;
	}

	public void setFHomeId(Integer FHomeId) {
		this.FHomeId = FHomeId;
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

	public String getFHomeTitle() {
		return this.FHomeTitle;
	}

	public void setFHomeTitle(String FHomeTitle) {
		this.FHomeTitle = FHomeTitle;
	}

	public String getFHomeContet() {
		return this.FHomeContet;
	}

	public void setFHomeContet(String FHomeContet) {
		this.FHomeContet = FHomeContet;
	}

	public Date getFHomeTime() {
		return this.FHomeTime;
	}

	public void setFHomeTime(Date FHomeTime) {
		this.FHomeTime = FHomeTime;
	}

	public String getFFilePath() {
		return this.FFilePath;
	}

	public void setFFilePath(String FFilePath) {
		this.FFilePath = FFilePath;
	}

	public String getFRead() {
		return this.FRead;
	}

	public void setFRead(String FRead) {
		this.FRead = FRead;
	}

	public String getFReply() {
		return this.FReply;
	}

	public void setFReply(String FReply) {
		this.FReply = FReply;
	}

	public String getFReplyRead() {
		return this.FReplyRead;
	}

	public void setFReplyRead(String FReplyRead) {
		this.FReplyRead = FReplyRead;
	}

}