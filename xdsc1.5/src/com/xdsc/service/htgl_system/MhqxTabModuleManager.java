package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabModule;
/**
 * <p>操作模块表的Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabModuleManager {
	/**
	 * 查找所有模块
	 * @return 返回查询结果
	 */
	public List<MhqxTabModule> findAll();
	/**
	 * 添加模块
	 * @param module 模块对象
	 */
	public void save(MhqxTabModule module);
	/**
	 * 删除模块
	 * @param module 模块对象
	 */
	public void delete(MhqxTabModule module);
	/**
	 * 按照ID查找模块
	 * @param id
	 * @return 查找结果
	 */
	public MhqxTabModule findById(Integer id);
	/**
	 * 更新模块
	 * @param module
	 */
	public void update(MhqxTabModule module);
	/**
	 * 按照模块名称查找
	 * @param name 模块名称
	 * @return 查找结果
	 */
	public List<MhqxTabModule> findByName(String name);
	
}
