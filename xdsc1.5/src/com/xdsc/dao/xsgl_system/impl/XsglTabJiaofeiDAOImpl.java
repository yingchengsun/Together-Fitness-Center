package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabJiaofeiDAO;
import com.xdsc.model.XsglTabJiaofei;

public class XsglTabJiaofeiDAOImpl extends HibernateDaoSupport implements XsglTabJiaofeiDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiaofeiDAO#saveJStudent(com.xdsc.model.xsgl_system.XsglTabJiaofei)
	 */
	public boolean saveJStudent(XsglTabJiaofei jstudent){
		this.getHibernateTemplate().save(jstudent);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiaofeiDAO#deleteJStudent(com.xdsc.model.xsgl_system.XsglTabJiaofei)
	 */
	public boolean deleteJStudent(XsglTabJiaofei jstudent){
		this.getHibernateTemplate().delete(jstudent);
		return true;
	}
	
	public boolean updateJStudent(XsglTabJiaofei jstudent){
		this.getHibernateTemplate().update(jstudent);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiaofeiDAO#getJStudentList()
	 */
	public List<XsglTabJiaofei> getJStudentList(){
		String hql = "from XsglTabJiaofei";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiaofei> getJStudentListByGrade(int gradeId){
		String hql="from XsglTabJiaofei xj where xj.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiaofei> getJStudentByStuNum(String stuNum){
		String hql = "from XsglTabJiaofei xj where xj.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiaofei> getJStudentByStuName(String stuName){
		String hql="from XsglTabJiaofei xj where xj.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiaofei> getJStudentByYearClass(String year,String classid){
		String hql="from XsglTabJiaofei xj where xj.FYear='"+year+"' and xj.tabStudents.tabClasses.FClassNumber='"+classid+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
