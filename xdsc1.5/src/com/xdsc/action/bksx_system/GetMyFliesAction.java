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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action���ڵõ�ĳ�ļ����µ��ض�ָ����ʦ��ָ��ѧ���ύ���ļ�
 */
public class GetMyFliesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Springע���Service�����
	 */
	BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * �����Ա������Get��Set����
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
	 *                �õ��ض��ļ������ض�ָ����ʦ����ָ��ѧ���ύ�������ļ�
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
		// ��Ŀ¼�����ڣ�����֮
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		// ��ȡ��ǰ��ʦѧ��ѧ���б�stuNumList
		List subList = bksxTabSubstuguiManager
				.getSubstuguiByTeacher(teacherName);
		List<String> stuNumList = new ArrayList<String>();
		for (int i = 0; i < subList.size(); i++) {
			BksxTabSubstugui substugui = (BksxTabSubstugui) subList.get(i);
			String stuNum = substugui.getTabStudents().getFStudentNumber();
			stuNumList.add(stuNum);
		}
		// ��ȡ�ҵ�ѧ�����ļ�
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
	 *                �õ��ض��ļ������ض�ָ����ʦ����ָ��ѧ���ύ�������ļ�
	 */
	public List getMyFiles(String path, String teacherName, String teacherDegree)
			throws UnsupportedEncodingException {
		// ��Ŀ¼�����ڣ�����֮
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		// ��ȡ��ǰ��ʦѧ��ѧ���б�stuNumList
		List subList = bksxTabSubstuguiManager.getSubstuguiByTeacher(
				teacherName, teacherDegree);
		List<String> stuNumList = new ArrayList<String>();
		for (int i = 0; i < subList.size(); i++) {
			BksxTabSubstugui substugui = (BksxTabSubstugui) subList.get(i);
			String stuNum = substugui.getTabStudents().getFStudentNumber();
			stuNumList.add(stuNum);
		}
		// ��ȡ�ҵ�ѧ�����ļ�
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
