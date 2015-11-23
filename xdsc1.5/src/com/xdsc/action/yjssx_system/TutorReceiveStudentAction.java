package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabTutorselectdispach;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.StudentSelectTutorDispachService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * 类功能：导师接收研究生
 * @author 许鑫
 * @version 1.1
 */
public class TutorReceiveStudentAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private StudentSelectTutorDispachService studentSelectTutorDispachService;
	
	private TutorInfoService tutorInfoService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private List<TabPostgraduate> studentList;
	
	private List<String> stuId; 
	
	private int p = 1;

	private int lastPage;

	
	/**
	 * 查找到管理员分配给该导师的研究生
	 * @return 返回研究生列表
	 */
	public String findAllDispachedStudent(){             //查找所有报名信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<YjssxTabTutorselectdispach> list=studentSelectTutorDispachService.findDispachInfoByTutorNum(FUserNumber);
		studentList = new ArrayList<TabPostgraduate>();
		for(int i=0;i<list.size();i++){
			studentList.add(list.get(i).getTabPostgraduate());
		}
		if(studentList.size()==0){
			return "AdminNotDispachStudent";
		}
		if(studentList.size()>10){
			int pages = 10;
			int listlength = this.studentList.size();
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
			this.studentList = this.studentList.subList(startIndex, endIndex);	
		}
		
		return "findAllDispachedStudent";
	}
	
	/**
	 * 导师确定接收研究生，选择研究生
	 * @return 返回尚未分配了但尚未确定导师的研究生
	 */
	public String confirmToAcceptStudent(){                //确定接受研究生
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<YjssxTabTutorselectdispach> list=studentSelectTutorDispachService.findDispachInfoByTutorNum(FUserNumber);
		studentList = new ArrayList<TabPostgraduate>();
		for(int i=0;i<list.size();i++){                        //找到未确定导师的研究生
			if(list.get(i).getTabPostgraduate().getTabTeachers()==null){
				studentList.add(list.get(i).getTabPostgraduate());
			}
		}
		if(studentList.size()==0){                 //所有分配给导师的研究生已经确定了导师
			return "AllDispachedStudentHasConfirm";
		}
		if(studentList.size()>10){
			int pages = 10;
			int listlength = this.studentList.size();
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
			this.studentList = this.studentList.subList(startIndex, endIndex);	
		}
		
		return "confirmToAcceptStudent";
	}
	
	/**
	 * 确定接收，给研究生添加导师
	 * @return 成功接收研究生
	 */
	public String confirmTOAccept(){                 //保存选择信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabTeachers teacher= tutorInfoService.findTutorById(FUserNumber);
		TabPostgraduate student=new TabPostgraduate();
		for(int i=0;i<stuId.size();i++){
			student=postgraduateInfoService.findPostgraduateByStuNumber(stuId.get(i));
			student.setTabTeachers(teacher);
			postgraduateInfoService.updatePostgraduateStuInfo(student);
		}
		return "confirmTOAccept";
	}

	public StudentSelectTutorDispachService getStudentSelectTutorDispachService() {
		return studentSelectTutorDispachService;
	}

	public void setStudentSelectTutorDispachService(
			StudentSelectTutorDispachService studentSelectTutorDispachService) {
		this.studentSelectTutorDispachService = studentSelectTutorDispachService;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public List<String> getStuId() {
		return stuId;
	}

	public void setStuId(List<String> stuId) {
		this.stuId = stuId;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}
}
