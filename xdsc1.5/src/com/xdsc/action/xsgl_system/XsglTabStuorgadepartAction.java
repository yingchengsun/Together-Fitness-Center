package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabStudents;
import com.xdsc.model.XsglTabDepartment;
import com.xdsc.model.XsglTabOrganizations;
import com.xdsc.model.XsglTabStuorgadepart;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabDepartmentManager;
import com.xdsc.service.xsgl_system.XsglTabOrganizationsManager;
import com.xdsc.service.xsgl_system.XsglTabStuorgadepartManager;
import com.xdsc.util.PageListHolder;

/**学生组织成员信息
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabStuorgadepartAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabStuorgadepartManager xsglTabStuorgadepartManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabDepartmentManager xsglTabDepartmentManager;
	
	
	private Integer FDid;
	private String FDname;
	private Integer FId;
	private XsglTabDepartment xsglTabDepartment;
	private XsglTabOrganizations xsglTabOrganizations;
	private TabStudents tabStudents;
	private String FPosition;
	private String FStudentNumber;
	private String FClassNumber;
	
	private String way;
	private String attribute;
	
	private int dname;
	
	public int getDname() {
		return dname;
	}
	public void setDname(int dname) {
		this.dname = dname;
	}
	public XsglTabStuorgadepartManager getXsglTabStuorgadepartManager() {
		return xsglTabStuorgadepartManager;
	}
	public void setXsglTabStuorgadepartManager(
			XsglTabStuorgadepartManager xsglTabStuorgadepartManager) {
		this.xsglTabStuorgadepartManager = xsglTabStuorgadepartManager;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer fId) {
		FId = fId;
	}
	public XsglTabDepartment getXsglTabDepartment() {
		return xsglTabDepartment;
	}
	public void setXsglTabDepartment(XsglTabDepartment xsglTabDepartment) {
		this.xsglTabDepartment = xsglTabDepartment;
	}
	public XsglTabOrganizations getXsglTabOrganizations() {
		return xsglTabOrganizations;
	}
	public void setXsglTabOrganizations(XsglTabOrganizations xsglTabOrganizations) {
		this.xsglTabOrganizations = xsglTabOrganizations;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public String getFPosition() {
		return FPosition;
	}
	public void setFPosition(String fPosition) {
		FPosition = fPosition;
	}
	
	public String getFDname() {
		return FDname;
	}
	public void setFDname(String dname) {
		FDname = dname;
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
	public XsglTabDepartmentManager getXsglTabDepartmentManager() {
		return xsglTabDepartmentManager;
	}
	public void setXsglTabDepartmentManager(
			XsglTabDepartmentManager xsglTabDepartmentManager) {
		this.xsglTabDepartmentManager = xsglTabDepartmentManager;
	}
	public Integer getFDid() {
		return FDid;
	}
	public void setFDid(Integer did) {
		FDid = did;
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
	
	/**添加一个成员信息
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入值有错，添加失败
	 */
	public String saveOrgStu(){
		XsglTabStuorgadepart student = new XsglTabStuorgadepart();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//学生不存在，添加失败
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		xsglTabDepartment = (XsglTabDepartment)xsglTabDepartmentManager.getDepartmentById(FDid);
		//部门不存在，添加失败
		if(xsglTabDepartment==null) return INPUT;
		else{
		student.setTabStudents(tabStudents);
		student.setXsglTabDepartment(xsglTabDepartment);
		student.setFPosition(FPosition);
		xsglTabStuorgadepartManager.saveStudent(student);
		return SUCCESS;
		}
		}
	}
	
	/**预更新一个成员信息
	 * @return SUCCESS 确定更新对象
	 */
	public String preUpdateOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		request.setAttribute("student", xsglTabStuorgadepartManager.getStuorgdepById(fid));
		return SUCCESS;
	}
	
	/**更新一个成员信息
	 * @return SUCCESS 更新成功
	 * @return INPUT 输入值有错，更新失败
	 */
	public String updateOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		XsglTabStuorgadepart student = xsglTabStuorgadepartManager.getStuorgdepById(fid);
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//学生不存在，添加失败
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		xsglTabDepartment = (XsglTabDepartment)xsglTabDepartmentManager.getDepartmentById(FDid);
		//部门不存在，添加失败
		if(xsglTabDepartment==null) return INPUT;
		else{
		student.setTabStudents(tabStudents);
		student.setXsglTabDepartment(xsglTabDepartment);
		student.setFPosition(FPosition);
		xsglTabStuorgadepartManager.updateStudent(student);
		return SUCCESS;
		}
		}
	}
	
	/**删除一个成员信息
	 * @return SUCCESS 删除成功
	 */
	public String deleteOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		xsglTabStuorgadepartManager.deleteStudent(xsglTabStuorgadepartManager.getStuorgdepById(fid));
		return SUCCESS;
	}
	
	/**获取所有学生组织成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getOrgStudentList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabStuorgadepartManager.getStudentList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("studentAll", list_all);
		
		request.setAttribute("studentList", list_current);
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentList());
		return SUCCESS;
	}
	/** 前翻页
	 * @return SUCCESS 前翻页成功
	*/
	public String orgStuPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("studentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("studentList", list_current);
		
		return SUCCESS;
	}
	/** 后翻页
	 * @return SUCCESS 后翻页成功
	*/
	public String orgStuNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("studentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("studentList", list_current);
		
		return SUCCESS;
	}
	/**获取学生会所有成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByStudentUnion(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabStuorgadepartManager.getStudentByStudentUnion();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("studentAll", list_all);
		request.setAttribute("studentList", list_current);
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("学生会"));
		return SUCCESS;
	}
	
	/**获取科协所有成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByKeXie(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabStuorgadepartManager.getStudentByKeXie();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("studentAll", list_all);
		request.setAttribute("studentList", list_current);
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("科协"));
		return SUCCESS;
	}
	/**获取团委所有成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByTuanWei(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabStuorgadepartManager.getStudentByTuanWei();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("studentAll", list_all);
		request.setAttribute("studentList", list_current);
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("团委"));
		return SUCCESS;
	}
	
	
	/**按学生会部门名称获取成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	/**按科协部门名称获取成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByKXDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByKXDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	/**按团委部门名称获取成员信息
	 * @return SUCCESS 获取成功
	 */
	public String getStudentByTWDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByTWDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	
	/**按部门名称获取成员信息
	 * @return SUCCESS 获取成功
	 */
	public String selectStudentByOrgDep(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByOrgDep(dname);
		Map session =(Map)ActionContext.getContext().get("session");
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("studentAll", list_all);
		request.setAttribute("studentList", list_current);
		return SUCCESS;
	}
	
	/**按学生学号或姓名获取学生组织成员信息
	 * @return SUCCESS 获取成功
	 */
	public String selectDepStudentByStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//按学号获取
		if (way.equals("number")) {
			String stuNum = attribute;
			List list = xsglTabStuorgadepartManager.getStuOrgByStuNum(stuNum);
			request.setAttribute("studentList", list);
		} 
		//按姓名获取
		else if (way.equals("name")) {
			String stuName = attribute;
			request.setAttribute("studentList", xsglTabStuorgadepartManager.getStuOrgByStuName(stuName));
		}
		return SUCCESS;
	}
	

}
