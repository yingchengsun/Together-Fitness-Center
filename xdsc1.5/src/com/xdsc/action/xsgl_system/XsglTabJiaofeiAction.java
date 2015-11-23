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


/**ѧ��Ƿ����Ϣ
 * @author ������
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
	
	/** ���꼶��ȡѧ��Ƿ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
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
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
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
	/** ��ȡ����ѧ��Ƿ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
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
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
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
	
	/** ɾ��һ��ѧ��Ƿ����Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteFee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		xsglTabJiaofeiManager.deleteJStudent((XsglTabJiaofei)xsglTabJiaofeiManager.getJStudentByStuNum(stuNum).get(0));

		return SUCCESS;
	}
	/** Ԥ����һ��ѧ��Ƿ����Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateFee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		request.setAttribute("student", xsglTabJiaofeiManager.getJStudentByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	/** ����һ��ѧ��Ƿ����Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updateFee(){
		XsglTabJiaofei jstudent = xsglTabJiaofeiManager.getJStudentByStuNum(tabStudents.getFStudentNumber()).get(0);

		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//ѧ�������ڣ����ʧ��
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
	/** ���һ��ѧ��Ƿ����Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String saveFee(){
		XsglTabJiaofei jstudent = new XsglTabJiaofei();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//ѧ�������ڣ����ʧ��
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
	/** ��ѧ��ѧ�Ż�������ȡǷ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
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
	/** ����ݡ��༶��ȡѧ��Ƿ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectFeeByYear(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("jStudentList", xsglTabJiaofeiManager.getJStudentByYearClass(year, classid));
		return SUCCESS;
	}

}
