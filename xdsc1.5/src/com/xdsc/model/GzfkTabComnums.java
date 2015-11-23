package com.xdsc.model;

import java.util.Date;

/**
 * GzfkTabComnums entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabComnums implements java.io.Serializable {

	// Fields

	private Integer FId;
	private TabCompany tabCompany;
	private Date FComNumYear;
	private Integer FComNum;
	private String FContactPerson;

	// Constructors

	/** default constructor */
	public GzfkTabComnums() {
	}

	/** full constructor */
	public GzfkTabComnums(TabCompany tabCompany, Date FComNumYear,
			Integer FComNum, String FContactPerson) {
		this.tabCompany = tabCompany;
		this.FComNumYear = FComNumYear;
		this.FComNum = FComNum;
		this.FContactPerson = FContactPerson;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public TabCompany getTabCompany() {
		return this.tabCompany;
	}

	public void setTabCompany(TabCompany tabCompany) {
		this.tabCompany = tabCompany;
	}

	public Date getFComNumYear() {
		return this.FComNumYear;
	}

	public void setFComNumYear(Date FComNumYear) {
		this.FComNumYear = FComNumYear;
	}

	public Integer getFComNum() {
		return this.FComNum;
	}

	public void setFComNum(Integer FComNum) {
		this.FComNum = FComNum;
	}

	public String getFContactPerson() {
		return this.FContactPerson;
	}

	public void setFContactPerson(String FContactPerson) {
		this.FContactPerson = FContactPerson;
	}

}