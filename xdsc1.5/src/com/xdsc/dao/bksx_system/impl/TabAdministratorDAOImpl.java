package com.xdsc.dao.bksx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.TabAdministratorDAO;
import com.xdsc.model.TabAdministrator;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 封装对TabAdministrator的操作
 */
public class TabAdministratorDAOImpl extends HibernateDaoSupport implements TabAdministratorDAO {
	/**
	 * 根据ID获得一个管理员对象
	 * 
	 * @param adminID
	 *            管理员ID
	 * @return TabAdministrator
	 */
	public TabAdministrator getAdminById(String adminID) {
		String hql = "from TabAdministrator ta where ta.FAdminNumber='"
				+ adminID + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabAdministrator) (this.getHibernateTemplate().find(hql)
					.get(0));
	}
}
