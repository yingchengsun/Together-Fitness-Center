package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.OtherInfoDAO;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabOtherstudent;

public class OtherInfoDAOImpl extends HibernateDaoSupport implements OtherInfoDAO{

	public void addOtherStudent(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(otherStudent);
	}

	public void deleteOtherInfo(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(otherStudent);
	}

	public List<GzfkTabOtherstudent> findOtherInfo() {
		// TODO Auto-generated method stub
		List<GzfkTabOtherstudent> list = this.getHibernateTemplate().loadAll(GzfkTabOtherstudent.class);
	    return list;
	}

	public GzfkTabOtherstudent findOtherInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		return (GzfkTabOtherstudent)this.getHibernateTemplate().get(GzfkTabOtherstudent.class, FNumber);
	}

	public List<GzfkTabOtherstudent> findOtherInfoByName(String name) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabOtherstudent c where c.tabStudents.FStudentName='"+name+"'";
		List<GzfkTabOtherstudent> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public void updateOtherInfo(GzfkTabOtherstudent otherStudent) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(otherStudent);
	}

	public List<GzfkTabOtherstudent> findOtherInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabOtherstudent c where c.tabStudents.FStudentNumber='"+num+"'";
		List<GzfkTabOtherstudent> list=this.getHibernateTemplate().find(hql);
		
		return list;
		
	}

	public GzfkTabOtherstudent findOtherInfoByStuSelfNum(String num) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabOtherstudent c where c.tabStudents.FStudentNumber='"+num+"'";
		List<GzfkTabOtherstudent> list=this.getHibernateTemplate().find(hql);
		int size=list.size();
		System.out.println(size);
		GzfkTabOtherstudent otherStudent=new GzfkTabOtherstudent();
		if(size>0){
			otherStudent= list.get(0);
	    }
		return otherStudent;
	}
	

}
