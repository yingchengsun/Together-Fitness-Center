package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService;

/**
 * 类功能:实习招聘信息查看
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateZhaoPinInfoAction extends ActionSupport {

	private CompanyZhaoPinInfoService companyZhaoPinInfoService;
	
	private List<TabInformation> infoList; 
	
	private TabInformation infoDetail;
	
	private int id;
	
	private int p = 1;

	private int lastPage;

	/**
	 * 显示所有公司的招聘信息
	 * @return 返回查找出来的所有招聘信息
	 */
	public String showAllInfo(){      //查找所有公司招聘信息
		infoList = companyZhaoPinInfoService.findAllReleaseZhaoPinInfoByAdmin();
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
		return "showAllInfo";
	}
	
	/**
	 * 显示招聘详细信息
	 * @return 返回招聘详情
	 */
	public String showInfo(){    //显示信息详情
		infoDetail = companyZhaoPinInfoService.findZhaoPinById(id);
		return "showInfo";
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
	
	
	public TabInformation getInfoDetail() {
		return infoDetail;
	}

	public void setInfoDetail(TabInformation infoDetail) {
		this.infoDetail = infoDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
