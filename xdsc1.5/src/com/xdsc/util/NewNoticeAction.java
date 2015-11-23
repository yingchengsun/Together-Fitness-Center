package com.xdsc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.jiaofu.TeacherHomeworkManageDAO;
import com.xdsc.dao.wzmh_system.impl.NoticeToDaoImpl;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.service.yjssx_system.SystomNoticeService;

public class NewNoticeAction extends ActionSupport implements SessionAware{
	
	private NoticeToDaoImpl noticeToDaoImpl;
	
	private TeacherHomeworkManageDAO teacherHomeworkManageDAO; 
	private Long homeworkcount;
	private int isTeacher;
	private Map session;
	
	private SystomNoticeService systomNoticeService;
	
	private List<TabNotice> noticeList;
	
	private String FUserNumber;
	private int FInfoId;
	
	public synchronized int getIsTeacher() {
		return isTeacher;
	}
	public synchronized void setIsTeacher(int isTeacher) {
		this.isTeacher = isTeacher;
	}
	public NoticeToDaoImpl getNoticeToDaoImpl()
	{
		return noticeToDaoImpl;
	}
	public void setNoticeToDaoImpl(NoticeToDaoImpl noticeToDaoImpl)
	{
		this.noticeToDaoImpl=noticeToDaoImpl;
	}
	
	public int getFInfoId() {
		return FInfoId;
	}

	public void setFInfoId(int infoId) {
		FInfoId = infoId;
	}

	
	
	public synchronized Long getHomeworkcount() {
		return homeworkcount;
	}
	public synchronized void setHomeworkcount(Long homeworkcount) {
		this.homeworkcount = homeworkcount;
	}

	
	
	public synchronized TeacherHomeworkManageDAO getTeacherHomeworkManageDAO() {
		return teacherHomeworkManageDAO;
	}
	public synchronized void setTeacherHomeworkManageDAO(
			TeacherHomeworkManageDAO teacherHomeworkManageDAO) {
		this.teacherHomeworkManageDAO = teacherHomeworkManageDAO;
	}
	public String getUserNewNotice(){
		//Notice
		FUserNumber =(String) session.get("FUserNumber");     
		//从session中取到数据
		System.out.println("Notice:"+FUserNumber);
		List<TabNoticetosb> list=systomNoticeService.findNoticeToByUserNum(FUserNumber);
		noticeList = new ArrayList<TabNotice>();
		for(int i=0;i<list.size();i++){
			noticeList.add(list.get(i).getTabNotice());
		}
	//	HttpSession session = ServletActionContext.getRequest().getSession();
		
//		if(session.getAttribute("roletype").toString().equals("1"))
//		{
//		//homework
//		isTeacher=1;
	//	homeworkcount =teacherHomeworkManageDAO.findNewHomeworkCount(FUserNumber);
		return "getUserNewNotice";
//		}
//		else
//		{
//			return "getUserNewNotice";
//		}
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<TabNotice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<TabNotice> noticeList) {
		this.noticeList = noticeList;
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}
	
	public String deleteNotice() {
		System.out.println(FInfoId);
		noticeToDaoImpl.deleteByFInfoId(FInfoId);
		return "deleteNotice";
	}
	 
}
