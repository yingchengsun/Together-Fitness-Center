package com.xdsc.util;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	// ��װ�ϴ��ļ�����
	private String title;

	// ��װ�ϴ��ļ�
	private File file;

	// ��װ�ϴ��ļ�����
	private String fileContentType;

	// ��װ�ϴ��ļ���
	private String fileFileName;

	// ��װ�ϴ��ļ�����·��
	private String savePath;
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	// �����ļ��ϴ�·��
	public String getSavePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRealPath(savePath);
	}

	// �ϴ��ļ���getter��setter����
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// ʡ������getter��setter����
	// ...
	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String execute() throws Exception {
		System.out.println("=========");
		if(getFileFileName().equals("")||getFileFileName()==null)
		{
			addFieldError("file", "�����ļ�����Ϊ��");
			return "input";
		}
		if(getFileFileName().indexOf("xls")==-1)
		{
			addFieldError("file", "�����ļ���ʽ����ȷ");
		}
		// �����ϴ��ļ���ŵ����·��
		setSavePath(path);
		// ���ϴ��ļ����·����ԭ�ļ�������һ�������
		File dir = new File(getSavePath());
		// ������Ŀ¼�����ڣ��򴴽�����
		if (!dir.exists())
			dir.mkdirs();
		// ���ϴ��ļ����·����ԭ�ļ�������һ�������
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ getFileFileName());
		// ���ϴ��ļ�����һ��������
		FileInputStream fis = new FileInputStream(getFile());
		// ���ϴ��ļ�д�뵽���������Ӧ���ļ���
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		return SUCCESS;
	}

	public void validate()
	{
		System.out.println("validate==================");
		if(getFileFileName().equals("")||getFileFileName()==null)
		{
			addFieldError("file", "�����ļ�����Ϊ��");
		}
	}

}
