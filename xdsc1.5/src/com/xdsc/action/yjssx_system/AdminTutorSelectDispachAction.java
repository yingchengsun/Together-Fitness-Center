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
 * 类功能：通过导师选择信息将研究生分发给导师
 * @author 许鑫
 * @version 1.1
 */
public class AdminTutorSelectDispachAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private StudentSelectTutorDispachService studentSelectTutorDispachService;
	
	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * 确定将研究生给导师
	 */
	private List<TabPostgraduate> studentList;
	
	private List<TabTeachers> tutorList;
	
	/**
	 * 根据导师的Id查找导师的信息
	 */
	private String tutorId;
	
	/**
	 * 分配给导师的研究生的Id
	 */
	private List<String> StuId;                    //分配研究生
	
	/**
	 * 根据导师的姓名查找第一第二第三志愿报考的研究生
	 */
	private String TutorName;
	
	private String studentName;
	
	private TabTeachers tutor;
	
	private List<TabTeachers> teacherList;
	
	/**
	 * 第一，第二，第三志愿报考的研究生
	 */
	private List<YjssxTabTutorselect> firstWish;        //第一志愿报考的
	
	private List<YjssxTabTutorselect> secondWish;       //第二志愿报考的
	
	private List<YjssxTabTutorselect> thirdWish;          //第三志愿报考的
	
	/**
	 * 研究生调剂，导师名单和研究生名单
	 */
	private String SId;
	
	private String TId;
	
	/**
	 * 给导师分配研究生，在select标签中显示导师列表
	 * @return 返回导师列表 teacherList
	 */
	public String preDispachStudent(){
		teacherList = tutorInfoService.findAllTutors();
		return "preDispachStudent";
	}
	
	/**
	 * 给导师分配研究生
	 * @return 将研究生分配给导师
	 */
	public String disDispachStudent(){                              //分配报名的研究生给导师
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
	 * 通过导师的Id查找出导师的三个志愿报名的研究生
	 * @return 返回三个志愿报名该导师的信息
	 */
	public String dispachSearchByTutorName(){                  //按导师姓名查询
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		tutor = tutorInfoService.findTutorById(TutorName);         //修改-----通过id查而不是name
		firstWish = new ArrayList<YjssxTabTutorselect>();
		secondWish = new ArrayList<YjssxTabTutorselect>();
		thirdWish = new ArrayList<YjssxTabTutorselect>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTabTeachersByFFirstWish().getFTeacherNumber().equals(TutorName)){   //第一志愿报考的
				firstWish.add(list.get(i));
			}else if(list.get(i).getTabTeachersByFSecondWish().getFTeacherNumber().equals(TutorName)){  //第二志愿报考的
				secondWish.add(list.get(i));
			}else{                                                   //第三志愿报考的
				thirdWish.add(list.get(i));
			}
			
		}
		return "dispachSearchByTutorName";
	}
	
	/**
	 * 将研究生调剂给导师
	 * @return 返回teacherList用来填充数据
	 */
	public String preConfirmAddStuToTutor(){
		teacherList = tutorInfoService.findAllTutors();
		return "preConfirmAddStuToTutor";
	}
	
	/**
	 * 根据导师研究生姓名查找导师和研究生信息
	 * @return 返回搜素结果
	 */
	public String confirmAddStudentToTutor(){                    //研究生调剂
		studentList=postgraduateInfoService.findStudentByName(studentName);
		tutorList = tutorInfoService.findTutorByName(TutorName);
		return "confirmAddStudentToTutor";
	}
	
	/**
	 * 保存研究生调剂信息
	 * @return 保存成功
	 */
	public String saveConfirmInfo(){                        //研究生调剂信息的保存
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
