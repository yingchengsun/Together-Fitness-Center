package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JfptTabCourseaskquestion entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabCourseaskquestion implements java.io.Serializable {

	// Fields

	private Integer FQuestionId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private String FContents;
	private Date FDateTime;
	private Set jfptTabCoursereplyquestions = new HashSet(0);

	// Constructors

	/** default constructor */
	public JfptTabCourseaskquestion() {
	}

	/** full constructor */
	public JfptTabCourseaskquestion(TabCourse tabCourse,
			TabStudents tabStudents, String FContents, Date FDateTime,
			Set jfptTabCoursereplyquestions) {
		this.tabCourse = tabCourse;
		this.tabStudents = tabStudents;
		this.FContents = FContents;
		this.FDateTime = FDateTime;
		this.jfptTabCoursereplyquestions = jfptTabCoursereplyquestions;
	}

	// Property accessors

	public Integer getFQuestionId() {
		return this.FQuestionId;
	}

	public void setFQuestionId(Integer FQuestionId) {
		this.FQuestionId = FQuestionId;
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

	public String getFContents() {
		return this.FContents;
	}

	public void setFContents(String FContents) {
		this.FContents = FContents;
	}

	public Date getFDateTime() {
		return this.FDateTime;
	}

	public void setFDateTime(Date FDateTime) {
		this.FDateTime = FDateTime;
	}

	public Set getJfptTabCoursereplyquestions() {
		return this.jfptTabCoursereplyquestions;
	}

	public void setJfptTabCoursereplyquestions(Set jfptTabCoursereplyquestions) {
		this.jfptTabCoursereplyquestions = jfptTabCoursereplyquestions;
	}

}