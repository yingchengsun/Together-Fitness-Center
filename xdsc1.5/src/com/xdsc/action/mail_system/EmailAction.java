package com.xdsc.action.mail_system;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.search.AndTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ContactDaoInterface;
import com.xdsc.dao.mail_system.EmailDaoInterface;
import com.xdsc.dao.mail_system.MailManagerDaoInterface;
import com.xdsc.model.Mail;
import com.xdsc.model.Mailmanager;
import com.xdsc.model.TabStudents;
import com.xdsc.service.mail_system.DisplayContent;
import com.xdsc.service.mail_system.POP3Help;
import com.xdsc.util.mail_system.DateConvert;
import com.xdsc.util.mail_system.FileUpLoad;

/** ���ʼ��йص�action 
 * �������� ���� ���� ����ʼ���action
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class EmailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ʼ�����
	 */
	Mail mail;

	 
	/**
	 * �����ļ��ϴ����������
	 */
	private List<File> uploads;
	private List<String> fileNames;
	private List<String> uploadContentTypes;

	
	/**
	 * �����ʼ��������������
	 */
	private String search_from;
	private String search_date;
	
	
	/**
	 * �����ʼ�������������
	 */
	private int move_target;
	private int[] move_object;
	


	/**
	 * �����ʼ��ķ��������
	 */
	EmailDaoInterface emailDao;
	
	
	/**
	 * �ʼ�����ķ��������
	 */
	MailManagerDaoInterface mailmanagerDao;
	
	ContactDaoInterface contactDao;
	
	
	public ContactDaoInterface getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDaoInterface contactDao) {
		this.contactDao = contactDao;
	}

	public MailManagerDaoInterface getMailmanagerDao() {
		return mailmanagerDao;
	}

	public void setMailmanagerDao(MailManagerDaoInterface mailmanagerDao) {
		this.mailmanagerDao = mailmanagerDao;
	}

	

	/**�й��ļ��ϴ���get set ����
	 * @return
	 */
	public List<File> getUploads() {
		return uploads;
	}

	public List<String> getUploadFileName() {
		return fileNames;
	}

	public List<String> getUploadContentTypes() {
		return uploadContentTypes;
	}

	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	public void setUploadsFileName(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	public void setUploadsContentType(List<String> uploadContentTypes) {
		this.uploadContentTypes = uploadContentTypes;
	}

	public EmailDaoInterface getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDaoInterface emailDao) {
		this.emailDao = emailDao;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}
	
	
	/**����ʼ���ʹ�õķ���
	 * @return ��ʾ��ǳɹ��������ռ������ϵͳ�Ż�
	 */
	public String tagMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int[] msgnum_array = move_object;
		int msgnum = 0;
		for(int i=0;i<msgnum_array.length;i++){
			msgnum = msgnum_array[i];
		if(move_target==0){
			//�����0 ���ʼ����Ϊ�Ѷ�
			
			if (!mailmanagerDao.findByMsgnum(msgnum, (String) request.getSession()
					.getAttribute("username"))) {
				Mailmanager mm = new Mailmanager();
				mm.setMmDeleted(0);
				mm.setMmDraft(0);
				mm.setMmMsgnum(msgnum);
				mm.setMmRubbish(0);
				mm.setMmSeen(1);
				mm.setMmUsername((String) request.getSession().getAttribute(
						"username"));
				// System.out.println("In DisplayContent : "+mailmanagerDao);
				mailmanagerDao.addSeen(mm);
			}
			else{
				Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String) request.getSession()
					.getAttribute("username"));
				mm.setMmSeen(1);
				mailmanagerDao.updateDeleted(mm);
				
			}
		}
		else if(move_target==1){
			if (mailmanagerDao.findByMsgnum(msgnum, (String) request.getSession()
					.getAttribute("username"))) {
				Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String) request.getSession()
					.getAttribute("username"));
				
				mm.setMmDraft(0);
				mm.setMmMsgnum(msgnum);
				
				mm.setMmSeen(0);
				mm.setMmUsername((String) request.getSession().getAttribute(
						"username"));
				// System.out.println("In DisplayContent : "+mailmanagerDao);
				mailmanagerDao.updateNew(mm);
			}
		}
		else if(move_target==2){
			if (mailmanagerDao.findByMsgnum(msgnum, (String) request.getSession()
					.getAttribute("username"))) {
				Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String) request.getSession()
					.getAttribute("username"));
				
				mm.setMmDraft(0);
				mm.setMmMsgnum(msgnum);
				mm.setMmRubbish(1);
				
				mm.setMmUsername((String) request.getSession().getAttribute(
						"username"));
				// System.out.println("In DisplayContent : "+mailmanagerDao);
				mailmanagerDao.updateRubbish(mm);
			}
			else{
				Mailmanager mm = new Mailmanager();
				mm.setMmDeleted(0);
				mm.setMmDraft(0);
				mm.setMmMsgnum(msgnum);
				mm.setMmRubbish(1);
				mm.setMmSeen(1);
				mm.setMmUsername((String) request.getSession().getAttribute(
						"username"));
				// System.out.println("In DisplayContent : "+mailmanagerDao);
				mailmanagerDao.addSeen(mm);
			}
		}
		
		}
		return SUCCESS;
	}

	
	/**ͳ�����е�δ���ʼ��������ķ���
	 * @return ���ص��ռ����л�ϵͳ�Ż���ʾδ���ʼ�������
	 */
	public String countNew() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Folder folder = (Folder) request.getSession().getAttribute("folder");
		int countOfInbox = 0;
		try {
			countOfInbox = folder.getMessageCount();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int countOfSeen = mailmanagerDao.findCountOfSeen((String) request
				.getSession().getAttribute("username"));
		int countOfNew = countOfInbox - countOfSeen;
		System.out.println("In EmailAction to count the new emails..."
				+ countOfNew);
		request.getSession().setAttribute("countOfNew", countOfNew);
		return SUCCESS;
	}

	
	/**�����ʼ��ķ��� ��Ҫ������ʼ��Ѷ���ʱ����б��
	 * @return �����ݿ����ʼ��Ѷ���־���
	 */
	public String manageMail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		int msgnum = Integer.parseInt(request.getParameter("msgnum"));

		if (!mailmanagerDao.findByMsgnum(msgnum, (String) request.getSession()
				.getAttribute("username"))) {
			Mailmanager mm = new Mailmanager();
			mm.setMmDeleted(0);
			mm.setMmDraft(0);
			mm.setMmMsgnum(msgnum);
			mm.setMmRubbish(0);
			mm.setMmSeen(1);
			mm.setMmUsername((String) request.getSession().getAttribute(
					"username"));
			// System.out.println("In DisplayContent : "+mailmanagerDao);
			mailmanagerDao.addSeen(mm);
			
			
		}
		else{
			Mailmanager mm = mailmanagerDao.findByMsgnumandUsername(msgnum, (String) request.getSession()
				.getAttribute("username"));
			mm.setMmSeen(1);
			mailmanagerDao.updateDeleted(mm);
			
		}
		try {
			new DisplayContent().doGet(request, response, msgnum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/** �ʼ���������ط���
	 * @return ���ط����������ʼ��б�
	 * @throws ParseException
	 */
	public String searchMail() throws ParseException {
		DateConvert dateConvert = new DateConvert();
		HttpServletRequest request = ServletActionContext.getRequest();
		Folder folder = (Folder) request.getSession().getAttribute("folder");

		try {
			SearchTerm st = new AndTerm(new FromStringTerm(search_from),
					new SubjectTerm(search_date));
			Message[] message = folder.search(st);

			System.out.println("�ҵ�" + message.length + "����������������ʼ�");
			request.setAttribute("messages", message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	
	/**  �����ʼ�ʹ�õ�action
	 * @return ���ͳɹ���ʾ
	 * @throws Exception �ļ��ϴ������쳣
	 */
	public String sendEmail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		String password = (String) request.getSession()
				.getAttribute("password");
		String smtpServer = (String) request.getSession().getAttribute(
				"smtpServer");
		String displayName = username;

		// ************
		// �����õ���
		// Iterator it = fileNames.iterator();
		// while(it.hasNext()){
		// String tempFileName =(String) it.next();
		// System.out.println(tempFileName);
		// }
		// ***********
		// ***********
		// System.out.println(uploads.isEmpty());
		// System.out.println(fileNames.isEmpty());
		// System.out.println(uploadContentTypes.isEmpty());

		if (null!=uploads) {
			
			FileUpLoad fileUpLoad = new FileUpLoad();
			mail.setFile(fileUpLoad.fileUpLoad(uploads, fileNames,
					uploadContentTypes));
		}

		mail.setDisplayName(displayName);
		mail.setUsername(username);
		mail.setPassword(password);
		mail.setSmtpServer(smtpServer);
		mail.setFrom(username + "@localhost");
		// mail.setFile(tempFileNameContainer);
		
		
		if(mail.getTo().split("@").length==1){
			System.out.println("%%%%%%%%%%%%%%%%^^^^^^^"+contactDao+mail.getTo());
			List studentsList = contactDao.findByClassNumber(mail.getTo());
			
			String address = "";
			Iterator it = studentsList.iterator();
			while(it.hasNext()){
				TabStudents temp = (TabStudents)it.next();
				address+=(temp.getMhqxTabUser().getFUserNumber()+"@localhost;");
			}
			mail.setTo(address);
		}
		
		HashMap message = emailDao.sendMail(mail);
		String alertMessage = (String) message.get("state");
		request.setAttribute("alertMessage", alertMessage);

		return SUCCESS;
	}

	 
	/** �õ�Folder���󣬴����Session�� ������ʾÿ���ʼ���Ϣ
	 * ���������Ҫ�����������ʼ�
	 * ��ʾ�ʼ����е��ʼ��б�ʱ���Ѿ����˵�����ɾ���������ʼ�
	 * @return �����ռ������ʼ��б�
	 */
	public String showEmail() {

		HttpServletRequest request = ServletActionContext.getRequest();
		// String host =(String) request.getSession().getAttribute("host");
		// String username =
		// (String)request.getSession().getAttribute("username");
		// String password =
		// (String)request.getSession().getAttribute("password");

		Folder folder = (Folder) request.getSession().getAttribute("folder");

		// ��֪��folder�򿪵�ʱ���Ƕ�ã���Ϊ���ʼ����������Ǻ����
		// �Ҳ��볬��ʱ��֮��folder�ͻ��Զ��رհ�,�������folder�Զ�
		// �ر��˾����´򿪣�����Ѿ����˾Ͳ�ִ��
		if (null == folder||!folder.isOpen() ) {
			folder = new POP3Help().getFolder((String) request.getSession()
					.getAttribute("host"), (String) request.getSession()
					.getAttribute("username"), (String) request.getSession()
					.getAttribute("password"));

		}
		// ���Եõ���folder�����Ƿ�Ϊ�գ�����
		try {
			System.out.println(folder.getMessageCount());
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Inbox���Ѿ���ɾ�����ʼ�
		List deletedList = mailmanagerDao.findDeleted((String) request
				.getSession().getAttribute("username"));
		// ��msgnum����list��
		List deletedNumList = new ArrayList(0);
		Iterator it1 = deletedList.iterator();
		while (it1.hasNext()) {

			Mailmanager mm1 = (Mailmanager) it1.next();
			deletedNumList.add(mm1.getMmMsgnum());
		}
		
		//Inbox�е������ʼ�
		
		List rubbishList = mailmanagerDao.findRubbish((String) request
				.getSession().getAttribute("username"));
		List rubbishNumList = new ArrayList(0);
		Iterator it2 = rubbishList.iterator();
		while(it2.hasNext()){
			Mailmanager mm2 =(Mailmanager)it2.next();
			rubbishNumList.add(mm2.getMmMsgnum());
		}
		
		//Inbox���Ѷ��ʼ�
		List<Mailmanager> seenList = mailmanagerDao.findSeen((String) request
				.getSession().getAttribute("username"));
		List seenNumList = new ArrayList(0);
		Iterator it3 = seenList.iterator();
		while(it3.hasNext()){
			Mailmanager mm3 = (Mailmanager)it3.next();
			seenNumList.add(mm3.getMmMsgnum());
		}
		
		System.out.println("In EmailAction to show rubbish mail number "+rubbishNumList.size());
		System.out.println("In EmailAction to show deleted mail number "+deletedNumList.size());


		request.setAttribute("deletedMsgNumList", deletedNumList);
		request.setAttribute("rubbishNumList", rubbishNumList);
		request.setAttribute("seenMsgNumList", seenNumList);
		request.getSession().setAttribute("folder", folder);
		return SUCCESS;
	}

	public String getSearch_from() {
		return search_from;
	}

	public String getSearch_date() {
		return search_date;
	}

	public void setSearch_from(String search_from) {
		this.search_from = search_from;
	}

	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}

	public int getMove_target() {
		return move_target;
	}



	public int[] getMove_object() {
		return move_object;
	}

	public void setMove_object(int[] move_object) {
		this.move_object = move_object;
	}

	public void setMove_target(int move_target) {
		this.move_target = move_target;
	}

	

	// ���ظ�����action

	// //������ʾ�ʼ�ͷ��
	// public String displayHead(){
	// //response.setContentType("text/html;charset=gb2312");
	// //PrintWriter out = response.getWriter();
	// HttpServletRequest request = ServletActionContext.getRequest();
	// HttpSession session = request.getSession();
	// int msgnum = Integer.parseInt(request.getParameter("msgnum"));
	// Folder folder = (Folder)session.getAttribute("folder");
	//		
	// try {
	// Message msg = folder.getMessage(msgnum);
	// String from = msg.getFrom()[0].toString();
	// String subject = msg.getSubject();
	// String sendDate = DateFormat.getInstance().format(msg.getSentDate());
	// // out.println("�ʼ����⣺"+ subject +"</br>");
	// // out.println("�����ˣ�"+from+"<br/>");
	// // out.println("�������ڣ�"+sendDate+"<br/><br/>");
	// request.setAttribute("subject", subject);
	// request.setAttribute("from", from);
	// request.setAttribute("sendDate", sendDate);
	//			
	// if(msg.isMimeType("multipart/*")){
	// request.setAttribute("attach", new String("1"));
	// Multipart mp = (Multipart)msg.getContent();
	// for(int i=0;i<mp.getCount();i++){
	// BodyPart bp = mp.getBodyPart(i);
	// if(bp.getDisposition()!=null){
	// String filename = bp.getFileName();
	// System.out.println(filename);
	// if(filename.startsWith("=?")){
	// filename=MimeUtility.decodeText(filename);
	// }
	// // out.print("������");
	// // out.print("<a
	// href=HandleAttach?msgnum="+msgnum+"&&bodynum="+i+"&&filename"+">"+filename+"</a><br/>");
	// request.setAttribute("msgnum", msgnum);
	// request.setAttribute("bodynum", i);
	// request.setAttribute("filename", filename);
	// }
	// }
	// }
	//			
	// }
	// catch (Exception e) {
	//			
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return SUCCESS;
	// }
	//	
	// //������ʾ�ʼ����ĵ�
	// public String displayContent(){
	// return SUCCESS;
	// }
	//	
	//	
	// // //�����ʼ�������action
	// // public String handleAttach() {
	// // return SUCCESS;
	// // }

}
