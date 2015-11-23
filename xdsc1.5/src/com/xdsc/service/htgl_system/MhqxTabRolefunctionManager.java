package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolefunction;

/**
 * <p>������ɫ���ܱ��Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRolefunctionManager {
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolefunction> findAll();
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void save(MhqxTabRolefunction rolefunction);
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void delete(MhqxTabRolefunction rolefunction);
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolefunction findById(Integer id);
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void update(MhqxTabRolefunction rolefunction);
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolefunction> findByRoleId(int roleid);
}
