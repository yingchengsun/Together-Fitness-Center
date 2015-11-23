package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselectdispach;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.StudentSelectTutorDispachService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * �๦�ܣ���ʦ�����о���
 * @author ����
 * @version 1.1
 */
public class TutorReceiveStudentAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private StudentSelectTutorDispachService studentSelectTutorDispachService;
	
	private TutorInfoService tutorInfoService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private List<TabPostgraduate> studentList;
	
	private List<String> stuId; 
	
	private int p = 1;

	private int lastPage;

	
	/**
	 * ���ҵ�����Ա������õ�ʦ���о���
	 * @return �����о����б�
	 */
	public String findAllDispachedStudent(){             //�������б�����Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<YjssxTabTutorselectdispach> list=studentSelectTutorDispachService.findDispachInfoByTutorNum(FUserNumber);
		studentList = new ArrayList<TabPostgraduate>();
		for(int i=0;i<list.size();i++){
			studentList.add(list.get(i).getTabPostgraduate());
		}
		if(studentList.size()==0){
			return "AdminNotDispachStudent";
		}
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
		
		return "findAllDispachedStudent";
	}
	
	/**
	 * ��ʦȷ�������о�����ѡ���о���
	 * @return ������δ�����˵���δȷ����ʦ���о���
	 */
	public String confirmToAcceptStudent(){                //ȷ�������о���
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<YjssxTabTutorselectdispach> list=studentSelectTutorDispachService.findDispachInfoByTutorNum(FUserNumber);
		studentList = new ArrayList<TabPostgraduate>();
		for(int i=0;i<list.size();i++){                        //�ҵ�δȷ����ʦ���о���
			if(list.get(i).getTabPostgraduate().getTabTeachers()==null){
				studentList.add(list.get(i).getTabPostgraduate());
			}
		}
		if(studentList.size()==0){                 //���з������ʦ���о����Ѿ�ȷ���˵�ʦ
			return "AllDispachedStudentHasConfirm";
		}
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
		
		return "confirmToAcceptStudent";
	}
	
	/**
	 * ȷ�����գ����о�����ӵ�ʦ
	 * @return �ɹ������о���
	 */
	public String confirmTOAccept(){                 //����ѡ����Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		TabTeachers teacher= tutorInfoService.findTutorById(FUserNumber);
		TabPostgraduate student=new TabPostgraduate();
		for(int i=0;i<stuId.size();i++){
			student=postgraduateInfoService.findPostgraduateByStuNumber(stuId.get(i));
			student.setTabTeachers(teacher);
			postgraduateInfoService.updatePostgraduateStuInfo(student);
		}
		return "confirmTOAccept";
	}

	public StudentSelectTutorDispachService getStudentSelectTutorDispachService() {
		return studentSelectTutorDispachService;
	}

	public void setStudentSelectTutorDispachService(
			StudentSelectTutorDispachService studentSelectTutorDispachService) {
		this.studentSelectTutorDispachService = studentSelectTutorDispachService;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public List<String> getStuId() {
		return stuId;
	}

	public void setStuId(List<String> stuId) {
		this.stuId = stuId;
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
