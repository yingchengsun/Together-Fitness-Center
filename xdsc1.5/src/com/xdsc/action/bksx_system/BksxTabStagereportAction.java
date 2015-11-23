package com.xdsc.action.bksx_system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabMemberManager;
import com.xdsc.service.bksx_system.BksxTabProjectManager;
import com.xdsc.service.bksx_system.BksxTabStagereportManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶���Ŀ�ͽ׶��ܽᱨ�����ز���
 */
public class BksxTabStagereportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service����
	 */
	private BksxTabStagereportManager bksxTabStagereportManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabProjectManager bksxTabProjectManager;
	private BksxTabMemberManager bksxTabMemberManager;

	/**
	 * �ܽᱨ���������
	 */
	private Integer FSid;
	private BksxTabProject bksxTabProject;
	private String FReportAuthor;
	private String FReportMembers;
	private String FReportStage;
	private Date FStartTime;
	private Date FFinishTime;
	private String FStageGoal;
	private String FCompletedWork;
	private String FPercentage;
	private String FProblem;
	private String FSolution;
	private String FTeacherAdvice;
	private String FManagerAdvice;
	private String FAcquisition;

	/**
	 * ��������
	 */
	private String stage;

	/**
	 * @return SUCCESS ת��׶��ܽᱨ���б�JSPҳ��<br>
	 *         ����ĿΪ��λ�õ���Ŀ�׶α��棬��������׶Ρ���ƽ׶Ρ�ʵ�ֽ׶�
	 */
	public String getReportListByProject() {
		// ��session�л�ȡ�û�Id
		Map request = (Map) ActionContext.getContext().get("request");
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		if (substugui != null) {
			BksxTabProject project = substugui.getBksxTabProject();
			List list = bksxTabStagereportManager
					.getReportListByProject(project);
			request.put("reportlist", list);
		} else {
			request.put("reportlist", null);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ѧ����ͼ�µĽ׶α���
	 * @return teacher ת��ָ����ʦ��ͼ�µĽ׶α���
	 * @return admin ת�����Ա��ͼ�µĽ׶α���<br>
	 *         �õ��׶α������ϸ����
	 */
	public String getReportById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int rid = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("report", bksxTabStagereportManager
				.getReportById(rid));
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("STUDENT"))
			return SUCCESS;
		else if (role.equals("TEACHER"))
			return "teacher";
		else
			return "admin";
	}

	/**
	 * @return SUCCESS ת�����Ա��ͼ�µ�ĳ��Ŀ�Ľ׶��ܽᱨ��
	 * @return teacher ת��ָ����ʦ��ͼ�µ�ĳ��Ŀ�Ľ׶��ܽᱨ��<br>
	 *         �õ�ĳ�׶εĽ׶��ܽᱨ
	 */
	public String getStudentReportByStage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int projectID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("project", bksxTabProjectManager
				.getProjectById(projectID));
		List list = bksxTabStagereportManager.getReportListByStage(
				bksxTabProjectManager.getProjectById(projectID), FReportStage);
		if (list.isEmpty())
			request.setAttribute("stageReport", null);
		else
			request.setAttribute("stageReport", list);
		// �жϽ�ɫ���Ծ���actionת��
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("TEACHER"))
			return "teacher";
		else
			return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ѧ����ͼ�µĽ׶α���<br>
	 *         �õ�ĳ���׶ε��ܽᱨ��
	 */
	public String getReportByStage() {
		// ��session�л�ȡ�û�Id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabProject project = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getBksxTabProject();
		List list = bksxTabStagereportManager.getReportListByStage(project,
				stage);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("reportlist", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���½���Ŀ�׶��ܽᱨ��JSPҳ��<br>
	 *         �½�����Ԥ�����õ���ǰѧ�������Ŷӵ�������Ŀ���Ա���Թ�ѡ��
	 */
	public String preAddReport() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��session�л�ȡ��ǰѧ�����û�Id����������ȡ�û�����
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ��ȡ��ǰ�û���������Ŀ
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		if (member != null) {
			List<BksxTabMember> memberList = bksxTabMemberManager
					.getMemberListByTeam(member.getBksxTabTeam());
			request.setAttribute("memberList", memberList);
		}
		request.setAttribute("myself", student);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���½�����ɹ�ҳ��<br>
	 *         �½���Ŀ�ܽᱨ��
	 */
	public String addStageReport() {
		if (FStartTime.getTime() > FFinishTime.getTime()) {
			Date tempDate = new Date();
			tempDate = FStartTime;
			FStartTime = FFinishTime;
			FFinishTime = tempDate;
		}
		// ��session�л�ȡ�û�Id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabProject project = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getBksxTabProject();
		FReportAuthor = tabStudentsManager.getStudentById(stuNum)
				.getFStudentName();
		BksxTabStagereport report = new BksxTabStagereport(project,
				FReportAuthor, FReportMembers, FReportStage, FStartTime,
				FFinishTime, FStageGoal, FCompletedWork, FPercentage, FProblem,
				FSolution, FTeacherAdvice, FManagerAdvice, FAcquisition);
		bksxTabStagereportManager.saveStagereport(report);
		return SUCCESS;

	}

	/**
	 * @return SUCCESS ת���ܽᱨ����ϸ����ҳ��<br>
	 *         ���ӹ���Ա��ѧ�Ź�������Ľ���
	 */
	public String addManagerAdvice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int reportID = Integer.parseInt(request.getParameter("id"));
		BksxTabStagereport report = bksxTabStagereportManager
				.getReportById(reportID);
		report.setFManagerAdvice(FManagerAdvice);
		bksxTabStagereportManager.updateStagereport(report);
		request.setAttribute("report", bksxTabStagereportManager
				.getReportById(reportID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���ܽᱨ����ϸ����ҳ��<br>
	 *         ����ָ����ʦ��ѧ�Ź�������Ľ���
	 */
	public String addTeacherAdvice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int reportID = Integer.parseInt(request.getParameter("id"));
		BksxTabStagereport report = bksxTabStagereportManager
				.getReportById(reportID);
		report.setFTeacherAdvice(FTeacherAdvice);
		bksxTabStagereportManager.updateStagereport(report);
		request.setAttribute("report", bksxTabStagereportManager
				.getReportById(reportID));
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
	 */
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public Integer getFSid() {
		return FSid;
	}

	public void setFSid(Integer sid) {
		FSid = sid;
	}

	public BksxTabProject getBksxTabProject() {
		return bksxTabProject;
	}

	public void setBksxTabProject(BksxTabProject bksxTabProject) {
		this.bksxTabProject = bksxTabProject;
	}

	public String getFReportAuthor() {
		return FReportAuthor;
	}

	public void setFReportAuthor(String reportAuthor) {
		FReportAuthor = reportAuthor;
	}

	public String getFReportMembers() {
		return FReportMembers;
	}

	public void setFReportMembers(String reportMembers) {
		FReportMembers = reportMembers;
	}

	public String getFReportStage() {
		return FReportStage;
	}

	public void setFReportStage(String reportStage) {
		FReportStage = reportStage;
	}

	public Date getFStartTime() {
		return FStartTime;
	}

	public void setFStartTime(Date startTime) {
		FStartTime = startTime;
	}

	public Date getFFinishTime() {
		return FFinishTime;
	}

	public void setFFinishTime(Date finishTime) {
		FFinishTime = finishTime;
	}

	public String getFStageGoal() {
		return FStageGoal;
	}

	public void setFStageGoal(String stageGoal) {
		FStageGoal = stageGoal;
	}

	public String getFCompletedWork() {
		return FCompletedWork;
	}

	public void setFCompletedWork(String completedWork) {
		FCompletedWork = completedWork;
	}

	public String getFPercentage() {
		return FPercentage;
	}

	public void setFPercentage(String percentage) {
		FPercentage = percentage;
	}

	public String getFProblem() {
		return FProblem;
	}

	public void setFProblem(String problem) {
		FProblem = problem;
	}

	public String getFSolution() {
		return FSolution;
	}

	public void setFSolution(String solution) {
		FSolution = solution;
	}

	public String getFTeacherAdvice() {
		return FTeacherAdvice;
	}

	public void setFTeacherAdvice(String teacherAdvice) {
		FTeacherAdvice = teacherAdvice;
	}

	public String getFManagerAdvice() {
		return FManagerAdvice;
	}

	public void setFManagerAdvice(String managerAdvice) {
		FManagerAdvice = managerAdvice;
	}

	public String getFAcquisition() {
		return FAcquisition;
	}

	public void setFAcquisition(String acquisition) {
		FAcquisition = acquisition;
	}

	public BksxTabStagereportManager getBksxTabStagereportManager() {
		return bksxTabStagereportManager;
	}

	public void setBksxTabStagereportManager(
			BksxTabStagereportManager bksxTabStagereportManager) {
		this.bksxTabStagereportManager = bksxTabStagereportManager;
	}

	public BksxTabProjectManager getBksxTabProjectManager() {
		return bksxTabProjectManager;
	}

	public void setBksxTabProjectManager(
			BksxTabProjectManager bksxTabProjectManager) {
		this.bksxTabProjectManager = bksxTabProjectManager;
	}

	public BksxTabMemberManager getBksxTabMemberManager() {
		return bksxTabMemberManager;
	}

	public void setBksxTabMemberManager(
			BksxTabMemberManager bksxTabMemberManager) {
		this.bksxTabMemberManager = bksxTabMemberManager;
	}
}
