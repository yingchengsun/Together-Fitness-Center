package com.xdsc.action.bksx_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.BksxTabWorksummary;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.BksxTabWorksummaryManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶��о��͹����ܽᱨ�����ز���
 */
public class BksxTabWorksummaryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service��Ľӿ�
	 */
	private BksxTabWorksummaryManager bksxTabWorksummaryManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * �����ܽᱨ���������
	 */
	private Integer FWid;
	private BksxTabSubstugui bksxTabSubstugui;
	private String FSummaryStage;
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
	 * @return SUCCESS ת����ʾ�����ܽᱨ���ҳ��<br>
	 *         ѧ����ͼ���õ���ǰѧ���Ĺ����ܽᱨ���б�
	 */
	public String getSummaryByStuNum() {
		Map request = (Map) ActionContext.getContext().get("request");
		// ��session�л�ȡ�ĵ�ǰ�û���ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		List summaryList = new ArrayList();
		if (student != null) {
			String stuNum = student.getFStudentNumber();
			summaryList = bksxTabWorksummaryManager.getSummaryByStuNum(stuNum);
		}
		request.put("summaryList", summaryList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���������б���ʾҳ��<br>
	 *         ѧ����ͼ�����һ���׶ι������棬����ظ��򸲸�֮ǰ����
	 */
	public String addWorkSummary() {
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		List list = bksxTabWorksummaryManager.getSummaryByStage(stuNum,
				FSummaryStage);
		BksxTabWorksummary summary = null;
		// �������ظ��ļ�¼���򸲸�֮
		if (!list.isEmpty()) {
			summary = (BksxTabWorksummary) list.get(0);
			summary.setFStartTime(FStartTime);
			summary.setFFinishTime(FFinishTime);
			summary.setFStageGoal(FStageGoal);
			summary.setFCompletedWork(FCompletedWork);
			summary.setFPercentage(FPercentage);
			summary.setFProblem(FProblem);
			summary.setFSolution(FSolution);
			summary.setFAcquisition(FAcquisition);
			bksxTabWorksummaryManager.updateWorkSummary(summary);
		} else {
			// ���ظ����½�
			summary = new BksxTabWorksummary(substugui, FSummaryStage,
					FStartTime, FFinishTime, FStageGoal, FCompletedWork,
					FPercentage, FProblem, FSolution, null, null, FAcquisition);
			bksxTabWorksummaryManager.saveWorkSummary(summary);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����ܽ����ϸ������ʾҳ��<br>
	 *         �õ������ܽᱨ�����ϸ����
	 */
	public String getSummaryByID() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabWorksummary summary = bksxTabWorksummaryManager
				.getSummaryByID(id);
		request.setAttribute("summary", summary);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ�����ܽ��б�ҳ��<br>
	 *         ѧ����ͼ�����ս׶Σ�����׶Ρ����ڽ׶Ρ�����׶Σ���ѯ�����ܽ��б�
	 */
	public String getSummaryByStage() {
		// ��session�л�ȡ�ĵ�ǰ�û�ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("summaryList", bksxTabWorksummaryManager.getSummaryByStage(
				stuNum, FSummaryStage));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����Ա��ͼ�µĹ����ܽ��б�
	 * @return INPUT ת��ָ����ʦ��ͼ�µĹ����ܽ��б�<br>
	 *         ����Ա��ָ����ʦ��ͼ�����ղ�ͬ�׶εõ�ѧ���Ĺ����ܽ��б�
	 */
	public String showSummaryByStage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		String stuNum = bksxTabSubstuguiManager.getSubstuguiById(substuguiID)
				.getTabStudents().getFStudentNumber();
		List list = bksxTabWorksummaryManager.getSummaryByStage(stuNum,
				FSummaryStage);
		if (list.isEmpty())
			request.setAttribute("summary", null);
		else
			request.setAttribute("summary", (BksxTabWorksummary) list.get(0));
		// ���Ϊ�գ���Ϊ����Ա����Ϊ����Ϊ��ʦ
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS ת�����Ա��ͼ�Ĺ����ܽ���ϸ����ҳ��<br>
	 *         ����Ա��ͼ�����ӹ���Ա�Ը����ý׶ι��������ۺ�Ҫ��
	 */
	public String addManagerAdvice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int summaryID = Integer.parseInt(request.getParameter("id"));
		BksxTabWorksummary summary = bksxTabWorksummaryManager
				.getSummaryByID(summaryID);
		summary.setFManagerAdvice(FManagerAdvice);
		bksxTabWorksummaryManager.updateWorkSummary(summary);
		request.setAttribute("summary", bksxTabWorksummaryManager
				.getSummaryByID(summaryID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ָ����ʦ��ͼ�Ĺ����ܽ���ϸ����ҳ��<br>
	 *         ָ����ʦ��ͼ������ָ����ʦ�Ը����ý׶ι��������ۺ�Ҫ��
	 */
	public String addTeacherAdvice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int summaryID = Integer.parseInt(request.getParameter("id"));
		BksxTabWorksummary summary = bksxTabWorksummaryManager
				.getSummaryByID(summaryID);
		summary.setFTeacherAdvice(FTeacherAdvice);
		bksxTabWorksummaryManager.updateWorkSummary(summary);
		request.setAttribute("summary", bksxTabWorksummaryManager
				.getSummaryByID(summaryID));
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
	 */
	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public Integer getFWid() {
		return FWid;
	}

	public void setFWid(Integer wid) {
		FWid = wid;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public String getFSummaryStage() {
		return FSummaryStage;
	}

	public void setFSummaryStage(String summaryStage) {
		FSummaryStage = summaryStage;
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

	public BksxTabWorksummaryManager getBksxTabWorksummaryManager() {
		return bksxTabWorksummaryManager;
	}

	public void setBksxTabWorksummaryManager(
			BksxTabWorksummaryManager bksxTabWorksummaryManager) {
		this.bksxTabWorksummaryManager = bksxTabWorksummaryManager;
	}

}
