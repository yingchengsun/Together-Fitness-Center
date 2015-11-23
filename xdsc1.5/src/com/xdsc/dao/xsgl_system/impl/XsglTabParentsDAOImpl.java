package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabParentsDAO;
import com.xdsc.model.XsglTabParents;

public class XsglTabParentsDAOImpl extends HibernateDaoSupport implements XsglTabParentsDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabParentsDAOI#getParentById(java.lang.String)
	 */
	
	public boolean saveParent(XsglTabParents parent){
		this.getHibernateTemplate().save(parent);
		return true;
	}
	
	public boolean deleteParent(XsglTabParents parent){
		this.getHibernateTemplate().delete(parent);
		return true;
	}
	
	public boolean updateParent(XsglTabParents parent){
		this.getHibernateTemplate().update(parent);
		return true;
	}
	
	public List<XsglTabParents> getParentList(){
		String hql="from XsglTabParents";
		return this.getHibernateTemplate().find(hql);
	}
	
	public XsglTabParents getParentById(String pid){
		String hql="from XsglTabParents xtp where xtp.FParentId='"+pid+"'";
		return (XsglTabParents)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabParents> getParentByPNum(String parentNum){
		String hql="from XsglTabParents xtp where xtp.FParentId='"+parentNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParents> getParentByStuNum(String stuNum){
		String hql="from XsglTabParents xtp where xtp.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParents> getParentByStuName(String stuName){
		String hql="from XsglTabParents xtp where xtp.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabParents> getParentByPName(String parentName){
		String hql="from XsglTabParents xtp where xtp.FParentName='"+parentName+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
