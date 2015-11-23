package com.xdsc.service.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleDAO;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
/**
 * <p>����ģ����Serviceʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleManagerImpl implements MhqxTabModuleManager{
	private MhqxTabModuleDAO moduledao;
	
	public MhqxTabModuleDAO getModuledao() {
		return moduledao;
	}

	public void setModuledao(MhqxTabModuleDAO moduledao) {
		this.moduledao = moduledao;
	}
	/**
	 * ɾ��ģ��
	 * @param module ģ�����
	 */
	public void delete(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.removeMhqxTabModule(module);
	}
	/**
	 * ��������ģ��
	 * @return ���ز�ѯ���
	 */
	public List<MhqxTabModule> findAll() {
		// TODO Auto-generated method stub
		return this.moduledao.findAllMhqxTabModule();
	}
	/**
	 * ����ID����ģ��
	 * @param id
	 * @return ���ҽ��
	 */
	public MhqxTabModule findById(Integer id) {
		// TODO Auto-generated method stub
		return this.moduledao.findMhqxTabModuleById(id);
	}
	/**
	 * ����ģ�����Ʋ���
	 * @param name ģ������
	 * @return ���ҽ��
	 */
	public List<MhqxTabModule> findByName(String name) {
		// TODO Auto-generated method stub
		return this.moduledao.findMhqxTabModuleByName(name);
	}
	/**
	 * ���ģ��
	 * @param module ģ�����
	 */
	public void save(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.saveMhqxTabModule(module);
	}
	/**
	 * ����ģ��
	 * @param module
	 */
	public void update(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.moduledao.updateMhqxTabModule(module);
	}

}
