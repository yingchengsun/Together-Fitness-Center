package com.xdsc.dao.htgl_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.xdsc.dao.htgl_system.MhqxTabRoleUserDAO;
import com.xdsc.model.MhqxTabRoleuser;
/**
 * 用户角色表操作DAO实现
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleUserDAOImpl extends HibernateDaoSupport implements MhqxTabRoleUserDAO {
	/**
	 * 查找所有用户角色
	 * @return 用户角色对应列表
	 */
	public List<MhqxTabRoleuser> findAllMhqxTabRoleUser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabRoleuser roleuser order by roleuser.FId desc";
		return (List<MhqxTabRoleuser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 按照ID查找角色用户
	 * @param id 角色用户ID
	 * @return 角色用户对象
	 */
	public MhqxTabRoleuser findMhqxTabRoleUserById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabRoleuser)this.getHibernateTemplate().get(MhqxTabRoleuser.class, id);
	}
	/**
	 * 按照用户账号查找角色用户
	 * @param usernumber 用户账号
	 * @return 角色用户对象
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByUserNumber(
			String usernumber) {
		// TODO Auto-generated method stub
		String hql="from MhqxTabRoleuser roleuser where roleuser.mhqxTabUser.FUserNumber='"+usernumber+"'";
		return (List<MhqxTabRoleuser>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * 删除用户角色
	 * @param roleuser 用户角色对象
	 */
	public void removeMhqxTabRoleUser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(roleuser);
	}
	/**
	 * 添加用户角色对象
	 * @param roleuser 用户角色对象
	 */
	public void saveMhqxTabRoleUser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(roleuser);

	}
	/**
	 * 更新用户角色对象
	 * @param roleuser 用户角色对象 
	 */
	public void updateMhqxTabRoleuser(MhqxTabRoleuser roleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(roleuser);
	}
	/**
	 * 按角色ID查找用户角色
	 * @param roleid 角色ID
	 * @return 用户角色列表
	 */
	public List<MhqxTabRoleuser> findMhqxTabRoleUserByRoleId(int roleid)
	{
		String hql = "from MhqxTabRoleuser roleuser where roleuser.mhqxTabRole.FRoleId="+roleid;
		return this.getHibernateTemplate().find(hql);
	}
}
