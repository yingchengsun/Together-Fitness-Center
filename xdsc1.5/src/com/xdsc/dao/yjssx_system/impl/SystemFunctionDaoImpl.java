package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.SystemFunctionDao;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.YjssxTabReturnthesis;

/**
 * 接口功能：系统功能配置
 * @author 许鑫
 * @version 1.1
 */
public class SystemFunctionDaoImpl extends HibernateDaoSupport implements SystemFunctionDao {

	/**
	 * 给用户提交某项功能
	 * @param userFunction
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#addFunctionToUser(com.xdsc.model.MhqxTabUserfunction)
	 */
	public void addFunctionToUser(MhqxTabUserfunction userFunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userFunction);
	}

	/**
	 * 删除用户的某个功能
	 * @param userFunction
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#deleteUserFunction(com.xdsc.model.MhqxTabUserfunction)
	 */
	public void deleteUserFunction(MhqxTabUserfunction userFunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(userFunction);
	}

	/**
	 * 根据用户Id查找用户所具有的功能
	 * @param num
	 * @return 返回该用户所具有的功能
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#findUserFunctionByUserNum(java.lang.String)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNum(String num) {
		// TODO Auto-generated method stub
		String hql="from MhqxTabUserfunction uf where uf.mhqxTabUser.FUserNumber='"+num+"'";
		List<MhqxTabUserfunction> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据功能ID查找功能信息
	 * @param id
	 * @return 功能详情
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#findFunctionById(int)
	 */
	public MhqxTabFunction findFunctionById(int id) {
		// TODO Auto-generated method stub
		MhqxTabFunction fct=(MhqxTabFunction)this.getHibernateTemplate().get(MhqxTabFunction.class, id);
		return fct;
	}

	/**
	 * 根据功能Id查找功能人员列表
	 * @param id
	 * @return 用户功能列表
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#findUserFunctionByFunctionId(int)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByFunctionId(int id) {
		// TODO Auto-generated method stub
		String hql="from MhqxTabUserfunction uf where uf.mhqxTabFunction.FFunctionId='"+id+"'";
		List<MhqxTabUserfunction> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据用户ID和功能ID查找用户功能列表
	 * @param num
	 * @param id
	 * @return 返回用户功能列表
	 * @see com.xdsc.dao.yjssx_system.SystemFunctionDao#findUserFunctionByUserNumAndFunctionId(java.lang.String, int)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNumAndFunctionId(
			String num, int id) {
		// TODO Auto-generated method stub
		String hql="from MhqxTabUserfunction uf where uf.mhqxTabFunction.FFunctionId='"+id+"' and uf.mhqxTabUser.FUserNumber='"+num+"'";
		List<MhqxTabUserfunction> list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
