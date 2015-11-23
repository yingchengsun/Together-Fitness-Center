package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabParentsManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.util.PageListHolder;

/**学生家长信息
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabParentsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private XsglTabParentsManager xsglTabParentsManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	
	private String FParentId;
	private TabStudents tabStudents;
	private MhqxTabUser mhqxTabUser;
	private String FParentName;
	private String FStudentNumber;
	private String FStudentName;
	
	
	private String way;
	private String attribute;
	
	public XsglTabParentsManager getXsglTabParentsManager() {
		return xsglTabParentsManager;
	}
	public void setXsglTabParentsManager(XsglTabParentsManager xsglTabParentsManager) {
		this.xsglTabParentsManager = xsglTabParentsManager;
	}
	public String getFParentId() {
		return FParentId;
	}
	public void setFParentId(String parentId) {
		FParentId = parentId;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}
	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}
	public String getFParentName() {
		return FParentName;
	}
	public void setFParentName(String parentName) {
		FParentName = parentName;
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
	public String getFStudentName() {
		return FStudentName;
	}
	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}
	
	
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
	
	/** 添加一个家长
	 * @return SUCCESS 添加成功
	 * @return INPUT 添加失败
	*/
	public String saveParent(){
		XsglTabParents parent = new XsglTabParents();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
        //学生不存在，添加失败
		if(list.isEmpty())return INPUT;
		else{
		tabStudents=(TabStudents)list.get(0);
		parent.setFParentId(FParentId);
		parent.setFParentName(FParentName);
		parent.setTabStudents(tabStudents);
		xsglTabParentsManager.saveParent(parent);
		return SUCCESS;
		}
	}
	/** 删除一个家长
	 * @return SUCCESS 删除成功
	*/
	public String deleteParent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String Pid = request.getParameter("pid");
		xsglTabParentsManager.deleteParent(xsglTabParentsManager.getParentById(Pid));
		return SUCCESS;
	}
	/** 预更新某学生家长信息
	 * @return SUCCESS 确定更新对象
	*/
	public String preUpdateParent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String Pid = request.getParameter("pid");
		request.setAttribute("parent", xsglTabParentsManager.getParentById(Pid));
		return SUCCESS;
	}
	/** 更新某学生家长信息
	 * @return SUCCESS 更新成功
	 * @return INPUT 更新失败
	*/
	public String updateParent(){
		XsglTabParents parent = xsglTabParentsManager.getParentById(FParentId);
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
        //学生不存在，添加失败
		if(list.isEmpty())return INPUT;
		else{
	    tabStudents = (TabStudents)list.get(0);
		parent.setFParentId(FParentId);
		parent.setFParentName(FParentName);
		parent.setTabStudents(tabStudents);
		xsglTabParentsManager.updateParent(parent);
		return SUCCESS;
		}
	}
	/** 获取所有学生家长信息
	 * @return SUCCESS 获取成功
	*/
	public String getParentList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabParentsManager.getParentList();
		
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("parentAll", list_all);
		request.setAttribute("parentList", list_current);
		return SUCCESS;
	}
	
	/**前翻页
	 * @return 翻页成功
	 */
	public String parentPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("parentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("parentList", list_current);
		
		return SUCCESS;
	}
	/**后翻页
	 * @return 翻页成功
	 */
	public String parentNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("parentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("parentList", list_current);
		
		return SUCCESS;
	}
	
	/**按家长ID获取学生家长信息
	 * @return SUCCESS 获取成功
	 */
	public String getParentByPId(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents parent = (XsglTabParents)session.get("parent");
		request.setAttribute("parent",parent);
		return SUCCESS;
	}
	
	/**按学生学号或姓名或家长ID或姓名获取学生家长信息
	 * @return SUCCESS 获取成功
	 */
	public String selectParent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//按学生学号获取
		if(way.equals("stuNum")){
			String stuNum = attribute;
			List<XsglTabParents> list=xsglTabParentsManager.getParentByStuNum(stuNum);
			request.setAttribute("parentList", list);
		} 
		//按学生姓名获取
		else if(way.equals("stuName")){
			String stuName=attribute;
			List<XsglTabParents> list=xsglTabParentsManager.getParentByStuName(stuName);
			request.setAttribute("parentList", list);
		}
		//按家长ID获取
		else if(way.equals("parentNum")){
			String parentNum=attribute;
			List<XsglTabParents> list=xsglTabParentsManager.getParentByPNum(parentNum);
			request.setAttribute("parentList", list);
		}
		//按家长姓名获取
		else if(way.equals("parentName")){
			String parentName=attribute;
			List<XsglTabParents> list=xsglTabParentsManager.getParentByPName(parentName);
			request.setAttribute("parentList", list);
		}
		return SUCCESS;
	}

}
