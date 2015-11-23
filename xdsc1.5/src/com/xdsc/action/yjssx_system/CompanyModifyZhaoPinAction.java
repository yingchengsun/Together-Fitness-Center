package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService;

/**
 * 类功能：公司修改已经发布的招聘信息
 * @author 许鑫
 * @version 1.1
 */
public class CompanyModifyZhaoPinAction extends ActionSupport {
	
	private CompanyZhaoPinInfoService companyZhaoPinInfoService;
	
	/**
	 * 修改的信息
	 */
	
	private int InfoId;
	
	private String Title;
	
	private Date ReleaseDate ;
	
	private String Contet;
	
	private File uploadFile;          //form中如果有同名的相同类型(text ,textarea...)的信息则放在一个list中

	private String uploadFileContentType;

	private String uploadFileFileName;

	private String savePath;
	
	/**
	 * 修改已发布的招聘信息
	 * @return 修改信息成功
	 */
	public String modifyInfo(){
		TabInformation info= companyZhaoPinInfoService.findZhaoPinById(InfoId);
		String fileName=System.currentTimeMillis()+uploadFileFileName;//设置上传保存在数据库中的文件名
		if(info.getFInfoPath()!=null&&uploadFile!=null){
		String filePath=ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+info.getFInfoPath();//旧文件的保存路径
		File file=new File(filePath);
		file.delete();    //更新时删除以前的存储简历文件
		}
		if(uploadFile!=null){
			companyZhaoPinInfoService.savefile(uploadFile, savePath, fileName);
		}
		info.setFInfoContet(Contet);
		info.setFInfoStartTime(ReleaseDate);
		info.setFInfoTitle(Title);	
		info.setFInfoPath(fileName);
		companyZhaoPinInfoService.updateZhaoPinInfo(info);
		return "modifyInfo";
	}

	public CompanyZhaoPinInfoService getCompanyZhaoPinInfoService() {
		return companyZhaoPinInfoService;
	}

	public void setCompanyZhaoPinInfoService(
			CompanyZhaoPinInfoService companyZhaoPinInfoService) {
		this.companyZhaoPinInfoService = companyZhaoPinInfoService;
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

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getInfoId() {
		return InfoId;
	}

	public void setInfoId(int infoId) {
		InfoId = infoId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getContet() {
		return Contet;
	}

	public void setContet(String contet) {
		Contet = contet;
	}
	
}
