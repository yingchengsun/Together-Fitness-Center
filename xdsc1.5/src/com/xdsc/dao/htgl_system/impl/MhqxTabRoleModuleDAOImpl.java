package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRolemoduleDAO;
import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>������ɫģ����DAOʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleModuleDAOImpl extends HibernateDaoSupport implements MhqxTabRolemoduleDAO {
	/**
	 * �������н�ɫģ��
	 * @return �������ý�ɫģ��List
	 */
	public List<MhqxTabRolemodule> findAllMhqxTabRolemodule() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolemodule rolemodule";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ͨ��ID���ҽ�ɫģ��
	 * @param id ��ɫ����ID
	 * @return ��ɫģ�����
	 */
	public MhqxTabRolemodule findMhqxTabRolemoduleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRolemodule)this.getHibernateTemplate().get(MhqxTabRolemodule.class, id);
	}
	/**
	 * ͨ����ɫID����
	 * @param roleid ��ɫID
	 * @return  ���ؽ�ɫģ��List
	 */
	public List<MhqxTabRolemodule> findMhqxTabRolemoduleByRoleId(int roleid) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolemodule rolemodule where rolemodule.mhqxTabRole.FRoleId="+roleid;
		return (List<MhqxTabRolemodule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ����ɫģ��
	 * @param rolemodule ��ɫģ�����
	 */
	public void removeMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(rolemodule);
	}
	/**
	 * ��ӽ�ɫģ��
	 * @param rolemodule ��ɫģ�����
 	 */
	public void saveMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rolemodule);
	}
	/**
	 * ���½�ɫģ��
	 * @param rolemodule ��ɫģ�����
	 */
	public void updateMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(rolemodule);
	}

}
