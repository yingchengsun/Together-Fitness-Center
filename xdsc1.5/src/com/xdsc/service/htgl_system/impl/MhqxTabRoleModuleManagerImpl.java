package com.xdsc.service.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.xdsc.dao.htgl_system.MhqxTabRolemoduleDAO;
import com.xdsc.model.MhqxTabRolemodule;
import com.xdsc.service.htgl_system.MhqxTabRoleModuleManager;
/**
 * <p>������ɫ���ܱ��Serviceʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleModuleManagerImpl implements
		MhqxTabRoleModuleManager {
	
	private MhqxTabRolemoduleDAO rolemoduledao;

	public MhqxTabRolemoduleDAO getRolemoduledao() {
		return rolemoduledao;
	}

	public void setRolemoduledao(MhqxTabRolemoduleDAO rolemoduledao) {
		this.rolemoduledao = rolemoduledao;
	}
	/**
	 * ɾ����ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void delete(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.removeMhqxTabRolemodule(rolemodule);
	}
	/**
	 *�������н�ɫ������Ŀ
	 * @return �������н�ɫ������Ŀ
	 */
	public List<MhqxTabRolemodule> findAll() {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findAllMhqxTabRolemodule();
	}
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id
	 * @return ��ɫ���ܶ���
	 */
	public MhqxTabRolemodule findById(Integer id) {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findMhqxTabRolemoduleById(id);
	}
	/**
	 * ���ս�ɫID������Ŀ
	 * @param roleid
	 * @return ��ɫ���ܶ���
	 */
	public List<MhqxTabRolemodule> findByRoleId(int roleid) {
		// TODO Auto-generated method stub
		return this.rolemoduledao.findMhqxTabRolemoduleByRoleId(roleid);
	}
	/**
	 * ��ӽ�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void save(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.saveMhqxTabRolemodule(rolemodule);
	}
	/**
	 * ���½�ɫ������Ŀ
	 * @param rolefunction ��ɫ���ܶ���
	 */
	public void update(MhqxTabRolemodule rolemodule) {
		// TODO Auto-generated method stub
		this.rolemoduledao.updateMhqxTabRolemodule(rolemodule);
	}

}
