package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**类功能：管理员对研究生信息的管理
 * @author 许鑫
 * @version 1.1
 */
public class AdminStudentInfoManageAction extends ActionSupport {

	private PostgraduateInfoService postgraduateInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private CompanyInfoService companyInfoService;
	
	/**
	 * 给研究生添加导师，select标签中使用的List
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * 添加研究生信息，用户名和密码和研究生的基本信息
	 */
	private String userName ;
	
	private String password;
	
	private TabStudents stuInfo;
	
	private TabPostgraduate newStudent;
	
	/**
	 * 显示所有研究生的信息
	 */
	private List<TabPostgraduate> studentList;
	
	/**
	 * 删除研究生信息，研究生的Id
	 */
	private List<String> delStuId;
	
	/**
	 * 根据研究生的姓名搜索研究生信息，保存在studentList中
	 */
	private String stuName;
	
	/**
	 * 给研究生添加企业，给研究生添加导师搜索出来的研究生
	 */
	private List<TabPostgraduate> student;  
	
	/**
	 * 给研究生添加企业，给研究生添加导师，确定添加时传入的研究生的Id
	 */
	private String stuId;
	/**
	 * 给研究生添加导师，搜索出导师的信息
	 */
	private String tutorName;
	
	private List<TabTeachers> tutor;  
	
	/**
	 * 给研究生添加导师，确定添加时传入的导师的Id
	 */
	private String tutorId;
	
	/**
	 * 给研究生添加企业，搜索出企业的信息
	 */
	private String companyName;       
	
	private List<TabCompany> company;  
	
	private List<TabCompany> companyList;  
	/**
	 * 给研究生添加企业，确定添加时传入的企业的Id
	 */
	private String companyId;
	
	private TabCompany comInfo;
	
	private TabPostgraduate studentInfo;                   
	
	private TabTeachers tutorInfo;
	
//-------------------------------研究生搜索条件--------------------------------------
	private String studentName;
	
	private String studentSex;
	
	private String tutorNumber;
	
	private String companyNumber;
	
	private String className;
	
	private String gradeName;
	
	private String studentType;
	
	private int p = 1;

	private int lastPage;


	public String preAddNewStudent(){
		return "preAddNewStudent";
	}
	
	/**
	 * 添加研究生信息
	 * @return  addNewStudent 添加研究生成功
	 */
	public String addNewStudent(){
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(userName);
		user.setFUserPassword(password);
		tutorInfoService.addModuleUser(user);
		
		stuInfo.setFStudentNumber(userName);
		stuInfo.setMhqxTabUser(user);
		postgraduateInfoService.addStudent(stuInfo);
		
		newStudent.setFStudentNumber(userName);
		newStudent.setTabStudents(stuInfo);
		postgraduateInfoService.addPostgraduate(newStudent);
		return "addNewStudent";
	}
	
	/**
	 * 删除研究生信息
	 * @return  deleteStudent删除信息成功
	 */
	public String deleteStudent(){   
		for(int i=0;i<delStuId.size();i++){
			MhqxTabUser user = postgraduateInfoService.findModuleById(delStuId.get(i));
			postgraduateInfoService.delModuleUser(user);
		}
		return "deleteStudent";
	}

	/**
	 * 根据研究生姓名查找研究生信息
	 * @return  studentSearch 查找信息成功
	 */
	public String studentSearch(){
		teacherList=tutorInfoService.findAllTutors();
		companyList=companyInfoService.findAllCompanyInfo();
		studentList = postgraduateInfoService.findPostgraduateByCondition(studentName, studentSex, tutorNumber, companyNumber, className, gradeName, studentType, "", "","");
		return "studentSearch";
	}
	
	/**
	 * 显示所有研究生信息
	 * @return showAllPostgraudte 返回所有研究生信息studentList
	 */
	public String showAllPostgraudte(){ 
		teacherList=tutorInfoService.findAllTutors();
		companyList=companyInfoService.findAllCompanyInfo();
		studentList = postgraduateInfoService.findAllStudent();
		if(studentList.size()>10){
			int pages = 10;
			int listlength = this.studentList.size();
			if (listlength % pages == 0) {
				this.lastPage = listlength / pages;
			} else {
				this.lastPage = listlength / pages + 1;
			}
			if (this.p < 1)
				this.p = 1;
			if (this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.studentList = this.studentList.subList(startIndex, endIndex);
		}

		return "showAllPostgraudte";
	}
	
	/**
	 * 给研究生添加导师
	 * @return studentAddTutor 返回teacherList用于在select标签中显示数据
	 */
	public String studentAddTutor(){  
		teacherList = tutorInfoService.findAllTutors();
		return "studentAddTutor";
	}

	/**
	 * 给研究生添加导师，根据研究生和导师的Id来搜索导师和student信息
	 * @return studentAddTutorSearch 返回student为研究生信息，tutor为导师信息
	 */
	public String studentAddTutorSearch(){ 
		student = postgraduateInfoService.findStudentByName(stuName);
		tutor = tutorInfoService.findTutorByName(tutorName);
		return "studentAddTutorSearch";
	}
	
	/**
	 * 确定给研究生添加导师，更新数据库中研究生的导师字段
	 * @return confirmToAdd 表示添加导师成功
	 */
	public String confirmToAdd(){
		studentInfo=postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		tutorInfo=tutorInfoService.findTutorById(tutorId);
		studentInfo.setTabTeachers(tutorInfo);
		postgraduateInfoService.updatePostgraduateStuInfo(studentInfo);
		return "confirmToAdd";
	}
	
	/**
	 * 给研究生添加企业
	 * @return studentAddCompany 返回companyList用于在select标签中使用
	 */
	public String studentAddCompany(){
		companyList = companyInfoService.findAllCompanyInfo();
		return "studentAddCompany";
	}
	
	/**
	 * 给研究生添加企业，根据Id查找研究生和企业
	 * @return studentAddCompanySearch 返回company 和student
	 */
	public String studentAddCompanySearch(){
		student = postgraduateInfoService.findStudentByName(stuName);
		company = companyInfoService.findCompanyByName(companyName);
		return "studentAddCompanySearch";
	}
	
	/**
	 * 确定添加研究生
	 * @return confirmToAddCom 给研究生添加企业成功
	 */
	public String confirmToAddCom(){                     //给研究生添加企业
		studentInfo=postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		comInfo=companyInfoService.findCompanyByNum(companyId);
		studentInfo.setTabCompany(comInfo);
		postgraduateInfoService.updatePostgraduateStuInfo(studentInfo);
		return "confirmToAddCom";
	}
	
	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public TabStudents getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(TabStudents stuInfo) {
		this.stuInfo = stuInfo;
	}

	public TabPostgraduate getNewStudent() {
		return newStudent;
	}

	public void setNewStudent(TabPostgraduate newStudent) {
		this.newStudent = newStudent;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}
	
	public List<String> getDelStuId() {
		return delStuId;
	}

	public void setDelStuId(List<String> delStuId) {
		this.delStuId = delStuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public List<TabPostgraduate> getStudent() {
		return student;
	}

	public void setStudent(List<TabPostgraduate> student) {
		this.student = student;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public List<TabTeachers> getTutor() {
		return tutor;
	}

	public void setTutor(List<TabTeachers> tutor) {
		this.tutor = tutor;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<TabCompany> getCompany() {
		return company;
	}

	public void setCompany(List<TabCompany> company) {
		this.company = company;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public TabPostgraduate getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(TabPostgraduate studentInfo) {
		this.studentInfo = studentInfo;
	}

	public TabTeachers getTutorInfo() {
		return tutorInfo;
	}

	public void setTutorInfo(TabTeachers tutorInfo) {
		this.tutorInfo = tutorInfo;
	}

	public TabCompany getComInfo() {
		return comInfo;
	}

	public void setComInfo(TabCompany comInfo) {
		this.comInfo = comInfo;
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

	public List<TabTeachers> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TabTeachers> teacherList) {
		this.teacherList = teacherList;
	}

	public List<TabCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<TabCompany> companyList) {
		this.companyList = companyList;
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

	public String getTutorNumber() {
		return tutorNumber;
	}

	public void setTutorNumber(String tutorNumber) {
		this.tutorNumber = tutorNumber;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
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
