package com.xdsc.action.bksx_system;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabSearchplan;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.TabStudents;
import com.xdsc.service.bksx_system.BksxTabSearchplanManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action�з�װ�˶��о��ͱ�ҵ��ƿ��⡶�о��ƻ�������ز���
 */
public class BksxTabSearchplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Springע���Service���
	 */
	private BksxTabSearchplanManager bksxTabSearchplanManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * ���о��ƻ��顷�������
	 */
	private Integer id;
	private BksxTabSubstugui bksxTabSubstugui;
	private Date FFstartDate;
	private Date FFfinishDate;
	private String FFcontent;
	private Date FMstartDate;
	private Date FMfinishDate;
	private String FMcontent;
	private Date FEstartDate;
	private Date FEfinishDate;
	private String FEcontent;
	private String FFilePath;

	/**
	 * @return SUCCESS ת���о��ƻ��б�<br>
	 *         ����ѧ��ѧ�Ų��ҡ��о��ƻ���
	 */
	public String getSearchPlanByStuNum() {
		// ��session�л�ȡ���û�Id
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		BksxTabSearchplan plan = new BksxTabSearchplan();
		String stuNum = student.getFStudentNumber();
		plan = bksxTabSearchplanManager.getSearchPlanByStuNum(stuNum);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("plan", plan);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�򱣴�ƻ��ɹ�JSPҳ��<br>
	 *         ���桶�о��ƻ��顷
	 */
	public String savePlan() {
		// ��session�л�ȡ�ĵ�ǰ�û�ID
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		String stuNum = student.getFStudentNumber();
		BksxTabSubstugui substugui = bksxTabSubstuguiManager
				.getSubstuguiByStuNum(stuNum);
		BksxTabSearchplan plan = new BksxTabSearchplan(substugui, FFstartDate,
				FFfinishDate, FFcontent, FMstartDate, FMfinishDate, FMcontent,
				FEstartDate, FEfinishDate, FEcontent);
		bksxTabSearchplanManager.saveSearchPlan(plan);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����¡��о��ƻ��顷��JSPҳ��<br>
	 *         ����Ԥ�����õ�����µ��о��ƻ�����
	 */
	public String preUpdatePlan() {
		// ��Session��ȡ��ǰ�û�
		TabStudents student = (TabStudents) ActionContext.getContext()
				.getSession().get("student");
		if (student == null)
			return INPUT;
		HttpServletRequest request = ServletActionContext.getRequest();
		int planID = bksxTabSearchplanManager.getSearchPlanByStuNum(
				student.getFStudentNumber()).getId();
		BksxTabSearchplan plan = bksxTabSearchplanManager
				.getSearchPlanByID(planID);
		request.setAttribute("plan", plan);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת����º��JSPҳ��<br>
	 * 
	 * ���¡��о��ƻ��顷
	 */
	public String updatePlan() {
		// ����ʼʱ����ڽ���ʱ���ǣ������߽���
		Date tempDate = new Date();
		if (FFstartDate.getTime() > FFfinishDate.getTime()) {
			tempDate = FFstartDate;
			FFstartDate = FFfinishDate;
			FFfinishDate = tempDate;
		}
		if (FMstartDate.getTime() > FMfinishDate.getTime()) {
			tempDate = FMstartDate;
			FMstartDate = FMfinishDate;
			FMfinishDate = tempDate;
		}
		if (FEstartDate.getTime() > FEfinishDate.getTime()) {
			tempDate = FEstartDate;
			FEstartDate = FEfinishDate;
			FEfinishDate = tempDate;
		}
		BksxTabSearchplan plan = bksxTabSearchplanManager.getSearchPlanByID(id);
		plan.setFEcontent(FEcontent);
		plan.setFEfinishDate(FEfinishDate);
		plan.setFEstartDate(FEstartDate);
		plan.setFFcontent(FFcontent);
		plan.setFFfinishDate(FFfinishDate);
		plan.setFFstartDate(FFstartDate);
		plan.setFMcontent(FMcontent);
		plan.setFMfinishDate(FMfinishDate);
		plan.setFMstartDate(FMstartDate);
		bksxTabSearchplanManager.updateSearchPlan(plan);
		return SUCCESS;

	}

	/**
	 * �����Ա������Get��Set����
	 */
	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BksxTabSubstugui getBksxTabSubstugui() {
		return bksxTabSubstugui;
	}

	public void setBksxTabSubstugui(BksxTabSubstugui bksxTabSubstugui) {
		this.bksxTabSubstugui = bksxTabSubstugui;
	}

	public Date getFFstartDate() {
		return FFstartDate;
	}

	public void setFFstartDate(Date fstartDate) {
		FFstartDate = fstartDate;
	}

	public Date getFFfinishDate() {
		return FFfinishDate;
	}

	public void setFFfinishDate(Date ffinishDate) {
		FFfinishDate = ffinishDate;
	}

	public String getFFcontent() {
		return FFcontent;
	}

	public void setFFcontent(String fcontent) {
		FFcontent = fcontent;
	}

	public Date getFMstartDate() {
		return FMstartDate;
	}

	public void setFMstartDate(Date mstartDate) {
		FMstartDate = mstartDate;
	}

	public Date getFMfinishDate() {
		return FMfinishDate;
	}

	public void setFMfinishDate(Date mfinishDate) {
		FMfinishDate = mfinishDate;
	}

	public String getFMcontent() {
		return FMcontent;
	}

	public void setFMcontent(String mcontent) {
		FMcontent = mcontent;
	}

	public Date getFEstartDate() {
		return FEstartDate;
	}

	public void setFEstartDate(Date estartDate) {
		FEstartDate = estartDate;
	}

	public Date getFEfinishDate() {
		return FEfinishDate;
	}

	public void setFEfinishDate(Date efinishDate) {
		FEfinishDate = efinishDate;
	}

	public String getFEcontent() {
		return FEcontent;
	}

	public void setFEcontent(String econtent) {
		FEcontent = econtent;
	}

	public String getFFilePath() {
		return FFilePath;
	}

	public void setFFilePath(String filePath) {
		FFilePath = filePath;
	}

	public BksxTabSearchplanManager getBksxTabSearchplanManager() {
		return bksxTabSearchplanManager;
	}

	public void setBksxTabSearchplanManager(
			BksxTabSearchplanManager bksxTabSearchplanManager) {
		this.bksxTabSearchplanManager = bksxTabSearchplanManager;
	}

}
