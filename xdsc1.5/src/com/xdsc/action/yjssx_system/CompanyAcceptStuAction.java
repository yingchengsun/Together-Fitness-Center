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
 * 类功能:公司接收研究生
 * @author 许鑫
 * @version 1.1
 */
public class CompanyAcceptStuAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private UploadResumeService uploadResumeService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService CompanyInfoService;
	
	/**
	 * 所有研究生提交的简历
	 */
	private List<YjssxTabResume> ResumeList;
	
	/**
	 * 要接收的研究生的ID
	 */
	private List<String> AcceptStuId;
	
	/**
	 * 已接收的研究生列表
	 */
	private List<TabPostgraduate> acceptedStuList;
	
	/**
	 * 确定接收的研究生信息
	 */
	private List<TabPostgraduate> stuList;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * 查找出所有提交的简历
	 * @return 返回提交的简历的集合
	 */
	public String acceptStudent(){     //确定接收研究生
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		ResumeList=uploadResumeService.findAllResumeByComNum(FUserNumber);    //找到所有投简历的研究生
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
	 * 确定接收研究生，给研究生添加企业信息
	 * @return 接收研究生成功
	 */
	public String confirmToAccept(){    //决定接收研究生，
		FUserNumber =(String) session.get("FUserNumber");         //从session中取到数据
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
	 * 显示已接收的研究生列表
	 * @return 返回所有已接收的研究生
	 */
	public String StudentAccepted(){        //已经接受的研究生
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
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
