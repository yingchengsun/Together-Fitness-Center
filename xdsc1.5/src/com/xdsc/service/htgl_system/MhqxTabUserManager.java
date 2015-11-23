package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
/**
 * �û������Service
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserManager {
	/**
	 * �������е��û�
	 * @return �����û�
	 */
	public List<MhqxTabUser> findAll();
	/**
	 * ����û�
	 * @param user
	 */
	public void save(MhqxTabUser user);
	/**
	 * ɾ���û�
	 * @param user
	 */
	public void delete(MhqxTabUser user);
	/**
	 * ����ID�����û�
	 * @param id �û��˺�
	 * @return �����ҵ����û�����
	 */
	public List<MhqxTabUser> findById(String id);
	/**
	 * �����û���Ϣ
	 * @param user �û�����
	 */
	public void update(MhqxTabUser user);

}
