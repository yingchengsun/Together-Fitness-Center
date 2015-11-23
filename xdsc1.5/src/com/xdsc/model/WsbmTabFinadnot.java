package com.xdsc.model;

/**
 * WsbmTabFinadnot entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabFinadnot implements java.io.Serializable {

	// Fields

	private String FFinadNotNum;
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	private String FFilePath;

	// Constructors

	/** default constructor */
	public WsbmTabFinadnot() {
	}

	/** full constructor */
	public WsbmTabFinadnot(WsbmTabRegapplicant wsbmTabRegapplicant,
			String FFilePath) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
		this.FFilePath = FFilePath;
	}

	// Property accessors

	public String getFFinadNotNum() {
		return this.FFinadNotNum;
	}

	public void setFFinadNotNum(String FFinadNotNum) {
		this.FFinadNotNum = FFinadNotNum;
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