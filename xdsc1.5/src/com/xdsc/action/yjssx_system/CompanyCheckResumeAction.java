package com.xdsc.action.yjssx_system;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.YjssxTabResume;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.UploadResumeService;
import com.xdsc.util.CommonConstVariable;

public class CompanyCheckResumeAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private UploadResumeService uploadResumeService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	/**
	 * 公司查收简历列表
	 */
	private List<YjssxTabResume> ResumeList;
	
	/**
	 * 查看投简历的研究生的基本信息
	 */
	private String stuId;               //查看投简历的研究生的信息
	
	private TabPostgraduate stuInfo;
	
	/**
	 * 删除研究生的简历，简历的ID
	 */
	private int resumeId;              //删除简历的简历号
	
    private String contentType;                  //下载
	
	private String filePath;
	
	private String fileName;
	
	private int downId;
	
	private int p = 1;

	private int lastPage;

	/**
	 * 公司查收简历
	 * @return receiveResume返回查收的建立列表
	 */
	public String receiveResume(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		ResumeList=uploadResumeService.findAllResumeByComNum(FUserNumber);
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
		
		return "receiveResume";
	}
	
	/**
	 * 查看投简历的研究生的基本信息
	 * @return 研究生信息
	 */
	public String showStuInfo(){       //显示投简历的研究生的详细信息
		stuInfo = postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		return "showStuInfo";
	}
	
	/**
	 * 删除研究生的简历
	 * @return 删除简历成功
	 */
	public String deleteResume(){      //删除简历
		YjssxTabResume resume=uploadResumeService.findResumeById(resumeId);
		uploadResumeService.deleteResume(resume);
		return "deleteResume";
	}
	
	public String downFile(){      //下载简历模板
		YjssxTabResume info=uploadResumeService.findResumeById(downId);
		this.setContentType("application/"+this.getExt(info.getFFilePath()));
		this.setFilePath(CommonConstVariable.UPLOADRESUME_FILE_PATH+info.getFFilePath());
		this.setFileName(info.getFFilePath());
		return "downFileSuccess";
	}
	
	public InputStream getDownFile() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	public String getExt(String str){               //获得文件的后缀名
		String subStr=str.substring(str.indexOf("."));
		return subStr;
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

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public TabPostgraduate getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(TabPostgraduate stuInfo) {
		this.stuInfo = stuInfo;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}
	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
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


}
