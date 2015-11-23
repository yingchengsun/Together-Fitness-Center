package com.xdsc.action.bksx_system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabProjectapply;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.bksx_system.BksxTabMemberManager;
import com.xdsc.service.bksx_system.BksxTabProjectManager;
import com.xdsc.service.bksx_system.BksxTabProjectapplyManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.BksxTabTeamManager;
import com.xdsc.service.bksx_system.BksxTabTeamapplyManager;
import com.xdsc.service.bksx_system.TabStudentsManager;
import com.xdsc.service.bksx_system.TabTeachersManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对毕设项目的相关操作
 */
public class BksxTabProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service层的借口
	 */
	private BksxTabProjectManager bksxTabProjectManager;
	private BksxTabTeamManager bksxTabTeamManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabMemberManager bksxTabMemberManager;
	private BksxTabTeamapplyManager bksxTabTeamapplyManager;
	private BksxTabProjectapplyManager bksxTabProjectapplyManager;
	private TabTeachersManager tabTeachersManager;

	/**
	 * 项目团队相关属性
	 */
	private Integer FTeamId;
	private String FTeamName;
	private Integer FTeamMemberNum;
	private String FTeamDescription;
	private String FTeamCreator;
	private Date FTeamCreateDate;

	/**
	 * 项目相关属性
	 */
	private Integer FProjId;
	private BksxTabTeam bksxTabTeam;
	private String FProjectName;
	private String FProjectCategory;
	private String FProjectDescription;

	/**
	 * 辅助参数
	 */
	private String attributeType;
	private String attribute;
	private String regDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS 转向立项成功页面<br>
	 *         学生提出立项申请，在项目立项时同时建立团队
	 */
	public String createProjectApply() {
		BksxTabTeam team = bksxTabTeamManager.getTeamByName(FTeamName);
		// 获取当前用户的Id。得到姓名，从session中得到的用户id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 保存team信息
		if (team == null) {
			String creator = tabStudentsManager.getStudentById(stuNum)
					.getFStudentName();
			team = new BksxTabTeam(FTeamName, 0, FTeamDescription, creator,
					new Date(), null, null, null, null);
			bksxTabTeamManager.saveTeam(team);
		}
		// 获取当前学生的导师信息
		String teacherName = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getFTeacherName();
		String teacherDegreen = bksxTabSubstuguiManager.getSubstuguiByStuNum(
				stuNum).getFTeacherDegreen();
		List teacherList = new ArrayList();
		if (teacherDegreen != null)
			teacherList = tabTeachersManager.getTeacherByNameDegreen(
					teacherName, teacherDegreen);
		else
			teacherList = tabTeachersManager.getTeacherByName(teacherName);
		TabTeachers teacher = null;
		if (!teacherList.isEmpty())
			teacher = (TabTeachers) teacherList.get(0);
		// 将申请信息存入申请表中
		BksxTabProjectapply apply = new BksxTabProjectapply(team, teacher,
				student, FProjectName, FProjectCategory, FProjectDescription,
				"待审核");
		bksxTabProjectapplyManager.saveApply(apply);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("myteacher", teacher);

		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向立项申请列表页面<br>
	 *         指导教师视图，显示该教师名下立项申请的列表
	 */
	public String getMyProjectApplyList() {
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		List applyList = bksxTabProjectapplyManager
				.getApplyByTeacherNum(teacher.getFTeacherNumber());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("applyList", applyList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向立项申请列表页面<br>
	 *         指导教师批准立项申请
	 */
	public String agreeProjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabProjectapply apply = bksxTabProjectapplyManager.getApplyByID(id);
		// 将团队正式批准
		BksxTabTeam team = apply.getBksxTabTeam();
		team.setFTeamMemberNum(1);
		bksxTabTeamManager.updateTeam(team);
		// 保存新建的项目信息
		BksxTabProject project = new BksxTabProject(apply.getBksxTabTeam(),
				apply.getFProjectName(), apply.getFProjectCategory(), apply
						.getFProjectDescription(), null, null, null);
		bksxTabProjectManager.saveProject(project);
		// 如果成员表中不存在当前用户信息则保存项目组成员信息
		if (bksxTabMemberManager.getMemberByStuNum(apply.getTabStudents()
				.getFStudentNumber()) == null) {
			BksxTabMember member = new BksxTabMember(apply.getTabStudents()
					.getFStudentNumber(), team, "项目经理", null);
			bksxTabMemberManager.saveMember(member);
		}
		// 将项目信息保存到选题信息中
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(apply.getTabStudents()
						.getFStudentNumber());
		substugui.setBksxTabProject(project);
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// 将申请信息由申请表中删除
		bksxTabProjectapplyManager.deleteApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向立项申请列表页面<br>
	 *         指导教师拒绝立项申请
	 */
	public String refuseProjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabProjectapply apply = bksxTabProjectapplyManager.getApplyByID(id);
		// 将暂存的Team信息删除
		bksxTabTeamManager.deleteTeam(apply.getBksxTabTeam());
		// 由于数据库设置的级联删除，此处不必手动删除apply信息了
		// 将申请信息删除
		// bksxTabProjectapplyManager.deleteApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向项目列表<br>
	 *         得到所有项目的列表信息,并分页显示
	 */
	public String getProjectList() {
		List projectList = bksxTabProjectManager.getProjectList();
		Map request = (Map) ActionContext.getContext().get("request");
		if (projectList.size() > 10) {
			int pages = 10;
			int listlength = projectList.size();
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
			projectList = projectList.subList(startIndex, endIndex);
		}
		request.put("projectList", projectList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向项目管理JSP页面<br>
	 *         学生视图，以当前学生的学号为参数获取当前项目对象
	 */
	public String getProjectByStuNum() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		// 由session中获取当前用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// 输出团队信息
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		if (substugui != null) {
			// 得到项目信息
			request.put("project", substugui.getBksxTabProject());
			// 输出成员信息
			BksxTabMember member = bksxTabMemberManager
					.getMemberByStuNum(stuNum);
			if (member != null) {
				List<BksxTabMember> memberList = bksxTabMemberManager
						.getMemberListByTeam(member.getBksxTabTeam());
				request.put("memberList", memberList);
				// 获得当前用户的角色
				request.put("teamrole", member.getFTeamRole());
				// 待处理的申请信息
				List applyMyList = bksxTabTeamapplyManager
						.getApplyInfoByTeam(member.getBksxTabTeam());
				request.put("applyMyTeamList", applyMyList);
			} else {
				request.put("memberList", null);
			}
		} else {
			request.put("memberList", null);
		}

		return SUCCESS;
	}

	/**
	 * @return SUCCESS 管理员视图，转向项目详细信息
	 * @return INPUT 指导教师视图，转向项目详细信息<br>
	 *         获取项目的详细信息
	 */
	public String showProjectDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int projectID = Integer.parseInt(request.getParameter("id"));
		BksxTabProject project = bksxTabProjectManager
				.getProjectById(projectID);
		List memberList = bksxTabMemberManager.getMemberListByTeam(project
				.getBksxTabTeam());
		request.setAttribute("project", project);
		request.setAttribute("memberList", memberList);
		// 如果为空，则为管理员，不为空则为导师
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS 转向查询后的项目视图
	 * @exception ParseException
	 *                按照年级、项目类型进行查询
	 */
	public String getProjectByAttribute() throws ParseException {
		String startStr = regDate + "-01-01";
		String endStr = regDate + "-12-31";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(startStr);
		Date endDate = dateFormat.parse(endStr);
		List list = bksxTabProjectManager.getProjectByGradeAttribute(startDate,
				endDate, attributeType, attribute);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("projectList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向立项申请页面<br>
	 *         立项预处理，首先判断该生是否已经存在项目信息，若存在，则不予立项
	 */
	public String preCreateProject() {
		Map request = (Map) ActionContext.getContext().get("request");
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		if (substugui != null) {
			if (substugui.getBksxTabProject() == null)
				request.put("noProject", "NO");
			else
				request.put("noProject", "YES");
		}
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public TabTeachersManager getTabTeachersManager() {
		return tabTeachersManager;
	}

	public void setTabTeachersManager(TabTeachersManager tabTeachersManager) {
		this.tabTeachersManager = tabTeachersManager;
	}

	public BksxTabProjectapplyManager getBksxTabProjectapplyManager() {
		return bksxTabProjectapplyManager;
	}

	public void setBksxTabProjectapplyManager(
			BksxTabProjectapplyManager bksxTabProjectapplyManager) {
		this.bksxTabProjectapplyManager = bksxTabProjectapplyManager;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

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

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
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

	public Integer getFProjId() {
		return FProjId;
	}

	public void setFProjId(Integer projId) {
		FProjId = projId;
	}

	public BksxTabTeam getBksxTabTeam() {
		return bksxTabTeam;
	}

	public void setBksxTabTeam(BksxTabTeam bksxTabTeam) {
		this.bksxTabTeam = bksxTabTeam;
	}

	public String getFProjectName() {
		return FProjectName;
	}

	public void setFProjectName(String projectName) {
		FProjectName = projectName;
	}

	public String getFProjectCategory() {
		return FProjectCategory;
	}

	public void setFProjectCategory(String projectCategory) {
		FProjectCategory = projectCategory;
	}

	public String getFProjectDescription() {
		return FProjectDescription;
	}

	public void setFProjectDescription(String projectDescription) {
		FProjectDescription = projectDescription;
	}

	public BksxTabProjectManager getBksxTabProjectManager() {
		return bksxTabProjectManager;
	}

	public void setBksxTabProjectManager(
			BksxTabProjectManager bksxTabProjectManager) {
		this.bksxTabProjectManager = bksxTabProjectManager;
	}

	public BksxTabTeamManager getBksxTabTeamManager() {
		return bksxTabTeamManager;
	}

	public void setBksxTabTeamManager(BksxTabTeamManager bksxTabTeamManager) {
		this.bksxTabTeamManager = bksxTabTeamManager;
	}
}
