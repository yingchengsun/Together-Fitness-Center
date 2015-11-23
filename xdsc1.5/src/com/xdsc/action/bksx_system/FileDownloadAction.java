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
 * @author 孙建波
 * @version 1.1<br>
 *          此action封装了文件下载相关的操作
 */
public class FileDownloadAction extends ActionSupport {

	/**
	 * 文件名
	 */
	private String fileName;

	/**
	 * 学生注册年份、文件提交阶段
	 */
	private String regYear;
	private String fileType;

	/**
	 * 该类成员变量的Get与Set方法
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
	 * 对文件名进行编码设置，解决中文乱码问题
	 */
	public void setFileName() {
		String fname = ServletActionContext.getRequest().getParameter("name");
		this.fileName = fname;
	}

	/**
	 * 对文件名进行编码设置，解决中文乱码问题
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
	 *         返回files/6bksx_system/uploadFiles/路径下regYear文件夹下fileType下文件名为fileName的文件流
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
	 *         下载答辩安排表
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
	 *         下载答辩安排表等
	 */
	public String downloadChecklist() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         清空答辩安排文件夹
	 */
	public String clearChecklist() {
		String dir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles/checklist");
		FoderClear.delFolder(dir);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         清空前期、中期、后期或论文文件夹
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
	 * @return SUCCESS 转向管理员视图下的下载页面
	 * @return teacher 转向指导教师视图下的下载页面<br>
	 *         下载预处理，得到要下载的年级、文档归类信息
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
	 *         把所有文件打包成一个Zip文件下载，由于winrar不支持Unicode编码，解压中文名称文件时会出现乱码<br>
	 *         此功能暂时未用，由批量下载代替
	 */
	public InputStream getDownloadAsZipFile() {
		// 获取需要打包下载的文件夹路径
		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		String baseDirName = ServletActionContext.getServletContext()
				.getRealPath(
						"files/6bksx_system/uploadFiles/" + regYear + "/"
								+ fileType);
		// 获取需打包下载文件夹路径下的所有文件名数组
		File file = new File(baseDirName);
		File[] allFiles = file.listFiles();
		String[] fileNames = new String[allFiles.length];
		for (int i = 0; i < allFiles.length; i++) {
			fileNames[i] = allFiles[i].getName();
		}
		// 指定生成的临时zip文件存放位置和名称
		String tempDir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles");
		String zipFileName = tempDir + "/temp/allFiles.zip";
		File tempFile = new File(tempDir + "/temp");
		if (!tempFile.exists())
			tempFile.mkdirs();
		// 将指定文件夹baseDirName下的所有文件压缩到tempDir + "/temp/下的allFiles.zip文件中
		try {
			CompressUtil.zipFile(baseDirName, fileNames, zipFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 返回下载流allFiles.zip
		return ServletActionContext.getServletContext().getResourceAsStream(
				"files/6bksx_system/uploadFiles/temp/allFiles.zip");
	}

	/**
	 * @return SUCCESS<br>
	 *         打包下载,暂时未用
	 */
	public String downloadAsZip() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 批量下载<br>
	 *         将指定文件夹下的所有文件下载到指定的文件夹下
	 */
	public String downloadAllFiles() {
		// 获取需要打包下载的文件夹路径
		String regYear = (String) ActionContext.getContext().getSession().get(
				"fyear");
		String fileType = (String) ActionContext.getContext().getSession().get(
				"ftype");
		String baseDirName = ServletActionContext.getServletContext()
				.getRealPath(
						"files/6bksx_system/uploadFiles/" + regYear + "/"
								+ fileType);
		// 获取需打包下载文件夹路径下的所有文件名数组
		File file = new File(baseDirName);
		File[] allFiles = file.listFiles();
		String[] fileNames = new String[allFiles.length];
		for (int i = 0; i < allFiles.length; i++) {
			fileNames[i] = allFiles[i].getName();
		}
		// 指定生成的临时zip文件存放位置和名称
		String tempDir = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles");
		String zipFileName = tempDir + "/temp/allFiles.zip";
		File tempFile = new File(tempDir + "/temp");
		if (!tempFile.exists())
			tempFile.mkdirs();
		// 将指定文件夹baseDirName下的所有文件压缩到tempDir + "/temp/下的allFiles.zip文件中
		try {
			CompressUtil.zipFile(baseDirName, fileNames, zipFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ====================================================
		// 将生成的临时Zip文件解压到相应的文件夹下
		String dirName = "文件夹";
		if (fileType.equals("firstStage")) {
			dirName = "初期文档";
		} else if (fileType.equals("secondStage")) {
			dirName = "中期文档";
		} else if (fileType.equals("thirdStage")) {
			dirName = "后期文档";
		} else {
			dirName = "毕设论文";
		}
		String targetBaseDirName = "D:/" + regYear + "级毕业设计文档/" + dirName;
		File targetDir = new File(targetBaseDirName);
		if (!targetDir.exists())
			targetDir.mkdirs();
		// 解压开始....
		try {
			CompressUtil.upzipFile(zipFileName, targetBaseDirName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 传递参数
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("targetDir", targetBaseDirName);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向下载预处理页面<br>
	 *         为配合集成，单纯跳转功能
	 */
	public String filePreDownload() {
		return SUCCESS;
	}
}
