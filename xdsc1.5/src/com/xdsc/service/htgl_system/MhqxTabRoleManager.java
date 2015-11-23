package com.xdsc.service.htgl_system;

import java.util.List;
import com.xdsc.model.MhqxTabRole;
/**
 * <p>������ɫ���Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleManager {
	/**
	 * �������н�ɫ
	 * @return ���ز�ѯ���
	 */	
	public List<MhqxTabRole> findAll();
	/**
	 * ��ӽ�ɫ
	 * @param role ��ɫ����
	 */
	public void save(MhqxTabRole role);
	/**
	 * ɾ����ɫ
	 * @param role ��ɫ����
	 */	
	public void delete(MhqxTabRole role);
	/**
	 * ����ID���ҽ�ɫ
	 * @param id
	 * @return ���ҽ��
	 */	
	public MhqxTabRole findById(Integer id);
	/**
	 * ���½�ɫ
	 * @param role ��ɫ����
	 */
	public void update(MhqxTabRole role);
	/**
	 * ���ս�ɫ���Ʋ���
	 * @param name ��ɫ����
	 * @return ���ҽ��
	 */	
	public List<MhqxTabRole> findByName(String name);
	
}
