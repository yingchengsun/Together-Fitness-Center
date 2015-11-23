package com.xdsc.model;

/**
 * Mailmanager entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Mailmanager implements java.io.Serializable {

	// Fields

	private Integer mmId;
	private Integer mmMsgnum;
	private Integer mmSeen;
	private Integer mmDeleted;
	private Integer mmDraft;
	private Integer mmRubbish;
	private String mmUsername;

	// Constructors

	/** default constructor */
	public Mailmanager() {
	}

	/** full constructor */
	public Mailmanager(Integer mmMsgnum, Integer mmSeen, Integer mmDeleted,
			Integer mmDraft, Integer mmRubbish, String mmUsername) {
		this.mmMsgnum = mmMsgnum;
		this.mmSeen = mmSeen;
		this.mmDeleted = mmDeleted;
		this.mmDraft = mmDraft;
		this.mmRubbish = mmRubbish;
		this.mmUsername = mmUsername;
	}

	// Property accessors

	public Integer getMmId() {
		return this.mmId;
	}

	public void setMmId(Integer mmId) {
		this.mmId = mmId;
	}

	public Integer getMmMsgnum() {
		return this.mmMsgnum;
	}

	public void setMmMsgnum(Integer mmMsgnum) {
		this.mmMsgnum = mmMsgnum;
	}

	public Integer getMmSeen() {
		return this.mmSeen;
	}

	public void setMmSeen(Integer mmSeen) {
		this.mmSeen = mmSeen;
	}

	public Integer getMmDeleted() {
		return this.mmDeleted;
	}

	public void setMmDeleted(Integer mmDeleted) {
		this.mmDeleted = mmDeleted;
	}

	public Integer getMmDraft() {
		return this.mmDraft;
	}

	public void setMmDraft(Integer mmDraft) {
		this.mmDraft = mmDraft;
	}

	public Integer getMmRubbish() {
		return this.mmRubbish;
	}

	public void setMmRubbish(Integer mmRubbish) {
		this.mmRubbish = mmRubbish;
	}

	public String getMmUsername() {
		return this.mmUsername;
	}

	public void setMmUsername(String mmUsername) {
		this.mmUsername = mmUsername;
	}

}