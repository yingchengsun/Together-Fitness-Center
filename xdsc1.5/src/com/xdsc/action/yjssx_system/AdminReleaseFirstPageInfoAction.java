package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.MhqxTabUserService;
import com.xdsc.service.yjssx_system.SystemInfomationService;
import com.xdsc.util.CommonConstVariable;
import com.xdsc.util.YjssxUtils;

/**
 * �๦�ܣ�����Ա������ҳ��Ϣ
 * @author ����
 * @version 1.1
 */
public class AdminReleaseFirstPageInfoAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private SystemInfomationService systemInfomationService;
	
	private MhqxTabUserService mhqxTabUserService;
	
	/**
	 * ʵϰϵͳ��ҳ��Ϣ�����ͣ�1~7����ͬ���͵���Ϣ������Ӧ���ݿ���infomation��
	 */
	private String type; 
	
	/**
	 * �������͵����ͣ���֪����Ϣ�����ƣ��ڳ������ж���
	 */
	private String typeName;
	
	/**
	 * ������Ϣ�����ͣ���ʾ��ҳ������Ϣ
	 */
	private List<TabInformation> infoList;
	
	/**
	 * �������ͣ�����Ա��������ҳ��Ϣ
	 */
	private TabInformation releaseInfo;
	
	private String infoType;
	
	/**
	 * ����Ա������Ϣ������ļ�
	 */
	private File uploadFile;

	private String uploadFileContentType;

	private String uploadFileFileName;

	/**
	 * ��Ϣ���ļ��ı���·������struts.xml�����ã������޸�
	 */
	private String savePath;
	
	private int p = 1;

	private int lastPage;

	
	/**
	 * ����������ʾ�����͵�������Ϣ
	 * @return showInfo ������Ϣ�ɹ�
	 */
	public String showInfo(){
		System.out.println("----------"+type);
		List<TabInformation> list= systemInfomationService.findAllInfo();
		System.out.println(list.size());
		infoList = new ArrayList<TabInformation>();
		if(type.equals("1")){
			typeName = CommonConstVariable.FIRST_PAGE_NEWS;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NEWS)){
					infoList.add(list.get(i));
				}
			}
		}
		else if(type.equals("2")){
			typeName = CommonConstVariable.FIRST_PAGE_NOTICE;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NOTICE)){
					infoList.add(list.get(i));
				}
			}
		}
		else if(type.equals("3")){
			typeName = CommonConstVariable.FIRST_PAGE_MATERIAL;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_MATERIAL)){
					infoList.add(list.get(i));
				}
			}
		}
		else if(type.equals("4")){
			typeName = CommonConstVariable.FIRST_PAGE_ZHOPIN;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_ZHOPIN)){
					infoList.add(list.get(i));
				}
			}
		}
		else if(type.equals("5")){
			typeName = CommonConstVariable.FIRST_PAGE_COORCOM;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_COORCOM)){
					infoList.add(list.get(i));
				}
			}
		}
		else if(type.equals("6")){
			typeName = CommonConstVariable.FIRST_PAGE_POLICY;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_POLICY)){
					infoList.add(list.get(i));
				}
			}
		}
		else{
			typeName = CommonConstVariable.FIRST_PAGE_PRINCIPLE;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_PRINCIPLE)){
					infoList.add(list.get(i));
				}
			}
		}
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
		return "showInfo";
	}
	
	/**
	 * Я��typeName��Ϣ���ͼ���ת
	 * @return releaseInfo ��ת�ɹ�
	 */
	public String releaseInfo(){           
		if(type.equals("1")){
			typeName = CommonConstVariable.FIRST_PAGE_NEWS;
		}
		else if(type.equals("2")){
			typeName = CommonConstVariable.FIRST_PAGE_NOTICE;
		}
		else if(type.equals("3")){
			typeName = CommonConstVariable.FIRST_PAGE_MATERIAL;
		}
		else if(type.equals("4")){
			typeName = CommonConstVariable.FIRST_PAGE_ZHOPIN;
		}
		else if(type.equals("5")){
			typeName = CommonConstVariable.FIRST_PAGE_COORCOM;
		}
		else if(type.equals("6")){
			typeName = CommonConstVariable.FIRST_PAGE_POLICY;
		}
		else{
			typeName = CommonConstVariable.FIRST_PAGE_PRINCIPLE;
		}
		return "releaseInfo";
	}
	
	/**
	 * ����Ա�����ĸ����͵���Ϣ�����ݴ����typeName���浽��ͬ���͵���Ϣ
	 * @return  saveInfo ������Ϣ�ɹ�
	 */
	public String saveInfo(){ 
		releaseInfo.setFModuleId("7");
		if(infoType.equals("1")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_NEWS);
		}
		else if(infoType.equals("2")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_NOTICE);
		}
		else if(infoType.equals("3")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_MATERIAL);
		}
		else if(infoType.equals("4")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_ZHOPIN);
			releaseInfo.setFBiaoZhi(CommonConstVariable.ZHAOPIN_IS_RELEASE);    //����Ա����ֱ������Ϣ������ȥ
		}
		else if(infoType.equals("5")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_COORCOM);
		}
		else if(infoType.equals("6")){
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_POLICY);
		}
		else{
			releaseInfo.setFInfoType(CommonConstVariable.FIRST_PAGE_PRINCIPLE);
		}
		String savedName=System.currentTimeMillis()+uploadFileFileName;
		releaseInfo.setFInfoPath(savedName);
		MhqxTabUser user=new MhqxTabUser();
		FUserNumber =(String) session.get("FUserNumber"); 
		user=mhqxTabUserService.findMhqxTabUserById(FUserNumber);
		releaseInfo.setMhqxTabUser(user);
		systemInfomationService.addInfo(releaseInfo);
		if(uploadFile !=null){
			YjssxUtils.saveFile(uploadFile, savePath, savedName);
		}
		return "saveInfo";
	}
	

	public SystemInfomationService getSystemInfomationService() {
		return systemInfomationService;
	}

	public void setSystemInfomationService(
			SystemInfomationService systemInfomationService) {
		this.systemInfomationService = systemInfomationService;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	public List<TabInformation> getInfoList() {
		return infoList;
	}


	public void setInfoList(List<TabInformation> infoList) {
		this.infoList = infoList;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
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

	public MhqxTabUserService getMhqxTabUserService() {
		return mhqxTabUserService;
	}

	public void setMhqxTabUserService(MhqxTabUserService mhqxTabUserService) {
		this.mhqxTabUserService = mhqxTabUserService;
	}
}
