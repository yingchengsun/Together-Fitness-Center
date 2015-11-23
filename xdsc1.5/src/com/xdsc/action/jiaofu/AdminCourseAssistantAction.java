package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.AdminCourseAssistantManager;

/**
 * <p>�̸���̨����Ա�Խ̸�ϵͳ������Ȩ�޽��й������а���������̡�����Ȩ��������<br>
 * @author qianxun
 * @version 1.1
 *
 */
public class AdminCourseAssistantAction extends ActionSupport {

	/**service��Ķ�����spring����ע��*/
	private AdminCourseAssistantManager adminCourseAssistantManager;
	/**����������Ϣ�б����а�������������Ϣ��ȡ��������Ϣ*/
	private List<JfptTabAssistantapply> listAssistantapplyInfo;
	/**��Ӧ�����ݿ��е�����Ȩ��������Ϣ������*/
	private int FId;
	/**�����������͵Ķ���*/
	private JfptTabAssistantapply jfptTabAssistantapply;
	/**����ID��*/
	private String FAssistantId;
	/**��ʦְ����*/
	private String FTeacherNumber;
	/**�γ̱��*/
	private String FCourseNumber;
	/**��ʦ���͵Ķ���*/
	private TabTeachers tabTeachers;
	/**�γ����͵Ķ���*/
	private TabCourse tabCourse;
	/**��ҳ�м�¼��ǰ��ҳ���*/
	private int p = 1;
	/**��ѯ����¼����ҳ��*/
	private int lastPage;

	public AdminCourseAssistantManager getAdminCourseAssistantManager() {
		return adminCourseAssistantManager;
	}

	public void setAdminCourseAssistantManager(AdminCourseAssistantManager adminCourseAssistantManager) {
		this.adminCourseAssistantManager = adminCourseAssistantManager;
	}

	public JfptTabAssistantapply getJfptTabAssistantapply() {
		return jfptTabAssistantapply;
	}

	public void setJfptTabAssistantapply(JfptTabAssistantapply jfptTabAssistantapply) {
		this.jfptTabAssistantapply = jfptTabAssistantapply;
	}

	public String getFAssistantId() {
		return FAssistantId;
	}

	public void setFAssistantId(String assistantId) {
		FAssistantId = assistantId;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int id) {
		FId = id;
	}

	public List<JfptTabAssistantapply> getListAssistantapplyInfo() {
		return listAssistantapplyInfo;
	}

	public void setListAssistantapplyInfo(
			List<JfptTabAssistantapply> listAssistantapplyInfo) {
		this.listAssistantapplyInfo = listAssistantapplyInfo;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public TabTeachers getTabTeachers() {
		return tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	/**<p>���ܣ����ҳ��й��������������ȡ������Ϣ�����з�ҳ<br>
	 * @return action findAssistantapplyInfo
	 */
	public String findAssistantapplyInfo(){
		listAssistantapplyInfo = adminCourseAssistantManager.findAssistantapplyInfo();
		
		int pages = 5;
		int listlength = listAssistantapplyInfo.size();
		if(listlength==0)
			return "findAssistantapplyInfo";
		if (listlength % pages == 0) {
			this.lastPage = listlength / pages;
		} else {
			this.lastPage = listlength / pages + 1;
		}
		if (this.p < 1)
			this.p = 1;
		if (this.p > this.lastPage)
			this.p = this.lastPage;
		int startIndex = (this.p - 1) * pages;
		int endIndex = startIndex + pages;
		if (endIndex >= listlength)
			endIndex = listlength;
		listAssistantapplyInfo = listAssistantapplyInfo.subList(startIndex, endIndex);
		
		return "findAssistantapplyInfo";
	}
	
	/**
	 * <p>���ܣ�ͬ������Ȩ���������а���ͬ��ɾ����ͬ�����<br>
	 * @return action updateApplyInfoByID
	 */
	public String updateApplyInfoByID(){//ͬ�� FShenQing == C Y
		jfptTabAssistantapply = adminCourseAssistantManager.findAssistantapplyInfoByID(FId);
		if(jfptTabAssistantapply.getFShenQing().equalsIgnoreCase("Y")){
			jfptTabAssistantapply.setFShenQing("N");
		}else{
			adminCourseAssistantManager.deleteAssistantapplyInfo(jfptTabAssistantapply);
		}
		
		listAssistantapplyInfo = adminCourseAssistantManager.findAssistantapplyInfo();
		return "updateApplyInfoByID";
	}
	
	/**
	 * <p>���ܣ��ܾ�����Ȩ���������а����ܾ�ɾ���;ܾ�����<br>
	 * @return action deleteApplyInfoByID
	 */
	public String deleteApplyInfoByID(){//�ܾ�  FShenQing == C Y
		jfptTabAssistantapply = adminCourseAssistantManager.findAssistantapplyInfoByID(FId);
		if(jfptTabAssistantapply.getFShenQing().equalsIgnoreCase("C")){
			jfptTabAssistantapply.setFShenQing("N");
		}else{
			adminCourseAssistantManager.deleteAssistantapplyInfo(jfptTabAssistantapply);
		}
		
		listAssistantapplyInfo = adminCourseAssistantManager.findAssistantapplyInfo();
		return "deleteApplyInfoByID";
	}
	
	/**
	 * <p>���ܣ���������<br>
	 * @return action addAssistantInfo
	 */
	public String addAssistantInfo(){
		JfptTabAssistantapply jfptTabAssistantapply1 = new JfptTabAssistantapply();
		jfptTabAssistantapply1.setFAssistantId(FAssistantId);
		tabCourse = adminCourseAssistantManager.findTabCourseInfoByID(FCourseNumber);
		jfptTabAssistantapply1.setTabCourse(tabCourse);
		tabTeachers = adminCourseAssistantManager.findTeacherInfoByID(FTeacherNumber);
		jfptTabAssistantapply1.setTabTeachers(tabTeachers);
		jfptTabAssistantapply1.setFShenQing("N");
		
		adminCourseAssistantManager.addAssistantInfo(jfptTabAssistantapply1);
		return "addAssistantInfo";
	}
}
