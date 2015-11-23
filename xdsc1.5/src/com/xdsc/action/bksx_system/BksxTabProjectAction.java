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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶Ա�����Ŀ����ز���
 */
public class BksxTabProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service��Ľ��
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
	 * ��Ŀ�Ŷ��������
	 */
	private Integer FTeamId;
	private String FTeamName;
	private Integer FTeamMemberNum;
	private String FTeamDescription;
	private String FTeamCreator;
	private Date FTeamCreateDate;

	/**
	 * ��Ŀ�������
	 */
	private Integer FProjId;
	private BksxTabTeam bksxTabTeam;
	private String FProjectName;
	private String FProjectCategory;
	private String FProjectDescription;

	/**
	 * ��������
	 */
	private String attributeType;
	private String attribute;
	private String regDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS ת������ɹ�ҳ��<br>
	 *         ѧ������������룬����Ŀ����ʱͬʱ�����Ŷ�
	 */
	public String createProjectApply() {
		BksxTabTeam team = bksxTabTeamManager.getTeamByName(FTeamName);
		// ��ȡ��ǰ�û���Id���õ���������session�еõ����û�id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ����team��Ϣ
		if (team == null) {
			String creator = tabStudentsManager.getStudentById(stuNum)
					.getFStudentName();
			team = new BksxTabTeam(FTeamName, 0, FTeamDescription, creator,
					new Date(), null, null, null, null);
			bksxTabTeamManager.saveTeam(team);
		}
		// ��ȡ��ǰѧ���ĵ�ʦ��Ϣ
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
		// ��������Ϣ�����������
		BksxTabProjectapply apply = new BksxTabProjectapply(team, teacher,
				student, FProjectName, FProjectCategory, FProjectDescription,
				"�����");
		bksxTabProjectapplyManager.saveApply(apply);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("myteacher", teacher);

		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����������б�ҳ��<br>
	 *         ָ����ʦ��ͼ����ʾ�ý�ʦ��������������б�
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
	 * @return SUCCESS ת�����������б�ҳ��<br>
	 *         ָ����ʦ��׼��������
	 */
	public String agreeProjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabProjectapply apply = bksxTabProjectapplyManager.getApplyByID(id);
		// ���Ŷ���ʽ��׼
		BksxTabTeam team = apply.getBksxTabTeam();
		team.setFTeamMemberNum(1);
		bksxTabTeamManager.updateTeam(team);
		// �����½�����Ŀ��Ϣ
		BksxTabProject project = new BksxTabProject(apply.getBksxTabTeam(),
				apply.getFProjectName(), apply.getFProjectCategory(), apply
						.getFProjectDescription(), null, null, null);
		bksxTabProjectManager.saveProject(project);
		// �����Ա���в����ڵ�ǰ�û���Ϣ�򱣴���Ŀ���Ա��Ϣ
		if (bksxTabMemberManager.getMemberByStuNum(apply.getTabStudents()
				.getFStudentNumber()) == null) {
			BksxTabMember member = new BksxTabMember(apply.getTabStudents()
					.getFStudentNumber(), team, "��Ŀ����", null);
			bksxTabMemberManager.saveMember(member);
		}
		// ����Ŀ��Ϣ���浽ѡ����Ϣ��
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(apply.getTabStudents()
						.getFStudentNumber());
		substugui.setBksxTabProject(project);
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// ��������Ϣ���������ɾ��
		bksxTabProjectapplyManager.deleteApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����������б�ҳ��<br>
	 *         ָ����ʦ�ܾ���������
	 */
	public String refuseProjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabProjectapply apply = bksxTabProjectapplyManager.getApplyByID(id);
		// ���ݴ��Team��Ϣɾ��
		bksxTabTeamManager.deleteTeam(apply.getBksxTabTeam());
		// �������ݿ����õļ���ɾ�����˴������ֶ�ɾ��apply��Ϣ��
		// ��������Ϣɾ��
		// bksxTabProjectapplyManager.deleteApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����Ŀ�б�<br>
	 *         �õ�������Ŀ���б���Ϣ,����ҳ��ʾ
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
	 * @return SUCCESS ת����Ŀ����JSPҳ��<br>
	 *         ѧ����ͼ���Ե�ǰѧ����ѧ��Ϊ������ȡ��ǰ��Ŀ����
	 */
	public String getProjectByStuNum() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		// ��session�л�ȡ��ǰ�û�ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		// ����Ŷ���Ϣ
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		if (substugui != null) {
			// �õ���Ŀ��Ϣ
			request.put("project", substugui.getBksxTabProject());
			// �����Ա��Ϣ
			BksxTabMember member = bksxTabMemberManager
					.getMemberByStuNum(stuNum);
			if (member != null) {
				List<BksxTabMember> memberList = bksxTabMemberManager
						.getMemberListByTeam(member.getBksxTabTeam());
				request.put("memberList", memberList);
				// ��õ�ǰ�û��Ľ�ɫ
				request.put("teamrole", member.getFTeamRole());
				// �������������Ϣ
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
	 * @return SUCCESS ����Ա��ͼ��ת����Ŀ��ϸ��Ϣ
	 * @return INPUT ָ����ʦ��ͼ��ת����Ŀ��ϸ��Ϣ<br>
	 *         ��ȡ��Ŀ����ϸ��Ϣ
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
		// ���Ϊ�գ���Ϊ����Ա����Ϊ����Ϊ��ʦ
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS ת���ѯ�����Ŀ��ͼ
	 * @exception ParseException
	 *                �����꼶����Ŀ���ͽ��в�ѯ
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
	 * @return SUCCESS ת����������ҳ��<br>
	 *         ����Ԥ���������жϸ����Ƿ��Ѿ�������Ŀ��Ϣ�������ڣ���������
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
	 * �����Ա������Get��Set����
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
