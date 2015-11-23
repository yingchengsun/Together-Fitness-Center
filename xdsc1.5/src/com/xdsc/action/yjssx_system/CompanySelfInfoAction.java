package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.service.yjssx_system.CompanyInfoService;

/**
 * �๦��:��˾������Ϣ
 * @author ����
 * @version 1.1
 */
public class CompanySelfInfoAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private CompanyInfoService companyInfoService;
	
	private TabCompany companyInfo;
	
	/**
	 * ���ҵ���˾����Ϣ
	 * @return ���ع�˾����Ϣ
	 */
	public String findCompanyInfo(){                //��ʾ��˾��Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		companyInfo=companyInfoService.findCompanyByNum(FUserNumber);
		return "findCompanyInfo";
	}
	
	/**
	 * ���ҳ���˾��Ϣ����ת���޸��ŵ�ҳ��
	 * @return
	 */
	public String preModifyCompanyInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
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
