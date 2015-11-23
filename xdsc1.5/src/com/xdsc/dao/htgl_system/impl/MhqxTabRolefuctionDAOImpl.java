package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRolefunctionDAO;
import com.xdsc.model.MhqxTabRolefunction;
/**
 * <p>操作角色功能表的DAO实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRolefuctionDAOImpl extends HibernateDaoSupport implements MhqxTabRolefunctionDAO {
	/**
	 *查找所有角色功能条目
	 * @return 返回所有角色功能条目
	 */
	public List<MhqxTabRolefunction> findAllMhqxTabRolefunction() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolefunction rolefunction";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按ID查找角色功能条目
	 * @param id
	 * @return 角色功能对象
	 */
	public MhqxTabRolefunction findMhqxTabRolefunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRolefunction)this.getHibernateTemplate().get(MhqxTabRolefunction.class, id);
	}
	/**
	 * 按照角色ID查找条目
	 * @param roleid
	 * @return 角色功能对象
	 */
	public List<MhqxTabRolefunction> findMhqxTabRolefunctionByRoleId(int roleid) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolefunction rolefunction where rolefunction.mhqxTabRole.FRoleId="+roleid;
		return (List<MhqxTabRolefunction>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void removeMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(rolefunction);
	}
	/**
	 * 添加角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void saveMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rolefunction);
	}
	/**
	 * 更新角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void updateMhqxTabRolefunction(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(rolefunction);
	}

}
