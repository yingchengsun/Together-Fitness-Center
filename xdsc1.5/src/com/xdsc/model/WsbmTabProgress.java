package com.xdsc.model;

/**
 * WsbmTabProgress entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class WsbmTabProgress implements java.io.Serializable {

	// Fields

	private Integer FId;
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	private WsbmTabInstruction wsbmTabInstruction;

	// Constructors

	/** default constructor */
	public WsbmTabProgress() {
	}

	/** full constructor */
	public WsbmTabProgress(WsbmTabRegapplicant wsbmTabRegapplicant,
			WsbmTabInstruction wsbmTabInstruction) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
		this.wsbmTabInstruction = wsbmTabInstruction;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return this.wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public WsbmTabInstruction getWsbmTabInstruction() {
		return this.wsbmTabInstruction;
	}

	public void setWsbmTabInstruction(WsbmTabInstruction wsbmTabInstruction) {
		this.wsbmTabInstruction = wsbmTabInstruction;
	}

}