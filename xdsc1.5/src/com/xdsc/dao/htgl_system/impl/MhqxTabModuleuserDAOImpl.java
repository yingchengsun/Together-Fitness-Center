package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleuserDAO;
import com.xdsc.model.MhqxTabModuleuser;
/**
 * <p>操作用户模块表的DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleuserDAOImpl extends HibernateDaoSupport implements
		MhqxTabModuleuserDAO {
	/**
	 * 查找所有用户模块条目
	 * @return 用户模块条目列表
	 */
	public List<MhqxTabModuleuser> findAllMhqxTabModuleuser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModuleuser moduleuser";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按ID查找用户模块对应关系
	 * @param id 要查询的ID
	 * @return 返回查询结果用户模块对象
	 */
	public MhqxTabModuleuser findMhqxTabModuleuserById(Integer id) {
		// TODO Auto-generated method stub	
		return (MhqxTabModuleuser)this.getHibernateTemplate().get(MhqxTabModuleuser.class, id);
	}
	/**
	 * 按照用户账号查找用户模块信息
	 * @param usernumber 用户账号
	 * @return 按照用户账号查找的结果
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModuleuser moduleuser where moduleuser.mhqxTabUser.FUserNumber='"+usernumber+"'";
		
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除用户模块对应条目
	 * @param moduleuser 用户模块对象
	 */
	public void removeMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(moduleuser);
	}
	/**
	 * 添加用户模块对应关系
	 * @param moduleuser 用户模块对象
	 */
	public void saveMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(moduleuser);
	}
	/**
	 * 更新用户模块条目
	 * @param moduleuser 用户模块对象
	 */
	public void updateMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(moduleuser);

	}
	/**
	 * 检查用户是否存在该子系统
	 * @param moduleuser 用户模块对象
	 */
	public boolean CheckModuleUser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		String FUserNumber=moduleuser.getMhqxTabUser().getFUserNumber();
		int FModuleId = moduleuser.getMhqxTabModule().getFModuleId();
		String hql = "from MhqxTabModuleuser mu where mu.mhqxTabUser.FUserNumber='" +FUserNumber+
				"' and mu.mhqxTabModule.FModuleId="+FModuleId;
		if(this.getHibernateTemplate().find(hql).size()==0)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

}
