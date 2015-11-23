package com.xdsc.service.gzfk_system.impl;

import java.util.List;

import com.xdsc.dao.gzfk_system.UserLoginDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.gzfk_system.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {

	private UserLoginDao userLoginDao;
	
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

	public MhqxTabUser findUserByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return userLoginDao.findUserByNum(FUserNumber);
	}

}
