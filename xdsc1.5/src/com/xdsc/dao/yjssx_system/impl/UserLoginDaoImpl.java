package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.UserLoginDao;
import com.xdsc.model.MhqxTabUser;

/**
 * 接口功能：查找系统用户
 * @author 许鑫
 * @version 1.1
 */
public class UserLoginDaoImpl extends HibernateDaoSupport implements UserLoginDao {

	/**
	 * 在用户表中查找是否存在该用户
	 * @param user
	 * @return 返回用户列表
	 * @see com.xdsc.dao.yjssx_system.UserLoginDao#findUserByExample(com.xdsc.model.MhqxTabUser)
	 */
	public List<MhqxTabUser> findUserByExample(MhqxTabUser user) {
		// TODO Auto-generated method stub
		List<MhqxTabUser> list=this.getHibernateTemplate().findByExample(user);
		return list;
	}

}
