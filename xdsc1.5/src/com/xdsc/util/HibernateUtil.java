package com.xdsc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <p>创建SessionFactory提取为公共类，供Service层调用<br>
 * @author qianxun
 * @version 1.1
 */
public class HibernateUtil {
	/**SessionFactory对象*/
	private static SessionFactory sf;
	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	/**
	 * <p>功能：获取SessionFactory<br>
	 * @return sf SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
