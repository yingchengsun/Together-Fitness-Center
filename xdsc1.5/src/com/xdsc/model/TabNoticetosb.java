package com.xdsc.model;

/**
 * TabNoticetosb entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabNoticetosb implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private MhqxTabUser mhqxTabUser;
	private TabNotice tabNotice;
	private String FAlreadyRead;

	// Constructors

	/** default constructor */
	public TabNoticetosb() {
	}

	/** full constructor */
	public TabNoticetosb(MhqxTabUser mhqxTabUser, TabNotice tabNotice,
			String FAlreadyRead) {
		this.mhqxTabUser = mhqxTabUser;
		this.tabNotice = tabNotice;
		this.FAlreadyRead = FAlreadyRead;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public TabNotice getTabNotice() {
		return this.tabNotice;
	}

	public void setTabNotice(TabNotice tabNotice) {
		this.tabNotice = tabNotice;
	}

	public String getFAlreadyRead() {
		return this.FAlreadyRead;
	}

	public void setFAlreadyRead(String FAlreadyRead) {
		this.FAlreadyRead = FAlreadyRead;
	}

}