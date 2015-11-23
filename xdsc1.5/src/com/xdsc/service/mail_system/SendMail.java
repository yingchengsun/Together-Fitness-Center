package com.xdsc.service.mail_system;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.xdsc.dao.mail_system.ContactDao;
import com.xdsc.model.Mail;

/**
 * ���ڷ����ʼ���֧����
 * 
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 * 
 */
public class SendMail {
	// ������еķ������ڷ����ʼ�

	/**
	 * �����ʼ�
	 * 
	 * @param email �ʼ�ʵ��
	 * @return �����ʼ���״̬
	 */
	public HashMap sendMail(Mail email) {

		ArrayList file = (ArrayList) email.getFile();
		String filename = email.getFilename();
		HashMap map = new HashMap();
		map.put("state", "success");
		String message = "�ʼ����ͳɹ�";
		Session session = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", email.getSmtpServer());

		if (email.isIfAuth()) {
			// ��������Ҫ�����֤
			props.put("mail.smtp.auth", "true");
			SmtpAuth smtpAuth = new SmtpAuth(email.getUsername(), email
					.getPassword());
			session = Session.getDefaultInstance(props, smtpAuth);
		} else {
			props.put("mail.smtp.auth", "false");
			session = Session.getDefaultInstance(props, null);
		}
		session.setDebug(true);
		Transport trans = null;

		try {
			Message msg = new MimeMessage(session);
			try {
				Address from_address = new InternetAddress(email.getFrom(),
						email.getDisplayName());
				msg.setFrom(from_address);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//��һ�δ��������������ʼ���ַ��
			
			String[] toaddress ;
			

			System.out
					.println("In sendmail to show to.address" + email.getTo());
//			if(email.getTo().split("@").length==0){
//				ContactDao groupDao = new ContactDao();
//				List studentsList = groupDao.findByClassNumber(email.getTo());
//				toaddress = new String[studentsList.size()];
//				Iterator it = studentsList.iterator();
//				while(it.hasNext()){
//					int j =0;
//					TabStudents temp = (TabStudents)it.next();
//					toaddress[j++] = temp.getFStudentNumber()+"@localhost";
//				}
//			}
//			else{
				toaddress = email.getTo().split(";");
//			}
			
			// InternetAddress[] address ={ new InternetAddress(email.getTo())};
			InternetAddress[] address = new InternetAddress[toaddress.length];
			for (int i = 0; i < toaddress.length; i++) {
				address[i] = new InternetAddress(toaddress[i]);
			}
			

			
				msg.setRecipients(Message.RecipientType.TO, address);
				msg.setSubject(email.getSubject());

				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp = new MimeBodyPart();
				// �趨�ַ�����������ڳ��������������⣬��Ҫ�������������...
				// ���Գ���ʱ��"text/html;charset=utf-8"�м��";"��д����":"�˷��˺ó�ʱ�䣡����
//				mbp.setContent(email.getContent().toString(),
//						"text/html;charset=utf-8");
				mbp.setText(email.getContent().toString());
				mp.addBodyPart(mbp);
				if (!file.isEmpty()) {
					// �и���
					Iterator it = file.iterator();
					while (it.hasNext()) {
						mbp = new MimeBodyPart();
						filename = it.next().toString();
						FileDataSource fds = new FileDataSource(filename);
						mbp.setDataHandler(new DataHandler(fds));
						mbp.setFileName(fds.getName());
						mp.addBodyPart(mbp);
					}
					// for test
					System.out.println("handle the attachment...");
					file.clear();
				}
				msg.setContent(mp);// Multipart���뵽�ż�
				msg.setSentDate(new Date());// �����ż�ͷ�ķ�������
				// �����ż�
				msg.saveChanges();

				// **************
				// �����õ����...
				System.out.println(javax.mail.internet.MimeMessage.class
						.getResource(""));
				System.out.println(email.getUsername());
				System.out.println(email.getPassword());
				System.out.println(email.getContent());
				System.out.println(email.getFrom());
				System.out.println(email.getSmtpServer());
				System.out.println(email.getTo());
				System.out.println(email.getSubject());
				// *************
				trans = session.getTransport("smtp");

				trans.connect(email.getSmtpServer(), email.getUsername(), email
						.getPassword());
				trans.sendMessage(msg, msg.getAllRecipients());
			
			
			trans.close();

		} catch (AuthenticationFailedException e) {
			map.put("state", "failed");
			message = "�ʼ�����ʧ�ܣ�ԭ�������֤����";
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block

			message = "�ʼ�����ʧ�ܣ�����ԭ��\n" + e.getMessage();
			map.put("state", "failed");
			e.printStackTrace();
			Exception ex = null;
			if ((ex = e.getNextException()) != null) {
				System.out.println(ex.toString());
				ex.printStackTrace();
			}
		}
		map.put("message", message);
		return map;
	}

	// �����Ƿ��ܹ����͵�������
	// public static void main(String[] args){
	// Mail mail = new Mail();
	// mail.setContent("test if the sending mail function is ready or not...");
	// mail.setDisplayName("֣��˫");
	// mail.setFrom("z0c0s0@sina.com");
	// mail.setIfAuth(true);
	// mail.setPassword("shuang0000");
	// mail.setSmtpServer("smtp.sina.com");
	// mail.setSubject("I love U");
	// mail.setTo("sunjianbo0229@sina.com");
	// mail.setUsername("z0c0s0");
	// ArrayList fileNameList = new ArrayList();
	// fileNameList.add(new String("F:\\c.doc"));
	// mail.setFile(fileNameList);
	// new SendMail().sendMail(mail);
	// System.out.println("*************");
	// }

}
