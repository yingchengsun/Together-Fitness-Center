package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabStudentsDAO;
import com.xdsc.model.TabStudents;

public class XsglTabStudentsDAOImpl extends HibernateDaoSupport implements
		XsglTabStudentsDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system2.impl.TabStudentsDAO#saveStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#saveStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	public boolean saveStudent(TabStudents student) {
		this.getHibernateTemplate().save(student);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system2.impl.TabStudentsDAO#deleteStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#deleteStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	public boolean deleteStudent(TabStudents student) {
		this.getHibernateTemplate().delete(student);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system2.impl.TabStudentsDAO#getStudentsList()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#getStudentsList()
	 */
	public List<TabStudents> getStudentsList() {
		String hql = "from TabStudents";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system2.impl.TabStudentsDAO#getStudentByStuNum(java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#getStudentByStuNum(java.lang.String)
	 */
	public List getStudentByStuNum(String stuNum) {
		String hql = "from TabStudents ts where ts.FStudentNumber='" + stuNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#getStudentByStuName(java.lang.String)
	 */
	public List<TabStudents> getStudentByStuName(String stuName) {
		String hql = "from TabStudents ts where ts.FStudentName='" + stuName+"'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabStudentsDAO#updateStudent(com.xdsc.model.xsgl_system.TabStudents)
	 */
	public void updateStudent(TabStudents student) {
		this.getHibernateTemplate().update(student);
	}

	public List<TabStudents> getStudentListByClass(String classnumber) {

		// TODO Auto-generated method stub
		String hql = "from TabStudents ts where ts.tabClasses.FClassNumber='"
			+ classnumber + "'";
		
//		String hql = "from TabStudents ts where ts.tabClasses.FClassNumber='"
//				+ classnumber + "'";
		return this.getHibernateTemplate().find(hql);
		// if (this.getHibernateTemplate().find(hql).isEmpty())
		// return null;
		// else
		// return (TabStudents) this.getHibernateTemplate().find(hql).get(0);

	}

	public List<TabStudents> getStudentListByGrade(int gradeId) {
		String hql = "from TabStudents ts where ts.tabClasses.tabGrade.FGradeId='"
				+ gradeId + "'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<TabStudents> getStudentOfMale() {
		String hql = "from TabStudents ts where ts.FStudentSex='M'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<TabStudents> getStudentOfFemale() {
		String hql = "from TabStudents where ts.FStudentSex='F'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List getStudentByAttribute(String way,String attribute){
		String hql="from TabStudents where ts."+way+"='"+attribute+"'";;
		return this.getHibernateTemplate().find(hql);
	}

	public List getStudentListByYear(Date startDate, Date endDate,String classid,String direction_str) {
		String hql="from TabStudents ts where ts.FStudentRegData >= :startDate and ts.FStudentRegData <= :endDate and ts.tabClasses.FClassNumber=:classid and ts.tabDirection.FDirectionName=:direction_str";
		String[] params={"startDate","endDate","classid","direction_str"};
		Object[] args={startDate,endDate,classid,direction_str};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	public List<TabStudents> getGradeStudentByPartyList(Date startDate, Date endDate){
		String hql="from TabStudents ts where ts.FStudentRegData >= :startDate and ts.FStudentRegData <= :endDate and ts.FStudentPoliStatus='党员'";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		List<TabStudents> list = this.getHibernateTemplate().findByNamedParam(hql, params, args);
		String hql1="from TabStudents ts where ts.FStudentRegData >= :startDate and ts.FStudentRegData <= :endDate and ts.FStudentPoliStatus='预备党员'";
		String[] params1={"startDate","endDate"};
		Object[] args1={startDate,endDate};
		List<TabStudents> list1 = this.getHibernateTemplate().findByNamedParam(hql1, params1, args1);
		list.addAll(list1);
		return list;
	}
	
	public List<TabStudents> getStudentByPartyList() {
		String hql="from TabStudents ts where ts.FStudentPoliStatus='党员'";
		List<TabStudents> list = this.getHibernateTemplate().find(hql);
		String hql1="from TabStudents ts where ts.FStudentPoliStatus='预备党员'";
		List<TabStudents> list1 = this.getHibernateTemplate().find(hql1);
		list.addAll(list1);
		return list;
	}
	 
	public List<TabStudents> getStudentBySelectParty(String classid,String status){
		String hql="from TabStudents ts where ts.tabClasses.FClassNumber='"+classid+"' and ts.FStudentPoliStatus='"+status+"'";
		return this.getHibernateTemplate().find(hql);
	}
}
