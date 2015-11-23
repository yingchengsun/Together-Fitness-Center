package com.xdsc.action.yjssx_system;


import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.model.TabTeacherstype;
import com.xdsc.service.yjssx_system.TutorInfoService;
import com.xdsc.util.CommonConstVariable;

/**
 * �๦�ܣ���ʦ��Ϣ����
 * @author ����
 * @version 1.1
 */
public class AdminTutorInfoManageAction extends ActionSupport {

	private TutorInfoService tutorInfoService;
	
	/**
	 * ���ҵ��ĵ�ʦ��Ϣ
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * ��Ҫ��select��ǩ��ѡ��ĵ�ʦ��Ϣ
	 */
	private List<TabTeachers> tutorList;
	
	/**
	 * Ҫɾ���ĵ�ʦ��Id
	 */
	private List<String> delId;
	
	/**
	 * ���ݵ�ʦ������������ʦ��ϸ��Ϣ
	 */
	private String tutorName;
	
	/**
	 * ����ʦ������µ�ʦʱ��ʦId
	 */
	private List<String> newTutorId;
	
	/**
	 * ���һ���µ�ʦ���µ�ʦ����Ϣ
	 */
	private TabTeachers newTeacher;
	
	/**
	 * ��ӵ��µ�ʦ���û���������
	 */
	private String userName;
	
	private String password;
	
	private int p = 1;

	private int lastPage;

	/**
	 * ������ʾ���е�ʦ����Ϣ
	 * @return findAllTutor �������е�ʦ����Ϣ
	 */
	public String findAllTutor(){            //���ҳ����е�ʦ��Ϣ
		teacherList = tutorInfoService.findAllTutors();
		tutorList= teacherList;
		if(teacherList.size()>10){
			int pages = 10;
			int listlength = this.teacherList.size();
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
			this.teacherList = this.teacherList.subList(startIndex, endIndex);
		}
		return "findAllTutor";
	}
	
	/**
	 * ɾ��ĳ����ʦ����Ϣ
	 * @return deleteTutor ��ʦ��Ϣɾ���ɹ�
	 */
	public String deleteTutor(){             //ɾ��ĳ��ʦ��Ϣ
		for(int i=0;i<delId.size();i++){
			TabTeachers temp=tutorInfoService.findTutorById(delId.get(i));
			tutorInfoService.deleteTutorInfo(temp);
		}
		return "deleteTutor";
	}
	
	/**
	 * ���ݵ�ʦ����������ʦ��Ϣ
	 * @return searchTutor �����������ĵ�ʦ����Ϣ
	 */
	public String searchTutor(){                       //������ʦ��Ϣ
		teacherList = tutorInfoService.findAllTutors();
		tutorList = tutorInfoService.findTutorByName(tutorName);
		return "searchTutor";
	}
	
	/**
	 * ����µĵ�ʦ
	 * @return preAddNewTutor ����µĵ�ʦ�ɹ�
	 */
	public String preAddNewTutor(){                 //��ӵ�ʦ
		teacherList = tutorInfoService.findAllTeachers();
		tutorList = teacherList;
		if(teacherList.size()>10){
			int pages = 10;
			int listlength = this.teacherList.size();
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
			this.teacherList = this.teacherList.subList(startIndex, endIndex);
		}

		return "preAddNewTutor";
	}
	
	/**
	 * ��ӽ�ʦΪ��ʦ
	 * @return ����µĵ�ʦ�ɹ�
	 */
	public String addNewTutor(){                 //����µĵ�ʦ��Ϣ
		for(int i=0;i<newTutorId.size();i++){
			TabTeachers teacherTemp=tutorInfoService.findTutorById(newTutorId.get(i));
			TabTeacherstype type= new TabTeacherstype();
			type.setFTypeNumber(CommonConstVariable.TEACHER_TYPE_ID);
			type.setFTypeName(CommonConstVariable.TYPE_NAME);
			TabTeacherstotype to=new TabTeacherstotype();
			to.setTabTeachers(teacherTemp);
			to.setTabTeacherstype(type);
			tutorInfoService.addTutorType(to);
		}
		return "addNewTutor";
	}
	
	public String preAddNewTutorInfo(){
		return "preAddNewTutorInfo";
	}
	
	/**
	 * ����µĵ�ʦ��Ϣ
	 * @return ��ӵ�ʦ��Ϣ�ɹ�
	 */
	public String addNewTutorInfo(){                          //����µĽ�ʦ�����������Ϊ��ʦ
		MhqxTabUser NewUser= new MhqxTabUser();
		NewUser.setFUserNumber(userName);
		NewUser.setFUserPassword(password);
		tutorInfoService.addModuleUser(NewUser);
		newTeacher.setFTeacherNumber(userName);
		newTeacher.setMhqxTabUser(NewUser);
		tutorInfoService.addTeacher(newTeacher);              //�����ʦ��Ϣ
		TabTeacherstype type= new TabTeacherstype();            //���ý�ʦ������
		type.setFTypeNumber(CommonConstVariable.TEACHER_TYPE_ID);
		type.setFTypeName(CommonConstVariable.TYPE_NAME);
		TabTeacherstotype to =new TabTeacherstotype();        //����ʦ����Ϊ��ʦ
		to.setTabTeachers(newTeacher);		
		to.setTabTeacherstype(type);
		tutorInfoService.addTutorType(to);
		return "addNewTutorInfo";
	}
	/**
	 * ͨ����ʦ����������ʦ��Ϣ
	 * @return
	 */
	public String searchTeacher(){                //��ӵ�ʦ
		tutorList = tutorInfoService.findTutorByName(tutorName);
		teacherList= tutorInfoService.findAllTeachers();
		return "searchTeacher";
	}
		
	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public List<TabTeachers> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TabTeachers> teacherList) {
		this.teacherList = teacherList;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public List<String> getDelId() {
		return delId;
	}

	public void setDelId(List<String> delId) {
		this.delId = delId;
	}

	public List<String> getNewTutorId() {
		return newTutorId;
	}

	public void setNewTutorId(List<String> newTutorId) {
		this.newTutorId = newTutorId;
	}
	

	public TabTeachers getNewTeacher() {
		return newTeacher;
	}

	public void setNewTeacher(TabTeachers newTeacher) {
		this.newTeacher = newTeacher;
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

	public List<TabTeachers> getTutorList() {
		return tutorList;
	}

	public void setTutorList(List<TabTeachers> tutorList) {
		this.tutorList = tutorList;
	}


}
