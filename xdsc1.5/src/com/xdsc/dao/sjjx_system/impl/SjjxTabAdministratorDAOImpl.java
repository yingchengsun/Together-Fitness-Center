package com.xdsc.dao.sjjx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
/**���ڹ���Ա��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabAdministratorDAOImpl extends HibernateDaoSupport implements SjjxTabAdministratorDAO {

	/**ͨ������Ա��½Id���ҵ�����Ա��¼
	 * @param adminNumber
	 * @return ���ز��ҵ��Ĺ���Ա��¼
	 */
	public TabAdministrator getAdminByFAdminNumber(String adminNumber) {
		String hql = "from TabAdministrator ta where ta.FAdminNumber='" + adminNumber
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabAdministrator) this.getHibernateTemplate().find(hql).get(0);
	}
	
	
}
