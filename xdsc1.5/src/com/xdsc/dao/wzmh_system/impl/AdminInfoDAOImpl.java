package com.xdsc.dao.wzmh_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.AdminInfoDAO;
import com.xdsc.model.TabAdministrator;

/**
 * ����Ա��Ϣά��
 * 
 * @author �·�
 *  
 */
public class AdminInfoDAOImpl extends HibernateDaoSupport implements
		AdminInfoDAO {
	/**
	 * ���¹���Ա��Ϣ
	 * 
	 * @param �·�
	 */
	public TabAdministrator findAdminByNum(String num) {
		return getHibernateTemplate().get(TabAdministrator.class, num) == null ? null
				: (TabAdministrator) getHibernateTemplate().get(
						TabAdministrator.class, num);
	}

	/**
	 * ���ݹ���Ա�ʺŲ��ҹ���Ա
	 * 
	 * @param �ʺ�
	 * @return ����Աʵ��
	 */
	public void updateAdminInfo(TabAdministrator Admin) {
		if(Admin==null)
			return;
		this.getHibernateTemplate().update(Admin);
	}

	/**
	 * ����һ������Ա
	 * @param Admin
	 */
	public void insertAdminInfo(TabAdministrator Admin) {
		if(Admin==null)
			return;
		getHibernateTemplate().save(Admin);
	}

}
