package com.xdsc.action.wzmh_system;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.check.AppException;
import com.xdsc.check.PhoneCheck;
import com.xdsc.dao.gzfk_system.impl.TutorInfoDaoImpl;
import com.xdsc.model.TabTeachers;
import com.xdsc.wzmh_system.util.AItem;

/**
 * 编辑教师基本信息
 * @author 陈丰
 *
 */
public class EditTeacherInfoAction extends ActionSupport{
private String TeacherName;
private String TeacherNumber;
private String TeacherSex;
private String TeacherBirthday;
private String TeacherTel;
private String TeacherPhone;
private String TeacherEmail;
private String TeacherAddress;
private String TeacherXueLi;
private String TeacherWorkPlace;
private String TeacherResearch;
private String TeacherPosition;
private String TeacherZhiCheng;
private TutorInfoDaoImpl tutorInfoDao;
public String getTeacherName() {
	return TeacherName;
}
public void setTeacherName(String teacherName) {
	TeacherName = teacherName;
}
public String getTeacherNumber() {
	return TeacherNumber;
}
public void setTeacherNumber(String teacherNumber) {
	TeacherNumber = teacherNumber;
}
public String getTeacherSex() {
	return TeacherSex;
}
public void setTeacherSex(String teacherSex) {
	TeacherSex = teacherSex;
}
public String getTeacherBirthday() {
	return TeacherBirthday;
}
public void setTeacherBirthday(String teacherBirthday) {
	TeacherBirthday = teacherBirthday;
}
public String getTeacherTel() {
	return TeacherTel;
}
public void setTeacherTel(String teacherTel) {
	TeacherTel = teacherTel;
}
public String getTeacherPhone() {
	return TeacherPhone;
}
public void setTeacherPhone(String teacherPhone) {
	TeacherPhone = teacherPhone;
}
public String getTeacherEmail() {
	return TeacherEmail;
}
public void setTeacherEmail(String teacherEmail) {
	TeacherEmail = teacherEmail;
}
public String getTeacherAddress() {
	return TeacherAddress;
}
public void setTeacherAddress(String teacherAddress) {
	TeacherAddress = teacherAddress;
}
public String getTeacherXueLi() {
	return TeacherXueLi;
}
public void setTeacherXueLi(String teacherXueLi) {
	TeacherXueLi = teacherXueLi;
}
public String getTeacherWorkPlace() {
	return TeacherWorkPlace;
}
public void setTeacherWorkPlace(String teacherWorkPlace) {
	TeacherWorkPlace = teacherWorkPlace;
}
public String getTeacherResearch() {
	return TeacherResearch;
}
public void setTeacherResearch(String teacherResearch) {
	TeacherResearch = teacherResearch;
}
public String getTeacherPosition() {
	return TeacherPosition;
}
public void setTeacherPosition(String teacherPosition) {
	TeacherPosition = teacherPosition;
}
public String getTeacherZhiCheng() {
	return TeacherZhiCheng;
}
public void setTeacherZhiCheng(String teacherZhiCheng) {
	TeacherZhiCheng = teacherZhiCheng;
}
public TutorInfoDaoImpl getTutorInfoDao() {
	return tutorInfoDao;
}
public void setTutorInfoDao(TutorInfoDaoImpl tutorInfoDao) {
	this.tutorInfoDao = tutorInfoDao;
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
 * 电话手机号验证
 * @param 手机
 * @param 电话
 * @return 验证结果
 */
public boolean phoneValidation(String mobilephone,String tel)
{
	boolean flag=true;
	if(mobilephone!=null&&mobilephone!="")
		if(!PhoneCheck.mobilephoneCheck(mobilephone))
			flag= false;	
	if(tel!=null&&tel!="")
		if(!PhoneCheck.phoneCheck(tel))
			flag= false;
	return flag;
}

/**
 * 更新教师基本信息
 * @return 更新结果
 */
public String updateTeacher(){
	HttpSession session=ServletActionContext.getRequest().getSession();
	String id = session.getAttribute("FUserNumber").toString();
	TabTeachers teacher = tutorInfoDao.findTutorById(id);
	System.out.println(id+"  "+teacher);
	boolean flag = false;
	if(teacher==null)
	{
		teacher = new TabTeachers();
		teacher.setFTeacherNumber(id);
		flag=true;
	}
	AppException.clear();
	if(!checkEmail(TeacherEmail))
	{
		new AppException("邮件格式错误");
		return ERROR;
	}
	if(phoneValidation(TeacherPhone,TeacherTel)){
	teacher.setFTeacherName(TeacherName);
	teacher.setFTeacherSex(TeacherSex);
	try {
		teacher.setFTeacherBirthday(DateFormat.getDateInstance().parse(TeacherBirthday));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	teacher.setFTeacherTel(TeacherTel);
	teacher.setFTeacherPhone(TeacherPhone);
	teacher.setFTeacherEmail(TeacherEmail);
	teacher.setFTeacherAddress(TeacherAddress);
	teacher.setFTeacherXueLi(TeacherXueLi);
	teacher.setFTeacherWorkPlace(TeacherWorkPlace);
	teacher.setFTeacherResearch(TeacherResearch);
	teacher.setFTeacherPosition(TeacherPosition);
	teacher.setFTeacherZhiCheng(TeacherZhiCheng);
	if(flag)
		tutorInfoDao.addTeacher(teacher);
	tutorInfoDao.updateTutorInfo(teacher);
	return SUCCESS;
	}
	else
		return ERROR;
}
}
