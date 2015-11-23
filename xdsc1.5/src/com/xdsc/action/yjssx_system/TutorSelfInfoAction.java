package com.xdsc.action.yjssx_system;

import java.sql.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * 导师个人信息
 * @author 许鑫
 * @version 1.1
 */
public class TutorSelfInfoAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private TutorInfoService tutorInfoService;
	
	private TabTeachers teacherInfo;
	
	private TabTeachers modifyInfo;

	/**
	 * 显示导师详情
	 * @return 返回导师详情
	 */
	public String showTutorInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		teacherInfo=tutorInfoService.findTutorById(FUserNumber);
		return "showTutorInfo";
	}
	
	/**
	 * 修改导师信息前，显示导师更新前数据
	 * @return 返回更新前导师信息
	 */
	public String preModifySelfInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		teacherInfo = tutorInfoService.findTutorById(FUserNumber);
		return "preModifySelfInfo";
	}
	
	/**
	 * 导师修改个人信息
	 * @return 修改个人信息成功
	 */
	public String modifyselfInfo(){
		TabTeachers teacher=tutorInfoService.findTutorById(modifyInfo.getFTeacherNumber());
		teacher.setFTeacherName(modifyInfo.getFTeacherName());
		teacher.setFTeacherSex(modifyInfo.getFTeacherSex());
		teacher.setFTeacherBirthday(modifyInfo.getFTeacherBirthday());
		teacher.setFTeacherEmail(modifyInfo.getFTeacherEmail());
		teacher.setFTeacherPhone(modifyInfo.getFTeacherPhone());
		teacher.setFTeacherAddress(modifyInfo.getFTeacherAddress());
		teacher.setFTeacherTel(modifyInfo.getFTeacherTel());
		teacher.setFTeacherZhiCheng(modifyInfo.getFTeacherZhiCheng());
		teacher.setFTeacherPosition(modifyInfo.getFTeacherPosition());
		teacher.setFTeacherResearch(modifyInfo.getFTeacherResearch());
		teacher.setFTeacherAchieve(modifyInfo.getFTeacherAchieve());
		tutorInfoService.updateTutorInfo(teacher);
		return "modifyselfInfo";
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public TabTeachers getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TabTeachers teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public TabTeachers getModifyInfo() {
		return modifyInfo;
	}

	public void setModifyInfo(TabTeachers modifyInfo) {
		this.modifyInfo = modifyInfo;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

}
