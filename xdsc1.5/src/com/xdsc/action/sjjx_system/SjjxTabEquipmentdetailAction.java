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

/**���豸������Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */

public class SjjxTabEquipmentdetailAction extends ActionSupport{
	
	/**
	 * Spring ע���Service��Ľӿ�
	 */
	private SjjxTabEquipmentManager sjjxTabEquipmentManager;
	private SjjxTabEquipmentdetailManager sjjxTabEquipmentdetailManager;
	private SjjxTabLabManager sjjxTabLabManager;
	private SjjxTabAdministratorManager sjjxTabAdministratorManager;
	
	
	/**
	 * �豸������Ϣ�������
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

	/**ͨ���豸��Ų��ҵ����豸�ĵ�����¼
	 * @return SUCCESS ��ʾ���豸�����е�����¼
	 */
	public String showEquipDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer equipId = Integer.parseInt(request.getParameter("equipid"));
		Integer labId = Integer.parseInt(request.getParameter("labId"));
		List<SjjxTabEquipmentdetail> equipDetail = new ArrayList<SjjxTabEquipmentdetail>(0);
		equipDetail = sjjxTabEquipmentdetailManager.getEquipDetailByEquipId(equipId);
		//����豸������¼Ϊ�գ�����ʾ����
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
    
    
	/**����豸������¼��Ϣ
	 * @return SUCCESS �ɹ��ı��豸��ʵ���ұ�Ų������һ��������¼
	 */
	public String addEquipDetailInfo(){
		SjjxTabEquipmentdetail equipDetail = new SjjxTabEquipmentdetail();
		
		//*******
		//���ʵ���ұ�ŵ����
		SjjxTabEquipment sjjxTabEquipment = sjjxTabEquipmentManager.getEquipByEquipId(FEquId);
		System.out.println("%%%%%%%%%"+FLabId);
		System.out.println("%%%%%%%%%%%"+FEquId);
		SjjxTabLab sjjxTabLab = sjjxTabLabManager.getLabByLabId(FLabId);
		sjjxTabEquipment.setSjjxTabLab(sjjxTabLab);
		sjjxTabEquipmentManager.updateEquip(sjjxTabEquipment);
		
		equipDetail.setSjjxTabEquipment(sjjxTabEquipment);
		equipDetail.setFExLabId(FExLabId);
		
		//*******
		
		//��ʱ���ʽ��ת��
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
		     equipDetail.setFBaoFei("����");
		}
		else
			equipDetail.setFBaoFei("����");
		equipDetail.setFEquBreakReason(FEquBreakReason);
		sjjxTabEquipmentdetailManager.saveEquipDetail(equipDetail);
		return SUCCESS;
	}
	
	/**Ԥ���´��� ���õ���Ҫ���豸����
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
	 * �����Ա������Get��Set����
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
