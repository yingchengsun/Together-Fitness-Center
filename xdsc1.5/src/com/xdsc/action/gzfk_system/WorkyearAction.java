package com.xdsc.action.gzfk_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.GzfkTabComnums;
import com.xdsc.model.TabCompany;
import com.xdsc.service.gzfk_system.CompanyInfoService;
import com.xdsc.service.gzfk_system.WorkyearService;

/**用人单位录用信息处理
 * @author Administrator
 * @version 1.3
 */
public class WorkyearAction {
	private Integer FId;
	private TabCompany tabCompany;
	private Date FComNumYear;
	private Integer FComNum;
	private String FContactPerson;
	
	private String FCompanyNumber;
	private List<GzfkTabComnums> listWorkyearInfo;
	private WorkyearService workyearService;
	private CompanyInfoService companyInfoService;
	
	GzfkTabComnums workyear = new GzfkTabComnums();
	
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

	public GzfkTabComnums getWorkyear() {
		return workyear;
	}

	public void setWorkyear(GzfkTabComnums workyear) {
		this.workyear = workyear;
	}

	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer id) {
		FId = id;
	}

	public TabCompany getTabCompany() {
		return tabCompany;
	}

	public void setTabCompany(TabCompany tabCompany) {
		this.tabCompany = tabCompany;
	}

	public Date getFComNumYear() {
		return FComNumYear;
	}

	public void setFComNumYear(Date comNumYear) {
		FComNumYear = comNumYear;
	}

	public Integer getFComNum() {
		return FComNum;
	}

	public void setFComNum(Integer comNum) {
		FComNum = comNum;
	}

	public WorkyearService getWorkyearService() {
		return workyearService;
	}

	public void setWorkyearService(WorkyearService workyearService) {
		this.workyearService = workyearService;
	}
	
	public String getFCompanyNumber() {
		return FCompanyNumber;
	}

	public void setFCompanyNumber(String companyNumber) {
		FCompanyNumber = companyNumber;
	}

	public List<GzfkTabComnums> getListWorkyearInfo() {
		return listWorkyearInfo;
	}

	public void setListWorkyearInfo(List<GzfkTabComnums> listWorkyearInfo) {
		this.listWorkyearInfo = listWorkyearInfo;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public String getFContactPerson() {
		return FContactPerson;
	}

	public void setFContactPerson(String contactPerson) {
		FContactPerson = contactPerson;
	}
	
	//----------------------
	/**添加用人单位某年份录用信息响应
	 * @return addWorkyear 添加成功
	 */
	public String addWorkyear(){
		
		workyear.setFComNumYear(FComNumYear);
		System.out.println(FComNumYear);
		workyear.setFComNum(FComNum);
		workyear.setFContactPerson(FContactPerson);
		
		TabCompany company=new TabCompany();
		System.out.println(FCompanyNumber);
		company= companyInfoService.findCompanyByNum(FCompanyNumber);
		
		workyear.setTabCompany(company);
		
		workyearService.addWorkyear(workyear);
		System.out.println(FComNumYear);
		return "addWorkyear";
	}
	
	public String findWorkyearByNum(){
		//GzfkTabComnums workyear = new GzfkTabComnums();
		workyear = workyearService.findWorkyearByNum(FId);
		
		return "findWorkyearByNum";
	}
	
	public String findWorkyearInfoByNum(){
		
		listWorkyearInfo = workyearService.findWorkyearInfoByNum(FCompanyNumber);
		return "findWorkyearInfoByNum";
	}
	
	public String findAllUniyear(){
		listWorkyearInfo = workyearService.findAllWorkyear();
		if(listWorkyearInfo.size()>10){
			int pages = 10;
			int listlength = this.listWorkyearInfo.size();
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
			this.listWorkyearInfo = this.listWorkyearInfo.subList(startIndex, endIndex);
		}
		return "findAllUniyear";
		}

	public String deleteWorkyearByNum(){
		workyear = workyearService.findWorkyearByNum(FId);
		workyearService.deleteWorkyearByNum(workyear);
		listWorkyearInfo = workyearService.findAllWorkyear();

		return "deleteWorkyearByNum";
		}
	
	public String updateWorkyear(){
		workyear.setFComNum(FComNum);
		workyear.setFComNumYear(FComNumYear);
		workyear.setFContactPerson(FContactPerson);
		
		workyearService.updateWorkyear(workyear);
		listWorkyearInfo = workyearService.findAllWorkyear();

		return "updateWorkyear";
	}

}
