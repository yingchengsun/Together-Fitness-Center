package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabCoursetype;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.BasicInfoManageManager;

/**
 * <p>���ܣ�����Ա�Խ̸��Ļ�����Ϣ���й������а����γ���Ϣ����������Ϣ����������Ϣ������ʦ��Ϣ����������Ϣ����<br>
 * <p>�ⲿ�ֹ���ֻ�ǶԻ�����Ϣ���м�¼���޸ĺ�ɾ������Ϊ�����̸�ƽ̨��һ����Ϣ����<br>
 * @author qianxun
 * @version 1.1
 * @see com.opensymphony.xwork2.ActionSupport
 */
public class BasicInfoManageAction extends ActionSupport {

	//---------------------�γ���س�Ա��Ϣ---------------------------
	/**�γ̶���*/
	private TabCourse tabCourse;
	/**service��������ڵ���service��ķ���*/
	private BasicInfoManageManager basicInfoManageManager;
	/**�γ����Ͷ���ļ���*/
	private List<TabCourse> listCourseInfo;
	/**�γ̱��*/
	private String FCourseNumber;
	/**�γ�����*/
	private String FCourseName;
	/**ѧ��*/
	private double FCourseScore;
	/**ѧʱ*/
	private String FCourseXueShi;
	/**��ע*/
	private String FRemark;
	/**����Ŀγ������Թ�ѡ���ѯ*/
	private String FCourseNameselect;
	//---------------------������س�Ա��Ϣ---------------------------
	/**�γ̷�����Ϣ�б�*/
	private List<TabDirection> listDirectionInfo;
	/**�γ̷������*/
	private TabDirection tabDirection;
	/**�γ̷���ID*/
	private int FDirectionId;
	/**�γ̷�������*/
	private String FDirectionName;
	//---------------------������س�Ա��Ϣ---------------------------
	/**�γ�������Ϣ�б�*/
	private List<TabCoursetype> listCoursetypeInfo;
	/**�γ�����Id*/
	private int FNumber;
	/**�γ����Ͷ���*/
	private TabCoursetype tabCoursetype;
	/**�γ�������Ϣ*/
	private String FCourseType;
	/**�γ̷�����Ϣ*/
	private List<TabDirection> tabDirectionselect;
	/**�γ���Ϣ*/
	private List<TabCourse> tabCourseselect;
	//---------------------��ʦ��س�Ա��Ϣ---------------------------
	/**��ʦ��Ϣ*/
	private List<TabTeachers> listTeacherInfo;
	/**��ʦ����*/
	private TabTeachers tabTeachers;
	/**��ʦְ����*/
	private String FTeacherNumber;
	/**��ʦ����*/
	private String FTeacherName;
	/**�˺�״̬*/
	private String FIsLocked;
	//---------------------������س�Ա��Ϣ---------------------------	
	/**Ժ��������Ϣ*/
	private List<JfptTabOtherassist> listOtherassistInfo;
	/**���̶���*/
	private JfptTabOtherassist jfptTabOtherassist;
	/**����Id��*/
	private String FAssistantId;
	/**����*/
	private String FName;
	/**�Ա�*/
	private String FSex;
	/**��ҳ�����е�ǰҳ���*/
	private int p = 1;
	/**��ҳ�����н������ҳ������*/
	private int lastPage;
	
	public TabTeachers getTabTeachers() {
		return tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public String getFCourseXueShi() {
		return FCourseXueShi;
	}

	public void setFCourseXueShi(String courseXueShi) {
		FCourseXueShi = courseXueShi;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public String getFTeacherName() {
		return FTeacherName;
	}

	public void setFTeacherName(String teacherName) {
		FTeacherName = teacherName;
	}

	public String getFIsLocked() {
		return FIsLocked;
	}

	public void setFIsLocked(String isLocked) {
		FIsLocked = isLocked;
	}


	public List<TabTeachers> getListTeacherInfo() {
		return listTeacherInfo;
	}

	public void setListTeacherInfo(List<TabTeachers> listTeacherInfo) {
		this.listTeacherInfo = listTeacherInfo;
	}

	public List<TabDirection> getTabDirectionselect() {
		return tabDirectionselect;
	}

	public void setTabDirectionselect(List<TabDirection> tabDirectionselect) {
		this.tabDirectionselect = tabDirectionselect;
	}

	public List<TabCourse> getTabCourseselect() {
		return tabCourseselect;
	}

	public void setTabCourseselect(List<TabCourse> tabCourseselect) {
		this.tabCourseselect = tabCourseselect;
	}

	public String getFCourseType() {
		return FCourseType;
	}

	public void setFCourseType(String courseType) {
		FCourseType = courseType;
	}

	public List<JfptTabOtherassist> getListOtherassistInfo() {
		return listOtherassistInfo;
	}

	public void setListOtherassistInfo(List<JfptTabOtherassist> listOtherassistInfo) {
		this.listOtherassistInfo = listOtherassistInfo;
	}

	public TabCoursetype getTabCoursetype() {
		return tabCoursetype;
	}

	public void setTabCoursetype(TabCoursetype tabCoursetype) {
		this.tabCoursetype = tabCoursetype;
	}

	public JfptTabOtherassist getJfptTabOtherassist() {
		return jfptTabOtherassist;
	}

	public void setJfptTabOtherassist(JfptTabOtherassist jfptTabOtherassist) {
		this.jfptTabOtherassist = jfptTabOtherassist;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String name) {
		FName = name;
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

	public String getFSex() {
		return FSex;
	}

	public void setFSex(String sex) {
		FSex = sex;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
	}

	public String getFAssistantId() {
		return FAssistantId;
	}

	public void setFAssistantId(String assistantId) {
		FAssistantId = assistantId;
	}

	public List<TabCoursetype> getListCoursetypeInfo() {
		return listCoursetypeInfo;
	}

	public void setListCoursetypeInfo(List<TabCoursetype> listCoursetypeInfo) {
		this.listCoursetypeInfo = listCoursetypeInfo;
	}

	public String getFDirectionName() {
		return FDirectionName;
	}

	public void setFDirectionName(String directionName) {
		FDirectionName = directionName;
	}

	public int getFDirectionId() {
		return FDirectionId;
	}

	public void setFDirectionId(int directionId) {
		FDirectionId = directionId;
	}

	public TabDirection getTabDirection() {
		return tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public List<TabDirection> getListDirectionInfo() {
		return listDirectionInfo;
	}

	public void setListDirectionInfo(List<TabDirection> listDirectionInfo) {
		this.listDirectionInfo = listDirectionInfo;
	}

	public String getFCourseNameselect() {
		return FCourseNameselect;
	}

	public void setFCourseNameselect(String courseNameselect) {
		FCourseNameselect = courseNameselect;
	}

	public String getFCourseName() {
		return FCourseName;
	}

	public void setFCourseName(String courseName) {
		FCourseName = courseName;
	}

	public double getFCourseScore() {
		return FCourseScore;
	}

	public void setFCourseScore(double courseScore) {
		FCourseScore = courseScore;
	}

	public String getFRemark() {
		return FRemark;
	}

	public void setFRemark(String remark) {
		FRemark = remark;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public BasicInfoManageManager getBasicInfoManageManager() {
		return basicInfoManageManager;
	}

	public void setBasicInfoManageManager(
			BasicInfoManageManager basicInfoManageManager) {
		this.basicInfoManageManager = basicInfoManageManager;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}
	
    /**
     * <p>���ܣ����ҿγ���Ϣ�������з�ҳ����<br>
     * @return action findCourseInfo
     */
	public String findCourseInfo(){
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		
		int pages = 5;
		int listlength = listCourseInfo.size();
		if(listlength==0)
			return "findCourseInfo";
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
		listCourseInfo = listCourseInfo.subList(startIndex, endIndex);		
		
		return "findCourseInfo";
	}
	
	/**
	 * <p>���ܣ�ͨ���γ�Id��ɾ���γ���Ϣ<br>
	 * @return action deleteCourseInfoByID
	 */
	public String deleteCourseInfoByID(){
		tabCourse = basicInfoManageManager.findCourseInfoByID(FCourseNumber);
		basicInfoManageManager.deleteCourseInfo(tabCourse);
		
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		return "deleteCourseInfoByID";
	}
	
	/**
	 * <p>���ܣ�ͨ���γ�Id�Ų��ҿγ���Ϣ<br>
	 * @return action findCourseInfoByID
	 */
	public String findCourseInfoByID(){
		tabCourse = basicInfoManageManager.findCourseInfoByID(FCourseNumber);
		return "findCourseInfoByID";
	}
	
	/**
	 * <p>���ܣ����¿γ���Ϣ<br>
	 * @return action updateCourseInfo
	 */
	public String updateCourseInfo(){
		tabCourse.setFCourseName(FCourseName);
		tabCourse.setFCourseScore(FCourseScore);
		tabCourse.setFCourseXueShi(FCourseXueShi);
		tabCourse.setFRemark(FRemark);
		System.out.println(tabCourse.getFCourseScore()+"----------------------------");
		basicInfoManageManager.updateCourseInfo(tabCourse);
		
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		return "updateCourseInfo";
	}
	
	/**
	 * <p>���ܣ���ӿγ���Ϣ<br>
	 * @return action addCourseInfo
	 */
	public String addCourseInfo(){
		TabCourse tabCourse1 = new TabCourse();
		tabCourse1.setFCourseNumber(FCourseNumber);
		tabCourse1.setFCourseName(FCourseName);
		System.out.println(FCourseScore+"---------------------------------ѧ��");
		tabCourse1.setFCourseScore(FCourseScore);
		tabCourse1.setFCourseXueShi(FCourseXueShi);
		tabCourse1.setFRemark(FRemark);
		basicInfoManageManager.addTabCourseInfo(tabCourse1);
		
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		return "addCourseInfo";
	}
	
	/**
	 * <p>���ܣ�ͨ���γ�������ؿγ���Ϣ<br>
	 * @return action findCourseInfoByName
	 */
	public String findCourseInfoByName(){
		listCourseInfo = basicInfoManageManager.findCourseInfoByName(FCourseNameselect);
		return "findCourseInfoByName";
	}
	
	//-----------------------------�������-----------------------------------------
	/**
	 * <p>���ܣ����ҷ�����Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findDirectionInfo
	 */
	public String findDirectionInfo(){
		listDirectionInfo = basicInfoManageManager.findDirectionInfo();
		
		int pages = 5;
		int listlength = listDirectionInfo.size();
		if(listlength==0)
			return "findDirectionInfo";
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
		listDirectionInfo = listDirectionInfo.subList(startIndex, endIndex);
		
		return "findDirectionInfo";
	}
	
	/**
	 * <p>���ܣ�ͨ������Id�Ų��ҷ�����Ϣ��������ɾ��<br>
	 * @return action deleteDirectionInfoByID
	 */
	public String deleteDirectionInfoByID(){
		tabDirection = basicInfoManageManager.findDirectionByID(FDirectionId);
		
		basicInfoManageManager.deleteDirectionInfo(tabDirection);
		listDirectionInfo = basicInfoManageManager.findDirectionInfo();
		return "deleteDirectionInfoByID";
	}
	
	/**
	 * <p>���ܣ���ӷ�����Ϣ<br>
	 * @return action AddDirectionInfo
	 */
	public String AddDirectionInfo(){
		TabDirection tabDirection1 = new TabDirection();
		tabDirection1.setFDirectionName(FDirectionName);
		
		basicInfoManageManager.addDirectionInfo(tabDirection1);
		listDirectionInfo = basicInfoManageManager.findDirectionInfo();
		return "AddDirectionInfo";
	}
	
	//---------------------------------�������------------------------------------
	/**
	 * <p>���ܣ����ҿγ�������Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findCoursetypeInfo
	 */
	public String findCoursetypeInfo(){
		listCoursetypeInfo = basicInfoManageManager.findCoursetypeInfo();
		
		int pages = 5;
		int listlength = listCoursetypeInfo.size();
		if(listlength==0)
			return "findCoursetypeInfo";
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
		listCoursetypeInfo = listCoursetypeInfo.subList(startIndex, endIndex);
		
		return "findCoursetypeInfo";
	}
	
	/**
	 * <p>���ܣ����ݿγ�������ϢId��ɾ���γ���Ϣ<br>
	 * @return action deleteCoursetypeInfoByID
	 */
	public String deleteCoursetypeInfoByID(){
		tabCoursetype = basicInfoManageManager.findCoursetypeInfoByID(FNumber);
		basicInfoManageManager.deleteCoursetypeInfo(tabCoursetype);
		
		listCoursetypeInfo = basicInfoManageManager.findCoursetypeInfo();
		return "deleteCoursetypeInfoByID";
	}
	
	/**
	 * <p>���ܣ���ӿγ�������Ϣ<br>
	 * @return action addCoursetypeInfo
	 */
	public String addCoursetypeInfo(){
		TabCoursetype tabCoursetype1 = new TabCoursetype();
		TabCourse tabCourse2 = new TabCourse();
		tabCourse2 = basicInfoManageManager.findCourseInfoByID(FCourseNumber);
		tabCoursetype1.setTabCourse(tabCourse2);
		
		TabDirection tabDirection2 = new TabDirection();
		tabDirection2 = basicInfoManageManager.findDirectionByID(FDirectionId);
		tabCoursetype1.setTabDirection(tabDirection2);
		
		tabCoursetype1.setFCourseType(FCourseType);
		basicInfoManageManager.addTabCoursetype(tabCoursetype1);
		
		listCoursetypeInfo = basicInfoManageManager.findCoursetypeInfo();
		return "addCoursetypeInfo";
	}
	
	/**
	 * <p>���ܣ����ҿγ̷�����Ϣ���γ���Ϣ����Jspҳ��������ѡ��<br>
	 * @return action addInfoIntoCoursetype
	 */
	public String addInfoIntoCoursetype(){
		
		tabDirectionselect = basicInfoManageManager.findDirectionInfo();
		tabCourseselect = basicInfoManageManager.findCourseInfo();
		return "addInfoIntoCoursetype";
	}
	
	//---------------------------------��ʦ���------------------------------------
	/**
	 * <p>���ܣ����ҽ�ʦ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findTeacherInfo
	 */
	public String findTeacherInfo(){
		listTeacherInfo = basicInfoManageManager.findTeacherInfo();
		
		int pages = 5;
		int listlength = listTeacherInfo.size();
		if(listlength==0)
			return "findTeacherInfo";
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
		listTeacherInfo = listTeacherInfo.subList(startIndex, endIndex);
		
		return "findTeacherInfo";
	}
	              
	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ����Ȼ��ɾ��<br>
	 * @return action deleteTeacherInfoByID
	 */
	public String deleteTeacherInfoByID(){
		tabTeachers = basicInfoManageManager.findTeacherInfoByID(FTeacherNumber);
		basicInfoManageManager.deleteTeacherInfo(tabTeachers);
		
		listTeacherInfo = basicInfoManageManager.findTeacherInfo();
		return "deleteTeacherInfoByID";
	}
	
	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ��ϸ��Ϣ<br>
	 * @return action findTeacherInfoDetailByID
	 */
	public String findTeacherInfoDetailByID(){
		tabTeachers = basicInfoManageManager.findTeacherInfoByID(FTeacherNumber);
		return "findTeacherInfoDetailByID";
	}
	
	/**
	 * <p>���ܣ���ӽ�ʦ��Ϣ<br>
	 * @return action addTeacherInfo
	 */
	public String addTeacherInfo(){
		TabTeachers tabTeachers1 = new TabTeachers();
		tabTeachers1.setFTeacherNumber(FTeacherNumber);
		tabTeachers1.setFTeacherName(FTeacherName);
		tabTeachers1.setFIsLocked(FIsLocked);
		basicInfoManageManager.addTeacherInfo(tabTeachers1);
		
		listTeacherInfo = basicInfoManageManager.findTeacherInfo();
		return "addTeacherInfo";
	}
	
	//---------------------------------�������------------------------------------
	/**
	 * <p>���ܣ�����Ժ��������Ϣ�����Խ�������з�ҳ����<br>
	 * @return action findOtherInfo
	 */
	public String findOtherInfo(){
		listOtherassistInfo = basicInfoManageManager.findOtherInfo();
		
		int pages = 5;
		int listlength = listOtherassistInfo.size();
		if(listlength==0)
			return "findOtherInfo";
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
		listOtherassistInfo = listOtherassistInfo.subList(startIndex, endIndex);	
		
		return "findOtherInfo";
	}
	
	/**
	 * <p>���ܣ���������Id��ɾ��Ժ��������Ϣ<br>
	 * @return action deleteOtherInfoByID
	 */
	public String deleteOtherInfoByID(){
		jfptTabOtherassist = basicInfoManageManager.findOtherInfoByID(FAssistantId);
		basicInfoManageManager.deleteOtherInfo(jfptTabOtherassist);
		
		listOtherassistInfo = basicInfoManageManager.findOtherInfo();
		return "deleteOtherInfoByID";
	}
	
	/**
	 * <p>���ܣ����Ժ��������Ϣ<br>
	 * @return action addOtherInfo
	 */
	public String addOtherInfo(){
		JfptTabOtherassist jfptTabOtherassist1 = new JfptTabOtherassist();
		jfptTabOtherassist1.setFAssistantId(FAssistantId);
		jfptTabOtherassist1.setFName(FName);
		jfptTabOtherassist1.setFSex(FSex);
		
		basicInfoManageManager.addOtherInfo(jfptTabOtherassist1);
		
		listOtherassistInfo = basicInfoManageManager.findOtherInfo();
		return "addOtherInfo";
	}
}
