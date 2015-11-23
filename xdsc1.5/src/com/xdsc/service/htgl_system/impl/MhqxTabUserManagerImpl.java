package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabUserDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
/**
 * 用户表操作Service实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserManagerImpl implements MhqxTabUserManager {
	
	MhqxTabUserDAO userdao;
	
	public MhqxTabUserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(MhqxTabUserDAO userdao) {
		this.userdao = userdao;
	}
	/**
	 * 删除用户
	 * @param user
	 */
	public void delete(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.removeMhqxTabuser(user);
	}
	/**
	 * 查找所有的用户
	 * @return 所有用户
	 */
	public List<MhqxTabUser> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAllMhqxTabuser();
	}
	/**
	 * 按照ID查找用户
	 * @param id 用户账号
	 * @return 返回找到的用户对象
	 */
	public List<MhqxTabUser> findById(String id) {
		// TODO Auto-generated method stub
		return userdao.findMhqxTabuserById(id);
	}
	/**
	 * 添加用户
	 * @param user
	 */
	public void save(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.saveMhqxTabuser(user);
	}
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 */
	public void update(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.updateMhqxTabuser(user);
	}

}
