package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;

/**
 * �๦�ܣ��о���������Ϣ(���ˣ���ʦ����˾)�鿴���޸�
 * @author ����
 * @version 1.1
 */
public class PostgraudateSelfInfoAction extends ActionSupport implements  SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private TabPostgraduate postgraduateSelfInfo;    //������ʾ�о���������Ϣ
	
	/**
	 * �о����Ĺ�˾�͵�ʦ
	 */
	private TabCompany companyInfo;
	
	private TabTeachers teacherInfo;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	/**
	 * �о���ֻ���޸��Լ��ĵ绰������
	 */
	private String email;
	
	private String phone;
	
	/**
	 * �޸ĸ�����Ϣ
	 * @return �����޸���ǰ�ľ�����
	 */
	public String preModifySelfInfo(){      //�޸ĸ�����Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		return "preModifySelfInfo";
	}
	
	/**
	 * �о����޸ĸ�����Ϣ
	 * @return �޸ĸ�����Ϣ�ɹ�
	 */
	public String ModifySelfInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		TabStudents student=postgraduateInfoService.findStudentById(FUserNumber);
		student.setFStudentEmail(email);
		student.setFStudentTel(phone);
		postgraduateInfoService.updateStudent(student);
		return "ModifySelfInfo";
	}
	
	/**
	 * ��ʾ�о����ĸ�����Ϣ
	 * @return �����о���������Ϣ
	 */
	public String findPostgraduateInfo(){        //��ʾ�о����ĸ�����Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		return "findPostgraduateInfo";
	}
	
	/**
	 * ��ʾ�о����Ĺ�˾����Ϣ
	 * @return �����о����Ĺ�˾����Ϣ
	 */
	public String findCompanyInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		companyInfo=postgraduateSelfInfo.getTabCompany();
		if(companyInfo==null){
			return "CompanyNotConfirm";
		}
		return "findCompanyInfo";
	}
	
	/**
	 * ��ʾ�о����ĵ�ʦ����Ϣ
	 * @return �����о����ĵ�ʦ����Ϣ
	 */
    public String findTutorInfo(){
    	FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
    	postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
    	teacherInfo=postgraduateSelfInfo.getTabTeachers();
    	if(teacherInfo==null){
    		return "TutorNotConfirm";
    	}
		return "findTutorInfo";
	}

	public TabPostgraduate getPostgraduateSelfInfo() {
		return postgraduateSelfInfo;
	}

	public void setPostgraduateSelfInfo(TabPostgraduate postgraduateSelfInfo) {
		this.postgraduateSelfInfo = postgraduateSelfInfo;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public TabCompany getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(TabCompany companyInfo) {
		this.companyInfo = companyInfo;
	}

	public TabTeachers getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TabTeachers teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

}
