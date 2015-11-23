package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TabInformation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabInformation implements java.io.Serializable {

	// Fields

	private Integer FInfoId;
	private MhqxTabUser mhqxTabUser;
	private String FInfoTitle;
	private String FInfoContet;
	private Date FInfoStartTime;
	private Date FInfoFinishTime;
	private String FModuleId;
	private String FInfoType;
	private String FInfoZhiDing;
	private String FInfoZuiXin;
	private String FInfoPath;
	private String FBiaoZhi;
	private Set tabInformationimages = new HashSet(0);
	private Set mhqxTabPictures = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabInformation() {
	}

	/** full constructor */
	public TabInformation(MhqxTabUser mhqxTabUser, String FInfoTitle,
			String FInfoContet, Date FInfoStartTime, Date FInfoFinishTime,
			String FModuleId, String FInfoType, String FInfoZhiDing,
			String FInfoZuiXin, String FInfoPath, String FBiaoZhi,
			Set tabInformationimages, Set mhqxTabPictures) {
		this.mhqxTabUser = mhqxTabUser;
		this.FInfoTitle = FInfoTitle;
		this.FInfoContet = FInfoContet;
		this.FInfoStartTime = FInfoStartTime;
		this.FInfoFinishTime = FInfoFinishTime;
		this.FModuleId = FModuleId;
		this.FInfoType = FInfoType;
		this.FInfoZhiDing = FInfoZhiDing;
		this.FInfoZuiXin = FInfoZuiXin;
		this.FInfoPath = FInfoPath;
		this.FBiaoZhi = FBiaoZhi;
		this.tabInformationimages = tabInformationimages;
		this.mhqxTabPictures = mhqxTabPictures;
	}

	// Property accessors

	public Integer getFInfoId() {
		return this.FInfoId;
	}

	public void setFInfoId(Integer FInfoId) {
		this.FInfoId = FInfoId;
	}

	public MhqxTabUser getMhqxTabUser() {
		return this.mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFInfoTitle() {
		return this.FInfoTitle;
	}

	public void setFInfoTitle(String FInfoTitle) {
		this.FInfoTitle = FInfoTitle;
	}

	public String getFInfoContet() {
		return this.FInfoContet;
	}

	public void setFInfoContet(String FInfoContet) {
		this.FInfoContet = FInfoContet;
	}

	public Date getFInfoStartTime() {
		return this.FInfoStartTime;
	}

	public void setFInfoStartTime(Date FInfoStartTime) {
		this.FInfoStartTime = FInfoStartTime;
	}

	public Date getFInfoFinishTime() {
		return this.FInfoFinishTime;
	}

	public void setFInfoFinishTime(Date FInfoFinishTime) {
		this.FInfoFinishTime = FInfoFinishTime;
	}

	public String getFModuleId() {
		return this.FModuleId;
	}

	public void setFModuleId(String FModuleId) {
		this.FModuleId = FModuleId;
	}

	public String getFInfoType() {
		return this.FInfoType;
	}

	public void setFInfoType(String FInfoType) {
		this.FInfoType = FInfoType;
	}

	public String getFInfoZhiDing() {
		return this.FInfoZhiDing;
	}

	public void setFInfoZhiDing(String FInfoZhiDing) {
		this.FInfoZhiDing = FInfoZhiDing;
	}

	public String getFInfoZuiXin() {
		return this.FInfoZuiXin;
	}

	public void setFInfoZuiXin(String FInfoZuiXin) {
		this.FInfoZuiXin = FInfoZuiXin;
	}

	public String getFInfoPath() {
		return this.FInfoPath;
	}

	public void setFInfoPath(String FInfoPath) {
		this.FInfoPath = FInfoPath;
	}

	public String getFBiaoZhi() {
		return this.FBiaoZhi;
	}

	public void setFBiaoZhi(String FBiaoZhi) {
		this.FBiaoZhi = FBiaoZhi;
	}

	public Set getTabInformationimages() {
		return this.tabInformationimages;
	}

	public void setTabInformationimages(Set tabInformationimages) {
		this.tabInformationimages = tabInformationimages;
	}

	public Set getMhqxTabPictures() {
		return this.mhqxTabPictures;
	}

	public void setMhqxTabPictures(Set mhqxTabPictures) {
		this.mhqxTabPictures = mhqxTabPictures;
	}

}