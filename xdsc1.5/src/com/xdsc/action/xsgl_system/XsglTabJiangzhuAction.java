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

import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabJiangzhu;
import com.xdsc.model.XsglTabJiangzhugather;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabJiangzhugatherManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabJiangzhuManager;
import com.xdsc.util.PageListHolder;

/**资助及奖学金详细信息
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabJiangzhuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabJiangzhuManager xsglTabJiangzhuManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabJiangzhugatherManager xsglTabJiangzhugatherManager;
	private XsglTabClassesManager xsglTabClassesManager;
	
	private Integer FId;
	private TabStudents tabStudents;
	private String FName;
	private String FYear;
	private Integer FAmount;
	private String FStudentNumber;
	

	private String classid;
	private String year;
	private String stuNum;
	private String way;
	private String attribute;



	
	public XsglTabClassesManager getXsglTabClassesManager() {
		return xsglTabClassesManager;
	}
	public void setXsglTabClassesManager(XsglTabClassesManager xsglTabClassesManager) {
		this.xsglTabClassesManager = xsglTabClassesManager;
	}
	public XsglTabJiangzhugatherManager getXsglTabJiangzhugatherManager() {
		return xsglTabJiangzhugatherManager;
	}
	public void setXsglTabJiangzhugatherManager(
			XsglTabJiangzhugatherManager xsglTabJiangzhugatherManager) {
		this.xsglTabJiangzhugatherManager = xsglTabJiangzhugatherManager;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
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
	public XsglTabJiangzhuManager getXsglTabJiangzhuManager() {
		return xsglTabJiangzhuManager;
	}
	public void setXsglTabJiangzhuManager(
			XsglTabJiangzhuManager xsglTabJiangzhuManager) {
		this.xsglTabJiangzhuManager = xsglTabJiangzhuManager;
	}

	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String name) {
		FName = name;
	}
	public String getFYear() {
		return FYear;
	}
	public void setFYear(String year) {
		FYear = year;
	}
	public Integer getFAmount() {
		return FAmount;
	}
	public void setFAmount(Integer amount) {
		FAmount = amount;
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
	/**获取所有资助及奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getFStudentList() {
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentList();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("fstudentList", list);
		return SUCCESS;
	}
	
	
	/**获取所有助学贷款信息
	 * @return SUCCESS 获取成功
	 */
	public String getFStudentListByLoan(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListByLoan();
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	
	/**获取所有助学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getFStudentListByStipend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListByStipend();
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	
	/**获取所有奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getFStudentListByScholarship(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListByScholarship();
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	

	/**按年级获取助学贷款信息
	 * @return SUCCESS 获取成功
	 */
	public String getGradeStudentByLoan(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabJiangzhuManager.getGradeStuByLoan(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	/** 前翻页
	 * @return SUCCESS 前翻页成功
	*/
	public String fundStuPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("fStudentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("fstudentList", list_current);
		
		return SUCCESS;
	}
	/** 后翻页
	 * @return SUCCESS 后翻页成功
	*/
	public String fundStuNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("fStudentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("fstudentList", list_current);
		
		return SUCCESS;
	}
	
	/**按年级获取助学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getGradeStudentByStipend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabJiangzhuManager.getGradeStuByStipend(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	
	/**按年级获取奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getGradeStudentByScholarship(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		List list = xsglTabJiangzhuManager.getGradeStuBySholarship(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	
	/**按年份及班级获取助学贷款信息
	 * @return SUCCESS 获取成功
	 */
	public String getFStudentListByOption(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListByOption(year, classid);
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	
	/**按年份及班级获取奖学金信息
	 * @return SUCCESS 获取成功
	 */ 
	public String getFStudentListBySchOption(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListBySchOption(year, classid);
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	/**按年份及班级获取助学金信息
	 * @return SUCCESS 获取成功
	 */ 
	public String getFStudentListByStiOption(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<XsglTabJiangzhu> list = xsglTabJiangzhuManager.getFStudentListByStiOption(year, classid);
		request.setAttribute("fstudentList", list);
		return SUCCESS;
	}
	
	/**删除一条资助及奖学金信息
	 * @return SUCCESS 删除成功
	 */
	public String deleteFundStudent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("id"));
		xsglTabJiangzhuManager.deleteFStudent((XsglTabJiangzhu)xsglTabJiangzhuManager.getFStudentByFid(fid));
		return SUCCESS;
	}


	/**预更新一条资助及奖学金信息
	 * @return SUCCESS 确定更新对象
	 */
	public String preUpdateFundStudent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("fstudent", (XsglTabJiangzhu) xsglTabJiangzhuManager.getFStudentByFid(fid));
		return SUCCESS;
	}
	
	/**更新一条资助及奖学金信息
	 * @return SUCCESS 更新成功
	 * @return INPUT 输入值有错，更新失败
	 */
	public String updateFundStudent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		XsglTabJiangzhu fstudent=xsglTabJiangzhuManager.getFStudentByFid(fid);
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		if(list.isEmpty()) return INPUT;
		else{
			tabStudents=(TabStudents)list.get(0);
			fstudent.setTabStudents(tabStudents);
			fstudent.setFName(FName);
			fstudent.setFYear(FYear);
			fstudent.setFAmount(FAmount);
			xsglTabJiangzhuManager.updateFStudent(fstudent);
			return SUCCESS;
		}
		}
	
	/**添加一条资助及奖学金信息
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入值错误，添加失败
	 */
	public String saveFundStudent(){
		XsglTabJiangzhu fstudent=new XsglTabJiangzhu();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents=(TabStudents)list.get(0);
		fstudent.setFName(FName);
		fstudent.setFYear(FYear);
		fstudent.setFAmount(FAmount);
		fstudent.setTabStudents(tabStudents);
		xsglTabJiangzhuManager.saveFStudent(fstudent);
		return SUCCESS;
		}
	}
	

	/**按班级获取助学贷款信息
	 * @return SUCCESS 获取成功
	 */
	public String getClassStudentByLoan(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents p = (XsglTabParents)session.get("parent");
		String classid = p.getTabStudents().getTabClasses().getFClassNumber();
		List list = xsglTabJiangzhuManager.getClassStudentByLoan(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	
	/**按班级获取助学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getClassStudentByStipend(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents p = (XsglTabParents)session.get("parent");
		String classid = p.getTabStudents().getTabClasses().getFClassNumber();
		List list = xsglTabJiangzhuManager.getClassStudentByStipend(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	
	/**按班级获取奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getClassStudentBySholarship(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents p = (XsglTabParents)session.get("parent");
		String classid = p.getTabStudents().getTabClasses().getFClassNumber();
		List list = xsglTabJiangzhuManager.getClassStudentBySholarship(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("fStudentAll", list_all);
		request.setAttribute("fstudentList", list_current);
		return SUCCESS;
	}
	
	/**按类别名称、年份及班级获取资助及奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByNYC(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("id"));
		XsglTabJiangzhugather fund = xsglTabJiangzhugatherManager.getFundById(fid);
		String classid = fund.getTabClasses().getFClassNumber();
		String name = fund.getFName();
		String year = fund.getFYear();
		request.setAttribute("fstudentList", xsglTabJiangzhuManager.getStudentListByNameYearClass(name, year, classid));
		return SUCCESS;
	}
	/**按学生学号或姓名获取资助及奖学金信息
	 * @return SUCCESS 获取成功
	 */
	public String getFundStuByStu(){
			HttpServletRequest request = ServletActionContext.getRequest();
			if (way.equals("number")) {
				String stuNum = attribute;
				List list = xsglTabJiangzhuManager.getFundStuByStuNum(stuNum);
				request.setAttribute("fstudentList", list);
			} else if (way.equals("name")) {
				String stuName = attribute;
				List list = xsglTabJiangzhuManager.getFundStuByStuName(stuName);
				request.setAttribute("fstudentList", list);
			}
			return SUCCESS;
		}
}
