package com.xdsc.model;

/**
 * JfptTabHomenoticetoreceive entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabHomenoticetoreceive implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private JfptTabHomenotice jfptTabHomenotice;
	private TabStudents tabStudents;
	private String FMarkable;

	// Constructors

	/** default constructor */
	public JfptTabHomenoticetoreceive() {
	}

	/** full constructor */
	public JfptTabHomenoticetoreceive(JfptTabHomenotice jfptTabHomenotice,
			TabStudents tabStudents, String FMarkable) {
		this.jfptTabHomenotice = jfptTabHomenotice;
		this.tabStudents = tabStudents;
		this.FMarkable = FMarkable;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public JfptTabHomenotice getJfptTabHomenotice() {
		return this.jfptTabHomenotice;
	}

	public void setJfptTabHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		this.jfptTabHomenotice = jfptTabHomenotice;
	}

	public TabStudents getTabStudents() {
		return this.tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFMarkable() {
		return this.FMarkable;
	}

	public void setFMarkable(String FMarkable) {
		this.FMarkable = FMarkable;
	}

}