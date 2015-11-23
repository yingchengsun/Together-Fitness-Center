package com.xdsc.action.gzfk_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabStudents;
import com.xdsc.model.MhqxTabUser;
//import com.xdsc.model.gzfk_system.TabCompany;
//import com.xdsc.model.gzfk_system.TabNotice;
//import com.xdsc.model.gzfk_system.TabNoticetosb;
//import com.xdsc.model.gzfk_system.TabPostgraduate;
import com.xdsc.model.TabTeachers;
//import com.xdsc.service.gzfk_system.CompanyInfoService;
import com.xdsc.service.gzfk_system.TutorInfoService;
import com.xdsc.service.gzfk_system.UserLoginService;
import com.xdsc.service.gzfk_system.StudentInfoService;

/**��¼��֤
 * ���ֽ�ɫ�ĵ�¼��֤
 * @author Administrator
 * @version 1.3
 */
public class CommonLoginAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private UserLoginService userLoginService;
	//private CompanyInfoService companyInfoService;
	private TutorInfoService tutorInfoService;
	private StudentInfoService studentInfoService;
	
	private String name;
	private String userName;
	private String password;
	private String type;
	
	
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

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//----------------------------
	/**��ɫ��¼��Ӧ
	 * @return studentLogin ѧ����¼
	 * @return tutorLogin ����Ա��¼
	 * @return adminLogin ����Ա��¼
	 * @return loginFalse ��¼ʧ��
	 */
	public String login(){ 
		System.out.println("start login******************");//�û���½
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(name);
		//user.setFUserPassword(password);
		System.out.println("check*********************");
		if(userLoginService.UserIsValide(user)){          //���ж��û��Ƿ����
			
			if(type.equals("student")){               //�ж���ѧ�����Ǹ���Ա���ǹ���Ա
				TabStudents student = studentInfoService.findStudentByNum(name);
				if(student!=null){
					userName=student.getFStudentName();
					
					session.put("userNumber", name);
					System.out.println("student done~~*******************");

					return "studentLogin";
				}
				else{
					return "loginFalse";
				}
			}
			
			else if(type.equals("tutor")){                //����Ա
				TabTeachers tutor=tutorInfoService.findTutorById(name);
				if(tutor!=null){
					userName=tutor.getFTeacherName();
					//phone=tutor.getFTeacherPhone();
					//place=tutor.getFTeacherWorkPlace();
					session.put("userNumber", name);
					System.out.println("tutor done~~*******************");

					return "tutorLogin";
				}
				else{
					return "loginFalse";
				}
			}
			else if(name.equals("wwq")){
				session.put("userNumber", name);
				System.out.println("admin done~~*******************");

				return "adminLogin";
			}
			else
				System.out.println("no at all~~*******************");

		}
		return "loginFalse";
	}


}
