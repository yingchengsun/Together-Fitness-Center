package com.xdsc.model;

import java.util.Date;

/**
 * JfptTabCoursereplyquestion entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabCoursereplyquestion implements java.io.Serializable {

	// Fields

	private Integer FReplyId;
	private JfptTabCourseaskquestion jfptTabCourseaskquestion;
	private String FContents;
	private String FReplyUserId;
	private Date FDateTime;

	// Constructors

	/** default constructor */
	public JfptTabCoursereplyquestion() {
	}

	/** full constructor */
	public JfptTabCoursereplyquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion,
			String FContents, String FReplyUserId, Date FDateTime) {
		this.jfptTabCourseaskquestion = jfptTabCourseaskquestion;
		this.FContents = FContents;
		this.FReplyUserId = FReplyUserId;
		this.FDateTime = FDateTime;
	}

	// Property accessors

	public Integer getFReplyId() {
		return this.FReplyId;
	}

	public void setFReplyId(Integer FReplyId) {
		this.FReplyId = FReplyId;
	}

	public JfptTabCourseaskquestion getJfptTabCourseaskquestion() {
		return this.jfptTabCourseaskquestion;
	}

	public void setJfptTabCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		this.jfptTabCourseaskquestion = jfptTabCourseaskquestion;
	}

	public String getFContents() {
		return this.FContents;
	}

	public void setFContents(String FContents) {
		this.FContents = FContents;
	}

	public String getFReplyUserId() {
		return this.FReplyUserId;
	}

	public void setFReplyUserId(String FReplyUserId) {
		this.FReplyUserId = FReplyUserId;
	}

	public Date getFDateTime() {
		return this.FDateTime;
	}

	public void setFDateTime(Date FDateTime) {
		this.FDateTime = FDateTime;
	}

}