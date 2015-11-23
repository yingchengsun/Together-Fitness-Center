package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.StudentInfoDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabClasses;

import com.xdsc.model.TabStudents;





public class StudentInfoDAOImpl extends HibernateDaoSupport implements StudentInfoDAO{

	public void addStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}

	public void addStudentInfo(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	
	public void delStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(student);
	}

	public List<TabStudents> findAllStudentInfo() {
		// TODO Auto-generated method stub
		List<TabStudents> list=this.getHibernateTemplate().loadAll(TabStudents.class);
		return list;
	}

	public List<TabStudents> findStudentByName(String name) {
		// TODO Auto-generated method stub
		String hql="from TabStudents c where c.FStudentName='"+name+"'";
		List<TabStudents> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public TabStudents findStudentByNum(String num) {
//		 TODO Auto-generated method stub
		System.out.println(num+"***************************");
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, num);

	}
	

	public void updateStudentInfo(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(student);
	}

	public MhqxTabUser findModuleById(String id) {
		// TODO Auto-generated method stub
		MhqxTabUser user=(MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
		return user;
	}

	public List<TabStudents> findStudentByClass(String ClassNum) {
		// TODO Auto-generated method stub
		String hql="from TabStudents c where c.tabClasses.FClassNumber='"+ClassNum+"'";
		List<TabStudents> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabStudents> findStudentbyQuxiang(String FQuxiangselect) {
		// TODO Auto-generated method stub
		String hql="from TabStudents c where c.FQuXiang='"+FQuxiangselect+"'";
		List<TabStudents> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabStudents> searchStudentByNum(String num) {
		// TODO Auto-generated method stub
		String LikeName="%"+num+"%";
		String hql="from TabStudents c where c.FStudentNumber like'"+LikeName+"'";
		List<TabStudents> list=this.getHibernateTemplate().find(hql);
		return list;
		
	}

}
