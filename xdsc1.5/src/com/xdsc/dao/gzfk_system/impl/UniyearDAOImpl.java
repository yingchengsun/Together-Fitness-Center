package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.UniyearDAO;
import com.xdsc.model.GzfkTabComnums;
import com.xdsc.model.GzfkTabUninums;
import com.xdsc.model.TabClasses;

public class UniyearDAOImpl extends HibernateDaoSupport implements UniyearDAO{

	public void addUniyear(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		System.out.println("addUni start!!!!!!!!!!!!!!!!!!!1");
		this.getHibernateTemplate().save(uniyear);
		System.out.println("addUni finish!!!!!!!!!!!!!!!!!!!1");

	}

	public GzfkTabUninums findUniyearByNum(int FNumber) {
		// TODO Auto-generated method stub
		return (GzfkTabUninums)this.getHibernateTemplate().get(GzfkTabUninums.class, FNumber);
	}

	public List<GzfkTabUninums> findUniyearInfoByNum(int uniNum) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabUninums c where c.gzfkTabStudyuniversity.FId='"+uniNum+"'";
		List<GzfkTabUninums> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public List<GzfkTabUninums> findAllUniyear() {
		// TODO Auto-generated method stub
		List<GzfkTabUninums> list=this.getHibernateTemplate().loadAll(GzfkTabUninums.class);
		return list;
	}

	public void deleteUniyearByNum(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(uniyear);

	}

	public void updateUniyear(GzfkTabUninums uniyear) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(uniyear);
	}
	
}
