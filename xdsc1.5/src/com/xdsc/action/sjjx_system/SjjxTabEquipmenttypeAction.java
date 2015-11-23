package com.xdsc.action.sjjx_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.SjjxTabEquipmenttype;
import com.xdsc.service.sjjx_system.SjjxTabEquipmenttypeManager;
import com.xdsc.sjjx_system.util.PageListHolder;

/**对设备类型信息进行操作
 * @author 陈雪
 * @version 1.1
 */

public class SjjxTabEquipmenttypeAction extends ActionSupport{
	
	private SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager;
	
	/**
	 * 设备类型相关属性
	 */
	private Integer FEquTypeId;
	private String FEquTypeName;
	
	/**添加设备类型信息
	 * @return SUCCESS 成功添加一条设备类型记录
	 */
	public String addEquipType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		SjjxTabEquipmenttype equipType = new SjjxTabEquipmenttype();
		if(null==sjjxTabEquipmenttypeManager.getEquipTypeByEquipTypeName1(FEquTypeName)){
			 equipType.setFEquTypeName(FEquTypeName);
			 sjjxTabEquipmenttypeManager.saveEquipType(equipType);
		}
		else{
			request.setAttribute("exist",new String("1"));
		}
		return SUCCESS;
	}
	
	/**查找到全部设备类型记录
	 * @return SUCCESS 显示所有设备类型信息类表
	 */
	public String getEquipTypeList(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabEquipmenttypeManager.getEquipTypeList();
		//如果List为空，则不显示内容
		if(list.isEmpty()){
			request.put("isempty", new String("1"));
		}
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("EquipTypeAll", list_all);
		request.put("EquipTypeList", list_current);
		return SUCCESS;
		
	}
	
	/**分页功能中 响应点击[前一页]的函数
	 * @return SUCCESS 显示前一页列表
	 */
	public String previousEY(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("EquipTypeAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("EquipTypeList", list_current);
		
		return SUCCESS;
	}
	
	/**分页功能中 响应点击[后一页]的函数
	 * @return SUCCESS 显示后一页列表
	 */
	public String nextEY(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("EquipTypeAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("EquipTypeList", list_current);
		
		return SUCCESS;
	}
	
	/**通过设备类型编号查找设备类型并删除该记录
	 * @return SUCCESS 成功从列表中删除一条设备类型记录
	 */
	public String deleteEquipType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer equipTypeId = Integer.parseInt(request.getParameter("equipTypeId"));
		sjjxTabEquipmenttypeManager.deleteEquipType(sjjxTabEquipmenttypeManager.getEquipTypeByEquipTypeId(equipTypeId));
		return SUCCESS;
	}
	
	
	/**
	 * 该类成员变量的Get与Set方法
	 */
	public SjjxTabEquipmenttypeManager getSjjxTabEquipmenttypeManager() {
		return sjjxTabEquipmenttypeManager;
	}
	public void setSjjxTabEquipmenttypeManager(
			SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager) {
		this.sjjxTabEquipmenttypeManager = sjjxTabEquipmenttypeManager;
	}
	public Integer getFEquTypeId() {
		return FEquTypeId;
	}
	public void setFEquTypeId(Integer equTypeId) {
		FEquTypeId = equTypeId;
	}
	public String getFEquTypeName() {
		return FEquTypeName;
	}
	public void setFEquTypeName(String equTypeName) {
		FEquTypeName = equTypeName;
	}
}
