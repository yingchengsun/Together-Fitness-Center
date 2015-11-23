package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabUndergraduateDAO;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabUndergraduate;

public class XsglTabUndergraduateDAOImpl extends HibernateDaoSupport implements XsglTabUndergraduateDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabUndergraduateDAO#saveUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public boolean saveUndergraduate(TabUndergraduate undergraduate){
		this.getHibernateTemplate().save(undergraduate);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabUndergraduateDAO#deleteUndergraduate(com.xdsc.model.xsgl_system.TabUndergraduate)
	 */
	public boolean deleteUndergraduate(TabUndergraduate undergraduate){
		this.getHibernateTemplate().delete(undergraduate);
		return true;
	}
	
	public boolean updateUndergraduate(TabUndergraduate undergraduate){
		this.getHibernateTemplate().update(undergraduate);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabUndergraduateDAO#getUndergraduateList()
	 */
	public List<TabUndergraduate> getUndergraduateList(){
		String hql="from TabUndergraduate";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabUndergraduate> getUndergraduateListByYear(Date startDate, Date endDate){
		String hql="from TabUndergraduate tu where tu.tabStudents.FStudentRegData >= :startDate and tu.tabStudents.FStudentRegData <= :endDate";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	
	public List<TabUndergraduate> getUndergraduateByStuNum(String stuNum){
		String hql="from TabUndergraduate tu where tu.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabUndergraduate> getUndergraduateByStuName(String stuName){
		String hql = "from TabUndergraduate tu where tu.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabUndergraduate> getUndergraduateByGrade(int gid){
		String  hql = "from TabUndergraduate tu where tu.tabStudents.tabClasses.tabGrade.FGradeId='"+gid+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
