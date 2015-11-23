package com.xdsc.dao.bksx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.TabAdministratorDAO;
import com.xdsc.model.TabAdministrator;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * ��װ��TabAdministrator�Ĳ���
 */
public class TabAdministratorDAOImpl extends HibernateDaoSupport implements TabAdministratorDAO {
	/**
	 * ����ID���һ������Ա����
	 * 
	 * @param adminID
	 *            ����ԱID
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
