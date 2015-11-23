package com.xdsc.action.bksx_system;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.service.bksx_system.BksxTabMemberManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶���Ŀ�Ŷӳ�Ա����ز���
 */
public class BksxTabMemberAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service�ӿ�
	 */
	private BksxTabMemberManager bksxTabMemberManager;

	/**
	 * �Ŷӳ�Ա����
	 */
	private String FStudentNumber;
	private BksxTabTeam bksxTabTeam;
	private TabUndergraduate tabUndergraduate;
	private String FMemberDescription;
	private String FTeamRole;

	/**
	 * @return SUCCESS ת����³�Ա��ϢJSPҳ��<br>
	 *         ��Ա��ϢԤ�����õ������Ա����
	 */
	public String preUpdateMember() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		request.setAttribute("member", member);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����³ɹ�ҳ��<br>
	 *         ���³�Ա��Ϣ
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
	 * @return SUCCESS ת��ɾ����Ա�ɹ�ҳ��<br>
	 *         ɾ����Ա��Ϣ
	 */
	public String deleteMember() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		bksxTabMemberManager.deleteMember(member);
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
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
