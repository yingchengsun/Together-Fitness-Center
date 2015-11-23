package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
/**
 * 用户表操作Service
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserManager {
	/**
	 * 查找所有的用户
	 * @return 所有用户
	 */
	public List<MhqxTabUser> findAll();
	/**
	 * 添加用户
	 * @param user
	 */
	public void save(MhqxTabUser user);
	/**
	 * 删除用户
	 * @param user
	 */
	public void delete(MhqxTabUser user);
	/**
	 * 按照ID查找用户
	 * @param id 用户账号
	 * @return 返回找到的用户对象
	 */
	public List<MhqxTabUser> findById(String id);
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 */
	public void update(MhqxTabUser user);

}
