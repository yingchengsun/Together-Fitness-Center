package com.xdsc.service.gzfk_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;

public interface CompanyInfoService {	
	public Boolean CompanyIsValid(TabCompany company);
	
	public void addCompanyInfo(MhqxTabUser user);
	
	public void addCompanyInfo(TabCompany company);
	
	public void delCompanyInfo(TabCompany company);
	
	public void updateCompanyInfo(TabCompany company);
	
	public TabCompany findCompanyByNum(String num);
	
	public List<TabCompany> findCompanyByName(String name);
	
	public List<TabCompany> findCompanyByFProperty(String name);
	
	public List<TabCompany> findAllCompanyInfo();
}
