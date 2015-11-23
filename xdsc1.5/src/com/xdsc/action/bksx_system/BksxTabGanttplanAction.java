package com.xdsc.action.bksx_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabGanttplan;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabGanttplanManager;
import com.xdsc.service.bksx_system.BksxTabMemberManager;
import com.xdsc.service.bksx_system.BksxTabProjectManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对毕业设计项目计划（甘特图）的相关操作
 */
public class BksxTabGanttplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Spring注入的Service接口
	 */
	private BksxTabGanttplanManager bksxTabGanttplanManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabProjectManager bksxTabProjectManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabMemberManager bksxTabMemberManager;

	/**
	 * 甘特图对象
	 */
	private JFreeChart chart;

	/**
	 * 项目计划相关属性
	 */
	private Integer FTaskId;
	private BksxTabProject bksxTabProject;
	private TabStudents tabStudents;
	private String FTaskName;
	private Date FStartDate;
	private Date FFinishDate;
	private Double FCompletePercent;

	/**
	 * 辅助参数
	 */
	private String FStudentNumber;
	private String chartName = "项目日程表";
	private String leftName = "各阶段任务";
	private String bottomName = "时间周期";

	/**
	 * @return SUCCESS 转向显示项目计划任务页面<br>
	 *         学生视图，得到自己所在项目的任务列表
	 */
	public String getGanttplanList() {
		List<BksxTabGanttplan> list = new ArrayList<BksxTabGanttplan>();
		Map request = (Map) ActionContext.getContext().get("request");
		// 拿到当前学生的id，由此id获取其项目的id，进而得到甘特图的ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		if (substugui != null) {
			BksxTabProject project = substugui.getBksxTabProject();
			list = bksxTabGanttplanManager.getGanttplanListByPro(project
					.getFProjId());
			request.put("ganttlist", list);
		} else {
			request.put("ganttlist", null);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示根特图的JSP页面<br>
	 *         学生视图，得到自己所在项目的甘特图
	 */
	public String darwGanttChart() {
		List<BksxTabGanttplan> list = new ArrayList<BksxTabGanttplan>();
		// 拿到当前学生的id，由此id获取其项目的id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabProject project = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getBksxTabProject();
		list = bksxTabGanttplanManager.getGanttplanListByPro(project
				.getFProjId());
		IntervalCategoryDataset dataset = new DrawGanttChart()
				.createSampleDataset(list);
		chart = ChartFactory.createGanttChart(chartName, leftName, bottomName,
				dataset, false, false, false);
		// 设置显示字体
		new DrawGanttChart().configFont(chart);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示甘特图的JSP页面<br>
	 *         管理员、指导教师视图，得到某项目的计划与进度
	 */
	public String darwThisGanttChart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int proID = Integer.parseInt(request.getParameter("id"));
		List list = bksxTabGanttplanManager.getGanttplanListByPro(proID);
		IntervalCategoryDataset dataset = new DrawGanttChart()
				.createSampleDataset(list);
		chart = ChartFactory.createGanttChart(chartName, leftName, bottomName,
				dataset, false, false, false);
		// 设置显示字体
		new DrawGanttChart().configFont(chart);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向添加任务的JSP页面<br>
	 *         学生视图，添加任务预处理，获取团队所有成员的列表以供选择
	 */
	public String preAddTask() {
		// 从session中获取当前学生（用户Id），进而获取用户对象
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 获取当前用户从属的项目
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		List<BksxTabMember> memberList = bksxTabMemberManager
				.getMemberListByTeam(member.getBksxTabTeam());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("memberList", memberList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向添加任务成功页面<br>
	 *         添加一项任务
	 */
	public String addGanttplanTask() {
		// 如果开始日期大于结束日期，则交换两者
		if (FStartDate.getTime() > FFinishDate.getTime()) {
			Date tempDate = new Date();
			tempDate = FStartDate;
			FStartDate = FFinishDate;
			FFinishDate = tempDate;
		}
		// 从session中获取当前学生（用户Id），进而获取用户对象
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 获取当前用户从属的项目
		BksxTabProject project = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getBksxTabProject();
		BksxTabProject bksxTabProject = bksxTabProjectManager
				.getProjectById(project.getFProjId());
		TabStudents tabStudent = tabStudentsManager
				.getStudentById(FStudentNumber);
		BksxTabGanttplan bksxTabGanttplan = new BksxTabGanttplan(
				bksxTabProject, tabStudent, FTaskName, FStartDate, FFinishDate,
				0.0);
		bksxTabGanttplanManager.saveGanttplan(bksxTabGanttplan);
		return SUCCESS;

	}

	/**
	 * @return SUCCESS 转向删除成功页面<br>
	 *         删除一条任务记录
	 */
	public String deleteGanttplanTask() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		bksxTabGanttplanManager.deleteGanttplan(bksxTabGanttplanManager
				.getGanttplanById(id));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向任务更新页面<br>
	 *         更新预处理，得到需更新的任务提交至更新页面
	 */
	public String preUpdateGanttplan() {
		// 从session中获取当前学生（用户Id），进而获取用户对象
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 获取当前用户从属的项目
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		List<BksxTabMember> memberList = bksxTabMemberManager
				.getMemberListByTeam(member.getBksxTabTeam());
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("ganttTask", bksxTabGanttplanManager
				.getGanttplanById(id));
		request.setAttribute("memberList", memberList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向更新成功页面<br>
	 *         更新任务信息
	 */
	public String updateGanttplanTask() {
		// 如果开始日期大于结束日期，则交换两者
		if (FStartDate.getTime() > FFinishDate.getTime()) {
			Date tempDate = new Date();
			tempDate = FStartDate;
			FStartDate = FFinishDate;
			FFinishDate = tempDate;
		}
		BksxTabGanttplan bksxTabGanttplan = bksxTabGanttplanManager
				.getGanttplanById(FTaskId);
		bksxTabGanttplan.setFTaskName(FTaskName);
		bksxTabGanttplan.setFStartDate(FStartDate);
		bksxTabGanttplan.setFFinishDate(FFinishDate);
		bksxTabGanttplan.setFCompletePercent(FCompletePercent);
		bksxTabGanttplan.setTabStudents(tabStudentsManager
				.getStudentById(FStudentNumber));
		bksxTabGanttplanManager.updateGanttplan(bksxTabGanttplan);
		return SUCCESS;

	}

	/**
	 * @return SUCCESS 转向显示项目甘特图的页面<br>
	 *         单纯跳转，此处为项目整合中动态配置功能服务
	 */
	public String toProjectPlan() {
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

	public Integer getFTaskId() {
		return FTaskId;
	}

	public BksxTabMemberManager getBksxTabMemberManager() {
		return bksxTabMemberManager;
	}

	public void setBksxTabMemberManager(
			BksxTabMemberManager bksxTabMemberManager) {
		this.bksxTabMemberManager = bksxTabMemberManager;
	}

	public void setFTaskId(Integer taskId) {
		FTaskId = taskId;
	}

	public BksxTabProject getBksxTabProject() {
		return bksxTabProject;
	}

	public void setBksxTabProject(BksxTabProject bksxTabProject) {
		this.bksxTabProject = bksxTabProject;
	}

	public TabStudents getTabStudents() {
		return tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public String getFTaskName() {
		return FTaskName;
	}

	public void setFTaskName(String taskName) {
		FTaskName = taskName;
	}

	public Date getFStartDate() {
		return FStartDate;
	}

	public void setFStartDate(Date startDate) {
		FStartDate = startDate;
	}

	public Date getFFinishDate() {
		return FFinishDate;
	}

	public void setFFinishDate(Date finishDate) {
		FFinishDate = finishDate;
	}

	public Double getFCompletePercent() {
		return FCompletePercent;
	}

	public void setFCompletePercent(Double completePercent) {
		FCompletePercent = completePercent;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public BksxTabProjectManager getBksxTabProjectManager() {
		return bksxTabProjectManager;
	}

	public void setBksxTabProjectManager(
			BksxTabProjectManager bksxTabProjectManager) {
		this.bksxTabProjectManager = bksxTabProjectManager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public BksxTabGanttplanManager getBksxTabGanttplanManager() {
		return bksxTabGanttplanManager;
	}

	public void setBksxTabGanttplanManager(
			BksxTabGanttplanManager bksxTabGanttplanManager) {
		this.bksxTabGanttplanManager = bksxTabGanttplanManager;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getLeftName() {
		return leftName;
	}

	public void setLeftName(String leftName) {
		this.leftName = leftName;
	}

	public String getBottomName() {
		return bottomName;
	}

	public void setBottomName(String bottomName) {
		this.bottomName = bottomName;
	}

}
