package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.UserLoginDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;

public class UserLoginDaoImpl extends HibernateDaoSupport implements UserLoginDao {

	public List<MhqxTabUser> findUserByExample(MhqxTabUser user) {
		// TODO Auto-generated method stub
		List<MhqxTabUser> list=this.getHibernateTemplate().findByExample(user);
		return list;
	}

	public MhqxTabUser findUserByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber);
	}

}
