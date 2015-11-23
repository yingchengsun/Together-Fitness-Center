package com.xdsc.model;

/**
 * Remind entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Remind implements java.io.Serializable {

	// Fields

	private Integer RId;
	private String RTime;
	private String RTask;
	private String RNotes;
	private String RUserid;

	// Constructors

	/** default constructor */
	public Remind() {
	}

	/** minimal constructor */
	public Remind(String RTime, String RTask, String RUserid) {
		this.RTime = RTime;
		this.RTask = RTask;
		this.RUserid = RUserid;
	}

	/** full constructor */
	public Remind(String RTime, String RTask, String RNotes, String RUserid) {
		this.RTime = RTime;
		this.RTask = RTask;
		this.RNotes = RNotes;
		this.RUserid = RUserid;
	}

	// Property accessors

	public Integer getRId() {
		return this.RId;
	}

	public void setRId(Integer RId) {
		this.RId = RId;
	}

	public String getRTime() {
		return this.RTime;
	}

	public void setRTime(String RTime) {
		this.RTime = RTime;
	}

	public String getRTask() {
		return this.RTask;
	}

	public void setRTask(String RTask) {
		this.RTask = RTask;
	}

	public String getRNotes() {
		return this.RNotes;
	}

	public void setRNotes(String RNotes) {
		this.RNotes = RNotes;
	}

	public String getRUserid() {
		return this.RUserid;
	}

	public void setRUserid(String RUserid) {
		this.RUserid = RUserid;
	}

}