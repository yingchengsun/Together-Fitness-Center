package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.CompanyInfoDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCompany;


public class CompanyInfoDAOImpl extends HibernateDaoSupport implements CompanyInfoDAO {

	public void addCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(company);

	}

	public void addCompanyInfo(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	public void delCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(company);
	}

	public List<TabCompany> findAllCompanyInfo() {
		// TODO Auto-generated method stub
		List<TabCompany> list=this.getHibernateTemplate().loadAll(TabCompany.class);
		return list;
	}

	public TabCompany findCompanyByNum(String num) {
		// TODO Auto-generated method stub
		
		return (TabCompany)this.getHibernateTemplate().get(TabCompany.class, num);
	}

	public void updateCompanyInfo(TabCompany company) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(company);
	}

	public List<TabCompany> findCompanyByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";
		String hql="from TabCompany c where c.FCompanyName like'"+LikeName+"'";
		List<TabCompany> list=this.getHibernateTemplate().find(hql);
		return list;
		
	}

	public List<TabCompany> findCompanyByFProperty(String name) {
		// TODO Auto-generated method stub
		
		String hql = "from TabCompany c where c.FProperty ='"+name+"'";
		List<TabCompany> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabCompany> findCompanyByExample(TabCompany company) {
		// TODO Auto-generated method stub
		List<TabCompany> list = this.getHibernateTemplate().findByExample(company);
		return list;
	}

	

}
