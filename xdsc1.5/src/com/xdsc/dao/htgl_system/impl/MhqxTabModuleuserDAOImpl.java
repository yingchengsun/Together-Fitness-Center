package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabModuleuserDAO;
import com.xdsc.model.MhqxTabModuleuser;
/**
 * <p>�����û�ģ����DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleuserDAOImpl extends HibernateDaoSupport implements
		MhqxTabModuleuserDAO {
	/**
	 * ���������û�ģ����Ŀ
	 * @return �û�ģ����Ŀ�б�
	 */
	public List<MhqxTabModuleuser> findAllMhqxTabModuleuser() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModuleuser moduleuser";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ��ID�����û�ģ���Ӧ��ϵ
	 * @param id Ҫ��ѯ��ID
	 * @return ���ز�ѯ����û�ģ�����
	 */
	public MhqxTabModuleuser findMhqxTabModuleuserById(Integer id) {
		// TODO Auto-generated method stub	
		return (MhqxTabModuleuser)this.getHibernateTemplate().get(MhqxTabModuleuser.class, id);
	}
	/**
	 * �����û��˺Ų����û�ģ����Ϣ
	 * @param usernumber �û��˺�
	 * @return �����û��˺Ų��ҵĽ��
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModuleuser moduleuser where moduleuser.mhqxTabUser.FUserNumber='"+usernumber+"'";
		
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ɾ���û�ģ���Ӧ��Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void removeMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(moduleuser);
	}
	/**
	 * ����û�ģ���Ӧ��ϵ
	 * @param moduleuser �û�ģ�����
	 */
	public void saveMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(moduleuser);
	}
	/**
	 * �����û�ģ����Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void updateMhqxTabModuleuser(MhqxTabModuleuser moduleuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(moduleuser);

	}
	/**
	 * ����û��Ƿ���ڸ���ϵͳ
	 * @param moduleuser �û�ģ�����
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
