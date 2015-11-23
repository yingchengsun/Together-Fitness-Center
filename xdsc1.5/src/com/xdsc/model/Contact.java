package com.xdsc.model;

/**
 * Contact entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Contact implements java.io.Serializable {

	// Fields

	private Integer CId;
	private String CUsername;
	private String CName;
	private String CPassword;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** full constructor */
	public Contact(String CUsername, String CName, String CPassword) {
		this.CUsername = CUsername;
		this.CName = CName;
		this.CPassword = CPassword;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public String getCUsername() {
		return this.CUsername;
	}

	public void setCUsername(String CUsername) {
		this.CUsername = CUsername;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCPassword() {
		return this.CPassword;
	}

	public void setCPassword(String CPassword) {
		this.CPassword = CPassword;
	}

}