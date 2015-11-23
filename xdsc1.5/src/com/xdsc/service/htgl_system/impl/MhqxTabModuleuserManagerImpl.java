package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabModuleuserDAO;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
/**
 * <p>操作用户模块表的Service<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleuserManagerImpl implements MhqxTabModuleuserManager {
	
	private MhqxTabModuleuserDAO moduleuserdao;
		
	public MhqxTabModuleuserDAO getModuleuserdao() {
		return moduleuserdao;
	}

	public void setModuleuserdao(MhqxTabModuleuserDAO moduleuserdao) {
		this.moduleuserdao = moduleuserdao;
	}
	/**
	 * 删除用户模块对应条目
	 * @param moduleuser 用户模块对象
	 */
	public void delete(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.removeMhqxTabModuleuser(moduleuser);
	}
	/**
	 * 查找所有用户模块条目
	 * @return 用户模块条目列表
	 */
	public List<MhqxTabModuleuser> findAll() {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findAllMhqxTabModuleuser();
	}
	/**
	 * 按ID查找用户模块对应关系
	 * @param id 要查询的ID
	 * @return 返回查询结果用户模块对象
	 */
	public MhqxTabModuleuser findById(Integer id) {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findMhqxTabModuleuserById(id);
	}
	/**
	 * 按照用户账号查找用户模块信息
	 * @param usernumber 用户账号
	 * @return 按照用户账号查找的结果
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findMhqxTabModuleuserByUserNumber(usernumber);
	}
	/**
	 * 添加用户模块对应关系
	 * @param moduleuser 用户模块对象
	 */
	public void save(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.saveMhqxTabModuleuser(moduleuser);
	}
	/**
	 * 更新用户模块条目
	 * @param moduleuser 用户模块对象
	 */
	public void update(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.updateMhqxTabModuleuser(moduleuser);
	}
	/**
	 * 检查用户是否存在该子系统
	 * @param moduleuser 用户模块对象
	 */
	public boolean CheckModuleUser(MhqxTabModuleuser moduleuser)
	{
		return this.moduleuserdao.CheckModuleUser(moduleuser);
	}
}
