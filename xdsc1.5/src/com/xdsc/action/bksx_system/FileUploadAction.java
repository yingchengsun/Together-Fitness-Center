package com.xdsc.action.bksx_system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabStudents;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action��װ���ļ��ϴ�����ز���
 */
public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * �����ϴ��ļ���file����
	 */
	private File[] file;

	/**
	 * �ϴ��ļ���
	 */
	private String[] fileFileName;

	/**
	 * �ϴ��ļ���MIME����
	 */
	private String[] fileContentType;

	/**
	 * �����ϴ��ļ���Ŀ¼�������WebӦ�ó���ĸ�·������struts.xml�ļ�������
	 */
	private String uploadDir;

	/**
	 * �ϴ��ļ������ͣ�ʱ��
	 */
	private String fileType;

	/**
	 * �����Ա������Get��Set����
	 */
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * @see com.opensymphony.xwork.Action#execute()
	 */
	public String execute() throws Exception {

		String newFileName = null;

		// �õ���ǰʱ����1970��1��1��0ʱ0��0�뿪ʼ���ŵĺ��������������������Ϊ�ϴ��ļ��µ��ļ�����
		long now = new Date().getTime();

		// ��ȡ��ǰѧ����ѧ�ţ���ȡ��ǰѧ�����꼶
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			return INPUT;
		}
		String stuNum = student.getFStudentNumber();
		String stuName = "������";
		if (student.getFStudentName() != null)
			stuName = student.getFStudentName();
		String regYear = "";
		if (student.getFStudentRegData() != null)
			regYear = student.getFStudentRegData().toString().substring(0, 4);
		else {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String thisYear = df.format(new Date());
			regYear = thisYear.substring(0, 4);
		}
		// �õ������ϴ��ļ���Ŀ¼����ʵ·��
		String path = ServletActionContext.getServletContext().getRealPath(
				uploadDir + "\\" + regYear + "\\" + fileType);

		File dir = new File(path);
		// ������Ŀ¼�����ڣ��򴴽�����
		if (!dir.exists())
			dir.mkdirs();

		try {
			for (int i = 0; i < file.length; i++) {
				int index = fileFileName[i].lastIndexOf('.');
				// �ж��ϴ��ļ����Ƿ�����չ��,����ѧ��ѧ��+����+�ļ���Ϊ�µ��ļ���
				if (index != -1)
					newFileName = stuNum + "_" + stuName + "_"
							+ fileFileName[i].substring(0, index)
							+ fileFileName[i].substring(index);
				else
					newFileName = stuNum + stuName + Long.toString(now);

				BufferedOutputStream bos = null;
				BufferedInputStream bis = null;
				// ��ȡ��������ʱĿ¼�µ��ϴ��ļ���д�뵽�µ��ļ��С�
				try {
					FileInputStream fis = new FileInputStream(file[i]);
					bis = new BufferedInputStream(fis);

					FileOutputStream fos = new FileOutputStream(new File(dir,
							newFileName));
					bos = new BufferedOutputStream(fos);

					byte[] buf = new byte[4096];

					int len = -1;
					while ((len = bis.read(buf)) != -1) {
						bos.write(buf, 0, len);
					}
				} finally {
					try {
						if (null != bis)
							bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

					try {
						if (null != bos)
							bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (RuntimeException e) {
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���ļ��ϴ�ҳ��<br>
	 *         ������ת���ܣ�Ϊ���ϵͳ����
	 */
	public String toFileUpload() {
		return SUCCESS;
	}
}
