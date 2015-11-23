package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.SystemInfomationService;
import com.xdsc.util.CommonConstVariable;

public class YjssxFirstPageAction extends ActionSupport {

	private SystemInfomationService systemInfomationService;
	
	private List<TabInformation> newsInfo;
	
	private List<TabInformation> noticeInfo;
	
	private List<TabInformation> cooperateInfo;
	
	private List<TabInformation> ZhaoPinInfo;
	
	private int type;
	
	private List<TabInformation> moreInfo;
	
	private String infoTypeName;
	
	private int infoId;
	
	private TabInformation infoDetail;
	
	/**
	 * 首页显示部分信息
	 * @return
	 */
	public String showFirstPageInfo(){
		List<TabInformation> infoList=systemInfomationService.findAllInfo();
		newsInfo = new ArrayList<TabInformation>();
		noticeInfo = new ArrayList<TabInformation>();
		cooperateInfo = new ArrayList<TabInformation>();
		ZhaoPinInfo = new ArrayList<TabInformation>();
		for(int i=0;i<infoList.size();i++){
			if(newsInfo.size()<=5&&infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NEWS)){   //新闻公告信息只显示前5条
				newsInfo.add(infoList.get(i));
			}
			else if(noticeInfo.size()<=5&&infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NOTICE)){             //相关通知只显示前5条
				noticeInfo.add(infoList.get(i));
			}
			else if(cooperateInfo.size()<=4&&infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_COORCOM)){            //合作企业只显示前4条
				cooperateInfo.add(infoList.get(i));
			}
			else if(ZhaoPinInfo.size()<=5&&infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_ZHOPIN)){			   //招聘信息只显示前5条
				ZhaoPinInfo.add(infoList.get(i));
			}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("newsInfo", newsInfo);
		request.setAttribute("noticeInfo", noticeInfo);
		request.setAttribute("cooperateInfo", cooperateInfo);
		request.setAttribute("ZhaoPinInfo", ZhaoPinInfo);
		return "showFirstPageInfo";
	}
	
	/**
	 * 显示更多信息
	 * @return
	 */
	public String showMoreInfo(){
		moreInfo=new ArrayList<TabInformation>();
		List<TabInformation> infoList=systemInfomationService.findAllInfo();
		if(type==1){
			infoTypeName = CommonConstVariable.FIRST_PAGE_NEWS;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NEWS)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else if(type==2){
			infoTypeName = CommonConstVariable.FIRST_PAGE_NOTICE;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_NOTICE)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else if(type==3){
			infoTypeName = CommonConstVariable.FIRST_PAGE_COORCOM;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_COORCOM)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else if(type==4){
			infoTypeName = CommonConstVariable.FIRST_PAGE_ZHOPIN;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_ZHOPIN)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else if(type==5){
			infoTypeName = CommonConstVariable.FIRST_PAGE_POLICY;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_POLICY)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else if(type==6){
			infoTypeName = CommonConstVariable.FIRST_PAGE_MATERIAL;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_MATERIAL)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}else{
			infoTypeName = CommonConstVariable.FIRST_PAGE_PRINCIPLE;
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getFInfoType().equals(CommonConstVariable.FIRST_PAGE_PRINCIPLE)){   //新闻公告信息只显示前5条
					moreInfo.add(infoList.get(i));
				}
			}
		}
		return "showMoreInfo";
	}
	
	public String showInfoDetail(){
		infoDetail=systemInfomationService.findInfoById(infoId);
		return "showInfoDetail";
	}

	public List<TabInformation> getNewsInfo() {
		return newsInfo;
	}

	public void setNewsInfo(List<TabInformation> newsInfo) {
		this.newsInfo = newsInfo;
	}

	public List<TabInformation> getNoticeInfo() {
		return noticeInfo;
	}

	public void setNoticeInfo(List<TabInformation> noticeInfo) {
		this.noticeInfo = noticeInfo;
	}

	public List<TabInformation> getCooperateInfo() {
		return cooperateInfo;
	}

	public void setCooperateInfo(List<TabInformation> cooperateInfo) {
		this.cooperateInfo = cooperateInfo;
	}

	public List<TabInformation> getZhaoPinInfo() {
		return ZhaoPinInfo;
	}

	public void setZhaoPinInfo(List<TabInformation> zhaoPinInfo) {
		ZhaoPinInfo = zhaoPinInfo;
	}

	public SystemInfomationService getSystemInfomationService() {
		return systemInfomationService;
	}

	public void setSystemInfomationService(
			SystemInfomationService systemInfomationService) {
		this.systemInfomationService = systemInfomationService;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<TabInformation> getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(List<TabInformation> moreInfo) {
		this.moreInfo = moreInfo;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public TabInformation getInfoDetail() {
		return infoDetail;
	}

	public void setInfoDetail(TabInformation infoDetail) {
		this.infoDetail = infoDetail;
	}

	public String getInfoTypeName() {
		return infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}
}
