package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRoleUserDAO;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
/**
 * 用户角色表操作Service实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleUserManagerImpl implements MhqxTabRoleUserManager {
	private MhqxTabRoleUserDAO roleuserdao; 
	
	public MhqxTabRoleUserDAO getRoleuserdao() {
		return roleuserdao;
	}

	public void setRoleuserdao(MhqxTabRoleUserDAO roleuserdao) {
		this.roleuserdao = roleuserdao;
	}
	/**
	 * 删除用户角色
	 * @param roleuser 用户角色对象
	 */
	public void delete(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.removeMhqxTabRoleUser(roleuser);
	}
	/**
	 * 查找所有用户角色
	 * @return 用户角色对应列表
	 */
	public List<MhqxTabRoleuser> findAll() {
		// TODO Auto-generated method stub
		return this.roleuserdao.findAllMhqxTabRoleUser();
	}
	/**
	 * 按照ID查找角色用户
	 * @param id 角色用户ID
	 * @return 角色用户对象
	 */
	public MhqxTabRoleuser findById(Integer id) {
		// TODO Auto-generated method stub
		return this.roleuserdao.findMhqxTabRoleUserById(id);
	}
	/**
	 * 按照用户账号查找角色用户
	 * @param usernumber 用户账号
	 * @return 角色用户对象
	 */
	public List<MhqxTabRoleuser> findByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		return this.roleuserdao.findMhqxTabRoleUserByUserNumber(usernumber);
	}
	/**
	 * 添加用户角色对象
	 * @param roleuser 用户角色对象
	 */
	public void save(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.saveMhqxTabRoleUser(roleuser);
	}
	/**
	 * 更新用户角色对象
	 * @param roleuser 用户角色对象 
	 */
	public void update(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.updateMhqxTabRoleuser(roleuser);
	}
	/**
	 * 按角色ID查找用户角色
	 * @param roleid 角色ID
	 * @return 用户角色列表
	 */
	public List<MhqxTabRoleuser> findByRoleId(int roleid)
	{
		return this.roleuserdao.findMhqxTabRoleUserByRoleId(roleid);
	}
}
