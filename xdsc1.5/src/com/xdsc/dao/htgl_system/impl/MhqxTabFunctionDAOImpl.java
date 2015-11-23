package com.xdsc.dao.htgl_system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabFunctionDAO;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * <p>�������ܱ��DAOʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabFunctionDAOImpl extends HibernateDaoSupport implements MhqxTabFunctionDAO {
	/**
	 * <p>�������й���<br>
	 * @return ���ع����б�
	 */
	public List<MhqxTabFunction> findAllMhqxTabfunction() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function";
		
		return (List<MhqxTabFunction>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>����ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findMhqxTabfunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabFunction)this.getHibernateTemplate().get(MhqxTabFunction.class, id);
	}
	/**
	 * <p>���չ������Ʋ���<br>
	 * @param name ��������
	 * @return ���ز��ҵ��Ĺ���
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionName=?";
		return (List<MhqxTabFunction>)this.getHibernateTemplate().find(hql,name);
	}
	/**
	 * <p>ɾ������<br>
	 * @param Ҫɾ���Ĺ��ܶ���
	 */
	public void removeMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		//System.out.println("functionDAO shanchu"+function.getFFunctionName());
		this.getHibernateTemplate().delete(function);
	}
	/**
	 * <p>��ӹ��ܶ���<br>
	 * @param function Ҫ��ӵĹ��ܶ���
	 */
	public void saveMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(function);
	}
	/**
	 * <p>���¹���<br>
	 * @param function
	 */
	public void updateMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(function);
	}
	/**
	 * <p>����ģ��ͽ�ɫ���ҹ���<br>
	 * @param moduleid ģ��ID
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByModuleidandRoleid(
			int moduleid, String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.mhqxTabModule.FModuleId="+moduleid+" and function.FFunctionMark='"+rolename+"'";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>���ո�ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionBySuperId(int id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FSuperFunctionId="+id;
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>����ģ��͸�ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findfunctionListByModuleAndSuperId(int superId,int moduleId,String userNumber){
		MhqxTabUserfunctionDAOImpl dao=new MhqxTabUserfunctionDAOImpl();
		List<MhqxTabUserfunction> Userfunctionlist= dao.findMhqxTabUserfunctionByUserNumber(userNumber);
		List<MhqxTabFunction> FunctionList1=new ArrayList<MhqxTabFunction>();
		for(int i=0;i<Userfunctionlist.size();i++){
			FunctionList1.add(Userfunctionlist.get(i).getMhqxTabFunction());
		}
		List<MhqxTabFunction> FunctionList2=new ArrayList<MhqxTabFunction>();
		for(int i=0;i<FunctionList1.size();i++){
			if(FunctionList1.get(i).getMhqxTabModule().getFModuleId()==moduleId){
				FunctionList2.add(FunctionList1.get(i));
			}
		}
		List<MhqxTabFunction> FunctionList3=new ArrayList<MhqxTabFunction>();
		for(int i=0;i<FunctionList2.size();i++){
			if(FunctionList2.get(i).getFSuperFunctionId()==superId){
				FunctionList3.add(FunctionList2.get(i));
			}
		}
		
		return FunctionList3;	
	}
	/**
	 * ����ɫ�����ҹ���
	 * @param rolename ��ɫ��
	 * @return ��ɫ rolename ��ӵ�еĹ���
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByRoleName(String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionMark='"+rolename+"'";
		return this.getHibernateTemplate().find(hql);
	}

	
	/**
	 * <p>�������ƺͽ�ɫ���ҹ���<br>
	 * @param Name ��������
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findMhqxTabfunctionByNameandRoleid(
			String name, String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionName='"+name+"' and function.FFunctionMark='"+rolename+"'";
		System.out.println(hql);
		return (MhqxTabFunction)this.getHibernateTemplate().find(hql).get(0);
	}
	
	
	
	
	
}
