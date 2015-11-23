package com.xdsc.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabUserfunction;

public class ServletDao {

	public static List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		String hql = "from MhqxTabModuleuser moduleuser where moduleuser.mhqxTabUser.FUserNumber='"+usernumber+"'";
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		Query queryList=session.createQuery(hql);
		List<MhqxTabModuleuser> list=(List<MhqxTabModuleuser>)queryList.list();
		System.out.println("====================="+list.size());
		session.flush();
		session.getTransaction().commit();
		return list;
	}
//	//根据用户ID查找用户的functionList
//	public static List<MhqxTabFunction> findFunctionListByUserNum(String userNumber){
//		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabUser.FUserNumber='"+userNumber+"'";
//		Session session = HibernateSessionFactory.getSession();
//		session.getTransaction().begin();
//		Query queryList=session.createQuery(hql);
//		List<MhqxTabUserfunction> Userfunctionlist=(List<MhqxTabUserfunction>)queryList.list();
//		List<MhqxTabFunction> FunctionList=new ArrayList<MhqxTabFunction>();
//		for(int i=0;i<Userfunctionlist.size();i++){
//			FunctionList.add(Userfunctionlist.get(i).getMhqxTabFunction());
//		}
//		return FunctionList;
//	}
	//查找特定module下的MhqxTabFunction
	public static List<MhqxTabFunction> findfunctionListByModuleAndSuperId(int superId,int moduleId,String userNumber){
		String hql = "from MhqxTabUserfunction userfunction where userfunction.mhqxTabUser.FUserNumber='"+userNumber+"' "+
					 "and userfunction.mhqxTabFunction.FSuperFunctionId='"+superId+"' "+
					 "and userfunction.mhqxTabFunction.mhqxTabModule.FModuleId='"+moduleId+"'";
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		Query queryList=session.createQuery(hql);
		List<MhqxTabUserfunction> Userfunctionlist=(List<MhqxTabUserfunction>)queryList.list();
		session.flush();
		session.getTransaction().commit();
		System.out.println("---------------------------"+Userfunctionlist.size()+"--------------------");
		List<MhqxTabFunction> FunctionList=new ArrayList<MhqxTabFunction>();
		for(int i=0;i<Userfunctionlist.size();i++){
			FunctionList.add(Userfunctionlist.get(i).getMhqxTabFunction());
		}
		return FunctionList;	
	}
}
