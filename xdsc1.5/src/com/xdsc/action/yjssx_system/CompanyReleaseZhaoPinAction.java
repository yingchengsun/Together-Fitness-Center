package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能：公司发布招聘信息
 * @author 许鑫
 * @version 1.1
 */
public class CompanyReleaseZhaoPinAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private CompanyZhaoPinInfoService companyZhaoPinInfoService;
	
	private SystemFunctionService systemFunctionService;
	
	/**
	 * 该公司发布的所有招聘信息
	 */
	private List<TabInformation> infoList;
	
	/**
	 * 发布的招聘信息
	 */
	private TabInformation releaseInfo;
	
	private File uploadFile;          //form中如果有同名的相同类型(text ,textarea...)的信息则放在一个list中

	private String uploadFileContentType;

	private String uploadFileFileName;

	private String savePath;
	
	private int p = 1;

	private int lastPage;


	/**
	 * 查找到公司已经发布的所有招聘信息
	 * @return 返回所有招聘信息
	 */
	public String preRelease(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		infoList=companyZhaoPinInfoService.findAllZhaoPinByComNum(FUserNumber);
		if(infoList.size()>10){
			int pages = 10;
			int listlength = this.infoList.size();
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
			this.infoList = this.infoList.subList(startIndex, endIndex);
		}
		
		return "preRelease";
	}
	
	/**
	 * 发布招聘信息，先判断是否具有此权限
	 * @return 转向发布页面
	 */
	public String releaseInfomation(){      //发布招聘信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<MhqxTabUserfunction> functionList=systemFunctionService.findUserFunctionByUserNum(FUserNumber);//先判断是否有发布招聘信息的权限
		String temp="N";
		for(int i=0;i<functionList.size();i++){
			if(functionList.get(i).getMhqxTabFunction().getFFunctionId()==CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID){
				temp= "Y";
			}
		}
		if(temp.equals("N")){
			return "NoPowerToDoThisOption";
		}
		return "releaseInfomation";
	}
	
	/**
	 * 发布招聘信息，上传简历模板
	 * @return 招聘信息发布成功
	 */
	public String ReleaseInfo(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		releaseInfo.setFModuleId(CommonConstVariable.MODULE_ID);
		releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_ZHOPIN);
		String savedName=System.currentTimeMillis()+uploadFileFileName;
		releaseInfo.setFInfoPath(savedName);
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(FUserNumber);
		user.setFUserPassword("123");
		releaseInfo.setMhqxTabUser(user);
		releaseInfo.setFBiaoZhi(CommonConstVariable.ZHAOPIN_Not_RELEASE);
		companyZhaoPinInfoService.addZhaoPinInfo(releaseInfo);
		if(uploadFile !=null){
			companyZhaoPinInfoService.savefile(uploadFile, savePath, savedName);
		}
		return "ReleaseInfo";
	}

	public CompanyZhaoPinInfoService getCompanyZhaoPinInfoService() {
		return companyZhaoPinInfoService;
	}

	public void setCompanyZhaoPinInfoService(
			CompanyZhaoPinInfoService companyZhaoPinInfoService) {
		this.companyZhaoPinInfoService = companyZhaoPinInfoService;
	}

	public List<TabInformation> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<TabInformation> infoList) {
		this.infoList = infoList;
	}

	public TabInformation getReleaseInfo() {
		return releaseInfo;
	}

	public void setReleaseInfo(TabInformation releaseInfo) {
		this.releaseInfo = releaseInfo;
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

	public SystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}

	public void setSystemFunctionService(SystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
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
