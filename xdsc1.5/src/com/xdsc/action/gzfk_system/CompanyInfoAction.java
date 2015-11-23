package com.xdsc.action.gzfk_system;

import com.xdsc.service.gzfk_system.CompanyInfoService;
import com.xdsc.service.gzfk_system.UserLoginService;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCompany;
import java.util.List;

/**用人单位信息处理
 * @author Administrator
 * @version 1.3
 */
public class CompanyInfoAction {
	private String FUserNumber;
	//private String FUserPassword;
	
	private String FCompanyNumber;
	private String FCompanyName;
	private String FTelephone;
	private String FEmailAddress;
	//private String FPassword; 
	private String FAddress;
	private String FInformation;
	private String FProperty;
	
	private String FNameselect;
	private String FPropertyselect;
	
	private TabCompany company = new TabCompany(); 
	private MhqxTabUser user= new MhqxTabUser();
	//private MhqxTabUser user;
	private UserLoginService userLoginService;
	private List<TabCompany> listCompanyInfo;
	private CompanyInfoService companyInfoService;
	
	private int p = 1;
    private int lastPage;
	
	
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
	public String getFUserNumber() {
		return FUserNumber;
	}
	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}
	public String getFCompanyNumber() {
		return FCompanyNumber;
	}
	public void setFCompanyNumber(String companyNumber) {
		FCompanyNumber = companyNumber;
	}
	public String getFCompanyName() {
		return FCompanyName;
	}
	public void setFCompanyName(String companyName) {
		FCompanyName = companyName;
	}
	public String getFTelephone() {
		return FTelephone;
	}
	public void setFTelephone(String telephone) {
		FTelephone = telephone;
	}
	public String getFEmailAddress() {
		return FEmailAddress;
	}
	public void setFEmailAddress(String emailAddress) {
		FEmailAddress = emailAddress;
	}
	public String getFAddress() {
		return FAddress;
	}
	public void setFAddress(String address) {
		FAddress = address;
	}
	public String getFInformation() {
		return FInformation;
	}
	public void setFInformation(String information) {
		FInformation = information;
	}
	public String getFProperty() {
		return FProperty;
	}
	public void setFProperty(String property) {
		FProperty = property;
	}
	public String getFNameselect() {
		return FNameselect;
	}
	public void setFNameselect(String nameselect) {
		FNameselect = nameselect;
	}
	public List<TabCompany> getListCompanyInfo() {
		return listCompanyInfo;
	}
	public void setListCompanyInfo(List<TabCompany> listCompanyInfo) {
		this.listCompanyInfo = listCompanyInfo;
	}
	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}
	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}
	public String getFPropertyselect() {
		return FPropertyselect;
	}
	public void setFPropertyselect(String propertyselect) {
		FPropertyselect = propertyselect;
	}
	public TabCompany getCompany() {
		return company;
	}
	public void setCompany(TabCompany company) {
		this.company = company;
	}
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}
	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	//----------
	/**列出所有用人单位信息的响应
	 * @return findAllCompanyInfo 返回所有记录
	 */
	public String findAllCompanyInfo(){
		listCompanyInfo = companyInfoService.findAllCompanyInfo();
		if(listCompanyInfo.size()>10){
			int pages = 10;
			int listlength = this.listCompanyInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listCompanyInfo = this.listCompanyInfo.subList(startIndex, endIndex);
		}
		return "findAllCompanyInfo";
		
	}
	
	/**通过用人单位ID找到相应记录响应
	 * @return findCompanybyNum 返回记录
	 */
	public String findCompanybyNum(){
		System.out.println("start findbynum");
		
		company = companyInfoService.findCompanyByNum(FCompanyNumber);
		System.out.println(company.getFCompanyName());

		return "findCompanybyNum";
	}
	
	public String findCompanybyName(){
		listCompanyInfo = companyInfoService.findCompanyByName(FNameselect);
		return "findCompanybyName";
		
	}
	
	public String findCompanyByProperty(){
		listCompanyInfo = companyInfoService.findCompanyByFProperty(FPropertyselect);
		return "findCompanyByProperty";
		
	}
	
	/**添加用人单位信息响应
	 * @return addCompanyInfo 添加成功
	 * @return CompanyExist 记录已存在，添加失败
	 */
	public String addCompanyInfo(){
		System.out.println("start");
		company=companyInfoService.findCompanyByNum(FUserNumber);
		user=userLoginService.findUserByNum(FUserNumber);
		if(company!=null){
			return "CompanyExist";
		}
		else if(user==null){
		
		MhqxTabUser user= new MhqxTabUser();
		System.out.println("start user");
		user.setFUserNumber(FUserNumber);
		TabCompany company = new TabCompany();
		company.setFCompanyNumber(FUserNumber);

		companyInfoService.addCompanyInfo(user);
		
		System.out.println("start company");
		company.setMhqxTabUser(user);
		company.setFCompanyName(FCompanyName);
		company.setFAddress(FAddress);
		company.setFEmailAddress(FEmailAddress);
		company.setFInformation(FInformation);
		company.setFProperty(FProperty);
		company.setFTelephone(FTelephone);
		companyInfoService.addCompanyInfo(company);
		System.out.println("finish");
		
		listCompanyInfo = companyInfoService.findAllCompanyInfo();
		if(listCompanyInfo.size()>10){
			int pages = 10;
			int listlength = this.listCompanyInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listCompanyInfo = this.listCompanyInfo.subList(startIndex, endIndex);
		}
		return "addCompanyInfo";
		}
		// user表有记录和company表无记录
		else {

			TabCompany company = new TabCompany();
			company.setFCompanyNumber(FUserNumber);
			company.setMhqxTabUser(user);
			company.setFCompanyName(FCompanyName);
			company.setFAddress(FAddress);
			company.setFEmailAddress(FEmailAddress);
			company.setFInformation(FInformation);
			company.setFProperty(FProperty);
			company.setFTelephone(FTelephone);
			companyInfoService.addCompanyInfo(company);
			
			listCompanyInfo = companyInfoService.findAllCompanyInfo();
			return "addCompanyInfo";
		}
		
	}
	
	/**删除用人单位信息响应
	 * @return delCompanyByNum 删除成功
	 */
	public String delCompanyByNum(){
		//TabCompany company = new TabCompany();
		company = companyInfoService.findCompanyByNum(FCompanyNumber);
		companyInfoService.delCompanyInfo(company);
		listCompanyInfo = companyInfoService.findAllCompanyInfo();
		if(listCompanyInfo.size()>10){
			int pages = 10;
			int listlength = this.listCompanyInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listCompanyInfo = this.listCompanyInfo.subList(startIndex, endIndex);
		}
		return "delCompanyByNum";
	}
	
	/**更新用人单位信息响应
	 * @return updateCompanyInfo 更新成功
	 */
	public String updateCompanyInfo(){
		company.setFAddress(FAddress);
		company.setFCompanyName(FCompanyName);
		company.setFEmailAddress(FEmailAddress);
		company.setFInformation(FInformation);
		company.setFProperty(FProperty);
		company.setFTelephone(FTelephone);
		
		companyInfoService.updateCompanyInfo(company);
		listCompanyInfo = companyInfoService.findAllCompanyInfo();
		if(listCompanyInfo.size()>10){
			int pages = 10;
			int listlength = this.listCompanyInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listCompanyInfo = this.listCompanyInfo.subList(startIndex, endIndex);
		}
		return "updateCompanyInfo";
	}
	public MhqxTabUser getUser() {
		return user;
	}
	public void setUser(MhqxTabUser user) {
		this.user = user;
	}
	
}
