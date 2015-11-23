package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;

/**
 * 类功能：研究生选择导师
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateSelectTutorAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * 修改导师选择信息时先查找到已选择的导师信息
	 */
	private YjssxTabTutorselect selectedTutor;
	
	/**
	 * 导师选择时的三个志愿
	 */
	private String tutorId1;
	
	private String tutorId2;
	
	private String tutorId3;
	
	private String Comment; 
	
	/**
	 * 某个研究生选择导师的详情
	 */
	private String StudenNum;

	private YjssxTabTutorselect SelectInfo;
	
	/**
	 * 根据研究生的学号查找导师选择信息
	 * @return
	 */
	public String StudentSelectTutorInfo(){
		SelectInfo = postgraduateTutorSelectService.tutorSelectInfoByStuNum(StudenNum);
		return "StudentSelectTutorInfo";
	}
	
	/**
	 * 研究生选择导师
	 * @return selectTutor导师选择成功
	 */
	public String selectTutor(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabTeachers tutor1=postgraduateTutorSelectService.findTutorInfoByNum(tutorId1);
		TabTeachers tutor2=postgraduateTutorSelectService.findTutorInfoByNum(tutorId2);
		TabTeachers tutor3=postgraduateTutorSelectService.findTutorInfoByNum(tutorId3);
		YjssxTabTutorselect selectInfo=new YjssxTabTutorselect();
		selectInfo.setFStudentNumber(FUserNumber);	
		selectInfo.setTabTeachersByFFirstWish(tutor1);
		selectInfo.setTabTeachersByFSecondWish(tutor2);
		selectInfo.setTabTeachersByFThirdWish(tutor3);
		postgraduateTutorSelectService.addTutorSelectInfo(selectInfo);
		return "selectTutor";
	}
	
	/**
	 * 研究生修改导师选择信息
	 * @return 返回导师选择信息
	 */
	public String preUpdateTutorInfo(){		
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		selectedTutor = postgraduateTutorSelectService.findSelectedTutorInfo(FUserNumber);
		return "preUpdateTutorInfo";
	}
	
	/**
	 * 修改导师选择信息
	 * @return 修改导师选择信息成功
	 */
	public String updateTutorSelect(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabTeachers tutor1=postgraduateTutorSelectService.findTutorInfoByNum(tutorId1);
		TabTeachers tutor2=postgraduateTutorSelectService.findTutorInfoByNum(tutorId2);
		TabTeachers tutor3=postgraduateTutorSelectService.findTutorInfoByNum(tutorId3);
		YjssxTabTutorselect selectInfo=new YjssxTabTutorselect();
		selectInfo.setFStudentNumber(FUserNumber);	
		selectInfo.setTabTeachersByFFirstWish(tutor1);
		selectInfo.setTabTeachersByFSecondWish(tutor2);
		selectInfo.setTabTeachersByFThirdWish(tutor3);
		postgraduateTutorSelectService.updateTutorSelect(selectInfo);
		return "updateTutorSelect";
	}
	
	/**
	 * 显示已选择的导师的信息
	 * @return 返回已经选择的导师的信息
	 */
	public String SelectedTutorInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		selectedTutor = postgraduateTutorSelectService.findSelectedTutorInfo(FUserNumber);
		return "SelectedTutorInfo";
	}

	public PostgraduateTutorSelectService getPostgraduateTutorSelectService() {
		return postgraduateTutorSelectService;
	}

	public void setPostgraduateTutorSelectService(
			PostgraduateTutorSelectService postgraduateTutorSelectService) {
		this.postgraduateTutorSelectService = postgraduateTutorSelectService;
	}

	public String getTutorId1() {
		return tutorId1;
	}

	public void setTutorId1(String tutorId1) {
		this.tutorId1 = tutorId1;
	}

	public String getTutorId2() {
		return tutorId2;
	}

	public void setTutorId2(String tutorId2) {
		this.tutorId2 = tutorId2;
	}

	public String getTutorId3() {
		return tutorId3;
	}

	public void setTutorId3(String tutorId3) {
		this.tutorId3 = tutorId3;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public YjssxTabTutorselect getSelectedTutor() {
		return selectedTutor;
	}

	public void setSelectedTutor(YjssxTabTutorselect selectedTutor) {
		this.selectedTutor = selectedTutor;
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

	public YjssxTabTutorselect getSelectInfo() {
		return SelectInfo;
	}

	public void setSelectInfo(YjssxTabTutorselect selectInfo) {
		SelectInfo = selectInfo;
	}

	public String getStudenNum() {
		return StudenNum;
	}

	public void setStudenNum(String studenNum) {
		StudenNum = studenNum;
	}

}
