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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶Ա�����Ŀ��ѡ�����ز���
 */
public class BksxTabSubstuguiAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service��ӿ�
	 */
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabTeachersManager tabTeachersManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSearchplanManager bksxTabSearchplanManager;
	private BksxTabSubjectapplyManager bksxTabSubjectapplyManager;

	/**
	 * ѡ����Ϣ�������
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
	 * ��������
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
	 * @return SUCCESS ת����ʾѡ����Ϣҳ��<br>
	 *         ����Ա��ͼ���õ����е�ѡ����Ϣ����ҳ��ʾ
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
	 * @return SUCCESS ת���о���ѡ����Ϣ��ʾҳ��<br>
	 *         ����Ա��ͼ���õ������о��ͣ���������Ŀҳ��,��ҳ��ʾ
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
	 * @return SUCCESS ת�����Ա��ͼ�µĸ�����Ŀ����ҳ��
	 * @return INPUT ת��ָ����ʦ��ͼ�µĸ�����Ŀ����ҳ��<br>
	 *         ��ʾ������Ŀ�����ſ�
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
		// ���Ϊ�գ���Ϊ����Ա����Ϊ����Ϊ��ʦ
		String role = (String) ActionContext.getContext().getSession().get(
				"role");
		if (role.equals("ADMIN"))
			return SUCCESS;
		else
			return INPUT;
	}

	/**
	 * @return SUCCESS ת������б���ʾҳ��
	 * @exception ParseException
	 *                ����Ա��ͼ�������꼶����������ҷ���������ѡ����Ϣ
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
	 * @return SUCCESS ת��ѡ����Ϣ�б���ʾҳ��<br>
	 *         ����Ա��ͼ������ѧ��ѧ�š�ѧ���������������ơ���ʦ������ȷ����ѡ����Ϣ<br>
	 *         ��ҳ��ʾ
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
	 * @return SUCCESS ת��ѡ����Ϣ�б���ʾҳ��<br>
	 *         ����Ա��ͼ������ѧ��ѧ�š�ѧ���������������ơ���ʦ������ȷ�����о��ͣ�������Ŀ��ѡ����Ϣ<br>
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
	 * @return SUCCESS ת����ʾѡ���б�ҳ��<br>
	 *         ����Ա��ͼ������һ��ѡ����Ϣ
	 */
	public String addSubstugui() {
		// ���ø����˽�г�Ա����
		if (tabTeachersManager.getTeacherByName(FTeacherName).isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("teacherError", "�ý�ʦ�����ڣ�");
			return INPUT;
		}
		if (tabStudentsManager.getStudentById(FStudentNumber) == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("studentError", "��ѧ�������ڣ�");
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
	 * @return SUCCESS ת����ʾѡ����Ϣ�б�ҳ��<br>
	 *         ɾ��һ��ѡ����Ϣ
	 */
	public String deleteSubstugui() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		bksxTabSubstuguiManager.deleteSubstugui(bksxTabSubstuguiManager
				.getSubstuguiById(id));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�����ѡ����Ϣҳ��<br>
	 *         ����Ԥ�����õ�����µ�ѡ����Ϣ�����ύ
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
	 * @return SUCCESS ת��ѡ����Ϣ�б���ʾҳ��<br>
	 *         ����һ��ѡ����Ϣ
	 */
	public String updateSubstugui() {
		if (tabTeachersManager.getTeacherByName(FTeacherName).isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("teacherError", "��ʦ��Ϣ�����ڣ�");
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
		// ѧ����Ϣ��ʱ���޸�
		// substugui.setFStudentName(tabStudentsManager.getStudentById(
		// FStudentNumber).getFStudentName());
		// substugui.setTabStudents(tabStudentsManager
		// .getStudentById(FStudentNumber));
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ѡ����Ϣ��ʾҳ��<br>
	 *         ѧ����ͼ����ʾѧ����ѡ����ϸ��Ϣ
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
	 * @return SUCCESS ת����ʾ�о�����Ŀ�б�ҳ��
	 * @exception ParseException
	 *                ����Ա��ͼ�������꼶���������ʵõ��о��͵�ѡ���б�
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
	 * @return SUCCESS ת���ض���ʦָ��ѧ����ѡ����Ϣ<br>
	 *         ָ����ʦ��ͼ���õ��ý�ʦָ��ѧ����ѡ����Ϣ
	 */
	public String getMySubjects() {
		// ��session�л�ȡ�ĵ�ǰ��ʦ��ID
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
	 * @return SUCCESS ת����ʾѡ����Ϣ����ϸ����ҳ��<br>
	 *         ָ����ʦ��ͼ���õ�ָ��ѡ�����ϸ����
	 */
	public String showSubjectDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("substugui", bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ָ��ѧ���б�<br>
	 *         ָ����ʦ��ͼ���õ�ָ��ѧ�����б�
	 */
	public String getMyStudents() {
		// ��session�л�ȡ�ĵ�ǰ��ʦ��ID
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
	 * @return SUCCESS ת����ʾ��Ŀ��ѡ���б���ʾҳ��<br>
	 *         ָ����ʦ��ͼ���õ��ý�ʦ��ָ������Ŀ�͵�ѡ���б�
	 */
	public String getMyProjectList() {
		// ��session�л�ȡ�Ľ�ʦID
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
	 * @return SUCCESS ת����ʾ�о���ѡ���б����ʾҳ��<br>
	 *         ָ����ʦ��ͼ���õ���ָ����ʦ��ָ�����о��͵�ѡ���б�
	 */
	public String getMyResearchList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��session�л�ȡ�Ľ�ʦID
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
	 * @return SUCCESS ת���½��Ŀ�����Ϣ��ʾҳ��<br>
	 *         ָ����ʦҳ�棬�õ��ý�ʦ�������µı�ҵ��ƿ�����Ϣ<br>
	 *         ����δ����˵ġ����ͨ���������δͨ���Ŀ��Ⲣ��δ��ѧ��ѡ���
	 */
	public String getMyNewSubjects() {
		// ��session�л�ȡ��ǰ��ʦ�Ķ���
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
	 * @return SUCCESS ת���½��������ʾҳ��<br>
	 *         ָ����ʦ��ͼ���½���ҵ��ƿ��⣬�ÿ���״̬Ϊ�����
	 */
	public String newMySubject() {
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		String teacherNum = teacher.getFTeacherNumber();
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		// ���ø����˽�г�Ա����
		subjectHelp(type, category);
		BksxTabSubstugui subject = new BksxTabSubstugui(null, FSubjectName,
				FIsSoftware, FIsHardware, FIsSoftHard, FIsDocument,
				FIsResearch, FIsSimulation, FIsLab, FIsOthers, FLevel,
				teacherName, teacherDegree, FWorkPlace, null,
				FSubjectDescription, teacherNum, "�����", null);
		bksxTabSubstuguiManager.saveSubstugui(subject);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת���½������б�ҳ��<br>
	 *         ����Ա��ͼ���õ�����δ��˵��½���ҵ��ƿ����б�
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
	 * @return SUCCESS ת����ʾ�½�������ϸ��Ϣ��ҳ��<br>
	 *         ����Ա��ͼ���õ�ĳ���½���ҵ��ƿ������ϸ����
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
	 * @return SUCCESS ת����ʾ�½���ҵ��ƿ�����б�ҳ��<br>
	 *         ����Ա��ͼ�������½���ҵ��ƿ��⣬��ͬ���򽫸ÿ�����ʾ��ѧ���Թ�ѡ��<br>
	 *         ���򽫴���ѡ����Ϊ���ܾ����������������ʦ
	 */
	public String dealApplySubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui subject = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		if (result.equals("ͬ��")) {
			subject.setFReason(FReason);
			subject.setFIsChecked("��ͨ��");
			bksxTabSubstuguiManager.updateSubstugui(subject);
		} else if (result.equals("�ܾ�")) {
			subject.setFReason(FReason);
			subject.setFIsChecked("���ܾ�");
			bksxTabSubstuguiManager.updateSubstugui(subject);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ�½������б��ҳ��<br>
	 *         ָ����ʦ��ͼ��ɾ��������Ա���Ϊ���ܾ����Ŀ�����Ϣ
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
	 * @return SUCCESS ת��ɹ�ѧ��ѡ��ı�ҵ��ƿ����б�<br>
	 *         ѧ����ͼ���õ��ɹ�ѡ�񣨹���Ա���ͨ����δ������ѧ��ѡ�����ı�ҵ��ƿ����б�
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
	 * @return SUCCESS ת��ɹ�ѡ��ı�ҵ��ƿ����б���ʾҳ��<br>
	 *         ѧ����ͼ��ѡ��ĳһ���⣬��ѡ�������ظ�ѡ��ͬһ���⽫������
	 */
	public String chooseSubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubstugui subject = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		// ��session�л�ȡ��ǰѧ������
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		// �ж��Ƿ��ظ�����ͬһ����
		BksxTabSubjectapply app = bksxTabSubjectapplyManager
				.getSubjectApplyByStuSub(student.getFStudentNumber(), subject
						.getFSubStuGuiId());
		if (app == null) {
			BksxTabSubjectapply apply = new BksxTabSubjectapply(subject,
					student, "�����");
			bksxTabSubjectapplyManager.saveSubjectApply(apply);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����ʾ����ý�ʦ�����������Ϣ�б�<br>
	 *         ָ����ʦ��ͼ���õ����иõ�ʦ���µ�ѡ�������б�
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
	 * @return SUCCESS ת������ѡ���б�<br>
	 *         ָ����ʦ��ͼ��ͬ���ѧ��ѡ��ÿ���
	 */
	public String agreeSubjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubjectapply apply = bksxTabSubjectapplyManager
				.getSubjectApplyListByID(applyID);
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(apply.getBksxTabSubstugui().getFSubStuGuiId());
		// ������ѧ����Ϣ����ѡ���
		substugui.setTabStudents(apply.getTabStudents());
		substugui.setFStudentName(apply.getTabStudents().getFStudentName());
		bksxTabSubstuguiManager.updateSubstugui(substugui);
		// ɾ��������еļ�¼
		bksxTabSubjectapplyManager.deleteSubjectApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת������ѡ���б�<br>
	 *         ָ����ʦ��ͼ��ͬ���ѧ��ѡ��ÿ���
	 */
	public String refuseSubjectApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int applyID = Integer.parseInt(request.getParameter("id"));
		BksxTabSubjectapply apply = bksxTabSubjectapplyManager
				.getSubjectApplyListByID(applyID);
		// ֱ�ӽ�������Ϣɾ��
		bksxTabSubjectapplyManager.deleteSubjectApply(apply);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɹ�ѡ��ı�ҵ��ƿ����б�ҳ��<br>
	 *         ѧ����ͼ�����ݿ������ơ���ʦ�������Ѷȵȼ���ѯ���������Ŀ�����Ϣ
	 */
	public String showAvalibleSubjectByAttribute() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String hql = "from BksxTabSubstugui bs where bs." + attributeType
				+ "='" + attribute
				+ "' and bs.tabStudents = null and bs.FIsChecked='��ͨ��'";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.put("subjectList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɹ�ѡ��ı�ҵ��ƿ����б�ҳ��<br>
	 *         ѧ����ͼ�����ݿ�����Դ���ٲ��ҷ��������Ŀ�����Ϣ
	 */
	public String showAvalibleSubjectByCategory() {
		ActionContext context = ActionContext.getContext();
		Map request = (Map) context.get("request");
		String hql = "from BksxTabSubstugui bs where bs." + substuguiCategory
				+ "='Y' and bs.tabStudents = null and bs.FIsChecked='��ͨ��'";
		List list = bksxTabSubstuguiManager.getSomeSubstuguiList(hql);
		request.put("subjectList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����⵼��ҳ��<br>
	 *         ����Ա��ͼ���������Ԥ�����õ���ʦ��ѧ�����б�
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
	 *         �Կ������ʺ���Դ������Խ������ã���ȡ�Լ����ظ��д���
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
	 * �����Ա������Get��Set����
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
