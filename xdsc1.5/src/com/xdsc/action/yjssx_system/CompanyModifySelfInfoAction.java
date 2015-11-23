package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.service.yjssx_system.CompanyInfoService;

/**
 * 类功能：公司修改基本信息
 * @author 许鑫
 * @version 1.1
 *
 */
public class CompanyModifySelfInfoAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private CompanyInfoService companyInfoService;
	
	private TabCompany companyInfo;
	
	/**
	 * 修改公司的基本信息
	 * @return modifyInfo
	 */
	public String modifyInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabCompany company=companyInfoService.findCompanyByNum(FUserNumber);
		companyInfo.setFCompanyNumber(FUserNumber);
		company.setFCompanyName(companyInfo.getFCompanyName());
		company.setFAddress(companyInfo.getFAddress());
		company.setFEmailAddress(companyInfo.getFEmailAddress());
		company.setFTelephone(companyInfo.getFTelephone());
		company.setFInformation(companyInfo.getFInformation());
		companyInfoService.updateCompanyInfo(companyInfo);
		return "modifyInfo";
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public TabCompany getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(TabCompany companyInfo) {
		this.companyInfo = companyInfo;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

}
