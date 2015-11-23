package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleDAO;
import com.xdsc.model.MhqxTabModule;
/**
 * <p>操作模块表的DAO实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleDAOImpl extends HibernateDaoSupport implements
		MhqxTabModuleDAO {
	/**
	 * 查找所有模块
	 * @return 返回查询结果
	 */
	public List<MhqxTabModule> findAllMhqxTabModule() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModule module";
		return (List<MhqxTabModule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按照ID查找模块
	 * @param id
	 * @return 查找结果
	 */
	public MhqxTabModule findMhqxTabModuleById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabModule)this.getHibernateTemplate().get(MhqxTabModule.class, id);
	}
	/**
	 * 按照模块名称查找
	 * @param name 模块名称
	 * @return 查找结果
	 */
	public List<MhqxTabModule> findMhqxTabModuleByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModule module where module.FModuleName='"+name+"'";
		
		return (List<MhqxTabModule>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除模块
	 * @param module 模块对象
	 */
	public void removeMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(module);
	}
	/**
	 * 添加模块
	 * @param module 模块对象
	 */
	public void saveMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(module);
	}
	/**
	 * 更新模块
	 * @param module
	 */
	public void updateMhqxTabModule(MhqxTabModule module) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(module);
	}

}
