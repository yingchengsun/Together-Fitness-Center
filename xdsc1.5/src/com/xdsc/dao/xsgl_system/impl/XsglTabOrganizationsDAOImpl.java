package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabOrganizationsDAO;
import com.xdsc.model.XsglTabOrganizations;

public class XsglTabOrganizationsDAOImpl extends HibernateDaoSupport implements XsglTabOrganizationsDAO{
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabOrganizationsDAO#saveOrganization(com.xdsc.model.xsgl_system.XsglTabOrganizations)
	 */
	public boolean saveOrganization(XsglTabOrganizations organization){
		this.getHibernateTemplate().save(organization);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabOrganizationsDAO#deleteOrganization(com.xdsc.model.xsgl_system.XsglTabOrganizations)
	 */
	public boolean deleteOrganization(XsglTabOrganizations organization){
		this.getHibernateTemplate().delete(organization);
		return true;
	}
	
	public boolean updateOrganization(XsglTabOrganizations organization){
		this.getHibernateTemplate().update(organization);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabOrganizationsDAO#getOrganizationList()
	 */
	public List<XsglTabOrganizations> getOrganizationList(){
		String hql = "from XsglTabOrganizations";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabOrganizationsDAO#getOrganizationByName(java.lang.String)
	 */
	public List<XsglTabOrganizations> getOrganizationByName(String Oname){
		String hql = "from XsglTabOrganizations xtos where xtos.FOname='"+Oname+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public XsglTabOrganizations getOrganizationById(int orgId){
		String hql="from XsglTabOrganizations xtos where xtos.FOid='"+orgId+"'";
		List list = this.getHibernateTemplate().find(hql);
		if(list.isEmpty()) return null;
		else return (XsglTabOrganizations)list.get(0);
	}

}
