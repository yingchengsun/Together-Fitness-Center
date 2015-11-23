package com.xdsc.service.yjssx_system.impl;

import com.xdsc.dao.yjssx_system.MhqxTabUserDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.yjssx_system.MhqxTabUserService;

/**
 * 接口功能：对用户信息操作
 * @author 许鑫
 * @version 1.1
 */
public class MhqxTabUserServiceImpl implements MhqxTabUserService {

	private MhqxTabUserDao mhqxTabUserDao; 
	
	/**
	 * 通过ID查找user信息
	 * @param num 用户的ID
	 * @return 系统用户信息
	 * @see com.xdsc.service.yjssx_system.MhqxTabUserService#findMhqxTabUserById(java.lang.String)
	 */
	public MhqxTabUser findMhqxTabUserById(String num) {
		// TODO Auto-generated method stub
		return mhqxTabUserDao.findMhqxTabUserById(num);
	}

	public MhqxTabUserDao getMhqxTabUserDao() {
		return mhqxTabUserDao;
	}

	public void setMhqxTabUserDao(MhqxTabUserDao mhqxTabUserDao) {
		this.mhqxTabUserDao = mhqxTabUserDao;
	}

}
