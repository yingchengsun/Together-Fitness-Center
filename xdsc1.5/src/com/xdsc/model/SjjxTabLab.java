package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SjjxTabLab entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabLab implements java.io.Serializable {

	// Fields

	private Integer FLabId;
	private String FRoomNumber;
	private String FLabName;
	private String FLabLocation;
	private Integer FSeatNumber;
	private Set sjjxTabCourselabs = new HashSet(0);
	private Set sjjxTabEquipments = new HashSet(0);
	private Set sjjxTabUsualexperiments = new HashSet(0);

	// Constructors

	/** default constructor */
	public SjjxTabLab() {
	}

	/** full constructor */
	public SjjxTabLab(String FRoomNumber, String FLabName, String FLabLocation,
			Integer FSeatNumber, Set sjjxTabCourselabs, Set sjjxTabEquipments,
			Set sjjxTabUsualexperiments) {
		this.FRoomNumber = FRoomNumber;
		this.FLabName = FLabName;
		this.FLabLocation = FLabLocation;
		this.FSeatNumber = FSeatNumber;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
		this.sjjxTabEquipments = sjjxTabEquipments;
		this.sjjxTabUsualexperiments = sjjxTabUsualexperiments;
	}

	// Property accessors

	public Integer getFLabId() {
		return this.FLabId;
	}

	public void setFLabId(Integer FLabId) {
		this.FLabId = FLabId;
	}

	public String getFRoomNumber() {
		return this.FRoomNumber;
	}

	public void setFRoomNumber(String FRoomNumber) {
		this.FRoomNumber = FRoomNumber;
	}

	public String getFLabName() {
		return this.FLabName;
	}

	public void setFLabName(String FLabName) {
		this.FLabName = FLabName;
	}

	public String getFLabLocation() {
		return this.FLabLocation;
	}

	public void setFLabLocation(String FLabLocation) {
		this.FLabLocation = FLabLocation;
	}

	public Integer getFSeatNumber() {
		return this.FSeatNumber;
	}

	public void setFSeatNumber(Integer FSeatNumber) {
		this.FSeatNumber = FSeatNumber;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	public Set getSjjxTabEquipments() {
		return this.sjjxTabEquipments;
	}

	public void setSjjxTabEquipments(Set sjjxTabEquipments) {
		this.sjjxTabEquipments = sjjxTabEquipments;
	}

	public Set getSjjxTabUsualexperiments() {
		return this.sjjxTabUsualexperiments;
	}

	public void setSjjxTabUsualexperiments(Set sjjxTabUsualexperiments) {
		this.sjjxTabUsualexperiments = sjjxTabUsualexperiments;
	}

}