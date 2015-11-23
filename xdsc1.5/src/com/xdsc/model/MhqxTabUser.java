package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MhqxTabUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MhqxTabUser implements java.io.Serializable {

	// Fields

	private String FUserNumber;
	private String FUserPassword;
	private Set jfptTabUploadfiles = new HashSet(0);
	private Set wsbmTabRegapplicants = new HashSet(0);
	private Set jfptTabHomenotices = new HashSet(0);
	private Set xsglTabParentses = new HashSet(0);
	private Set jfptTabOtherassists = new HashSet(0);
	private Set mhqxTabUserfunctions = new HashSet(0);
	private Set tabStudentses = new HashSet(0);
	private Set tabCompanies = new HashSet(0);
	private Set jfptTabNoticetoreceives = new HashSet(0);
	private Set xsglTabXiaoyous = new HashSet(0);
	private Set mhqxTabModuleusers = new HashSet(0);
	private Set tabTeacherses = new HashSet(0);
	private Set jfptTabCoursenotices = new HashSet(0);
	private Set mhqxTabRoleusers = new HashSet(0);
	private Set tabAdministrators = new HashSet(0);
	private Set jfptTabZiwoanpais = new HashSet(0);
	private Set tabInformations = new HashSet(0);
	private Set tabNoticetosbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public MhqxTabUser() {
	}

	/** full constructor */
	public MhqxTabUser(String FUserPassword, Set jfptTabUploadfiles,
			Set wsbmTabRegapplicants, Set jfptTabHomenotices,
			Set xsglTabParentses, Set jfptTabOtherassists,
			Set mhqxTabUserfunctions, Set tabStudentses, Set tabCompanies,
			Set jfptTabNoticetoreceives, Set xsglTabXiaoyous,
			Set mhqxTabModuleusers, Set tabTeacherses,
			Set jfptTabCoursenotices, Set mhqxTabRoleusers,
			Set tabAdministrators, Set jfptTabZiwoanpais, Set tabInformations,
			Set tabNoticetosbs) {
		this.FUserPassword = FUserPassword;
		this.jfptTabUploadfiles = jfptTabUploadfiles;
		this.wsbmTabRegapplicants = wsbmTabRegapplicants;
		this.jfptTabHomenotices = jfptTabHomenotices;
		this.xsglTabParentses = xsglTabParentses;
		this.jfptTabOtherassists = jfptTabOtherassists;
		this.mhqxTabUserfunctions = mhqxTabUserfunctions;
		this.tabStudentses = tabStudentses;
		this.tabCompanies = tabCompanies;
		this.jfptTabNoticetoreceives = jfptTabNoticetoreceives;
		this.xsglTabXiaoyous = xsglTabXiaoyous;
		this.mhqxTabModuleusers = mhqxTabModuleusers;
		this.tabTeacherses = tabTeacherses;
		this.jfptTabCoursenotices = jfptTabCoursenotices;
		this.mhqxTabRoleusers = mhqxTabRoleusers;
		this.tabAdministrators = tabAdministrators;
		this.jfptTabZiwoanpais = jfptTabZiwoanpais;
		this.tabInformations = tabInformations;
		this.tabNoticetosbs = tabNoticetosbs;
	}

	// Property accessors

	public String getFUserNumber() {
		return this.FUserNumber;
	}

	public void setFUserNumber(String FUserNumber) {
		this.FUserNumber = FUserNumber;
	}

	public String getFUserPassword() {
		return this.FUserPassword;
	}

	public void setFUserPassword(String FUserPassword) {
		this.FUserPassword = FUserPassword;
	}

	public Set getJfptTabUploadfiles() {
		return this.jfptTabUploadfiles;
	}

	public void setJfptTabUploadfiles(Set jfptTabUploadfiles) {
		this.jfptTabUploadfiles = jfptTabUploadfiles;
	}

	public Set getWsbmTabRegapplicants() {
		return this.wsbmTabRegapplicants;
	}

	public void setWsbmTabRegapplicants(Set wsbmTabRegapplicants) {
		this.wsbmTabRegapplicants = wsbmTabRegapplicants;
	}

	public Set getJfptTabHomenotices() {
		return this.jfptTabHomenotices;
	}

	public void setJfptTabHomenotices(Set jfptTabHomenotices) {
		this.jfptTabHomenotices = jfptTabHomenotices;
	}

	public Set getXsglTabParentses() {
		return this.xsglTabParentses;
	}

	public void setXsglTabParentses(Set xsglTabParentses) {
		this.xsglTabParentses = xsglTabParentses;
	}

	public Set getJfptTabOtherassists() {
		return this.jfptTabOtherassists;
	}

	public void setJfptTabOtherassists(Set jfptTabOtherassists) {
		this.jfptTabOtherassists = jfptTabOtherassists;
	}

	public Set getMhqxTabUserfunctions() {
		return this.mhqxTabUserfunctions;
	}

	public void setMhqxTabUserfunctions(Set mhqxTabUserfunctions) {
		this.mhqxTabUserfunctions = mhqxTabUserfunctions;
	}

	public Set getTabStudentses() {
		return this.tabStudentses;
	}

	public void setTabStudentses(Set tabStudentses) {
		this.tabStudentses = tabStudentses;
	}

	public Set getTabCompanies() {
		return this.tabCompanies;
	}

	public void setTabCompanies(Set tabCompanies) {
		this.tabCompanies = tabCompanies;
	}

	public Set getJfptTabNoticetoreceives() {
		return this.jfptTabNoticetoreceives;
	}

	public void setJfptTabNoticetoreceives(Set jfptTabNoticetoreceives) {
		this.jfptTabNoticetoreceives = jfptTabNoticetoreceives;
	}

	public Set getXsglTabXiaoyous() {
		return this.xsglTabXiaoyous;
	}

	public void setXsglTabXiaoyous(Set xsglTabXiaoyous) {
		this.xsglTabXiaoyous = xsglTabXiaoyous;
	}

	public Set getMhqxTabModuleusers() {
		return this.mhqxTabModuleusers;
	}

	public void setMhqxTabModuleusers(Set mhqxTabModuleusers) {
		this.mhqxTabModuleusers = mhqxTabModuleusers;
	}

	public Set getTabTeacherses() {
		return this.tabTeacherses;
	}

	public void setTabTeacherses(Set tabTeacherses) {
		this.tabTeacherses = tabTeacherses;
	}

	public Set getJfptTabCoursenotices() {
		return this.jfptTabCoursenotices;
	}

	public void setJfptTabCoursenotices(Set jfptTabCoursenotices) {
		this.jfptTabCoursenotices = jfptTabCoursenotices;
	}

	public Set getMhqxTabRoleusers() {
		return this.mhqxTabRoleusers;
	}

	public void setMhqxTabRoleusers(Set mhqxTabRoleusers) {
		this.mhqxTabRoleusers = mhqxTabRoleusers;
	}

	public Set getTabAdministrators() {
		return this.tabAdministrators;
	}

	public void setTabAdministrators(Set tabAdministrators) {
		this.tabAdministrators = tabAdministrators;
	}

	public Set getJfptTabZiwoanpais() {
		return this.jfptTabZiwoanpais;
	}

	public void setJfptTabZiwoanpais(Set jfptTabZiwoanpais) {
		this.jfptTabZiwoanpais = jfptTabZiwoanpais;
	}

	public Set getTabInformations() {
		return this.tabInformations;
	}

	public void setTabInformations(Set tabInformations) {
		this.tabInformations = tabInformations;
	}

	public Set getTabNoticetosbs() {
		return this.tabNoticetosbs;
	}

	public void setTabNoticetosbs(Set tabNoticetosbs) {
		this.tabNoticetosbs = tabNoticetosbs;
	}

}