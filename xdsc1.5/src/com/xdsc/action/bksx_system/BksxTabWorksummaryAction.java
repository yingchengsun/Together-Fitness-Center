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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对研究型工作总结报告的相关操作
 */
public class BksxTabWorksummaryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service层的接口
	 */
	private BksxTabWorksummaryManager bksxTabWorksummaryManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * 工作总结报告相关属性
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
	 * @return SUCCESS 转向显示工作总结报告的页面<br>
	 *         学生视图，得到当前学生的工作总结报告列表
	 */
	public String getSummaryByStuNum() {
		Map request = (Map) ActionContext.getContext().get("request");
		// 由session中获取的当前用户的ID
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
	 * @return SUCCESS 转向工作报告列表显示页面<br>
	 *         学生视图，添加一条阶段工作报告，如果重复则覆盖之前内容
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
		// 若存在重复的记录，则覆盖之
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
			// 无重复则新建
			summary = new BksxTabWorksummary(substugui, FSummaryStage,
					FStartTime, FFinishTime, FStageGoal, FCompletedWork,
					FPercentage, FProblem, FSolution, null, null, FAcquisition);
			bksxTabWorksummaryManager.saveWorkSummary(summary);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向工作总结的详细内容显示页面<br>
	 *         得到工作总结报告的详细内容
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
	 * @return SUCCESS 转向显示工作总结列表页面<br>
	 *         学生视图，按照阶段（开题阶段、中期阶段、结题阶段）查询工作总结列表
	 */
	public String getSummaryByStage() {
		// 由session中获取的当前用户ID
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
	 * @return SUCCESS 转向管理员视图下的工作总结列表
	 * @return INPUT 转向指导教师视图下的工作总结列表<br>
	 *         管理员、指导教师视图，按照不同阶段得到学生的工作总结列表
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
		// 如果为空，则为管理员，不为空则为导师
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS 转向管理员视图的工作总结详细内容页面<br>
	 *         管理员视图，增加管理员对该生该阶段工作的评价和要求
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
	 * @return SUCCESS 转向指导教师视图的工作总结详细内容页面<br>
	 *         指导教师视图，增加指导教师对该生该阶段工作的评价和要求
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
	 * 该类成员变量的Get与Set方法
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
