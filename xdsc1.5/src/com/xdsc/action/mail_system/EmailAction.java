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

/** 和邮件有关的action 
 * 包括发送 接收 管理 标记邮件的action
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class EmailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 邮件对象
	 */
	Mail mail;

	 
	/**
	 * 用于文件上传的相关属性
	 */
	private List<File> uploads;
	private List<String> fileNames;
	private List<String> uploadContentTypes;

	
	/**
	 * 用于邮件搜索的相关属性
	 */
	private String search_from;
	private String search_date;
	
	
	/**
	 * 用于邮件管理的相关属性
	 */
	private int move_target;
	private int[] move_object;
	


	/**
	 * 操作邮件的方法类对象
	 */
	EmailDaoInterface emailDao;
	
	
	/**
	 * 邮件管理的方法类对象
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

	

	/**有关文件上传的get set 方法
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
	
	
	/**标记邮件所使用的方法
	 * @return 显示标记成功，返回收件箱或者系统门户
	 */
	public String tagMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int[] msgnum_array = move_object;
		int msgnum = 0;
		for(int i=0;i<msgnum_array.length;i++){
			msgnum = msgnum_array[i];
		if(move_target==0){
			//如果是0 将邮件标记为已读
			
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

	
	/**统计所有的未读邮件的数量的方法
	 * @return 返回到收件箱中或系统门户显示未读邮件的数量
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

	
	/**管理邮件的方法 主要是针对邮件已读的时候进行标记
	 * @return 对数据库中邮件已读标志标记
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

	
	/** 邮件搜索的相关方法
	 * @return 返回符合条件的邮件列表
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

			System.out.println("找到" + message.length + "封符合搜索条件的邮件");
			request.setAttribute("messages", message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	
	/**  发送邮件使用的action
	 * @return 发送成功提示
	 * @throws Exception 文件上传出现异常
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
		// 测试用的呗
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

	 
	/** 得到Folder对象，存放在Session中 用于显示每个邮件信息
	 * 这个方法主要是用来接收邮件
	 * 显示邮件箱中的邮件列表时，已经过滤掉了已删除和垃圾邮件
	 * @return 返回收件箱中邮件列表
	 */
	public String showEmail() {

		HttpServletRequest request = ServletActionContext.getRequest();
		// String host =(String) request.getSession().getAttribute("host");
		// String username =
		// (String)request.getSession().getAttribute("username");
		// String password =
		// (String)request.getSession().getAttribute("password");

		Folder folder = (Folder) request.getSession().getAttribute("folder");

		// 不知道folder打开的时间是多久，因为对邮件服务器不是很清楚
		// 我猜想超过时间之后，folder就会自动关闭吧,所以如果folder自动
		// 关闭了就重新打开，如果已经打开了就不执行
		if (null == folder||!folder.isOpen() ) {
			folder = new POP3Help().getFolder((String) request.getSession()
					.getAttribute("host"), (String) request.getSession()
					.getAttribute("username"), (String) request.getSession()
					.getAttribute("password"));

		}
		// 测试得到的folder对象是否为空！！！
		try {
			System.out.println(folder.getMessageCount());
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Inbox中已经被删除的邮件
		List deletedList = mailmanagerDao.findDeleted((String) request
				.getSession().getAttribute("username"));
		// 将msgnum放入list中
		List deletedNumList = new ArrayList(0);
		Iterator it1 = deletedList.iterator();
		while (it1.hasNext()) {

			Mailmanager mm1 = (Mailmanager) it1.next();
			deletedNumList.add(mm1.getMmMsgnum());
		}
		
		//Inbox中的垃圾邮件
		
		List rubbishList = mailmanagerDao.findRubbish((String) request
				.getSession().getAttribute("username"));
		List rubbishNumList = new ArrayList(0);
		Iterator it2 = rubbishList.iterator();
		while(it2.hasNext()){
			Mailmanager mm2 =(Mailmanager)it2.next();
			rubbishNumList.add(mm2.getMmMsgnum());
		}
		
		//Inbox的已读邮件
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

	

	// 下载附件的action

	// //处理显示邮件头的
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
	// // out.println("邮件主题："+ subject +"</br>");
	// // out.println("发件人："+from+"<br/>");
	// // out.println("发送日期："+sendDate+"<br/><br/>");
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
	// // out.print("附件：");
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
	// //处理显示邮件正文的
	// public String displayContent(){
	// return SUCCESS;
	// }
	//	
	//	
	// // //处理邮件附件的action
	// // public String handleAttach() {
	// // return SUCCESS;
	// // }

}
