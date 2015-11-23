package com.xdsc.action.bksx_system;

import java.text.ParseException;
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
import com.xdsc.model.BksxTabWorkdiary;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabAchievementManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.BksxTabWorkdiaryManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对工作日志的相关操作
 */
public class BksxTabWorkdiaryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring注入的Service层接口
	 */
	private BksxTabWorkdiaryManager bksxTabWorkdiaryManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabAchievementManager bksxTabAchievementManager;

	/**
	 * 个人工作日志相关属性
	 */
	private Integer FWid;
	private BksxTabSubstugui bksxTabSubstugui;
	private String FDiaryAuthor;
	private Date FDiaryDate;
	private String FDiaryTitle;
	private String FDiaryContent;

	/**
	 * 辅助参数
	 */
	private Date startDate;
	private Date endDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS 转向工作日志列表<br>
	 *         学生视图，记录工作日志
	 */
	public String addWorkDiary() {
		// 由session中获取的用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		FDiaryAuthor = tabStudentsManager.getStudentById(stuNum)
				.getFStudentName();
		bksxTabSubstugui = bksxTabSubstuguiManager.getSubstuguiByStuNum(stuNum);
		if (bksxTabSubstugui == null)
			return "error";
		BksxTabWorkdiary diary = new BksxTabWorkdiary(bksxTabSubstugui,
				FDiaryAuthor, new Date(), FDiaryTitle, FDiaryContent);
		bksxTabWorkdiaryManager.saveWorkDiary(diary);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向工作日志列表<br>
	 *         学生视图，得到当前学生的所有工作日志列表
	 */
	public String getDiaryListByStuNum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 由session中获取的用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		List list = new ArrayList();
		String stuNum = student.getFStudentNumber();
		list = bksxTabWorkdiaryManager.getDiaryListByStuNum(stuNum);
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
		request.setAttribute("diraylist", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向某生工作日志详细信息<br>
	 *         管理员，教师公共视图，得到某学生的日常工作详情
	 */
	public String getStudentDiaryByStuNum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuNum = request.getParameter("id");
		List list = bksxTabWorkdiaryManager.getDiaryListByStuNum(stuNum);
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		List alist = bksxTabAchievementManager.getAchievementByStuNum(stuNum);
		if (alist.isEmpty()) {
			request.setAttribute("achieve", null);
		} else {
			BksxTabAchievement achieve = (BksxTabAchievement) alist.get(0);
			request.setAttribute("achieve", achieve);
		}
		request.setAttribute("substugui", substugui);
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
		request.setAttribute("diraylist", list);
		request.setAttribute("substugui", substugui);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向学生详细日常工作显示页面
	 * @exception ParseException
	 *                管理员，指导教师公共视图，按照日期查询符合条件的学生工作日志
	 */
	public String getStudentDiaryByDate() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		int substuguiID = Integer.parseInt(request.getParameter("id"));
		List list = new ArrayList();
		if (startDate != null && endDate != null
				&& startDate.getTime() <= endDate.getTime()) {
			list = bksxTabWorkdiaryManager.getDiaryListBySubstuguiID(
					substuguiID, startDate, endDate);
		} else {
			String stuNum = bksxTabSubstuguiManager.getSubstuguiById(
					substuguiID).getTabStudents().getFStudentNumber();
			list = bksxTabWorkdiaryManager.getDiaryListByStuNum(stuNum);
		}
		request.setAttribute("diraylist", list);
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiById(substuguiID);
		request.setAttribute("substugui", substugui);
		return SUCCESS;

	}

	/**
	 * @return SUCCESS 转向学生日志列表显示页面<br>
	 *         学生视图，删除一条工作日志记录
	 */
	public String deleteDiary() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabWorkdiary diary = bksxTabWorkdiaryManager.getDiaryById(id);
		bksxTabWorkdiaryManager.deleteWorkDiary(diary);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向学生工作日志列表<br>
	 *         学生视图，按照日期查询符合条件的日志列表
	 */
	public String getDiaryListByDate() throws ParseException {
		// 由session中获取当前用户ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return "error";
		String stuNum = student.getFStudentNumber();
		if (startDate != null && endDate != null
				&& startDate.getTime() <= endDate.getTime()) {
			Map request = (Map) ActionContext.getContext().get("request");
			List list = bksxTabWorkdiaryManager.getDiaryListByDate(stuNum,
					startDate, endDate);
			request.put("diraylist", list);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public BksxTabAchievementManager getBksxTabAchievementManager() {
		return bksxTabAchievementManager;
	}

	public void setBksxTabAchievementManager(
			BksxTabAchievementManager bksxTabAchievementManager) {
		this.bksxTabAchievementManager = bksxTabAchievementManager;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getFDiaryAuthor() {
		return FDiaryAuthor;
	}

	public void setFDiaryAuthor(String diaryAuthor) {
		FDiaryAuthor = diaryAuthor;
	}

	public Date getFDiaryDate() {
		return FDiaryDate;
	}

	public void setFDiaryDate(Date diaryDate) {
		FDiaryDate = diaryDate;
	}

	public String getFDiaryTitle() {
		return FDiaryTitle;
	}

	public void setFDiaryTitle(String diaryTitle) {
		FDiaryTitle = diaryTitle;
	}

	public String getFDiaryContent() {
		return FDiaryContent;
	}

	public void setFDiaryContent(String diaryContent) {
		FDiaryContent = diaryContent;
	}

	public BksxTabWorkdiaryManager getBksxTabWorkdiaryManager() {
		return bksxTabWorkdiaryManager;
	}

	public void setBksxTabWorkdiaryManager(
			BksxTabWorkdiaryManager bksxTabWorkdiaryManager) {
		this.bksxTabWorkdiaryManager = bksxTabWorkdiaryManager;
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

}
