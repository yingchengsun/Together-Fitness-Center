package com.xdsc.model;

/**
 * JfptTabAssistantapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabAssistantapply implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabTeachers tabTeachers;
	private TabCourse tabCourse;
	private String FAssistantId;
	private String FShenQing;

	// Constructors

	/** default constructor */
	public JfptTabAssistantapply() {
	}

	/** full constructor */
	public JfptTabAssistantapply(TabTeachers tabTeachers, TabCourse tabCourse,
			String FAssistantId, String FShenQing) {
		this.tabTeachers = tabTeachers;
		this.tabCourse = tabCourse;
		this.FAssistantId = FAssistantId;
		this.FShenQing = FShenQing;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabTeachers getTabTeachers() {
		return this.tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabCourse getTabCourse() {
		return this.tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFAssistantId() {
		return this.FAssistantId;
	}

	public void setFAssistantId(String FAssistantId) {
		this.FAssistantId = FAssistantId;
	}

	public String getFShenQing() {
		return this.FShenQing;
	}

	public void setFShenQing(String FShenQing) {
		this.FShenQing = FShenQing;
	}

}