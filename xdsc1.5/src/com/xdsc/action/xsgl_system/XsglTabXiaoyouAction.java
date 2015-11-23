package com.xdsc.action.xsgl_system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.XsglTabXiaoyou;
import com.xdsc.service.xsgl_system.XsglTabXiaoyouManager;

/**校友信息
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabXiaoyouAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabXiaoyouManager xsglTabXiaoyouManager;
	private String FXiaoYouId;
	private MhqxTabUser mhqxTabUser;
	private String FXiaoYouName;
	private String FXiaoYouSex;
	private String FWorkPlace;
	private String FHistory;
	private String FPosition;
	private String FPostcode;
	private String FRegion;
	private String FGraduateYear;
	
	private int region;
	private String year;
	private String attribute;
	
	
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getFRegion() {
		return FRegion;
	}
	public void setFRegion(String region) {
		FRegion = region;
	}
	public String getFGraduateYear() {
		return FGraduateYear;
	}
	public void setFGraduateYear(String graduateYear) {
		FGraduateYear = graduateYear;
	}
	public XsglTabXiaoyouManager getXsglTabXiaoyouManager() {
		return xsglTabXiaoyouManager;
	}
	public void setXsglTabXiaoyouManager(XsglTabXiaoyouManager xsglTabXiaoyouManager) {
		this.xsglTabXiaoyouManager = xsglTabXiaoyouManager;
	}
	public String getFXiaoYouId() {
		return FXiaoYouId;
	}
	public void setFXiaoYouId(String fXiaoYouId) {
		FXiaoYouId = fXiaoYouId;
	}
	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}
	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}
	public String getFXiaoYouName() {
		return FXiaoYouName;
	}
	public void setFXiaoYouName(String fXiaoYouName) {
		FXiaoYouName = fXiaoYouName;
	}
	public String getFXiaoYouSex() {
		return FXiaoYouSex;
	}
	public void setFXiaoYouSex(String fXiaoYouSex) {
		FXiaoYouSex = fXiaoYouSex;
	}
	public String getFWorkPlace() {
		return FWorkPlace;
	}
	public void setFWorkPlace(String fWorkPlace) {
		FWorkPlace = fWorkPlace;
	}
	public String getFHistory() {
		return FHistory;
	}
	public void setFHistory(String fHistory) {
		FHistory = fHistory;
	}
	public String getFPosition() {
		return FPosition;
	}
	public void setFPosition(String fPosition) {
		FPosition = fPosition;
	}
	public String getFPostcode() {
		return FPostcode;
	}
	public void setFPostcode(String fPostcode) {
		FPostcode = fPostcode;
	}
	
	/**获取所有校友信息
	 * @return SUCCESS 获取成功
	 */
	public String getXStudentList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("xStudentList", xsglTabXiaoyouManager.getXStudentList());
		return SUCCESS;
	}
	
	public String getMXStudentList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("xStudentList", xsglTabXiaoyouManager.getXStudentList());
		return SUCCESS;
	}
	
	/**按姓名获取校友信息
	 * @return SUCCESS 获取成功
	 */
	public String getXStudentByName(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = attribute;
		request.setAttribute("xStudentList", xsglTabXiaoyouManager.getXStudentByName(name));
		return SUCCESS;
	}
	
	/**按ID获取校友详细信息
	 * @return
	 */
	public String showXStudentDetails(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String xid = request.getParameter("id");
		request.setAttribute("xstudent", (XsglTabXiaoyou) xsglTabXiaoyouManager.getXStudentById(xid).get(0));
		return SUCCESS;
	}
	
	/**按地区名称获取校友信息
	 * @return SUCCESS 获取成功
	 */
	public String getXStudentByOption(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String region_str = null;
		switch(region){
		case 0: region_str="北京";break;
		case 1: region_str="上海";break;
		case 2: region_str="广东";break;
		default:region_str=" ";break;
		}
		request.setAttribute("xStudentList", xsglTabXiaoyouManager.getXStudentByOption(region_str, year));
		return SUCCESS;
	}
}

	
