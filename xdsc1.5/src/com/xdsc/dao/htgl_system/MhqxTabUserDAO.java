package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUser;
/**
 * �û������DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserDAO {
	/**
	 * ����û�
	 * @param user
	 */
	public void saveMhqxTabuser(MhqxTabUser user);
	/**
	 * ɾ���û�
	 * @param user
	 */
	public void removeMhqxTabuser(MhqxTabUser user);
	/**
	 * ����ID�����û�
	 * @param id �û��˺�
	 * @return �����ҵ����û�����
	 */
	public List<MhqxTabUser> findMhqxTabuserById(String id);
	/**
	 * �������е��û�
	 * @return �����û�
	 */
	public List<MhqxTabUser> findAllMhqxTabuser();
	/**
	 * �����û���Ϣ
	 * @param user �û�����
	 */
	public void updateMhqxTabuser(MhqxTabUser user);
}
