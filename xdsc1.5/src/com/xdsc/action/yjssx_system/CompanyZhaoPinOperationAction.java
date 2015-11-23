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
 * �๦��:��˾��Ƹ��Ϣ�Ĳ���
 * @author ����
 * @version 1.1
 */
public class CompanyZhaoPinOperationAction extends ActionSupport {
	
	private CompanyZhaoPinInfoService companyZhaoPinInfoService;
	
	private CompanyInfoService companyInfoService;
	
	/**
	 * ��ʾ��Ƹ��Ϣ�����ID
	 */
	private int id;
	
	/**
	 * ��Ƹ��Ϣ����
	 */
	private TabInformation infoDetail;
	
	/**
	 * �޸ĵ���Ƹ��Ϣ
	 */
	private TabInformation updateInfo;
	
	private int downId;     //�����ļ���Id
	
    private String contentType;
	
	private String filePath;
	
	private String fileName;
	
	private String comNum;    //���빫˾��id��
	
	/**
	 * ���빫˾����Ƹ�ƻ���id
	 */
	private String infoId;        
	
	/**
	 *  ���빫˾����ϸ��Ϣ
	 */
	private TabCompany comInfo;       
	
	private String infoPath;

	/**
	 * ����id������Ƹ��Ϣ������
	 * @return ���ع�˾��Ƹ��Ϣ������
	 */
	public String showInfo(){    //��ʾ��Ϣ����
		infoDetail = companyZhaoPinInfoService.findZhaoPinById(id);
		return "showInfo";
	}
	
	/**
	 * ɾ����Ƹ��Ϣ
	 * @return ɾ����Ϣ�ɹ�
	 */
	public String deleteInfo(){    //ɾ����Ϣ
		TabInformation info= companyZhaoPinInfoService.findZhaoPinById(id);
		companyZhaoPinInfoService.deleteZhaoPinInfo(info);
		return "deleteInfo";
	}
	
	/**
	 * �޸���Ƹ��Ϣ
	 * @return ����Ҫ�޸ĵ���Ƹ��Ϣ����
	 */
	public String updateInfo(){    //�޸���Ϣ
		updateInfo=companyZhaoPinInfoService.findZhaoPinById(id);
		return "updateInfo";
	}
//******************************�ļ�����***********************************	
	public String downFile(){      //���ؼ���ģ��
		TabInformation info=companyZhaoPinInfoService.findZhaoPinById(downId);
		System.out.println("---------------------------"+info.getFInfoPath());
		this.setContentType("application/"+this.getExt(info.getFInfoPath()));
		this.setFilePath(CommonConstVariable.INFOMATION_FILE_PATH+info.getFInfoPath());
		this.setFileName(info.getFInfoPath());
		return "downFileSuccess";
	}
	
	public InputStream getDownFile() throws Exception{        //�ļ����������
		System.out.println("---------------------------"+this.getFilePath());
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	public String getExt(String str){               //����ļ��ĺ�׺��
		String subStr=str.substring(str.indexOf("."));
		return subStr;
	}
	//******************************�ļ�����***********************************		
	/**
	 * ���빫˾��ʾ��˾������
	 * @return
	 */
	public String applyCompany(){                  //���빫˾����ϸ��Ϣ
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
