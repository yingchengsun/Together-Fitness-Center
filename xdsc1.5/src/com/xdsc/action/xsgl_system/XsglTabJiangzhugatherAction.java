package com.xdsc.action.xsgl_system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabClasses;
import com.xdsc.model.XsglTabJiangzhugather;
import com.xdsc.service.xsgl_system.XsglTabClassesManager;
import com.xdsc.service.xsgl_system.XsglTabJiangzhugatherManager;
import com.xdsc.util.PageListHolder;

/**��������ѧ��ͳ����Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabJiangzhugatherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabJiangzhugatherManager xsglTabJiangzhugatherManager;
	private XsglTabClassesManager xsglTabClassesManager;
	
	private Integer FId;
	private TabClasses tabClasses;
	private String FName;
	private String FYear;
	private Integer FAmount;
	private Integer FTotalNum;
	private String FClassNumber;
	
	private Integer name;
	private String classid;
	private String year;
	
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getFId() {
		return FId;
	}
	public void setFId(Integer id) {
		FId = id;
	}
	public XsglTabJiangzhugatherManager getXsglTabJiangzhugatherManager() {
		return xsglTabJiangzhugatherManager;
	}
	public void setXsglTabJiangzhugatherManager(
			XsglTabJiangzhugatherManager xsglTabJiangzhugatherManager) {
		this.xsglTabJiangzhugatherManager = xsglTabJiangzhugatherManager;
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
	public String getFYear() {
		return FYear;
	}
	public void setFYear(String year) {
		FYear = year;
	}
	public Integer getFAmount() {
		return FAmount;
	}
	public void setFAmount(Integer amount) {
		FAmount = amount;
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
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	
	/** ��ȡ������ѧ����ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getLoanList() {
		List<XsglTabJiangzhugather> list = xsglTabJiangzhugatherManager.getLoanList();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("JiangzhuList", list);

		// HttpServletRequest request=ServletActionContext.getRequest();
		// request.setAttribute("studentsList", list);
		return SUCCESS;
	}
	/** ��ȡ������ѧ��ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getStipendList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("JiangzhuList", xsglTabJiangzhugatherManager.getStipendList());
		return SUCCESS;
	}
	/** ��ȡ���н�ѧ��ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getScholarshipList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("JiangzhuList", xsglTabJiangzhugatherManager.getScholarshipList());
		return SUCCESS;
	}
	/** ���һ����������ѧ��ͳ����Ϣ
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	*/
	public String saveFund(){
		XsglTabJiangzhugather fund=new XsglTabJiangzhugather();
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		if(tabClasses==null)return INPUT;
		else{
		fund.setTabClasses(tabClasses);
		fund.setFName(FName);
		fund.setFTotalNum(FTotalNum);
		fund.setFAmount(FAmount);
		fund.setFYear(FYear);
		xsglTabJiangzhugatherManager.saveJiangzhu(fund);
		return SUCCESS;
		}
	}
	/** ɾ��һ����������ѧ��ͳ����Ϣ
	 * @return SUCCESS ɾ���ɹ�
	*/
	public String deleteFund(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		xsglTabJiangzhugatherManager.deleteJiangzhu(xsglTabJiangzhugatherManager.getFundById(id));
		return SUCCESS;
	}
	/** Ԥ����һ����������ѧ��ͳ����Ϣ
	 * @return SUCCESS ȷ�����¶���
	*/
	public String preUpdateFund(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("fund", xsglTabJiangzhugatherManager.getFundById(id));
		return SUCCESS;
	}
	/** ����һ����������ѧ��ͳ����Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	*/
	public String updateFund(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int fundID = Integer.parseInt(request.getParameter("fundID"));
		XsglTabJiangzhugather fund = xsglTabJiangzhugatherManager.getFundById(fundID);
		tabClasses = xsglTabClassesManager.getClassByclassNum(FClassNumber);
		if(tabClasses==null)return INPUT;
		else{
		fund.setTabClasses(tabClasses);
		fund.setFName(FName);
		fund.setFTotalNum(FTotalNum);
		fund.setFAmount(FAmount);
		fund.setFYear(FYear);
		xsglTabJiangzhugatherManager.updateJiangzhu(fund);
		return SUCCESS;
		}
	}
	/** ��ȡ������������ѧ��ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String getFundList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List list = xsglTabJiangzhugatherManager.getFundList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("JiangzhuAll", list_all);
		request.setAttribute("JiangzhuList", list_current);
		request.setAttribute("classList", xsglTabClassesManager.getClassList());
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String fundPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("JiangzhuAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("JiangzhuList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String fundNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("JiangzhuAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("JiangzhuList", list_current);
		
		return SUCCESS;
	}
	/** ����ݡ��༶��������ƻ�ȡ��������ѧ��ͳ����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	*/
	public String selectFundByNameClassYear(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		String name_str = null;
		switch(name){
		case 0: name_str="��ѧ����";break;
		case 1: name_str="��ѧ��";break;
		case 2: name_str="��ѧ��";break;
		default: name_str=" ";break;
		}
		List list = xsglTabJiangzhugatherManager.getFundByNameClassAndYear(classid, year, name_str);
	
		request.setAttribute("JiangzhuList", list);
		
		return SUCCESS;
	}
}

