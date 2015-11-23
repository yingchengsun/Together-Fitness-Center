package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.CompanyInfoDao;
import com.xdsc.model.TabCompany;
import com.xdsc.service.yjssx_system.CompanyInfoService;

/**
 * 类功能：公司信息逻辑操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanyInfoServiceImpl implements CompanyInfoService {

	private CompanyInfoDao companyInfoDao;
	
	/**
	 * 添加公司信息
	 * @param company
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#addCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void addCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDao.addCompanyInfo(company);
	}

	/**
	 * 删除公司信息
	 * @param company
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#delCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void delCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDao.delCompanyInfo(company);
	}

	/**
	 * 查找所有公司的信息
	 * @return 返回所有公司的信息s
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#findAllCompanyInfo()
	 */
	public List<TabCompany> findAllCompanyInfo() {
		// TODO Auto-generated method stub
		return companyInfoDao.findAllCompanyInfo();
	}

	/**
	 * 根据公司的Id查找公司信息
	 * @param num 公司ID
	 * @return 返回公司信息
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#findCompanyByNum(java.lang.String)
	 */
	public TabCompany findCompanyByNum(String num) {
		// TODO Auto-generated method stub
		return companyInfoDao.findCompanyByNum(num);
	}

	/**
	 * 修改公司信息
	 * @param company
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#updateCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void updateCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		companyInfoDao.updateCompanyInfo(company);
	}

	public CompanyInfoDao getCompanyInfoDao() {
		return companyInfoDao;
	}

	public void setCompanyInfoDao(CompanyInfoDao companyInfoDao) {
		this.companyInfoDao = companyInfoDao;
	}

	/**
	 * 根据公司名字查找公司信息
	 * @param name 公司名称
	 * @return 返回公司信息
	 * @see com.xdsc.service.yjssx_system.CompanyInfoService#findCompanyByName(java.lang.String)
	 */
	public List<TabCompany> findCompanyByName(String name) {
		// TODO Auto-generated method stub
		return companyInfoDao.findCompanyByName(name);
	}

	public List<TabCompany> findCompanyByCondition(String companyName,
			String companyAddress, String companyEmail, String ConnectPerson) {
		// TODO Auto-generated method stub
		return companyInfoDao.findCompanyByCondition(companyName, companyAddress, companyEmail, ConnectPerson);
	}

}
