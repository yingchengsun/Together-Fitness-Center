package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.TabClasses;
import com.xdsc.model.TabGrade;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.util.PageListHolder;

/**
 * 班级信息
 * 
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabClassesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private XsglTabClassesManager xsglTabClassesManager;
	private XsglTabGradeManager xsglTabGradeManager;

	private String FClassNumber;
	private TabGrade tabGrade;
	private String FClassName;
	private Integer FClassMaleNum;
	private Integer FClassFemaleNum;
	private Integer FClassTotalNum;
	private Integer FClassCapacity;
	private Integer FClassWorkNum;
	private Integer FClassKaoYanNum;
	private Integer FClassAbroadNum;
	private Integer FClassOtherNum;
	private String FCalssLocation;
	private Integer FClassPartyNum;
	private Integer FGradeId;
	private String FGradeName;

	public XsglTabClassesManager getXsglTabClassesManager() {
		return xsglTabClassesManager;
	}

	public void setXsglTabClassesManager(
			XsglTabClassesManager xsglTabClassesManager) {
		this.xsglTabClassesManager = xsglTabClassesManager;
	}

	public XsglTabGradeManager getXsglTabGradeManager() {
		return xsglTabGradeManager;
	}

	public void setXsglTabGradeManager(XsglTabGradeManager xsglTabGradeManager) {
		this.xsglTabGradeManager = xsglTabGradeManager;
	}

	public String getFClassNumber() {
		return FClassNumber;
	}

	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
	}

	public String getFClassName() {
		return FClassName;
	}

	public void setFClassName(String className) {
		FClassName = className;
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

	public Integer getFClassCapacity() {
		return FClassCapacity;
	}

	public void setFClassCapacity(Integer classCapacity) {
		FClassCapacity = classCapacity;
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

	public String getFCalssLocation() {
		return FCalssLocation;
	}

	public void setFCalssLocation(String calssLocation) {
		FCalssLocation = calssLocation;
	}

	public TabGrade getTabGrade() {
		return tabGrade;
	}

	public void setTabGrade(TabGrade tabGrade) {
		this.tabGrade = tabGrade;
	}

	public Integer getFGradeId() {
		return FGradeId;
	}

	public void setFGradeId(Integer gradeId) {
		FGradeId = gradeId;
	}

	public String getFGradeName() {
		return FGradeName;
	}

	public void setFGradeName(String gradeName) {
		FGradeName = gradeName;
	}

	/**
	 * 获取各班级信息
	 * 
	 * @return SUCCESS 获取成功
	 */
	public String getClassList() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");
		List list = xsglTabClassesManager.getClassList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("classAll", list_all);
		request.put("classList", list_current);

		return SUCCESS;
	}

	/**
	 * 前翻页
	 * 
	 * @return SUCCESS 前翻页成功
	 */
	public String classPrevious() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");

		PageListHolder list_all = (PageListHolder) session.get("classAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("classList", list_current);

		return SUCCESS;
	}

	/**
	 * 后翻页
	 * 
	 * @return SUCCESS 后翻页成功
	 */
	public String classNext() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");

		PageListHolder list_all = (PageListHolder) session.get("classAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("classList", list_current);

		return SUCCESS;
	}

	/**
	 * 预更新班级信息
	 * 
	 * @return SUCCESS 确定更新对象
	 */
	public String preUpdateClass() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String classNum = request.getParameter("cid");
		request.setAttribute("tabClass", xsglTabClassesManager
				.getClassByclassNum(classNum));
		return SUCCESS;
	}

	/**
	 * 更新班级信息
	 * 
	 * @return SUCCESS 更新成功
	 * @return INPUT 输入值有错，更新失败
	 */
	public String updateClass() {
		TabClasses tabClass = (TabClasses) xsglTabClassesManager
				.getClassByclassNum(FClassNumber);
		tabGrade = (TabGrade) xsglTabGradeManager
				.getGradeByGradeName(FGradeName);
		if (tabGrade == null) return INPUT;
		else{
			tabClass.setFClassNumber(FClassNumber);
			tabClass.setFClassName(FClassName);
			tabClass.setFClassTotalNum(FClassTotalNum);
			tabClass.setFClassMaleNum(FClassMaleNum);
			tabClass.setFClassFemaleNum(FClassFemaleNum);
			tabClass.setTabGrade(tabGrade);
			xsglTabClassesManager.updateClass(tabClass);
			return SUCCESS;
		} 
	}

	/**
	 * 手动添加新班级信息
	 * 
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入值有错，添加失败
	 */
	public String saveClass() {

		tabGrade = xsglTabGradeManager.getGradeByGradeName(FGradeName);
		if (null == tabGrade) {
			return INPUT;
		} else {
			TabClasses tabClass = new TabClasses();
			tabClass.setFClassNumber(FClassNumber);
			tabClass.setFClassName(FClassName);
			tabClass.setFClassTotalNum(FClassTotalNum);
			tabClass.setFClassMaleNum(FClassMaleNum);
			tabClass.setFClassFemaleNum(FClassFemaleNum);
			tabClass.setTabGrade(tabGrade);
			xsglTabClassesManager.saveClass(tabClass);
			return SUCCESS;
		}
	}

	/**
	 * 删除新班级信息
	 * 
	 * @return SUCCESS 删除成功
	 */
	public String deleteClass() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String classNum = request.getParameter("cid");
		xsglTabClassesManager.deleteClass(xsglTabClassesManager
				.getClassByclassNum(classNum));
		return SUCCESS;
	}

	/**
	 * 按班级号搜索班级信息
	 * 
	 * @return SUCCESS 搜索成功
	 */
	public String getClassByClassNum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String classNum = request.getParameter("cid");
		request.setAttribute("classList", xsglTabClassesManager
				.getClassByclassNum(classNum));
		return SUCCESS;
	}

}
