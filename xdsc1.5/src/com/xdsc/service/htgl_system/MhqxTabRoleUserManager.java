package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRoleuser;
/**
 * �û���ɫ�����Service
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleUserManager {
	/**
	 * ���������û���ɫ
	 * @return �û���ɫ��Ӧ�б�
	 */
	public List<MhqxTabRoleuser> findAll();
	/**
	 * ����û���ɫ����
	 * @param roleuser �û���ɫ����
	 */
	public void save(MhqxTabRoleuser roleuser);
	/**
	 * ɾ���û���ɫ
	 * @param roleuser �û���ɫ����
	 */
	public void delete(MhqxTabRoleuser roleuser);
	/**
	 * ����ID���ҽ�ɫ�û�
	 * @param id ��ɫ�û�ID
	 * @return ��ɫ�û�����
	 */
	public MhqxTabRoleuser findById(Integer id);
	/**
	 * �����û���ɫ����
	 * @param roleuser �û���ɫ���� 
	 */
	public void update(MhqxTabRoleuser userfunction);
	/**
	 * �����û��˺Ų��ҽ�ɫ�û�
	 * @param usernumber �û��˺�
	 * @return ��ɫ�û�����
	 */
	public List<MhqxTabRoleuser> findByUserNumber(String usernumber);
	/**
	 * ����ɫID�����û���ɫ
	 * @param roleid ��ɫID
	 * @return �û���ɫ�б�
	 */
	public List<MhqxTabRoleuser> findByRoleId(int roleid);
}
