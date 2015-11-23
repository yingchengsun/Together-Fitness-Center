package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRolefunctionDAO;
import com.xdsc.model.MhqxTabRolefunction;
/**
 * <p>������ɫ���ܱ��DAOʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRolefuctionDAOImpl extends HibernateDaoSupport implements MhqxTabRolefunctionDAO {
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolefunction> findAllMhqxTabRolefunction() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolefunction rolefunction";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolefunction findMhqxTabRolefunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRolefunction)this.getHibernateTemplate().get(MhqxTabRolefunction.class, id);
	}
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolefunction> findMhqxTabRolefunctionByRoleId(int roleid) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolefunction rolefunction where rolefunction.mhqxTabRole.FRoleId="+roleid;
		return (List<MhqxTabRolefunction>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void removeMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(rolefunction);
	}
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void saveMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rolefunction);
	}
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void updateMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(rolefunction);
	}

}
