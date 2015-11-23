package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.UserLoginDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.wsbm.UserLoginService;

/**考生登陆
 * @author 苟小龙
 * @version 1.2
 */
public class UserLoginServiceImpl implements UserLoginService {
	/**
	 * DAO层对象属性
	 */
	private UserLoginDao userLoginDao;
	/**验证系统用户是否有效
	 * @param user 系统用户对象
	 * @return true 有效
	 * @return false 无效
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
