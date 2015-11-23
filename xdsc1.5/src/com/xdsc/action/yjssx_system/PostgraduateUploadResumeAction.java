package com.xdsc.action.yjssx_system;

import java.io.File;
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
 * �๦�ܣ��о�����˾�ύ����
 * @author ����
 * @version 1.1
 */
public class PostgraduateUploadResumeAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private CompanyInfoService companyInfoService;
	
	private UploadResumeService uploadResumeService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	/**
	 * ���ĸ���˾�ύ��������˾ID
	 */
	private String companyId;
	
	private TabCompany company;

	private File uploadFile;          //form�������ͬ������ͬ����(text ,textarea...)����Ϣ�����һ��list��

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;

	/**
	 * ��˾�ύ����
	 * @return �ύ�����ɹ�
	 */
	public String uploadResume(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			uploadResumeService.savefile(uploadFile, savePath, saveName);
			YjssxTabResume resume=new YjssxTabResume();		
			//*************************ѧ����Ϣ��session�л�ȡ*********************************
			TabPostgraduate student=postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
			company=companyInfoService.findCompanyByNum(companyId);
			resume.setTabCompany(company);
			resume.setTabPostgraduate(student);
			resume.setFFilePath(saveName);
			uploadResumeService.addResume(resume);
			return "uploadResume";
		}
		return "uploadResume";
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public UploadResumeService getUploadResumeService() {
		return uploadResumeService;
	}

	public void setUploadResumeService(UploadResumeService uploadResumeService) {
		this.uploadResumeService = uploadResumeService;
	}
	
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public TabCompany getCompany() {
		return company;
	}

	public void setCompany(TabCompany company) {
		this.company = company;
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
