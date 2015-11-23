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
 * <p>功能：管理员对教辅的基本信息进行管理，其中包括课程信息管理、方向信息管理、类型信息管理、教师信息管理、助教信息管理<br>
 * <p>这部分功能只是对基本信息进行记录、修改和删除，是为整个教辅平台做一个信息基础<br>
 * @author qianxun
 * @version 1.1
 * @see com.opensymphony.xwork2.ActionSupport
 */
public class BasicInfoManageAction extends ActionSupport {

	//---------------------课程相关成员信息---------------------------
	/**课程对象*/
	private TabCourse tabCourse;
	/**service层对象，用于调用service层的方法*/
	private BasicInfoManageManager basicInfoManageManager;
	/**课程类型对象的集合*/
	private List<TabCourse> listCourseInfo;
	/**课程编号*/
	private String FCourseNumber;
	/**课程名称*/
	private String FCourseName;
	/**学分*/
	private double FCourseScore;
	/**学时*/
	private String FCourseXueShi;
	/**备注*/
	private String FRemark;
	/**输入的课程名称以供选择查询*/
	private String FCourseNameselect;
	//---------------------方向相关成员信息---------------------------
	/**课程方向信息列表*/
	private List<TabDirection> listDirectionInfo;
	/**课程方向对象*/
	private TabDirection tabDirection;
	/**课程方向ID*/
	private int FDirectionId;
	/**课程方向名称*/
	private String FDirectionName;
	//---------------------类型相关成员信息---------------------------
	/**课程类型信息列表*/
	private List<TabCoursetype> listCoursetypeInfo;
	/**课程类型Id*/
	private int FNumber;
	/**课程类型对象*/
	private TabCoursetype tabCoursetype;
	/**课程类型信息*/
	private String FCourseType;
	/**课程方向信息*/
	private List<TabDirection> tabDirectionselect;
	/**课程信息*/
	private List<TabCourse> tabCourseselect;
	//---------------------教师相关成员信息---------------------------
	/**教师信息*/
	private List<TabTeachers> listTeacherInfo;
	/**教师对象*/
	private TabTeachers tabTeachers;
	/**教师职工号*/
	private String FTeacherNumber;
	/**教师姓名*/
	private String FTeacherName;
	/**账号状态*/
	private String FIsLocked;
	//---------------------助教相关成员信息---------------------------	
	/**院外助教信息*/
	private List<JfptTabOtherassist> listOtherassistInfo;
	/**助教对象*/
	private JfptTabOtherassist jfptTabOtherassist;
	/**助教Id号*/
	private String FAssistantId;
	/**姓名*/
	private String FName;
	/**性别*/
	private String FSex;
	/**分页处理中当前页面号*/
	private int p = 1;
	/**分页处理中结果集的页面总数*/
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
     * <p>功能：查找课程信息，并进行分页处理<br>
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
	 * <p>功能：通过课程Id号删除课程信息<br>
	 * @return action deleteCourseInfoByID
	 */
	public String deleteCourseInfoByID(){
		tabCourse = basicInfoManageManager.findCourseInfoByID(FCourseNumber);
		basicInfoManageManager.deleteCourseInfo(tabCourse);
		
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		return "deleteCourseInfoByID";
	}
	
	/**
	 * <p>功能：通过课程Id号查找课程信息<br>
	 * @return action findCourseInfoByID
	 */
	public String findCourseInfoByID(){
		tabCourse = basicInfoManageManager.findCourseInfoByID(FCourseNumber);
		return "findCourseInfoByID";
	}
	
	/**
	 * <p>功能：更新课程信息<br>
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
	 * <p>功能：添加课程信息<br>
	 * @return action addCourseInfo
	 */
	public String addCourseInfo(){
		TabCourse tabCourse1 = new TabCourse();
		tabCourse1.setFCourseNumber(FCourseNumber);
		tabCourse1.setFCourseName(FCourseName);
		System.out.println(FCourseScore+"---------------------------------学分");
		tabCourse1.setFCourseScore(FCourseScore);
		tabCourse1.setFCourseXueShi(FCourseXueShi);
		tabCourse1.setFRemark(FRemark);
		basicInfoManageManager.addTabCourseInfo(tabCourse1);
		
		listCourseInfo = basicInfoManageManager.findCourseInfo();
		return "addCourseInfo";
	}
	
	/**
	 * <p>功能：通过课程名称相关课程信息<br>
	 * @return action findCourseInfoByName
	 */
	public String findCourseInfoByName(){
		listCourseInfo = basicInfoManageManager.findCourseInfoByName(FCourseNameselect);
		return "findCourseInfoByName";
	}
	
	//-----------------------------方向相关-----------------------------------------
	/**
	 * <p>功能：查找方向信息，并对结果进行分页处理<br>
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
	 * <p>功能：通过方向Id号查找方向信息，并进行删除<br>
	 * @return action deleteDirectionInfoByID
	 */
	public String deleteDirectionInfoByID(){
		tabDirection = basicInfoManageManager.findDirectionByID(FDirectionId);
		
		basicInfoManageManager.deleteDirectionInfo(tabDirection);
		listDirectionInfo = basicInfoManageManager.findDirectionInfo();
		return "deleteDirectionInfoByID";
	}
	
	/**
	 * <p>功能：添加方向信息<br>
	 * @return action AddDirectionInfo
	 */
	public String AddDirectionInfo(){
		TabDirection tabDirection1 = new TabDirection();
		tabDirection1.setFDirectionName(FDirectionName);
		
		basicInfoManageManager.addDirectionInfo(tabDirection1);
		listDirectionInfo = basicInfoManageManager.findDirectionInfo();
		return "AddDirectionInfo";
	}
	
	//---------------------------------类型相关------------------------------------
	/**
	 * <p>功能：查找课程类型信息，并对结果进行分页处理<br>
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
	 * <p>功能：根据课程类型信息Id号删除课程信息<br>
	 * @return action deleteCoursetypeInfoByID
	 */
	public String deleteCoursetypeInfoByID(){
		tabCoursetype = basicInfoManageManager.findCoursetypeInfoByID(FNumber);
		basicInfoManageManager.deleteCoursetypeInfo(tabCoursetype);
		
		listCoursetypeInfo = basicInfoManageManager.findCoursetypeInfo();
		return "deleteCoursetypeInfoByID";
	}
	
	/**
	 * <p>功能：添加课程类型信息<br>
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
	 * <p>功能：查找课程方向信息、课程信息，在Jsp页面中用于选择<br>
	 * @return action addInfoIntoCoursetype
	 */
	public String addInfoIntoCoursetype(){
		
		tabDirectionselect = basicInfoManageManager.findDirectionInfo();
		tabCourseselect = basicInfoManageManager.findCourseInfo();
		return "addInfoIntoCoursetype";
	}
	
	//---------------------------------教师相关------------------------------------
	/**
	 * <p>功能：查找教师信息，并对结果进行分页处理<br>
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
	 * <p>功能：根据教师职工号查找教师对象，然后删除<br>
	 * @return action deleteTeacherInfoByID
	 */
	public String deleteTeacherInfoByID(){
		tabTeachers = basicInfoManageManager.findTeacherInfoByID(FTeacherNumber);
		basicInfoManageManager.deleteTeacherInfo(tabTeachers);
		
		listTeacherInfo = basicInfoManageManager.findTeacherInfo();
		return "deleteTeacherInfoByID";
	}
	
	/**
	 * <p>功能：根据教师职工号查找教师详细信息<br>
	 * @return action findTeacherInfoDetailByID
	 */
	public String findTeacherInfoDetailByID(){
		tabTeachers = basicInfoManageManager.findTeacherInfoByID(FTeacherNumber);
		return "findTeacherInfoDetailByID";
	}
	
	/**
	 * <p>功能：添加教师信息<br>
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
	
	//---------------------------------助教相关------------------------------------
	/**
	 * <p>功能：查找院外助教信息，并对结果集进行分页处理<br>
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
	 * <p>功能：根据助教Id号删除院外助教信息<br>
	 * @return action deleteOtherInfoByID
	 */
	public String deleteOtherInfoByID(){
		jfptTabOtherassist = basicInfoManageManager.findOtherInfoByID(FAssistantId);
		basicInfoManageManager.deleteOtherInfo(jfptTabOtherassist);
		
		listOtherassistInfo = basicInfoManageManager.findOtherInfo();
		return "deleteOtherInfoByID";
	}
	
	/**
	 * <p>功能：添加院外助教信息<br>
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
