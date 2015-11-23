package com.xdsc.action.bksx_system;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.service.bksx_system.BksxTabMemberManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对项目团队成员的相关操作
 */
public class BksxTabMemberAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service接口
	 */
	private BksxTabMemberManager bksxTabMemberManager;

	/**
	 * 团队成员属性
	 */
	private String FStudentNumber;
	private BksxTabTeam bksxTabTeam;
	private TabUndergraduate tabUndergraduate;
	private String FMemberDescription;
	private String FTeamRole;

	/**
	 * @return SUCCESS 转向更新成员信息JSP页面<br>
	 *         成员信息预处理，得到所需成员对象
	 */
	public String preUpdateMember() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		request.setAttribute("member", member);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向更新成功页面<br>
	 *         更新成员信息
	 */
	public String updateMember() {
		BksxTabMember member = bksxTabMemberManager
				.getMemberByStuNum(FStudentNumber);
		member.setFTeamRole(FTeamRole);
		member.setFMemberDescription(FMemberDescription);
		bksxTabMemberManager.updateMember(member);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向删除成员成功页面<br>
	 *         删除成员信息
	 */
	public String deleteMember() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		bksxTabMemberManager.deleteMember(member);
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public BksxTabTeam getBksxTabTeam() {
		return bksxTabTeam;
	}

	public void setBksxTabTeam(BksxTabTeam bksxTabTeam) {
		this.bksxTabTeam = bksxTabTeam;
	}

	public TabUndergraduate getTabUndergraduate() {
		return tabUndergraduate;
	}

	public void setTabUndergraduate(TabUndergraduate tabUndergraduate) {
		this.tabUndergraduate = tabUndergraduate;
	}

	public String getFMemberDescription() {
		return FMemberDescription;
	}

	public void setFMemberDescription(String memberDescription) {
		FMemberDescription = memberDescription;
	}

	public String getFTeamRole() {
		return FTeamRole;
	}

	public void setFTeamRole(String teamRole) {
		FTeamRole = teamRole;
	}

	public BksxTabMemberManager getBksxTabMemberManager() {
		return bksxTabMemberManager;
	}

	public void setBksxTabMemberManager(
			BksxTabMemberManager bksxTabMemberManager) {
		this.bksxTabMemberManager = bksxTabMemberManager;
	}
}
