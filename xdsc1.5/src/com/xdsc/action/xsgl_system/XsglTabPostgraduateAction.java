package com.xdsc.action.xsgl_system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.service.xsgl_system.XsglTabPostgraduateManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.util.PageListHolder;

/**研究生信息
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabPostgraduateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabPostgraduateManager xsglTabPostgraduateManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabTeachersManager xsglTabTeachersManager;
	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabGradeManager xsglTabGradeManager;
	
	private String FStudentNumber;
	private TabTeachers tabTeachers;
	private TabStudents tabStudents;
	private String FStudentExSchool;
	private String FStudentEscore;
	private String FStudentErank;
	private String FType;
	private String FIsFirstChoice;
	private String FTeacherNumber;
	private String FTeacherName;
	private TabClasses tabClasses;
	private String FStudentName;
	private String FStudentSex;
	private Date FStudentBirthday;
	private String FStudentNation;
	private Date FStudentRegData;
	private String FStudentTel;
	private String FStudentEmail;
	private String FStudentPostcode;
	private String FStudentNativeplace;
	private String FHomeTel;
	private String FStudentAddress;
	private String FStudentPoliStatus;
	private String FStudentDormitory;
	private String FStudentMajor;
	private String FRewardPunish;
	private String FClassNumber;
	
	private String classid;
	private String way;
	private String attribute;
	
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
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
	public XsglTabPostgraduateManager getXsglTabPostgraduateManager() {
		return xsglTabPostgraduateManager;
	}
	public void setXsglTabPostgraduateManager(
			XsglTabPostgraduateManager xsglTabPostgraduateManager) {
		this.xsglTabPostgraduateManager = xsglTabPostgraduateManager;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	
	public String getFClassNumber() {
		return FClassNumber;
	}
	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
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
	public String getFStudentExSchool() {
		return FStudentExSchool;
	}
	public void setFStudentExSchool(String studentExSchool) {
		FStudentExSchool = studentExSchool;
	}
	public String getFStudentEscore() {
		return FStudentEscore;
	}
	public void setFStudentEscore(String studentEscore) {
		FStudentEscore = studentEscore;
	}
	public String getFStudentErank() {
		return FStudentErank;
	}
	public void setFStudentErank(String studentErank) {
		FStudentErank = studentErank;
	}
	public String getFType() {
		return FType;
	}
	public void setFType(String type) {
		FType = type;
	}
	
	public TabClasses getTabClasses() {
		return tabClasses;
	}
	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}
	public String getFStudentName() {
		return FStudentName;
	}
	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}
	public String getFStudentSex() {
		return FStudentSex;
	}
	public void setFStudentSex(String studentSex) {
		FStudentSex = studentSex;
	}
	public Date getFStudentBirthday() {
		return FStudentBirthday;
	}
	public void setFStudentBirthday(Date studentBirthday) {
		FStudentBirthday = studentBirthday;
	}
	public String getFStudentNation() {
		return FStudentNation;
	}
	public void setFStudentNation(String studentNation) {
		FStudentNation = studentNation;
	}
	public Date getFStudentRegData() {
		return FStudentRegData;
	}
	public void setFStudentRegData(Date studentRegData) {
		FStudentRegData = studentRegData;
	}
	public String getFStudentTel() {
		return FStudentTel;
	}
	public void setFStudentTel(String studentTel) {
		FStudentTel = studentTel;
	}
	public String getFStudentEmail() {
		return FStudentEmail;
	}
	public void setFStudentEmail(String studentEmail) {
		FStudentEmail = studentEmail;
	}
	public String getFStudentPostcode() {
		return FStudentPostcode;
	}
	public void setFStudentPostcode(String studentPostcode) {
		FStudentPostcode = studentPostcode;
	}
	public String getFStudentNativeplace() {
		return FStudentNativeplace;
	}
	public void setFStudentNativeplace(String studentNativeplace) {
		FStudentNativeplace = studentNativeplace;
	}
	public String getFHomeTel() {
		return FHomeTel;
	}
	public void setFHomeTel(String homeTel) {
		FHomeTel = homeTel;
	}
	public String getFStudentAddress() {
		return FStudentAddress;
	}
	public void setFStudentAddress(String studentAddress) {
		FStudentAddress = studentAddress;
	}
	public String getFStudentPoliStatus() {
		return FStudentPoliStatus;
	}
	public void setFStudentPoliStatus(String studentPoliStatus) {
		FStudentPoliStatus = studentPoliStatus;
	}
	public String getFStudentDormitory() {
		return FStudentDormitory;
	}
	public void setFStudentDormitory(String studentDormitory) {
		FStudentDormitory = studentDormitory;
	}
	public String getFStudentMajor() {
		return FStudentMajor;
	}
	public void setFStudentMajor(String studentMajor) {
		FStudentMajor = studentMajor;
	}
	public String getFRewardPunish() {
		return FRewardPunish;
	}
	public void setFRewardPunish(String rewardPunish) {
		FRewardPunish = rewardPunish;
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
	public XsglTabGradeManager getXsglTabGradeManager() {
		return xsglTabGradeManager;
	}
	public void setXsglTabGradeManager(XsglTabGradeManager xsglTabGradeManager) {
		this.xsglTabGradeManager = xsglTabGradeManager;
	}
	public XsglTabTeachersManager getXsglTabTeachersManager() {
		return xsglTabTeachersManager;
	}
	public void setXsglTabTeachersManager(
			XsglTabTeachersManager xsglTabTeachersManager) {
		this.xsglTabTeachersManager = xsglTabTeachersManager;
	}
	public String getFTeacherNumber() {
		return FTeacherNumber;
	}
	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}
	public String getFIsFirstChoice() {
		return FIsFirstChoice;
	}
	public void setFIsFirstChoice(String isFirstChoice) {
		FIsFirstChoice = isFirstChoice;
	}
	public String getFTeacherName() {
		return FTeacherName;
	}
	public void setFTeacherName(String teacherName) {
		FTeacherName = teacherName;
	}
	
	
	/** 添加一个研究生信息
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入出错，添加失败
	*/
	public String savePostgraduate(){
		TabPostgraduate postgraduate = new TabPostgraduate();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		tabTeachers = xsglTabTeachersManager.getTeacherByTeaName(FTeacherName);
		//导师不存在，添加失败
		if(tabTeachers==null)return INPUT; 
		//学生记录为空，则添加
		if(list.isEmpty()){
			tabStudents = new TabStudents();
			tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
			//班级不存在，添加失败
			if(tabClasses==null)return INPUT;
			tabStudents.setFStudentNumber(FStudentNumber);
			tabStudents.setFStudentName(FStudentName);
			tabStudents.setFStudentSex(FStudentSex);
			tabStudents.setTabClasses(tabClasses);
			tabStudents.setFHomeTel(FHomeTel);
			tabStudents.setFRewardPunish(FRewardPunish);
			tabStudents.setFStudentAddress(FStudentAddress);
			tabStudents.setFStudentBirthday(FStudentBirthday);
			tabStudents.setFStudentDormitory(FStudentDormitory);
			tabStudents.setFStudentEmail(FStudentEmail);
			tabStudents.setFStudentMajor(FStudentMajor);
			tabStudents.setFStudentNation(FStudentNation);
			tabStudents.setFStudentNativeplace(FStudentNativeplace);
			tabStudents.setFStudentPoliStatus(FStudentPoliStatus);
			tabStudents.setFStudentPostcode(FStudentPostcode);
			tabStudents.setFStudentRegData(FStudentRegData);
			tabStudents.setFStudentTel(FStudentTel);
			xsglTabStudentsManager.saveStudent(tabStudents);
		    postgraduate.setFStudentNumber(FStudentNumber);
		    postgraduate.setTabStudents(tabStudents);
		    postgraduate.setTabTeachers(tabTeachers);
		    postgraduate.setFStudentExSchool(FStudentExSchool);
		    postgraduate.setFStudentEscore(FStudentEscore);
		    postgraduate.setFStudentErank(FStudentErank);
		    postgraduate.setFIsFirstChoice(FIsFirstChoice);
		xsglTabPostgraduateManager.savePostgraduate(postgraduate);
		return SUCCESS;
		}else return INPUT;
		
	}
	/** 删除一个研究生信息
	 * @return SUCCESS 删除成功
	*/
	public String deletePostgraduate(){
		HttpServletRequest request=ServletActionContext.getRequest();
		TabPostgraduate postgraduate=xsglTabPostgraduateManager.getPostgraduateByStuNum(request.getParameter("id")).get(0);
		xsglTabPostgraduateManager.deletePostgraduate(postgraduate);
		return SUCCESS;
	}
	/** 预更新一个研究生信息
	 * @return SUCCESS 确定更新对象
	*/
	public String preUpdatePostgraduate(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String stuNum=request.getParameter("id");
		request.setAttribute("postgraduate", xsglTabPostgraduateManager.getPostgraduateByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	/** 更新一个研究生信息
	 * @return SUCCESS 更新成功
	 * @return INPUT 输入出错，更新失败
	*/
	public String updatePostgraduate(){
		TabPostgraduate postgraduate=xsglTabPostgraduateManager.getPostgraduateByStuNum(FStudentNumber).get(0);
		tabTeachers=(TabTeachers)xsglTabTeachersManager.getTeacherByTeaName(FTeacherName);
		tabStudents=(TabStudents)xsglTabStudentsManager.getStudentByStuNum(FStudentNumber).get(0);
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		//导师或班级不存在，更新失败
		if(tabTeachers==null ||tabClasses==null)return INPUT;
		tabStudents.setFStudentNumber(FStudentNumber);
		tabStudents.setFStudentName(FStudentName);
		tabStudents.setFStudentSex(FStudentSex);
		tabStudents.setTabClasses(tabClasses);
		tabStudents.setFHomeTel(FHomeTel);
		tabStudents.setFRewardPunish(FRewardPunish);
		tabStudents.setFStudentAddress(FStudentAddress);
		tabStudents.setFStudentBirthday(FStudentBirthday);
		tabStudents.setFStudentDormitory(FStudentDormitory);
		tabStudents.setFStudentEmail(FStudentEmail);
		tabStudents.setFStudentMajor(FStudentMajor);
		tabStudents.setFStudentNation(FStudentNation);
		tabStudents.setFStudentNativeplace(FStudentNativeplace);
		tabStudents.setFStudentPoliStatus(FStudentPoliStatus);
		tabStudents.setFStudentPostcode(FStudentPostcode);
		tabStudents.setFStudentRegData(FStudentRegData);
		tabStudents.setFStudentTel(FStudentTel);
		xsglTabStudentsManager.updateStudent(tabStudents);
		postgraduate.setFStudentNumber(FStudentNumber);
		postgraduate.setTabStudents(tabStudents);
		postgraduate.setTabTeachers(tabTeachers);
		postgraduate.setFStudentExSchool(FStudentExSchool);
		postgraduate.setFStudentEscore(FStudentEscore);
		postgraduate.setFStudentErank(FStudentErank);
		postgraduate.setFIsFirstChoice(FIsFirstChoice);
		xsglTabPostgraduateManager.updatePostgraduate(postgraduate);
		return SUCCESS;
	}
	/** 获取所有研究生信息
	 * @return SUCCESS 获取成功
	*/
	public String getPostgraduateList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabPostgraduateManager.getPostgraduateList();
		
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("postgraduateAll", list_all);
		request.setAttribute("postgraduateList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getPostgraClassList());
		return SUCCESS;
	}
	/** 前翻页
	 * @return SUCCESS 前翻页成功
	*/
	  public String postgraPrevious(){
			Map request = (Map) ActionContext.getContext().get("request");
			Map session =(Map)ActionContext.getContext().get("session");
			
			PageListHolder list_all =(PageListHolder) session.get("postgraduateAll");
			list_all.previousPage();
			List list_current = list_all.getPageList();
			request.put("postgraduateList", list_current);
			
			return SUCCESS;
		}
	  /** 后翻页
		 * @return SUCCESS 后翻页成功
		*/
		public String postgraNext(){
			Map request = (Map) ActionContext.getContext().get("request");
			Map session =(Map)ActionContext.getContext().get("session");
			
			PageListHolder list_all =(PageListHolder) session.get("postgraduateAll");
			list_all.nextPage();
			List list_current = list_all.getPageList();
			request.put("postgraduateList", list_current);
			
			return SUCCESS;
		}
	
	/**按年级获取研究生信息
	 * @return SUCCESS 获取成功
	 */
	public String getPostgraduateListByGrade(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		int gradeid = Integer.parseInt(request.getParameter("gid"));
		List list = xsglTabPostgraduateManager.getPostgraduateByGrade(gradeid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("postgraduateAll", list_all);
		request.setAttribute("postgraduateList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassByGradeId(gradeid));
		return SUCCESS;
	}
	 /** 获取某个研究生信息
	 * @return SUCCESS  获取成功
	*/
	public String showPostgraduate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("postgraduate", (TabPostgraduate) xsglTabPostgraduateManager.getPostgraduateByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	
	public String selectPostgraduateByClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabPostgraduateManager.getPostgraduateByClass(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("postgraduateAll", list_all);
		request.setAttribute("postgraduateList", list_current);
		return SUCCESS;
	}
	/**按学生学号或姓名获取研究生信息
	 * @return SUCCESS 获取成功
	 */
	public String selectPostgraduateByStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//按学号获取
		if (way.equals("number")) {
			String stuNum = attribute;
			List list =  xsglTabPostgraduateManager.getPostgraduateByStuNum(stuNum);
			request.setAttribute("postgraduateList", list);
		} 
		//按姓名获取
		else if (way.equals("name")) {
			String stuName = attribute;
			request.setAttribute("postgraduateList", xsglTabPostgraduateManager.getPostgraduateByStuName(stuName));
		}
		return SUCCESS;
	}

}
