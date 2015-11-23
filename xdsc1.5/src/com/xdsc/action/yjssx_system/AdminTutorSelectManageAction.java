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
 * �๦�ܣ���ʦѡ����Ϣ����
 * @author ����
 * @version 1.1
 */
public class AdminTutorSelectManageAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;

	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	private TutorInfoService tutorInfoService;

	/**
	 * ������select��ǩ���ṩ���е�ʦ������
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * ����־Ը���Ͳ��ҵ�ʦѡ�����Ϣ
	 */
	private List<YjssxTabTutorselect> tutorSelectInfo;
	
	/**
	 * ��ʦȷ�����������
	 */
	private String confirmInfo;
	
	/**
	 * �Ѿ�ѡ��ʦ���о�����Ϊѡ��ʦ���о�����ѯ
	 */
	private List<TabPostgraduate> student;//�鿴��ʦȷ�����
	
	private String selectInfo;          //�о���ѡ�������ѯ
	
	/**
	 * ־Ը����
	 */
	private String wish;            //����־Ը�����ѯ
	
	private String TutorName;          //��ʦ������ѯ
	
	private List<YjssxTabTutorselect> firstWish;        //��һ־Ը������
	
	private List<YjssxTabTutorselect> secondWish;       //�ڶ�־Ը������
	
	private List<YjssxTabTutorselect> thirdWish;          //����־Ը������
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * ������ת����ʦ��Ϣ����ҳ�棬ͬʱ�ṩselect��ǩ������
	 * @return preManage
	 */
	public String preManage(){            //��ʦѡ����Ϣ����
		teacherList = tutorInfoService.findAllTutors();
		return "preManage";
	}
	
	/**
	 * ����selectInfo=Y/N���Ͳ鿴��ѡ���Ϊѡ��ʦ���о���
	 * @return StudentSelectInfo
	 */
	public String StudentSelectInfo(){                //�о���ѡ�������ѯ,����student
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
			for(int i=0;i<stuList.size();i++){                    //�ҵ�δѡ��ʦ���о���
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
	 * ��ʦȷ�������ѯ��confirmInfo=Y/N�鿴��ȷ����ʦ��δȷ����ʦ���о���
	 * @return TutorConfirmInfoSearch
	 */
	public String TutorConfirmInfoSearch(){                  // ����ʦȷ�������ѯ,����student
		teacherList = tutorInfoService.findAllTutors();
		List<TabPostgraduate> stuList=postgraduateInfoService.findAllStudent();
		student = new ArrayList<TabPostgraduate>();
		if(confirmInfo.equals("Y")){                    //��ʦ��ѡ���Ѿ�ȷ�����о���
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getTabTeachers()!=null){
					student.add(stuList.get(i));
				}
			}
		}else{                                                 //��ʦ��ѡ��δȷ�����о���
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
	 * ��־Ը�͵�ʦ��������ѯ�о���ѡ��ʦ�����
	 * @return SelectInfoWishSearch
	 */
	public String SelectInfoWishSearch(){                           //��־Ը��ѯ
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
	 * ����ʦ��������ѯ����־Ը�������о���
	 * @return tutorSelectSearchByTutorName
	 */
	public String tutorSelectSearchByTutorName(){                  //����ʦ������ѯ
		teacherList = tutorInfoService.findAllTutors();
		List<YjssxTabTutorselect> list=postgraduateTutorSelectService.findAllTutorSelectInfo();
		firstWish = new ArrayList<YjssxTabTutorselect>();
		secondWish = new ArrayList<YjssxTabTutorselect>();
		thirdWish = new ArrayList<YjssxTabTutorselect>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTabTeachersByFFirstWish().getFTeacherName().equals(TutorName)){   //��һ־Ը������
				firstWish.add(list.get(i));
			}else if(list.get(i).getTabTeachersByFSecondWish().getFTeacherName().equals(TutorName)){  //�ڶ�־Ը������
				secondWish.add(list.get(i));
			}else{                                                   //����־Ը������
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
