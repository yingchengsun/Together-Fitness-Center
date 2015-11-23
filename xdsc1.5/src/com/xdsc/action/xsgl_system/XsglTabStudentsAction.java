package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.util.PageListHolder;

/**学生个人信息
 * @author 杨盼盼
 *
 */
public class XsglTabStudentsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private XsglTabStudentsManager xsglTabStudentsManager;

	private String FStudentNumber;
	private TabClasses tabClasses;
	private TabDirection tabDirection;
	private MhqxTabUser mhqxTabUser;
	private String FStudentName;
	private String FIsLocked;
	private String FStudentSex;
	private Date FStudentBirthday;
	private String FStudentIdCard;
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
	private String FQuXiang;
	private String FCardNumber;

	private String way;
	private String attribute;
	private String classid;

	

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public TabClasses getTabClasses() {
		return tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFStudentName() {
		return FStudentName;
	}

	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}

	public String getFIsLocked() {
		return FIsLocked;
	}

	public void setFIsLocked(String isLocked) {
		FIsLocked = isLocked;
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

	public String getFStudentIdCard() {
		return FStudentIdCard;
	}

	public void setFStudentIdCard(String studentIdCard) {
		FStudentIdCard = studentIdCard;
	}

	public String getFStudentNation() {
		return FStudentNation;
	}

	public void setFStudentNation(String studentNation) {
		FStudentNation = studentNation;
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

	public String getFQuXiang() {
		return FQuXiang;
	}

	public void setFQuXiang(String quXiang) {
		FQuXiang = quXiang;
	}

	public String getFCardNumber() {
		return FCardNumber;
	}

	public void setFCardNumber(String cardNumber) {
		FCardNumber = cardNumber;
	}

	public XsglTabStudentsManager getXsglTabStudentsManager() {
		return xsglTabStudentsManager;
	}

	public void setXsglTabStudentsManager(
			XsglTabStudentsManager xsglTabStudentsManager) {
		this.xsglTabStudentsManager = xsglTabStudentsManager;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}


	public TabDirection getTabDirection() {
		return tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public Date getFStudentRegData() {
		return FStudentRegData;
	}


	
	public String getStudentsList() {
		List<TabStudents> list = xsglTabStudentsManager.getStudentsList();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("studentsList", list);
		return SUCCESS;
	}


	public String preUpdateStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("student", xsglTabStudentsManager
				.getStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}

	/**更新一个学生信息
	 * @return SUCCESS 更新成功
	 */
	public String updateStudent() {
		TabStudents student = (TabStudents) xsglTabStudentsManager
				.getStudentByStuNum(FStudentNumber).get(0);
		student.setFStudentName(FStudentName);
		student.setFStudentSex(FStudentSex);
		student.setTabClasses(tabClasses);
		student.setFCardNumber(FCardNumber);
		student.setFHomeTel(FHomeTel);
		student.setFIsLocked(FIsLocked);
		student.setFQuXiang(FQuXiang);
		student.setFRewardPunish(FRewardPunish);
		student.setFStudentAddress(FStudentAddress);
		student.setFStudentBirthday(FStudentBirthday);
		student.setFStudentDormitory(FStudentDormitory);
		student.setFStudentEmail(FStudentEmail);
		student.setFStudentIdCard(FStudentIdCard);
		student.setFStudentMajor(FStudentMajor);
		student.setFStudentNation(FStudentNation);
		student.setFStudentNativeplace(FStudentNativeplace);
		student.setFStudentPoliStatus(FStudentPoliStatus);
		student.setFStudentPostcode(FStudentPostcode);
		student.setFStudentRegData(FStudentRegData);
		student.setFStudentTel(FStudentTel);
		xsglTabStudentsManager.updateStudent(student);
		return SUCCESS;
	}

	/**删除一个学生信息
	 * @return SUCCESS 删除成功
	 */
	public String deleteStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		xsglTabStudentsManager.deleteStudent((TabStudents) xsglTabStudentsManager
				.getStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}

	/**添加一个学生信息
	 * @return SUCCESS 添加成功
	 */
	public String saveStudent() {
		TabStudents student = new TabStudents();
		student.setFStudentNumber(FStudentNumber);
		student.setFStudentName(FStudentName);
		student.setFStudentSex(FStudentSex);
		student.setTabClasses(tabClasses);
		student.setFCardNumber(FCardNumber);
		student.setTabDirection(tabDirection);
		student.setFHomeTel(FHomeTel);
		student.setFIsLocked(FIsLocked);
		student.setFQuXiang(FQuXiang);
		student.setFRewardPunish(FRewardPunish);
		student.setFStudentAddress(FStudentAddress);
		student.setFStudentBirthday(FStudentBirthday);
		student.setFStudentDormitory(FStudentDormitory);
		student.setFStudentEmail(FStudentEmail);
		student.setFStudentIdCard(FStudentIdCard);
		student.setFStudentMajor(FStudentMajor);
		student.setFStudentNation(FStudentNation);
		student.setFStudentNativeplace(FStudentNativeplace);
		student.setFStudentPoliStatus(FStudentPoliStatus);
		student.setFStudentPostcode(FStudentPostcode);
		student.setFStudentRegData(FStudentRegData);
		student.setFStudentTel(FStudentTel);
		xsglTabStudentsManager.saveStudent(student);
		return SUCCESS;
	}

	/**按学号获取学生信息
	 * @return SUCCESS 获取成功
	 */
	public String showStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("student", (TabStudents) xsglTabStudentsManager
				.getStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}

	/**按学生学号或姓名获取学生信息
	 * @return SUCCESS 获取成功
	 */
	public String selectStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//按学号获取
		if (way.equals("number")) {
			String stuNum = attribute;
			List<TabStudents> list = (List<TabStudents>) xsglTabStudentsManager
					.getStudentByStuNum(stuNum);
			request.setAttribute("classstudentlist", list);
		} 
		//按姓名获取
		else if (way.equals("name")) {
			String stuName = attribute;
			request.setAttribute("classstudentlist", xsglTabStudentsManager
					.getStudentByStuName(stuName));
		}
		return SUCCESS;
	}

	/**按班级获取学生信息
	 * @return SUCCESS 获取成功
	 */
	public String showClassStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String classnumber = request.getParameter("cid");
		request.setAttribute("classstudentlist", xsglTabStudentsManager
				.getStudentListByClass(classnumber));
		// List list = tabStudentsManager.getStudentsList();
		// Map request = (Map) ActionContext.getContext().get("request");
		// request.put("studentsList", list);
		return SUCCESS;
	}
	
	
    /**按年级获取学生信息
     * @return SUCCESS 获取成功
     */
    public String getStudentByGrade(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	Map session =(Map)ActionContext.getContext().get("session");
    	TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabStudentsManager.getStudentListByGrade(gradeId);
		
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("studentAll", list_all);
		request.setAttribute("studentList",list_current );
		return SUCCESS;
}
    
    
    /**前翻页
     * @return SUCCESS 翻页成功 
     */
    public String gradeStuPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("studentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("studentList", list_current);
		
		return SUCCESS;
	}
	/**后翻页
	 * @return SUCCESS 翻页成功
	 */
	public String gradeStuNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("studentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("studentList", list_current);
		
		return SUCCESS;
	}


	/**获取学生基本信息
	 * @return SUCCESS 获取成功
	 */ 
	public String showStudentArchives(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("student", (TabStudents) xsglTabStudentsManager
				.getStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}


}
