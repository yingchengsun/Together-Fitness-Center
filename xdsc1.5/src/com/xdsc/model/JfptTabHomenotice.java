package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JfptTabHomenotice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabHomenotice implements java.io.Serializable {

	// Fields

	private Integer FHomeNoticeId;
	private TabCourse tabCourse;
	private MhqxTabUser mhqxTabUser;
	private String FTitle;
	private Date FDate;
	private String FContent;
	private String FUrl;
	private Set jfptTabHomenoticetoreceives = new HashSet(0);

	// Constructors

	/** default constructor */
	public JfptTabHomenotice() {
	}

	/** full constructor */
	public JfptTabHomenotice(TabCourse tabCourse, MhqxTabUser mhqxTabUser,
			String FTitle, Date FDate, String FContent, String FUrl,
			Set jfptTabHomenoticetoreceives) {
		this.tabCourse = tabCourse;
		this.mhqxTabUser = mhqxTabUser;
		this.FTitle = FTitle;
		this.FDate = FDate;
		this.FContent = FContent;
		this.FUrl = FUrl;
		this.jfptTabHomenoticetoreceives = jfptTabHomenoticetoreceives;
	}

	// Property accessors

	public Integer getFHomeNoticeId() {
		return this.FHomeNoticeId;
	}

	public void setFHomeNoticeId(Integer FHomeNoticeId) {
		this.FHomeNoticeId = FHomeNoticeId;
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

	public Set getJfptTabHomenoticetoreceives() {
		return this.jfptTabHomenoticetoreceives;
	}

	public void setJfptTabHomenoticetoreceives(Set jfptTabHomenoticetoreceives) {
		this.jfptTabHomenoticetoreceives = jfptTabHomenoticetoreceives;
	}

}