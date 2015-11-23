package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRoleuser;
/**
 * 用户角色表操作DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleUserDAO {
	/**
	 * 添加用户角色对象
	 * @param roleuser 用户角色对象
	 */
	public void saveMhqxTabRoleUser(MhqxTabRoleuser roleuser);
	/**
	 * 删除用户角色
	 * @param roleuser 用户角色对象
	 */
	public void removeMhqxTabRoleUser(MhqxTabRoleuser roleuser);
	/**
	 * 按照ID查找角色用户
	 * @param id 角色用户ID
	 * @return 角色用户对象
	 */
	public MhqxTabRoleuser findMhqxTabRoleUserById(Integer id);
	/**
	 * 按照用户账号查找角色用户
	 * @param usernumber 用户账号
	 * @return 角色用户对象
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByUserNumber(String usernumber);
	/**
	 * 查找所有用户角色
	 * @return 用户角色对应列表
	 */
	public List<MhqxTabRoleuser> findAllMhqxTabRoleUser();
	/**
	 * 更新用户角色对象
	 * @param roleuser 用户角色对象 
	 */
	public void updateMhqxTabRoleuser(MhqxTabRoleuser roleuser);
	/**
	 * 按角色ID查找用户角色
	 * @param roleid 角色ID
	 * @return 用户角色列表
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByRoleId(int roleid);
}
