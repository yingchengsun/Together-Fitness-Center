package com.xdsc.service.htgl_system;

import java.util.List;
import com.xdsc.model.MhqxTabRole;
/**
 * <p>操作角色表的Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleManager {
	/**
	 * 查找所有角色
	 * @return 返回查询结果
	 */	
	public List<MhqxTabRole> findAll();
	/**
	 * 添加角色
	 * @param role 角色对象
	 */
	public void save(MhqxTabRole role);
	/**
	 * 删除角色
	 * @param role 角色对象
	 */	
	public void delete(MhqxTabRole role);
	/**
	 * 按照ID查找角色
	 * @param id
	 * @return 查找结果
	 */	
	public MhqxTabRole findById(Integer id);
	/**
	 * 更新角色
	 * @param role 角色对象
	 */
	public void update(MhqxTabRole role);
	/**
	 * 按照角色名称查找
	 * @param name 角色名称
	 * @return 查找结果
	 */	
	public List<MhqxTabRole> findByName(String name);
	
}
