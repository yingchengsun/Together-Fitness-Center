package com.xdsc.action.gzfk_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.model.GzfkTabUninums;
import com.xdsc.service.gzfk_system.UniInfoService;
import com.xdsc.service.gzfk_system.UniyearService;

/**升学学校录取信息处理
 * @author Administrator
 * @version 1.3
 */
public class UniyearAction {
	
	private Integer FNumber;      //学校年份录取自增主键
	private GzfkTabStudyuniversity gzfkTabStudyuniversity;
	private Date FUniYear;
	private Integer FUniNum;
	
	private Integer FId;          //读研学校主键
	private List<GzfkTabUninums> listUniyearInfo;
	private UniyearService uniyearService;
	private UniInfoService uniInfoService;
	
	GzfkTabUninums uniyear = new GzfkTabUninums(); 
	
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
	public GzfkTabUninums getUniyear() {
		return uniyear;
	}
	public void setUniyear(GzfkTabUninums uniyear) {
		this.uniyear = uniyear;
	}
	public Integer getFNumber() {
		return FNumber;
	}
	public void setFNumber(Integer number) {
		FNumber = number;
	}
	public GzfkTabStudyuniversity getGzfkTabStudyuniversity() {
		return gzfkTabStudyuniversity;
	}
	public void setGzfkTabStudyuniversity(
			GzfkTabStudyuniversity gzfkTabStudyuniversity) {
		this.gzfkTabStudyuniversity = gzfkTabStudyuniversity;
	}
	public Date getFUniYear() {
		return FUniYear;
	}
	public void setFUniYear(Date uniYear) {
		FUniYear = uniYear;
	}
	public Integer getFUniNum() {
		return FUniNum;
	}
	public void setFUniNum(Integer uniNum) {
		FUniNum = uniNum;
	}

	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	public List<GzfkTabUninums> getListUniyearInfo() {
		return listUniyearInfo;
	}
	public void setListUniyearInfo(List<GzfkTabUninums> listUniyearInfo) {
		this.listUniyearInfo = listUniyearInfo;
	}
	public UniyearService getUniyearService() {
		return uniyearService;
	}
	public void setUniyearService(UniyearService uniyearService) {
		this.uniyearService = uniyearService;
	}
	public UniInfoService getUniInfoService() {
		return uniInfoService;
	}
	public void setUniInfoService(UniInfoService uniInfoService) {
		this.uniInfoService = uniInfoService;
	}
	
	//---------------------
	public String addUniyear(){
		System.out.println("start******************************");

		uniyear.setFUniYear(FUniYear);
		System.out.println(FUniYear);
		uniyear.setFUniNum(FUniNum);
		System.out.println(FUniNum);

		GzfkTabStudyuniversity gzfkTabStudyuniversity = new GzfkTabStudyuniversity();
		gzfkTabStudyuniversity = uniInfoService.findUniByNum(FId);
		System.out.println(FId);

		uniyear.setGzfkTabStudyuniversity(gzfkTabStudyuniversity);
		System.out.println(FId+"=++++++++++++++++++++++");

		uniyearService.addUniyear(uniyear);
		listUniyearInfo = uniyearService.findAllUniyear();
		return "addUniyear";
	}
	
	public String findUniyearInfoByNum(){
		
		listUniyearInfo = uniyearService.findUniyearInfoByNum(FId);
		return "findUniyearInfoByNum";
	}
	
	public String findUniyearByNum(){
		uniyear = uniyearService.findUniyearByNum(FNumber);
		return "findUniyearByNum";
	}
	
	public String findAllUniyear(){
		listUniyearInfo = uniyearService.findAllUniyear();
		if(listUniyearInfo.size()>10){
			int pages = 10;
			int listlength = this.listUniyearInfo.size();
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
			this.listUniyearInfo = this.listUniyearInfo.subList(startIndex, endIndex);
		}
		return "findAllUniyear";
	}
	
	public String deleteUniyearByNum(){
		uniyear = uniyearService.findUniyearByNum(FNumber);
		uniyearService.deleteUniyearByNum(uniyear);
		listUniyearInfo = uniyearService.findAllUniyear();
		
		return "deleteUniyearByNum";
	}
	
	public String updateUniyear(){
		uniyear.setFUniYear(FUniYear);
		uniyear.setFUniNum(FUniNum);
		
		uniyearService.updateUniyear(uniyear);
		listUniyearInfo = uniyearService.findAllUniyear();

		return "updateUniyear";
	}
	
}
