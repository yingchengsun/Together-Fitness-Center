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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action封装了文件上传的相关操作
 */
public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 代表上传文件的file对象
	 */
	private File[] file;

	/**
	 * 上传文件名
	 */
	private String[] fileFileName;

	/**
	 * 上传文件的MIME类型
	 */
	private String[] fileContentType;

	/**
	 * 保存上传文件的目录，相对于Web应用程序的根路径，在struts.xml文件中配置
	 */
	private String uploadDir;

	/**
	 * 上传文件的类型，时期
	 */
	private String fileType;

	/**
	 * 该类成员变量的Get与Set方法
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

		// 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数，将这个毫秒数作为上传文件新的文件名。
		long now = new Date().getTime();

		// 获取当前学生的学号，获取当前学生的年级
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			return INPUT;
		}
		String stuNum = student.getFStudentNumber();
		String stuName = "无名氏";
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
		// 得到保存上传文件的目录的真实路径
		String path = ServletActionContext.getServletContext().getRealPath(
				uploadDir + "\\" + regYear + "\\" + fileType);

		File dir = new File(path);
		// 如果这个目录不存在，则创建它。
		if (!dir.exists())
			dir.mkdirs();

		try {
			for (int i = 0; i < file.length; i++) {
				int index = fileFileName[i].lastIndexOf('.');
				// 判断上传文件名是否有扩展名,并以学生学号+姓名+文件名为新的文件名
				if (index != -1)
					newFileName = stuNum + "_" + stuName + "_"
							+ fileFileName[i].substring(0, index)
							+ fileFileName[i].substring(index);
				else
					newFileName = stuNum + stuName + Long.toString(now);

				BufferedOutputStream bos = null;
				BufferedInputStream bis = null;
				// 读取保存在临时目录下的上传文件，写入到新的文件中。
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
	 * @return SUCCESS 转向文件上传页面<br>
	 *         单纯跳转功能，为配合系统集成
	 */
	public String toFileUpload() {
		return SUCCESS;
	}
}
