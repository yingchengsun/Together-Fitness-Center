package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabModule;
/**
 * <p>����ģ����Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabModuleManager {
	/**
	 * ��������ģ��
	 * @return ���ز�ѯ���
	 */
	public List<MhqxTabModule> findAll();
	/**
	 * ���ģ��
	 * @param module ģ�����
	 */
	public void save(MhqxTabModule module);
	/**
	 * ɾ��ģ��
	 * @param module ģ�����
	 */
	public void delete(MhqxTabModule module);
	/**
	 * ����ID����ģ��
	 * @param id
	 * @return ���ҽ��
	 */
	public MhqxTabModule findById(Integer id);
	/**
	 * ����ģ��
	 * @param module
	 */
	public void update(MhqxTabModule module);
	/**
	 * ����ģ�����Ʋ���
	 * @param name ģ������
	 * @return ���ҽ��
	 */
	public List<MhqxTabModule> findByName(String name);
	
}
