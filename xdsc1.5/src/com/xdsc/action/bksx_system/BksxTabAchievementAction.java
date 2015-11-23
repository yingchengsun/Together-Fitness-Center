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
 * @author �ｨ��
 * @version 1.1 <br>
 *          ��Action�з�װ�˶Ա���ɼ�����ز���
 */
public class BksxTabAchievementAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Springע���Service�ӿ�
	 */
	private BksxTabAchievementManager bksxTabAchievementManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabStudentsManager tabStudentsManager;

	/**
	 * �ɼ��������
	 */
	private Integer FSubStuGuiId;
	private BksxTabSubstugui bksxTabSubstugui;
	private Float FFirstScore;
	private Float FSecondScore;
	private Float FThirdScore;
	private String FFinalScore;

	/**
	 * ��������
	 */
	private String FStudentNumber;
	private String FStudentName;
	private String regDate;
	private Integer stage;
	private Float score;
	private int p = 1;
	private int lastPage;

	/**
	 * @return SUCCESS ת����ʾJSPҳ��<br>
	 *         ����Ա��ͼ�õ����еı�ҵ��Ƴɼ���Ϣ������ҳ��ʾ
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
	 * @return SUCCESS ���û�д�ѧ����¼�������
	 * @return INPUT ������ڴ�ѧ���ɼ���¼����ת������ACTION ��ҵ��ƹ���Ա���ѧ���ɼ�
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
	 * @return SUCCESS ת����ʾɾ���ɹ����JSPҳ��<br>
	 *         ɾ��ĳһ���ɼ���Ϣ
	 */
	public String deleteAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		bksxTabAchievementManager.deleteAchievement(bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɼ�����ҳ��<br>
	 *         Ԥ���´����õ�����µĳɼ�����
	 */
	public String preUpdateAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("achieve", bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɼ����³ɹ���ҳ�� <br>
	 *         ���³ɼ�
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
	 *         ��ѧ��ѧ��Ϊ�����õ���ѧ���ĳɼ�
	 */
	public String getAchieveByStuNum() {
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("achieveList", bksxTabAchievementManager
				.getAchievementByStuNum(FStudentNumber));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɼ���ʾҳ��
	 * @throws ParseException
	 *             �����꼶����ѯѧ����ҵ��Ƴɼ�
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
	 * @return SUCCESS ת��ɼ���ʾҳ��<br>
	 *         ѧ����ͼ���õ���ѧ���ĳɼ���Ϣ
	 */
	public String getMyAchievement() {
		// ��session�л�õ��û�ID
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
	 * @return SUCCESS ת��ɼ���ʾҳ��<br>
	 *         ָ����ʦ��ͼ���õ��ý�ʦ��ָ����ѧ���ɼ���Ϣ������ҳ��ʾ
	 */
	public String getMyStudentAchievement() {
		// ������session�л�ȡ�ĵ�ǰ�û�
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
	 * @return SUCCESS ת��ɼ�����ҳ��<br>
	 *         ��ʦ����ѧ���ɼ�Ԥ�����õ���ѧ���ĳɼ�����
	 */
	public String preUpdateStudentAchieve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int achieveID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("achieve", bksxTabAchievementManager
				.getAchievementByID(achieveID));
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��ɼ��޸ĳɹ�ҳ��<br>
	 *         ��ʦ�޸�ѧ���ɼ�
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
	 * @return SUCCESS ת���޸ĳɹ���ɼ���Ϣ<br>
	 *         ָ����ʦ�ֽ׶θ�ָ����ѧ�����
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
	 * @return SUCCESS ��ת���ɼ�¼��ҳ��<br>
	 *         ��ȡѧ���б��Թ�¼��ѡ��֮��
	 */
	public String toResultImport() {
//		List studentList = tabStudentsManager.getStudentList();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("studentList", studentList);
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
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
