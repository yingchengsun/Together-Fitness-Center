package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleDAO;
import com.xdsc.model.MhqxTabModule;
/**
 * <p>����ģ����DAOʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleDAOImpl extends HibernateDaoSupport implements
		MhqxTabModuleDAO {
	/**
	 * ��������ģ��
	 * @return ���ز�ѯ���
	 */
	public List<MhqxTabModule> findAllMhqxTabModule() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModule module";
		return (List<MhqxTabModule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����ID����ģ��
	 * @param id
	 * @return ���ҽ��
	 */
	public MhqxTabModule findMhqxTabModuleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabModule)this.getHibernateTemplate().get(MhqxTabModule.class, id);
	}
	/**
	 * ����ģ�����Ʋ���
	 * @param name ģ������
	 * @return ���ҽ��
	 */
	public List<MhqxTabModule> findMhqxTabModuleByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModule module where module.FModuleName='"+name+"'";
		
		return (List<MhqxTabModule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ��ģ��
	 * @param module ģ�����
	 */
	public void removeMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(module);
	}
	/**
	 * ���ģ��
	 * @param module ģ�����
	 */
	public void saveMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(module);
	}
	/**
	 * ����ģ��
	 * @param module
	 */
	public void updateMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(module);
	}

}
