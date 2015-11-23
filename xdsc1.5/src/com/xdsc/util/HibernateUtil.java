package com.xdsc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <p>����SessionFactory��ȡΪ�����࣬��Service�����<br>
 * @author qianxun
 * @version 1.1
 */
public class HibernateUtil {
	/**SessionFactory����*/
	private static SessionFactory sf;
	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	/**
	 * <p>���ܣ���ȡSessionFactory<br>
	 * @return sf SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
