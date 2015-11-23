package com.xdsc.action.gzfk_system;

import java.util.List;

import com.xdsc.model.TabClasses;
import com.xdsc.service.gzfk_system.ClassInfoService;
/**班级信息处理
 * 各类人数的记录
 * @author 王文倩
 * @version 1.1
 */
public class ClassInfoAction {
	/**
	 * 班级号
	 */
	private String FClassNumber;
	/**
	 * 班级基本信息相关属性
	 */
	private Integer FClassMaleNum;
	private Integer FClassFemaleNum;
	private Integer FClassTotalNum;
	private Integer FClassPartyNum;
	/**
	 * 班级毕业信息相关属性
	 */
	private Integer FClassWorkNum;
	private Integer FClassKaoYanNum;
	private Integer FClassAbroadNum;
	private Integer FClassOtherNum;
	/**
	 * 查询时输入信息相关属性
	 */
	private String FClassNumSelect;
	private String FGradeNumSelect;
	
	private TabClasses class1 = new TabClasses();
	private ClassInfoService classInfoService;
	private List<TabClasses> listClassInfo;
	
	/**
	 * 分页信息处理相关属性
	 */
	private int p = 1;
    private int lastPage;
	
	public String getFClassNumber() {
		return FClassNumber;
	}
	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
	}
	public Integer getFClassMaleNum() {
		return FClassMaleNum;
	}
	public void setFClassMaleNum(Integer classMaleNum) {
		FClassMaleNum = classMaleNum;
	}
	public Integer getFClassFemaleNum() {
		return FClassFemaleNum;
	}
	public void setFClassFemaleNum(Integer classFemaleNum) {
		FClassFemaleNum = classFemaleNum;
	}
	public Integer getFClassTotalNum() {
		return FClassTotalNum;
	}
	public void setFClassTotalNum(Integer classTotalNum) {
		FClassTotalNum = classTotalNum;
	}
	public Integer getFClassPartyNum() {
		return FClassPartyNum;
	}
	public void setFClassPartyNum(Integer classPartyNum) {
		FClassPartyNum = classPartyNum;
	}
	public Integer getFClassWorkNum() {
		return FClassWorkNum;
	}
	public void setFClassWorkNum(Integer classWorkNum) {
		FClassWorkNum = classWorkNum;
	}
	public Integer getFClassKaoYanNum() {
		return FClassKaoYanNum;
	}
	public void setFClassKaoYanNum(Integer classKaoYanNum) {
		FClassKaoYanNum = classKaoYanNum;
	}
	public Integer getFClassAbroadNum() {
		return FClassAbroadNum;
	}
	public void setFClassAbroadNum(Integer classAbroadNum) {
		FClassAbroadNum = classAbroadNum;
	}
	public Integer getFClassOtherNum() {
		return FClassOtherNum;
	}
	public void setFClassOtherNum(Integer classOtherNum) {
		FClassOtherNum = classOtherNum;
	}
	public ClassInfoService getClassInfoService() {
		return classInfoService;
	}
	public void setClassInfoService(ClassInfoService classInfoService) {
		this.classInfoService = classInfoService;
	}
	public List<TabClasses> getListClassInfo() {
		return listClassInfo;
	}
	public void setListClassInfo(List<TabClasses> listClassInfo) {
		this.listClassInfo = listClassInfo;
	}
	public String getFClassNumSelect() {
		return FClassNumSelect;
	}
	public void setFClassNumSelect(String classNumSelect) {
		FClassNumSelect = classNumSelect;
	}

	public String getFGradeNumSelect() {
		return FGradeNumSelect;
	}
	public void setFGradeNumSelect(String gradeNumSelect) {
		FGradeNumSelect = gradeNumSelect;
	}
	

	public TabClasses getClass1() {
		return class1;
	}
	public void setClass1(TabClasses class1) {
		this.class1 = class1;
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

	
	
	//------
	/**添加班级的响应处理
	 * @return addClassInfo 添加成功
	 * @return ClassExist 添加失败，该班级已存在
	 */
	public String addClassInfo(){
		//TabClasses class1 = new TabClasses();
		System.out.println("add~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		class1=classInfoService.findClassByNum(FClassNumber);
		System.out.println("find~~~~~~NUmber~~~~~~~~~~~~~~~~~~");

//		if(!classInfoService.ClassIsValid(class1)){
	if(class1==null){		
		class1 = new TabClasses();
		class1.setFClassNumber(FClassNumber);
		class1.setFClassAbroadNum(FClassAbroadNum);
		class1.setFClassKaoYanNum(FClassKaoYanNum);
		class1.setFClassWorkNum(FClassWorkNum);
		class1.setFClassOtherNum(FClassOtherNum);
		class1.setFClassFemaleNum(FClassFemaleNum);
		class1.setFClassMaleNum(FClassMaleNum);
		class1.setFClassPartyNum(FClassPartyNum);
		class1.setFClassTotalNum(FClassTotalNum);
		
		classInfoService.addClassInfo(class1);
		
		listClassInfo = classInfoService.findAllClassInfo();
		
		return "addClassInfo";	
		}
		else
			return "ClassExist";
			
	}
	
	/**列出所有班级的相应处理
	 * @return findAllClassInfo 查找成功
	 */
	public String findAllClassInfo(){
		listClassInfo = classInfoService.findAllClassInfo();
		if(listClassInfo.size()>10){
			int pages = 10;
			int listlength = this.listClassInfo.size();
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
			this.listClassInfo = this.listClassInfo.subList(startIndex, endIndex);
		}
		return "findAllClassInfo";
		
	}
	
	/**通过班级号找到班级信息的相应处理
	 * 用于删除和修改的对象处理
	 * @return findClassByNum
	 */
	public String findClassByNum(){
		TabClasses class1 = new TabClasses();
		class1 = classInfoService.findClassByNum(FClassNumSelect);
		return "findClassByNum";
		
	}

	/**通过班级号找到班级信息的相应处理
	 * 用于查询的显示
	 * @return findClassoneByNum
	 */
	public String findClassoneByNum(){
		listClassInfo = classInfoService.findClassoneByNum(FClassNumSelect);
		return "findClassoneByNum";
	}
	
	/**删除班级的相应处理
	 * @return delClassByNum
	 */
	public String delClassByNum(){
		//TabClasses class1 = new TabClasses();
		class1 = classInfoService.findClassByNum(FClassNumber);
		classInfoService.delClassInfo(class1);
		listClassInfo = classInfoService.findAllClassInfo();
		return "delClassByNum";
		
	}
	
	/**修改班级的相应处理
	 * @return updateClassInfo
	 */
	public String updateClassInfo(){
		//TabClasses class1 = new TabClasses();
//		class1=classInfoService.findClassByNum(FClassNumber);
//		class1.setFClassNumber(FClassNumber);
		class1.setFClassAbroadNum(FClassAbroadNum);
		class1.setFClassKaoYanNum(FClassKaoYanNum);
		class1.setFClassWorkNum(FClassWorkNum);
		class1.setFClassOtherNum(FClassOtherNum);
		
		class1.setFClassFemaleNum(FClassFemaleNum);
		class1.setFClassMaleNum(FClassMaleNum);
		class1.setFClassPartyNum(FClassPartyNum);
		class1.setFClassTotalNum(FClassTotalNum);
		
		classInfoService.updateClassInfo(class1);
		listClassInfo = classInfoService.findAllClassInfo();

		
		return "updateClassInfo";
	}
	
	/**年级信息响应
	 * @return findGradeByNum 找到年级信息
	 */
	public String findGradeByNum(){
		listClassInfo = classInfoService.findGradeByNum(FGradeNumSelect);
		return "findGradeByNum";
	}

}
