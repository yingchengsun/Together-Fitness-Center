package com.xdsc.service.wsbm.impl;

import java.util.List;

import com.xdsc.dao.wsbm.UserLoginDao;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.wsbm.UserLoginService;

/**������½
 * @author ��С��
 * @version 1.2
 */
public class UserLoginServiceImpl implements UserLoginService {
	/**
	 * DAO���������
	 */
	private UserLoginDao userLoginDao;
	/**��֤ϵͳ�û��Ƿ���Ч
	 * @param user ϵͳ�û�����
	 * @return true ��Ч
	 * @return false ��Ч
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
