package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRoleDAO;
import com.xdsc.model.MhqxTabRole;
/**
 * <p>操作角色表的DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleDAOImpl extends HibernateDaoSupport implements MhqxTabRoleDAO {
	/**
	 * 按照角色名称查找
	 * @param name 角色名称
	 * @return 查找结果
	 */	
	public List<MhqxTabRole> findMhqxTabRoleByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRole role where role.FRoleName='"+name+"'";
		return (List<MhqxTabRole>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 查找所有角色
	 * @return 返回查询结果
	 */	
	public List<MhqxTabRole> findAllMhqxTabRole() {
		// TODO Auto-generated method stub
		
		String hql = "from MhqxTabRole role order by role.id desc";
		
		return (List<MhqxTabRole>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按照ID查找角色
	 * @param id
	 * @return 查找结果
	 */	
	public MhqxTabRole findMhqxTabRoleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRole)this.getHibernateTemplate().get(MhqxTabRole.class, id);
	}
	/**
	 * 删除角色
	 * @param role 角色对象
	 */
	public void removeMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(role);
	}
	/**
	 * 添加角色
	 * @param role 角色对象
	 */
	public void saveMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(role);
	}
	/**
	 * 更新角色
	 * @param role 角色对象
	 */
	public void updateMhqxTabRole(MhqxTabRole role) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(role);
	}

}
