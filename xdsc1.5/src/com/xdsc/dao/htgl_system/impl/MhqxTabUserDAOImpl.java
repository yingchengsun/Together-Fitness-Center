package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabUserDAO;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabUser;
/**
 * 用户表操作DAO实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserDAOImpl extends HibernateDaoSupport implements MhqxTabUserDAO {
	/**
	 * 查找所有的用户
	 * @return 所有用户
	 */
	public List<MhqxTabUser> findAllMhqxTabuser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUser user order by user.FUserNumber desc";
		return (List<MhqxTabUser>)this.getHibernateTemplate().find(hql);
	}   
	/**
	 * 按照ID查找用户
	 * @param id 用户账号
	 * @return 返回找到的用户对象
	 */
	public List<MhqxTabUser> findMhqxTabuserById(String id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUser user where user.FUserNumber='"+id+"'";
		return (List<MhqxTabUser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除用户
	 * @param user
	 */
	public void removeMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 */
	public void updateMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

}
