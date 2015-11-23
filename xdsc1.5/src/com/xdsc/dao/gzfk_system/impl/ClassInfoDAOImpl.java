package com.xdsc.dao.gzfk_system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.ClassInfoDAO;
import com.xdsc.model.TabClasses;






public class ClassInfoDAOImpl extends HibernateDaoSupport implements ClassInfoDAO{

	

	public void addClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(class1);
	}

	public void delClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(class1);

	}

	public List<TabClasses> findAllClassInfo() {
		// TODO Auto-generated method stub
		List<TabClasses> list=this.getHibernateTemplate().loadAll(TabClasses.class);
		return list;
	}


	public void updateClassInfo(TabClasses class1) {
		// TODO Auto-generated method stub
		System.out.println("start update imdao********************");
		this.getHibernateTemplate().update(class1);
		System.out.println("finish update imdao********************");


	}
	
	public TabClasses findClassByNum(String FClassNum) {
		// TODO Auto-generated method stub
		return (TabClasses)this.getHibernateTemplate().get(TabClasses.class, FClassNum);
	}

	public List<TabClasses> findClassoneByNum(String num) {
		// TODO Auto-generated method stub
		String hql="from TabClasses c where c.FClassNumber='"+num+"'";
		List<TabClasses> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabClasses> findGradeByNum(String num) {
		// TODO Auto-generated method stub
		String LikeName="%"+num+"%";
		String hql="from TabClasses c where c.FClassNumber like'"+LikeName+"'";
		List<TabClasses> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<TabClasses> findClssByExample(TabClasses class1) {
		// TODO Auto-generated method stub
		List<TabClasses> list=this.getHibernateTemplate().findByExample(class1);
		return list;
	}

}
