package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabRolefunction;
/**
 * <p>������ɫ���ܱ��DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabRolefunctionDAO {
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void saveMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void removeMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolefunction findMhqxTabRolefunctionById(Integer id);
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolefunction> findMhqxTabRolefunctionByRoleId(int roleid);
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolefunction> findAllMhqxTabRolefunction();
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void updateMhqxTabRolefunction(MhqxTabRolefunction rolefunction);
}
