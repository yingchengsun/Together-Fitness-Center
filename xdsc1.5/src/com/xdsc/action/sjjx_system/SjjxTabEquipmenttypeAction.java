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

/**���豸������Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */

public class SjjxTabEquipmenttypeAction extends ActionSupport{
	
	private SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager;
	
	/**
	 * �豸�����������
	 */
	private Integer FEquTypeId;
	private String FEquTypeName;
	
	/**����豸������Ϣ
	 * @return SUCCESS �ɹ����һ���豸���ͼ�¼
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
	
	/**���ҵ�ȫ���豸���ͼ�¼
	 * @return SUCCESS ��ʾ�����豸������Ϣ���
	 */
	public String getEquipTypeList(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabEquipmenttypeManager.getEquipTypeList();
		//���ListΪ�գ�����ʾ����
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
	
	/**��ҳ������ ��Ӧ���[ǰһҳ]�ĺ���
	 * @return SUCCESS ��ʾǰһҳ�б�
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
	
	/**��ҳ������ ��Ӧ���[��һҳ]�ĺ���
	 * @return SUCCESS ��ʾ��һҳ�б�
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
	
	/**ͨ���豸���ͱ�Ų����豸���Ͳ�ɾ���ü�¼
	 * @return SUCCESS �ɹ����б���ɾ��һ���豸���ͼ�¼
	 */
	public String deleteEquipType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer equipTypeId = Integer.parseInt(request.getParameter("equipTypeId"));
		sjjxTabEquipmenttypeManager.deleteEquipType(sjjxTabEquipmenttypeManager.getEquipTypeByEquipTypeId(equipTypeId));
		return SUCCESS;
	}
	
	
	/**
	 * �����Ա������Get��Set����
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
