package com.xdsc.action.yjssx_system;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能:公司招聘信息的操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanyZhaoPinOperationAction extends ActionSupport {
	
	private CompanyZhaoPinInfoService companyZhaoPinInfoService;
	
	private CompanyInfoService companyInfoService;
	
	/**
	 * 显示招聘信息详情的ID
	 */
	private int id;
	
	/**
	 * 招聘信息详情
	 */
	private TabInformation infoDetail;
	
	/**
	 * 修改的招聘信息
	 */
	private TabInformation updateInfo;
	
	private int downId;     //下载文件的Id
	
    private String contentType;
	
	private String filePath;
	
	private String fileName;
	
	private String comNum;    //申请公司的id号
	
	/**
	 * 申请公司的招聘计划的id
	 */
	private String infoId;        
	
	/**
	 *  申请公司的详细信息
	 */
	private TabCompany comInfo;       
	
	private String infoPath;

	/**
	 * 根据id查找招聘信息的详情
	 * @return 返回公司招聘信息的详情
	 */
	public String showInfo(){    //显示信息详情
		infoDetail = companyZhaoPinInfoService.findZhaoPinById(id);
		return "showInfo";
	}
	
	/**
	 * 删除招聘信息
	 * @return 删除信息成功
	 */
	public String deleteInfo(){    //删除信息
		TabInformation info= companyZhaoPinInfoService.findZhaoPinById(id);
		companyZhaoPinInfoService.deleteZhaoPinInfo(info);
		return "deleteInfo";
	}
	
	/**
	 * 修改招聘信息
	 * @return 返回要修改的招聘信息详情
	 */
	public String updateInfo(){    //修改信息
		updateInfo=companyZhaoPinInfoService.findZhaoPinById(id);
		return "updateInfo";
	}
//******************************文件下载***********************************	
	public String downFile(){      //下载简历模板
		TabInformation info=companyZhaoPinInfoService.findZhaoPinById(downId);
		System.out.println("---------------------------"+info.getFInfoPath());
		this.setContentType("application/"+this.getExt(info.getFInfoPath()));
		this.setFilePath(CommonConstVariable.INFOMATION_FILE_PATH+info.getFInfoPath());
		this.setFileName(info.getFInfoPath());
		return "downFileSuccess";
	}
	
	public InputStream getDownFile() throws Exception{        //文件下载输出流
		System.out.println("---------------------------"+this.getFilePath());
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	public String getExt(String str){               //获得文件的后缀名
		String subStr=str.substring(str.indexOf("."));
		return subStr;
	}
	//******************************文件下载***********************************		
	/**
	 * 申请公司显示公司的详情
	 * @return
	 */
	public String applyCompany(){                  //申请公司的详细信息
		comInfo=companyInfoService.findCompanyByNum(comNum);
		return "applyCompany";
	}
	
	public TabInformation getInfoDetail() {
		return infoDetail;
	}

	public void setInfoDetail(TabInformation infoDetail) {
		this.infoDetail = infoDetail;
	}

	public CompanyZhaoPinInfoService getCompanyZhaoPinInfoService() {
		return companyZhaoPinInfoService;
	}

	public void setCompanyZhaoPinInfoService(
			CompanyZhaoPinInfoService companyZhaoPinInfoService) {
		this.companyZhaoPinInfoService = companyZhaoPinInfoService;
	}

	public int getId() {
		return id;
	}
	
	public TabInformation getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(TabInformation updateInfo) {
		this.updateInfo = updateInfo;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
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
	

	public String getComNum() {
		return comNum;
	}

	public void setComNum(String comNum) {
		this.comNum = comNum;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public TabCompany getComInfo() {
		return comInfo;
	}

	public void setComInfo(TabCompany comInfo) {
		this.comInfo = comInfo;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getInfoPath() {
		return infoPath;
	}

	public void setInfoPath(String infoPath) {
		this.infoPath = infoPath;
	}



}
