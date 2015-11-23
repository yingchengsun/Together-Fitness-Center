package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabXiaoyouDAO;
import com.xdsc.model.XsglTabXiaoyou;

public class XsglTabXiaoyouDAOImpl extends HibernateDaoSupport implements XsglTabXiaoyouDAO {
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabXiaoyouDAO#saveXStudent(com.xdsc.model.xsgl_system.XsglTabXiaoyou)
	 */
	public boolean saveXStudent(XsglTabXiaoyou xstudent){
		this.getHibernateTemplate().save(xstudent);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabXiaoyouDAO#deleteXStudent(com.xdsc.model.xsgl_system.XsglTabXiaoyou)
	 */
	public boolean deleteXStudent(XsglTabXiaoyou xstudent){
		this.getHibernateTemplate().delete(xstudent);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabXiaoyouDAO#getXStudentList()
	 */
	public List<XsglTabXiaoyou> getXStudentList(){
		String hql="from XsglTabXiaoyou";
		return this.getHibernateTemplate().find(hql);
	}

	
	public List<XsglTabXiaoyou> getXStudentByName(String name) {
		String hql="from XsglTabXiaoyou xtxy where xtxy.FXiaoYouName='"+name+"'";
		return this.getHibernateTemplate().find(hql);
	}

	
	public List<XsglTabXiaoyou> getXStudentById(String xid) {
		String hql="from XsglTabXiaoyou xtxy where xtxy.FXiaoYouId='"+xid+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabXiaoyou> getXStudentByOption(String region,String year){
		String hql="from XsglTabXiaoyou xtxy where xtxy.FRegion='"+region+"' and xtxy.FGraduateYear='"+year+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
