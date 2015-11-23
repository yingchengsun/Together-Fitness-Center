package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.service.yjssx_system.CompanyInfoService;

/**
 * 类功能:公司基本信息
 * @author 许鑫
 * @version 1.1
 */
public class CompanySelfInfoAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private CompanyInfoService companyInfoService;
	
	private TabCompany companyInfo;
	
	/**
	 * 查找到公司的信息
	 * @return 返回公司的信息
	 */
	public String findCompanyInfo(){                //显示公司信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		companyInfo=companyInfoService.findCompanyByNum(FUserNumber);
		return "findCompanyInfo";
	}
	
	/**
	 * 查找出公司信息，并转向修改信的页面
	 * @return
	 */
	public String preModifyCompanyInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		companyInfo=companyInfoService.findCompanyByNum(FUserNumber);
		return "preModifyCompanyInfo";
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
