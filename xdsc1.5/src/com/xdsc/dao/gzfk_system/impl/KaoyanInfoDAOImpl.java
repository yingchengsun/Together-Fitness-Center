package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.KaoyanInfoDAO;
import com.xdsc.model.GzfkTabKaoyanstudent;


public class KaoyanInfoDAOImpl extends HibernateDaoSupport implements KaoyanInfoDAO{
	//-----------------¿¼ÑÐ-----------
	public void addKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(kaoyanStudent);
	}

	public void deleteKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		System.out.println("start delete daoimpl**************");

		this.getHibernateTemplate().delete(kaoyanStudent);
		System.out.println("finish delete daoimpl**************");
	}

	public List<GzfkTabKaoyanstudent> findKaoyanInfo() {
		// TODO Auto-generated method stub
		System.out.println("start find daoimpl*************");
		List<GzfkTabKaoyanstudent> list = this.getHibernateTemplate().loadAll(GzfkTabKaoyanstudent.class);
		System.out.println("finish find daoimpl*************");       
		return list;
	}

	public GzfkTabKaoyanstudent findKaoyanInfoByID(Integer FNumber) {
		// TODO Auto-generated method stub
		System.out.println("start find daoimpl**************");
		return (GzfkTabKaoyanstudent)this.getHibernateTemplate().get(GzfkTabKaoyanstudent.class, FNumber);
	}

	public List<GzfkTabKaoyanstudent> findKaoyanInfoByName(String name) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabKaoyanstudent c where c.tabStudents.FStudentName='"+name+"'";
		List<GzfkTabKaoyanstudent> list=this.getHibernateTemplate().find(hql);
		return list;
	}
	

	public void updateKaoyanInfo(GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(kaoyanStudent);
	}

	//public GzfkTabKaoyanstudent findKaoyanInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		//String hql="from GzfkTabKaoyanstudent c where c.tabStudents.FStudentNumber='"+num+"'";
		//GzfkTabKaoyanstudent kaoyanStudent = (GzfkTabKaoyanstudent) this.getHibernateTemplate().find(hql);
		//return kaoyanStudent;
	//}
	
	public GzfkTabKaoyanstudent findKaoyanInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabKaoyanstudent c where c.tabStudents.FStudentNumber='"+num+"'";
		List<GzfkTabKaoyanstudent> list=this.getHibernateTemplate().find(hql);
		int size=list.size();
		System.out.println(size);
		GzfkTabKaoyanstudent kaoyanStudent=new GzfkTabKaoyanstudent();
		if(size>0){
			kaoyanStudent= list.get(0);
	    }
		return kaoyanStudent;
	}

	public List<GzfkTabKaoyanstudent> findKaoyanstudentByExample(
			GzfkTabKaoyanstudent kaoyanStudent) {
		// TODO Auto-generated method stub
		List<GzfkTabKaoyanstudent> list = this.getHibernateTemplate().findByExample(kaoyanStudent);
		return list;
	}
}
