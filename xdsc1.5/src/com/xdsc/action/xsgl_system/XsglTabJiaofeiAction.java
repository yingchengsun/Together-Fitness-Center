package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabJiaofei;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabJiaofeiManager;
import com.xdsc.util.PageListHolder;


/**学生欠费信息
 * @author 杨盼盼
 * @version 1.1 
 */
public class XsglTabJiaofeiAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabJiaofeiManager xsglTabJiaofeiManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabClassesManager xsglTabClassesManager;
	
	private Integer FId;
	private TabStudents tabStudents;
	private Integer FTuition;
	private Integer FAccommodation;
	private Integer FTotal;
	private String FYear;
	private String FStudentNumber;
	private String FClassNumber;
	
	private String way;
	private String attribute;
	private String year;
	private String classid;

	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	
	public XsglTabJiaofeiManager getXsglTabJiaofeiManager() {
		return xsglTabJiaofeiManager;
	}
	public void setXsglTabJiaofeiManager(XsglTabJiaofeiManager xsglTabJiaofeiManager) {
		this.xsglTabJiaofeiManager = xsglTabJiaofeiManager;
	}
	
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	
	public Integer getFTuition() {
		return FTuition;
	}
	public void setFTuition(Integer tuition) {
		FTuition = tuition;
	}
	public Integer getFAccommodation() {
		return FAccommodation;
	}
	public void setFAccommodation(Integer accommodation) {
		FAccommodation = accommodation;
	}
	public Integer getFTotal() {
		return FTotal;
	}
	public void setFTotal(Integer total) {
		FTotal = total;
	}
	public String getFYear() {
		return FYear;
	}
	public void setFYear(String fYear) {
		FYear = fYear;
	}
	
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	
	public XsglTabStudentsManager getXsglTabStudentsManager() {
		return xsglTabStudentsManager;
	}
	public void setXsglTabStudentsManager(
			XsglTabStudentsManager xsglTabStudentsManager) {
		this.xsglTabStudentsManager = xsglTabStudentsManager;
	}
	public XsglTabClassesManager getXsglTabClassesManager() {
		return xsglTabClassesManager;
	}
	public void setXsglTabClassesManager(XsglTabClassesManager xsglTabClassesManager) {
		this.xsglTabClassesManager = xsglTabClassesManager;
	}
	public String getFClassNumber() {
		return FClassNumber;
	}
	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
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
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	/** 按年级获取学生欠费信息
	 * @return SUCCESS 获取成功
	*/
	public String getStudentListByGrade(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabJiaofeiManager.getJStudentListByGrade(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("jStudentAll", list_all);
		request.setAttribute("jStudentList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassByGradeId(gradeId));
		return SUCCESS;
	}
	/** 前翻页
	 * @return SUCCESS 前翻页成功
	*/
	public String gradeFeePrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("jStudentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("jStudentList", list_current);
		
		return SUCCESS;
	}
	/** 后翻页
	 * @return SUCCESS 后翻页成功
	*/
	public String gradeFeeNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("jStudentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("jStudentList", list_current);
		
		return SUCCESS;
	}
	/** 获取所有学生欠费信息
	 * @return SUCCESS 获取成功
	*/
	public String getMStudentList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabJiaofeiManager.getJStudentList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("jStudentAll", list_all);
		request.setAttribute("jStudentList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassList());
		return SUCCESS;
		}
	/** 前翻页
	 * @return SUCCESS 前翻页成功
	*/
	public String feePrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("jStudentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("jStudentList", list_current);
		
		return SUCCESS;
	}
	/** 后翻页
	 * @return SUCCESS 后翻页成功
	*/
	public String feeNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("jStudentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("jStudentList", list_current);
		
		return SUCCESS;
	}
	
	/** 删除一条学生欠费信息
	 * @return SUCCESS 删除成功
	*/
	public String deleteFee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		xsglTabJiaofeiManager.deleteJStudent((XsglTabJiaofei)xsglTabJiaofeiManager.getJStudentByStuNum(stuNum).get(0));

		return SUCCESS;
	}
	/** 预更新一条学生欠费信息
	 * @return SUCCESS 确定更新对象
	*/
	public String preUpdateFee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("student", xsglTabJiaofeiManager.getJStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	/** 更新一条学生欠费信息
	 * @return SUCCESS 更新成功
	 * @return INPUT 输入值有错，更新失败
	*/
	public String updateFee(){
		XsglTabJiaofei jstudent = xsglTabJiaofeiManager.getJStudentByStuNum(tabStudents.getFStudentNumber()).get(0);

		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//学生不存在，添加失败
		if(list.isEmpty())
			return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		jstudent.setTabStudents(tabStudents);
		jstudent.setFYear(FYear);
		jstudent.setFTuition(FTuition);
		jstudent.setFAccommodation(FAccommodation);
		jstudent.setFTotal(FTotal);
		xsglTabJiaofeiManager.updateJStudent(jstudent);
		return SUCCESS;
		}
	}
	/** 添加一条学生欠费信息
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入值有错，添加失败
	*/
	public String saveFee(){
		XsglTabJiaofei jstudent = new XsglTabJiaofei();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//学生不存在，添加失败
		if(list.isEmpty())
			return INPUT;
		else{
			tabStudents = (TabStudents)list.get(0);
			jstudent.setTabStudents(tabStudents);
			jstudent.setFYear(FYear);
			jstudent.setFTuition(FTuition);
			jstudent.setFAccommodation(FAccommodation);
			jstudent.setFTotal(FTotal);
			xsglTabJiaofeiManager.saveJStudent(jstudent);
			return SUCCESS;
		}
	}
	/** 按学生学号或姓名获取欠费信息
	 * @return SUCCESS 获取成功
	*/
	public String selectFee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(way.equals("stuNum")){
			String stuNum=attribute;
			List<XsglTabJiaofei> list=xsglTabJiaofeiManager.getJStudentByStuNum(stuNum);
			request.setAttribute("jStudentList", list);
		}else if(way.equals("stuName")){
			String stuName=attribute;
			List<XsglTabJiaofei> list=xsglTabJiaofeiManager.getJStudentByStuName(stuName);
			request.setAttribute("jStudentList", list);
		}
		return SUCCESS;
	}
	/** 按年份、班级获取学生欠费信息
	 * @return SUCCESS 获取成功
	*/
	public String selectFeeByYear(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("jStudentList", xsglTabJiaofeiManager.getJStudentByYearClass(year, classid));
		return SUCCESS;
	}

}
