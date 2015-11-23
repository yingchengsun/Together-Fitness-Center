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

/** �๦�ܣ���ҵʵϰ��Ƹ����
 * @author ����
 * @version 1.1
 *
 */
public class AdminPractingZhaoPinManageAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;

	//-------------------------------�о�����������--------------------------------------
	private String studentName;
	
	private String studentSex;
	
	private String className;
	
	private String gradeName;
	
	private String studentType;
	
	/**
	 * ������ʾselectѡ���ǩ������ѡ������
	 */
	private List<TabCompany> companyList;
	
	/**
	 * ���ݹ�˾��������ʾ��˾����Ϣ
	 */
	private String ComName;
	
	private List<TabPostgraduate> studentList;
	
	/**
	 * ��ѯ�о�����ҵ��ȷ�����Y/N������
	 */
	private String confirmInfo;               
	
	/**
	 * ����ѧ������������ѧ������ҵʵϰȷ�����
	 */
	private String stuName;
	
	/**
	 * ʵ�ּ򵥵���ת������ʾ�����о�����Ϣ
	 * @return preShowManage ��ת�ɹ�
	 */
	public String preShowManage(){  
		studentList = postgraduateInfoService.findAllStudent();
		return "preShowManage";
	}
	
	/**
	 * �����о��������������о�����ʵϰ��ҵȷ����Ϣ��student.company
	 * @return
	 */
	public String searchStudent(){	
		studentList = postgraduateInfoService.findPostgraduateByCondition(studentName, studentSex, "", "", className, gradeName, studentType, "", "","");
		return "searchStudent";
	}
	
	/**
	 * ʵ�ּ���ת�����������й�˾��Ϣ��ʾselect��ǩ��ֵ�б�
	 * @return preSearchForManage ��ת�ɹ�
	 */
	public String preSearchForManage(){
		companyList = companyInfoService.findAllCompanyInfo();             
		return "preSearchForManage";
	}
	
	/**
	 * �������������о�����Ϣ��confirmInfo=Y�����Ѿ�ȷ����ҵ���о�����confirmInfo=N����δȷ����ҵ���о���
	 * @return CompanyConfirmedSearch �����ɹ�
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
	 * ������ҵ����������ȥ�˸ù�˾�������о���
	 * @return searchByCompanyName ���ҳɹ�
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
