package com.xdsc.action.wzmh_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.check.PhoneCheck;
import com.xdsc.dao.gzfk_system.impl.StudentInfoDAOImpl;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;

/**
 * 编辑学生基本信息
 * @author 陈丰
 *
 */
public class EditStudentInfoAction extends ActionSupport{
private String StudentName;
private String StudentTel;
private String HomeTel;
private String StudentDormitory;
private String StudentEmail;

private StudentInfoDAOImpl studentInfoDAO;

public StudentInfoDAOImpl getStudentInfoDAO() {
	return studentInfoDAO;
}
public void setStudentInfoDAO(StudentInfoDAOImpl studentInfoDAO) {
	this.studentInfoDAO = studentInfoDAO;
}
public String getStudentEmail() {
	return StudentEmail;
}
public void setStudentEmail(String studentEmail) {
	StudentEmail = studentEmail;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getStudentTel() {
	return StudentTel;
}
public void setStudentTel(String studentTel) {
	StudentTel = studentTel;
}
public String getHomeTel() {
	return HomeTel;
}
public void setHomeTel(String homeTel) {
	HomeTel = homeTel;
}
public String getStudentDormitory() {
	return StudentDormitory;
}
public void setStudentDormitory(String studentDormitory) {
	StudentDormitory = studentDormitory;
}


/**
 * 手机电话验证
 * @param 手机
 * @param 电话
 * @return 验证结果
 */
public boolean phoneValidation(String mobilephone,String tel)
{
	boolean flag=true;
	if(mobilephone!=null&&mobilephone!="")
		if(!PhoneCheck.mobilephoneCheck(mobilephone))
			flag=false;	
	if(tel!=null&&tel!="")
		if(!PhoneCheck.phoneCheck(tel))
			flag=false;	
	return flag;
}
public boolean checkEmail(String mail){   
if(mail==null||mail.equals(""))
	return true;
    String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";   
    Pattern   p   =   Pattern.compile(regex);   
    Matcher   m   =   p.matcher(mail);   
    return m.find();   
}  
/**
 * 更新学生基本信息
 * @return 更新结果
 */
public String updateStudent()
{	
	HttpSession session=ServletActionContext.getRequest().getSession();
	String id = session.getAttribute("FUserNumber").toString();
	TabStudents student = studentInfoDAO.findStudentByNum(id);
	boolean flag=false;
	if(student==null)
	{
		student = new TabStudents();
		student.setFStudentNumber(id);
		flag=true;
	}
	AppException.clear();
	if(!checkEmail(StudentEmail))
	{
		new AppException("邮件格式错误");
		return ERROR;
	}
	if(phoneValidation(StudentTel,HomeTel)){
	student.setFHomeTel(HomeTel);
	student.setFStudentDormitory(StudentDormitory);
	student.setFStudentTel(StudentTel);
	student.setFStudentEmail(StudentEmail);
	if(flag)
	studentInfoDAO.addStudentInfo(student);
	studentInfoDAO.updateStudentInfo(student);
	AppException.clear();
	return SUCCESS;
	}
	else
		return ERROR;
}
}






