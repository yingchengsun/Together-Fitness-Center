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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶Թ�����־����ز���
 */
public class BksxTabWorkdiaryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service��ӿ�
	 */
	private BksxTabWorkdiaryManager bksxTabWorkdiaryManager;
	private TabStudentsManager tabStudentsManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabAchievementManager bksxTabAchievementManager;

	/**
	 * ���˹�����־�������
	 */
	private Integer FWid;
	private BksxTabSubstugui bksxTabSubstugui;
	private String FDiaryAuthor;
	private Date FDiaryDate;
	private String FDiaryTitle;
	private String FDiaryContent;

	/**
	 * ��������
	 */
	private Date startDate;
	private Date endDate;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS ת������־�б�<br>
	 *         ѧ����ͼ����¼������־
	 */
	public String addWorkDiary() {
		// ��session�л�ȡ���û�ID
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
	 * @return SUCCESS ת������־�б�<br>
	 *         ѧ����ͼ���õ���ǰѧ�������й�����־�б�
	 */
	public String getDiaryListByStuNum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��session�л�ȡ���û�ID
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
	 * @return SUCCESS ת��ĳ��������־��ϸ��Ϣ<br>
	 *         ����Ա����ʦ������ͼ���õ�ĳѧ�����ճ���������
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
	 * @return SUCCESS ת��ѧ����ϸ�ճ�������ʾҳ��
	 * @exception ParseException
	 *                ����Ա��ָ����ʦ������ͼ���������ڲ�ѯ����������ѧ��������־
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
	 * @return SUCCESS ת��ѧ����־�б���ʾҳ��<br>
	 *         ѧ����ͼ��ɾ��һ��������־��¼
	 */
	public String deleteDiary() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		BksxTabWorkdiary diary = bksxTabWorkdiaryManager.getDiaryById(id);
		bksxTabWorkdiaryManager.deleteWorkDiary(diary);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ѧ��������־�б�<br>
	 *         ѧ����ͼ���������ڲ�ѯ������������־�б�
	 */
	public String getDiaryListByDate() throws ParseException {
		// ��session�л�ȡ��ǰ�û�ID
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
	 * �����Ա������Get��Set����
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
