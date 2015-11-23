package com.xdsc.action.yjssx_system;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;

/**
 * �๦��:��ʦ���о�������֪ͨ
 * @author ����
 * @version 1.1
 */
public class TutorStuInfoForNoticeAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	/**
	 * ��ʦҲ���յ��о�����Ϣ
	 */
	private List<TabPostgraduate> stuList;
	
	private int p = 1;

	private int lastPage;

	
	/**
	 * ���ҵ�ʦ�µ������о���
	 * @return ���ظõ�ʦ�ѽ��յ��о����б�
	 */
	public String TutorsStuInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		stuList = postgraduateInfoService.findPostgraduateByTutorNumber(FUserNumber);
		if(stuList.size()>10){
			int pages = 10;
			int listlength = this.stuList.size();
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
			this.stuList = this.stuList.subList(startIndex, endIndex);	
		}	
		return "TutorsStuInfo";
	}
	
	/**
	 * ��ʾ��ʦ�ѽ��յ������о�����Ϣ�����ڷ���֪ͨ
	 * @return �о����б�
	 */
	public String AllStudentInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		stuList = postgraduateInfoService.findPostgraduateByTutorNumber(FUserNumber);
		if(stuList.size()>10){
			int pages = 10;
			int listlength = this.stuList.size();
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
			this.stuList = this.stuList.subList(startIndex, endIndex);
		}
		
		return "AllStudentInfo";
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getStuList() {
		return stuList;
	}

	public void setStuList(List<TabPostgraduate> stuList) {
		this.stuList = stuList;
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
