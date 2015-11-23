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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对项目团队的相关操作
 */
public class BksxTabTeamAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service层接口
	 */
	private BksxTabTeamManager bksxTabTeamManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabMemberManager bksxTabMemberManager;
	private BksxTabTeamapplyManager bksxTabTeamapplyManager;

	/**
	 * Team相关属性
	 */
	private Integer FTeamId;
	private String FTeamName;
	private Integer FTeamMemberNum;
	private String FTeamDescription;
	private String FTeamCreator;
	private Date FTeamCreateDate;

	/**
	 * 辅助参数
	 */
	private Date startDate;
	private Date endDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS 转向Team列表显示页面<br>
	 *         学生视图，得到所有项目团队列表<br>
	 *         显示团队列表、当前学生申请队伍的信息
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
		// 输出申请信息
		List applyList = bksxTabTeamapplyManager.getApplyInfoByStuNum(stuNum);
		request.put("applyList", applyList);
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		request.put("member", member);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示Team列表的页面<br>
	 *         学生视图，根据团队名称查询符合条件的队伍列表
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
		// 输出申请信息
		List applyList = bksxTabTeamapplyManager.getApplyInfoByStuNum(stuNum);
		request.put("applyList", applyList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向按日期查询后的团队列表
	 * @return INPUT 转向全部团队列表<br>
	 *         学生视图，按照团队创建时间搜索团队列表，若日期输入非法，则返回所有团队列表
	 */
	public String getTeamListByDate() {
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return "error";
		String stuNum = student.getFStudentNumber();
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		// 输出申请信息
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
	 * @return SUCCESS 转向当前学生Team信息页面<br>
	 *         学生视图，退出当前团队，当此学生不是项目经理角色是该功能有效
	 */
	public String quitFromTeam() {
		// 由session中获取当前用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 将选题信息中的项目信息删除
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		substugui.setBksxTabProject(null);
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// 将队员表中的队员信息删除
		bksxTabMemberManager.deleteMember(bksxTabMemberManager
				.getMemberByStuNum(stuNum));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示所有团队列表页面<br>
	 *         学生试图，申请加入某一团队
	 */
	public String applyTeam() {
		// 由session中获取当前用户对象
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		// 获取要申请的队伍对象
		HttpServletRequest request = ServletActionContext.getRequest();
		int teamID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeam team = bksxTabTeamManager.getTeamById(teamID);
		String status = "待审核";
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoByStuNumStatus(student.getFStudentNumber(),
						status, teamID);
		if (apply == null) {
			BksxTabTeamapply applyInfo = new BksxTabTeamapply(team, student,
					"待审核");
			bksxTabTeamapplyManager.saveApplyInfo(applyInfo);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示团队列表页面<br>
	 *         学生视图，删除某一条申请信息
	 */
	public String deleteApplyInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		bksxTabTeamapplyManager.deleteApplyInfo(bksxTabTeamapplyManager
				.getApplyInfoById(applyID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向该生团队信息页面<br>
	 *         学生视图，角色为项目经理，批准某学生加入该团队
	 */
	public String agreeApply() {
		// 1.获取申请者基本信息
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoById(applyID);
		// 2.将项目信息保存入申请者的选题信息中
		// 由session中获取的当前用户ID，获取其项目信息
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
		// 3. 将当前用户的选题中项目信息保存入申请用户的选题项目信息中
		substuguiNew.setBksxTabProject(substuguiCurrent.getBksxTabProject());
		bksxTabSubstuguiManager.updateSubstugui(substuguiNew);
		// 4. 将新成员信息保存入成员信息表中
		BksxTabMember newMember = new BksxTabMember(apply.getTabStudents()
				.getFStudentNumber(), apply.getBksxTabTeam(), null, null);
		bksxTabMemberManager.saveMember(newMember);
		// 5.将申请表中的“待审核”状态更改为”审核通过“
		apply.setFResult("审核通过");
		bksxTabTeamapplyManager.updateApplyInfo(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向该生团队信息页面<br>
	 *         学生视图，角色为项目经理，拒绝某学生加入该团队
	 */
	public String refuseApply() {
		// 1.获取申请者基本信息
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabTeamapply apply = bksxTabTeamapplyManager
				.getApplyInfoById(applyID);
		// 2.将申请表中的”待审核“状态更改为”被拒绝“
		apply.setFResult("被拒绝");
		bksxTabTeamapplyManager.updateApplyInfo(apply);
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
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
