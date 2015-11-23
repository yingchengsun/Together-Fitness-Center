package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabDepartmentDAO;
import com.xdsc.model.XsglTabDepartment;

public class XsglTabDepartmentDAOImpl extends HibernateDaoSupport implements XsglTabDepartmentDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabDepartmentDAO#saveDepartment(com.xdsc.model.xsgl_system.XsglTabDepartment)
	 */
	public boolean saveDepartment(XsglTabDepartment department){
		this.getHibernateTemplate().save(department);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabDepartmentDAO#deleteDepartment(com.xdsc.model.xsgl_system.XsglTabDepartment)
	 */
	public boolean deleteDepartment(XsglTabDepartment department){
		this.getHibernateTemplate().delete(department);
		return true;
	}
	
	public boolean updateDepartment(XsglTabDepartment department){
		this.getHibernateTemplate().update(department);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabDepartmentDAO#getDepartmentList()
	 */
	public List<XsglTabDepartment> getDepartmentList(){
		String hql = "from XsglTabDepartment";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabDepartmentDAO#getDepartmentByName(java.lang.String)
	 */
	public List<XsglTabDepartment> getDepartmentByName(String name){
		String hql = "from XsglTabDepartment xtdt where xtdt.FDname='"+name+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabDepartment> getDepartmentByOName(String oname){
		String hql="from XsglTabDepartment xtdt where xtdt.xsglTabOrganizations.FOname='"+oname+"'";
		return this.getHibernateTemplate().find(hql);
	}

	public XsglTabDepartment getDepartmentById(int departId){
		String hql="from XsglTabDepartment xtdt where xtdt.FDid='"+departId+"'";
		List list = this.getHibernateTemplate().find(hql);
		if(list.isEmpty()) return null;
		else return (XsglTabDepartment)list.get(0);
	}
}
