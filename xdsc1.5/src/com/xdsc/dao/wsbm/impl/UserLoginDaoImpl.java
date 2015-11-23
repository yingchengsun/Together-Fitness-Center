package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.UserLoginDao;
import com.xdsc.model.MhqxTabUser;

/**用户登录
 * @author 苟小龙
 *@version 1.2
 */
public class UserLoginDaoImpl extends HibernateDaoSupport implements UserLoginDao {
	/**获得用户列表
	 * @param user 用户对象
	 * @return list 用户对象表单
	 */
	public List<MhqxTabUser> findUserByExample(MhqxTabUser user) {
		// TODO Auto-generated method stub
		List<MhqxTabUser> list=this.getHibernateTemplate().findByExample(user);
		return list;
	}

}
