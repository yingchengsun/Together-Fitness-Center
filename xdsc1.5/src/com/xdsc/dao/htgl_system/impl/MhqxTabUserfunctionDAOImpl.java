package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabUserfunctionDAO;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * 角色功能表操作DAO实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserfunctionDAOImpl extends HibernateDaoSupport implements MhqxTabUserfunctionDAO {
	/**
	 * 返回所有的用户功能
	 * @return 用户功能列表
	 */
	public List<MhqxTabUserfunction> findAllMhqxTabUserfunction() {
		// TODO Auto-generated method stub
		List<MhqxTabUserfunction> list = this.getHibernateTemplate().loadAll(MhqxTabUserfunction.class);
		System.out.println("in the userfunctionDAOImpl----sdfsdfdsfsdfsdf------");
		return list;
	}
	/**
	 * 按照用户账号查找
	 * @param usernumber 用户账号
	 * @return 用户账号列表
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(
			String usernumber) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabUser.FUserNumber='"+usernumber+"'";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按ID查找角色功能条目
	 * @param id 角色功能ID
	 * @return 用户功能对象
	 */
	public MhqxTabUserfunction findMhqxTabUserfunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabUserfunction)this.getHibernateTemplate().get(MhqxTabUserfunction.class, id);
	}
	/**
	 * 删除角色功能
	 * @param userfunction 用户功能对象
	 */
	public void removeMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(userfunction);
	}
	/**
	 * 添加角色功能
	 * @param userfunction 用户功能对象
	 */
	public void saveMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userfunction);
	}
	/**
	 * 更新用户功能
	 * @param userfunction 用户功能对象
	 */
	public void updateMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(userfunction);
	}
	/**
	 * 按照父功ID能查找用户功能
	 * @param id 父功能ID
	 * @return 用户功能List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(int id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabFunction.FSuperFunctionId="+id;
	    return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 检查用户是否有该功能
	 * @return 有则返回true,无则返回false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction)
	{
		String usernumber =  userfunction.getMhqxTabUser().getFUserNumber();
		int functionid = userfunction.getMhqxTabFunction().getFFunctionId();
		String hql = "from MhqxTabUserfunction uf where uf.mhqxTabUser.FUserNumber='"+usernumber
		           +"' and uf.mhqxTabFunction.FFunctionId="+functionid;
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
