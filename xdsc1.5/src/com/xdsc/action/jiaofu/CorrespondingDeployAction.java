package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabStudentassociate;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.CorrespondingDeployManager;

/**
 * <p>功能：对应配置，主要是配置教辅系统的对应关系，分另包括：教师课程班级、班级课程学生、教师课程学生配置。<br>
 * 这里把课程类型总体分为两大类，分别是选修和必修。其中必修又包括方向课和校公共课程等。<br>
 * @author qianxun
 * @version 1.1
 */
public class CorrespondingDeployAction extends ActionSupport {

	/**service层对象，用于调用service层的方向*/
	private CorrespondingDeployManager correspondingDeployManager;
	// -------------------------教师班级课程-------------------------------------
	/**教师课程班级配置信息*/
	private List<JfptTabTeacherassociate> listTeacherDeployInfo;
	/**教师课程班级对象信息*/
	private JfptTabTeacherassociate jfptTabTeacherassociate;
	/**配置信息Id号*/
	private int FId;
	/**教师信息*/
	private List<TabTeachers> listTeachersInfo;
	/**班级信息*/
	private List<TabClasses> listClassesInfo;
	/**课程信息*/
	private List<TabCourse> listCourseInfo;
	/**Jsp页面中选择的教师信息Id号*/
	private String[] listSelectTeachersInfo;
	/**Jsp页面中选择的班级信息Id号*/
	private String[] listSelectClassesInfo;
	/**Jsp页面中选择的课程信息Id号*/
	private String[] listSelectCourseInfo;
	/**Jsp页面中选择的学生信息Id号*/
	private String[] listSelectStudentsInfo;

	// -------------------------学生课程班级-------------------------------------
	/**学生班级课程配置信息*/
	private List<JfptTabStudentassociate> listStudentDeployInfo;
	/**学生班级课程配置信息对象*/
	private JfptTabStudentassociate jfptTabStudentassociate;
	/**对象配置Id号*/
	private int FInt;
	// private List<TabClasses> listClassesInfo;
	/**学生信息*/
	private List<TabStudents> listStudentsInfo;
	// private List<TabCourse> listCourseInfo;

	// -------------------------教师课程学生-------------------------------------
	/**选修课程配置信息*/
	private List<JfptTabChooseassociate> listChooseDeployInfo;
	/**选修课程配置信息对象*/
	private JfptTabChooseassociate jfptTabChooseassociate;

	// --------------------------------------
	/**分页处理中记录当前页面号*/
	private int p = 1;
	/**分页处理中记录查询结果集的总页数*/
	private int lastPage;

	public CorrespondingDeployManager getCorrespondingDeployManager() {
		return correspondingDeployManager;
	}

	public void setCorrespondingDeployManager(
			CorrespondingDeployManager correspondingDeployManager) {
		this.correspondingDeployManager = correspondingDeployManager;
	}

	// public List<TabTeachers> getListSelectTeachersInfo() {
	// return listSelectTeachersInfo;
	// }
	//
	// public void setListSelectTeachersInfo(List<TabTeachers>
	// listSelectTeachersInfo) {
	// this.listSelectTeachersInfo = listSelectTeachersInfo;
	// }

	public List<JfptTabTeacherassociate> getListTeacherDeployInfo() {
		return listTeacherDeployInfo;
	}

	public void setListTeacherDeployInfo(
			List<JfptTabTeacherassociate> listTeacherDeployInfo) {
		this.listTeacherDeployInfo = listTeacherDeployInfo;
	}

	public JfptTabTeacherassociate getJfptTabTeacherassociate() {
		return jfptTabTeacherassociate;
	}

	public void setJfptTabTeacherassociate(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		this.jfptTabTeacherassociate = jfptTabTeacherassociate;
	}

	public List<TabTeachers> getListTeachersInfo() {
		return listTeachersInfo;
	}

	public void setListTeachersInfo(List<TabTeachers> listTeachersInfo) {
		this.listTeachersInfo = listTeachersInfo;
	}

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
	}

	public List<TabClasses> getListClassesInfo() {
		return listClassesInfo;
	}

	public void setListClassesInfo(List<TabClasses> listClassesInfo) {
		this.listClassesInfo = listClassesInfo;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int id) {
		FId = id;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public String[] getListSelectClassesInfo() {
		return listSelectClassesInfo;
	}

	public void setListSelectClassesInfo(String[] listSelectClassesInfo) {
		this.listSelectClassesInfo = listSelectClassesInfo;
	}

	public String[] getListSelectCourseInfo() {
		return listSelectCourseInfo;
	}

	public void setListSelectCourseInfo(String[] listSelectCourseInfo) {
		this.listSelectCourseInfo = listSelectCourseInfo;
	}

	public String[] getListSelectStudentsInfo() {
		return listSelectStudentsInfo;
	}

	public void setListSelectStudentsInfo(String[] listSelectStudentsInfo) {
		this.listSelectStudentsInfo = listSelectStudentsInfo;
	}

	public String[] getListSelectTeachersInfo() {
		return listSelectTeachersInfo;
	}

	public void setListSelectTeachersInfo(String[] listSelectTeachersInfo) {
		this.listSelectTeachersInfo = listSelectTeachersInfo;
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

	public JfptTabChooseassociate getJfptTabChooseassociate() {
		return jfptTabChooseassociate;
	}

	public void setJfptTabChooseassociate(
			JfptTabChooseassociate jfptTabChooseassociate) {
		this.jfptTabChooseassociate = jfptTabChooseassociate;
	}

	public List<JfptTabChooseassociate> getListChooseDeployInfo() {
		return listChooseDeployInfo;
	}

	public void setListChooseDeployInfo(
			List<JfptTabChooseassociate> listChooseDeployInfo) {
		this.listChooseDeployInfo = listChooseDeployInfo;
	}

	public JfptTabStudentassociate getJfptTabStudentassociate() {
		return jfptTabStudentassociate;
	}

	public void setJfptTabStudentassociate(
			JfptTabStudentassociate jfptTabStudentassociate) {
		this.jfptTabStudentassociate = jfptTabStudentassociate;
	}

	public int getFInt() {
		return FInt;
	}

	public void setFInt(int int1) {
		FInt = int1;
	}

	public List<JfptTabStudentassociate> getListStudentDeployInfo() {
		return listStudentDeployInfo;
	}

	public void setListStudentDeployInfo(
			List<JfptTabStudentassociate> listStudentDeployInfo) {
		this.listStudentDeployInfo = listStudentDeployInfo;
	}

	// -------------------------教师班级课程-------------------------------------
	/**
	 * <p>功能：查询教师配置信息<br>
	 * @return action findTeacherDeployInfo
	 */
	public String findTeacherDeployInfo() {
		listTeacherDeployInfo = correspondingDeployManager.findTeacherDeployInfo();

		// --------------------------分页处理------------------------------
		int pages = 5;
		int listlength = listTeacherDeployInfo.size();
		if (listlength == 0)
			return "findTeacherDeployInfo";
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
		listTeacherDeployInfo = listTeacherDeployInfo.subList(startIndex,endIndex);

		return "findTeacherDeployInfo";
	}

	/**
	 * <p>功能：删除教师配置信息<br>
	 * @return action deleteTeacherInfoByID
	 */
	public String deleteTeacherInfoByID() {
		jfptTabTeacherassociate = correspondingDeployManager
				.findTeacherDeployInfoByID(FId);
		System.out.println("***********&&&&&&&&&&&&&&&&&&&****************1"
				+ FId);
		correspondingDeployManager
				.deleteTeacherDeployInfo(jfptTabTeacherassociate);
		System.out.println("***********&&&&&&&&&&&&&&&&&&&****************2"
				+ FId);

		listTeacherDeployInfo = correspondingDeployManager
				.findTeacherDeployInfo();
		return "deleteTeacherInfoByID";
	}

	/**
	 * <p>功能：查询相关信息，便于在Jsp页面中对教师信息进行配置<br>
	 * @return action addInfoIntoTeacherDeploy
	 */
	public String addInfoIntoTeacherDeploy() {
		listTeachersInfo = correspondingDeployManager.findlistTeachersInfo();
		listClassesInfo = correspondingDeployManager.findlistClassesInfo();
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();

		return "addInfoIntoTeacherDeploy";
	}

	/**
	 * <p>功能：查询相关信息，便于在Jsp页面中进行学生相关信息配置<br>
	 * @return action addInfoIntoStudentDeploy
	 */
	public String addInfoIntoStudentDeploy() {
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();
		listStudentsInfo = correspondingDeployManager.findlistStudentsInfo();
		return "addInfoIntoStudentDeploy";
	}

	/**
	 * <p>功能：添加教师配置信息<br>
	 * @return action addTeacherDeploy
	 */
	public String addTeacherDeploy() {
		for (int i = 0; i < listSelectClassesInfo.length; i++) {

			JfptTabTeacherassociate jfptTabTeacherassociate1 = new JfptTabTeacherassociate();
			TabClasses tabClasses = new TabClasses();
			tabClasses = correspondingDeployManager
					.findClassesInfoByID(listSelectClassesInfo[i]);
			jfptTabTeacherassociate1.setTabClasses(tabClasses);
			TabCourse tabCourse = new TabCourse();
			tabCourse = correspondingDeployManager
					.findCourseInfoByID(listSelectCourseInfo[0]);
			jfptTabTeacherassociate1.setTabCourse(tabCourse);
			TabTeachers tabTeachers = new TabTeachers();
			tabTeachers = correspondingDeployManager
					.findTeachersInfoByID(listSelectTeachersInfo[0]);
			jfptTabTeacherassociate1.setTabTeachers(tabTeachers);
			correspondingDeployManager
					.addTeacherassociateInfo(jfptTabTeacherassociate1);
		}

		listTeacherDeployInfo = correspondingDeployManager
				.findTeacherDeployInfo();
		return "addTeacherDeploy";
	}

	/**
	 * <p>功能：添加学生配置信息<br>
	 * @return action addStudentDeploy
	 */
	public String addStudentDeploy() {
		for (int i = 0; i < listSelectCourseInfo.length; i++) {
			for (int j = 0; j < listSelectStudentsInfo.length; j++) {
				JfptTabStudentassociate jfptTabStudentassociate1 = new JfptTabStudentassociate();
				TabCourse tabCourse = new TabCourse();
				tabCourse = correspondingDeployManager
						.findCourseInfoByID(listSelectCourseInfo[i]);
				jfptTabStudentassociate1.setTabCourse(tabCourse);
				TabStudents tabStudents = new TabStudents();
				tabStudents = correspondingDeployManager
						.findStudentsInfoByID(listSelectStudentsInfo[j]);
				jfptTabStudentassociate1.setTabStudents(tabStudents);
				TabClasses tabClasses = new TabClasses();
				tabClasses = correspondingDeployManager
						.findClassesInfoBySid(listSelectStudentsInfo[j]);
				jfptTabStudentassociate1.setTabClasses(tabClasses);
				correspondingDeployManager
						.addStudentassociateInfo(jfptTabStudentassociate1);
			}
		}
		listStudentDeployInfo = correspondingDeployManager
				.findStudentDeployInfo();
		return "addStudentDeploy";
	}

	// -------------------------学生课程班级-------------------------------------
	/**
	 * <p>功能：查询学生配置信息，并对结果进行分页处理<br>
	 * @return action findStudentDeployInfo
	 */
	public String findStudentDeployInfo() {
		listStudentDeployInfo = correspondingDeployManager
				.findStudentDeployInfo();
		// --------------------------分页处理------------------------------
		int pages = 5;
		int listlength = listStudentDeployInfo.size();
		if (listlength == 0)
			return "findStudentDeployInfo";
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
		listStudentDeployInfo = listStudentDeployInfo.subList(startIndex,
				endIndex);

		return "findStudentDeployInfo";
	}

	/**
	 * <p>功能：通过学生配置信息Id号删除相关的配置信息<br>
	 * @return action deleteStudentInfoByID
	 */
	public String deleteStudentInfoByID() {
		jfptTabStudentassociate = correspondingDeployManager
				.findStudentDeployInfoByID(FInt);
		correspondingDeployManager
				.deleteStudentDeployInfo(jfptTabStudentassociate);

		listStudentDeployInfo = correspondingDeployManager
				.findStudentDeployInfo();
		return "deleteStudentInfoByID";
	}

	// -------------------------教师课程学生-------------------------------------
	/**
	 * <p>功能：查询相关信息，便于在Jsp页面中对选修课程进行配置<br>
	 * @return action addInfoIntoOtherDeploy
	 */
	public String addInfoIntoOtherDeploy() {
		listTeachersInfo = correspondingDeployManager.findlistTeachersInfo();
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();
		listStudentsInfo = correspondingDeployManager.findlistStudentsInfo();
		return "addInfoIntoOtherDeploy";
	}

	/**
	 * <p>功能：添加选修课程配置信息<br>
	 * @return action addOtherDeploy
	 */
	public String addOtherDeploy() {
		for (int i = 0; i < listSelectStudentsInfo.length; i++) {
			JfptTabChooseassociate jfptTabChooseassociate1 = new JfptTabChooseassociate();
			TabCourse tabCourse = new TabCourse();
			tabCourse = correspondingDeployManager
					.findCourseInfoByID(listSelectCourseInfo[0]);
			jfptTabChooseassociate1.setTabCourse(tabCourse);
			TabStudents tabStudents = new TabStudents();
			tabStudents = correspondingDeployManager
					.findStudentsInfoByID(listSelectStudentsInfo[i]);
			jfptTabChooseassociate1.setTabStudents(tabStudents);
			TabTeachers tabTeachers = new TabTeachers();
			tabTeachers = correspondingDeployManager
					.findTeachersInfoByID(listSelectTeachersInfo[0]);
			jfptTabChooseassociate1.setTabTeachers(tabTeachers);
			correspondingDeployManager
					.addChooseassociateInfo(jfptTabChooseassociate1);
		}
		listChooseDeployInfo = correspondingDeployManager.findOtherDeployInfo();
		return "addOtherDeploy";
	}

	/**
	 * <p>功能：查询选修课程配置信息,并对结果进行分页处理<br>
	 * @return action findOtherDeployInfo
	 */
	public String findOtherDeployInfo() {
		listChooseDeployInfo = correspondingDeployManager.findOtherDeployInfo();
		
		int pages = 5;
		int listlength = listChooseDeployInfo.size();
		if(listlength==0)
			return "findOtherDeployInfo";
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
		listChooseDeployInfo = listChooseDeployInfo.subList(startIndex, endIndex);	
		
		return "findOtherDeployInfo";
	}

	/**
	 * <p>功能：根据选修配置信息Id号删除相关的配置信息<br>
	 * @return action deleteOtherInfoByID
	 */
	public String deleteOtherInfoByID() {
		jfptTabChooseassociate = correspondingDeployManager
				.findOtherDeployInfoByID(FId);
		correspondingDeployManager
				.deleteOtherDeployInfo(jfptTabChooseassociate);

		listChooseDeployInfo = correspondingDeployManager.findOtherDeployInfo();
		return "deleteOtherInfoByID";
	}
}
