package com.xdsc.service.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleDAO;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
/**
 * <p>操作模块表的Service实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleManagerImpl implements MhqxTabModuleManager{
	private MhqxTabModuleDAO moduledao;
	
	public MhqxTabModuleDAO getModuledao() {
		return moduledao;
	}

	public void setModuledao(MhqxTabModuleDAO moduledao) {
		this.moduledao = moduledao;
	}
	/**
	 * 删除模块
	 * @param module 模块对象
	 */
	public void delete(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.removeMhqxTabModule(module);
	}
	/**
	 * 查找所有模块
	 * @return 返回查询结果
	 */
	public List<MhqxTabModule> findAll() {
		// TODO Auto-generated method stub
		return this.moduledao.findAllMhqxTabModule();
	}
	/**
	 * 按照ID查找模块
	 * @param id
	 * @return 查找结果
	 */
	public MhqxTabModule findById(Integer id) {
		// TODO Auto-generated method stub
		return this.moduledao.findMhqxTabModuleById(id);
	}
	/**
	 * 按照模块名称查找
	 * @param name 模块名称
	 * @return 查找结果
	 */
	public List<MhqxTabModule> findByName(String name) {
		// TODO Auto-generated method stub
		return this.moduledao.findMhqxTabModuleByName(name);
	}
	/**
	 * 添加模块
	 * @param module 模块对象
	 */
	public void save(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.saveMhqxTabModule(module);
	}
	/**
	 * 更新模块
	 * @param module
	 */
	public void update(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.updateMhqxTabModule(module);
	}

}
