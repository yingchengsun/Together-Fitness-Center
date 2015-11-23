package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.CssDAO;
import com.xdsc.model.MhqxTabRemind;

public class CssDAOImpl extends HibernateDaoSupport implements CssDAO {

	public MhqxTabRemind findbyid(int id) {

		return (MhqxTabRemind)getHibernateTemplate().get(MhqxTabRemind.class,id);
	}

	public MhqxTabRemind findbyusernumber(String UserNumber) {
		String hql = "from MhqxTabRemind  where FRemindType =?";
		return getHibernateTemplate().find(hql, UserNumber).isEmpty()?null:(MhqxTabRemind)this.getHibernateTemplate().find(hql, UserNumber).get(0);
	}

	public void insert(MhqxTabRemind css) {
		getHibernateTemplate().save(css);
	}

	public void update(MhqxTabRemind css) {
		getHibernateTemplate().update(css);

	}

}
