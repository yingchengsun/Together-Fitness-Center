package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
/**
 * 用户表操作DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserDAO {
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveMhqxTabuser(MhqxTabUser user);
	/**
	 * 删除用户
	 * @param user
	 */
	public void removeMhqxTabuser(MhqxTabUser user);
	/**
	 * 按照ID查找用户
	 * @param id 用户账号
	 * @return 返回找到的用户对象
	 */
	public List<MhqxTabUser> findMhqxTabuserById(String id);
	/**
	 * 查找所有的用户
	 * @return 所有用户
	 */
	public List<MhqxTabUser> findAllMhqxTabuser();
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 */
	public void updateMhqxTabuser(MhqxTabUser user);
}
