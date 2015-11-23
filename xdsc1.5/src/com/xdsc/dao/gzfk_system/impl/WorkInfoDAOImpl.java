package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.WorkInfoDAO;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabWorkstudent;
import com.xdsc.model.TabCompany;




public class WorkInfoDAOImpl extends HibernateDaoSupport implements WorkInfoDAO{

	//------นคื๗---------
	public void addWorkStudent(GzfkTabWorkstudent workStudent) {
		getHibernateTemplate().save(workStudent);
	}

	public List<GzfkTabWorkstudent> findWorkInfo() {
		// TODO Auto-generated method stub
		List<GzfkTabWorkstudent> list = this.getHibernateTemplate().loadAll(GzfkTabWorkstudent.class);
		return list;
	}

	public void deleteWorkInfo(GzfkTabWorkstudent workStudent) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(workStudent);
	}

	public GzfkTabWorkstudent findWorkInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		return (GzfkTabWorkstudent)this.getHibernateTemplate().get(GzfkTabWorkstudent.class, FNumber);
	}


	
	public void updateWorkInfo(GzfkTabWorkstudent workStudent) {
		this.getHibernateTemplate().update(workStudent);
		
	}

	public List<GzfkTabWorkstudent> findWorkInfoByName(String name) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabWorkstudent c where c.tabStudents.FStudentName='"+name+"'";
		List<GzfkTabWorkstudent> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<GzfkTabWorkstudent> findWorkInfoByCity(String FCityselect) {
		// TODO Auto-generated method stub
		System.out.println("city dao*****************************");
		String hql="from GzfkTabWorkstudent c where c.FWorkCity='"+FCityselect+"'";
		List<GzfkTabWorkstudent> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public GzfkTabWorkstudent findWorkInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabWorkstudent c where c.tabStudents.FStudentNumber='"+num+"'";
		List list=this.getHibernateTemplate().find(hql);
		GzfkTabWorkstudent workstudent=new GzfkTabWorkstudent();
		if(list.size()>0){
			workstudent=(GzfkTabWorkstudent)list.get(0);
		}
		return workstudent;
	}

	public List<GzfkTabWorkstudent> findWorkstudentByExample(
			GzfkTabWorkstudent workStudent) {
		// TODO Auto-generated method stub
		List<GzfkTabWorkstudent> list= this.getHibernateTemplate().findByExample(workStudent);
		return null;
	}


}
