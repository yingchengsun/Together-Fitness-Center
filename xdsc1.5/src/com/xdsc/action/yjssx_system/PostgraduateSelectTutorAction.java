package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;

/**
 * �๦�ܣ��о���ѡ��ʦ
 * @author ����
 * @version 1.1
 */
public class PostgraduateSelectTutorAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * �޸ĵ�ʦѡ����Ϣʱ�Ȳ��ҵ���ѡ��ĵ�ʦ��Ϣ
	 */
	private YjssxTabTutorselect selectedTutor;
	
	/**
	 * ��ʦѡ��ʱ������־Ը
	 */
	private String tutorId1;
	
	private String tutorId2;
	
	private String tutorId3;
	
	private String Comment; 
	
	/**
	 * ĳ���о���ѡ��ʦ������
	 */
	private String StudenNum;

	private YjssxTabTutorselect SelectInfo;
	
	/**
	 * �����о�����ѧ�Ų��ҵ�ʦѡ����Ϣ
	 * @return
	 */
	public String StudentSelectTutorInfo(){
		SelectInfo = postgraduateTutorSelectService.tutorSelectInfoByStuNum(StudenNum);
		return "StudentSelectTutorInfo";
	}
	
	/**
	 * �о���ѡ��ʦ
	 * @return selectTutor��ʦѡ��ɹ�
	 */
	public String selectTutor(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
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
	 * �о����޸ĵ�ʦѡ����Ϣ
	 * @return ���ص�ʦѡ����Ϣ
	 */
	public String preUpdateTutorInfo(){		
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		selectedTutor = postgraduateTutorSelectService.findSelectedTutorInfo(FUserNumber);
		return "preUpdateTutorInfo";
	}
	
	/**
	 * �޸ĵ�ʦѡ����Ϣ
	 * @return �޸ĵ�ʦѡ����Ϣ�ɹ�
	 */
	public String updateTutorSelect(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
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
	 * ��ʾ��ѡ��ĵ�ʦ����Ϣ
	 * @return �����Ѿ�ѡ��ĵ�ʦ����Ϣ
	 */
	public String SelectedTutorInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
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
