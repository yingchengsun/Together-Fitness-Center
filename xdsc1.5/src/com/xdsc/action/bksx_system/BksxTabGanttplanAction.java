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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶Ա�ҵ�����Ŀ�ƻ�������ͼ������ز���
 */
public class BksxTabGanttplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Springע���Service�ӿ�
	 */
	private BksxTabGanttplanManager bksxTabGanttplanManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabProjectManager bksxTabProjectManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabMemberManager bksxTabMemberManager;

	/**
	 * ����ͼ����
	 */
	private JFreeChart chart;

	/**
	 * ��Ŀ�ƻ��������
	 */
	private Integer FTaskId;
	private BksxTabProject bksxTabProject;
	private TabStudents tabStudents;
	private String FTaskName;
	private Date FStartDate;
	private Date FFinishDate;
	private Double FCompletePercent;

	/**
	 * ��������
	 */
	private String FStudentNumber;
	private String chartName = "��Ŀ�ճ̱�";
	private String leftName = "���׶�����";
	private String bottomName = "ʱ������";

	/**
	 * @return SUCCESS ת����ʾ��Ŀ�ƻ�����ҳ��<br>
	 *         ѧ����ͼ���õ��Լ�������Ŀ�������б�
	 */
	public String getGanttplanList() {
		List<BksxTabGanttplan> list = new ArrayList<BksxTabGanttplan>();
		Map request = (Map) ActionContext.getContext().get("request");
		// �õ���ǰѧ����id���ɴ�id��ȡ����Ŀ��id�������õ�����ͼ��ID
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
	 * @return SUCCESS ת����ʾ����ͼ��JSPҳ��<br>
	 *         ѧ����ͼ���õ��Լ�������Ŀ�ĸ���ͼ
	 */
	public String darwGanttChart() {
		List<BksxTabGanttplan> list = new ArrayList<BksxTabGanttplan>();
		// �õ���ǰѧ����id���ɴ�id��ȡ����Ŀ��id
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
		// ������ʾ����
		new DrawGanttChart().configFont(chart);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ����ͼ��JSPҳ��<br>
	 *         ����Ա��ָ����ʦ��ͼ���õ�ĳ��Ŀ�ļƻ������
	 */
	public String darwThisGanttChart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int proID = Integer.parseInt(request.getParameter("id"));
		List list = bksxTabGanttplanManager.getGanttplanListByPro(proID);
		IntervalCategoryDataset dataset = new DrawGanttChart()
				.createSampleDataset(list);
		chart = ChartFactory.createGanttChart(chartName, leftName, bottomName,
				dataset, false, false, false);
		// ������ʾ����
		new DrawGanttChart().configFont(chart);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����������JSPҳ��<br>
	 *         ѧ����ͼ���������Ԥ������ȡ�Ŷ����г�Ա���б��Թ�ѡ��
	 */
	public String preAddTask() {
		// ��session�л�ȡ��ǰѧ�����û�Id����������ȡ�û�����
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ��ȡ��ǰ�û���������Ŀ
		BksxTabMember member = bksxTabMemberManager.getMemberByStuNum(stuNum);
		List<BksxTabMember> memberList = bksxTabMemberManager
				.getMemberListByTeam(member.getBksxTabTeam());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("memberList", memberList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���������ɹ�ҳ��<br>
	 *         ���һ������
	 */
	public String addGanttplanTask() {
		// �����ʼ���ڴ��ڽ������ڣ��򽻻�����
		if (FStartDate.getTime() > FFinishDate.getTime()) {
			Date tempDate = new Date();
			tempDate = FStartDate;
			FStartDate = FFinishDate;
			FFinishDate = tempDate;
		}
		// ��session�л�ȡ��ǰѧ�����û�Id����������ȡ�û�����
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ��ȡ��ǰ�û���������Ŀ
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
	 * @return SUCCESS ת��ɾ���ɹ�ҳ��<br>
	 *         ɾ��һ�������¼
	 */
	public String deleteGanttplanTask() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		bksxTabGanttplanManager.deleteGanttplan(bksxTabGanttplanManager
				.getGanttplanById(id));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���������ҳ��<br>
	 *         ����Ԥ�����õ�����µ������ύ������ҳ��
	 */
	public String preUpdateGanttplan() {
		// ��session�л�ȡ��ǰѧ�����û�Id����������ȡ�û�����
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ��ȡ��ǰ�û���������Ŀ
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
	 * @return SUCCESS ת����³ɹ�ҳ��<br>
	 *         ����������Ϣ
	 */
	public String updateGanttplanTask() {
		// �����ʼ���ڴ��ڽ������ڣ��򽻻�����
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
	 * @return SUCCESS ת����ʾ��Ŀ����ͼ��ҳ��<br>
	 *         ������ת���˴�Ϊ��Ŀ�����ж�̬���ù��ܷ���
	 */
	public String toProjectPlan() {
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
