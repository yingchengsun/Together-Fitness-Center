package com.xdsc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * GzfkTabStudyuniversity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class GzfkTabStudyuniversity implements java.io.Serializable {

	// Fields

	private Integer FId;
	private String FUniName;
	private String FUniCountry;
	private String FUniCity;
	private String FUniAddress;
	private String FUniEmail;
	private String FUniTel;
	private String FUniIntro;
	private Set gzfkTabUninumses = new HashSet(0);
	private Set gzfkTabKaoyanstudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public GzfkTabStudyuniversity() {
	}

	/** full constructor */
	public GzfkTabStudyuniversity(String FUniName, String FUniCountry,
			String FUniCity, String FUniAddress, String FUniEmail,
			String FUniTel, String FUniIntro, Set gzfkTabUninumses,
			Set gzfkTabKaoyanstudents) {
		this.FUniName = FUniName;
		this.FUniCountry = FUniCountry;
		this.FUniCity = FUniCity;
		this.FUniAddress = FUniAddress;
		this.FUniEmail = FUniEmail;
		this.FUniTel = FUniTel;
		this.FUniIntro = FUniIntro;
		this.gzfkTabUninumses = gzfkTabUninumses;
		this.gzfkTabKaoyanstudents = gzfkTabKaoyanstudents;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public String getFUniName() {
		return this.FUniName;
	}

	public void setFUniName(String FUniName) {
		this.FUniName = FUniName;
	}

	public String getFUniCountry() {
		return this.FUniCountry;
	}

	public void setFUniCountry(String FUniCountry) {
		this.FUniCountry = FUniCountry;
	}

	public String getFUniCity() {
		return this.FUniCity;
	}

	public void setFUniCity(String FUniCity) {
		this.FUniCity = FUniCity;
	}

	public String getFUniAddress() {
		return this.FUniAddress;
	}

	public void setFUniAddress(String FUniAddress) {
		this.FUniAddress = FUniAddress;
	}

	public String getFUniEmail() {
		return this.FUniEmail;
	}

	public void setFUniEmail(String FUniEmail) {
		this.FUniEmail = FUniEmail;
	}

	public String getFUniTel() {
		return this.FUniTel;
	}

	public void setFUniTel(String FUniTel) {
		this.FUniTel = FUniTel;
	}

	public String getFUniIntro() {
		return this.FUniIntro;
	}

	public void setFUniIntro(String FUniIntro) {
		this.FUniIntro = FUniIntro;
	}

	public Set getGzfkTabUninumses() {
		return this.gzfkTabUninumses;
	}

	public void setGzfkTabUninumses(Set gzfkTabUninumses) {
		this.gzfkTabUninumses = gzfkTabUninumses;
	}

	public Set getGzfkTabKaoyanstudents() {
		return this.gzfkTabKaoyanstudents;
	}

	public void setGzfkTabKaoyanstudents(Set gzfkTabKaoyanstudents) {
		this.gzfkTabKaoyanstudents = gzfkTabKaoyanstudents;
	}

}