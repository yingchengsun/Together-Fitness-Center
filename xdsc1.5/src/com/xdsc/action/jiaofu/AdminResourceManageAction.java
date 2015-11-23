package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminResourceManageManager;

/**
 * <p>功能：管理员对教辅系统中的上传课件资源进行管理，其中包括：查询资源、删除资源等<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminResourceManageAction extends ActionSupport {

	/**service层对象，用于调用service层的方法*/
	private AdminResourceManageManager adminResourceManageManager;
	/**教辅上传资源信息列表*/
	private List<JfptTabUploadfile> listUploadfileInfo;
	/**资源对象ID号*/
	private int FNumber;
	/**分页处理中记录当前页面号*/
	private int p = 1;
	/**分页处理中记录查询出数据集的总页数*/
	private int lastPage;
	/**资源删除信息列表*/
	private List<Integer> deletelist;

	public List<Integer> getDeletelist() {
		return deletelist;
	}

	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}

	public AdminResourceManageManager getAdminResourceManageManager() {
		return adminResourceManageManager;
	}

	public void setAdminResourceManageManager(
			AdminResourceManageManager adminResourceManageManager) {
		this.adminResourceManageManager = adminResourceManageManager;
	}
	
	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
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

	public List<JfptTabUploadfile> getListUploadfileInfo() {
		return listUploadfileInfo;
	}

	public void setListUploadfileInfo(List<JfptTabUploadfile> listUploadfileInfo) {
		this.listUploadfileInfo = listUploadfileInfo;
	}

	/**
	 * <p>功能：查找出教辅的相关资源信息并进行分页处理<br>
	 * @return action findResourceInfo
	 */
	public String findResourceInfo(){
		listUploadfileInfo = adminResourceManageManager.findUploadfileInfo();
		
		int pages = 5;
		int listlength = listUploadfileInfo.size();
		if(listlength==0)
			return "findResourceInfo";
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
		listUploadfileInfo = listUploadfileInfo.subList(startIndex, endIndex);
		
		return "findResourceInfo";
	}
	
	/**
	 * <p>功能：根据删除信息列表的主键删除相关资源信息<br>
	 * @return action deleteUpfileInfo
	 */
	public String deleteUpfileInfo(){
		for(int i:deletelist){
			adminResourceManageManager.deleteUpfileInfoByID(i);
    	}
		
		listUploadfileInfo = adminResourceManageManager.findUploadfileInfo();
		return "deleteUpfileInfo";
	}
	
	/**
	 * <p>功能：根据上传资源对应的主键删除相关资源信息<br>
	 * @return action deleteUpfileInfoByID
	 */
	public String deleteUpfileInfoByID(){
		adminResourceManageManager.deleteUpfileInfoByID(FNumber);
		
		listUploadfileInfo = adminResourceManageManager.findUploadfileInfo();
		return "deleteUpfileInfoByID";
	}
}
