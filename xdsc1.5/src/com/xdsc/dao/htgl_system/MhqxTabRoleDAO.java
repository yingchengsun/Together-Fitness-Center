package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;
/**
 * <p>������ɫ���DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleDAO {
	/**
	 * ��ӽ�ɫ
	 * @param role ��ɫ����
	 */
	public void saveMhqxTabRole(MhqxTabRole role);
	/**
	 * ɾ����ɫ
	 * @param role ��ɫ����
	 */	
	public void removeMhqxTabRole(MhqxTabRole role);
	/**
	 * ����ID���ҽ�ɫ
	 * @param id
	 * @return ���ҽ��
	 */	
	public MhqxTabRole findMhqxTabRoleById(Integer id);
	/**
	 * ���ս�ɫ���Ʋ���
	 * @param name ��ɫ����
	 * @return ���ҽ��
	 */	
	public List<MhqxTabRole> findMhqxTabRoleByName(String name);
	/**
	 * �������н�ɫ
	 * @return ���ز�ѯ���
	 */	
	public List<MhqxTabRole> findAllMhqxTabRole();
	/**
	 * ���½�ɫ
	 * @param role ��ɫ����
	 */
	public void updateMhqxTabRole(MhqxTabRole role);
}
