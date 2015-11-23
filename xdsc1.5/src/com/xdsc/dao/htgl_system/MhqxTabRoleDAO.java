package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;
/**
 * <p>操作角色表的DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleDAO {
	/**
	 * 添加角色
	 * @param role 角色对象
	 */
	public void saveMhqxTabRole(MhqxTabRole role);
	/**
	 * 删除角色
	 * @param role 角色对象
	 */	
	public void removeMhqxTabRole(MhqxTabRole role);
	/**
	 * 按照ID查找角色
	 * @param id
	 * @return 查找结果
	 */	
	public MhqxTabRole findMhqxTabRoleById(Integer id);
	/**
	 * 按照角色名称查找
	 * @param name 角色名称
	 * @return 查找结果
	 */	
	public List<MhqxTabRole> findMhqxTabRoleByName(String name);
	/**
	 * 查找所有角色
	 * @return 返回查询结果
	 */	
	public List<MhqxTabRole> findAllMhqxTabRole();
	/**
	 * 更新角色
	 * @param role 角色对象
	 */
	public void updateMhqxTabRole(MhqxTabRole role);
}
