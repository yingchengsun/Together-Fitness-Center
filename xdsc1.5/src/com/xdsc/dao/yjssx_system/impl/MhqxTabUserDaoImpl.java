package com.xdsc.dao.yjssx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.MhqxTabUserDao;
import com.xdsc.model.MhqxTabUser;

/**
 * 类功能：对用户表的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class MhqxTabUserDaoImpl extends HibernateDaoSupport implements MhqxTabUserDao {

	/**
	 * 通过ID查找user信息
	 * @param num 用户的ID
	 * @return 系统用户信息
	 * @see com.xdsc.dao.yjssx_system.MhqxTabUserDao#findMhqxTabUserById(java.lang.String)
	 */
	public MhqxTabUser findMhqxTabUserById(String num) {
		// TODO Auto-generated method stub
		MhqxTabUser user = (MhqxTabUser) this.getHibernateTemplate().get(MhqxTabUser.class, num);
		return user;
	}

}
