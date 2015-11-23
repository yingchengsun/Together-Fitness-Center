package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabModuleuserDAO;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
/**
 * <p>�����û�ģ����Service<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleuserManagerImpl implements MhqxTabModuleuserManager {
	
	private MhqxTabModuleuserDAO moduleuserdao;
		
	public MhqxTabModuleuserDAO getModuleuserdao() {
		return moduleuserdao;
	}

	public void setModuleuserdao(MhqxTabModuleuserDAO moduleuserdao) {
		this.moduleuserdao = moduleuserdao;
	}
	/**
	 * ɾ���û�ģ���Ӧ��Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void delete(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.removeMhqxTabModuleuser(moduleuser);
	}
	/**
	 * ���������û�ģ����Ŀ
	 * @return �û�ģ����Ŀ�б�
	 */
	public List<MhqxTabModuleuser> findAll() {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findAllMhqxTabModuleuser();
	}
	/**
	 * ��ID�����û�ģ���Ӧ��ϵ
	 * @param id Ҫ��ѯ��ID
	 * @return ���ز�ѯ����û�ģ�����
	 */
	public MhqxTabModuleuser findById(Integer id) {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findMhqxTabModuleuserById(id);
	}
	/**
	 * �����û��˺Ų����û�ģ����Ϣ
	 * @param usernumber �û��˺�
	 * @return �����û��˺Ų��ҵĽ��
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		return this.moduleuserdao.findMhqxTabModuleuserByUserNumber(usernumber);
	}
	/**
	 * ����û�ģ���Ӧ��ϵ
	 * @param moduleuser �û�ģ�����
	 */
	public void save(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.saveMhqxTabModuleuser(moduleuser);
	}
	/**
	 * �����û�ģ����Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void update(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.moduleuserdao.updateMhqxTabModuleuser(moduleuser);
	}
	/**
	 * ����û��Ƿ���ڸ���ϵͳ
	 * @param moduleuser �û�ģ�����
	 */
	public boolean CheckModuleUser(MhqxTabModuleuser moduleuser)
	{
		return this.moduleuserdao.CheckModuleUser(moduleuser);
	}
}
