package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xdsc.dao.htgl_system.impl.MhqxTabUserfunctionDAOImpl;
import com.xdsc.util.HibernateUtil;

public class Test {
	public static void main(String args[])
	{
//		ClassPathResource res = new ClassPathResource("./beans.xml");
//		XmlBeanFactory factory = new XmlBeanFactory(res);
//		MhqxTabRole role = new MhqxTabRole();
//		role.setFRoleName("nicholas");
//		MhqxTabRoleManager roledao = (MhqxTabRoleManager)factory.getBean("RoleManager");
//		roledao.save(role);
		
//		MhqxTabUser user=new MhqxTabUser();
//		MhqxTabRole role = new MhqxTabRole();
//		MhqxTabRoleuser roleuser = new MhqxTabRoleuser();
//		role.setFRoleName("Ñ§Éú");
//		user.setFUserNumber("130611");
//		user.setFUserPassword("130611");
//		roleuser.setMhqxTabRole(role);
//		roleuser.setMhqxTabUser(user);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr=session.beginTransaction();
//		session.save(user);
//		session.save(role);
//		session.save(roleuser);
		
//		MhqxTabUserfunctionDAOImpl userfunctionmanager = new MhqxTabUserfunctionDAOImpl();
//		Iterator<MhqxTabUserfunction> iterator = userfunctionmanager.findById(1);
//		System.out.println(iterator.next().getFId());
//		System.out.println(userfunctionmanager.findMhqxTabUserfunctionById(2).getFId());
//		MhqxTabRoleModule = 
		
		tr.commit();
//		MhqxTabUserManager userdao = (MhqxTabUserManager)factory.getBean("UserManager");
//		
//	    userdao.save(user);
	    
	    
	}
}
