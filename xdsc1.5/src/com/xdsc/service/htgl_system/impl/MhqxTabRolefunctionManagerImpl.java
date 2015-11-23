package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabRolefunctionDAO;
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
/**
 * <p>������ɫ���ܱ��Serviceʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRolefunctionManagerImpl implements MhqxTabRolefunctionManager {

	private MhqxTabRolefunctionDAO rolefunctiondao;
		
	public MhqxTabRolefunctionDAO getRolefunctiondao() {
		return rolefunctiondao;
	}

	public void setRolefunctiondao(MhqxTabRolefunctionDAO rolefunctiondao) {
		this.rolefunctiondao = rolefunctiondao;
	}
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void delete(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.rolefunctiondao.removeMhqxTabRolefunction(rolefunction);
	}
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolefunction> findAll() {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findAllMhqxTabRolefunction();
	}
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolefunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findMhqxTabRolefunctionById(id);
	}
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolefunction> findByRoleId(int roleid) {
		// TODO Auto-generated method stub
		return this.rolefunctiondao.findMhqxTabRolefunctionByRoleId(roleid);
	}
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void save(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		 this.rolefunctiondao.saveMhqxTabRolefunction(rolefunction);
	}
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void update(MhqxTabRolefunction rolefunction) {
		// TODO Auto-generated method stub
		this.rolefunctiondao.updateMhqxTabRolefunction(rolefunction);
	}

}
