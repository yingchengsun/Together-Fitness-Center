package com.xdsc.dao.htgl_system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.MhqxTabFunctionDAO;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * <p>操作功能表的DAO实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabFunctionDAOImpl extends HibernateDaoSupport implements MhqxTabFunctionDAO {
	/**
	 * <p>查找所有功能<br>
	 * @return 返回功能列表
	 */
	public List<MhqxTabFunction> findAllMhqxTabfunction() {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function";
		
		return (List<MhqxTabFunction>)this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>按照ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public MhqxTabFunction findMhqxTabfunctionById(Integer id) {
		// TODO Auto-generated method stub
		return (MhqxTabFunction)this.getHibernateTemplate().get(MhqxTabFunction.class, id);
	}
	/**
	 * <p>按照功能名称查找<br>
	 * @param name 功能名称
	 * @return 返回查找到的功能
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionName=?";
		return (List<MhqxTabFunction>)this.getHibernateTemplate().find(hql,name);
	}
	/**
	 * <p>删除功能<br>
	 * @param 要删除的功能对象
	 */
	public void removeMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		//System.out.println("functionDAO shanchu"+function.getFFunctionName());
		this.getHibernateTemplate().delete(function);
	}
	/**
	 * <p>添加功能对象<br>
	 * @param function 要添加的功能对象
	 */
	public void saveMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(function);
	}
	/**
	 * <p>更新功能<br>
	 * @param function
	 */
	public void updateMhqxTabfunction(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(function);
	}
	/**
	 * <p>按照模块和角色查找功能<br>
	 * @param moduleid 模块ID
	 * @param rolename 角色ID
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByModuleidandRoleid(
			int moduleid, String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.mhqxTabModule.FModuleId="+moduleid+" and function.FFunctionMark='"+rolename+"'";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>按照父ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionBySuperId(int id) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FSuperFunctionId="+id;
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * <p>按照模块和父ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
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
	 * 按角色名查找功能
	 * @param rolename 角色名
	 * @return 角色 rolename 所拥有的功能
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByRoleName(String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionMark='"+rolename+"'";
		return this.getHibernateTemplate().find(hql);
	}

	
	/**
	 * <p>按照名称和角色查找功能<br>
	 * @param Name 功能名称
	 * @param rolename 角色ID
	 * @return 返回查找结果
	 */
	public MhqxTabFunction findMhqxTabfunctionByNameandRoleid(
			String name, String rolename) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabFunction function where function.FFunctionName='"+name+"' and function.FFunctionMark='"+rolename+"'";
		System.out.println(hql);
		return (MhqxTabFunction)this.getHibernateTemplate().find(hql).get(0);
	}
	
	
	
	
	
}
