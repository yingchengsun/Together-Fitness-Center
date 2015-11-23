package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabPostgraduateDAO;
import com.xdsc.model.TabPostgraduate;

public class XsglTabPostgraduateDAOImpl extends HibernateDaoSupport implements XsglTabPostgraduateDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabPostgraduateDAO#savePostgraduate(com.xdsc.model.xsgl_system.TabPostgraduate)
	 */
	public boolean savePostgraduate(TabPostgraduate postgraduate){
		this.getHibernateTemplate().save(postgraduate);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabPostgraduateDAO#deletePostgraduate(com.xdsc.model.xsgl_system.TabPostgraduate)
	 */
	public boolean deletePostgraduate(TabPostgraduate postgraduate){
		this.getHibernateTemplate().delete(postgraduate);
		return true;
	}
	
	public boolean updatePostgraduate(TabPostgraduate postgraduate){
		this.getHibernateTemplate().update(postgraduate);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabPostgraduateDAO#getPostgraduateList()
	 */
	
	public List<TabPostgraduate> getPostgraduateByStuNum(String stuNum){
		String hql="from TabPostgraduate tp where tp.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabPostgraduate> getPostgraduateByStuName(String stuName){
		String hql = "from TabPostgraduate tp where tp.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabPostgraduate> getPostgraduateList(){
		String hql="from TabPostgraduate";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<TabPostgraduate> getPostgraduateListByYear(Date startDate, Date endDate){
		String hql="from TabPostgraduate tp where tp.tabStudents.FStudentRegData >= :startDate and tp.tabStudents.FStudentRegData <= :endDate";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	public List<TabPostgraduate> getPostgraduateByGrade(int gid){
		String hql = "from TabPostgraduate tp where tp.tabStudents.tabClasses.tabGrade.FGradeId='"+gid+"'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<TabPostgraduate> getPostgraduateByClass(String classid){
		String hql = "from TabPostgraduate tp where tp.tabStudents.tabClasses.FClassNumber='"+classid+"'";
		return this.getHibernateTemplate().find(hql);
	}
}
