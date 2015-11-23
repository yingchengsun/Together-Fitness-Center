package com.xdsc.action.gzfk_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.dao.gzfk_system.impl.StudentInfoDAOImpl;
import com.xdsc.model.GzfkTabWorkstudent;

import com.xdsc.model.TabCompany;
import com.xdsc.model.TabStudents;


import com.xdsc.service.gzfk_system.WorkInfoService;
import com.xdsc.service.gzfk_system.CompanyInfoService;
import com.xdsc.service.gzfk_system.StudentInfoService;


/**工作学生信息处理
 * @author 王文倩
 * @version 1.3
 */
public class WorkInfoAction extends ActionSupport{
	//--------------工作学生相关成员信息-----------
	private Integer FNumber;
	//private Integer FSalary;
	private String FPosition;
	private String FWorkCity;
	private String FWorkAdd;
	private String FEmail;
	
	private String FStudentNumber;
	private String FCompanyNumber;
	
	private String FStuNameselect;
	private String FCityselect;
	
	private List<GzfkTabWorkstudent> listWorkInfo;
	
	private WorkInfoService workInfoService;
	private StudentInfoService studentInfoService;
	private CompanyInfoService companyInfoService;

	private GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
	private TabStudents student1=new TabStudents();
	
	private int p = 1;
    private int lastPage;
	
	
	
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public String getFCompanyNumber() {
		return FCompanyNumber;
	}

	public void setFCompanyNumber(String companyNumber) {
		FCompanyNumber = companyNumber;
	}

//	public Integer getFSalary() {
//		return FSalary;
//	}
//
//	public void setFSalary(Integer salary) {
//		FSalary = salary;
//	}

	public String getFPosition() {
		return FPosition;
	}

	public void setFPosition(String position) {
		FPosition = position;
	}

	public String getFWorkCity() {
		return FWorkCity;
	}

	public void setFWorkCity(String workCity) {
		FWorkCity = workCity;
	}

	public String getFWorkAdd() {
		return FWorkAdd;
	}

	public void setFWorkAdd(String workAdd) {
		FWorkAdd = workAdd;
	}

	public String getFEmail() {
		return FEmail;
	}

	public void setFEmail(String email) {
		FEmail = email;
	}

	public Integer getFNumber() {
		return FNumber;
	}

	public void setFNumber(Integer number) {
		FNumber = number;
	}

	public String getFStuNameselect() {
		return FStuNameselect;
	}

	public void setFStuNameselect(String stuNameselect) {
		FStuNameselect = stuNameselect;
	}

	public WorkInfoService getWorkInfoService() {
		return workInfoService;
	}

	public void setWorkInfoService(WorkInfoService workInfoService) {
		this.workInfoService = workInfoService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public List<GzfkTabWorkstudent> getListWorkInfo() {
		return listWorkInfo;
	}

	public void setListWorkInfo(List<GzfkTabWorkstudent> listWorkInfo) {
		this.listWorkInfo = listWorkInfo;
	}

	public WorkInfoAction() {
		super();
	}

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
//	public StudentInfoService getStudentInfoService() {
//		return studentInfoService;
//	}
//
//	public void setStudentInfoService(StudentInfoService studentInfoService) {
//		this.studentInfoService = studentInfoService;
//	}



//	
//	public TabCompany getCompany() {
//		return company;
//	}
//
//	public void setCompany(TabCompany company) {
//		this.company = company;
//	}

//	public GzfkTabWorkstudent getWorkStudent() {
//		return workStudent;
//	}
//
//	public void setWorkStudent(GzfkTabWorkstudent workStudent) {
//		this.workStudent = workStudent;
//	}

	//------------------工作学生-----------------------
	public String findAllWorkInfo(){
		listWorkInfo = workInfoService.findWorkInfo();
		if(listWorkInfo.size()>10){
			int pages = 10;
			int listlength = this.listWorkInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listWorkInfo = this.listWorkInfo.subList(startIndex, endIndex);
		}
		return "findAllWorkInfo";
	}

	
	public String addWorkInfo(){
		//GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
		
GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
		
		System.out.println("start");
		
		workStudent.setFEmail(FEmail);
		workStudent.setFPosition(FPosition);
		workStudent.setFWorkCity(FWorkCity);
		workStudent.setFWorkAdd(FWorkAdd);
		
		System.out.println(workStudent.getFSalary()+","+workStudent.getFEmail());

		//根据FStudentNumber得到student对象，存入workStudent
		//StudentInfoDAOImpl  studentDAO=new StudentInfoDAOImpl();
		TabStudents student1=new TabStudents();
		System.out.println(FStudentNumber);
		student1 = studentInfoService.findStudentByNum(FStudentNumber);
		System.out.println(student1.getFStudentName());
		if(("").equals(student1))
			System.out.println("student NULL");
//		student= studentInfoService.findStudentByNum(FStudentNumber);
		System.out.println(student1.getFStudentName());
		workStudent.setTabStudents(student1);
		System.out.println("workstudent"+workStudent.getTabStudents().getFStudentName());
		
		TabCompany company=new TabCompany();
		System.out.println(FCompanyNumber);
		company= companyInfoService.findCompanyByNum(FCompanyNumber);
		workStudent.setTabCompany(company);
		System.out.println(workStudent.getTabCompany().getFCompanyName());
		System.out.println("company"+workStudent.getTabCompany().getFCompanyName());
		
		workInfoService.addWorkStudent(workStudent);
		System.out.println("finish");
		listWorkInfo = workInfoService.findWorkInfo();
		if(listWorkInfo.size()>10){
			int pages = 10;
			int listlength = this.listWorkInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listWorkInfo = this.listWorkInfo.subList(startIndex, endIndex);
		}
		return "addWorkInfo";
			
	}

	
	
	public String findWorkInfoByID(){
		//GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
		workStudent = workInfoService.findWorkInfoByID(FNumber);
		return "findWorkInfoByID";
	}
	
	public String findWorkInfoByName(){
		listWorkInfo = workInfoService.findWorkInfoByName(FStuNameselect);
		return "findWorkInfoByName";
	}
	
	public String findWorkInfoByCity(){
		System.out.println("workbycity start*****************");
		System.out.println(FCityselect);


		listWorkInfo = workInfoService.findWorkInfoByCity(FCityselect);
		System.out.println(listWorkInfo.size());
		return "findWorkInfoByCity";
	}
	
	public String deleteWorkInfoByID(){
		//GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
		workStudent = workInfoService.findWorkInfoByID(FNumber);
		workInfoService.deleteWorkInfo(workStudent);
		
		listWorkInfo = workInfoService.findWorkInfo();


		return "deleteWorkInfoByID";
	}
	
	
	
	public String updateWorkInfo(){
		//GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
		workStudent.setFEmail(FEmail);
		workStudent.setFPosition(FPosition);
		//workStudent.setFSalary(FSalary);
		workStudent.setFWorkAdd(FWorkAdd);
		workStudent.setFWorkCity(FWorkCity);
		
		workInfoService.updateWorkInfo(workStudent);
		listWorkInfo = workInfoService.findWorkInfo();

		
    	return "updateWorkInfo";
	}

	public String getFCityselect() {
		return FCityselect;
	}

	public void setFCityselect(String cityselect) {
		FCityselect = cityselect;
	}

	public GzfkTabWorkstudent getWorkStudent() {
		return workStudent;
	}

	public void setWorkStudent(GzfkTabWorkstudent workStudent) {
		this.workStudent = workStudent;
	}

	public TabStudents getStudent1() {
		return student1;
	}

	public void setStudent1(TabStudents student1) {
		this.student1 = student1;
	}


}