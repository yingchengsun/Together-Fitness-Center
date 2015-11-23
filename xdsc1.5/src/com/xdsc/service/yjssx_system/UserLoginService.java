package com.xdsc.service.yjssx_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;

/**
 * 接口功能：查找系统用户
 * @author 许鑫
 * @version 1.1
 */
public interface UserLoginService {
	
	/**
	 * 判断用户是否是合法用户
	 * @param user
	 * @return 是或否
	 */
	public Boolean UserIsValide(MhqxTabUser user);
}
