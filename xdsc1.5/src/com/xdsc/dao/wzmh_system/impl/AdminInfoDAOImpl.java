package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.AdminInfoDAO;
import com.xdsc.model.TabAdministrator;

/**
 * 管理员信息维护
 * 
 * @author 陈丰
 *  
 */
public class AdminInfoDAOImpl extends HibernateDaoSupport implements
		AdminInfoDAO {
	/**
	 * 更新管理员信息
	 * 
	 * @param 陈丰
	 */
	public TabAdministrator findAdminByNum(String num) {
		return getHibernateTemplate().get(TabAdministrator.class, num) == null ? null
				: (TabAdministrator) getHibernateTemplate().get(
						TabAdministrator.class, num);
	}

	/**
	 * 根据管理员帐号查找管理员
	 * 
	 * @param 帐号
	 * @return 管理员实例
	 */
	public void updateAdminInfo(TabAdministrator Admin) {
		if(Admin==null)
			return;
		this.getHibernateTemplate().update(Admin);
	}

	/**
	 * 插入一个管理员
	 * @param Admin
	 */
	public void insertAdminInfo(TabAdministrator Admin) {
		if(Admin==null)
			return;
		getHibernateTemplate().save(Admin);
	}

}
