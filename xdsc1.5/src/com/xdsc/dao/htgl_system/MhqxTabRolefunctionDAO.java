package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolefunction;
/**
 * <p>操作角色功能表的DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRolefunctionDAO {
	/**
	 * 添加角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void saveMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
	/**
	 * 删除角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void removeMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
	/**
	 * 按ID查找角色功能条目
	 * @param id
	 * @return 角色功能对象
	 */
	public MhqxTabRolefunction findMhqxTabRolefunctionById(Integer id);
	/**
	 * 按照角色ID查找条目
	 * @param roleid
	 * @return 角色功能对象
	 */
	public List<MhqxTabRolefunction> findMhqxTabRolefunctionByRoleId(int roleid);
	/**
	 *查找所有角色功能条目
	 * @return 返回所有角色功能条目
	 */
	public List<MhqxTabRolefunction> findAllMhqxTabRolefunction();
	/**
	 * 更新角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void updateMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
}
