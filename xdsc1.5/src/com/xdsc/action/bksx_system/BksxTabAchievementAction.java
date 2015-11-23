package com.xdsc.action.bksx_system;

import java.lang.reflect.Array;
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
import com.xdsc.model.BksxTabAchievement;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.bksx_system.BksxTabAchievementManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author 孙建波
 * @version 1.1 <br>
 *          此Action中封装了对毕设成绩的相关操作
 */
public class BksxTabAchievementAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service接口
	 */
	private BksxTabAchievementManager bksxTabAchievementManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabStudentsManager tabStudentsManager;

	/**
	 * 成绩相关属性
	 */
	private Integer FSubStuGuiId;
	private BksxTabSubstugui bksxTabSubstugui;
	private Float FFirstScore;
	private Float FSecondScore;
	private Float FThirdScore;
	private String FFinalScore;

	/**
	 * 辅助参数
	 */
	private String FStudentNumber;
	private String FStudentName;
	private String regDate;
	private Integer stage;
	private Float score;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS 转到显示JSP页面<br>
	 *         管理员视图得到所有的毕业设计成绩信息，并分页显示
	 */
	public String getAchievementList() {
		Map request = (Map) ActionContext.getContext().get("request");
		List list = bksxTabAchievementManager.getAllAchievement();
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
		request.put("achieveList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 如果没有此学生记录，则添加
	 * @return INPUT 如果存在此学生成绩记录，则转到更新ACTION 毕业设计管理员添加学生成绩
	 */
	public String addAchieve() {
		if (bksxTabAchievementManager.getAchievementByStuNum(FStudentNumber)
				.isEmpty()) {
			BksxTabSubstugui substugui = bksxTabSubstuguiManager
					.getSubstuguiByStuNum(FStudentNumber);
			if (substugui != null) {
				BksxTabAchievement achievement = new BksxTabAchievement(
						substugui.getFSubStuGuiId(), FFirstScore, FSecondScore,
						FThirdScore, null, FFinalScore);
				bksxTabAchievementManager.saveAchievement(achievement);
				return SUCCESS;
			}
			return INPUT;
		} else
			return INPUT;
	}

	/**
	 * @return SUCCESS 转向显示删除成功后的JSP页面<br>
	 *         删除某一条成绩信息
	 */
	public String deleteAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		bksxTabAchievementManager.deleteAchievement(bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩更新页面<br>
	 *         预更新处理，得到需更新的成绩对象
	 */
	public String preUpdateAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("achieve", bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩更新成功后页面 <br>
	 *         更新成绩
	 */
	public String updateAchieve() {
		BksxTabAchievement achievement = bksxTabAchievementManager
				.getAchievementByID(FSubStuGuiId);
		achievement.setFFirstScore(FFirstScore);
		achievement.setFSecondScore(FSecondScore);
		achievement.setFThirdScore(FThirdScore);
		achievement.setFFinalScore(FFinalScore);
		bksxTabAchievementManager.updateAchievement(achievement);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS <br>
	 *         以学生学号为参数得到该学生的成绩
	 */
	public String getAchieveByStuNum() {
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("achieveList", bksxTabAchievementManager
				.getAchievementByStuNum(FStudentNumber));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩显示页面
	 * @throws ParseException
	 *             按照年级来查询学生毕业设计成绩
	 */
	public String getAchieveByGrade() throws ParseException {
		String startStr = regDate + "-01-01";
		String endStr = regDate + "-12-31";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse(startStr);
		Date endDate = dateFormat.parse(endStr);
		List list = bksxTabAchievementManager.getAchievementByGrade(startDate,
				endDate);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("achieveList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩显示页面<br>
	 *         学生视图，得到该学生的成绩信息
	 */
	public String getMyAchievement() {
		// 由session中获得的用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		Map request = (Map) ActionContext.getContext().get("request");
		List list = bksxTabAchievementManager.getAchievementByStuNum(stuNum);
		if (list.isEmpty())
			request.put("achieve", null);
		else
			request.put("achieve", list.get(0));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩显示页面<br>
	 *         指导教师视图，得到该教师所指导的学生成绩信息，并分页显示
	 */
	public String getMyStudentAchievement() {
		// 假设由session中获取的当前用户
		TabTeachers teacher = (TabTeachers) ActionContext.getContext()
				.getSession().get("teacher");
		if (teacher == null)
			return INPUT;
		Map request = (Map) ActionContext.getContext().get("request");
		String teacherName = teacher.getFTeacherName();
		String teacherDegree = teacher.getFTeacherZhiCheng();
		List achieveList = new ArrayList();
		if (teacherDegree != null)
			achieveList = bksxTabAchievementManager.getAchievementByTeacher(
					teacherName, teacherDegree);
		else
			achieveList = bksxTabAchievementManager
					.getAchievementByTeacher(teacherName);
		if (achieveList.size() > 10) {
			int pages = 10;
			int listlength = achieveList.size();
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
			achieveList = achieveList.subList(startIndex, endIndex);
		}
		request.put("achieveList", achieveList);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩更新页面<br>
	 *         教师更新学生成绩预处理，得到该学生的成绩对象
	 */
	public String preUpdateStudentAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("achieve", bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向成绩修改成功页面<br>
	 *         教师修改学生成绩
	 */
	public String updateStudentAchieve() {
		BksxTabAchievement achievement = bksxTabAchievementManager
				.getAchievementByID(FSubStuGuiId);
		achievement.setFFirstScore(FFirstScore);
		achievement.setFSecondScore(FSecondScore);
		achievement.setFThirdScore(FThirdScore);
		bksxTabAchievementManager.updateAchievement(achievement);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转到修改成功后成绩信息<br>
	 *         指导教师分阶段给指导的学生打分
	 */
	public String addSingleScore() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		BksxTabAchievement achieve = bksxTabAchievementManager
				.getAchievementByID(substuguiID);
		if (achieve == null) {
			BksxTabAchievement a = new BksxTabAchievement(substuguiID, null,
					null, null, null, null);
			switch (stage) {
			case 0:
				a.setFFirstScore(score);
				break;
			case 1:
				a.setFSecondScore(score);
				break;
			case 2:
				a.setFThirdScore(score);
				break;
			}
			bksxTabAchievementManager.saveAchievement(a);
		} else {
			switch (stage) {
			case 0:
				achieve.setFFirstScore(score);
				break;
			case 1:
				achieve.setFSecondScore(score);
				break;
			case 2:
				achieve.setFThirdScore(score);
				break;
			}
			bksxTabAchievementManager.updateAchievement(achieve);
		}
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 跳转到成绩录入页面<br>
	 *         获取学生列表，以供录入选择之用
	 */
	public String toResultImport() {
//		List studentList = tabStudentsManager.getStudentList();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("studentList", studentList);
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public String getFStudentName() {
		return FStudentName;
	}

	public void setFStudentName(String studentName) {
		FStudentName = studentName;
	}

	public Integer getFSubStuGuiId() {
		return FSubStuGuiId;
	}

	public void setFSubStuGuiId(Integer subStuGuiId) {
		FSubStuGuiId = subStuGuiId;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public Float getFFirstScore() {
		return FFirstScore;
	}

	public void setFFirstScore(Float firstScore) {
		FFirstScore = firstScore;
	}

	public Float getFSecondScore() {
		return FSecondScore;
	}

	public void setFSecondScore(Float secondScore) {
		FSecondScore = secondScore;
	}

	public Float getFThirdScore() {
		return FThirdScore;
	}

	public void setFThirdScore(Float thirdScore) {
		FThirdScore = thirdScore;
	}

	public String getFFinalScore() {
		return FFinalScore;
	}

	public void setFFinalScore(String finalScore) {
		FFinalScore = finalScore;
	}

	public BksxTabAchievementManager getBksxTabAchievementManager() {
		return bksxTabAchievementManager;
	}

	public void setBksxTabAchievementManager(
			BksxTabAchievementManager bksxTabAchievementManager) {
		this.bksxTabAchievementManager = bksxTabAchievementManager;
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

}
