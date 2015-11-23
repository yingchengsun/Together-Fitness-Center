package com.xdsc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Mail {
	// 邮件类，包括所发送邮件所需要的所有属性
	private String displayName;
	private String to;
	private String from;
	private String smtpServer;// smtp服务器
	private String username;// 登录smtp服务器的用户名
	private String password;// 登录smtp服务器的密码
	private String subject;// 邮件主题
	private String content;// 邮件内容
	private boolean ifAuth;// 服务器是否需要身份认证
	private String filename = new String("");
	private List file = new ArrayList(0);// 用于保存发送附件的文件名的集合

	

	public String getDisplayName() {
		return displayName;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public boolean isIfAuth() {
		return ifAuth;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIfAuth(boolean ifAuth) {
		this.ifAuth = ifAuth;
	}

	// 该方法用于收集附件名
	public void addAttachFile(String fname) {
		file.add(filename);
	}
	

	public List getFile() {
		return file;
	}

	public void setFile(List file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Mail() {
		// empty constructor
	}

	// 初始化SMTP服务器地址、发送者E-mail地址、用户名、密码、接收者、主题、内容
	// 这个构造函数是在邮件服务器需要身份验证前提下的初始化
	public Mail(String smtpServer, String from, String displayName,
			String username, String password, String to, String subject,
			String content) {
		this.smtpServer = smtpServer;
		this.from = from;
		this.displayName = displayName;
		this.ifAuth = true;
		this.username = username;
		this.password = password;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	//初始化SMTP服务器地址，发送者E-mail地址，接受者，主题 内容
	//这个构造函数是在邮件服务器不需要身份验证的前提下的初始化
	public Mail(String smtpServer, String from, String displayName, String to,
			String subject, String content) {
		this.smtpServer = smtpServer;
		this.from = from;
		this.displayName = displayName;
		this.ifAuth = false;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
}
