package com.xdsc.action.xsgl_system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.XsglTabOrganizations;
import com.xdsc.service.xsgl_system.XsglTabOrganizationsManager;

/**学生组织信息
 * @author 杨盼盼
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
	
	/**获取所有学生组织信息
	 * @return SUCCESS 获取成功
	 */
	public String getOrganizationList(){
		 HttpServletRequest request=ServletActionContext.getRequest();
		 List list = xsglTabOrganizationsManager.getOrganizationList();
		 request.setAttribute("organizationList", list);
		 return SUCCESS;
	}
	
	/**添加一个学生组织
	 * @return SUCCESS 添加成功
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
	
	/**删除一个学生组织
	 * @return SUCCESS 删除成功
	 */
	public String deleteOrganization(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  int orgId =Integer.parseInt(request.getParameter("oid"));
		  XsglTabOrganizations organization = xsglTabOrganizationsManager.getOrganizationById(orgId);
		  xsglTabOrganizationsManager.deleteOrganization(organization);
		 return SUCCESS;
	}
	
	/**预更新一个学生组织
	 * @return SUCCESS 确定更新对象
	 */
	public String preUpdateOrganization(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  int orgId =Integer.parseInt(request.getParameter("oid"));
		  request.setAttribute("organization", xsglTabOrganizationsManager.getOrganizationById(orgId));
		 return SUCCESS;
	}
	
	/**更新一个学生组织
	 * @return SUCCESS 更新成功
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
	
	/**按名称获取学生组织信息
	 * @return SUCCESS 获取成功
	 */
	public String getOrganizationByName(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String name = request.getParameter("name");
		List list = xsglTabOrganizationsManager.getOrganizationByName(name);
		request.setAttribute("organizationList", list);
		return SUCCESS;
	}

}
