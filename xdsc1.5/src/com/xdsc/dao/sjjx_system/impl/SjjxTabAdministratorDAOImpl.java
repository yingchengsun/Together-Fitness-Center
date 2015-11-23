package com.xdsc.dao.sjjx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
/**对于管理员信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabAdministratorDAOImpl extends HibernateDaoSupport implements SjjxTabAdministratorDAO {

	/**通过管理员登陆Id查找到管理员记录
	 * @param adminNumber
	 * @return 返回查找到的管理员记录
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
