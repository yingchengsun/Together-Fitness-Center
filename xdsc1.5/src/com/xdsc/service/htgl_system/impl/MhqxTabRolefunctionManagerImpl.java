package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRolefunctionDAO;
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
/**
 * <p>操作角色功能表的Service实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRolefunctionManagerImpl implements MhqxTabRolefunctionManager {

	private MhqxTabRolefunctionDAO rolefunctiondao;
		
	public MhqxTabRolefunctionDAO getRolefunctiondao() {
		return rolefunctiondao;
	}

	public void setRolefunctiondao(MhqxTabRolefunctionDAO rolefunctiondao) {
		this.rolefunctiondao = rolefunctiondao;
	}
	/**
	 * 删除角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void delete(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.rolefunctiondao.removeMhqxTabRolefunction(rolefunction);
	}
	/**
	 *查找所有角色功能条目
	 * @return 返回所有角色功能条目
	 */
	public List<MhqxTabRolefunction> findAll() {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findAllMhqxTabRolefunction();
	}
	/**
	 * 按ID查找角色功能条目
	 * @param id
	 * @return 角色功能对象
	 */
	public MhqxTabRolefunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findMhqxTabRolefunctionById(id);
	}
	/**
	 * 按照角色ID查找条目
	 * @param roleid
	 * @return 角色功能对象
	 */
	public List<MhqxTabRolefunction> findByRoleId(int roleid) {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findMhqxTabRolefunctionByRoleId(roleid);
	}
	/**
	 * 添加角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void save(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		 this.rolefunctiondao.saveMhqxTabRolefunction(rolefunction);
	}
	/**
	 * 更新角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void update(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.rolefunctiondao.updateMhqxTabRolefunction(rolefunction);
	}

}
