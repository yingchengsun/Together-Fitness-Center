package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.UserLoginDao;
import com.xdsc.model.MhqxTabUser;

/**�û���¼
 * @author ��С��
 *@version 1.2
 */
public class UserLoginDaoImpl extends HibernateDaoSupport implements UserLoginDao {
	/**����û��б�
	 * @param user �û�����
	 * @return list �û������
	 */
	public List<MhqxTabUser> findUserByExample(MhqxTabUser user) {
		// TODO Auto-generated method stub
		List<MhqxTabUser> list=this.getHibernateTemplate().findByExample(user);
		return list;
	}

}
