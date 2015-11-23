package com.xdsc.model;

import java.util.Date;

/**
 * BksxTabSearchplan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BksxTabSearchplan implements java.io.Serializable {

	// Fields

	private Integer id;
	private BksxTabSubstugui bksxTabSubstugui;
	private Date FFstartDate;
	private Date FFfinishDate;
	private String FFcontent;
	private Date FMstartDate;
	private Date FMfinishDate;
	private String FMcontent;
	private Date FEstartDate;
	private Date FEfinishDate;
	private String FEcontent;

	// Constructors

	/** default constructor */
	public BksxTabSearchplan() {
	}

	/** full constructor */
	public BksxTabSearchplan(BksxTabSubstugui bksxTabSubstugui,
			Date FFstartDate, Date FFfinishDate, String FFcontent,
			Date FMstartDate, Date FMfinishDate, String FMcontent,
			Date FEstartDate, Date FEfinishDate, String FEcontent) {
		this.bksxTabSubstugui = bksxTabSubstugui;
		this.FFstartDate = FFstartDate;
		this.FFfinishDate = FFfinishDate;
		this.FFcontent = FFcontent;
		this.FMstartDate = FMstartDate;
		this.FMfinishDate = FMfinishDate;
		this.FMcontent = FMcontent;
		this.FEstartDate = FEstartDate;
		this.FEfinishDate = FEfinishDate;
		this.FEcontent = FEcontent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return this.bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public Date getFFstartDate() {
		return this.FFstartDate;
	}

	public void setFFstartDate(Date FFstartDate) {
		this.FFstartDate = FFstartDate;
	}

	public Date getFFfinishDate() {
		return this.FFfinishDate;
	}

	public void setFFfinishDate(Date FFfinishDate) {
		this.FFfinishDate = FFfinishDate;
	}

	public String getFFcontent() {
		return this.FFcontent;
	}

	public void setFFcontent(String FFcontent) {
		this.FFcontent = FFcontent;
	}

	public Date getFMstartDate() {
		return this.FMstartDate;
	}

	public void setFMstartDate(Date FMstartDate) {
		this.FMstartDate = FMstartDate;
	}

	public Date getFMfinishDate() {
		return this.FMfinishDate;
	}

	public void setFMfinishDate(Date FMfinishDate) {
		this.FMfinishDate = FMfinishDate;
	}

	public String getFMcontent() {
		return this.FMcontent;
	}

	public void setFMcontent(String FMcontent) {
		this.FMcontent = FMcontent;
	}

	public Date getFEstartDate() {
		return this.FEstartDate;
	}

	public void setFEstartDate(Date FEstartDate) {
		this.FEstartDate = FEstartDate;
	}

	public Date getFEfinishDate() {
		return this.FEfinishDate;
	}

	public void setFEfinishDate(Date FEfinishDate) {
		this.FEfinishDate = FEfinishDate;
	}

	public String getFEcontent() {
		return this.FEcontent;
	}

	public void setFEcontent(String FEcontent) {
		this.FEcontent = FEcontent;
	}

}