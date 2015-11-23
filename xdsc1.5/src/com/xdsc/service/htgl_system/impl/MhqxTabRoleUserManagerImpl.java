package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRoleUserDAO;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
/**
 * �û���ɫ�����Serviceʵ��
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleUserManagerImpl implements MhqxTabRoleUserManager {
	private MhqxTabRoleUserDAO roleuserdao; 
	
	public MhqxTabRoleUserDAO getRoleuserdao() {
		return roleuserdao;
	}

	public void setRoleuserdao(MhqxTabRoleUserDAO roleuserdao) {
		this.roleuserdao = roleuserdao;
	}
	/**
	 * ɾ���û���ɫ
	 * @param roleuser �û���ɫ����
	 */
	public void delete(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.removeMhqxTabRoleUser(roleuser);
	}
	/**
	 * ���������û���ɫ
	 * @return �û���ɫ��Ӧ�б�
	 */
	public List<MhqxTabRoleuser> findAll() {
		// TODO Auto-generated method stub
		return this.roleuserdao.findAllMhqxTabRoleUser();
	}
	/**
	 * ����ID���ҽ�ɫ�û�
	 * @param id ��ɫ�û�ID
	 * @return ��ɫ�û�����
	 */
	public MhqxTabRoleuser findById(Integer id) {
		// TODO Auto-generated method stub
		return this.roleuserdao.findMhqxTabRoleUserById(id);
	}
	/**
	 * �����û��˺Ų��ҽ�ɫ�û�
	 * @param usernumber �û��˺�
	 * @return ��ɫ�û�����
	 */
	public List<MhqxTabRoleuser> findByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		return this.roleuserdao.findMhqxTabRoleUserByUserNumber(usernumber);
	}
	/**
	 * ����û���ɫ����
	 * @param roleuser �û���ɫ����
	 */
	public void save(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.saveMhqxTabRoleUser(roleuser);
	}
	/**
	 * �����û���ɫ����
	 * @param roleuser �û���ɫ���� 
	 */
	public void update(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.roleuserdao.updateMhqxTabRoleuser(roleuser);
	}
	/**
	 * ����ɫID�����û���ɫ
	 * @param roleid ��ɫID
	 * @return �û���ɫ�б�
	 */
	public List<MhqxTabRoleuser> findByRoleId(int roleid)
	{
		return this.roleuserdao.findMhqxTabRoleUserByRoleId(roleid);
	}
}
