package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabUserDAO;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabUser;
/**
 * �û������DAOʵ��
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserDAOImpl extends HibernateDaoSupport implements MhqxTabUserDAO {
	/**
	 * �������е��û�
	 * @return �����û�
	 */
	public List<MhqxTabUser> findAllMhqxTabuser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUser user order by user.FUserNumber desc";
		return (List<MhqxTabUser>)this.getHibernateTemplate().find(hql);
	}   
	/**
	 * ����ID�����û�
	 * @param id �û��˺�
	 * @return �����ҵ����û�����
	 */
	public List<MhqxTabUser> findMhqxTabuserById(String id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUser user where user.FUserNumber='"+id+"'";
		return (List<MhqxTabUser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ���û�
	 * @param user
	 */
	public void removeMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}
	/**
	 * ����û�
	 * @param user
	 */
	public void saveMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	/**
	 * �����û���Ϣ
	 * @param user �û�����
	 */
	public void updateMhqxTabuser(MhqxTabUser user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

}
