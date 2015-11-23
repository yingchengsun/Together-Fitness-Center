package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>������ɫģ����DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRolemoduleDAO {
	/**
	 * ��ӽ�ɫģ��
	 * @param rolemodule ��ɫģ�����
 	 */
	public void saveMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	/**
	 * ɾ����ɫģ��
	 * @param rolemodule ��ɫģ�����
	 */
	public void removeMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	/**
	 * ͨ��ID���ҽ�ɫģ��
	 * @param id ��ɫ����ID
	 * @return ��ɫģ�����
	 */
	public MhqxTabRolemodule findMhqxTabRolemoduleById(Integer id);
	/**
	 * ͨ����ɫID����
	 * @param roleid ��ɫID
	 * @return  ���ؽ�ɫģ��List
	 */
	public List<MhqxTabRolemodule> findMhqxTabRolemoduleByRoleId(int roleid);
	/**
	 * �������н�ɫģ��
	 * @return �������ý�ɫģ��List
	 */
	public List<MhqxTabRolemodule> findAllMhqxTabRolemodule();
	/**
	 * ���½�ɫģ��
	 * @param rolemodule ��ɫģ�����
	 */
	public void updateMhqxTabRolemodule(MhqxTabRolemodule rolemodule);
	
}
