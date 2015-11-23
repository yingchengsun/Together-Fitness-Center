package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRoleuser;
/**
 * �û���ɫ�����DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleUserDAO {
	/**
	 * ����û���ɫ����
	 * @param roleuser �û���ɫ����
	 */
	public void saveMhqxTabRoleUser(MhqxTabRoleuser roleuser);
	/**
	 * ɾ���û���ɫ
	 * @param roleuser �û���ɫ����
	 */
	public void removeMhqxTabRoleUser(MhqxTabRoleuser roleuser);
	/**
	 * ����ID���ҽ�ɫ�û�
	 * @param id ��ɫ�û�ID
	 * @return ��ɫ�û�����
	 */
	public MhqxTabRoleuser findMhqxTabRoleUserById(Integer id);
	/**
	 * �����û��˺Ų��ҽ�ɫ�û�
	 * @param usernumber �û��˺�
	 * @return ��ɫ�û�����
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByUserNumber(String usernumber);
	/**
	 * ���������û���ɫ
	 * @return �û���ɫ��Ӧ�б�
	 */
	public List<MhqxTabRoleuser> findAllMhqxTabRoleUser();
	/**
	 * �����û���ɫ����
	 * @param roleuser �û���ɫ���� 
	 */
	public void updateMhqxTabRoleuser(MhqxTabRoleuser roleuser);
	/**
	 * ����ɫID�����û���ɫ
	 * @param roleid ��ɫID
	 * @return �û���ɫ�б�
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByRoleId(int roleid);
}
