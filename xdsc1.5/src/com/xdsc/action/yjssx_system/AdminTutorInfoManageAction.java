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
 * 类功能：导师信息管理
 * @author 许鑫
 * @version 1.1
 */
public class AdminTutorInfoManageAction extends ActionSupport {

	private TutorInfoService tutorInfoService;
	
	/**
	 * 查找到的导师信息
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * 需要在select标签总选择的导师信息
	 */
	private List<TabTeachers> tutorList;
	
	/**
	 * 要删除的导师的Id
	 */
	private List<String> delId;
	
	/**
	 * 根据导师的姓名搜索导师详细信息
	 */
	private String tutorName;
	
	/**
	 * 将教师分配成新导师时教师Id
	 */
	private List<String> newTutorId;
	
	/**
	 * 添加一个新导师，新导师的信息
	 */
	private TabTeachers newTeacher;
	
	/**
	 * 添加的新导师的用户名和密码
	 */
	private String userName;
	
	private String password;
	
	private int p = 1;

	private int lastPage;

	/**
	 * 用于显示所有导师的信息
	 * @return findAllTutor 返回所有导师的信息
	 */
	public String findAllTutor(){            //查找出所有导师信息
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
	 * 删除某个导师的信息
	 * @return deleteTutor 导师信息删除成功
	 */
	public String deleteTutor(){             //删除某导师信息
		for(int i=0;i<delId.size();i++){
			TabTeachers temp=tutorInfoService.findTutorById(delId.get(i));
			tutorInfoService.deleteTutorInfo(temp);
		}
		return "deleteTutor";
	}
	
	/**
	 * 根据导师姓名搜索导师信息
	 * @return searchTutor 返回搜索到的导师的信息
	 */
	public String searchTutor(){                       //搜索导师信息
		teacherList = tutorInfoService.findAllTutors();
		tutorList = tutorInfoService.findTutorByName(tutorName);
		return "searchTutor";
	}
	
	/**
	 * 添加新的导师
	 * @return preAddNewTutor 添加新的导师成功
	 */
	public String preAddNewTutor(){                 //添加导师
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
	 * 添加教师为导师
	 * @return 添加新的导师成功
	 */
	public String addNewTutor(){                 //添加新的导师信息
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
	 * 添加新的导师信息
	 * @return 添加导师信息成功
	 */
	public String addNewTutorInfo(){                          //添加新的教师，并将其添加为导师
		MhqxTabUser NewUser= new MhqxTabUser();
		NewUser.setFUserNumber(userName);
		NewUser.setFUserPassword(password);
		tutorInfoService.addModuleUser(NewUser);
		newTeacher.setFTeacherNumber(userName);
		newTeacher.setMhqxTabUser(NewUser);
		tutorInfoService.addTeacher(newTeacher);              //保存教师信息
		TabTeacherstype type= new TabTeacherstype();            //设置教师的类型
		type.setFTypeNumber(CommonConstVariable.TEACHER_TYPE_ID);
		type.setFTypeName(CommonConstVariable.TYPE_NAME);
		TabTeacherstotype to =new TabTeacherstotype();        //给教师分配为导师
		to.setTabTeachers(newTeacher);		
		to.setTabTeacherstype(type);
		tutorInfoService.addTutorType(to);
		return "addNewTutorInfo";
	}
	/**
	 * 通过导师姓名搜索导师信息
	 * @return
	 */
	public String searchTeacher(){                //添加导师
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
