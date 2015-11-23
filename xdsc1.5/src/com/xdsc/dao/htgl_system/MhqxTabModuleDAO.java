package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabModule;

/**
 * <p>����ģ����DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabModuleDAO {
	/**
	 * ���ģ��
	 * @param module ģ�����
	 */
	public void saveMhqxTabModule(MhqxTabModule module);
	/**
	 * ɾ��ģ��
	 * @param module ģ�����
	 */
	public void removeMhqxTabModule(MhqxTabModule module);
	/**
	 * ����ID����ģ��
	 * @param id
	 * @return ���ҽ��
	 */
	public MhqxTabModule findMhqxTabModuleById(Integer id);
	/**
	 * ����ģ�����Ʋ���
	 * @param name ģ������
	 * @return ���ҽ��
	 */
	public List<MhqxTabModule> findMhqxTabModuleByName(String name);
	/**
	 * ��������ģ��
	 * @return ���ز�ѯ���
	 */
	public List<MhqxTabModule> findAllMhqxTabModule();
	/**
	 * ����ģ��
	 * @param module
	 */
	public void updateMhqxTabModule(MhqxTabModule module);
}
