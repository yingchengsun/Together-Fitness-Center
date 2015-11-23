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
 * 类功能：研究生个人信息(个人，导师，公司)查看与修改
 * @author 许鑫
 * @version 1.1
 */
public class PostgraudateSelfInfoAction extends ActionSupport implements  SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private TabPostgraduate postgraduateSelfInfo;    //用于显示研究生个人信息
	
	/**
	 * 研究生的公司和导师
	 */
	private TabCompany companyInfo;
	
	private TabTeachers teacherInfo;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	/**
	 * 研究生只能修改自己的电话和邮箱
	 */
	private String email;
	
	private String phone;
	
	/**
	 * 修改个人信息
	 * @return 返回修改以前的旧数据
	 */
	public String preModifySelfInfo(){      //修改个人信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		return "preModifySelfInfo";
	}
	
	/**
	 * 研究生修改个人信息
	 * @return 修改个人信息成功
	 */
	public String ModifySelfInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabStudents student=postgraduateInfoService.findStudentById(FUserNumber);
		student.setFStudentEmail(email);
		student.setFStudentTel(phone);
		postgraduateInfoService.updateStudent(student);
		return "ModifySelfInfo";
	}
	
	/**
	 * 显示研究生的个人信息
	 * @return 返回研究生个人信息
	 */
	public String findPostgraduateInfo(){        //显示研究生的个人信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		return "findPostgraduateInfo";
	}
	
	/**
	 * 显示研究生的公司的信息
	 * @return 返回研究生的公司的信息
	 */
	public String findCompanyInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		postgraduateSelfInfo= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		companyInfo=postgraduateSelfInfo.getTabCompany();
		if(companyInfo==null){
			return "CompanyNotConfirm";
		}
		return "findCompanyInfo";
	}
	
	/**
	 * 显示研究生的导师的信息
	 * @return 返回研究生的导师的信息
	 */
    public String findTutorInfo(){
    	FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
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
