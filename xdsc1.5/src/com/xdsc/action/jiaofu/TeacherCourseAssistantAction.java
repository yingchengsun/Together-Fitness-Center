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
 * <p>功能：课程助教管理，包括助教的申请、助教的取消和查看助教详细信息<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseAssistantAction extends ActionSupport implements SessionAware{

	/**service层对象，便于调用service层的方法*/
	private TeacherCourseAssistantManager teacherCourseAssistantManager;
	/**助教申请对象信息*/
	private List<JfptTabAssistantapply> listAssistantapplyInfo;
	/**申请对象id号*/
	private int FId;
	/**助教申请对象信息*/
	private JfptTabAssistantapply jfptTabAssistantapply;
	/**助教编号*/
	private String FAssistantId;
	/**教师对象*/
	private TabTeachers tabTeachers;
	/**学生对象*/
	private TabStudents tabStudents;
	/**院外助教对象*/
	private JfptTabOtherassist jfptTabOtherassist;
	/**教师编号*/
	private String FTeacherNumber;
	/**课程编号*/
	private String FCourseNumber;
	/**课程对象*/
	private TabCourse tabCourse;
	/**Map类型的对象*/
	private Map<String,Object> session;
	/**用户编号*/
	private String FUserNumber;
//	private String FAssistantId;
	/**分页处理中记录当前页面编号*/
	private int p = 1;
	/**分页处理中记录查询结果集的总页面数*/
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
	 * <p>功能：根据个人编号查找相关的助教信息，并对结果进行分页处理<br>
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
	 * <p>功能：删除助教信息，这里只是提出申请删除，具体操作由后台管理员进行管理<br>
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
	 * <p>功能：查看助教的具体信息<br>
	 * @return 如果是学生对象 findAssistantDetailInfoO <br>如果是教师对象 findAssistantDetailInfoS <br>如果是院外助教人员 findAssistantDetailInfoT<br>
	 */
	public String findAssistantDetailInfoByID(){
		if(teacherCourseAssistantManager.findAssistantOtherInfoByID(FAssistantId) != null){
			jfptTabOtherassist = teacherCourseAssistantManager.findAssistantOtherInfoByID(FAssistantId);
			System.out.println("***********校外助教****************");
			return "findAssistantDetailInfoO";
		}else if(teacherCourseAssistantManager.findAssistantStudentInfoByID(FAssistantId) != null){
			tabStudents = teacherCourseAssistantManager.findAssistantStudentInfoByID(FAssistantId);
			System.out.println("************在校学生***************");
			return "findAssistantDetailInfoS";
		}else{
			tabTeachers = teacherCourseAssistantManager.findAssistantTeacherInfoByID(FAssistantId);
			System.out.println("*************在校老师**************");
			return "findAssistantDetailInfoT";
		}
	}
	
	/**
	 * <p>功能：申请添加助教信息<br>
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
