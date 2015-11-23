package com.xdsc.action.bksx_system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��action��װ���ļ�������صĲ���
 */
public class FileDownloadAction extends ActionSupport {

	/**
	 * �ļ���
	 */
	private String fileName;

	/**
	 * ѧ��ע����ݡ��ļ��ύ�׶�
	 */
	private String regYear;
	private String fileType;

	/**
	 * �����Ա������Get��Set����
	 */
	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * ���ļ������б������ã����������������
	 */
	public void setFileName() {
		String fname = ServletActionContext.getRequest().getParameter("name");
		this.fileName = fname;
	}

	/**
	 * ���ļ������б������ã����������������
	 */
	public String getFileName() {
		try {
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {

		}
		return fileName;
	}

	/**
	 * @return InputStream<br>
	 *         ����files/6bksx_system/uploadFiles/·����regYear�ļ�����fileType���ļ���ΪfileName���ļ���
	 */
	public InputStream getDownloadFile() {
		this.setFileName();

		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		return ServletActionContext.getServletContext().getResourceAsStream(
				"files/6bksx_system/uploadFiles/" + regYear + "/" + fileType
						+ "/" + fileName);
	}

	/**
	 * @return InputStream<br>
	 *         ���ش�簲�ű�
	 */
	public InputStream getChecklistDownloadFile() {
		this.setFileName();
		return ServletActionContext.getServletContext().getResourceAsStream(
				"files/6bksx_system/uploadFiles/checklist/" + fileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         ���ش�簲�ű��
	 */
	public String downloadChecklist() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         ��մ�簲���ļ���
	 */
	public String clearChecklist() {
		String dir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles/checklist");
		FoderClear.delFolder(dir);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         ���ǰ�ڡ����ڡ����ڻ������ļ���
	 */
	public String clearFoder() {
		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		String dir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles/" + regYear + "/" + fileType);
		FoderClear.delFolder(dir);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("regYear", regYear);
		request.setAttribute("fileType", fileType);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����Ա��ͼ�µ�����ҳ��
	 * @return teacher ת��ָ����ʦ��ͼ�µ�����ҳ��<br>
	 *         ����Ԥ�����õ�Ҫ���ص��꼶���ĵ�������Ϣ
	 */
	public String preDownload() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("regYear", regYear);
		request.setAttribute("fileType", fileType);
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return "teacher";
	}

	/**
	 * @return SUCCESS<br>
	 *         �������ļ������һ��Zip�ļ����أ�����winrar��֧��Unicode���룬��ѹ���������ļ�ʱ���������<br>
	 *         �˹�����ʱδ�ã����������ش���
	 */
	public InputStream getDownloadAsZipFile() {
		// ��ȡ��Ҫ������ص��ļ���·��
		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		String baseDirName = ServletActionContext.getServletContext()
				.getRealPath(
						"files/6bksx_system/uploadFiles/" + regYear + "/"
								+ fileType);
		// ��ȡ���������ļ���·���µ������ļ�������
		File file = new File(baseDirName);
		File[] allFiles = file.listFiles();
		String[] fileNames = new String[allFiles.length];
		for (int i = 0; i < allFiles.length; i++) {
			fileNames[i] = allFiles[i].getName();
		}
		// ָ�����ɵ���ʱzip�ļ����λ�ú�����
		String tempDir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles");
		String zipFileName = tempDir + "/temp/allFiles.zip";
		File tempFile = new File(tempDir + "/temp");
		if (!tempFile.exists())
			tempFile.mkdirs();
		// ��ָ���ļ���baseDirName�µ������ļ�ѹ����tempDir + "/temp/�µ�allFiles.zip�ļ���
		try {
			CompressUtil.zipFile(baseDirName, fileNames, zipFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ����������allFiles.zip
		return ServletActionContext.getServletContext().getResourceAsStream(
				"files/6bksx_system/uploadFiles/temp/allFiles.zip");
	}

	/**
	 * @return SUCCESS<br>
	 *         �������,��ʱδ��
	 */
	public String downloadAsZip() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ��������<br>
	 *         ��ָ���ļ����µ������ļ����ص�ָ�����ļ�����
	 */
	public String downloadAllFiles() {
		// ��ȡ��Ҫ������ص��ļ���·��
		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		String baseDirName = ServletActionContext.getServletContext()
				.getRealPath(
						"files/6bksx_system/uploadFiles/" + regYear + "/"
								+ fileType);
		// ��ȡ���������ļ���·���µ������ļ�������
		File file = new File(baseDirName);
		File[] allFiles = file.listFiles();
		String[] fileNames = new String[allFiles.length];
		for (int i = 0; i < allFiles.length; i++) {
			fileNames[i] = allFiles[i].getName();
		}
		// ָ�����ɵ���ʱzip�ļ����λ�ú�����
		String tempDir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles");
		String zipFileName = tempDir + "/temp/allFiles.zip";
		File tempFile = new File(tempDir + "/temp");
		if (!tempFile.exists())
			tempFile.mkdirs();
		// ��ָ���ļ���baseDirName�µ������ļ�ѹ����tempDir + "/temp/�µ�allFiles.zip�ļ���
		try {
			CompressUtil.zipFile(baseDirName, fileNames, zipFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ====================================================
		// �����ɵ���ʱZip�ļ���ѹ����Ӧ���ļ�����
		String dirName = "�ļ���";
		if (fileType.equals("firstStage")) {
			dirName = "�����ĵ�";
		} else if (fileType.equals("secondStage")) {
			dirName = "�����ĵ�";
		} else if (fileType.equals("thirdStage")) {
			dirName = "�����ĵ�";
		} else {
			dirName = "��������";
		}
		String targetBaseDirName = "D:/" + regYear + "����ҵ����ĵ�/" + dirName;
		File targetDir = new File(targetBaseDirName);
		if (!targetDir.exists())
			targetDir.mkdirs();
		// ��ѹ��ʼ....
		try {
			CompressUtil.upzipFile(zipFileName, targetBaseDirName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ���ݲ���
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("targetDir", targetBaseDirName);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת������Ԥ����ҳ��<br>
	 *         Ϊ��ϼ��ɣ�������ת����
	 */
	public String filePreDownload() {
		return SUCCESS;
	}
}
