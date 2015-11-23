package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JfptTabCoursenotice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabCoursenotice implements java.io.Serializable {

	// Fields

	private Integer FNoticeId;
	private TabCourse tabCourse;
	private MhqxTabUser mhqxTabUser;
	private String FTitle;
	private Date FDate;
	private String FContent;
	private String FUrl;
	private Set jfptTabNoticetoreceives = new HashSet(0);

	// Constructors

	/** default constructor */
	public JfptTabCoursenotice() {
	}

	/** full constructor */
	public JfptTabCoursenotice(TabCourse tabCourse, MhqxTabUser mhqxTabUser,
			String FTitle, Date FDate, String FContent, String FUrl,
			Set jfptTabNoticetoreceives) {
		this.tabCourse = tabCourse;
		this.mhqxTabUser = mhqxTabUser;
		this.FTitle = FTitle;
		this.FDate = FDate;
		this.FContent = FContent;
		this.FUrl = FUrl;
		this.jfptTabNoticetoreceives = jfptTabNoticetoreceives;
	}

	// Property accessors

	public Integer getFNoticeId() {
		return this.FNoticeId;
	}

	public void setFNoticeId(Integer FNoticeId) {
		this.FNoticeId = FNoticeId;
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

	public String getFTitle() {
		return this.FTitle;
	}

	public void setFTitle(String FTitle) {
		this.FTitle = FTitle;
	}

	public Date getFDate() {
		return this.FDate;
	}

	public void setFDate(Date FDate) {
		this.FDate = FDate;
	}

	public String getFContent() {
		return this.FContent;
	}

	public void setFContent(String FContent) {
		this.FContent = FContent;
	}

	public String getFUrl() {
		return this.FUrl;
	}

	public void setFUrl(String FUrl) {
		this.FUrl = FUrl;
	}

	public Set getJfptTabNoticetoreceives() {
		return this.jfptTabNoticetoreceives;
	}

	public void setJfptTabNoticetoreceives(Set jfptTabNoticetoreceives) {
		this.jfptTabNoticetoreceives = jfptTabNoticetoreceives;
	}

}