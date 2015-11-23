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

	/**����Ա�����ϴ���Ҫ֪ͨ�Ϳ�����֪
	 * @author ��С��
	 * @version 1.2
	 */
	public class AdminReleaseNoticeAction extends ActionSupport {

		/**
		 * ��װ�ϴ��ļ�
		 */
		private File file;
		/**
		 * ��װ�ϴ��ļ�����
		 */
		private String fileContentType;
		/**
		 * ��װ�ϴ��ļ���
		 */
		private String fileFileName;
		/**
		 * ��װ�ϴ��ļ�����·��
		 */
		private String savePath;
		/**
		 * �Զ����ϴ��ļ�·��ֵ
		 */
		private String path;//�Զ����ϴ��ļ�·��ֵ

		/** �ϴ��ļ�
		 *@return saveNotice �ϴ��ɹ�
		 *@throws Exception
		 */
		public String execute() throws Exception {
			try {
				UploadAction ua = new UploadAction();//�����ϴ�Action�Ķ���
				/**����UploadAction�ĸ������**/
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
				// ����Workbook����, ֻ��Workbook����
				// ֱ�Ӵӱ����ļ�����Workbook
				// ������������Workbook
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
