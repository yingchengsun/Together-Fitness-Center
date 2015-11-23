package com.xdsc.dao.yjssx_system;

import com.xdsc.model.MhqxTabUser;

/**
 * 接口功能：对用户表的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface MhqxTabUserDao {

	/**
	 * 通过ID查找user信息
	 * @param num 用户的ID
	 * @return 系统用户信息
	 */
	public MhqxTabUser findMhqxTabUserById(String num);
}
