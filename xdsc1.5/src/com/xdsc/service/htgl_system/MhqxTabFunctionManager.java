package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
/**
 * <p>操作功能表的Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabFunctionManager {	
	/**
	 * <p>查找所有功能<br>
	 * @return 返回功能列表
	 */
	public List<MhqxTabFunction> findAll();
	/**
	 * <p>添加功能对象<br>
	 * @param function 要添加的功能对象
	 */
	public void save(MhqxTabFunction function);
	/**
	 * <p>删除功能<br>
	 * @param 要删除的功能对象
	 */
	public void delete(MhqxTabFunction function);
	/**
	 * <p>按照ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public MhqxTabFunction findById(Integer id);
	/**
	 * <p>更新功能<br>
	 * @param function
	 */
	public void update(MhqxTabFunction function);
	/**
	 * <p>按照功能名称查找<br>
	 * @param name 功能名称
	 * @return 返回查找到的功能
	 */
	public List<MhqxTabFunction> findByName(String name);
	/**
	 * <p>按照模块和角色查找功能<br>
	 * @param moduleid 模块ID
	 * @param rolename 角色ID
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findByModuleidandRolename(int moduleid,String rolename);
	/**
	 * <p>按照父ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findBySuperId(int id);
	/**
	 * 按角色名查找功能
	 * @param rolename 角色名
	 * @return 角色 rolename 所拥有的功能
	 */
	public List<MhqxTabFunction> findByRoleName(String rolename);
}
