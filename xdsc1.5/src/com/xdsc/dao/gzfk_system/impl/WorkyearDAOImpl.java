package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.WorkyearDAO;
import com.xdsc.model.GzfkTabComnums;
import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabStudents;

public class WorkyearDAOImpl  extends HibernateDaoSupport implements WorkyearDAO{

	public void addWorkyear(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(workyear);
	}

	public GzfkTabComnums findWorkyearByNum(int FId) {
		// TODO Auto-generated method stub
		return (GzfkTabComnums)this.getHibernateTemplate().get(GzfkTabComnums.class, FId);
	}

	public List<GzfkTabComnums> findWorkyearInfoByNum(String name) {
		// TODO Auto-generated method stub
		String hql="from GzfkTabComnums c where c.tabCompany.FCompanyNumber='"+name+"'";
		List<GzfkTabComnums> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	public void deleteWorkyearByNum(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(workyear);

	}

	public List<GzfkTabComnums> findAllWorkyear() {
		// TODO Auto-generated method stub
		List<GzfkTabComnums> list=this.getHibernateTemplate().loadAll(GzfkTabComnums.class);
		return list;
	}

	public void updateWorkyear(GzfkTabComnums workyear) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(workyear);

	}

	
}
