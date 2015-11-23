package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRoleDAO;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
/**
 * <p>������ɫ���Serviceʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleManagerImpl implements MhqxTabRoleManager {
	MhqxTabRoleDAO roledao;
	
	public MhqxTabRoleDAO getRoledao() {
		return roledao;
	}

	public void setRoledao(MhqxTabRoleDAO roledao) {
		this.roledao = roledao;
	}
	/**
	 * ���ս�ɫ���Ʋ���
	 * @param name ��ɫ����
	 * @return ���ҽ��
	 */	
	public List<MhqxTabRole> findByName(String name) {
		// TODO Auto-generated method stub
		return this.roledao.findMhqxTabRoleByName(name);
	}
	/**
	 * ɾ����ɫ
	 * @param role ��ɫ����
	 */	
	public void delete(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.removeMhqxTabRole(role);
	}
	/**
	 * �������н�ɫ
	 * @return ���ز�ѯ���
	 */	
	public List<MhqxTabRole> findAll() {
		// TODO Auto-generated method stub
		return roledao.findAllMhqxTabRole();
	}
	/**
	 * ����ID���ҽ�ɫ
	 * @param id
	 * @return ���ҽ��
	 */	
	public MhqxTabRole findById(Integer id) {
		// TODO Auto-generated method stub
		return roledao.findMhqxTabRoleById(id);
	}
	/**
	 * ��ӽ�ɫ
	 * @param role ��ɫ����
	 */
	public void save(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.saveMhqxTabRole(role);
	}
	/**
	 * ���½�ɫ
	 * @param role ��ɫ����
	 */
	public void update(MhqxTabRole role) {
		// TODO Auto-generated method stub
		roledao.updateMhqxTabRole(role);
	}

}
