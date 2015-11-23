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
 * <p>���ܣ���Ӧ���ã���Ҫ�����ý̸�ϵͳ�Ķ�Ӧ��ϵ�������������ʦ�γ̰༶���༶�γ�ѧ������ʦ�γ�ѧ�����á�<br>
 * ����ѿγ����������Ϊ�����࣬�ֱ���ѡ�޺ͱ��ޡ����б����ְ�������κ�У�����γ̵ȡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class CorrespondingDeployAction extends ActionSupport {

	/**service��������ڵ���service��ķ���*/
	private CorrespondingDeployManager correspondingDeployManager;
	// -------------------------��ʦ�༶�γ�-------------------------------------
	/**��ʦ�γ̰༶������Ϣ*/
	private List<JfptTabTeacherassociate> listTeacherDeployInfo;
	/**��ʦ�γ̰༶������Ϣ*/
	private JfptTabTeacherassociate jfptTabTeacherassociate;
	/**������ϢId��*/
	private int FId;
	/**��ʦ��Ϣ*/
	private List<TabTeachers> listTeachersInfo;
	/**�༶��Ϣ*/
	private List<TabClasses> listClassesInfo;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**Jspҳ����ѡ��Ľ�ʦ��ϢId��*/
	private String[] listSelectTeachersInfo;
	/**Jspҳ����ѡ��İ༶��ϢId��*/
	private String[] listSelectClassesInfo;
	/**Jspҳ����ѡ��Ŀγ���ϢId��*/
	private String[] listSelectCourseInfo;
	/**Jspҳ����ѡ���ѧ����ϢId��*/
	private String[] listSelectStudentsInfo;

	// -------------------------ѧ���γ̰༶-------------------------------------
	/**ѧ���༶�γ�������Ϣ*/
	private List<JfptTabStudentassociate> listStudentDeployInfo;
	/**ѧ���༶�γ�������Ϣ����*/
	private JfptTabStudentassociate jfptTabStudentassociate;
	/**��������Id��*/
	private int FInt;
	// private List<TabClasses> listClassesInfo;
	/**ѧ����Ϣ*/
	private List<TabStudents> listStudentsInfo;
	// private List<TabCourse> listCourseInfo;

	// -------------------------��ʦ�γ�ѧ��-------------------------------------
	/**ѡ�޿γ�������Ϣ*/
	private List<JfptTabChooseassociate> listChooseDeployInfo;
	/**ѡ�޿γ�������Ϣ����*/
	private JfptTabChooseassociate jfptTabChooseassociate;

	// --------------------------------------
	/**��ҳ�����м�¼��ǰҳ���*/
	private int p = 1;
	/**��ҳ�����м�¼��ѯ���������ҳ��*/
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

	// -------------------------��ʦ�༶�γ�-------------------------------------
	/**
	 * <p>���ܣ���ѯ��ʦ������Ϣ<br>
	 * @return action findTeacherDeployInfo
	 */
	public String findTeacherDeployInfo() {
		listTeacherDeployInfo = correspondingDeployManager.findTeacherDeployInfo();

		// --------------------------��ҳ����------------------------------
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
	 * <p>���ܣ�ɾ����ʦ������Ϣ<br>
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
	 * <p>���ܣ���ѯ�����Ϣ��������Jspҳ���жԽ�ʦ��Ϣ��������<br>
	 * @return action addInfoIntoTeacherDeploy
	 */
	public String addInfoIntoTeacherDeploy() {
		listTeachersInfo = correspondingDeployManager.findlistTeachersInfo();
		listClassesInfo = correspondingDeployManager.findlistClassesInfo();
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();

		return "addInfoIntoTeacherDeploy";
	}

	/**
	 * <p>���ܣ���ѯ�����Ϣ��������Jspҳ���н���ѧ�������Ϣ����<br>
	 * @return action addInfoIntoStudentDeploy
	 */
	public String addInfoIntoStudentDeploy() {
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();
		listStudentsInfo = correspondingDeployManager.findlistStudentsInfo();
		return "addInfoIntoStudentDeploy";
	}

	/**
	 * <p>���ܣ���ӽ�ʦ������Ϣ<br>
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
	 * <p>���ܣ����ѧ��������Ϣ<br>
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

	// -------------------------ѧ���γ̰༶-------------------------------------
	/**
	 * <p>���ܣ���ѯѧ��������Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findStudentDeployInfo
	 */
	public String findStudentDeployInfo() {
		listStudentDeployInfo = correspondingDeployManager
				.findStudentDeployInfo();
		// --------------------------��ҳ����------------------------------
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
	 * <p>���ܣ�ͨ��ѧ��������ϢId��ɾ����ص�������Ϣ<br>
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

	// -------------------------��ʦ�γ�ѧ��-------------------------------------
	/**
	 * <p>���ܣ���ѯ�����Ϣ��������Jspҳ���ж�ѡ�޿γ̽�������<br>
	 * @return action addInfoIntoOtherDeploy
	 */
	public String addInfoIntoOtherDeploy() {
		listTeachersInfo = correspondingDeployManager.findlistTeachersInfo();
		listCourseInfo = correspondingDeployManager.findlistCourseInfo();
		listStudentsInfo = correspondingDeployManager.findlistStudentsInfo();
		return "addInfoIntoOtherDeploy";
	}

	/**
	 * <p>���ܣ����ѡ�޿γ�������Ϣ<br>
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
	 * <p>���ܣ���ѯѡ�޿γ�������Ϣ,���Խ�����з�ҳ����<br>
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
	 * <p>���ܣ�����ѡ��������ϢId��ɾ����ص�������Ϣ<br>
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
