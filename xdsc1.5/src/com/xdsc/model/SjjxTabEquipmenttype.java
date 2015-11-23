package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SjjxTabEquipmenttype entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabEquipmenttype implements java.io.Serializable {

	// Fields

	private Integer FEquTypeId;
	private String FEquTypeName;
	private Set sjjxTabEquipments = new HashSet(0);

	// Constructors

	/** default constructor */
	public SjjxTabEquipmenttype() {
	}

	/** full constructor */
	public SjjxTabEquipmenttype(String FEquTypeName, Set sjjxTabEquipments) {
		this.FEquTypeName = FEquTypeName;
		this.sjjxTabEquipments = sjjxTabEquipments;
	}

	// Property accessors

	public Integer getFEquTypeId() {
		return this.FEquTypeId;
	}

	public void setFEquTypeId(Integer FEquTypeId) {
		this.FEquTypeId = FEquTypeId;
	}

	public String getFEquTypeName() {
		return this.FEquTypeName;
	}

	public void setFEquTypeName(String FEquTypeName) {
		this.FEquTypeName = FEquTypeName;
	}

	public Set getSjjxTabEquipments() {
		return this.sjjxTabEquipments;
	}

	public void setSjjxTabEquipments(Set sjjxTabEquipments) {
		this.sjjxTabEquipments = sjjxTabEquipments;
	}

}