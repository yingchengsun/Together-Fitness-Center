package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.TabClasses;
import com.xdsc.model.XsglTabPartygather;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabPartygatherManager;
import com.xdsc.util.PageListHolder;

/**ѧ������ͳ����Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabPartygatherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabPartygatherManager xsglTabPartygatherManager;
	private XsglTabClassesManager xsglTabClassesManager;
	
	private Integer FId;
	private TabClasses tabClasses;
	private String FName;
	private Integer FMaleNum;
	private Integer FFemaleNum;
	private Integer FTotalNum;
	private String FYear;
	private String FClassNumber;
	
	private String year;
	private String classid; 
	private int status;  //���
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFYear() {
		return FYear;
	}
	public void setFYear(String year) {
		FYear = year;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	public XsglTabPartygatherManager getXsglTabPartygatherManager() {
		return xsglTabPartygatherManager;
	}
	public void setXsglTabPartygatherManager(
			XsglTabPartygatherManager xsglTabPartygatherManager) {
		this.xsglTabPartygatherManager = xsglTabPartygatherManager;
	}

	public TabClasses getTabClasses() {
		return tabClasses;
	}
	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}
	
	public String getFName() {
		return FName;
	}
	public void setFName(String name) {
		FName = name;
	}
	public Integer getFMaleNum() {
		return FMaleNum;
	}
	public void setFMaleNum(Integer maleNum) {
		FMaleNum = maleNum;
	}
	public Integer getFFemaleNum() {
		return FFemaleNum;
	}
	public void setFFemaleNum(Integer femaleNum) {
		FFemaleNum = femaleNum;
	}
	public Integer getFTotalNum() {
		return FTotalNum;
	}
	public void setFTotalNum(Integer totalNum) {
		FTotalNum = totalNum;
	}
	public XsglTabClassesManager getXsglTabClassesManager() {
		return xsglTabClassesManager;
	}
	public void setXsglTabClassesManager(XsglTabClassesManager xsglTabClassesManager) {
		this.xsglTabClassesManager = xsglTabClassesManager;
	}
	public String getFClassNumber() {
		return FClassNumber;
	}
	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
	}
	
	/** ��ȡѧ������ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getPartyList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabPartygatherManager.getPartyList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("partytAll", list_all);
		request.setAttribute("partyList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassList());
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String partyPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partytAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("partyList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String partyFeeNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("partytAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("partyList", list_current);
		
		return SUCCESS;
	}
	/** ���һ��ѧ������ͳ����Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String saveParty(){
		XsglTabPartygather party = new XsglTabPartygather();
		tabClasses=xsglTabClassesManager.getClassByclassNum(FClassNumber);
		//�༶�����ڣ����ʧ��
		if(tabClasses==null)return INPUT;
		else{
		party.setTabClasses(tabClasses);
		party.setFYear(FYear);
		party.setFName(FName);
		party.setFTotalNum(FTotalNum);
		party.setFMaleNum(FMaleNum);
		party.setFFemaleNum(FFemaleNum);
		xsglTabPartygatherManager.saveParty(party);
		return SUCCESS;
		}
	}
	/** Ԥ����һ��ѧ������ͳ����Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateParty() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("party", xsglTabPartygatherManager.getPartyByFId(FId));
		return SUCCESS;
	}
	/** ����һ��ѧ������ͳ����Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updateParty(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int partyID = Integer.parseInt(request.getParameter("partyID"));
		XsglTabPartygather party=xsglTabPartygatherManager.getPartyByFId(partyID);
		tabClasses=xsglTabClassesManager.getClassByclassNum(FClassNumber);
		//�༶�����ڣ����ʧ��
		if(tabClasses==null)return INPUT;
		else{
		party.setFName(FName);
		party.setFYear(FYear);
		party.setFMaleNum(FMaleNum);
		party.setFFemaleNum(FFemaleNum);
		party.setFTotalNum(FTotalNum);
		party.setTabClasses(tabClasses);
		xsglTabPartygatherManager.updateParty(party);
		return SUCCESS;
		}
	}
	/** ɾ��һ��ѧ������ͳ����Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteParty() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int FId = Integer.parseInt(request.getParameter("id"));
		xsglTabPartygatherManager.deleteParty(xsglTabPartygatherManager.getPartyByFId(FId));
		return SUCCESS;
	}
	/** ���༶����ݡ�������ƻ�ȡѧ������ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectPartyByYearClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String status_str = null;
		switch(status){
		case 0: status_str="��Ա";break;
		case 1: status_str="Ԥ����Ա";break;
		case 2: status_str="��Ա��չ����";break;
		case 3: status_str="�뵳��������";break;
		default:status_str=" ";break;
		}
		request.setAttribute("partyList", xsglTabPartygatherManager.getPartyByNameYearAndClass(year, classid, status_str));
		return SUCCESS;
	}


}
