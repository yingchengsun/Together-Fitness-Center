package com.xdsc.service.mail_system;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;


/** ��װ����POP3�������������Ӳ��ҵõ�
 * ���������ռ����������ʼ��ķ���
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class POP3Help {
	
	//
	
	/**�����еķ��������õ�pop3�������������ʼ�
	 * @param host ������
	 * @param username �û���
	 * @param password ����
	 * @return �ʼ���
	 */
	public static Folder getFolder(String host, String username,String password){
		
		Properties prop = new Properties();
		prop.setProperty("mail.store.protocol", "pop3");
		prop.setProperty("mail.pop3.host", host);//host�ڿ��������� sohu��pop3������
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
