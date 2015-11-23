package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabClassesDAO;
import com.xdsc.model.TabClasses;


public class XsglTabClassesDAOImpl extends HibernateDaoSupport implements XsglTabClassesDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabClassesDAO#saveClass(com.xdsc.model.xsgl_system.TabClasses)
	 */
	public boolean saveClass(TabClasses tabClass){
		this.getHibernateTemplate().save(tabClass);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabClassesDAO#deleteClass(com.xdsc.model.xsgl_system.TabClasses)
	 */
	public boolean deleteClass(TabClasses tabClass){
		this.getHibernateTemplate().delete(tabClass);
		return true;
	}
	
	public boolean updateClass(TabClasses tabClass){
		this.getHibernateTemplate().update(tabClass);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabClassesDAO#getClassList()
	 */
	public List<TabClasses> getClassList(){
		String hql="from TabClasses";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabClassesDAO#getClassByClassNum(java.lang.String)
	 */
	public TabClasses getClassByClassNum(String classNum) {
		String hql = "from TabClasses tc where tc.FClassNumber='" + classNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabClasses) this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<TabClasses> getClassByGradeId(int gradeId){
		String hql="from TabClasses tc where tc.tabGrade.FGradeId='"+gradeId+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabClasses> getPostgraClassList(){
		String hql = "from TabClasses tc where tc.tabGrade.FGradeName like '%研究生%'";
		return this.getHibernateTemplate().find(hql);
	}
	 
	public List<TabClasses> getUndergraClassList(){
		String hql = "from TabClasses tc where tc.tabGrade.FGradeName like '%本科生%'";
		return this.getHibernateTemplate().find(hql);
	}
	
}
