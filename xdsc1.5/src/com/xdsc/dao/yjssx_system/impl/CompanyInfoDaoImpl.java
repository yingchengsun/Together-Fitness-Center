package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.CompanyInfoDao;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabTeachers;

/**
 * 类功能：对企业信息的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanyInfoDaoImpl extends HibernateDaoSupport implements CompanyInfoDao {

	/**
	 * 添加公司信息
	 * @param company
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#addCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void addCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(company);

	}

	/**
	 * 删除公司信息
	 * @param company
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#delCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void delCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(company);
	}

	/**
	 * 查找所有公司的信息
	 * @return 返回所有公司的信息
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#findAllCompanyInfo()
	 */
	public List<TabCompany> findAllCompanyInfo() {
		// TODO Auto-generated method stub
		List<TabCompany> list=this.getHibernateTemplate().loadAll(TabCompany.class);
		return list;
	}

	/**
	 * 根据公司的Id查找公司信息
	 * @param num 公司ID
	 * @return 返回公司信息
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#findCompanyByNum(java.lang.String)
	 */
	public TabCompany findCompanyByNum(String num) {
		// TODO Auto-generated method stub
		TabCompany info=(TabCompany)this.getHibernateTemplate().get(TabCompany.class, num);
		return info;
	}

	/**
	 * 修改公司信息
	 * @param company
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#updateCompanyInfo(com.xdsc.model.TabCompany)
	 */
	public void updateCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(company);
	}

	/**
	 * 根据公司名字查找公司信息
	 * @param name 公司名称
	 * @return 返回公司信息
	 * @see com.xdsc.dao.yjssx_system.CompanyInfoDao#findCompanyByName(java.lang.String)
	 */
	public List<TabCompany> findCompanyByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";;           //模糊查询
		String hql="from TabCompany c where c.FCompanyName like'"+LikeName+"'";
		List<TabCompany> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabCompany> findCompanyByCondition(String companyName,
			String companyAddress, String companyEmail, String ConnectPerson) {
		// TODO Auto-generated method stub
		String CompanyName="%"+companyName+"%";
		String CompanyAddress="%"+companyAddress+"%";
		String CompanyEmail="%"+companyEmail+"%";
		String connectPerson="%"+ConnectPerson+"%";
		String hql="from TabCompany c where c.FCompanyName like '"+CompanyName+"'"+
		"and c.FAddress like '"+CompanyAddress+"'"+
		"and c.FEmailAddress like '"+CompanyEmail+"'"+
		"and c.FConnectPerson like '"+connectPerson+"'";
		System.out.println(hql);
		List<TabCompany> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
