package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabParents;
import com.xdsc.model.XsglTabParty;
import com.xdsc.model.XsglTabPartygather;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.service.xsgl_system.XsglTabPartygatherManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabPartyManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.util.PageListHolder;

/**ѧ��������ϸ��Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabPartyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabPartyManager xsglTabPartyManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabGradeManager xsglTabGradeManager;
	private XsglTabTeachersManager xsglTabTeachersManager;
	private XsglTabPartygatherManager xsglTabPartygatherManager;
	
	
	private Integer FId;
	private TabStudents tabStudents;
	private String FYear;
	private String FName;
	private String FStudentNumber;
	
	private String year;
	private String classid;
	private int status;
	
	public XsglTabPartygatherManager getXsglTabPartygatherManager() {
		return xsglTabPartygatherManager;
	}
	public void setXsglTabPartygatherManager(
			XsglTabPartygatherManager xsglTabPartygatherManager) {
		this.xsglTabPartygatherManager = xsglTabPartygatherManager;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public XsglTabPartyManager getXsglTabPartyManager() {
		return xsglTabPartyManager;
	}
	public void setXsglTabPartyManager(XsglTabPartyManager xsglTabPartyManager) {
		this.xsglTabPartyManager = xsglTabPartyManager;
	}
	
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public String getFYear() {
		return FYear;
	}
	public void setFYear(String year) {
		FYear = year;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String name) {
		FName = name;
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
	
	
	/** ���һ��ѧ��������Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String savePartyMember(){
		XsglTabParty partyMember = new XsglTabParty();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		partyMember.setFName(FName);
		partyMember.setFYear(FYear);
		partyMember.setTabStudents(tabStudents);
		xsglTabPartyManager.savePartyMember(partyMember);
		return SUCCESS;
		}
	}
	/** ɾ��һ��ѧ��������Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deletePartyMember(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fId = Integer.parseInt(request.getParameter("fid"));
		xsglTabPartyManager.deletePartyMember(xsglTabPartyManager.getPartyMemberByFId(fId));
		return SUCCESS;
	}
	/** Ԥ����һ��ѧ��������Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdatePartyMember(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("fid"));
		request.setAttribute("partyMember", xsglTabPartyManager.getPartyMemberByFId(FId));
		return SUCCESS;
	}
	/** ����һ��ѧ��������Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updatePartyMember(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int partyID = Integer.parseInt(request.getParameter("partyID"));
		XsglTabParty partyMember = xsglTabPartyManager.getPartyMemberByFId(partyID);
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		if(list.isEmpty()) return INPUT;
		else{
		tabStudents = (TabStudents)list.get(0);
		partyMember.setFName(FName);
		partyMember.setFYear(FYear);
		partyMember.setTabStudents(tabStudents);
		xsglTabPartyManager.updatePartyMember(partyMember);
		return SUCCESS;
		}
	}
	/** ��ȡ����ѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("partyStuList", xsglTabPartyManager.getPartyMemberList());
		return SUCCESS;
	} 
	/** ��������ƻ�ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberByFName(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("partyStuList", xsglTabPartyManager.getPartyMemberByFName(FName));
		return SUCCESS;
	}
	/** ��ѧ��ѧ�Ż�ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberByStuNum(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String StuNum=request.getParameter("id");
		request.setAttribute("partyStuList", xsglTabPartyManager.getPartyMemberByStuNum(StuNum));
		return SUCCESS;
		}
	/** ���꼶��ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberListByGrade(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		TabTeachers t = (TabTeachers)session.get("teacher");
    	int gradeId = t.getTabGrade().getFGradeId();
		
		List list = xsglTabPartyManager.getPartyMemberListByGrade(gradeId);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("partyStuAll", list_all);
		request.setAttribute("partyStuList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassByGradeId(gradeId));
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String gradePartyPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partyStuAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("partyStuList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String gradePartyNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partyStuAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("partyStuList", list_current);
		
		return SUCCESS;
	}
	/** ���༶����ݼ�������ƻ�ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberListByClassAndName(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		int FId=Integer.parseInt(request.getParameter("id"));
		XsglTabPartygather party = xsglTabPartygatherManager.getPartyByFId(FId);
		String classid= party.getTabClasses().getFClassNumber();
		String name=party.getFName();
		String year = party.getFYear();
		List list = xsglTabPartyManager.getPartyMemberByNameYearAndClass(year, classid, name);
		
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("partyStuAll", list_all);
		request.setAttribute("partyStuList", list_current);
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String partyStuPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partyStuAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("partyStuList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String partyStuNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partyStuAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("partyStuList", list_current);
		
		return SUCCESS;
	}
	
	/** ���༶��ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberListByClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		XsglTabParents p = (XsglTabParents)session.get("parent");
		String classid = p.getTabStudents().getTabClasses().getFClassNumber();
		List list = xsglTabPartyManager.getPartyMemberByClass(classid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("partyStuAll", list_all);
		request.setAttribute("studentsList", list_current);
		return SUCCESS;
	}
	/** ���꼶��������Ƽ���ݻ�ȡѧ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyMemberByNameYearClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String status_str = null;
		switch(status){
		case 0: status_str="��Ա";break;
		case 1: status_str="Ԥ����Ա";break;
		case 2: status_str="��Ա��չ����";break;
		case 3: status_str="�뵳��������";break;
		default:status_str=" ";break;
		}
		request.setAttribute("partyStuList", xsglTabPartyManager.getPartyMemberByNameYearAndClass(year, classid, status_str));
		return SUCCESS;
	}
}
