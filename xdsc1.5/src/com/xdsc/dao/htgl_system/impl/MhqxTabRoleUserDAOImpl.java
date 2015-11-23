package com.xdsc.dao.htgl_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.xdsc.dao.htgl_system.MhqxTabRoleUserDAO;
import com.xdsc.model.MhqxTabRoleuser;
/**
 * �û���ɫ�����DAOʵ��
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleUserDAOImpl extends HibernateDaoSupport implements MhqxTabRoleUserDAO {
	/**
	 * ���������û���ɫ
	 * @return �û���ɫ��Ӧ�б�
	 */
	public List<MhqxTabRoleuser> findAllMhqxTabRoleUser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRoleuser roleuser order by roleuser.FId desc";
		return (List<MhqxTabRoleuser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����ID���ҽ�ɫ�û�
	 * @param id ��ɫ�û�ID
	 * @return ��ɫ�û�����
	 */
	public MhqxTabRoleuser findMhqxTabRoleUserById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRoleuser)this.getHibernateTemplate().get(MhqxTabRoleuser.class, id);
	}
	/**
	 * �����û��˺Ų��ҽ�ɫ�û�
	 * @param usernumber �û��˺�
	 * @return ��ɫ�û�����
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByUserNumber(
			String usernumber) {
		// TODO Auto-generated method stub
		String hql="from MhqxTabRoleuser roleuser where roleuser.mhqxTabUser.FUserNumber='"+usernumber+"'";
		return (List<MhqxTabRoleuser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ���û���ɫ
	 * @param roleuser �û���ɫ����
	 */
	public void removeMhqxTabRoleUser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(roleuser);
	}
	/**
	 * ����û���ɫ����
	 * @param roleuser �û���ɫ����
	 */
	public void saveMhqxTabRoleUser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(roleuser);

	}
	/**
	 * �����û���ɫ����
	 * @param roleuser �û���ɫ���� 
	 */
	public void updateMhqxTabRoleuser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(roleuser);
	}
	/**
	 * ����ɫID�����û���ɫ
	 * @param roleid ��ɫID
	 * @return �û���ɫ�б�
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByRoleId(int roleid)
	{
		String hql = "from MhqxTabRoleuser roleuser where roleuser.mhqxTabRole.FRoleId="+roleid;
		return this.getHibernateTemplate().find(hql);
	}
}
