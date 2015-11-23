package com.xdsc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SjjxTabEquipment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SjjxTabEquipment implements java.io.Serializable {

	// Fields

	private Integer FEquId;
	private SjjxTabLab sjjxTabLab;
	private SjjxTabEquipmenttype sjjxTabEquipmenttype;
	private String FEquBrand;
	private Date FEquBuyTime;
	private Integer FDepartmentId;
	private String FDepartmentName;
	private String FEquName;
	private String FEquPattern;
	private String FEquStandard;
	private Integer FEquPrice;
	private String FChuChangId;
	private String FPersonL;
	private String FPersonJ;
	private String FPersonS;
	private String FRemarks;
	private Integer FTypeId;
	private String FEquBuyCompany;
	private String FCountry;
	private Integer FCountryId;
	private String FFundsId;
	private String FFundsName;
	private Integer FUseDirectionId;
	private String FUseDirectionName;
	private String FKeYanId;
	private Integer FDanJuId;
	private Date FRuKuTime;
	private Integer FZiChanType;
	private Integer FGuoBiaoId;
	private Date FShuRuTime;
	private Integer FEquSourceId;
	private String FEquSourceName;
	private Integer FZheJiuId;
	private String FZheJiuName;
	private Date FBaoXiuDate;
	private String FCaiWuPingDan;
	private String FJiZhangRen;
	private String FShenHe;
	private Set sjjxTabEquipmentdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public SjjxTabEquipment() {
	}

	/** full constructor */
	public SjjxTabEquipment(SjjxTabLab sjjxTabLab,
			SjjxTabEquipmenttype sjjxTabEquipmenttype, String FEquBrand,
			Date FEquBuyTime, Integer FDepartmentId, String FDepartmentName,
			String FEquName, String FEquPattern, String FEquStandard,
			Integer FEquPrice, String FChuChangId, String FPersonL,
			String FPersonJ, String FPersonS, String FRemarks, Integer FTypeId,
			String FEquBuyCompany, String FCountry, Integer FCountryId,
			String FFundsId, String FFundsName, Integer FUseDirectionId,
			String FUseDirectionName, String FKeYanId, Integer FDanJuId,
			Date FRuKuTime, Integer FZiChanType, Integer FGuoBiaoId,
			Date FShuRuTime, Integer FEquSourceId, String FEquSourceName,
			Integer FZheJiuId, String FZheJiuName, Date FBaoXiuDate,
			String FCaiWuPingDan, String FJiZhangRen, String FShenHe,
			Set sjjxTabEquipmentdetails) {
		this.sjjxTabLab = sjjxTabLab;
		this.sjjxTabEquipmenttype = sjjxTabEquipmenttype;
		this.FEquBrand = FEquBrand;
		this.FEquBuyTime = FEquBuyTime;
		this.FDepartmentId = FDepartmentId;
		this.FDepartmentName = FDepartmentName;
		this.FEquName = FEquName;
		this.FEquPattern = FEquPattern;
		this.FEquStandard = FEquStandard;
		this.FEquPrice = FEquPrice;
		this.FChuChangId = FChuChangId;
		this.FPersonL = FPersonL;
		this.FPersonJ = FPersonJ;
		this.FPersonS = FPersonS;
		this.FRemarks = FRemarks;
		this.FTypeId = FTypeId;
		this.FEquBuyCompany = FEquBuyCompany;
		this.FCountry = FCountry;
		this.FCountryId = FCountryId;
		this.FFundsId = FFundsId;
		this.FFundsName = FFundsName;
		this.FUseDirectionId = FUseDirectionId;
		this.FUseDirectionName = FUseDirectionName;
		this.FKeYanId = FKeYanId;
		this.FDanJuId = FDanJuId;
		this.FRuKuTime = FRuKuTime;
		this.FZiChanType = FZiChanType;
		this.FGuoBiaoId = FGuoBiaoId;
		this.FShuRuTime = FShuRuTime;
		this.FEquSourceId = FEquSourceId;
		this.FEquSourceName = FEquSourceName;
		this.FZheJiuId = FZheJiuId;
		this.FZheJiuName = FZheJiuName;
		this.FBaoXiuDate = FBaoXiuDate;
		this.FCaiWuPingDan = FCaiWuPingDan;
		this.FJiZhangRen = FJiZhangRen;
		this.FShenHe = FShenHe;
		this.sjjxTabEquipmentdetails = sjjxTabEquipmentdetails;
	}

	// Property accessors

	public Integer getFEquId() {
		return this.FEquId;
	}

	public void setFEquId(Integer FEquId) {
		this.FEquId = FEquId;
	}

	public SjjxTabLab getSjjxTabLab() {
		return this.sjjxTabLab;
	}

	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}

	public SjjxTabEquipmenttype getSjjxTabEquipmenttype() {
		return this.sjjxTabEquipmenttype;
	}

	public void setSjjxTabEquipmenttype(
			SjjxTabEquipmenttype sjjxTabEquipmenttype) {
		this.sjjxTabEquipmenttype = sjjxTabEquipmenttype;
	}

	public String getFEquBrand() {
		return this.FEquBrand;
	}

	public void setFEquBrand(String FEquBrand) {
		this.FEquBrand = FEquBrand;
	}

	public Date getFEquBuyTime() {
		return this.FEquBuyTime;
	}

	public void setFEquBuyTime(Date FEquBuyTime) {
		this.FEquBuyTime = FEquBuyTime;
	}

	public Integer getFDepartmentId() {
		return this.FDepartmentId;
	}

	public void setFDepartmentId(Integer FDepartmentId) {
		this.FDepartmentId = FDepartmentId;
	}

	public String getFDepartmentName() {
		return this.FDepartmentName;
	}

	public void setFDepartmentName(String FDepartmentName) {
		this.FDepartmentName = FDepartmentName;
	}

	public String getFEquName() {
		return this.FEquName;
	}

	public void setFEquName(String FEquName) {
		this.FEquName = FEquName;
	}

	public String getFEquPattern() {
		return this.FEquPattern;
	}

	public void setFEquPattern(String FEquPattern) {
		this.FEquPattern = FEquPattern;
	}

	public String getFEquStandard() {
		return this.FEquStandard;
	}

	public void setFEquStandard(String FEquStandard) {
		this.FEquStandard = FEquStandard;
	}

	public Integer getFEquPrice() {
		return this.FEquPrice;
	}

	public void setFEquPrice(Integer FEquPrice) {
		this.FEquPrice = FEquPrice;
	}

	public String getFChuChangId() {
		return this.FChuChangId;
	}

	public void setFChuChangId(String FChuChangId) {
		this.FChuChangId = FChuChangId;
	}

	public String getFPersonL() {
		return this.FPersonL;
	}

	public void setFPersonL(String FPersonL) {
		this.FPersonL = FPersonL;
	}

	public String getFPersonJ() {
		return this.FPersonJ;
	}

	public void setFPersonJ(String FPersonJ) {
		this.FPersonJ = FPersonJ;
	}

	public String getFPersonS() {
		return this.FPersonS;
	}

	public void setFPersonS(String FPersonS) {
		this.FPersonS = FPersonS;
	}

	public String getFRemarks() {
		return this.FRemarks;
	}

	public void setFRemarks(String FRemarks) {
		this.FRemarks = FRemarks;
	}

	public Integer getFTypeId() {
		return this.FTypeId;
	}

	public void setFTypeId(Integer FTypeId) {
		this.FTypeId = FTypeId;
	}

	public String getFEquBuyCompany() {
		return this.FEquBuyCompany;
	}

	public void setFEquBuyCompany(String FEquBuyCompany) {
		this.FEquBuyCompany = FEquBuyCompany;
	}

	public String getFCountry() {
		return this.FCountry;
	}

	public void setFCountry(String FCountry) {
		this.FCountry = FCountry;
	}

	public Integer getFCountryId() {
		return this.FCountryId;
	}

	public void setFCountryId(Integer FCountryId) {
		this.FCountryId = FCountryId;
	}

	public String getFFundsId() {
		return this.FFundsId;
	}

	public void setFFundsId(String FFundsId) {
		this.FFundsId = FFundsId;
	}

	public String getFFundsName() {
		return this.FFundsName;
	}

	public void setFFundsName(String FFundsName) {
		this.FFundsName = FFundsName;
	}

	public Integer getFUseDirectionId() {
		return this.FUseDirectionId;
	}

	public void setFUseDirectionId(Integer FUseDirectionId) {
		this.FUseDirectionId = FUseDirectionId;
	}

	public String getFUseDirectionName() {
		return this.FUseDirectionName;
	}

	public void setFUseDirectionName(String FUseDirectionName) {
		this.FUseDirectionName = FUseDirectionName;
	}

	public String getFKeYanId() {
		return this.FKeYanId;
	}

	public void setFKeYanId(String FKeYanId) {
		this.FKeYanId = FKeYanId;
	}

	public Integer getFDanJuId() {
		return this.FDanJuId;
	}

	public void setFDanJuId(Integer FDanJuId) {
		this.FDanJuId = FDanJuId;
	}

	public Date getFRuKuTime() {
		return this.FRuKuTime;
	}

	public void setFRuKuTime(Date FRuKuTime) {
		this.FRuKuTime = FRuKuTime;
	}

	public Integer getFZiChanType() {
		return this.FZiChanType;
	}

	public void setFZiChanType(Integer FZiChanType) {
		this.FZiChanType = FZiChanType;
	}

	public Integer getFGuoBiaoId() {
		return this.FGuoBiaoId;
	}

	public void setFGuoBiaoId(Integer FGuoBiaoId) {
		this.FGuoBiaoId = FGuoBiaoId;
	}

	public Date getFShuRuTime() {
		return this.FShuRuTime;
	}

	public void setFShuRuTime(Date FShuRuTime) {
		this.FShuRuTime = FShuRuTime;
	}

	public Integer getFEquSourceId() {
		return this.FEquSourceId;
	}

	public void setFEquSourceId(Integer FEquSourceId) {
		this.FEquSourceId = FEquSourceId;
	}

	public String getFEquSourceName() {
		return this.FEquSourceName;
	}

	public void setFEquSourceName(String FEquSourceName) {
		this.FEquSourceName = FEquSourceName;
	}

	public Integer getFZheJiuId() {
		return this.FZheJiuId;
	}

	public void setFZheJiuId(Integer FZheJiuId) {
		this.FZheJiuId = FZheJiuId;
	}

	public String getFZheJiuName() {
		return this.FZheJiuName;
	}

	public void setFZheJiuName(String FZheJiuName) {
		this.FZheJiuName = FZheJiuName;
	}

	public Date getFBaoXiuDate() {
		return this.FBaoXiuDate;
	}

	public void setFBaoXiuDate(Date FBaoXiuDate) {
		this.FBaoXiuDate = FBaoXiuDate;
	}

	public String getFCaiWuPingDan() {
		return this.FCaiWuPingDan;
	}

	public void setFCaiWuPingDan(String FCaiWuPingDan) {
		this.FCaiWuPingDan = FCaiWuPingDan;
	}

	public String getFJiZhangRen() {
		return this.FJiZhangRen;
	}

	public void setFJiZhangRen(String FJiZhangRen) {
		this.FJiZhangRen = FJiZhangRen;
	}

	public String getFShenHe() {
		return this.FShenHe;
	}

	public void setFShenHe(String FShenHe) {
		this.FShenHe = FShenHe;
	}

	public Set getSjjxTabEquipmentdetails() {
		return this.sjjxTabEquipmentdetails;
	}

	public void setSjjxTabEquipmentdetails(Set sjjxTabEquipmentdetails) {
		this.sjjxTabEquipmentdetails = sjjxTabEquipmentdetails;
	}

}