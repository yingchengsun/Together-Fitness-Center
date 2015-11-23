package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabStuorgadepartDAO;
import com.xdsc.model.XsglTabStuorgadepart;

public class XsglTabStuorgadepartDAOImpl extends HibernateDaoSupport implements XsglTabStuorgadepartDAO {
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabStuorgadepartDAO#saveStuent(com.xdsc.model.xsgl_system.XsglTabStuorgadepart)
	 */
	public boolean saveStudent(XsglTabStuorgadepart student){
		this.getHibernateTemplate().save(student);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabStuorgadepartDAO#deleteStudent(com.xdsc.model.xsgl_system.XsglTabStuorgadepart)
	 */
	public boolean deleteStudent(XsglTabStuorgadepart student){
		this.getHibernateTemplate().delete(student);
		return true;
	}
	
	public boolean updateStudent(XsglTabStuorgadepart student){
		this.getHibernateTemplate().update(student);
		return true;
	}
	
	public List<XsglTabStuorgadepart> getStudentList(){
		String hql = "from XsglTabStuorgadepart";
		return this.getHibernateTemplate().find(hql);
	}


//	public List<XsglTabStuorgadepart> getStudentByOrganization(String oname) {
//		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabOrganizations=oname";
//		return this.getHibernateTemplate().find(hql);
//	}
	public XsglTabStuorgadepart getStuorgdepById(int Id){
		String hql="from XsglTabStuorgadepart xtst where xtst.FId='"+Id+"'";
		return (XsglTabStuorgadepart)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabStuorgadepart> getStuOrgByStuNum(String stuNum){
		String hql="from XsglTabStuorgadepart xtst where xtst.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabStuorgadepart> getStuOrgByStuName(String stuName){
		String hql = "from XsglTabStuorgadepart xtst where xtst.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabStuorgadepart> getStudentByOrgDep(int dName){
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabDepartment.FDid='"+dName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabStuorgadepart> getStudentByDepartment(int dname){
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabDepartment.FDname='"+dname+"'and xtst.xsglTabOrganizations.FOname='学生会'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabStuorgadepart> getStudentByKXDepartment(int dname){
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabDepartment.FDname='"+dname+"'and xtst.xsglTabOrganizations.FOname='科协'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabStuorgadepart> getStudentByTWDepartment(int dname){
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabDepartment.FDname='"+dname+"'and xtst.xsglTabOrganizations.FOname='团委'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabStuorgadepart> getStudentByKeXie() {
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabOrganizations.FOname='科协'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabStuorgadepart> getStudentByStudentUnion() {
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabOrganizations.FOname='学生会'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabStuorgadepart> getStudentByTuanWei() {
		String hql = "from XsglTabStuorgadepart xtst where xtst.xsglTabOrganizations.FOname='团委'";
		return this.getHibernateTemplate().find(hql);
	}

}
