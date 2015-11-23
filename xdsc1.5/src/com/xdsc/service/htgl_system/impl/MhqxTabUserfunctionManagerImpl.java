package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabUserfunctionDAO;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
/**
 * 角色功能表操作Service实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserfunctionManagerImpl implements
		MhqxTabUserfunctionManager {
	private MhqxTabUserfunctionDAO userfunctiondao;
		
	public MhqxTabUserfunctionDAO getUserfunctiondao() {
		return userfunctiondao;
	}

	public void setUserfunctiondao(MhqxTabUserfunctionDAO userfunctiondao) {
		this.userfunctiondao = userfunctiondao;
	}
	/**
	 * 删除角色功能
	 * @param userfunction 用户功能对象
	 */
	public void delete(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.removeMhqxTabUserfunction(userfunction);
	}
	/**
	 * 返回所有的用户功能
	 * @return 用户功能列表
	 */
	public List<MhqxTabUserfunction> findAll() {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findAllMhqxTabUserfunction();
	}
	/**
	 * 按ID查找角色功能条目
	 * @param id 角色功能ID
	 * @return 用户功能对象
	 */
	public MhqxTabUserfunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findMhqxTabUserfunctionById(id);
	}
	/**
	 * 按照用户账号查找
	 * @param usernumber 用户账号
	 * @return 用户账号列表
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		
		return this.userfunctiondao.findMhqxTabUserfunctionByUserNumber(usernumber);
	}
	/**
	 * 添加角色功能
	 * @param userfunction 用户功能对象
	 */
	public void save(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.saveMhqxTabUserfunction(userfunction);
	}
	/**
	 * 更新用户功能
	 * @param userfunction 用户功能对象
	 */
	public void update(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.updateMhqxTabUserfunction(userfunction);
	}
	/**
	 * 按照父功ID能查找用户功能
	 * @param id 父功能ID
	 * @return 用户功能List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(
			int id) {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findMhqxTabUserfunctionBySuperFunctionId(id);
	}
	
	/**
	 * 检查用户是否有该功能
	 * @return 有则返回true,无则返回false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction)
	{
		return this.userfunctiondao.CheckUserFunction(userfunction);
	}

}
