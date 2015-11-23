package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolemodule;
/**
 * <p>������ɫ���ܱ��Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRoleModuleManager {
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolemodule> findAll();
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void save(MhqxTabRolemodule rolemodule);
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void delete(MhqxTabRolemodule rolemodule);
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolemodule findById(Integer id);
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void update(MhqxTabRolemodule rolemodule);
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolemodule> findByRoleId(int roleid);
}
