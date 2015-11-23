package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.model.YjssxTabTutorselectdispach;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;
import com.xdsc.service.yjssx_system.StudentSelectTutorDispachService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * �๦�ܣ�ͨ����ʦѡ����Ϣ���о����ַ�����ʦ
 * @author ����
 * @version 1.1
 */
public class AdminTutorSelectDispachAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private StudentSelectTutorDispachService studentSelectTutorDispachService;
	
	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * ȷ�����о�������ʦ
	 */
	private List<TabPostgraduate> studentList;
	
	private List<TabTeachers> tutorList;
	
	/**
	 * ���ݵ�ʦ��Id���ҵ�ʦ����Ϣ
	 */
	private String tutorId;
	
	/**
	 * �������ʦ���о�����Id
	 */
	private List<String> StuId;                    //�����о���
	
	/**
	 * ���ݵ�ʦ���������ҵ�һ�ڶ�����־Ը�������о���
	 */
	private String TutorName;
	
	private String studentName;
	
	private TabTeachers tutor;
	
	private List<TabTeachers> teacherList;
	
	/**
	 * ��һ���ڶ�������־Ը�������о���
	 */
	private List<YjssxTabTutorselect> firstWish;        //��һ־Ը������
	
	private List<YjssxTabTutorselect> secondWish;       //�ڶ�־Ը������
	
	private List<YjssxTabTutorselect> thirdWish;          //����־Ը������
	
	/**
	 * �о�����������ʦ�������о�������
	 */
	private String SId;
	
	private String TId;
	
	/**
	 * ����ʦ�����о�������select��ǩ����ʾ��ʦ�б�
	 * @return ���ص�ʦ�б� teacherList
	 */
	public String preDispachStudent(){
		teacherList = tutorInfoService.findAllTutors();
		return "preDispachStudent";
	}
	
	/**
	 * ����ʦ�����о���
	 * @return ���о����������ʦ
	 */
	public String disDispachStudent(){                              //���䱨�����о�������ʦ
		TabTeachers teacher= tutorInfoService.findTutorById(tutorId);
		YjssxTabTutorselectdispach dispach=new YjssxTabTutorselectdispach();
		TabPostgraduate student=new TabPostgraduate();
		for(int i=0;i<StuId.size();i++){
			student=postgraduateInfoService.findPostgraduateByStuNumber(StuId.get(i));
			dispach.setTabPostgraduate(student);
			dispach.setTabTeachers(teacher);
			studentSelectTutorDispachService.addDispachedStudent(dispach);
		}
		return "disDispachStudent";
	}
	
	/**
	 * ͨ����ʦ��Id���ҳ���ʦ������־Ը�������о���
	 * @return ��������־Ը�����õ�ʦ����Ϣ
	 */
	public String dispachSearchByTutorName(){                  //����ʦ������ѯ
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		tutor = tutorInfoService.findTutorById(TutorName);         //�޸�-----ͨ��id�������name
		firstWish = new ArrayList<YjssxTabTutorselect>();
		secondWish = new ArrayList<YjssxTabTutorselect>();
		thirdWish = new ArrayList<YjssxTabTutorselect>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTabTeachersByFFirstWish().getFTeacherNumber().equals(TutorName)){   //��һ־Ը������
				firstWish.add(list.get(i));
			}else if(list.get(i).getTabTeachersByFSecondWish().getFTeacherNumber().equals(TutorName)){  //�ڶ�־Ը������
				secondWish.add(list.get(i));
			}else{                                                   //����־Ը������
				thirdWish.add(list.get(i));
			}
			
		}
		return "dispachSearchByTutorName";
	}
	
	/**
	 * ���о�����������ʦ
	 * @return ����teacherList�����������
	 */
	public String preConfirmAddStuToTutor(){
		teacherList = tutorInfoService.findAllTutors();
		return "preConfirmAddStuToTutor";
	}
	
	/**
	 * ���ݵ�ʦ�о����������ҵ�ʦ���о�����Ϣ
	 * @return �������ؽ��
	 */
	public String confirmAddStudentToTutor(){                    //�о�������
		studentList=postgraduateInfoService.findStudentByName(studentName);
		tutorList = tutorInfoService.findTutorByName(TutorName);
		return "confirmAddStudentToTutor";
	}
	
	/**
	 * �����о���������Ϣ
	 * @return ����ɹ�
	 */
	public String saveConfirmInfo(){                        //�о���������Ϣ�ı���
		TabTeachers teacher1= tutorInfoService.findTutorById(TId);
		TabPostgraduate student1=postgraduateInfoService.findPostgraduateByStuNumber(SId);
		student1.setTabTeachers(teacher1);
		postgraduateInfoService.updatePostgraduateStuInfo(student1);
		return "saveConfirmInfo";
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public StudentSelectTutorDispachService getStudentSelectTutorDispachService() {
		return studentSelectTutorDispachService;
	}

	public void setStudentSelectTutorDispachService(
			StudentSelectTutorDispachService studentSelectTutorDispachService) {
		this.studentSelectTutorDispachService = studentSelectTutorDispachService;
	}

	public PostgraduateTutorSelectService getPostgraduateTutorSelectService() {
		return postgraduateTutorSelectService;
	}

	public void setPostgraduateTutorSelectService(
			PostgraduateTutorSelectService postgraduateTutorSelectService) {
		this.postgraduateTutorSelectService = postgraduateTutorSelectService;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public List<String> getStuId() {
		return StuId;
	}

	public void setStuId(List<String> stuId) {
		StuId = stuId;
	}

	public String getTutorName() {
		return TutorName;
	}

	public void setTutorName(String tutorName) {
		TutorName = tutorName;
	}

	public TabTeachers getTutor() {
		return tutor;
	}

	public void setTutor(TabTeachers tutor) {
		this.tutor = tutor;
	}

	public List<YjssxTabTutorselect> getFirstWish() {
		return firstWish;
	}

	public void setFirstWish(List<YjssxTabTutorselect> firstWish) {
		this.firstWish = firstWish;
	}

	public List<YjssxTabTutorselect> getSecondWish() {
		return secondWish;
	}

	public void setSecondWish(List<YjssxTabTutorselect> secondWish) {
		this.secondWish = secondWish;
	}

	public List<YjssxTabTutorselect> getThirdWish() {
		return thirdWish;
	}

	public void setThirdWish(List<YjssxTabTutorselect> thirdWish) {
		this.thirdWish = thirdWish;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<TabTeachers> getTutorList() {
		return tutorList;
	}

	public void setTutorList(List<TabTeachers> tutorList) {
		this.tutorList = tutorList;
	}

	public String getSId() {
		return SId;
	}

	public void setSId(String id) {
		SId = id;
	}

	public String getTId() {
		return TId;
	}

	public void setTId(String id) {
		TId = id;
	}

	public List<TabTeachers> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TabTeachers> teacherList) {
		this.teacherList = teacherList;
	}
}
