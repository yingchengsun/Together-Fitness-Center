package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.XsglTabKaoqin;
import com.xdsc.model.XsglTabKaoqingather;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabCourseManager;
import com.xdsc.service.xsgl_system.XsglTabKaoqinManager;
import com.xdsc.service.xsgl_system.XsglTabKaoqingatherManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.util.PageListHolder;

/**ѧ��������ϸ��Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabKaoqinAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabKaoqinManager xsglTabKaoqinManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabKaoqingatherManager xsglTabKaoqingatherManager;
	private XsglTabCourseManager xsglTabCourseManager;
	
	private Integer FId;
	private TabCourse tabCourse;
	private TabStudents tabStudents;
	private Date FData;
	private String FAbsence;
	private String FRemark;
	private String FCourseNumber;
	private String FStudentNumber;

	private String way;
	private String attribute;
	private Date date;
	private String courseNum;
	
	public XsglTabKaoqingatherManager getXsglTabKaoqingatherManager() {
		return xsglTabKaoqingatherManager;
	}
	public void setXsglTabKaoqingatherManager(
			XsglTabKaoqingatherManager xsglTabKaoqingatherManager) {
		this.xsglTabKaoqingatherManager = xsglTabKaoqingatherManager;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public XsglTabKaoqinManager getXsglTabKaoqinManager() {
		return xsglTabKaoqinManager;
	}
	public void setXsglTabKaoqinManager(XsglTabKaoqinManager xsglTabKaoqinManager) {
		this.xsglTabKaoqinManager = xsglTabKaoqinManager;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	public TabCourse getTabCourse() {
		return tabCourse;
	}
	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public Date getFData() {
		return FData;
	}
	public void setFData(Date data) {
		FData = data;
	}
	public String getFAbsence() {
		return FAbsence;
	}
	public void setFAbsence(String absence) {
		FAbsence = absence;
	}
	public String getFRemark() {
		return FRemark;
	}
	public void setFRemark(String remark) {
		FRemark = remark;
	}
	
	public XsglTabStudentsManager getXsglTabStudentsManager() {
		return xsglTabStudentsManager;
	}
	public void setXsglTabStudentsManager(
			XsglTabStudentsManager xsglTabStudentsManager) {
		this.xsglTabStudentsManager = xsglTabStudentsManager;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	public XsglTabCourseManager getXsglTabCourseManager() {
		return xsglTabCourseManager;
	}
	public void setXsglTabCourseManager(XsglTabCourseManager xsglTabCourseManager) {
		this.xsglTabCourseManager = xsglTabCourseManager;
	}
	
	public String getFCourseNumber() {
		return FCourseNumber;
	}
	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}
	
	/** ���һ��������Ϣ
	 * @return SUCCESS ��ӳɹ�
	*/
	public String saveAttend(){
		XsglTabKaoqin attend = new XsglTabKaoqin();
		tabCourse = xsglTabCourseManager.getCourseByNum(FCourseNumber);
		tabStudents=(TabStudents)xsglTabStudentsManager.getStudentByStuNum(FStudentNumber).get(0);
		attend.setFData(FData);
		attend.setTabCourse(tabCourse);
		attend.setTabCourse(tabCourse);
		attend.setTabStudents(tabStudents);
		attend.setFAbsence(FAbsence);
		attend.setFRemark(FRemark);
		xsglTabKaoqinManager.saveAttendance(attend);
		return SUCCESS;
	}
	/** ɾ��һ��������Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteAttend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("id"));
		xsglTabKaoqinManager.deleteAttendance(xsglTabKaoqinManager.getAttendanceByFId(fid));
		return SUCCESS;
	}
	/** Ԥ����һ��������Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateAttend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("attend", xsglTabKaoqinManager.getAttendanceByFId(fid));
		return SUCCESS;
	}
	/** ����һ��������Ϣ
	 * @return SUCCESS ���³ɹ�
	*/
	public String updateAttend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("fid"));
		XsglTabKaoqin attend = xsglTabKaoqinManager.getAttendanceByFId(FId);
		tabCourse = xsglTabCourseManager.getCourseByNum(FCourseNumber);
		tabStudents=(TabStudents)xsglTabStudentsManager.getStudentByStuNum(FStudentNumber).get(0);
		attend.setFData(FData);
		attend.setTabCourse(tabCourse);
		attend.setTabCourse(tabCourse);
		attend.setTabStudents(tabStudents);
		attend.setFAbsence(FAbsence);
		attend.setFRemark(FRemark);
		xsglTabKaoqinManager.updateAttendance(attend);
		return SUCCESS;
	}
	/** ���༶��ȡ������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getAttendanceByClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		String classid= request.getParameter("cid");
		List list = xsglTabKaoqinManager.getAttendanceByClass(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("attendanceAll", list_all);
		request.setAttribute("attendanceList", list_current);
		request.setAttribute("courseList", xsglTabCourseManager.getAllCourse());
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String classAttPrevious(){
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
	public String classAttNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("attendanceAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("attendanceList", list_current);
		
		return SUCCESS;
	}
	/** ��ѧ��ѧ�Ż�������ȡ������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectAttendanceByStudent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if (way.equals("number")) {
			String stuNum = attribute;
			List list = xsglTabKaoqinManager.getAttendanceByStuNum(stuNum);
			request.setAttribute("attendanceList", list);
		} else if (way.equals("name")) {
			String stuName = attribute;
			List list = xsglTabKaoqinManager.getAttendByStuName(stuName);
			request.setAttribute("attendanceList", list);
		}
		return SUCCESS;
	}
	
	/**���ݿ���ͳ����Ϣ�����ڡ��༶���γ̻�ȡ��Ӧ����ϸ��Ϣ
	 * @return ��ȡ�ɹ�
	 */
	public String getAttendanceByDCC(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		int id = Integer.parseInt(request.getParameter("id"));
		XsglTabKaoqingather attend = xsglTabKaoqingatherManager.getTotalAttendanceByFId(id);
		Date date = attend.getFData();
		String classid = attend.getTabClasses().getFClassNumber();
		String course = attend.getTabCourse().getFCourseNumber();
		List list = xsglTabKaoqinManager.getAttendByDateClassCourse(date, classid, course);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("attendanceAll", list_all);
		request.setAttribute("attendanceList", list_current);
		return SUCCESS;
	}
	/** ��ѧ��ѧ�Ż�ȡ������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getAttendByStuNum(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents p = (XsglTabParents)session.get("parent");
		String stuNum = p.getTabStudents().getFStudentNumber();
		List list = xsglTabKaoqinManager.getAttendanceByStuNum(stuNum);
			PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("attendanceAll", list_all);
		request.setAttribute("attendanceList", list_current);
		return SUCCESS;
	}
	/** ��ѧ��ѧ�š����ڡ��γ����ƻ�ȡ������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectAttendBySDC(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("attendanceList", xsglTabKaoqinManager.getAttendByStuDateCourse(date, courseNum, stuNum));
		return SUCCESS;
	}

}
