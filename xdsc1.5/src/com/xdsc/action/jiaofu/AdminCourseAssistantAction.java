package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.AdminCourseAssistantManager;

/**
 * <p>教辅后台管理员对教辅系统的助教权限进行管理，其中包括添加助教、助教权限审批。<br>
 * @author qianxun
 * @version 1.1
 *
 */
public class AdminCourseAssistantAction extends ActionSupport {

	/**service层的对象，由spring帮助注入*/
	private AdminCourseAssistantManager adminCourseAssistantManager;
	/**助教申请信息列表，其中包括申请助教信息和取消助教信息*/
	private List<JfptTabAssistantapply> listAssistantapplyInfo;
	/**对应到数据库中的助教权限申请信息主键号*/
	private int FId;
	/**助教申请类型的对象*/
	private JfptTabAssistantapply jfptTabAssistantapply;
	/**助教ID号*/
	private String FAssistantId;
	/**教师职工号*/
	private String FTeacherNumber;
	/**课程编号*/
	private String FCourseNumber;
	/**教师类型的对象*/
	private TabTeachers tabTeachers;
	/**课程类型的对象*/
	private TabCourse tabCourse;
	/**分页中记录当前的页面号*/
	private int p = 1;
	/**查询出记录的总页数*/
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

	/**<p>功能：查找出有关助教申请和助教取消的信息并进行分页<br>
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
	 * <p>功能：同意助教权限请求，其中包括同意删除和同意分配<br>
	 * @return action updateApplyInfoByID
	 */
	public String updateApplyInfoByID(){//同意 FShenQing == C Y
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
	 * <p>功能：拒绝助教权限请求，其中包括拒绝删除和拒绝分配<br>
	 * @return action deleteApplyInfoByID
	 */
	public String deleteApplyInfoByID(){//拒绝  FShenQing == C Y
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
	 * <p>功能：分配助教<br>
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
