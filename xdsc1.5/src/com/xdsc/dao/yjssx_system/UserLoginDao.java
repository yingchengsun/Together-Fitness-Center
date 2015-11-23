package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;

/**
 * 接口功能：查找系统用户
 * @author 许鑫
 * @version 1.1
 */
public interface UserLoginDao {
	
	/**
	 * 在用户表中查找是否存在该用户
	 * @param user
	 * @return 返回用户列表
	 */
	List<MhqxTabUser> findUserByExample(MhqxTabUser user);

}
