package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/** 类功能：企业实习招聘管理
 * @author 许鑫
 * @version 1.1
 *
 */
public class AdminPractingZhaoPinManageAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;

	//-------------------------------研究生搜索条件--------------------------------------
	private String studentName;
	
	private String studentSex;
	
	private String className;
	
	private String gradeName;
	
	private String studentType;
	
	/**
	 * 用于显示select选择标签的下拉选择数据
	 */
	private List<TabCompany> companyList;
	
	/**
	 * 根据公司的名称显示公司的信息
	 */
	private String ComName;
	
	private List<TabPostgraduate> studentList;
	
	/**
	 * 查询研究生企业的确定情况Y/N的条件
	 */
	private String confirmInfo;               
	
	/**
	 * 根据学生的姓名查找学生的企业实习确定情况
	 */
	private String stuName;
	
	/**
	 * 实现简单的跳转，并显示所有研究生信息
	 * @return preShowManage 跳转成功
	 */
	public String preShowManage(){  
		studentList = postgraduateInfoService.findAllStudent();
		return "preShowManage";
	}
	
	/**
	 * 根据研究生的姓名查找研究生的实习企业确定信息，student.company
	 * @return
	 */
	public String searchStudent(){	
		studentList = postgraduateInfoService.findPostgraduateByCondition(studentName, studentSex, "", "", className, gradeName, studentType, "", "","");
		return "searchStudent";
	}
	
	/**
	 * 实现简单跳转，并查找所有公司信息显示select标签的值列表
	 * @return preSearchForManage 跳转成功
	 */
	public String preSearchForManage(){
		companyList = companyInfoService.findAllCompanyInfo();             
		return "preSearchForManage";
	}
	
	/**
	 * 根据条件查找研究生信息，confirmInfo=Y查找已经确定企业的研究生，confirmInfo=N查找未确定企业的研究生
	 * @return CompanyConfirmedSearch 搜索成功
	 */
	public String CompanyConfirmedSearch(){            
		companyList = companyInfoService.findAllCompanyInfo();
		List<TabPostgraduate> stuList=postgraduateInfoService.findAllStudent();
		studentList = new ArrayList<TabPostgraduate>();
		if(confirmInfo.equals("Y")){               
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getTabCompany()!=null){
					studentList.add(stuList.get(i));
				}
			}
		}else{       
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getTabCompany()==null){
					studentList.add(stuList.get(i));
				}
			}
		}
		return "CompanyConfirmedSearch";
	}
	
	/**
	 * 根据企业的名称搜索去了该公司的所有研究生
	 * @return searchByCompanyName 查找成功
	 */
	public String searchByCompanyName(){ 
		companyList = companyInfoService.findAllCompanyInfo();
		studentList=postgraduateInfoService.findPostgraduateByComNumber(ComName);
		return "searchByCompanyName";
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getConfirmInfo() {
		return confirmInfo;
	}

	public void setConfirmInfo(String confirmInfo) {
		this.confirmInfo = confirmInfo;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public List<TabCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<TabCompany> companyList) {
		this.companyList = companyList;
	}

	public String getComName() {
		return ComName;
	}

	public void setComName(String comName) {
		ComName = comName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

}
