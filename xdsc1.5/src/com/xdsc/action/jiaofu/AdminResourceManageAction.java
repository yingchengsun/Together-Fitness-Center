package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminResourceManageManager;

/**
 * <p>���ܣ�����Ա�Խ̸�ϵͳ�е��ϴ��μ���Դ���й������а�������ѯ��Դ��ɾ����Դ��<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminResourceManageAction extends ActionSupport {

	/**service��������ڵ���service��ķ���*/
	private AdminResourceManageManager adminResourceManageManager;
	/**�̸��ϴ���Դ��Ϣ�б�*/
	private List<JfptTabUploadfile> listUploadfileInfo;
	/**��Դ����ID��*/
	private int FNumber;
	/**��ҳ�����м�¼��ǰҳ���*/
	private int p = 1;
	/**��ҳ�����м�¼��ѯ�����ݼ�����ҳ��*/
	private int lastPage;
	/**��Դɾ����Ϣ�б�*/
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
	 * <p>���ܣ����ҳ��̸��������Դ��Ϣ�����з�ҳ����<br>
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
	 * <p>���ܣ�����ɾ����Ϣ�б������ɾ�������Դ��Ϣ<br>
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
	 * <p>���ܣ������ϴ���Դ��Ӧ������ɾ�������Դ��Ϣ<br>
	 * @return action deleteUpfileInfoByID
	 */
	public String deleteUpfileInfoByID(){
		adminResourceManageManager.deleteUpfileInfoByID(FNumber);
		
		listUploadfileInfo = adminResourceManageManager.findUploadfileInfo();
		return "deleteUpfileInfoByID";
	}
}
