package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>操作角色功能表的Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleModuleManager {
	/**
	 *查找所有角色功能条目
	 * @return 返回所有角色功能条目
	 */
	public List<MhqxTabRolemodule> findAll();
	/**
	 * 添加角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void save(MhqxTabRolemodule rolemodule);
	/**
	 * 删除角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void delete(MhqxTabRolemodule rolemodule);
	/**
	 * 按ID查找角色功能条目
	 * @param id
	 * @return 角色功能对象
	 */
	public MhqxTabRolemodule findById(Integer id);
	/**
	 * 更新角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void update(MhqxTabRolemodule rolemodule);
	/**
	 * 按照角色ID查找条目
	 * @param roleid
	 * @return 角色功能对象
	 */
	public List<MhqxTabRolemodule> findByRoleId(int roleid);
}
