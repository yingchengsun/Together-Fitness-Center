package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * 类功能：导师选择信息管理
 * @author 许鑫
 * @version 1.1
 */
public class AdminTutorSelectManageAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;

	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	private TutorInfoService tutorInfoService;

	/**
	 * 用于在select标签中提供所有导师的数据
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * 根据志愿类型查找导师选择的信息
	 */
	private List<YjssxTabTutorselect> tutorSelectInfo;
	
	/**
	 * 导师确认情况的类型
	 */
	private String confirmInfo;
	
	/**
	 * 已经选则导师的研究生和为选择导师的研究生查询
	 */
	private List<TabPostgraduate> student;//查看导师确定情况
	
	private String selectInfo;          //研究生选择情况查询
	
	/**
	 * 志愿类型
	 */
	private String wish;            //根据志愿情况查询
	
	private String TutorName;          //导师姓名查询
	
	private List<YjssxTabTutorselect> firstWish;        //第一志愿报考的
	
	private List<YjssxTabTutorselect> secondWish;       //第二志愿报考的
	
	private List<YjssxTabTutorselect> thirdWish;          //第三志愿报考的
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * 用于跳转到导师信息管理页面，同时提供select标签的数据
	 * @return preManage
	 */
	public String preManage(){            //导师选择信息管理
		teacherList = tutorInfoService.findAllTutors();
		return "preManage";
	}
	
	/**
	 * 根据selectInfo=Y/N类型查看已选择和为选择导师的研究生
	 * @return StudentSelectInfo
	 */
	public String StudentSelectInfo(){                //研究生选择情况查询,返回student
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		List<TabPostgraduate> stuList=postgraduateInfoService.findAllStudent();
		student = new ArrayList<TabPostgraduate>();
		if(selectInfo.equals("Y")){
			for(int i=0;i<list.size();i++){
				student.add(list.get(i).getTabPostgraduate());
			}
			return "tutorHaveSelect";
		}else{
			for(int i=0;i<stuList.size();i++){                    //找到未选择导师的研究生
				for(int j=0;j<list.size();j++){
					if(list.get(j).getTabPostgraduate().getFStudentNumber().equals(stuList.get(i).getFStudentNumber())){
						stuList.remove(i);
				 }
			  }
			}
			student=stuList;
			if(student.size()>10){
				int pages = 10;
				int listlength = this.student.size();
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
				this.student = this.student.subList(startIndex, endIndex);
			}	
			return "tutorNotSelect";
		}
	}
	
	/**
	 * 导师确定情况查询，confirmInfo=Y/N查看已确定导师和未确定导师的研究生
	 * @return TutorConfirmInfoSearch
	 */
	public String TutorConfirmInfoSearch(){                  // 按导师确定情况查询,返回student
		teacherList = tutorInfoService.findAllTutors();
		List<TabPostgraduate> stuList=postgraduateInfoService.findAllStudent();
		student = new ArrayList<TabPostgraduate>();
		if(confirmInfo.equals("Y")){                    //导师已选择已经确定的研究生
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getTabTeachers()!=null){
					student.add(stuList.get(i));
				}
			}
		}else{                                                 //导师已选择未确定的研究生
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getTabTeachers()==null){
					student.add(stuList.get(i));
				}
			}
		}
		if(student.size()>10){
			int pages = 10;
			int listlength = this.student.size();
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
			this.student = this.student.subList(startIndex, endIndex);
		}
		return "TutorConfirmInfoSearch";
	}
	
	/**
	 * 按志愿和导师的姓名查询研究生选择导师的情况
	 * @return SelectInfoWishSearch
	 */
	public String SelectInfoWishSearch(){                           //按志愿查询
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		tutorSelectInfo = new ArrayList<YjssxTabTutorselect>();
		if(wish.equals("first")){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTabTeachersByFFirstWish().getFTeacherName().equals(TutorName)){
					tutorSelectInfo.add(list.get(i));
				}
			}
		}else if(wish.equals("second")){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTabTeachersByFSecondWish().getFTeacherName().equals(TutorName)){
					tutorSelectInfo.add(list.get(i));
				}
			}
		}else{
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTabTeachersByFThirdWish().getFTeacherName().equals(TutorName)){
					tutorSelectInfo.add(list.get(i));
				}
			}
		}
		if(tutorSelectInfo.size()>10){
			int pages = 10;
			int listlength = this.tutorSelectInfo.size();
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
			this.tutorSelectInfo = this.tutorSelectInfo.subList(startIndex, endIndex);
		}

		return "SelectInfoWishSearch";
	}
	
	/**
	 * 按导师的姓名查询三个志愿报考的研究生
	 * @return tutorSelectSearchByTutorName
	 */
	public String tutorSelectSearchByTutorName(){                  //按导师姓名查询
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		firstWish = new ArrayList<YjssxTabTutorselect>();
		secondWish = new ArrayList<YjssxTabTutorselect>();
		thirdWish = new ArrayList<YjssxTabTutorselect>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTabTeachersByFFirstWish().getFTeacherName().equals(TutorName)){   //第一志愿报考的
				firstWish.add(list.get(i));
			}else if(list.get(i).getTabTeachersByFSecondWish().getFTeacherName().equals(TutorName)){  //第二志愿报考的
				secondWish.add(list.get(i));
			}else{                                                   //第三志愿报考的
				thirdWish.add(list.get(i));
			}
			
		}

		return "tutorSelectSearchByTutorName";
	}
	
//*************************************************************************
	public PostgraduateTutorSelectService getPostgraduateTutorSelectService() {
		return postgraduateTutorSelectService;
	}

	public void setPostgraduateTutorSelectService(
			PostgraduateTutorSelectService postgraduateTutorSelectService) {
		this.postgraduateTutorSelectService = postgraduateTutorSelectService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<YjssxTabTutorselect> getTutorSelectInfo() {
		return tutorSelectInfo;
	}

	public void setTutorSelectInfo(List<YjssxTabTutorselect> tutorSelectInfo) {
		this.tutorSelectInfo = tutorSelectInfo;
	}

	public String getConfirmInfo() {
		return confirmInfo;
	}

	public void setConfirmInfo(String confirmInfo) {
		this.confirmInfo = confirmInfo;
	}

	public List<TabPostgraduate> getStudent() {
		return student;
	}

	public void setStudent(List<TabPostgraduate> student) {
		this.student = student;
	}

	public String getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	public String getTutorName() {
		return TutorName;
	}

	public void setTutorName(String tutorName) {
		TutorName = tutorName;
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
}
