package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRoleDAO;
import com.xdsc.model.MhqxTabRole;
/**
 * <p>������ɫ���DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleDAOImpl extends HibernateDaoSupport implements MhqxTabRoleDAO {
	/**
	 * ���ս�ɫ���Ʋ���
	 * @param name ��ɫ����
	 * @return ���ҽ��
	 */	
	public List<MhqxTabRole> findMhqxTabRoleByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRole role where role.FRoleName='"+name+"'";
		return (List<MhqxTabRole>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * �������н�ɫ
	 * @return ���ز�ѯ���
	 */	
	public List<MhqxTabRole> findAllMhqxTabRole() {
		// TODO Auto-generated method stub
		
		String hql = "from MhqxTabRole role order by role.id desc";
		
		return (List<MhqxTabRole>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����ID���ҽ�ɫ
	 * @param id
	 * @return ���ҽ��
	 */	
	public MhqxTabRole findMhqxTabRoleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRole)this.getHibernateTemplate().get(MhqxTabRole.class, id);
	}
	/**
	 * ɾ����ɫ
	 * @param role ��ɫ����
	 */
	public void removeMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(role);
	}
	/**
	 * ��ӽ�ɫ
	 * @param role ��ɫ����
	 */
	public void saveMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(role);
	}
	/**
	 * ���½�ɫ
	 * @param role ��ɫ����
	 */
	public void updateMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(role);
	}

}
