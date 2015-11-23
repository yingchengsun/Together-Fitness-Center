package com.xdsc.util;

import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;

public class DownloadAction implements Action {
	// ��Ҫ���ص��ļ�·��
	private String downloadPath;

	// ��Ϊ����Ҫ�õ��ļ���·������ֻ��Ҫ��������setter����
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	// �����ϱߵ��ļ�·����������������������Ӧ�������ļ��е�InputName������
	public InputStream getTargetFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				downloadPath);
	}

	// execute����ֻ�践��SUCCESS
	public String execute() throws Exception{
		return SUCCESS;
	}
}
