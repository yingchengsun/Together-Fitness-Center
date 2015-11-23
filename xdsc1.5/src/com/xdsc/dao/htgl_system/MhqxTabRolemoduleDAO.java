package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>操作角色模块表的DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRolemoduleDAO {
	/**
	 * 添加角色模块
	 * @param rolemodule 角色模块对象
 	 */
	public void saveMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	/**
	 * 删除角色模块
	 * @param rolemodule 角色模块对象
	 */
	public void removeMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	/**
	 * 通过ID查找角色模块
	 * @param id 角色对象ID
	 * @return 角色模块对象
	 */
	public MhqxTabRolemodule findMhqxTabRolemoduleById(Integer id);
	/**
	 * 通过角色ID查找
	 * @param roleid 角色ID
	 * @return  返回角色模块List
	 */
	public List<MhqxTabRolemodule> findMhqxTabRolemoduleByRoleId(int roleid);
	/**
	 * 查找所有角色模块
	 * @return 返回所用角色模块List
	 */
	public List<MhqxTabRolemodule> findAllMhqxTabRolemodule();
	/**
	 * 更新角色模块
	 * @param rolemodule 角色模块对象
	 */
	public void updateMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	
}
