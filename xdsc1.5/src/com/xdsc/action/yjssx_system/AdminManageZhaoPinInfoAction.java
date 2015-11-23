package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.SystemInfomationService;
import com.xdsc.util.CommonConstVariable;

public class AdminManageZhaoPinInfoAction extends ActionSupport {
	
	private SystemInfomationService systemInfomationService;
	
	/**
	 * 显示招聘信息
	 */
	private List<TabInformation> infoList;
	
	private int infoId;
	
	private String type;
	
	/**
	 * 显示招聘信息
	 * @return
	 */
	public String showInfo(){
		List<TabInformation> list= systemInfomationService.findAllInfo();
		infoList = new ArrayList<TabInformation>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_ZHOPIN)){
				infoList.add(list.get(i));
			}
		}
		return "showInfo";
	}
	
	/**
	 * 重设招聘信息是否发布的标志
	 * @return
	 */
	public String releaseInfo(){
		TabInformation information=systemInfomationService.findInfoById(infoId);
		if(type.equals(CommonConstVariable.ZHAOPIN_IS_RELEASE)){
			information.setFBiaoZhi(CommonConstVariable.ZHAOPIN_Not_RELEASE);
		}else{
			information.setFBiaoZhi(CommonConstVariable.ZHAOPIN_IS_RELEASE);
		}
		systemInfomationService.updateInfo(information);
		List<TabInformation> list= systemInfomationService.findAllInfo();
		infoList = new ArrayList<TabInformation>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_ZHOPIN)){
				infoList.add(list.get(i));
			}
		}
		return "releaseInfo";
	}
	
	

	public SystemInfomationService getSystemInfomationService() {
		return systemInfomationService;
	}

	public void setSystemInfomationService(
			SystemInfomationService systemInfomationService) {
		this.systemInfomationService = systemInfomationService;
	}

	public List<TabInformation> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<TabInformation> infoList) {
		this.infoList = infoList;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
