package com.xdsc.action.yjssx_system;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabNotice;
import com.xdsc.model.YjssxTabResume;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystemInfomationService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.service.yjssx_system.UploadResumeService;
import com.xdsc.util.CommonConstVariable;

public class CommonDownFileAction extends ActionSupport {
	
	private SystemInfomationService systemInfomationService;
	
	private SystomNoticeService systomNoticeService;
	
	private UploadResumeService uploadResumeService;
	
	private PostgraduateThesisService postgraduateThesisService;

	private String contentType;                  //下载
	
	private String filePath;
	
	private String fileName;
	
	private int downId;
	//--------------------------------------------下载information的附件----------------------------------------------	
	public String downInfomation(){    
		TabInformation info=systemInfomationService.findInfoById(downId);
		this.setContentType("application/"+this.getExt(info.getFInfoPath()));
		this.setFilePath(CommonConstVariable.INFOMATION_FILE_PATH+info.getFInfoPath());
		this.setFileName(info.getFInfoPath());
		System.out.println("*******"+this.getFileName());
		return "downInfomation";
	}
	
	public InputStream getDownInfomation() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
//--------------------------------------------下载notice的附件----------------------------------------------
	public String downNotice(){     
		TabNotice notice=systomNoticeService.findNoticeById(downId);
		this.setContentType("application/"+this.getExt(notice.getFInfoContet()));
		this.setFilePath(CommonConstVariable.NOTICE_FILE_PATH+notice.getFInfoContet());
		this.setFileName(notice.getFInfoContet());
		return "downNotice";
	}
	
	public InputStream getDownNotice() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
//--------------------------------------------下载提交thesis论文的附件----------------------------------------------
	public String downSubmitThesis(){      
		YjssxTabSubmitthesis thesis=postgraduateThesisService.findSubmitThesisById(downId);
		this.setContentType("application/"+this.getExt(thesis.getFThesisStorePath()));
		this.setFilePath(CommonConstVariable.THESIS_FILE_PATH+thesis.getFThesisStorePath());
		this.setFileName(thesis.getFThesisStorePath());
		return "downSubmitThesis";
	}
	
	public InputStream getDownSubmitThesis() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
//--------------------------------------------下载反馈thesis论文的附件----------------------------------------------
	public String downReturnThesis(){      
		YjssxTabReturnthesis thesis=postgraduateThesisService.findReturnThesisById(downId);
		this.setContentType("application/"+this.getExt(thesis.getFThesisStorePath()));
		this.setFilePath(CommonConstVariable.THESIS_FILE_PATH+thesis.getFThesisStorePath());
		this.setFileName(thesis.getFThesisStorePath());
		return "downReturnThesis";
	}
	
	public InputStream getDownReturnThesis() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
//--------------------------------------------下载简历----------------------------------------------
	
	public String downResume(){      
		YjssxTabResume resume=uploadResumeService.findResumeById(downId);
		this.setContentType("application/"+this.getExt(resume.getFFilePath()));
		this.setFilePath(CommonConstVariable.UPLOADRESUME_FILE_PATH+resume.getFFilePath());
		this.setFileName(resume.getFFilePath());
		return "downResume";
	}
	
	public InputStream getDownResume() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
//---------------------------------------------------------------------------------------	
	public String getExt(String str){               //获得文件的后缀名
		String subStr=str.substring(str.indexOf("."));
		return subStr;
	}
	
	public SystemInfomationService getSystemInfomationService() {
		return systemInfomationService;
	}

	public void setSystemInfomationService(
			SystemInfomationService systemInfomationService) {
		this.systemInfomationService = systemInfomationService;
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public UploadResumeService getUploadResumeService() {
		return uploadResumeService;
	}

	public void setUploadResumeService(UploadResumeService uploadResumeService) {
		this.uploadResumeService = uploadResumeService;
	}

	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
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
}
