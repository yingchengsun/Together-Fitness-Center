package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TabClasses entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TabClasses implements java.io.Serializable {

	// Fields

	private String FClassNumber;
	private TabGrade tabGrade;
	private String FClassName;
	private Integer FClassMaleNum;
	private Integer FClassFemaleNum;
	private Integer FClassTotalNum;
	private Integer FClassCapacity;
	private Integer FClassWorkNum;
	private Integer FClassKaoYanNum;
	private Integer FClassAbroadNum;
	private Integer FClassOtherNum;
	private String FCalssLocation;
	private Integer FClassPartyNum;
	private Set sjjxTabCourselabs = new HashSet(0);
	private Set xsglTabJiaofeigathers = new HashSet(0);
	private Set xsglTabPartygathers = new HashSet(0);
	private Set xsglTabKaoqingathers = new HashSet(0);
	private Set xsglTabJiangzhugathers = new HashSet(0);
	private Set tabStudentses = new HashSet(0);
	private Set jfptTabStudentassociates = new HashSet(0);
	private Set jfptTabTeacherassociates = new HashSet(0);

	// Constructors

	/** default constructor */
	public TabClasses() {
	}

	/** full constructor */
	public TabClasses(TabGrade tabGrade, String FClassName,
			Integer FClassMaleNum, Integer FClassFemaleNum,
			Integer FClassTotalNum, Integer FClassCapacity,
			Integer FClassWorkNum, Integer FClassKaoYanNum,
			Integer FClassAbroadNum, Integer FClassOtherNum,
			String FCalssLocation, Integer FClassPartyNum,
			Set sjjxTabCourselabs, Set xsglTabJiaofeigathers,
			Set xsglTabPartygathers, Set xsglTabKaoqingathers,
			Set xsglTabJiangzhugathers, Set tabStudentses,
			Set jfptTabStudentassociates, Set jfptTabTeacherassociates) {
		this.tabGrade = tabGrade;
		this.FClassName = FClassName;
		this.FClassMaleNum = FClassMaleNum;
		this.FClassFemaleNum = FClassFemaleNum;
		this.FClassTotalNum = FClassTotalNum;
		this.FClassCapacity = FClassCapacity;
		this.FClassWorkNum = FClassWorkNum;
		this.FClassKaoYanNum = FClassKaoYanNum;
		this.FClassAbroadNum = FClassAbroadNum;
		this.FClassOtherNum = FClassOtherNum;
		this.FCalssLocation = FCalssLocation;
		this.FClassPartyNum = FClassPartyNum;
		this.sjjxTabCourselabs = sjjxTabCourselabs;
		this.xsglTabJiaofeigathers = xsglTabJiaofeigathers;
		this.xsglTabPartygathers = xsglTabPartygathers;
		this.xsglTabKaoqingathers = xsglTabKaoqingathers;
		this.xsglTabJiangzhugathers = xsglTabJiangzhugathers;
		this.tabStudentses = tabStudentses;
		this.jfptTabStudentassociates = jfptTabStudentassociates;
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
	}

	// Property accessors

	public String getFClassNumber() {
		return this.FClassNumber;
	}

	public void setFClassNumber(String FClassNumber) {
		this.FClassNumber = FClassNumber;
	}

	public TabGrade getTabGrade() {
		return this.tabGrade;
	}

	public void setTabGrade(TabGrade tabGrade) {
		this.tabGrade = tabGrade;
	}

	public String getFClassName() {
		return this.FClassName;
	}

	public void setFClassName(String FClassName) {
		this.FClassName = FClassName;
	}

	public Integer getFClassMaleNum() {
		return this.FClassMaleNum;
	}

	public void setFClassMaleNum(Integer FClassMaleNum) {
		this.FClassMaleNum = FClassMaleNum;
	}

	public Integer getFClassFemaleNum() {
		return this.FClassFemaleNum;
	}

	public void setFClassFemaleNum(Integer FClassFemaleNum) {
		this.FClassFemaleNum = FClassFemaleNum;
	}

	public Integer getFClassTotalNum() {
		return this.FClassTotalNum;
	}

	public void setFClassTotalNum(Integer FClassTotalNum) {
		this.FClassTotalNum = FClassTotalNum;
	}

	public Integer getFClassCapacity() {
		return this.FClassCapacity;
	}

	public void setFClassCapacity(Integer FClassCapacity) {
		this.FClassCapacity = FClassCapacity;
	}

	public Integer getFClassWorkNum() {
		return this.FClassWorkNum;
	}

	public void setFClassWorkNum(Integer FClassWorkNum) {
		this.FClassWorkNum = FClassWorkNum;
	}

	public Integer getFClassKaoYanNum() {
		return this.FClassKaoYanNum;
	}

	public void setFClassKaoYanNum(Integer FClassKaoYanNum) {
		this.FClassKaoYanNum = FClassKaoYanNum;
	}

	public Integer getFClassAbroadNum() {
		return this.FClassAbroadNum;
	}

	public void setFClassAbroadNum(Integer FClassAbroadNum) {
		this.FClassAbroadNum = FClassAbroadNum;
	}

	public Integer getFClassOtherNum() {
		return this.FClassOtherNum;
	}

	public void setFClassOtherNum(Integer FClassOtherNum) {
		this.FClassOtherNum = FClassOtherNum;
	}

	public String getFCalssLocation() {
		return this.FCalssLocation;
	}

	public void setFCalssLocation(String FCalssLocation) {
		this.FCalssLocation = FCalssLocation;
	}

	public Integer getFClassPartyNum() {
		return this.FClassPartyNum;
	}

	public void setFClassPartyNum(Integer FClassPartyNum) {
		this.FClassPartyNum = FClassPartyNum;
	}

	public Set getSjjxTabCourselabs() {
		return this.sjjxTabCourselabs;
	}

	public void setSjjxTabCourselabs(Set sjjxTabCourselabs) {
		this.sjjxTabCourselabs = sjjxTabCourselabs;
	}

	public Set getXsglTabJiaofeigathers() {
		return this.xsglTabJiaofeigathers;
	}

	public void setXsglTabJiaofeigathers(Set xsglTabJiaofeigathers) {
		this.xsglTabJiaofeigathers = xsglTabJiaofeigathers;
	}

	public Set getXsglTabPartygathers() {
		return this.xsglTabPartygathers;
	}

	public void setXsglTabPartygathers(Set xsglTabPartygathers) {
		this.xsglTabPartygathers = xsglTabPartygathers;
	}

	public Set getXsglTabKaoqingathers() {
		return this.xsglTabKaoqingathers;
	}

	public void setXsglTabKaoqingathers(Set xsglTabKaoqingathers) {
		this.xsglTabKaoqingathers = xsglTabKaoqingathers;
	}

	public Set getXsglTabJiangzhugathers() {
		return this.xsglTabJiangzhugathers;
	}

	public void setXsglTabJiangzhugathers(Set xsglTabJiangzhugathers) {
		this.xsglTabJiangzhugathers = xsglTabJiangzhugathers;
	}

	public Set getTabStudentses() {
		return this.tabStudentses;
	}

	public void setTabStudentses(Set tabStudentses) {
		this.tabStudentses = tabStudentses;
	}

	public Set getJfptTabStudentassociates() {
		return this.jfptTabStudentassociates;
	}

	public void setJfptTabStudentassociates(Set jfptTabStudentassociates) {
		this.jfptTabStudentassociates = jfptTabStudentassociates;
	}

	public Set getJfptTabTeacherassociates() {
		return this.jfptTabTeacherassociates;
	}

	public void setJfptTabTeacherassociates(Set jfptTabTeacherassociates) {
		this.jfptTabTeacherassociates = jfptTabTeacherassociates;
	}

}