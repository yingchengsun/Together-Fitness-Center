package com.xdsc.service.mail_system;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;


/** 封装了与POP3服务器建立连接并且得到
 * 服务器上收件箱里所有邮件的方法
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class POP3Help {
	
	//
	
	/**此类中的方法用来得到pop3服务器上所有邮件
	 * @param host 主机名
	 * @param username 用户名
	 * @param password 密码
	 * @return 邮件夹
	 */
	public static Folder getFolder(String host, String username,String password){
		
		Properties prop = new Properties();
		prop.setProperty("mail.store.protocol", "pop3");
		prop.setProperty("mail.pop3.host", host);//host在开发初期用 sohu的pop3服务器
		//Session mailSession = Session.getDefaultInstance(props, authenticator)
		Session mailSession = Session.getDefaultInstance(prop, null);
		mailSession.setDebug(false);
		try {
			Store store = mailSession.getStore("pop3");
			
			//for testing
			System.out.println(username);
			System.out.println(password);
			System.out.println(host);
			
			store.connect(host, username, password);
			Folder folder = store.getFolder("INBOX");
			
			folder.open(Folder.READ_WRITE);
			
			System.out.println(folder.getMessageCount());
			System.out.println("execute here **** get mails from inbox");
			return folder;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
