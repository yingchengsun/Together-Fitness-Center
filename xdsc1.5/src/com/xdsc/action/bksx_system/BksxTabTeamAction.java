package com.xdsc.action.bksx_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabMemberManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.BksxTabTeamManager;
import com.xdsc.service.bksx_system.BksxTabTeamapplyManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶���Ŀ�Ŷӵ���ز���
 */
public class BksxTabTeamAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service��ӿ�
	 */
	private BksxTabTeamManager bksxTabTeamManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabMemberManager bksxTabMemberManager;
	private BksxTabTeamapplyManager bksxTabTeamapplyManager;

	/**
	 * Team�������
	 */
	private Integer FTeamId;
	private String FTeamName;
	private Integer FTeamMemberNum;
	private String FTeamDescription;
	private String FTeamCreator;
	private Date FTeamCreateDate;

	/**
	 * ��������
	 */
	private Date startDate;
	private Date endDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS ת��Team�б���ʾҳ��<br>
	 *         ѧ����ͼ���õ�������Ŀ�Ŷ��б�<br>
	 *         ��ʾ�Ŷ��б���ǰѧ������������Ϣ
	 */
	public String getTeamList() {
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		List<BksxTabTeam> list = bksxTabTeamManager.getTeamList();
		if (list.size() > 10) {
			int pages = 10;
			int listlength = list.size();
			if (listlength % pages == 0) {
				lastPage = listlength / pages;
			} else {
				lastPage = listlength / pages + 1;
			}
			if (p < 1)
				p = 1;
			if (p > lastPage)
				p = lastPage;
			int startIndex = (p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			list = list.subList(startIndex, endIndex);
		}
		request.put("teamlist", list);
		// ���������Ϣ
		List applyList = bksxTabTeamapplyManager.getApplyInfoByStuNum(stuNum);
		request.put("applyList", applyList);
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		request.put("member", member);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾTeam�б��ҳ��<br>
	 *         ѧ����ͼ�������Ŷ����Ʋ�ѯ���������Ķ����б�
	 */
	public String getTeamListByName() {
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		List<BksxTabTeam> list = bksxTabTeamManager
				.getTeamListByName(FTeamName);
		request.put("teamlist", list);
		// ���������Ϣ
		List applyList = bksxTabTeamapplyManager.getApplyInfoByStuNum(stuNum);
		request.put("applyList", applyList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����ڲ�ѯ����Ŷ��б�
	 * @return INPUT ת��ȫ���Ŷ��б�<br>
	 *         ѧ����ͼ�������ŶӴ���ʱ�������Ŷ��б�����������Ƿ����򷵻������Ŷ��б�
	 */
	public String getTeamListByDate() {
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return "error";
		String stuNum = student.getFStudentNumber();
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		// ���������Ϣ
		List applyList = bksxTabTeamapplyManager.getApplyInfoByStuNum(stuNum);
		request.put("applyList", applyList);

		List<BksxTabTeam> list = new ArrayList<BksxTabTeam>();
		if (startDate != null && endDate != null) {
			list = bksxTabTeamManager.getTeamListByDate(startDate, endDate);
			request.put("teamlist", list);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	/**
	 * @return SUCCESS ת��ǰѧ��Team��Ϣҳ��<br>
	 *         ѧ����ͼ���˳���ǰ�Ŷӣ�����ѧ��������Ŀ�����ɫ�Ǹù�����Ч
	 */
	public String quitFromTeam() {
		// ��session�л�ȡ��ǰ�û�ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ��ѡ����Ϣ�е���Ŀ��Ϣɾ��
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		substugui.setBksxTabProject(null);
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// ����Ա���еĶ�Ա��Ϣɾ��
		bksxTabMemberManager.deleteMember(bksxTabMemberManager
				.getMemberByStuNum(stuNum));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ�����Ŷ��б�ҳ��<br>
	 *         ѧ����ͼ���������ĳһ�Ŷ�
	 */
	public String applyTeam() {
		// ��session�л�ȡ��ǰ�û�����
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		// ��ȡҪ����Ķ������
		HttpServletRequest request = ServletActionContext.getRequest();
		int teamID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeam team = bksxTabTeamManager.getTeamById(teamID);
		String status = "�����";
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoByStuNumStatus(student.getFStudentNumber(),
						status, teamID);
		if (apply == null) {
			BksxTabTeamapply applyInfo = new BksxTabTeamapply(team, student,
					"�����");
			bksxTabTeamapplyManager.saveApplyInfo(applyInfo);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ�Ŷ��б�ҳ��<br>
	 *         ѧ����ͼ��ɾ��ĳһ��������Ϣ
	 */
	public String deleteApplyInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		bksxTabTeamapplyManager.deleteApplyInfo(bksxTabTeamapplyManager
				.getApplyInfoById(applyID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת������Ŷ���Ϣҳ��<br>
	 *         ѧ����ͼ����ɫΪ��Ŀ������׼ĳѧ��������Ŷ�
	 */
	public String agreeApply() {
		// 1.��ȡ�����߻�����Ϣ
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoById(applyID);
		// 2.����Ŀ��Ϣ�����������ߵ�ѡ����Ϣ��
		// ��session�л�ȡ�ĵ�ǰ�û�ID����ȡ����Ŀ��Ϣ
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substuguiCurrent = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		BksxTabSubstugui substuguiNew = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(apply.getTabStudents()
						.getFStudentNumber());
		// 3. ����ǰ�û���ѡ������Ŀ��Ϣ�����������û���ѡ����Ŀ��Ϣ��
		substuguiNew.setBksxTabProject(substuguiCurrent.getBksxTabProject());
		bksxTabSubstuguiManager.updateSubstugui(substuguiNew);
		// 4. ���³�Ա��Ϣ�������Ա��Ϣ����
		BksxTabMember newMember = new BksxTabMember(apply.getTabStudents()
				.getFStudentNumber(), apply.getBksxTabTeam(), null, null);
		bksxTabMemberManager.saveMember(newMember);
		// 5.��������еġ�����ˡ�״̬����Ϊ�����ͨ����
		apply.setFResult("���ͨ��");
		bksxTabTeamapplyManager.updateApplyInfo(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת������Ŷ���Ϣҳ��<br>
	 *         ѧ����ͼ����ɫΪ��Ŀ�����ܾ�ĳѧ��������Ŷ�
	 */
	public String refuseApply() {
		// 1.��ȡ�����߻�����Ϣ
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoById(applyID);
		// 2.��������еġ�����ˡ�״̬����Ϊ�����ܾ���
		apply.setFResult("���ܾ�");
		bksxTabTeamapplyManager.updateApplyInfo(apply);
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
	 */
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public BksxTabTeamapplyManager getBksxTabTeamapplyManager() {
		return bksxTabTeamapplyManager;
	}

	public void setBksxTabTeamapplyManager(
			BksxTabTeamapplyManager bksxTabTeamapplyManager) {
		this.bksxTabTeamapplyManager = bksxTabTeamapplyManager;
	}

	public BksxTabMemberManager getBksxTabMemberManager() {
		return bksxTabMemberManager;
	}

	public void setBksxTabMemberManager(
			BksxTabMemberManager bksxTabMemberManager) {
		this.bksxTabMemberManager = bksxTabMemberManager;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getFTeamId() {
		return FTeamId;
	}

	public void setFTeamId(Integer teamId) {
		FTeamId = teamId;
	}

	public String getFTeamName() {
		return FTeamName;
	}

	public void setFTeamName(String teamName) {
		FTeamName = teamName;
	}

	public Integer getFTeamMemberNum() {
		return FTeamMemberNum;
	}

	public void setFTeamMemberNum(Integer teamMemberNum) {
		FTeamMemberNum = teamMemberNum;
	}

	public String getFTeamDescription() {
		return FTeamDescription;
	}

	public void setFTeamDescription(String teamDescription) {
		FTeamDescription = teamDescription;
	}

	public String getFTeamCreator() {
		return FTeamCreator;
	}

	public void setFTeamCreator(String teamCreator) {
		FTeamCreator = teamCreator;
	}

	public Date getFTeamCreateDate() {
		return FTeamCreateDate;
	}

	public void setFTeamCreateDate(Date teamCreateDate) {
		FTeamCreateDate = teamCreateDate;
	}

	public BksxTabTeamManager getBksxTabTeamManager() {
		return bksxTabTeamManager;
	}

	public void setBksxTabTeamManager(BksxTabTeamManager bksxTabTeamManager) {
		this.bksxTabTeamManager = bksxTabTeamManager;
	}
}
