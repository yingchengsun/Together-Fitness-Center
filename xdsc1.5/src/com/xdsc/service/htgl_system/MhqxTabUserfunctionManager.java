package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUserfunction;

/**
 * 角色功能表操作Service
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserfunctionManager {
	/**
	 * 返回所有的用户功能
	 * @return 用户功能列表
	 */
	public List<MhqxTabUserfunction> findAll();
	/**
	 * 添加角色功能
	 * @param userfunction 用户功能对象
	 */
	public void save(MhqxTabUserfunction userfunction);
	/**
	 * 删除角色功能
	 * @param userfunction 用户功能对象
	 */
	public void delete(MhqxTabUserfunction userfunction);
	/**
	 * 按ID查找角色功能条目
	 * @param id 角色功能ID
	 * @return 用户功能对象
	 */
	public MhqxTabUserfunction findById(Integer id);
	/**
	 * 更新用户功能
	 * @param userfunction 用户功能对象
	 */
	public void update(MhqxTabUserfunction userfunction);
	/**
	 * 按照用户账号查找
	 * @param usernumber 用户账号
	 * @return 用户账号列表
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(String usernumber);
	/**
	 * 按照父功ID能查找用户功能
	 * @param id 父功能ID
	 * @return 用户功能List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(int id);
	/**
	 * 检查用户是否有该功能
	 * @return 有则返回true,无则返回false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction);
}
