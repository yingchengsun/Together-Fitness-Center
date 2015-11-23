package com.xdsc.util;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	// 封装上传文件标题
	private String title;

	// 封装上传文件
	private File file;

	// 封装上传文件类型
	private String fileContentType;

	// 封装上传文件名
	private String fileFileName;

	// 封装上传文件保存路径
	private String savePath;
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	// 返回文件上传路径
	public String getSavePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRealPath(savePath);
	}

	// 上传文件的getter和setter方法
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// 省略其它getter和setter方法
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
			addFieldError("file", "输入文件不能为空");
			return "input";
		}
		if(getFileFileName().indexOf("xls")==-1)
		{
			addFieldError("file", "输入文件格式不正确");
		}
		// 设置上传文件存放的相对路径
		setSavePath(path);
		// 以上传文件存放路径和原文件名建立一个输出流
		File dir = new File(getSavePath());
		// 如果这个目录不存在，则创建它。
		if (!dir.exists())
			dir.mkdirs();
		// 以上传文件存放路径和原文件名建立一个输出流
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ getFileFileName());
		// 以上传文件建立一个输入流
		FileInputStream fis = new FileInputStream(getFile());
		// 将上传文件写入到输出流所对应的文件中
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
			addFieldError("file", "输入文件不能为空");
		}
	}

}
