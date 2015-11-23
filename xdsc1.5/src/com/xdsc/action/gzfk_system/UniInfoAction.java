package com.xdsc.action.gzfk_system;


import java.util.List;

import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.service.gzfk_system.UniInfoService;

/**升学学校信息处理
 * @author Administrator
 * @version 1.3
 */
public class UniInfoAction {
	private Integer FId;
	private String FUniName;
	private String FUniCountry;
	private String FUniCity;
	private String FUniAddress;
	private String FUniEmail;
	private String FUniTel;
	private String FUniIntro;
	
	private String FUniNameselect;
	
	private GzfkTabStudyuniversity uni = new GzfkTabStudyuniversity();
	
	private List<GzfkTabStudyuniversity> listUniInfo;
	private  UniInfoService uniInfoService;
	
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
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer uniId) {
		FId = uniId;
	}
	public String getFUniName() {
		return FUniName;
	}
	public void setFUniName(String uniName) {
		FUniName = uniName;
	}
	public String getFUniCountry() {
		return FUniCountry;
	}
	public void setFUniCountry(String uniCountry) {
		FUniCountry = uniCountry;
	}
	public String getFUniCity() {
		return FUniCity;
	}
	public void setFUniCity(String uniCity) {
		FUniCity = uniCity;
	}
	public String getFUniAddress() {
		return FUniAddress;
	}
	public void setFUniAddress(String uniAddress) {
		FUniAddress = uniAddress;
	}
	public String getFUniEmail() {
		return FUniEmail;
	}
	public void setFUniEmail(String uniEmail) {
		FUniEmail = uniEmail;
	}
	public String getFUniTel() {
		return FUniTel;
	}
	public void setFUniTel(String uniTel) {
		FUniTel = uniTel;
	}
	public String getFUniIntro() {
		return FUniIntro;
	}
	public void setFUniIntro(String uniIntro) {
		FUniIntro = uniIntro;
	}
	public String getFUniNameselect() {
		return FUniNameselect;
	}
	public void setFUniNameselect(String uniNameselect) {
		FUniNameselect = uniNameselect;
	}
	public List<GzfkTabStudyuniversity> getListUniInfo() {
		return listUniInfo;
	}
	public void setListUniInfo(List<GzfkTabStudyuniversity> listUniInfo) {
		this.listUniInfo = listUniInfo;
	}
	public UniInfoService getUniInfoService() {
		return uniInfoService;
	}
	public void setUniInfoService(UniInfoService uniInfoService) {
		this.uniInfoService = uniInfoService;
	}
	
	//-----------
	public String addUniInfo(){
		//GzfkTabStudyuniversity uni = new GzfkTabStudyuniversity();
		listUniInfo=uniInfoService.findUniByName(FUniName);
		if(listUniInfo.size()==0){
		uni=new GzfkTabStudyuniversity();
		uni.setFUniName(FUniName);
		
		uni.setFUniAddress(FUniAddress);
		uni.setFUniCity(FUniCity);
		uni.setFUniCountry(FUniCountry);
		uni.setFUniEmail(FUniEmail);
		uni.setFId(FId);
		uni.setFUniIntro(FUniIntro);
		uni.setFUniName(FUniName);
		uni.setFUniTel(FUniTel);
		
		uniInfoService.addUniInfo(uni);
		
		listUniInfo = uniInfoService.findAllUniInfo();
		return "addUniInfo";	
		}
		else
			return "UniExist";
		}
	
	public String findAllUniInfo(){
		listUniInfo = uniInfoService.findAllUniInfo();
		if(listUniInfo.size()>10){
			int pages = 10;
			int listlength = this.listUniInfo.size();
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
			this.listUniInfo = this.listUniInfo.subList(startIndex, endIndex);
		}
		return "findAllUniInfo";
		
	}
	
	public GzfkTabStudyuniversity getUni() {
		return uni;
	}
	public void setUni(GzfkTabStudyuniversity uni) {
		this.uni = uni;
	}
	public String searchUniByName(){
		listUniInfo = uniInfoService.searchUniByName(FUniNameselect);
		return "searchUniByName";
		
	}
	public String findUniByName(){
		listUniInfo=uniInfoService.findUniByName(FUniName);
		return "findUniByName";
	}
	public String findUniByNum(){
		//GzfkTabStudyuniversity uni = new GzfkTabStudyuniversity();
		uni = uniInfoService.findUniByNum(FId);	
		return "findUniByNum";
	}
	
	public String delUniByNum(){
		//GzfkTabStudyuniversity uni = new GzfkTabStudyuniversity();
		uni = uniInfoService.findUniByNum(FId);
		uniInfoService.delUniInfo(uni);
		listUniInfo = uniInfoService.findAllUniInfo();
		return "delUniByNum";
		}
	
	public String updateUniInfo(){
		uni.setFUniAddress(FUniAddress);
		uni.setFUniCity(FUniCity);
		uni.setFUniCountry(FUniCountry);
		uni.setFUniEmail(FUniEmail);
		uni.setFUniIntro(FUniIntro);
		uni.setFUniName(FUniName);
		uni.setFUniTel(FUniTel);
		uniInfoService.updateUniInfo(uni);
		
		listUniInfo = uniInfoService.findAllUniInfo();

		return "updateUniInfo";
	}
}
