package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabUserfunctionDAO;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * ��ɫ���ܱ����DAOʵ��
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserfunctionDAOImpl extends HibernateDaoSupport implements MhqxTabUserfunctionDAO {
	/**
	 * �������е��û�����
	 * @return �û������б�
	 */
	public List<MhqxTabUserfunction> findAllMhqxTabUserfunction() {
		// TODO Auto-generated method stub
		List<MhqxTabUserfunction> list = this.getHibernateTemplate().loadAll(MhqxTabUserfunction.class);
		System.out.println("in the userfunctionDAOImpl----sdfsdfdsfsdfsdf------");
		return list;
	}
	/**
	 * �����û��˺Ų���
	 * @param usernumber �û��˺�
	 * @return �û��˺��б�
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(
			String usernumber) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabUser.FUserNumber='"+usernumber+"'";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id ��ɫ����ID
	 * @return �û����ܶ���
	 */
	public MhqxTabUserfunction findMhqxTabUserfunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabUserfunction)this.getHibernateTemplate().get(MhqxTabUserfunction.class, id);
	}
	/**
	 * ɾ����ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void removeMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(userfunction);
	}
	/**
	 * ��ӽ�ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void saveMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userfunction);
	}
	/**
	 * �����û�����
	 * @param userfunction �û����ܶ���
	 */
	public void updateMhqxTabUserfunction(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(userfunction);
	}
	/**
	 * ���ո���ID�ܲ����û�����
	 * @param id ������ID
	 * @return �û�����List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(int id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabFunction.FSuperFunctionId="+id;
	    return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����û��Ƿ��иù���
	 * @return ���򷵻�true,���򷵻�false.
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
