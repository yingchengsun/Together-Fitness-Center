package com.xdsc.action.sjjx_system;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabLab;

import com.xdsc.service.sjjx_system.SjjxTabLabManager;
import com.xdsc.sjjx_system.util.PageListHolder;

/**��ʵ������Ϣ���в�����Action
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabLabAction extends ActionSupport{
	
	
	private SjjxTabLabManager sjjxTabLabManager;
	
	/**
	 * ʵ������Ϣ�������
	 */
	private Integer FLabId;
	private String FLabName;
	private String FLabLocation;
	private Integer FSeatNumber;
	private String FRoomNumber;
    private String XiaoQu;
	
	
	/**��ʾȫ��ʵ������Ϣ
	 * @return SUCCESS ���ҵ�����ʵ������Ϣ
	 */
	public String getLabList(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabLabManager.getLabList();
		
		if(list.isEmpty()){
			request.put("isempty",new String("1"));
		}
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("LabAll", list_all);
		request.put("labList", list_current);
		return SUCCESS;
	}
	
	/**��ҳ����
	 * @return SUCCESS
	 */
	public String previous(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("LabAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("labList", list_current);
		
		return SUCCESS;
	}
	
	/**��ҳ����
	 * @return SUCCESS
	 */
	public String next(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("LabAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("labList", list_current);
		
		return SUCCESS;
	}
	
	
	/**����µ�ʵ������Ϣ
	 * @return SUCCESS ��ӳɹ�
	 */
	public String addLabInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		SjjxTabLab lab = new SjjxTabLab();
		if(XiaoQu.equals("0")){
		    lab.setFLabLocation("��У��");
		}
		else
			lab.setFLabLocation("��У��");
		if(!sjjxTabLabManager.getLabByLabName(FLabName).isEmpty()){
			request.setAttribute("exist",new String("1"));
		}
		else{	
			lab.setFLabName(FLabName);
			lab.setFSeatNumber(FSeatNumber);
			if(!sjjxTabLabManager.getLabByRoomNumber(FRoomNumber).isEmpty()){
				request.setAttribute("exist",new String("2"));
			}
			else{
				lab.setFRoomNumber(FRoomNumber);
				request.setAttribute("exist",new String("3"));
			    sjjxTabLabManager.saveLab(lab); 
			}
		}
		
		return SUCCESS;
	}
	
	/**Ԥ����ʵ������Ϣ
	 * @return
	 */
	public String preUpdateLab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer labId = Integer.parseInt( request.getParameter("labid"));
		request.setAttribute("lab", sjjxTabLabManager.getLabByLabId(labId));
		return SUCCESS;
	}
	
	/**����ʵ������Ϣ 
	 * @return SUCCESS ���³ɹ�
	 */
	public String updateLab(){
		SjjxTabLab lab = sjjxTabLabManager.getLabByLabId(FLabId);
	    lab.setFLabLocation(FLabLocation);
	    lab.setFLabName(FLabName);
	    lab.setFSeatNumber(FSeatNumber);
	    lab.setFRoomNumber(FRoomNumber);
		sjjxTabLabManager.updateLab(lab);
		return SUCCESS;
	}
	
	
	/**ͨ��ʵ����Id���Ҷ�Ӧʵ������Ϣ
	 * @return SUCCESS ���ҳɹ�
	 */
	public String showLab2(){

		HttpServletRequest request = ServletActionContext.getRequest();
		int labId = (Integer)request.getAttribute("id");
		SjjxTabLab lab = (SjjxTabLab)sjjxTabLabManager.getLabByLabId(labId);
		
		request.setAttribute("lab", lab);
		return SUCCESS;
	}
	
	/**��Ԥ��������������ͨ��ʵ����Id����ʵ������Ϣ�ķ���
	 * @return SUCCESS ���ҳɹ�
	 */
	public String Lab3(){

		HttpServletRequest request = ServletActionContext.getRequest();
		int labId = (Integer)request.getAttribute("labId");
		SjjxTabLab lab = (SjjxTabLab)sjjxTabLabManager.getLabByLabId(labId);
		request.setAttribute("labId", labId);
		return SUCCESS;
	}
    
	/**ͨ��ʵ����Id���ҵ�ʵ������Ϣ������ɾ��
	 * @return SUCCESS ɾ���ɹ�
	 */
	public String deleteLab(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer labId = Integer.parseInt(request.getParameter("labId"));
		sjjxTabLabManager.deleteLab(sjjxTabLabManager.getLabByLabId(labId));
		return SUCCESS;
	}
	
	/**���get��set����
	 *
	 */
	public SjjxTabLabManager getSjjxTabLabManager() {
		return sjjxTabLabManager;
	}
	public void setSjjxTabLabManager(SjjxTabLabManager sjjxTabLabManager) {
		this.sjjxTabLabManager = sjjxTabLabManager;
	}

	public Integer getFSeatNumber() {
		return FSeatNumber;
	}
	public void setFSeatNumber(Integer seatNumber) {
		FSeatNumber = seatNumber;
	}

	public Integer getFLabId() {
		return FLabId;
	}
	public void setFLabId(Integer labId) {
		FLabId = labId;
	}

	public String getFLabName() {
		return FLabName;
	}
	public void setFLabName(String labName) {
		FLabName = labName;
	}
	public String getFLabLocation() {
		return FLabLocation;
	}
	public void setFLabLocation(String labLocation) {
		FLabLocation = labLocation;
	}

	
	public String getFRoomNumber() {
		return FRoomNumber;
	}
	public void setFRoomNumber(String roomNumber) {
		FRoomNumber = roomNumber;
	}
	
	public String getXiaoQu() {
		return XiaoQu;
	}

	public void setXiaoQu(String xiaoQu) {
		XiaoQu = xiaoQu;
	}

}
