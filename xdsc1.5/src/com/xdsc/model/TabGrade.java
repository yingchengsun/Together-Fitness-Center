package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabGrade entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabGrade implements java.io.Serializable {

	// Fields

	private Integer FGradeId;
	private String FGradeNum;
	private String FGradeName;
	private Integer FGradeMaleNum;
	private Integer FGradeFemaleNum;
	private Integer FGradeTotalNum;
	private Set tabClasseses = new HashSet(0);
	private Set tabTeacherses = new HashSet(0);
	private Set sjjxTabCourselabs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabGrade() {
	}

	/** full constructor */
	public TabGrade(String FGradeNum, String FGradeName, Integer FGradeMaleNum,
			Integer FGradeFemaleNum, Integer FGradeTotalNum, Set tabClasseses,
			Set tabTeacherses, Set sjjxTabCourselabs) {
		this.FGradeNum = FGradeNum;
		this.FGradeName = FGradeName;
		this.FGradeMaleNum = FGradeMaleNum;
		this.FGradeFemaleNum = FGradeFemaleNum;
		this.FGradeTotalNum = FGradeTotalNum;
		this.tabClasseses = tabClasseses;
		this.tabTeacherses = tabTeacherses;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	// Property accessors

	public Integer getFGradeId() {
		return this.FGradeId;
	}

	public void setFGradeId(Integer FGradeId) {
		this.FGradeId = FGradeId;
	}

	public String getFGradeNum() {
		return this.FGradeNum;
	}

	public void setFGradeNum(String FGradeNum) {
		this.FGradeNum = FGradeNum;
	}

	public String getFGradeName() {
		return this.FGradeName;
	}

	public void setFGradeName(String FGradeName) {
		this.FGradeName = FGradeName;
	}

	public Integer getFGradeMaleNum() {
		return this.FGradeMaleNum;
	}

	public void setFGradeMaleNum(Integer FGradeMaleNum) {
		this.FGradeMaleNum = FGradeMaleNum;
	}

	public Integer getFGradeFemaleNum() {
		return this.FGradeFemaleNum;
	}

	public void setFGradeFemaleNum(Integer FGradeFemaleNum) {
		this.FGradeFemaleNum = FGradeFemaleNum;
	}

	public Integer getFGradeTotalNum() {
		return this.FGradeTotalNum;
	}

	public void setFGradeTotalNum(Integer FGradeTotalNum) {
		this.FGradeTotalNum = FGradeTotalNum;
	}

	public Set getTabClasseses() {
		return this.tabClasseses;
	}

	public void setTabClasseses(Set tabClasseses) {
		this.tabClasseses = tabClasseses;
	}

	public Set getTabTeacherses() {
		return this.tabTeacherses;
	}

	public void setTabTeacherses(Set tabTeacherses) {
		this.tabTeacherses = tabTeacherses;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

}