package com.xdsc.service.yjssx_system;

import java.util.List;

import com.xdsc.model.TabCompany;

/**
 * 接口功能：公司信息逻辑操作
 * @author 许鑫
 * @version 1.1
 */
public interface CompanyInfoService {

	/**
	 * 添加公司信息
	 * @param company
	 */
	public void addCompanyInfo(TabCompany company);
	
	/**
	 * 删除公司信息
	 * @param company
	 */
	public void delCompanyInfo(TabCompany company);
	
	/**
	 * 修改公司信息
	 * @param company
	 */
	public void updateCompanyInfo(TabCompany company);
	
	/**
	 * 根据公司的Id查找公司信息
	 * @param num 公司ID
	 * @return 返回公司信息
	 */
	public TabCompany findCompanyByNum(String num);
	
	/**
	 * 根据公司名字查找公司信息
	 * @param name 公司名称
	 * @return 返回公司信息
	 */
	public List<TabCompany> findCompanyByName(String name);
	
	/**
	 * 查找所有公司的信息
	 * @return 返回所有公司的信息
	 */
	public List<TabCompany> findAllCompanyInfo();
	
	/**
	 * 根据用户条件查询公司名单
	 * @param companyName
	 * @param companyAddress
	 * @param companyEmail
	 * @param ConnectPerson
	 * @return
	 */
	public List<TabCompany> findCompanyByCondition(String companyName,String companyAddress,String companyEmail,String ConnectPerson);
}
