package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.UserLoginDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.yjssx_system.UserLoginService;

/**
 * 类功能：查找系统用户
 * @author 许鑫
 * @version 1.1
 */
public class UserLoginServiceImpl implements UserLoginService {

	private UserLoginDao userLoginDao;
	
	/**
	 * 判断用户是否是合法用户
	 * @param user
	 * @return 是或否
	 * @see com.xdsc.service.yjssx_system.UserLoginService#UserIsValide(com.xdsc.model.MhqxTabUser)
	 */
	public Boolean UserIsValide(MhqxTabUser user) {
		// TODO Auto-generated method stub
		if(userLoginDao.findUserByExample(user).size()>0){
			return true;
		}
		return false;
	}

	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

}
