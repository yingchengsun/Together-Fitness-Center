package com.xdsc.action.bksx_system;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action用于得到某文件夹下的特定指导教师所指导学生提交的文件
 */
public class GetMyFliesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Spring注入的Service层对象
	 */
	BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	/**
	 * @return SUCCESS
	 * @exception UnsupportedEncodingException
	 *                得到特定文件夹下特定指导教师名下指导学生提交的所有文件
	 */
	public String getFiles() throws UnsupportedEncodingException {
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		String regYear = (String) request.getAttribute("regYear");
		String fileType = (String) request.getAttribute("fileType");
		String path = ServletActionContext.getServletContext().getRealPath(
				"files/6bksx_system/uploadFiles/" + regYear + "/" + fileType);
		List files = new ArrayList();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			files = getMyFiles(path, teacherName, teacherDegree);
		else
			files = getMyFiles(path, teacherName);
		request.setAttribute("myFiles", files);
		request.setAttribute("regYear", regYear);
		request.setAttribute("fileType", fileType);
		return SUCCESS;
	}

	private List getMyFiles(String path, String teacherName) {
		// 当目录不存在，创建之
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		// 获取当前教师学生学号列表stuNumList
		List subList = bksxTabSubstuguiManager
				.getSubstuguiByTeacher(teacherName);
		List<String> stuNumList = new ArrayList<String>();
		for (int i = 0; i < subList.size(); i++) {
			BksxTabSubstugui substugui = (BksxTabSubstugui) subList.get(i);
			String stuNum = substugui.getTabStudents().getFStudentNumber();
			stuNumList.add(stuNum);
		}
		// 获取我的学生的文件
		File[] allFiles = file.listFiles();
		List<File> myFiles = new ArrayList<File>();
		for (int i = 0; i < allFiles.length; i++) {
			String fname = allFiles[i].getName();
			String preFname = fname.substring(0, 8);
			for (int j = 0; j < stuNumList.size(); j++) {
				if ((stuNumList.get(j)).equals(preFname)) {
					myFiles.add(allFiles[i]);
				}
			}
		}
		return myFiles;
	}

	/**
	 * @return SUCCESS
	 * @exception UnsupportedEncodingException
	 *                得到特定文件夹下特定指导教师名下指导学生提交的所有文件
	 */
	public List getMyFiles(String path, String teacherName, String teacherDegree)
			throws UnsupportedEncodingException {
		// 当目录不存在，创建之
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		// 获取当前教师学生学号列表stuNumList
		List subList = bksxTabSubstuguiManager.getSubstuguiByTeacher(
				teacherName, teacherDegree);
		List<String> stuNumList = new ArrayList<String>();
		for (int i = 0; i < subList.size(); i++) {
			BksxTabSubstugui substugui = (BksxTabSubstugui) subList.get(i);
			String stuNum = substugui.getTabStudents().getFStudentNumber();
			stuNumList.add(stuNum);
		}
		// 获取我的学生的文件
		File[] allFiles = file.listFiles();
		List<File> myFiles = new ArrayList<File>();
		for (int i = 0; i < allFiles.length; i++) {
			String fname = allFiles[i].getName();
			String preFname = fname.substring(0, 8);
			for (int j = 0; j < stuNumList.size(); j++) {
				if ((stuNumList.get(j)).equals(preFname)) {
					myFiles.add(allFiles[i]);
				}
			}
		}
		return myFiles;
	}
}
