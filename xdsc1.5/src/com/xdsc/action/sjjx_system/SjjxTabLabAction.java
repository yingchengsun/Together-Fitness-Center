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

/**对实验室信息进行操作的Action
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabLabAction extends ActionSupport{
	
	
	private SjjxTabLabManager sjjxTabLabManager;
	
	/**
	 * 实验室信息相关属性
	 */
	private Integer FLabId;
	private String FLabName;
	private String FLabLocation;
	private Integer FSeatNumber;
	private String FRoomNumber;
    private String XiaoQu;
	
	
	/**显示全部实验室信息
	 * @return SUCCESS 查找到所有实验室信息
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
	
	/**分页处理
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
	
	/**分页处理
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
	
	
	/**添加新的实验室信息
	 * @return SUCCESS 添加成功
	 */
	public String addLabInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		SjjxTabLab lab = new SjjxTabLab();
		if(XiaoQu.equals("0")){
		    lab.setFLabLocation("北校区");
		}
		else
			lab.setFLabLocation("南校区");
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
	
	/**预更新实验室信息
	 * @return
	 */
	public String preUpdateLab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer labId = Integer.parseInt( request.getParameter("labid"));
		request.setAttribute("lab", sjjxTabLabManager.getLabByLabId(labId));
		return SUCCESS;
	}
	
	/**更新实验室信息 
	 * @return SUCCESS 更新成功
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
	
	
	/**通过实验室Id查找对应实验室信息
	 * @return SUCCESS 查找成功
	 */
	public String showLab2(){

		HttpServletRequest request = ServletActionContext.getRequest();
		int labId = (Integer)request.getAttribute("id");
		SjjxTabLab lab = (SjjxTabLab)sjjxTabLabManager.getLabByLabId(labId);
		
		request.setAttribute("lab", lab);
		return SUCCESS;
	}
	
	/**在预定机房操作中先通过实验室Id查找实验室信息的方法
	 * @return SUCCESS 查找成功
	 */
	public String Lab3(){

		HttpServletRequest request = ServletActionContext.getRequest();
		int labId = (Integer)request.getAttribute("labId");
		SjjxTabLab lab = (SjjxTabLab)sjjxTabLabManager.getLabByLabId(labId);
		request.setAttribute("labId", labId);
		return SUCCESS;
	}
    
	/**通过实验室Id查找到实验室信息并进行删除
	 * @return SUCCESS 删除成功
	 */
	public String deleteLab(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer labId = Integer.parseInt(request.getParameter("labId"));
		sjjxTabLabManager.deleteLab(sjjxTabLabManager.getLabByLabId(labId));
		return SUCCESS;
	}
	
	/**相关get、set方法
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
