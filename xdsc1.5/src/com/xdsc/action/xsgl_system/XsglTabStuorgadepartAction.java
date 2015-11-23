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

/**ѧ����֯��Ա��Ϣ
 * @author ������
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
	
	/**���һ����Ա��Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	 */
	public String saveOrgStu(){
		XsglTabStuorgadepart student = new XsglTabStuorgadepart();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//ѧ�������ڣ����ʧ��
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		xsglTabDepartment = (XsglTabDepartment)xsglTabDepartmentManager.getDepartmentById(FDid);
		//���Ų����ڣ����ʧ��
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
	
	/**Ԥ����һ����Ա��Ϣ
	 * @return SUCCESS ȷ�����¶���
	 */
	public String preUpdateOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		request.setAttribute("student", xsglTabStuorgadepartManager.getStuorgdepById(fid));
		return SUCCESS;
	}
	
	/**����һ����Ա��Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	 */
	public String updateOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		XsglTabStuorgadepart student = xsglTabStuorgadepartManager.getStuorgdepById(fid);
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//ѧ�������ڣ����ʧ��
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		xsglTabDepartment = (XsglTabDepartment)xsglTabDepartmentManager.getDepartmentById(FDid);
		//���Ų����ڣ����ʧ��
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
	
	/**ɾ��һ����Ա��Ϣ
	 * @return SUCCESS ɾ���ɹ�
	 */
	public String deleteOrgStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fid = Integer.parseInt(request.getParameter("fid"));
		xsglTabStuorgadepartManager.deleteStudent(xsglTabStuorgadepartManager.getStuorgdepById(fid));
		return SUCCESS;
	}
	
	/**��ȡ����ѧ����֯��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
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
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
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
	/**��ȡѧ�������г�Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("ѧ����"));
		return SUCCESS;
	}
	
	/**��ȡ��Э���г�Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("��Э"));
		return SUCCESS;
	}
	/**��ȡ��ί���г�Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
		request.setAttribute("departmentList", xsglTabDepartmentManager.getDepartmentByOName("��ί"));
		return SUCCESS;
	}
	
	
	/**��ѧ���Ჿ�����ƻ�ȡ��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getStudentByDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	/**����Э�������ƻ�ȡ��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getStudentByKXDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByKXDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	/**����ί�������ƻ�ȡ��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getStudentByTWDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = xsglTabStuorgadepartManager.getStudentByTWDepartment(dname);
		request.setAttribute("studentList", list);
		return SUCCESS;
	}
	
	/**���������ƻ�ȡ��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
	
	/**��ѧ��ѧ�Ż�������ȡѧ����֯��Ա��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String selectDepStudentByStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//��ѧ�Ż�ȡ
		if (way.equals("number")) {
			String stuNum = attribute;
			List list = xsglTabStuorgadepartManager.getStuOrgByStuNum(stuNum);
			request.setAttribute("studentList", list);
		} 
		//��������ȡ
		else if (way.equals("name")) {
			String stuName = attribute;
			request.setAttribute("studentList", xsglTabStuorgadepartManager.getStuOrgByStuName(stuName));
		}
		return SUCCESS;
	}
	

}
