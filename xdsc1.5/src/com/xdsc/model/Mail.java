package com.xdsc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Mail {
	// �ʼ��࣬�����������ʼ�����Ҫ����������
	private String displayName;
	private String to;
	private String from;
	private String smtpServer;// smtp������
	private String username;// ��¼smtp���������û���
	private String password;// ��¼smtp������������
	private String subject;// �ʼ�����
	private String content;// �ʼ�����
	private boolean ifAuth;// �������Ƿ���Ҫ�����֤
	private String filename = new String("");
	private List file = new ArrayList(0);// ���ڱ��淢�͸������ļ����ļ���

	

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

	// �÷��������ռ�������
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

	// ��ʼ��SMTP��������ַ��������E-mail��ַ���û��������롢�����ߡ����⡢����
	// ������캯�������ʼ���������Ҫ�����֤ǰ���µĳ�ʼ��
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

	//��ʼ��SMTP��������ַ��������E-mail��ַ�������ߣ����� ����
	//������캯�������ʼ�����������Ҫ�����֤��ǰ���µĳ�ʼ��
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
