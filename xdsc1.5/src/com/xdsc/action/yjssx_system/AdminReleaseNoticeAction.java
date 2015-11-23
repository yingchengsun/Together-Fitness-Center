package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.service.yjssx_system.TutorInfoService;
import com.xdsc.util.CommonConstVariable;

/**类功能：管理员发送通知
 * @author 许鑫
 * @version 1.1
 */
public class AdminReleaseNoticeAction extends ActionSupport {

	private SystomNoticeService systomNoticeService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private TutorInfoService tutorInfoService;
	
	/**
	 * 给某个人发送信息，传入人的角色和人的名字
	 */
	private String name; 
	
	private String type; 
	//-------------------------------下拉菜单显示的数据----------------------------
	private List<TabPostgraduate> studentList;
	
	private List<TabCompany> companyList;
	
	private List<TabTeachers> teacherList;
	//-------------------------------研究生搜索条件--------------------------------------
	private String studentName;
	
	private String studentSex;
	
	private String tutorNumber;
	
	private String companyNumber;
	
	private String className;
	
	private String gradeName;
	
	private String studentType;
	
	//-------------------------------公司搜索条件----------------------------------------
	private String companyName;
	
	private String companyAddress;
	
	private String companyEmail;
	
	private String ConnectPerson;
	//-----------------------------------导师搜索条件-------------------------------------
	
	private String tutorName;
	//
	/**
	 * 根据类型和角色查找出来的信息集合，company,teacher,student
	 */
	private List<TabCompany> company;
	
	private List<TabPostgraduate> student;
	
	private List<TabTeachers> teacher;
	
	/**
	 * 给哪些人发送通知，人的Id
	 */
	private List<String> noticeId;
	
	/**
	 * 发送的通知的详情
	 */
	private TabNotice notice; 
	
	private File uploadFile; 

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;

	/**实现简单的跳转
	 * @return releaseNotice 跳转成功
	 */
	public String releaseNotice(){
		
		return "releaseNotice";
	}
	
	/**
	 * 通过判断给哪个角色发送通知，查找角色表单所需下拉列表数据
	 * @return 转向搜索页面
	 */
	public String NoticeToRoles(){
		if(type.equals(CommonConstVariable.TYPE_STUDENT)){
			companyList = companyInfoService.findAllCompanyInfo();
			teacherList = tutorInfoService.findAllTutors();
			student = postgraduateInfoService.findAllStudent();
			return "adminNoticeToStudent";
		}
		else if(type.equals(CommonConstVariable.TYPE_TUTOR)){
			teacherList = tutorInfoService.findAllTutors();
			teacher= teacherList;
			return "adminNoticeToTutor";
		}
		else{
			companyList = companyInfoService.findAllCompanyInfo();
			company = companyList;
			return "adminNoticeToCompany";
		}
	}
	
	/**
	 * 给某个角色发信息，根据用户输入条件查询用户
	 * @return adminNoticeToAll
	 */
	public String adminNoticeToSbSearch(){ 
		if(type.equals(CommonConstVariable.TYPE_STUDENT)){
			companyList = companyInfoService.findAllCompanyInfo();
			teacherList = tutorInfoService.findAllTutors();
			student = postgraduateInfoService.findPostgraduateByCondition(studentName, studentSex, tutorNumber, companyNumber, className, gradeName, studentType, "", "","");
			return "adminNoticeToStudent";
		}
		else if(type.equals(CommonConstVariable.TYPE_TUTOR)){
			teacherList = tutorInfoService.findAllTutors();
			teacher= tutorInfoService.findTutorByName(tutorName);
			return "adminNoticeToTutor";
		}
		else{
			companyList = companyInfoService.findAllCompanyInfo();
			company= companyInfoService.findCompanyByCondition(companyName, companyAddress, companyEmail, ConnectPerson);
			return "adminNoticeToCompany";
		}
	}
	
	/**
	 * 实现简单的跳转，跳转大发送通知的页面
	 * @return NoticeTo 跳转成功
	 */
	public String noticeTo(){
		
		return "NoticeTo";
	}
	
	/**
	 * 实现通知的发送，先保存通知，再在中间表中将此通知和所要发送通知的人关联起来
	 * @return saveNotice 通知发送成功
	 */
	public String saveNotice(){
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			systomNoticeService.savefile(uploadFile, savePath, saveName);
			notice.setFInfoPath(saveName);
		}
		notice.setFModuleId(CommonConstVariable.MODULE_ID);
		if(type.equals(CommonConstVariable.TYPE_STUDENT)){
			notice.setFInfoType(CommonConstVariable.NOTICE_TYPE_ADMINTOSTUDENT);
		}
		else if(type.equals(CommonConstVariable.TYPE_TUTOR)){
			notice.setFInfoType(CommonConstVariable.NOTICE_TYPE_ADMINTOTUTOR); 
		}
		else{
			notice.setFInfoType(CommonConstVariable.NOTICE_TYPE_ADMINTOCOMPANY);
		}	
		systomNoticeService.addNotice(notice);
		List<MhqxTabUser> userList=new ArrayList<MhqxTabUser>();
		for(int i=0;i<noticeId.size();i++){
			MhqxTabUser user=postgraduateInfoService.findModuleById(noticeId.get(i));
			userList.add(user);
		}
		TabNotice lastSave = systomNoticeService.findLastSaveNotice(notice); 
		TabNoticetosb noticeTo=new TabNoticetosb();
		for(int i=0;i<noticeId.size();i++){   
			noticeTo.setMhqxTabUser(userList.get(i));
			noticeTo.setTabNotice(lastSave);
			noticeTo.setFAlreadyRead("0");
			systomNoticeService.addNoticeTo(noticeTo);
		}
		
		return "saveNotice";
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TabCompany> getCompany() {
		return company;
	}

	public void setCompany(List<TabCompany> company) {
		this.company = company;
	}

	public List<TabPostgraduate> getStudent() {
		return student;
	}

	public void setStudent(List<TabPostgraduate> student) {
		this.student = student;
	}

	public List<TabTeachers> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<TabTeachers> teacher) {
		this.teacher = teacher;
	}
	
	public List<String> getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(List<String> noticeId) {
		this.noticeId = noticeId;
	}

	public TabNotice getNotice() {
		return notice;
	}

	public void setNotice(TabNotice notice) {
		this.notice = notice;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<TabCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<TabCompany> companyList) {
		this.companyList = companyList;
	}

	public List<TabTeachers> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TabTeachers> teacherList) {
		this.teacherList = teacherList;
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

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getConnectPerson() {
		return ConnectPerson;
	}

	public void setConnectPerson(String connectPerson) {
		ConnectPerson = connectPerson;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
