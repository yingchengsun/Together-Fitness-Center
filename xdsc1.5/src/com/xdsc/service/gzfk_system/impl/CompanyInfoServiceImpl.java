package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.CompanyInfoDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import com.xdsc.service.gzfk_system.CompanyInfoService;

public class CompanyInfoServiceImpl implements CompanyInfoService {

	private CompanyInfoDAO companyInfoDAO;
	public CompanyInfoDAO getCompanyInfoDAO() {
		return companyInfoDAO;
	}

	public void setCompanyInfoDAO(CompanyInfoDAO companyInfoDAO) {
		this.companyInfoDAO = companyInfoDAO;
	}
	
	public void addCompanyInfo(MhqxTabUser user) {
		// TODO Auto-generated method stub
		companyInfoDAO.addCompanyInfo(user);
	}
	
	public void addCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDAO.addCompanyInfo(company);
	}

	public void delCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDAO.delCompanyInfo(company);
	}

	public List<TabCompany> findAllCompanyInfo() {
		// TODO Auto-generated method stub
		return companyInfoDAO.findAllCompanyInfo();
	}

	public TabCompany findCompanyByNum(String num) {
		// TODO Auto-generated method stub
		return companyInfoDAO.findCompanyByNum(num);
	}

	public void updateCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDAO.updateCompanyInfo(company);
	}

	
	public List<TabCompany> findCompanyByName(String name) {
		// TODO Auto-generated method stub
		return companyInfoDAO.findCompanyByName(name);
	}

	public List<TabCompany> findCompanyByFProperty(String name) {
		// TODO Auto-generated method stub
		return companyInfoDAO.findCompanyByFProperty(name);
	}

	public Boolean CompanyIsValid(TabCompany company) {
		// TODO Auto-generated method stub
		if(companyInfoDAO.findCompanyByExample(company).size()>0){
			return true;
		}
		return false;
	}

	

}
