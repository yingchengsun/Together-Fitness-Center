package com.xdsc.model;

/**
 * JfptTabNoticetoreceive entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabNoticetoreceive implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private JfptTabCoursenotice jfptTabCoursenotice;
	private MhqxTabUser mhqxTabUser;
	private String FMarkable;

	// Constructors

	/** default constructor */
	public JfptTabNoticetoreceive() {
	}

	/** full constructor */
	public JfptTabNoticetoreceive(JfptTabCoursenotice jfptTabCoursenotice,
			MhqxTabUser mhqxTabUser, String FMarkable) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
		this.mhqxTabUser = mhqxTabUser;
		this.FMarkable = FMarkable;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return this.jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFMarkable() {
		return this.FMarkable;
	}

	public void setFMarkable(String FMarkable) {
		this.FMarkable = FMarkable;
	}

}