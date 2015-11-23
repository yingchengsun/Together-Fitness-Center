package com.xdsc.model;

import java.util.Date;

/**
 * SjjxTabEquipmentdetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabEquipmentdetail implements java.io.Serializable {

	// Fields

	private Integer FNumber;
	private SjjxTabEquipment sjjxTabEquipment;
	private TabAdministrator tabAdministrator;
	private String FExLabId;
	private String FEquBreakReason;
	private Date FEquBreakTime;
	private Date FEquMoveTime;
	private String FBaoFei;

	// Constructors

	/** default constructor */
	public SjjxTabEquipmentdetail() {
	}

	/** full constructor */
	public SjjxTabEquipmentdetail(SjjxTabEquipment sjjxTabEquipment,
			TabAdministrator tabAdministrator, String FExLabId,
			String FEquBreakReason, Date FEquBreakTime, Date FEquMoveTime,
			String FBaoFei) {
		this.sjjxTabEquipment = sjjxTabEquipment;
		this.tabAdministrator = tabAdministrator;
		this.FExLabId = FExLabId;
		this.FEquBreakReason = FEquBreakReason;
		this.FEquBreakTime = FEquBreakTime;
		this.FEquMoveTime = FEquMoveTime;
		this.FBaoFei = FBaoFei;
	}

	// Property accessors

	public Integer getFNumber() {
		return this.FNumber;
	}

	public void setFNumber(Integer FNumber) {
		this.FNumber = FNumber;
	}

	public SjjxTabEquipment getSjjxTabEquipment() {
		return this.sjjxTabEquipment;
	}

	public void setSjjxTabEquipment(SjjxTabEquipment sjjxTabEquipment) {
		this.sjjxTabEquipment = sjjxTabEquipment;
	}

	public TabAdministrator getTabAdministrator() {
		return this.tabAdministrator;
	}

	public void setTabAdministrator(TabAdministrator tabAdministrator) {
		this.tabAdministrator = tabAdministrator;
	}

	public String getFExLabId() {
		return this.FExLabId;
	}

	public void setFExLabId(String FExLabId) {
		this.FExLabId = FExLabId;
	}

	public String getFEquBreakReason() {
		return this.FEquBreakReason;
	}

	public void setFEquBreakReason(String FEquBreakReason) {
		this.FEquBreakReason = FEquBreakReason;
	}

	public Date getFEquBreakTime() {
		return this.FEquBreakTime;
	}

	public void setFEquBreakTime(Date FEquBreakTime) {
		this.FEquBreakTime = FEquBreakTime;
	}

	public Date getFEquMoveTime() {
		return this.FEquMoveTime;
	}

	public void setFEquMoveTime(Date FEquMoveTime) {
		this.FEquMoveTime = FEquMoveTime;
	}

	public String getFBaoFei() {
		return this.FBaoFei;
	}

	public void setFBaoFei(String FBaoFei) {
		this.FBaoFei = FBaoFei;
	}

}