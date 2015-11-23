package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRoleDAO;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
/**
 * <p>操作角色表的Service实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleManagerImpl implements MhqxTabRoleManager {
	MhqxTabRoleDAO roledao;
	
	public MhqxTabRoleDAO getRoledao() {
		return roledao;
	}

	public void setRoledao(MhqxTabRoleDAO roledao) {
		this.roledao = roledao;
	}
	/**
	 * 按照角色名称查找
	 * @param name 角色名称
	 * @return 查找结果
	 */	
	public List<MhqxTabRole> findByName(String name) {
		// TODO Auto-generated method stub
		return this.roledao.findMhqxTabRoleByName(name);
	}
	/**
	 * 删除角色
	 * @param role 角色对象
	 */	
	public void delete(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.removeMhqxTabRole(role);
	}
	/**
	 * 查找所有角色
	 * @return 返回查询结果
	 */	
	public List<MhqxTabRole> findAll() {
		// TODO Auto-generated method stub
		return roledao.findAllMhqxTabRole();
	}
	/**
	 * 按照ID查找角色
	 * @param id
	 * @return 查找结果
	 */	
	public MhqxTabRole findById(Integer id) {
		// TODO Auto-generated method stub
		return roledao.findMhqxTabRoleById(id);
	}
	/**
	 * 添加角色
	 * @param role 角色对象
	 */
	public void save(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.saveMhqxTabRole(role);
	}
	/**
	 * 更新角色
	 * @param role 角色对象
	 */
	public void update(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.updateMhqxTabRole(role);
	}

}
