package com.xdsc.model;

/**
 * JfptTabStudentteacher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabStudentteacher implements java.io.Serializable {

	// Fields

	private JfptTabStudentteacherId id;

	// Constructors

	/** default constructor */
	public JfptTabStudentteacher() {
	}

	/** full constructor */
	public JfptTabStudentteacher(JfptTabStudentteacherId id) {
		this.id = id;
	}

	// Property accessors

	public JfptTabStudentteacherId getId() {
		return this.id;
	}

	public void setId(JfptTabStudentteacherId id) {
		this.id = id;
	}

}