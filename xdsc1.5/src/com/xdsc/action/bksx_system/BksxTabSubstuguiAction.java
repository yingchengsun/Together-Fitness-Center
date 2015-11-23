package com.xdsc.action.bksx_system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabSearchplan;
import com.xdsc.model.BksxTabSubjectapply;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.bksx_system.BksxTabSearchplanManager;
import com.xdsc.service.bksx_system.BksxTabSubjectapplyManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;
import com.xdsc.service.bksx_system.TabTeachersManager;
import com.xdsc.service.wzmh_system.TeacherManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对毕设题目、选题的相关操作
 */
public class BksxTabSubstuguiAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service层接口
	 */
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabTeachersManager tabTeachersManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSearchplanManager bksxTabSearchplanManager;
	private BksxTabSubjectapplyManager bksxTabSubjectapplyManager;

	/**
	 * 选题信息相关属性
	 */
	private Integer FSubStuGuiId;
	private BksxTabProject bksxTabProject;
	private TabStudents tabStudents;
	private String FSubjectName;
	private String FIsSoftware;
	private String FIsHardware;
	private String FIsSoftHard;
	private String FIsDocument;
	private String FIsResearch;
	private String FIsSimulation;
	private String FIsLab;
	private String FIsOthers;
	private String FLevel;
	private String FTeacherName;
	private String FTeacherDegreen;
	private String FWorkPlace;
	private String FStudentName;
	private String FSubjectDescription;
	private String FTeacherNumber;
	private String FIsChecked;
	private String FReason;

	/**
	 * 辅助参数
	 */
	private int type;
	private int category;
	private String subtype;
	private String substuguiCategory;
	private String attributeType;
	private String attribute;
	private String regDate;
	private String FStudentNumber;
	private String result;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS 转向显示选题信息页面<br>
	 *         管理员视图，得到所有的选题信息，分页显示
	 */
	public String getSubstuguiList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = bksxTabSubstuguiManager.getSubstuguiList();
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
		request.setAttribute("substuguilist", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向研究型选题信息显示页面<br>
	 *         管理员视图，得到所有研究型，即个人项目页面,分页显示
	 */
	public String getResearchSubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List researchList = bksxTabSubstuguiManager.getReacherList();
		if (researchList.size() > 10) {
			int pages = 10;
			int listlength = researchList.size();
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
			researchList = researchList.subList(startIndex, endIndex);
		}
		request.setAttribute("researchList", researchList);
		request.setAttribute("pageTag", "ALL");
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向管理员视图下的个人项目管理页面
	 * @return INPUT 转向指导教师视图下的个人项目管理页面<br>
	 *         显示个人项目基本概况
	 */
	public String showResearchView() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		BksxTabSearchplan plan = bksxTabSearchplanManager
				.getSearchPlanByStustuguiID(substuguiID);
		request.setAttribute("substugui", substugui);
		request.setAttribute("searchplan", plan);
		// 如果为空，则为管理员，不为空则为导师
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS 转向课题列表显示页面
	 * @exception ParseException
	 *                管理员视图，按照年级与课题类别查找符合条件的选题信息
	 */
	public String getSomeSubstuguiListByCategory() throws ParseException {
		String startStr = regDate + "-01-01";
		String endStr = regDate + "-12-31";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(startStr);
		Date endDate = dateFormat.parse(endStr);
		List list = bksxTabSubstuguiManager.getSubstuguiListByGradeCategory(
				startDate, endDate, substuguiCategory);
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		request.put("substuguilist", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向选题信息列表显示页面<br>
	 *         管理员视图，根据学生学号、学生姓名、课题名称、导师姓名精确查找选题信息<br>
	 *         分页显示
	 */
	public String getSomeSubstuguiListByAttribute() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String hql = "from BksxTabSubstugui bs where bs." + attributeType
				+ "='" + attribute + "'";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.put("substuguilist", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向选题信息列表显示页面<br>
	 *         管理员视图，根据学生学号、学生姓名、课题名称、导师姓名精确查找研究型（个人项目）选题信息<br>
	 */
	public String getResearchByAttribute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String hql = "from BksxTabSubstugui bs where bs." + attributeType
				+ "='" + attribute + "' and bs.bksxTabProject = null";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.setAttribute("researchList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示选题列表页面<br>
	 *         管理员视图，增加一条选题信息
	 */
	public String addSubstugui() {
		// 调用该类的私有成员方法
		if (tabTeachersManager.getTeacherByName(FTeacherName).isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("teacherError", "该教师不存在！");
			return INPUT;
		}
		if (tabStudentsManager.getStudentById(FStudentNumber) == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("studentError", "该学生不存在！");
			return INPUT;
		}
		subjectHelp(type, category);
		BksxTabSubstugui substugui = new BksxTabSubstugui(tabStudentsManager
				.getStudentById(FStudentNumber), FSubjectName, FIsSoftware,
				FIsHardware, FIsSoftHard, FIsDocument, FIsResearch,
				FIsSimulation, FIsLab, FIsOthers, FLevel, FTeacherName,
				((TabTeachers) tabTeachersManager
						.getTeacherByName(FTeacherName).get(0))
						.getFTeacherZhiCheng(), FWorkPlace, tabStudentsManager
						.getStudentById(FStudentNumber).getFStudentName(),
				FSubjectDescription, null, null, null);
		bksxTabSubstuguiManager.saveSubstugui(substugui);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示选题信息列表页面<br>
	 *         删除一条选题信息
	 */
	public String deleteSubstugui() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		bksxTabSubstuguiManager.deleteSubstugui(bksxTabSubstuguiManager
				.getSubstuguiById(id));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向更新选题信息页面<br>
	 *         更新预处理，得到需更新的选题信息对象提交
	 */
	public String preUpdateSubstugui() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("substugui", bksxTabSubstuguiManager
				.getSubstuguiById(id));
		// request
		// .setAttribute("teacherList", tabTeachersManager
		// .getTeacherList());
		// request
		// .setAttribute("studentList", tabStudentsManager
		// .getStudentList());
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向选题信息列表显示页面<br>
	 *         更新一条选题信息
	 */
	public String updateSubstugui() {
		if (tabTeachersManager.getTeacherByName(FTeacherName).isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("teacherError", "教师信息不存在！");
			return INPUT;
		}
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(FSubStuGuiId);
		substugui.setFSubjectName(FSubjectName);
		switch (type) {
		case 0:
			substugui.setFIsSoftware("Y");
			substugui.setFIsHardware(null);
			substugui.setFIsSoftHard(null);
			substugui.setFIsDocument(null);
			break;
		case 1:
			substugui.setFIsHardware("Y");
			substugui.setFIsSoftware(null);
			substugui.setFIsSoftHard(null);
			substugui.setFIsDocument(null);
			break;
		case 2:
			substugui.setFIsSoftHard("Y");
			substugui.setFIsSoftware(null);
			substugui.setFIsHardware(null);
			substugui.setFIsDocument(null);
			break;
		case 3:
			substugui.setFIsDocument("Y");
			substugui.setFIsSoftware(null);
			substugui.setFIsHardware(null);
			substugui.setFIsSoftHard(null);
			break;
		}
		switch (category) {
		case 0:
			substugui.setFIsResearch("Y");
			substugui.setFIsSimulation(null);
			substugui.setFIsLab(null);
			substugui.setFIsOthers(null);
			break;
		case 1:
			substugui.setFIsSimulation("Y");
			substugui.setFIsResearch(null);
			substugui.setFIsLab(null);
			substugui.setFIsOthers(null);
			break;
		case 2:
			substugui.setFIsLab("Y");
			substugui.setFIsResearch(null);
			substugui.setFIsSimulation(null);
			substugui.setFIsOthers(null);
			break;
		case 3:
			substugui.setFIsOthers("Y");
			substugui.setFIsResearch(null);
			substugui.setFIsSimulation(null);
			substugui.setFIsLab(null);
			break;
		}
		substugui.setFLevel(FLevel);
		TabTeachers teacher = (TabTeachers) tabTeachersManager
				.getTeacherByName(FTeacherName).get(0);
		substugui.setFTeacherName(teacher.getFTeacherName());
		substugui.setFTeacherDegreen(teacher.getFTeacherZhiCheng());
		substugui.setFTeacherNumber(teacher.getFTeacherNumber());
		substugui.setFWorkPlace(FWorkPlace);
		// 学生信息暂时不修改
		// substugui.setFStudentName(tabStudentsManager.getStudentById(
		// FStudentNumber).getFStudentName());
		// substugui.setTabStudents(tabStudentsManager
		// .getStudentById(FStudentNumber));
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向选题信息显示页面<br>
	 *         学生视图，显示学生的选题详细信息
	 */
	public String getSubstuguiByStuNum() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		request.put("substugui", substugui);
		if (substugui != null) {
			FTeacherName = substugui.getFTeacherName();
			FTeacherDegreen = substugui.getFTeacherDegreen();
			List list = tabTeachersManager.getTeacherByNameDegreen(
					FTeacherName, FTeacherDegreen);
			if (!list.isEmpty())
				request.put("teacher", (TabTeachers) list.get(0));
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示研究型项目列表页面
	 * @exception ParseException
	 *                管理员视图，根据年级、课题性质得到研究型的选题列表
	 */
	public String getResearchByGrade() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String startStr = regDate + "-01-01";
		String endStr = regDate + "-12-31";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(startStr);
		Date endDate = dateFormat.parse(endStr);
		List list = bksxTabSubstuguiManager.getResearchByGrade(startDate,
				endDate, subtype);
		request.setAttribute("researchList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向特定教师指导学生的选题信息<br>
	 *         指导教师视图，得到该教师指导学生的选题信息
	 */
	public String getMySubjects() {
		// 由session中获取的当前教师的ID
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		List subjectList = new ArrayList();
		if (teacher == null)
			return INPUT;
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			subjectList = bksxTabSubstuguiManager.getSubstuguiByTeacher(
					teacherName, teacherDegree);
		else
			subjectList = bksxTabSubstuguiManager
					.getSubstuguiByTeacher(teacherName);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("subjectList", subjectList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示选题信息的详细内容页面<br>
	 *         指导教师视图，得到指定选题的详细内容
	 */
	public String showSubjectDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("substugui", bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向指导学生列表<br>
	 *         指导教师视图，得到指导学生的列表
	 */
	public String getMyStudents() {
		// 由session中获取的当前教师的ID
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		List studentList = new ArrayList();
		if (teacher == null)
			return INPUT;
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			studentList = bksxTabSubstuguiManager.getSubstuguiByTeacher(
					teacherName, teacherDegree);
		else
			studentList = bksxTabSubstuguiManager
					.getSubstuguiByTeacher(teacherName);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("studentList", studentList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示项目型选题列表显示页面<br>
	 *         指导教师视图，得到该教师所指导的项目型的选题列表
	 */
	public String getMyProjectList() {
		// 由session中获取的教师ID
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		Set projectSet = new HashSet();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			projectSet = bksxTabSubstuguiManager.getProjectListByTeacher(
					teacherName, teacherDegree);
		else
			projectSet = bksxTabSubstuguiManager
					.getProjectListByTeacher(teacherName);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("projectList", projectSet);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示研究型选题列表的显示页面<br>
	 *         指导教师视图，得到该指导教师所指导的研究型的选题列表
	 */
	public String getMyResearchList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 由session中获取的教师ID
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		List list = new ArrayList();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			list = bksxTabSubstuguiManager.getResearchByTeacher(teacherName,
					teacherDegree);
		else
			list = bksxTabSubstuguiManager.getResearchByTeacher(teacherName);
		request.setAttribute("researchList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向新建的课题信息显示页面<br>
	 *         指导教师页面，得到该教师所出的新的毕业设计课题信息<br>
	 *         包括未被审核的、审核通过的与审核未通过的课题并且未被学生选择的
	 */
	public String getMyNewSubjects() {
		// 由session中获取当前教师的对象
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		List newList = new ArrayList();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacher.getFTeacherZhiCheng() != null)
			newList = bksxTabSubstuguiManager.getNewSubstuguiByTeacher(
					teacherName, teacherDegree);
		else
			newList = bksxTabSubstuguiManager
					.getNewSubstuguiByTeacher(teacherName);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("newSubjectList", newList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向新建课题的显示页面<br>
	 *         指导教师视图，新建毕业设计课题，该课题状态为待审核
	 */
	public String newMySubject() {
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		String teacherNum = teacher.getFTeacherNumber();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		// 调用该类的私有成员方法
		subjectHelp(type, category);
		BksxTabSubstugui subject = new BksxTabSubstugui(null, FSubjectName,
				FIsSoftware, FIsHardware, FIsSoftHard, FIsDocument,
				FIsResearch, FIsSimulation, FIsLab, FIsOthers, FLevel,
				teacherName, teacherDegree, FWorkPlace, null,
				FSubjectDescription, teacherNum, "待审核", null);
		bksxTabSubstuguiManager.saveSubstugui(subject);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向新建课题列表页面<br>
	 *         管理员视图，得到所有未审核的新建毕业设计课题列表
	 */
	public String getNewApplySubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List applyList = bksxTabSubstuguiManager.getApplySubjectList();
		if (applyList.size() > 10) {
			int pages = 10;
			int listlength = applyList.size();
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
			applyList = applyList.subList(startIndex, endIndex);
		}
		request.setAttribute("applyList", applyList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示新建课题详细信息的页面<br>
	 *         管理员视图，得到某条新建毕业设计课题的详细内容
	 */
	public String applyingSubjectDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		request.setAttribute("substugui", substugui);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示新建毕业设计课题的列表页面<br>
	 *         管理员视图，审批新建毕业设计课题，若同意则将该课题显示给学生以供选题<br>
	 *         否则将此条选题标记为“拒绝”，反馈给出题教师
	 */
	public String dealApplySubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui subject = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		if (result.equals("同意")) {
			subject.setFReason(FReason);
			subject.setFIsChecked("已通过");
			bksxTabSubstuguiManager.updateSubstugui(subject);
		} else if (result.equals("拒绝")) {
			subject.setFReason(FReason);
			subject.setFIsChecked("被拒绝");
			bksxTabSubstuguiManager.updateSubstugui(subject);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示新建课题列表的页面<br>
	 *         指导教师视图，删除被管理员标记为“拒绝”的课题信息
	 */
	public String deleteRefuseInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui subject = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		bksxTabSubstuguiManager.deleteSubstugui(subject);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向可供学生选择的毕业设计课题列表<br>
	 *         学生视图，得到可供选择（管理员审核通过且未被其他学生选定）的毕业设计课题列表
	 */
	public String getAvilableSubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List subjectList = bksxTabSubstuguiManager.getAvilableSubjectList();
		if (subjectList.size() > 10) {
			int pages = 10;
			int listlength = subjectList.size();
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
			subjectList = subjectList.subList(startIndex, endIndex);
		}
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("all", "Y");
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向可供选择的毕业设计课题列表显示页面<br>
	 *         学生视图，选择某一课题，可选择多个，重复选择同一课题将被忽略
	 */
	public String chooseSubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui subject = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		// 由session中获取当前学生对象
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		// 判断是否重复申请同一课题
		BksxTabSubjectapply app = bksxTabSubjectapplyManager
				.getSubjectApplyByStuSub(student.getFStudentNumber(), subject
						.getFSubStuGuiId());
		if (app == null) {
			BksxTabSubjectapply apply = new BksxTabSubjectapply(subject,
					student, "待审核");
			bksxTabSubjectapplyManager.saveSubjectApply(apply);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向显示申请该教师课题的申请信息列表<br>
	 *         指导教师视图，得到所有该导师名下的选题申请列表
	 */
	public String getMyApplySubjects() {
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		List applyList = new ArrayList();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		if (teacherDegree != null)
			applyList = bksxTabSubjectapplyManager.getSubjectApplyByTeacher(
					teacherName, teacherDegree);
		else
			applyList = bksxTabSubjectapplyManager
					.getSubjectApplyByTeacher(teacherName);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("applyList", applyList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向申请选题列表<br>
	 *         指导教师视图，同意该学生选择该课题
	 */
	public String agreeSubjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubjectapply apply = bksxTabSubjectapplyManager
				.getSubjectApplyListByID(applyID);
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(apply.getBksxTabSubstugui().getFSubStuGuiId());
		// 将申请学生信息填入选题表
		substugui.setTabStudents(apply.getTabStudents());
		substugui.setFStudentName(apply.getTabStudents().getFStudentName());
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// 删除申请表中的记录
		bksxTabSubjectapplyManager.deleteSubjectApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向申请选题列表<br>
	 *         指导教师视图，同意该学生选择该课题
	 */
	public String refuseSubjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubjectapply apply = bksxTabSubjectapplyManager
				.getSubjectApplyListByID(applyID);
		// 直接将申请信息删除
		bksxTabSubjectapplyManager.deleteSubjectApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向可供选择的毕业设计课题列表页面<br>
	 *         学生视图，根据课题名称、导师姓名、难度等级查询符合条件的课题信息
	 */
	public String showAvalibleSubjectByAttribute() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String hql = "from BksxTabSubstugui bs where bs." + attributeType
				+ "='" + attribute
				+ "' and bs.tabStudents = null and bs.FIsChecked='已通过'";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.put("subjectList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向可供选择的毕业设计课题列表页面<br>
	 *         学生视图，根据课题来源快速查找符合条件的课题信息
	 */
	public String showAvalibleSubjectByCategory() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String hql = "from BksxTabSubstugui bs where bs." + substuguiCategory
				+ "='Y' and bs.tabStudents = null and bs.FIsChecked='已通过'";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.put("subjectList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向课题导入页面<br>
	 *         管理员视图，导入课题预处理，得到导师、学生的列表
	 */
	public String preProjectImport() {
		// List teacherList = tabTeachersManager.getTeacherList();
		// List studentList = tabStudentsManager.getStudentList();
		// HttpServletRequest request = ServletActionContext.getRequest();
		// request.setAttribute("teacherList", teacherList);
		// request.setAttribute("studentList", studentList);
		return SUCCESS;
	}

	/**
	 * @return <br>
	 *         对课题性质和来源相关属性进行设置，提取以减少重复行代码
	 */
	private void subjectHelp(int type, int category) {
		switch (type) {
		case 0:
			FIsSoftware = "Y";
			FIsHardware = null;
			FIsSoftHard = null;
			FIsDocument = null;
			break;
		case 1:
			FIsHardware = "Y";
			FIsSoftHard = null;
			FIsDocument = null;
			FIsSoftware = null;
			break;
		case 2:
			FIsSoftHard = "Y";
			FIsHardware = null;
			FIsSoftware = null;
			FIsDocument = null;
			break;
		case 3:
			FIsDocument = "Y";
			FIsSoftHard = null;
			FIsHardware = null;
			FIsSoftware = null;
			break;
		}
		switch (category) {
		case 0:
			FIsResearch = "Y";
			FIsLab = null;
			FIsOthers = null;
			FIsSimulation = null;
			break;
		case 1:
			FIsSimulation = "Y";
			FIsResearch = null;
			FIsLab = null;
			FIsOthers = null;
			break;
		case 2:
			FIsLab = "Y";
			FIsSimulation = null;
			FIsResearch = null;
			FIsOthers = null;
			break;
		case 3:
			FIsOthers = "Y";
			FIsLab = null;
			FIsSimulation = null;
			FIsResearch = null;
			break;
		}
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public BksxTabSubjectapplyManager getBksxTabSubjectapplyManager() {
		return bksxTabSubjectapplyManager;
	}

	public void setBksxTabSubjectapplyManager(
			BksxTabSubjectapplyManager bksxTabSubjectapplyManager) {
		this.bksxTabSubjectapplyManager = bksxTabSubjectapplyManager;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFReason() {
		return FReason;
	}

	public void setFReason(String reason) {
		FReason = reason;
	}

	public String getFIsChecked() {
		return FIsChecked;
	}

	public void setFIsChecked(String isChecked) {
		FIsChecked = isChecked;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public TabTeachersManager getTabTeachersManager() {
		return tabTeachersManager;
	}

	public void setTabTeachersManager(TabTeachersManager tabTeachersManager) {
		this.tabTeachersManager = tabTeachersManager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public BksxTabSearchplanManager getBksxTabSearchplanManager() {
		return bksxTabSearchplanManager;
	}

	public void setBksxTabSearchplanManager(
			BksxTabSearchplanManager bksxTabSearchplanManager) {
		this.bksxTabSearchplanManager = bksxTabSearchplanManager;
	}

	public Integer getFSubStuGuiId() {
		return FSubStuGuiId;
	}

	public void setFSubStuGuiId(Integer subStuGuiId) {
		FSubStuGuiId = subStuGuiId;
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

	public String getFSubjectName() {
		return FSubjectName;
	}

	public void setFSubjectName(String subjectName) {
		FSubjectName = subjectName;
	}

	public String getFIsSoftware() {
		return FIsSoftware;
	}

	public void setFIsSoftware(String isSoftware) {
		FIsSoftware = isSoftware;
	}

	public String getFIsHardware() {
		return FIsHardware;
	}

	public void setFIsHardware(String isHardware) {
		FIsHardware = isHardware;
	}

	public String getFIsSoftHard() {
		return FIsSoftHard;
	}

	public void setFIsSoftHard(String isSoftHard) {
		FIsSoftHard = isSoftHard;
	}

	public String getFIsDocument() {
		return FIsDocument;
	}

	public void setFIsDocument(String isDocument) {
		FIsDocument = isDocument;
	}

	public String getFIsResearch() {
		return FIsResearch;
	}

	public void setFIsResearch(String isResearch) {
		FIsResearch = isResearch;
	}

	public String getFIsSimulation() {
		return FIsSimulation;
	}

	public void setFIsSimulation(String isSimulation) {
		FIsSimulation = isSimulation;
	}

	public String getFIsLab() {
		return FIsLab;
	}

	public void setFIsLab(String isLab) {
		FIsLab = isLab;
	}

	public String getFIsOthers() {
		return FIsOthers;
	}

	public void setFIsOthers(String isOthers) {
		FIsOthers = isOthers;
	}

	public String getFLevel() {
		return FLevel;
	}

	public void setFLevel(String level) {
		FLevel = level;
	}

	public String getFTeacherName() {
		return FTeacherName;
	}

	public void setFTeacherName(String teacherName) {
		FTeacherName = teacherName;
	}

	public String getFTeacherDegreen() {
		return FTeacherDegreen;
	}

	public void setFTeacherDegreen(String teacherDegreen) {
		FTeacherDegreen = teacherDegreen;
	}

	public String getFWorkPlace() {
		return FWorkPlace;
	}

	public void setFWorkPlace(String workPlace) {
		FWorkPlace = workPlace;
	}

	public String getFStudentName() {
		return FStudentName;
	}

	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}

	public String getFSubjectDescription() {
		return FSubjectDescription;
	}

	public void setFSubjectDescription(String subjectDescription) {
		FSubjectDescription = subjectDescription;
	}

	public String getSubstuguiCategory() {
		return substuguiCategory;
	}

	public void setSubstuguiCategory(String substuguiCategory) {
		this.substuguiCategory = substuguiCategory;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
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
}
