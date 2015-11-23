package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.XsglTabOrganizations;
import com.xdsc.service.xsgl_system.XsglTabOrganizationsManager;

/**ѧ����֯��Ϣ
 * @author ������
 * @version 1.1
 */
public class XsglTabOrganizationsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private XsglTabOrganizationsManager xsglTabOrganizationsManager;
	
	private Integer FOid;
	private String FOname;
	private Date FBuildTime;
	private String FIntroduce;
	private Integer FTotal;
	
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
	public void setFOid(Integer fOid) {
		FOid = fOid;
	}
	public String getFOname() {
		return FOname;
	}
	public void setFOname(String fOname) {
		FOname = fOname;
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
	
	/**��ȡ����ѧ����֯��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getOrganizationList(){
		 HttpServletRequest request=ServletActionContext.getRequest();
		 List list = xsglTabOrganizationsManager.getOrganizationList();
		 request.setAttribute("organizationList", list);
		 return SUCCESS;
	}
	
	/**���һ��ѧ����֯
	 * @return SUCCESS ��ӳɹ�
	 */
	public String saveOrganization(){
		  XsglTabOrganizations organization = new XsglTabOrganizations();
		  organization.setFOid(FOid);
		  organization.setFOname(FOname);
		  organization.setFBuildTime(FBuildTime);
		  organization.setFTotal(FTotal);
		  xsglTabOrganizationsManager.saveOrganization(organization);
		 return SUCCESS;
	}
	
	/**ɾ��һ��ѧ����֯
	 * @return SUCCESS ɾ���ɹ�
	 */
	public String deleteOrganization(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  int orgId =Integer.parseInt(request.getParameter("oid"));
		  XsglTabOrganizations organization = xsglTabOrganizationsManager.getOrganizationById(orgId);
		  xsglTabOrganizationsManager.deleteOrganization(organization);
		 return SUCCESS;
	}
	
	/**Ԥ����һ��ѧ����֯
	 * @return SUCCESS ȷ�����¶���
	 */
	public String preUpdateOrganization(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  int orgId =Integer.parseInt(request.getParameter("oid"));
		  request.setAttribute("organization", xsglTabOrganizationsManager.getOrganizationById(orgId));
		 return SUCCESS;
	}
	
	/**����һ��ѧ����֯
	 * @return SUCCESS ���³ɹ�
	 */
	public String updateOrganization(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  int orgId =Integer.parseInt(request.getParameter("oid"));
		  XsglTabOrganizations organization = xsglTabOrganizationsManager.getOrganizationById(orgId);
		  organization.setFOid(FOid);
		  organization.setFOname(FOname);
		  organization.setFBuildTime(FBuildTime);
		  organization.setFTotal(FTotal);
		  xsglTabOrganizationsManager.updateOrganization(organization);
		 return SUCCESS;
	}
	
	/**�����ƻ�ȡѧ����֯��Ϣ
	 * @return SUCCESS ��ȡ�ɹ�
	 */
	public String getOrganizationByName(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String name = request.getParameter("name");
		List list = xsglTabOrganizationsManager.getOrganizationByName(name);
		request.setAttribute("organizationList", list);
		return SUCCESS;
	}

}
