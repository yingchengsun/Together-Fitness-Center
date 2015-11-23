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

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;

import com.xdsc.model.TabUndergraduate;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.service.xsgl_system.XsglTabStudentsManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.service.xsgl_system.XsglTabUndergraduateManager;
import com.xdsc.util.PageListHolder;

/**��������Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabUndergraduateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabUndergraduateManager xsglTabUndergraduateManager;
	private XsglTabStudentsManager xsglTabStudentsManager;
	private XsglTabTeachersManager xsglTabTeachersManager;
	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabGradeManager xsglTabGradeManager;
	
	private String FStudentNumber;
	private MhqxTabUser mhqxTabUser;
	private TabStudents tabStudents;
	private String FStudentHighSchool;
	private String FStudentHscore;
	private String FStudentHrank;
	private String FIsFirstChoice;
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
	
	public String getFClassNumber() {
		return FClassNumber;
	}
	public void setFClassNumber(String fClassNumber) {
		FClassNumber = fClassNumber;
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
	public void setFStudentName(String fStudentName) {
		FStudentName = fStudentName;
	}
	public String getFStudentSex() {
		return FStudentSex;
	}
	public void setFStudentSex(String fStudentSex) {
		FStudentSex = fStudentSex;
	}
	public Date getFStudentBirthday() {
		return FStudentBirthday;
	}
	public void setFStudentBirthday(Date fStudentBirthday) {
		FStudentBirthday = fStudentBirthday;
	}
	public String getFStudentNation() {
		return FStudentNation;
	}
	public void setFStudentNation(String fStudentNation) {
		FStudentNation = fStudentNation;
	}
	public Date getFStudentRegData() {
		return FStudentRegData;
	}
	public void setFStudentRegData(Date fStudentRegData) {
		FStudentRegData = fStudentRegData;
	}
	public String getFStudentTel() {
		return FStudentTel;
	}
	public void setFStudentTel(String fStudentTel) {
		FStudentTel = fStudentTel;
	}
	public String getFStudentEmail() {
		return FStudentEmail;
	}
	public void setFStudentEmail(String fStudentEmail) {
		FStudentEmail = fStudentEmail;
	}
	public String getFStudentPostcode() {
		return FStudentPostcode;
	}
	public void setFStudentPostcode(String fStudentPostcode) {
		FStudentPostcode = fStudentPostcode;
	}
	public String getFStudentNativeplace() {
		return FStudentNativeplace;
	}
	public void setFStudentNativeplace(String fStudentNativeplace) {
		FStudentNativeplace = fStudentNativeplace;
	}
	public String getFHomeTel() {
		return FHomeTel;
	}
	public void setFHomeTel(String fHomeTel) {
		FHomeTel = fHomeTel;
	}
	public String getFStudentAddress() {
		return FStudentAddress;
	}
	public void setFStudentAddress(String fStudentAddress) {
		FStudentAddress = fStudentAddress;
	}
	public String getFStudentPoliStatus() {
		return FStudentPoliStatus;
	}
	public void setFStudentPoliStatus(String fStudentPoliStatus) {
		FStudentPoliStatus = fStudentPoliStatus;
	}
	public String getFStudentDormitory() {
		return FStudentDormitory;
	}
	public void setFStudentDormitory(String fStudentDormitory) {
		FStudentDormitory = fStudentDormitory;
	}
	public String getFStudentMajor() {
		return FStudentMajor;
	}
	public void setFStudentMajor(String fStudentMajor) {
		FStudentMajor = fStudentMajor;
	}
	public String getFRewardPunish() {
		return FRewardPunish;
	}
	public void setFRewardPunish(String fRewardPunish) {
		FRewardPunish = fRewardPunish;
	}
	private String way;
	private String attribute;
	
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
	public XsglTabUndergraduateManager getXsglTabUndergraduateManager() {
		return xsglTabUndergraduateManager;
	}
	public void setXsglTabUndergraduateManager(
			XsglTabUndergraduateManager xsglTabUndergraduateManager) {
		this.xsglTabUndergraduateManager = xsglTabUndergraduateManager;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public String getFStudentHighSchool() {
		return FStudentHighSchool;
	}
	public void setFStudentHighSchool(String studentHighSchool) {
		FStudentHighSchool = studentHighSchool;
	}
	public String getFStudentHscore() {
		return FStudentHscore;
	}
	public void setFStudentHscore(String studentHscore) {
		FStudentHscore = studentHscore;
	}
	public String getFStudentHrank() {
		return FStudentHrank;
	}
	public void setFStudentHrank(String studentHrank) {
		FStudentHrank = studentHrank;
	}
	
	public XsglTabStudentsManager getXsglTabStudentsManager() {
		return xsglTabStudentsManager;
	}
	public void setXsglTabStudentsManager(
			XsglTabStudentsManager xsglTabStudentsManager) {
		this.xsglTabStudentsManager = xsglTabStudentsManager;
	}
	public String getFIsFirstChoice() {
		return FIsFirstChoice;
	}
	public void setFIsFirstChoice(String isFirstChoice) {
		FIsFirstChoice = isFirstChoice;
	}
	public XsglTabTeachersManager getXsglTabTeachersManager() {
		return xsglTabTeachersManager;
	}
	public void setXsglTabTeachersManager(
			XsglTabTeachersManager xsglTabTeachersManager) {
		this.xsglTabTeachersManager = xsglTabTeachersManager;
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
	
	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}
	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}
	
	
	/** ��ȡ���б�������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getUndergraduateList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabUndergraduateManager.getUndergraduateList();
		
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("undergraduateAll", list_all);
		request.setAttribute("undergraduateList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getUndergraClassList());
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	 public String ungraPrevious(){
			Map request = (Map) ActionContext.getContext().get("request");
			Map session =(Map)ActionContext.getContext().get("session");
			
			PageListHolder list_all =(PageListHolder) session.get("undergraduateAll");
			list_all.previousPage();
			List list_current = list_all.getPageList();
			request.put("undergraduateList", list_current);
			
			return SUCCESS;
		}
	 /** ��ҳ
		 * @return SUCCESS ��ҳ�ɹ�
		*/
		public String ungraNext(){
			Map request = (Map) ActionContext.getContext().get("request");
			Map session =(Map)ActionContext.getContext().get("session");
			
			PageListHolder list_all =(PageListHolder) session.get("undergraduateAll");
			list_all.nextPage();
			List list_current = list_all.getPageList();
			request.put("undergraduateList", list_current);
			
			return SUCCESS;
		}
		/** ��ѧ�Ż�ȡĳ����������Ϣ
		 * @return SUCCESS ��ȡ�ɹ�
		*/
	public String showUndergraduate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
	    request.setAttribute("undergraduate", (TabUndergraduate) xsglTabUndergraduateManager.getUndergraduateByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	/** ���꼶��ȡ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getUndergraduateListByGrade(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		int gradeid = Integer.parseInt(request.getParameter("gid"));
		List list = xsglTabUndergraduateManager.getUndergraduateByGrade(gradeid);
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("undergraduateAll", list_all);
		request.setAttribute("undergraduateList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassByGradeId(gradeid));
		return SUCCESS;
	}
	/** ���һ����������Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String saveUndergraduate(){
		TabUndergraduate undergraduate = new TabUndergraduate();
		List list = xsglTabStudentsManager.getStudentByStuNum(FStudentNumber);
		//ѧ����¼Ϊ�գ������
		if(list.isEmpty()){
			tabStudents = new TabStudents();
			tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
			//�༶�����ڣ����ʧ��
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
		    undergraduate.setFStudentNumber(FStudentNumber);
		    undergraduate.setTabStudents(tabStudents);
		    undergraduate.setFStudentHighSchool(FStudentHighSchool);
		    undergraduate.setFStudentHscore(FStudentHscore);
		    undergraduate.setFStudentHrank(FStudentHrank);
		    undergraduate.setFIsFirstChoice(FIsFirstChoice);
		    xsglTabUndergraduateManager.saveUndergraduate(undergraduate);
		return SUCCESS;
		}else return INPUT;
	}
	/** ɾ��һ����������Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteUndergraduate(){
		HttpServletRequest request=ServletActionContext.getRequest();
		TabUndergraduate undergraduate=xsglTabUndergraduateManager.getUndergraduateByStuNum(request.getParameter("id")).get(0);
		xsglTabUndergraduateManager.deleteUndergraduate(undergraduate);
		return SUCCESS;
	}
	/** Ԥ����ĳ����������Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateUndergraduate(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String stuNum=request.getParameter("id");
		request.setAttribute("undergraduate", xsglTabUndergraduateManager.getUndergraduateByStuNum(stuNum).get(0));
		return SUCCESS;
	}
	/** ����ĳ����������Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updateUndergraduate(){
		TabUndergraduate undergraduate=xsglTabUndergraduateManager.getUndergraduateByStuNum(FStudentNumber).get(0);
		tabStudents=(TabStudents)xsglTabStudentsManager.getStudentByStuNum(FStudentNumber).get(0);
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		//�༶�����ڣ�����ʧ��
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
		xsglTabStudentsManager.updateStudent(tabStudents);
		undergraduate.setFStudentNumber(FStudentNumber);
//		undergraduate.setTabStudents(tabStudents);
		undergraduate.setFStudentHighSchool(FStudentHighSchool);
		undergraduate.setFStudentHscore(FStudentHscore);
		undergraduate.setFStudentHrank(FStudentHrank);
		undergraduate.setFIsFirstChoice(FIsFirstChoice);
		xsglTabUndergraduateManager.updateUndergraduate(undergraduate);
		return SUCCESS;
	}
	/**��ѧ��ѧ�Ż�������ȡ��������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String selectUndergraduateByStu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//��ѧ�Ż�ȡ
		if (way.equals("number")) {
			String stuNum = attribute;
			List list =  xsglTabUndergraduateManager.getUndergraduateByStuNum(stuNum);
			request.setAttribute("undergraduateList", list);
		} 
		//��������ȡ
		else if (way.equals("name")) {
			String stuName = attribute;
			request.setAttribute("undergraduateList", xsglTabUndergraduateManager.getUndergraduateByStuName(stuName));
		}
		return SUCCESS;
	}
}
