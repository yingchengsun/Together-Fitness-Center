package com.xdsc.action.gzfk_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.StudentInfoService;

/**ѧ����¼session����
 * @author Administrator
 * @version 1.3
 */
public class StudentSelfAction  extends ActionSupport implements  SessionAware{
	
	private Map session;
	private TabStudents student;
	private StudentInfoService studentInfoService;
	
	
	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public TabStudents getStudent() {
		return student;
	}


	public void setStudent(TabStudents student) {
		this.student = student;
	}


	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}


	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}


	//----------------
	public String findStudentSelfInfo(){        //��ʾ�о����ĸ�����Ϣ
		String userName=(String)session.get("userNumber");
		student= studentInfoService.findStudentByNum(userName);
		return "findStudentSelfInfo";
	}

}
