package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabKaoqingather;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabCourseManager;
import com.xdsc.service.xsgl_system.XsglTabKaoqingatherManager;
import com.xdsc.util.PageListHolder;

/**����ͳ����Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabKaoqingatherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private XsglTabKaoqingatherManager xsglTabKaoqingatherManager;
	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabCourseManager xsglTabCourseManager;

	private Integer FId;
	private TabClasses tabClasses;
	private TabCourse tabCourse;
	private Date FData;
	private Integer FTnumber;
	private Integer FRnumber;
	private String FRemark;
	private String FClassNumber;
	private String FCourseNumber;
	
	private Date date;
	private String classid;
	private String courseNum;



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer id) {
		FId = id;
	}

	public TabClasses getTabClasses() {
		return tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public Date getFData() {
		return FData;
	}

	public void setFData(Date data) {
		FData = data;
	}

	public Integer getFTnumber() {
		return FTnumber;
	}

	public void setFTnumber(Integer tnumber) {
		FTnumber = tnumber;
	}

	public Integer getFRnumber() {
		return FRnumber;
	}

	public void setFRnumber(Integer rnumber) {
		FRnumber = rnumber;
	}

	public String getFRemark() {
		return FRemark;
	}

	public void setFRemark(String remark) {
		FRemark = remark;
	}

	public XsglTabKaoqingatherManager getXsglTabKaoqingatherManager() {
		return xsglTabKaoqingatherManager;
	}

	public void setXsglTabKaoqingatherManager(
			XsglTabKaoqingatherManager xsglTabKaoqingatherManager) {
		this.xsglTabKaoqingatherManager = xsglTabKaoqingatherManager;
	}

	public XsglTabClassesManager getXsglTabClassesManager() {
		return xsglTabClassesManager;
	}

	public void setXsglTabClassesManager(
			XsglTabClassesManager xsglTabClassesManager) {
		this.xsglTabClassesManager = xsglTabClassesManager;
	}

	public String getFClassNumber() {
		return FClassNumber;
	}

	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
	}

	public XsglTabCourseManager getXsglTabCourseManager() {
		return xsglTabCourseManager;
	}

	public void setXsglTabCourseManager(
			XsglTabCourseManager xsglTabCourseManager) {
		this.xsglTabCourseManager = xsglTabCourseManager;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}
	
	/** ���һ������ͳ����Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String saveTotalAttend() {
		XsglTabKaoqingather toAttend = new XsglTabKaoqingather();
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		tabCourse = xsglTabCourseManager.getCourseByNum(FCourseNumber);
		if(tabClasses==null || tabCourse==null)return INPUT;
		else{
		toAttend.setFData(FData);
		toAttend.setTabClasses(tabClasses);
		toAttend.setTabCourse(tabCourse);
		toAttend.setFTnumber(FTnumber);
		toAttend.setFRnumber(FRnumber);
		toAttend.setFRemark(FRemark);
		xsglTabKaoqingatherManager.saveTotalAttendance(toAttend);
		return SUCCESS;
		}
	}
	/** ɾ��һ������ͳ����Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteTotalAttend() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("fid"));
		xsglTabKaoqingatherManager
				.deleteTotalAttendance(xsglTabKaoqingatherManager
						.getTotalAttendanceByFId(FId));
		return SUCCESS;
	}
	/** Ԥ����һ������ͳ����Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateTotalAttend() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("fid"));
		request.setAttribute("toAttend", xsglTabKaoqingatherManager
				.getTotalAttendanceByFId(FId));
		return SUCCESS;
	}
	/** ����һ������ͳ����Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updateTotalAttend() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int attendID = Integer.parseInt(request.getParameter("attendID"));
		XsglTabKaoqingather toAttend = xsglTabKaoqingatherManager
				.getTotalAttendanceByFId(attendID);
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		tabCourse = xsglTabCourseManager.getCourseByNum(FCourseNumber);
		if(tabClasses==null || tabCourse==null)return INPUT;
		else{
		toAttend.setFData(FData);
		toAttend.setTabClasses(tabClasses);
		toAttend.setTabCourse(tabCourse);
		toAttend.setFTnumber(FTnumber);
		toAttend.setFRnumber(FRnumber);
		toAttend.setFRemark(FRemark);
		xsglTabKaoqingatherManager.updateTotalAttendance(toAttend);
		return SUCCESS;
		}
	}
	/** ��ȡ���п���ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getTotalAttendanceList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabKaoqingatherManager.getTotalAttendanceList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("attendanceAll", list_all);
		request.setAttribute("attendanceList", list_current);
		request.setAttribute("courseList", xsglTabCourseManager.getAllCourse());
		request.setAttribute("classList", xsglTabClassesManager.getClassList());
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String totalAttPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("attendanceAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("attendanceList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String totalAttNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("attendanceAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("attendanceList", list_current);
		
		return SUCCESS;
	}
	/** ���꼶��ȡ����ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getTotalAttendanceByGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabKaoqingatherManager
		.getTotalAttendanceByGrade(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("attendanceAll", list_all);
		request.setAttribute("attendanceList", list_current);
		request.setAttribute("courseList", xsglTabCourseManager.getAllCourse());
		request.setAttribute("classList", xsglTabClassesManager.getClassByGradeId(gradeId));
		return SUCCESS;
	}
	
	/** �����ڡ��༶�ż��γ����ƻ�ȡ����ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectTotalAttendByDCC(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabKaoqingatherManager.getTotalAttendByDateClassCourse(date, classid, courseNum);
		request.setAttribute("attendanceList", list);
		return SUCCESS;
	}

}
