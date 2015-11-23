package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabUserDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
/**
 * �û������Serviceʵ��
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
	 * ɾ���û�
	 * @param user
	 */
	public void delete(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.removeMhqxTabuser(user);
	}
	/**
	 * �������е��û�
	 * @return �����û�
	 */
	public List<MhqxTabUser> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAllMhqxTabuser();
	}
	/**
	 * ����ID�����û�
	 * @param id �û��˺�
	 * @return �����ҵ����û�����
	 */
	public List<MhqxTabUser> findById(String id) {
		// TODO Auto-generated method stub
		return userdao.findMhqxTabuserById(id);
	}
	/**
	 * ����û�
	 * @param user
	 */
	public void save(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.saveMhqxTabuser(user);
	}
	/**
	 * �����û���Ϣ
	 * @param user �û�����
	 */
	public void update(MhqxTabUser user) {
		// TODO Auto-generated method stub
		userdao.updateMhqxTabuser(user);
	}

}
