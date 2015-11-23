package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabRolemoduleDAO;
import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>操作角色模块表的DAO实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleModuleDAOImpl extends HibernateDaoSupport implements MhqxTabRolemoduleDAO {
	/**
	 * 查找所有角色模块
	 * @return 返回所用角色模块List
	 */
	public List<MhqxTabRolemodule> findAllMhqxTabRolemodule() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolemodule rolemodule";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 通过ID查找角色模块
	 * @param id 角色对象ID
	 * @return 角色模块对象
	 */
	public MhqxTabRolemodule findMhqxTabRolemoduleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRolemodule)this.getHibernateTemplate().get(MhqxTabRolemodule.class, id);
	}
	/**
	 * 通过角色ID查找
	 * @param roleid 角色ID
	 * @return  返回角色模块List
	 */
	public List<MhqxTabRolemodule> findMhqxTabRolemoduleByRoleId(int roleid) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRolemodule rolemodule where rolemodule.mhqxTabRole.FRoleId="+roleid;
		return (List<MhqxTabRolemodule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除角色模块
	 * @param rolemodule 角色模块对象
	 */
	public void removeMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(rolemodule);
	}
	/**
	 * 添加角色模块
	 * @param rolemodule 角色模块对象
 	 */
	public void saveMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rolemodule);
	}
	/**
	 * 更新角色模块
	 * @param rolemodule 角色模块对象
	 */
	public void updateMhqxTabRolemodule(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(rolemodule);
	}

}
