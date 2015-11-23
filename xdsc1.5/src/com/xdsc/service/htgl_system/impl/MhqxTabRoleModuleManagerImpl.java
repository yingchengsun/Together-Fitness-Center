package com.xdsc.service.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.xdsc.dao.htgl_system.MhqxTabRolemoduleDAO;
import com.xdsc.model.MhqxTabRolemodule;
import com.xdsc.service.htgl_system.MhqxTabRoleModuleManager;
/**
 * <p>操作角色功能表的Service实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleModuleManagerImpl implements
		MhqxTabRoleModuleManager {
	
	private MhqxTabRolemoduleDAO rolemoduledao;

	public MhqxTabRolemoduleDAO getRolemoduledao() {
		return rolemoduledao;
	}

	public void setRolemoduledao(MhqxTabRolemoduleDAO rolemoduledao) {
		this.rolemoduledao = rolemoduledao;
	}
	/**
	 * 删除角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void delete(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.removeMhqxTabRolemodule(rolemodule);
	}
	/**
	 *查找所有角色功能条目
	 * @return 返回所有角色功能条目
	 */
	public List<MhqxTabRolemodule> findAll() {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findAllMhqxTabRolemodule();
	}
	/**
	 * 按ID查找角色功能条目
	 * @param id
	 * @return 角色功能对象
	 */
	public MhqxTabRolemodule findById(Integer id) {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findMhqxTabRolemoduleById(id);
	}
	/**
	 * 按照角色ID查找条目
	 * @param roleid
	 * @return 角色功能对象
	 */
	public List<MhqxTabRolemodule> findByRoleId(int roleid) {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findMhqxTabRolemoduleByRoleId(roleid);
	}
	/**
	 * 添加角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void save(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.saveMhqxTabRolemodule(rolemodule);
	}
	/**
	 * 更新角色功能条目
	 * @param rolefunction 角色功能对象
	 */
	public void update(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.updateMhqxTabRolemodule(rolemodule);
	}

}
