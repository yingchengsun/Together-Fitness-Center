package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**类功能：管理员对企业信息的管理
 * @author 许鑫
 * @version 1.1
 */
public class AdminCompanyInfoManageAction extends ActionSupport {

	/**
	 * 企业服务层接口
	 */
	private CompanyInfoService companyInfoService;
	
	/**
	 * 由于导师信息服务层代码也使用到添加User表的功能
	 * 因在此次用到导师的service
	 */
	private TutorInfoService tutorInfoService;
	
	/**
	 * 根据条件查找出的公司的信息
	 */
	private List<TabCompany> companyList;  
	
	/**
	 * 用于页面下拉菜单上循环显示company列表的list
	 */
	private List<TabCompany> company;
	
	/**
	 * 根据公司的名称查找公司信息，返回的信息放在companyList中
	 */
	private String ComName;
	
	/**
	 * 删除公司的信息，传入公司信息的Id
	 */
	private List<String> delId;      
	
	/**
	 * 添加公司信息，只添加公司的用户名和密码，其他信息由公司自己修改
	 */
	private String userName;
	
	private String password;
	
	private TabCompany companyInfo;
	
	//-------------------------------公司搜索条件----------------------------------------
	private String companyName;
	
	private String companyAddress;
	
	private String companyEmail;
	
	private String ConnectPerson;
	
	/**
	 * 分页的实现，p代表第一页，lastPage代表最后一页
	 */
	private int p = 1;

	private int lastPage;
	
	/**查找所有公司的详细信息，并在页面上显示企业信息下拉列表
	 * @return findAllCompany 找到所有了公司信息
	 */
	public String findAllCompany(){            
		companyList = companyInfoService.findAllCompanyInfo();
		company = companyList;
		if(companyList.size()>10){
			int pages = 10;
			int listlength = this.companyList.size();
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
			this.companyList = this.companyList.subList(startIndex, endIndex);
		}

		return "findAllCompany";
	}
	
	/**根据公司的名称查找公司的信息，company是下拉菜单中需要显示的数据
	 * @return searchCompany 返回找到的公司的信息
	 */
	public String searchCompany(){                 
		companyList = companyInfoService.findCompanyByCondition(companyName, companyAddress, companyEmail, ConnectPerson);
		company = companyInfoService.findAllCompanyInfo();
		return "searchCompany";
	}
	
	/**管理员删除公司的信息
	 * @return deleteCompany 删除公司信息成功
	 */
	public String deleteCompany(){                    
		for(int i=0;i<delId.size();i++){
			TabCompany temp= companyInfoService.findCompanyByNum(delId.get(i));
			companyInfoService.delCompanyInfo(temp);
		}
		return "deleteCompany";
	}
	
	/**简单的跳转，跳转到添加公司信息的页面
	 * @return preAddCompanyInfo 跳转成功
	 */
	public String preAddCompanyInfo(){
		return "preAddCompanyInfo";
	}
	
	/**添加公司信息，先用户名密码保存User表中，剩下信息由公司自己修改
	 * @return
	 */
	public String AddCompanyInfo(){
		MhqxTabUser NewUser= new MhqxTabUser();
		NewUser.setFUserNumber(userName);
		NewUser.setFUserPassword(password);
		tutorInfoService.addModuleUser(NewUser);
		companyInfo.setFCompanyNumber(userName);
		companyInfo.setMhqxTabUser(NewUser);
		companyInfoService.addCompanyInfo(companyInfo);
		return "AddCompanyInfo";
	}
	
	public CompanyInfoService getCompanyInfoService() {        
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public List<TabCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<TabCompany> companyList) {
		this.companyList = companyList;
	}

	public String getComName() {
		return ComName;
	}

	public void setComName(String comName) {
		ComName = comName;
	}

	public List<String> getDelId() {
		return delId;
	}

	public void setDelId(List<String> delId) {
		this.delId = delId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TabCompany getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(TabCompany companyInfo) {
		this.companyInfo = companyInfo;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
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

	public List<TabCompany> getCompany() {
		return company;
	}

	public void setCompany(List<TabCompany> company) {
		this.company = company;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getConnectPerson() {
		return ConnectPerson;
	}

	public void setConnectPerson(String connectPerson) {
		ConnectPerson = connectPerson;
	}

}
