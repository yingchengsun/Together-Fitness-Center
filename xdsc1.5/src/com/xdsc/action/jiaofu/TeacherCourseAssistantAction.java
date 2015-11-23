package com.xdsc.action.jiaofu;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.TeacherCourseAssistantManager;

/**
 * <p>���ܣ��γ����̹����������̵����롢���̵�ȡ���Ͳ鿴������ϸ��Ϣ<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseAssistantAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service��ķ���*/
	private TeacherCourseAssistantManager teacherCourseAssistantManager;
	/**�������������Ϣ*/
	private List<JfptTabAssistantapply> listAssistantapplyInfo;
	/**�������id��*/
	private int FId;
	/**�������������Ϣ*/
	private JfptTabAssistantapply jfptTabAssistantapply;
	/**���̱��*/
	private String FAssistantId;
	/**��ʦ����*/
	private TabTeachers tabTeachers;
	/**ѧ������*/
	private TabStudents tabStudents;
	/**Ժ�����̶���*/
	private JfptTabOtherassist jfptTabOtherassist;
	/**��ʦ���*/
	private String FTeacherNumber;
	/**�γ̱��*/
	private String FCourseNumber;
	/**�γ̶���*/
	private TabCourse tabCourse;
	/**Map���͵Ķ���*/
	private Map<String,Object> session;
	/**�û����*/
	private String FUserNumber;
//	private String FAssistantId;
	/**��ҳ�����м�¼��ǰҳ����*/
	private int p = 1;
	/**��ҳ�����м�¼��ѯ���������ҳ����*/
	private int lastPage;

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

	public TeacherCourseAssistantManager getTeacherCourseAssistantManager() {
		return teacherCourseAssistantManager;
	}

	public void setTeacherCourseAssistantManager(
			TeacherCourseAssistantManager teacherCourseAssistantManager) {
		this.teacherCourseAssistantManager = teacherCourseAssistantManager;
	}
	
	public TabTeachers getTabTeachers() {
		return tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabStudents getTabStudents() {
		return tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public JfptTabOtherassist getJfptTabOtherassist() {
		return jfptTabOtherassist;
	}

	public void setJfptTabOtherassist(JfptTabOtherassist jfptTabOtherassist) {
		this.jfptTabOtherassist = jfptTabOtherassist;
	}

	public String getFAssistantId() {
		return FAssistantId;
	}

	public void setFAssistantId(String assistantId) {
		FAssistantId = assistantId;
	}

	public JfptTabAssistantapply getJfptTabAssistantapply() {
		return jfptTabAssistantapply;
	}

	public void setJfptTabAssistantapply(JfptTabAssistantapply jfptTabAssistantapply) {
		this.jfptTabAssistantapply = jfptTabAssistantapply;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int id) {
		FId = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public List<JfptTabAssistantapply> getListAssistantapplyInfo() {
		return listAssistantapplyInfo;
	}

	public void setListAssistantapplyInfo(
			List<JfptTabAssistantapply> listAssistantapplyInfo) {
		this.listAssistantapplyInfo = listAssistantapplyInfo;
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

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų�����ص�������Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findAssistantInfo
	 */
	public String findAssistantInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listAssistantapplyInfo = teacherCourseAssistantManager.findAssistantapplyInfo(FTeacherNumber);
		
		int pages = 5;
		int listlength = listAssistantapplyInfo.size();
		if(listlength==0)
			return "findAssistantInfo";
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
		
		return "findAssistantInfo";
	}
	
	/**
	 * <p>���ܣ�ɾ��������Ϣ������ֻ���������ɾ������������ɺ�̨����Ա���й���<br>
	 * @return action deleteAssistantInfo
	 */
	public String deleteAssistantInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabAssistantapply = teacherCourseAssistantManager.findAssistantapplyInfoByID(FId);
		jfptTabAssistantapply.setFShenQing("C");
		teacherCourseAssistantManager.updateInfo(jfptTabAssistantapply);
		listAssistantapplyInfo = teacherCourseAssistantManager.findAssistantapplyInfo(FTeacherNumber);
		return "deleteAssistantInfo";
	}
	
	/**
	 * <p>���ܣ��鿴���̵ľ�����Ϣ<br>
	 * @return �����ѧ������ findAssistantDetailInfoO <br>����ǽ�ʦ���� findAssistantDetailInfoS <br>�����Ժ��������Ա findAssistantDetailInfoT<br>
	 */
	public String findAssistantDetailInfoByID(){
		if(teacherCourseAssistantManager.findAssistantOtherInfoByID(FAssistantId) != null){
			jfptTabOtherassist = teacherCourseAssistantManager.findAssistantOtherInfoByID(FAssistantId);
			System.out.println("***********У������****************");
			return "findAssistantDetailInfoO";
		}else if(teacherCourseAssistantManager.findAssistantStudentInfoByID(FAssistantId) != null){
			tabStudents = teacherCourseAssistantManager.findAssistantStudentInfoByID(FAssistantId);
			System.out.println("************��Уѧ��***************");
			return "findAssistantDetailInfoS";
		}else{
			tabTeachers = teacherCourseAssistantManager.findAssistantTeacherInfoByID(FAssistantId);
			System.out.println("*************��У��ʦ**************");
			return "findAssistantDetailInfoT";
		}
	}
	
	/**
	 * <p>���ܣ��������������Ϣ<br>
	 * @return action addAssistantInfo
	 */
	public String addAssistantInfo(){
		JfptTabAssistantapply jfptTabAssistantapply1 = new JfptTabAssistantapply();
		jfptTabAssistantapply1.setFAssistantId(FAssistantId);
		jfptTabAssistantapply1.setFShenQing("Y");
		
		tabCourse = teacherCourseAssistantManager.findCourseInfoByID(FCourseNumber);
		jfptTabAssistantapply1.setTabCourse(tabCourse);
		
		tabTeachers = teacherCourseAssistantManager.findTeacherInfoByID(FTeacherNumber);
		jfptTabAssistantapply1.setTabTeachers(tabTeachers);
		
		teacherCourseAssistantManager.addAssistantapply(jfptTabAssistantapply1);
		listAssistantapplyInfo = teacherCourseAssistantManager.findAssistantapplyInfo(FTeacherNumber);
		return "addAssistantInfo";
	}
}
