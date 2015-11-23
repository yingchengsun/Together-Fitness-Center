package com.xdsc.model;

/**
 * WsbmTabPreadnot entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabPreadnot implements java.io.Serializable {

	// Fields

	private String FPreAdNotNum;
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	private String FFilePath;

	// Constructors

	/** default constructor */
	public WsbmTabPreadnot() {
	}

	/** full constructor */
	public WsbmTabPreadnot(WsbmTabRegapplicant wsbmTabRegapplicant,
			String FFilePath) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
		this.FFilePath = FFilePath;
	}

	// Property accessors

	public String getFPreAdNotNum() {
		return this.FPreAdNotNum;
	}

	public void setFPreAdNotNum(String FPreAdNotNum) {
		this.FPreAdNotNum = FPreAdNotNum;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return this.wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public String getFFilePath() {
		return this.FFilePath;
	}

	public void setFFilePath(String FFilePath) {
		this.FFilePath = FFilePath;
	}

}