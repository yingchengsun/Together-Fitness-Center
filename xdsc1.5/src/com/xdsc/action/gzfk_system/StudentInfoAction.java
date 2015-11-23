package com.xdsc.action.gzfk_system;

import java.util.Date;
import java.util.List;


import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.ClassInfoService;
import com.xdsc.service.gzfk_system.StudentInfoService;
import com.xdsc.service.gzfk_system.UserLoginService;

/**学生基本信息处理
 * @author Administrator
 * @version 1.3
 */
public class StudentInfoAction {
	private String FUserNumber;
	//private String FUserPassword;
	
	private String FStudentNumber;
	private String FClassNumber;
	private String FStudentName;
	private String FStudentSex;
	private Date FStudentBirthday;
	private String FStudentNation;
	//private String FStudentNativeplace;
	private String FStudentPoliStatus;
	private String FStudentMajor;
	private String FRewardPunish;
	private String FQuXiang;
	
	private String FNameselect;
	private TabStudents student = new TabStudents();
	private String FStudentNumSelect;
	private String FClassNumSelect;
	private String FQuxiangselect;
	
	private MhqxTabUser user= new MhqxTabUser();
	//private MhqxTabUser user;
	private UserLoginService userLoginService;

	private ClassInfoService classInfoService;
	private List<TabStudents> listStudentInfo;
	private StudentInfoService studentInfoService;
	
	/**
	 * 分页信息处理相关属性
	 */
	private int p = 1;
    private int lastPage;
	
    
	public String getFStudentNumSelect() {
		return FStudentNumSelect;
	}
	public void setFStudentNumSelect(String studentNumSelect) {
		FStudentNumSelect = studentNumSelect;
	}
	public MhqxTabUser getUser() {
		return user;
	}
	public void setUser(MhqxTabUser user) {
		this.user = user;
	}
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}
	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	public String getFClassNumSelect() {
		return FClassNumSelect;
	}
	public void setFClassNumSelect(String classNumSelect) {
		FClassNumSelect = classNumSelect;
	}
	public String getFNameselect() {
		return FNameselect;
	}
	public void setFNameselect(String nameselect) {
		FNameselect = nameselect;
	}
	public List<TabStudents> getListStudentInfo() {
		return listStudentInfo;
	}
	public void setListStudentInfo(List<TabStudents> listStudentInfo) {
		this.listStudentInfo = listStudentInfo;
	}
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
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
	public String getFStudentName() {
		return FStudentName;
	}
	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}
	public String getFStudentSex() {
		return FStudentSex;
	}
	public void setFStudentSex(String studentSex) {
		FStudentSex = studentSex;
	}
	public Date getFStudentBirthday() {
		return FStudentBirthday;
	}
	public void setFStudentBirthday(Date studentBirthday) {
		FStudentBirthday = studentBirthday;
	}
	public String getFStudentNation() {
		return FStudentNation;
	}
	public void setFStudentNation(String studentNation) {
		FStudentNation = studentNation;
	}
//	public String getFStudentNativeplace() {
//		return FStudentNativeplace;
//	}
//	public void setFStudentNativeplace(String studentNativeplace) {
//		FStudentNativeplace = studentNativeplace;
//	}
	public String getFStudentPoliStatus() {
		return FStudentPoliStatus;
	}
	public void setFStudentPoliStatus(String studentPoliStatus) {
		FStudentPoliStatus = studentPoliStatus;
	}
	public String getFStudentMajor() {
		return FStudentMajor;
	}
	public void setFStudentMajor(String studentMajor) {
		FStudentMajor = studentMajor;
	}
	public String getFRewardPunish() {
		return FRewardPunish;
	}
	public void setFRewardPunish(String rewardPunish) {
		FRewardPunish = rewardPunish;
	}
	public String getFQuXiang() {
		return FQuXiang;
	}
	public void setFQuXiang(String quXiang) {
		FQuXiang = quXiang;
	}
	public ClassInfoService getClassInfoService() {
		return classInfoService;
	}
	public void setClassInfoService(ClassInfoService classInfoService) {
		this.classInfoService = classInfoService;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}
	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}
	
	public TabStudents getStudent() {
		return student;
	}
	public void setStudent(TabStudents student) {
		this.student = student;
	}

	public String getFQuxiangselect() {
		return FQuxiangselect;
	}
	public void setFQuxiangselect(String quxiangselect) {
		FQuxiangselect = quxiangselect;
	}
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
	
	
	//--------------
	public String findAllStudentInfo(){
		listStudentInfo = studentInfoService.findAllStudentInfo();
		if(listStudentInfo.size()>10){
			int pages = 10;
			int listlength = this.listStudentInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages + 1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listStudentInfo = this.listStudentInfo.subList(startIndex, endIndex);
		}
		return "findAllStudentInfo";
		
	}
	
	public String findStudentbyNum(){
		System.out.println("start find by num");
		//TabStudents student = new TabStudents();
		student = studentInfoService.findStudentByNum(FStudentNumber);
		System.out.println(student.getFStudentName());
		return "findStudentbyNum";
	}
	
	public String findStudentbyName(){
		listStudentInfo = studentInfoService.findStudentByName(FNameselect);
		return "findStudentbyName";
		
	}
	
	public String addStudentInfo(){
		System.out.println("start");
		//TabStudents student = new TabStudents();
		student=studentInfoService.findStudentByNum(FUserNumber);
		user=userLoginService.findUserByNum(FUserNumber);
		
		if(student!=null){
			return "StudentExist";
		}
		else if(user==null){
		MhqxTabUser user= new MhqxTabUser();
		TabStudents student = new TabStudents();
		
		System.out.println("start user");
		user.setFUserNumber(FUserNumber);
		//user.setFUserPassword(FUserPassword);

		studentInfoService.addStudentInfo(user);
		System.out.println(FUserNumber);
		//user.setFUserPassword(FUserPassword);
		System.out.println("start student");
		student.setFStudentNumber(user.getFUserNumber());
		System.out.println(FUserNumber);
		student.setFStudentName(FStudentName);
		System.out.println(FStudentName);
		student.setFQuXiang(FQuXiang);
		student.setFRewardPunish(FRewardPunish);
		student.setFStudentBirthday(FStudentBirthday);
		student.setFStudentMajor(FStudentMajor);
		student.setFStudentNation(FStudentNation);
		//student.setFStudentNativeplace(FStudentNativeplace);
		student.setFStudentPoliStatus(FStudentPoliStatus);
		student.setFStudentSex(FStudentSex);
		
		TabClasses class1 = new TabClasses();
		System.out.println(FClassNumber);
		class1 = classInfoService.findClassByNum(FClassNumber);
		student.setTabClasses(class1);
		//System.out.println(student.getTabClasses().getFClassNumber());
		
		System.out.println("add class");

		class1 = classInfoService.findClassByNum(FClassNumber);
		student.setTabClasses(class1);
		System.out.println("add class finish");
		
		studentInfoService.addStudentInfo(student);
		System.out.println("finish");
		
		listStudentInfo = studentInfoService.findAllStudentInfo();
		return "addStudentInfo";
		}
		else{
			TabStudents student = new TabStudents();
			student.setFStudentNumber(FUserNumber);
			student.setMhqxTabUser(user);
			System.out.println(FUserNumber);
			student.setFStudentName(FStudentName);
			System.out.println(FStudentName);
			student.setFQuXiang(FQuXiang);
			student.setFRewardPunish(FRewardPunish);
			student.setFStudentBirthday(FStudentBirthday);
			student.setFStudentMajor(FStudentMajor);
			student.setFStudentNation(FStudentNation);
			//student.setFStudentNativeplace(FStudentNativeplace);
			student.setFStudentPoliStatus(FStudentPoliStatus);
			student.setFStudentSex(FStudentSex);
			
			TabClasses class1 = new TabClasses();
			System.out.println(FClassNumber);
			class1 = classInfoService.findClassByNum(FClassNumber);
			student.setTabClasses(class1);
			//System.out.println(student.getTabClasses().getFClassNumber());
			
			System.out.println("add class");

			class1 = classInfoService.findClassByNum(FClassNumber);
			student.setTabClasses(class1);
			System.out.println("add class finish");
			
			studentInfoService.addStudentInfo(student);
			System.out.println("finish");
			
			listStudentInfo = studentInfoService.findAllStudentInfo();
			return "addStudentInfo";
		}
		
	}

	public String delStudentByNum(){
		//TabStudents student = new TabStudents();
		student = studentInfoService.findStudentByNum(FStudentNumber);
		studentInfoService.delStudentInfo(student);
		listStudentInfo = studentInfoService.findAllStudentInfo();

		return "delStudentByNum";
	}
	
	public String updateStudentInfo(){
		student.setFQuXiang(FQuXiang);
		student.setFRewardPunish(FRewardPunish);
		student.setFStudentBirthday(FStudentBirthday);
		student.setFStudentMajor(FStudentMajor);
		student.setFStudentNation(FStudentNation);
		//student.setFStudentNativeplace(FStudentNativeplace);
		student.setFStudentPoliStatus(FStudentPoliStatus);
		student.setFStudentSex(FStudentSex);
		student.setFStudentName(FStudentName);
		
		studentInfoService.updateStudentInfo(student);
		
		listStudentInfo = studentInfoService.findAllStudentInfo();
		return "updateStudentInfo";
	}
	
	public String findStudentByClass(){
		System.out.println("student start by class############");
		listStudentInfo = studentInfoService.findStudentByClass(FClassNumSelect);
		
		if(listStudentInfo.size()>10){
			int pages = 10;
			int listlength = this.listStudentInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages + 1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listStudentInfo = this.listStudentInfo.subList(startIndex, endIndex);
		}
		return "findStudentByClass";
		
	}
	
	public String findStudentbyQuxiang(){
		listStudentInfo = studentInfoService.findStudentbyQuxiang(FQuxiangselect);
		return "findStudentbyQuxiang";
		}
	//public String getFUserPassword() {
		//return FUserPassword;
	//}
	//public void setFUserPassword(String userPassword) {
		//FUserPassword = userPassword;
	//}
	
	public String searchStudentByNum(){
		listStudentInfo = studentInfoService.searchStudentByNum(FStudentNumSelect);
		return "searchStudentByNum";
	}

}
