package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.YjssxTabResume;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.UploadResumeService;

/**
 * �๦��:��˾�����о���
 * @author ����
 * @version 1.1
 */
public class CompanyAcceptStuAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private UploadResumeService uploadResumeService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService CompanyInfoService;
	
	/**
	 * �����о����ύ�ļ���
	 */
	private List<YjssxTabResume> ResumeList;
	
	/**
	 * Ҫ���յ��о�����ID
	 */
	private List<String> AcceptStuId;
	
	/**
	 * �ѽ��յ��о����б�
	 */
	private List<TabPostgraduate> acceptedStuList;
	
	/**
	 * ȷ�����յ��о�����Ϣ
	 */
	private List<TabPostgraduate> stuList;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * ���ҳ������ύ�ļ���
	 * @return �����ύ�ļ����ļ���
	 */
	public String acceptStudent(){     //ȷ�������о���
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		ResumeList=uploadResumeService.findAllResumeByComNum(FUserNumber);    //�ҵ�����Ͷ�������о���
		if(ResumeList.size()>10){
			int pages = 10;
			int listlength = this.ResumeList.size();
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
			this.ResumeList = this.ResumeList.subList(startIndex, endIndex);		
		}	
		return "acceptStudent";
	}
	
	/**
	 * ȷ�������о��������о��������ҵ��Ϣ
	 * @return �����о����ɹ�
	 */
	public String confirmToAccept(){    //���������о�����
		FUserNumber =(String) session.get("FUserNumber");         //��session��ȡ������
		stuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<AcceptStuId.size();i++){
			stuList.add(postgraduateInfoService.findPostgraduateByStuNumber(AcceptStuId.get(i)));
		}
		TabCompany company= CompanyInfoService.findCompanyByNum(FUserNumber);
		for(int i=0;i<stuList.size();i++){
			TabPostgraduate stu=stuList.get(i);
			stu.setTabCompany(company);
			postgraduateInfoService.updatePostgraduateStuInfo(stu);
		}
		return "confirmToAccept";
	}
	
	/**
	 * ��ʾ�ѽ��յ��о����б�
	 * @return ���������ѽ��յ��о���
	 */
	public String StudentAccepted(){        //�Ѿ����ܵ��о���
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		acceptedStuList = postgraduateInfoService.findPostgraduateByComNumber(FUserNumber);
		if(acceptedStuList.size()>10){
			int pages = 10;
			int listlength = this.acceptedStuList.size();
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
			this.acceptedStuList = this.acceptedStuList.subList(startIndex, endIndex);
		}
		
		return "StudentAccepted";
	}

	public UploadResumeService getUploadResumeService() {
		return uploadResumeService;
	}

	public void setUploadResumeService(UploadResumeService uploadResumeService) {
		this.uploadResumeService = uploadResumeService;
	}

	public List<YjssxTabResume> getResumeList() {
		return ResumeList;
	}

	public void setResumeList(List<YjssxTabResume> resumeList) {
		ResumeList = resumeList;
	}
	
	
	public List<String> getAcceptStuId() {
		return AcceptStuId;
	}

	public void setAcceptStuId(List<String> acceptStuId) {
		AcceptStuId = acceptStuId;
	}

	public CompanyInfoService getCompanyInfoService() {
		return CompanyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		CompanyInfoService = companyInfoService;
	}

	public List<TabPostgraduate> getStuList() {
		return stuList;
	}

	public void setStuList(List<TabPostgraduate> stuList) {
		this.stuList = stuList;
	}

	public List<TabPostgraduate> getAcceptedStuList() {
		return acceptedStuList;
	}

	public void setAcceptedStuList(List<TabPostgraduate> acceptedStuList) {
		this.acceptedStuList = acceptedStuList;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
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
