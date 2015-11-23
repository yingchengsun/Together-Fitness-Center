package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * XsglTabOrganizations entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class XsglTabOrganizations implements java.io.Serializable {

	// Fields

	private Integer FOid;
	private String FOname;
	private Date FBuildTime;
	private String FIntroduce;
	private Integer FTotal;
	private Set xsglTabStuorgadeparts = new HashSet(0);
	private Set xsglTabDepartments = new HashSet(0);

	// Constructors

	/** default constructor */
	public XsglTabOrganizations() {
	}

	/** full constructor */
	public XsglTabOrganizations(String FOname, Date FBuildTime,
			String FIntroduce, Integer FTotal, Set xsglTabStuorgadeparts,
			Set xsglTabDepartments) {
		this.FOname = FOname;
		this.FBuildTime = FBuildTime;
		this.FIntroduce = FIntroduce;
		this.FTotal = FTotal;
		this.xsglTabStuorgadeparts = xsglTabStuorgadeparts;
		this.xsglTabDepartments = xsglTabDepartments;
	}

	// Property accessors

	public Integer getFOid() {
		return this.FOid;
	}

	public void setFOid(Integer FOid) {
		this.FOid = FOid;
	}

	public String getFOname() {
		return this.FOname;
	}

	public void setFOname(String FOname) {
		this.FOname = FOname;
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

	public Set getXsglTabDepartments() {
		return this.xsglTabDepartments;
	}

	public void setXsglTabDepartments(Set xsglTabDepartments) {
		this.xsglTabDepartments = xsglTabDepartments;
	}

}