package com.xdsc.action.sjjx_system;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmentdetail;
import com.xdsc.model.SjjxTabEquipmenttype;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.model.TabAdministrator;
import com.xdsc.service.sjjx_system.SjjxTabAdministratorManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentdetailManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmenttypeManager;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;
import com.xdsc.sjjx_system.util.DateConvert;

/**对设备调拨信息进行操作
 * @author 陈雪
 * @version 1.1
 */

public class SjjxTabEquipmentdetailAction extends ActionSupport{
	
	/**
	 * Spring 注入的Service层的接口
	 */
	private SjjxTabEquipmentManager sjjxTabEquipmentManager;
	private SjjxTabEquipmentdetailManager sjjxTabEquipmentdetailManager;
	private SjjxTabLabManager sjjxTabLabManager;
	private SjjxTabAdministratorManager sjjxTabAdministratorManager;
	
	
	/**
	 * 设备调拨信息相关属性
	 */
	private Integer FNumber;
	private SjjxTabEquipment sjjxTabEquipment;
    private SjjxTabLab sjjxTabLab;;
//	private TabAdministrator tabAdministrator;
	private String FEquBreakReason;
	private Integer FEquId;
	private String FEquBreakTime;
	private String FEquMoveTime;
	private String FBaoFei;
	private Integer FLabId;
	private String FExLabId;
//	private String FAdminNumber;
    private String BaoFei;

	/**通过设备编号查找到该设备的调拨记录
	 * @return SUCCESS 显示该设备的所有调拨记录
	 */
	public String showEquipDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer equipId = Integer.parseInt(request.getParameter("equipid"));
		Integer labId = Integer.parseInt(request.getParameter("labId"));
		List<SjjxTabEquipmentdetail> equipDetail = new ArrayList<SjjxTabEquipmentdetail>(0);
		equipDetail = sjjxTabEquipmentdetailManager.getEquipDetailByEquipId(equipId);
		//如果设备调拨记录为空，则不显示内容
		if(null==equipDetail){
			request.setAttribute("isempty", new String("1"));
			request.setAttribute("equipId", equipId);
			request.setAttribute("labId",labId);
		}
		else{
//			request.setAttribute("isempty", new String("0"));
			request.setAttribute("equipDetailList", equipDetail);
		}
		return SUCCESS;
	}
    
    
	/**添加设备调拨记录信息
	 * @return SUCCESS 成功改变设备的实验室编号并添加了一条调拨记录
	 */
	public String addEquipDetailInfo(){
		SjjxTabEquipmentdetail equipDetail = new SjjxTabEquipmentdetail();
		
		//*******
		//变更实验室编号的语句
		SjjxTabEquipment sjjxTabEquipment = sjjxTabEquipmentManager.getEquipByEquipId(FEquId);
		System.out.println("%%%%%%%%%"+FLabId);
		System.out.println("%%%%%%%%%%%"+FEquId);
		SjjxTabLab sjjxTabLab = sjjxTabLabManager.getLabByLabId(FLabId);
		sjjxTabEquipment.setSjjxTabLab(sjjxTabLab);
		sjjxTabEquipmentManager.updateEquip(sjjxTabEquipment);
		
		equipDetail.setSjjxTabEquipment(sjjxTabEquipment);
		equipDetail.setFExLabId(FExLabId);
		
		//*******
		
		//做时间格式的转换
        DateConvert dateConvert = new DateConvert();
		try {
			Date sql_date2 = dateConvert.dateConvert(FEquMoveTime);
			equipDetail.setFEquMoveTime(sql_date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(FEquBreakTime.length()>0){
			try {
				Date sql_date = dateConvert.dateConvert(FEquBreakTime);
				equipDetail.setFEquBreakTime(sql_date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			equipDetail.setFEquBreakTime(null);
		}
		if(BaoFei.equals("0")){
		     equipDetail.setFBaoFei("正常");
		}
		else
			equipDetail.setFBaoFei("报废");
		equipDetail.setFEquBreakReason(FEquBreakReason);
		sjjxTabEquipmentdetailManager.saveEquipDetail(equipDetail);
		return SUCCESS;
	}
	
	/**预更新处理 ，得到需要的设备对象
	 * @return SUCCESS 
	 */
	public String preUpdateEquipDetail() {
		HttpServletResponse response= ServletActionContext.getResponse();
		HttpServletRequest request= ServletActionContext.getRequest();
		Integer equipId = Integer.parseInt( request.getParameter("equip_id"));
		SjjxTabEquipment sjjxTabEquipment = sjjxTabEquipmentManager.getEquipByEquipId(equipId);
		int labId = sjjxTabEquipment.getSjjxTabLab().getFLabId();
		request.setAttribute("equipid", equipId);
		request.setAttribute("labId",labId);
		return SUCCESS;
		
	}
	

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public SjjxTabLab getSjjxTabLab() {
		return sjjxTabLab;
	}
	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}
	public Integer getFLabId() {
		return FLabId;
	}
	public void setFLabId(Integer labId) {
		FLabId = labId;
	}
	public Integer getFEquId() {
		return FEquId;
	}
	public void setFEquId(Integer equId) {
		FEquId = equId;
	}
	public SjjxTabEquipmentManager getSjjxTabEquipmentManager() {
		return sjjxTabEquipmentManager;
	}
	public void setSjjxTabEquipmentManager(
			SjjxTabEquipmentManager sjjxTabEquipmentManager) {
		this.sjjxTabEquipmentManager = sjjxTabEquipmentManager;
	}
	public SjjxTabEquipmentdetailManager getSjjxTabEquipmentdetailManager() {
		return sjjxTabEquipmentdetailManager;
	}
	public void setSjjxTabEquipmentdetailManager(
			SjjxTabEquipmentdetailManager sjjxTabEquipmentdetailManager) {
		this.sjjxTabEquipmentdetailManager = sjjxTabEquipmentdetailManager;
	}
	public SjjxTabLabManager getSjjxTabLabManager() {
		return sjjxTabLabManager;
	}
	public void setSjjxTabLabManager(SjjxTabLabManager sjjxTabLabManager) {
		this.sjjxTabLabManager = sjjxTabLabManager;
	}
	public Integer getFNumber() {
		return FNumber;
	}
	public void setFNumber(Integer number) {
		FNumber = number;
	}
	public SjjxTabEquipment getSjjxTabEquipment() {
		return sjjxTabEquipment;
	}
	public void setSjjxTabEquipment(SjjxTabEquipment sjjxTabEquipment) {
		this.sjjxTabEquipment = sjjxTabEquipment;
	}
//	public TabAdministrator getTabAdministrator() {
//		return tabAdministrator;
//	}
//	public void setTabAdministrator(TabAdministrator tabAdministrator) {
//		this.tabAdministrator = tabAdministrator;
//	}
	public String getFEquBreakReason() {
		return FEquBreakReason;
	}
	public void setFEquBreakReason(String equBreakReason) {
		FEquBreakReason = equBreakReason;
	}
	public String getFEquBreakTime() {
		return FEquBreakTime;
	}
	public void setFEquBreakTime(String equBreakTime) {
		FEquBreakTime = equBreakTime;
	}
	public String getFEquMoveTime() {
		return FEquMoveTime;
	}
	public void setFEquMoveTime(String equMoveTime) {
		FEquMoveTime = equMoveTime;
	}
	public String getFBaoFei() {
		return FBaoFei;
	}
	public void setFBaoFei(String baoFei) {
		FBaoFei = baoFei;
	}
	public SjjxTabAdministratorManager getSjjxTabAdministratorManager() {
		return sjjxTabAdministratorManager;
	}
	public void setSjjxTabAdministratorManager(
			SjjxTabAdministratorManager sjjxTabAdministratorManager) {
		this.sjjxTabAdministratorManager = sjjxTabAdministratorManager;
	}
	public String getFExLabId() {
		return FExLabId;
	}
	public void setFExLabId(String exLabId) {
		FExLabId = exLabId;
	}
//	public String getFAdminNumber() {
//		return FAdminNumber;
//	}
//	public void setFAdminNumber(String adminNumber) {
//		FAdminNumber = adminNumber;
//	}
	public String getBaoFei() {
		return BaoFei;
	}

	public void setBaoFei(String baoFei) {
		BaoFei = baoFei;
	}
}
