package com.xdsc.action.wzmh_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.model.TabInformation;

import com.xdsc.service.wzmh_system.MhqxTabNavigationManager;
import com.xdsc.util.MultiPage;

/**
 * @author ����
 * 
 */
public class MhqxTabNavigationAction extends ActionSupport {

	/** ����������� */
	private Integer FNavigationId;
	private String FNavigationName;
	private String FNavigationPicUrl;
	private String FNavigationUrl;
	private Integer FNavigationPriority;

	private List<String> check;

	private MhqxTabNavigation n;
	private List<MhqxTabNavigation> navigationList;// ���е���
	private MhqxTabNavigationManager mhqxTabNavigationManager;

	/** ͼƬ�������ı��� */
	private File uploadFile;

	private String uploadFileFileName;
	private String savePath;

	/**��ҳ�������ı��� */
	private int p = 1;
	private int lastPage;

	/**
	 * ���캯��
	 */
	public MhqxTabNavigationAction() {
	}

	/**
	 * ����һ��navigation��¼
	 * 
	 * @return addSUCCESS
	 * @throws Exception
	 */
	public String add() throws Exception {
		n = mhqxTabNavigationManager.savefile(uploadFile, n, savePath,
				uploadFileFileName);
		
		mhqxTabNavigationManager.add(n);
		return "addSUCCESS";
	}

	/**
	 * ɾ��һ��navigation��¼
	 * 
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String delete() throws Exception {
		mhqxTabNavigationManager.delete(mhqxTabNavigationManager
				.getMhqxTabNavigationByID(FNavigationId));
		return "deleteSUCCESS";
	}

	/**
	 * ɾ������navigation��¼
	 * 
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String deleteAll() throws Exception {
		for (String s : check) {
			int id = Integer.parseInt(s);
			mhqxTabNavigationManager.delete(mhqxTabNavigationManager
					.getMhqxTabNavigationByID(id));
		}
		return "deleteSUCCESS";
	}

	/**
	 * ����Ҫ���µ�navigation��¼�����ݶ�ȡ������ʾ��ҳ����
	 * 
	 * @return preUpdateSUCCESS
	 */
	public String preUpdate() {
		n = mhqxTabNavigationManager.getMhqxTabNavigationByID(FNavigationId);
		return "preUpdateSUCCESS";
	}

	/**
	 * ����һ��navigation��¼
	 * 
	 * @return updateSUCCESS
	 * @throws Exception
	 */
	public String update() throws Exception {
		n = mhqxTabNavigationManager
				.getMhqxTabNavigationByID(FNavigationId);
		if(uploadFile!=null){
			n=mhqxTabNavigationManager.savefile(uploadFile, n, savePath,
					uploadFileFileName);
		}	
		n.setFNavigationId(FNavigationId);
		n.setFNavigationName(FNavigationName);
		n.setFNavigationPriority(FNavigationPriority);
		n.setFNavigationUrl(FNavigationUrl);
		mhqxTabNavigationManager.update(n);

		return "updateSUCCESS";
	}

	/**
	 * ������ݿ������е�navigation��¼
	 * ��ҳ���
	 * @return listAllSUCCESS
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		navigationList = mhqxTabNavigationManager.findAllMhqxTabNavigation();
		if (navigationList!=null&&navigationList.size() > 10) {
			int pages = 10;
			int listlength = navigationList.size();
			if (listlength % pages == 0) {
				lastPage = listlength / pages;
			} else {
				lastPage = listlength / pages + 1;
			}
			if (p < 1)
				p = 1;
			if (p > lastPage)
				p = lastPage;
			int startIndex = (p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			navigationList = navigationList.subList(startIndex, endIndex);
		}
		return "listAllSUCCESS";
	}

	/**
	 * ������ݿ��������봫��nameֵƥ���navigation��¼
	 * 
	 * @return listByNameSUCCESS
	 * @throws Exception
	 */
	public String listByName() throws Exception {
		navigationList = mhqxTabNavigationManager
				.findMhqxTabNavigationByName(FNavigationName);
		return "listByNameSUCCESS";

	}

	public Integer getFNavigationId() {
		return FNavigationId;
	}

	public void setFNavigationId(Integer navigationId) {
		FNavigationId = navigationId;
	}

	public String getFNavigationName() {
		return FNavigationName;
	}

	public void setFNavigationName(String navigationName) {
		FNavigationName = navigationName;
	}

	public String getFNavigationPicUrl() {
		return FNavigationPicUrl;
	}

	public void setFNavigationPicUrl(String navigationPicUrl) {
		FNavigationPicUrl = navigationPicUrl;
	}

	public String getFNavigationUrl() {
		return FNavigationUrl;
	}

	public void setFNavigationUrl(String navigationUrl) {
		FNavigationUrl = navigationUrl;
	}

	public Integer getFNavigationPriority() {
		return FNavigationPriority;
	}

	public void setFNavigationPriority(Integer navigationPriority) {
		FNavigationPriority = navigationPriority;
	}

	public MhqxTabNavigation getN() {
		return n;
	}

	public void setN(MhqxTabNavigation n) {
		this.n = n;
	}

	public List<MhqxTabNavigation> getNavigationList() {
		return navigationList;
	}

	public void setNavigationList(List<MhqxTabNavigation> navigationList) {
		this.navigationList = navigationList;
	}

	public MhqxTabNavigationManager getMhqxTabNavigationManager() {
		return mhqxTabNavigationManager;
	}

	public void setMhqxTabNavigationManager(
			MhqxTabNavigationManager mhqxTabNavigationManager) {
		this.mhqxTabNavigationManager = mhqxTabNavigationManager;
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

	public List<String> getCheck() {
		return check;
	}

	public void setCheck(List<String> check) {
		this.check = check;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
}
