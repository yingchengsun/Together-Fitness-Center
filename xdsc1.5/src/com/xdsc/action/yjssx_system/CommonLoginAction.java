package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

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
import com.xdsc.service.yjssx_system.UserLoginService;

/**
 * 类功能：系统用户登录
 * @author 许鑫
 * @version 1.1
 */
public class CommonLoginAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private UserLoginService userLoginService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * 用户登录后显示用户的新鲜事
	 */
	private List<TabNotice> noticeList;
	
	/**
	 * 用户登录的用户名和密码
	 */
	private String name;
	
	private String password;
	
	/**
	 * 用户登录的用户类型
	 */
	private String type;
	
	private String userName;
	
	private String place;
	
	private String phone;
	
	/**
	 * 用户登录，先在user表中判断是否存在，再在根据类型在company,student,teacher表中看是否有此用户
	 * @return 跳转到新鲜事页面
	 */
	public String login(){             //用户登陆
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(name);
		user.setFUserPassword(password);
		if(userLoginService.UserIsValide(user)){          //先判断用户是否存在
			List<TabNoticetosb> list=systomNoticeService.findNoticeToByUserNum(name);
			noticeList = new ArrayList<TabNotice>();
			for(int i=0;i<list.size();i++){
				noticeList.add(list.get(i).getTabNotice());
			}
			if(type.equals("student")){               //判断是学生还是企业还是管理员还是导师
				TabPostgraduate student=postgraduateInfoService.findPostgraduateByStuNumber(name);
				if(student!=null){
					userName=student.getTabStudents().getFStudentName();
					phone=student.getTabStudents().getFStudentTel();
					place=student.getTabStudents().getFStudentDormitory();
					session.put("FUserNumber", name);
					return "LoginSuccess";
				}
				else{
					return "loginFalse";
				}
			}
			else if(type.equals("company")){          //企业
				TabCompany company=companyInfoService.findCompanyByNum(name);
				if(company!=null){
					userName=company.getFCompanyName();
					phone=company.getFTelephone();
					place=company.getFAddress();
					session.put("FUserNumber", name);
					return "LoginSuccess";
				}
				else{
					return "loginFalse";
				}
			}
			else if(type.equals("tutor")){                //导师
				TabTeachers tutor=tutorInfoService.findTutorById(name);
				if(tutor!=null){
					userName=tutor.getFTeacherName();
					phone=tutor.getFTeacherPhone();
					place=tutor.getFTeacherWorkPlace();
					session.put("FUserNumber", name);
					return "LoginSuccess";
				}
				else{
					return "loginFalse";
				}
			}
			else if(name.equals("xuxin")&&password.equals("123")){
				session.put("FUserNumber", name);
				return "adminLogin";
			}
		}
		return "loginFalse";
	}
	
	public String GoToHomePage(){
		if(type.equals("student")){
			return "studentPage";
		}else if(type.equals("company")){
			return "companyPage";
		}
		else{
			return "tutorPage";		
		}
	}
	
	public String LogOut(){
		session.remove("FUserNumber");
		return "LogOut";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public UserLoginService getUserLoginService() {
		return userLoginService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
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

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public List<TabNotice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<TabNotice> noticeList) {
		this.noticeList = noticeList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

}
