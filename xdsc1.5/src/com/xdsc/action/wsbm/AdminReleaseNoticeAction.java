package com.xdsc.action.wsbm;

	import java.io.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import javax.servlet.http.HttpServletRequest;

	import org.apache.struts2.ServletActionContext;

	import com.opensymphony.xwork2.ActionSupport;
	import com.xdsc.util.UploadAction;

import jxl.*;

	/**管理员发送上传重要通知和考生须知
	 * @author 苟小龙
	 * @version 1.2
	 */
	public class AdminReleaseNoticeAction extends ActionSupport {

		/**
		 * 封装上传文件
		 */
		private File file;
		/**
		 * 封装上传文件类型
		 */
		private String fileContentType;
		/**
		 * 封装上传文件名
		 */
		private String fileFileName;
		/**
		 * 封装上传文件保存路径
		 */
		private String savePath;
		/**
		 * 自定义上传文件路径值
		 */
		private String path;//自定义上传文件路径值

		/** 上传文件
		 *@return saveNotice 上传成功
		 *@throws Exception
		 */
		public String execute() throws Exception {
			try {
				UploadAction ua = new UploadAction();//创建上传Action的对象
				/**配置UploadAction的各项参数**/
				ua.setPath(path);
				ua.setFile(file);
				ua.setFileContentType(fileContentType);
				ua.setFileFileName(fileFileName);
				ua.setSavePath(getSavePath());
				ua.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return "saveNotice";
				// 构建Workbook对象, 只读Workbook对象
				// 直接从本地文件创建Workbook
				// 从输入流创建Workbook
		}


		
		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

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

		public String getSavePath() {
			HttpServletRequest request = ServletActionContext.getRequest();
			return request.getRealPath(savePath);
		}

		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}
