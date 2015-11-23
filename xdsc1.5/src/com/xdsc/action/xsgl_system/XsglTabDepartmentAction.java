package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.XsglTabDepartment;
import com.xdsc.model.XsglTabOrganizations;
import com.xdsc.service.xsgl_system.XsglTabDepartmentManager;
import com.xdsc.service.xsgl_system.XsglTabOrganizationsManager;
import com.xdsc.util.PageListHolder;

/**ѧ����֯������Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabDepartmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabDepartmentManager xsglTabDepartmentManager;
	private XsglTabOrganizationsManager xsglTabOrganizationsManager;
	
	
	private Integer FDid;
	private XsglTabOrganizations xsglTabOrganizations;
	private String FDname;
	private Date FBuildTime;
	private String FIntroduce;
	private Integer FTotal;
	
	private Integer FOid;
	
	public XsglTabOrganizationsManager getXsglTabOrganizationsManager() {
		return xsglTabOrganizationsManager;
	}
	public void setXsglTabOrganizationsManager(
			XsglTabOrganizationsManager xsglTabOrganizationsManager) {
		this.xsglTabOrganizationsManager = xsglTabOrganizationsManager;
	}
	public Integer getFOid() {
		return FOid;
	}
	public void setFOid(Integer oid) {
		FOid = oid;
	}
	public XsglTabDepartmentManager getXsglTabDepartmentManager() {
		return xsglTabDepartmentManager;
	}
	public void setXsglTabDepartmentManager(
			XsglTabDepartmentManager xsglTabDepartmentManager) {
		this.xsglTabDepartmentManager = xsglTabDepartmentManager;
	}
	public Integer getFDid() {
		return FDid;
	}
	public void setFDid(Integer fDid) {
		FDid = fDid;
	}
	public XsglTabOrganizations getXsglTabOrganizations() {
		return xsglTabOrganizations;
	}
	public void setXsglTabOrganizations(XsglTabOrganizations xsglTabOrganizations) {
		this.xsglTabOrganizations = xsglTabOrganizations;
	}
	
	public String getFDname() {
		return FDname;
	}
	public void setFDname(String dname) {
		FDname = dname;
	}
	public Date getFBuildTime() {
		return FBuildTime;
	}
	public void setFBuildTime(Date fBuildTime) {
		FBuildTime = fBuildTime;
	}
	public String getFIntroduce() {
		return FIntroduce;
	}
	public void setFIntroduce(String fIntroduce) {
		FIntroduce = fIntroduce;
	}
	public Integer getFTotal() {
		return FTotal;
	}
	public void setFTotal(Integer fTotal) {
		FTotal = fTotal;
	}
	
	
	/**���һ������
	 * @return SUCCESS ��ӳɹ�
	 * @return INPUT ����ֵ�д����ʧ��
	 */
	public String saveDepartment(){
		XsglTabDepartment department = new XsglTabDepartment();
		xsglTabOrganizations = xsglTabOrganizationsManager.getOrganizationById(FOid);
		if(xsglTabOrganizations==null)return INPUT;
		else{
		department.setXsglTabOrganizations(xsglTabOrganizations);
		department.setFDid(FDid);
		department.setFTotal(FTotal);
		department.setFBuildTime(FBuildTime);
		department.setFIntroduce(FIntroduce);
		xsglTabDepartmentManager.saveDepartment(department);
		return SUCCESS;
		}
	}
	
	/**ɾ��һ������
	 * @return SUCCESS ɾ���ɹ�
	 */
	public String deleteDepartment(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int departId = Integer.parseInt(request.getParameter("Did"));
		xsglTabDepartmentManager.deleteDepartment(xsglTabDepartmentManager.getDepartmentById(departId));
		return SUCCESS;
	}
	
	/**Ԥ����һ��������Ϣ
	 * @return SUCCESS ȷ�����¶���
	 */
	public String preUpdateDepartment(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int departId = Integer.parseInt(request.getParameter("Did"));
		request.setAttribute("department", xsglTabDepartmentManager.getDepartmentById(departId));
		return SUCCESS;
	}
	
	/**����һ��������Ϣ
	 * @return SUCCESS ���³ɹ�
	 * @return INPUT ����ֵ�д�����ʧ��
	 */
	public String updateDepartment(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int departId = Integer.parseInt(request.getParameter("FDid"));
		XsglTabDepartment department= xsglTabDepartmentManager.getDepartmentById(departId);
		xsglTabOrganizations = xsglTabOrganizationsManager.getOrganizationById(FOid);
		if(xsglTabOrganizations==null)return INPUT;
		else{
		department.setXsglTabOrganizations(xsglTabOrganizations);
		department.setFDid(FDid);
		department.setFTotal(FTotal);
		department.setFBuildTime(FBuildTime);
		department.setFIntroduce(FIntroduce);
		xsglTabDepartmentManager.updateDepartment(department);
		return SUCCESS;
		}
	}
	
	/**��ȡ���в�����Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getDepartmentList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		List<XsglTabDepartment> list = xsglTabDepartmentManager.getDepartmentList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("departmentAll", list_all);
		request.setAttribute("departmentList", list_current);
		return SUCCESS;
	}
	/** ǰ��ҳ
	 * @return SUCCESS ǰ��ҳ�ɹ�
	*/
	public String departmentPrevious(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("departmentAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("departmentList", list_current);
		
		return SUCCESS;
	}
	/** ��ҳ
	 * @return SUCCESS ��ҳ�ɹ�
	*/
	public String departmentNext(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("departmentAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("departmentList", list_current);
		
		return SUCCESS;
	}
	
	/**�����ƻ�ȡ������Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getDepartmentByName(){
		HttpServletRequest request=ServletActionContext.getRequest();
		XsglTabDepartment department = new XsglTabDepartment();
		List<XsglTabDepartment> list = xsglTabDepartmentManager.getDepartmentByName(department.getFDname());
		request.setAttribute("DepartmentList", list);
		return SUCCESS;
	}

}
