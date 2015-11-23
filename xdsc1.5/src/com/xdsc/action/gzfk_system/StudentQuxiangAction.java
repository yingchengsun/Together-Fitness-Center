package com.xdsc.action.gzfk_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabOtherstudent;
import com.xdsc.model.GzfkTabWorkstudent;
import com.xdsc.service.gzfk_system.KaoyanInfoService;
import com.xdsc.service.gzfk_system.OtherInfoService;
import com.xdsc.service.gzfk_system.WorkInfoService;

/**学生个人信息处理
 * @author Administrator
 * @version 1.3
 */
public class StudentQuxiangAction extends ActionSupport implements  SessionAware{

	private Map session;
	private GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
	private GzfkTabWorkstudent workStudent = new GzfkTabWorkstudent();
	private GzfkTabOtherstudent otherStudent = new GzfkTabOtherstudent();

	
	private KaoyanInfoService kaoyanInfoService;
	private WorkInfoService workInfoService;
	private OtherInfoService otherInfoService;
	
	public OtherInfoService getOtherInfoService() {
		return otherInfoService;
	}

	public void setOtherInfoService(OtherInfoService otherInfoService) {
		this.otherInfoService = otherInfoService;
	}

	public WorkInfoService getWorkInfoService() {
		return workInfoService;
	}

	public void setWorkInfoService(WorkInfoService workInfoService) {
		this.workInfoService = workInfoService;
	}

	
	
	public GzfkTabKaoyanstudent getKaoyanStudent() {
		return kaoyanStudent;
	}

	public void setKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent) {
		this.kaoyanStudent = kaoyanStudent;
	}

	public GzfkTabWorkstudent getWorkStudent() {
		return workStudent;
	}

	public void setWorkStudent(GzfkTabWorkstudent workStudent) {
		this.workStudent = workStudent;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	public KaoyanInfoService getKaoyanInfoService() {
		return kaoyanInfoService;
	}

	public void setKaoyanInfoService(KaoyanInfoService kaoyanInfoService) {
		this.kaoyanInfoService = kaoyanInfoService;
	}

	//-----------------------
	public String StudentQuxiang(){
		System.out.println("start quxiang find******************");
		String studentNum=(String)session.get("userNumber");
		System.out.println("get session name******************");

		kaoyanStudent = kaoyanInfoService.findKaoyanInfoByStuNum(studentNum);
		workStudent = workInfoService.findWorkInfoByStuNum(studentNum);
		otherStudent = otherInfoService.findOtherInfoByStuSelfNum(studentNum);
		if(kaoyanStudent.getFNumber()!=null){
			System.out.println("kaoyan not null******************");
			System.out.println(kaoyanStudent.getFNumber());

			//GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
			//kaoyanStudent = kaoyanInfoService.findKaoyanInfoByStuNum(studentNum);
			//System.out.println("return kaoyan******************");

			return "StudentKaoyan";
		}
			
		else if(workStudent.getFNumber()!=null){
			System.out.println("work not null******************");

//			workStudent = workInfoService.findWorkInfoByStuNum(studentNum);
			System.out.println(workStudent.getFNumber());

			System.out.println("return work******************");

			return "StudentWork";
		}
		else if(otherStudent.getFOtherId()!=null){
			System.out.println("other not null******************");
			System.out.println(otherStudent.getFOtherId());

			return "StudentOther";
		}
		
		else 
			return "noRecord";
		
	}

	public GzfkTabOtherstudent getOtherStudent() {
		return otherStudent;
	}

	public void setOtherStudent(GzfkTabOtherstudent otherStudent) {
		this.otherStudent = otherStudent;
	}



}
