package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * XsglTabDepartment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabDepartment implements java.io.Serializable {

	// Fields

	private Integer FDid;
	private XsglTabOrganizations xsglTabOrganizations;
	private String FDname;
	private Date FBuildTime;
	private String FIntroduce;
	private Integer FTotal;
	private Set xsglTabStuorgadeparts = new HashSet(0);

	// Constructors

	/** default constructor */
	public XsglTabDepartment() {
	}

	/** full constructor */
	public XsglTabDepartment(XsglTabOrganizations xsglTabOrganizations,
			String FDname, Date FBuildTime, String FIntroduce, Integer FTotal,
			Set xsglTabStuorgadeparts) {
		this.xsglTabOrganizations = xsglTabOrganizations;
		this.FDname = FDname;
		this.FBuildTime = FBuildTime;
		this.FIntroduce = FIntroduce;
		this.FTotal = FTotal;
		this.xsglTabStuorgadeparts = xsglTabStuorgadeparts;
	}

	// Property accessors

	public Integer getFDid() {
		return this.FDid;
	}

	public void setFDid(Integer FDid) {
		this.FDid = FDid;
	}

	public XsglTabOrganizations getXsglTabOrganizations() {
		return this.xsglTabOrganizations;
	}

	public void setXsglTabOrganizations(
			XsglTabOrganizations xsglTabOrganizations) {
		this.xsglTabOrganizations = xsglTabOrganizations;
	}

	public String getFDname() {
		return this.FDname;
	}

	public void setFDname(String FDname) {
		this.FDname = FDname;
	}

	public Date getFBuildTime() {
		return this.FBuildTime;
	}

	public void setFBuildTime(Date FBuildTime) {
		this.FBuildTime = FBuildTime;
	}

	public String getFIntroduce() {
		return this.FIntroduce;
	}

	public void setFIntroduce(String FIntroduce) {
		this.FIntroduce = FIntroduce;
	}

	public Integer getFTotal() {
		return this.FTotal;
	}

	public void setFTotal(Integer FTotal) {
		this.FTotal = FTotal;
	}

	public Set getXsglTabStuorgadeparts() {
		return this.xsglTabStuorgadeparts;
	}

	public void setXsglTabStuorgadeparts(Set xsglTabStuorgadeparts) {
		this.xsglTabStuorgadeparts = xsglTabStuorgadeparts;
	}

}