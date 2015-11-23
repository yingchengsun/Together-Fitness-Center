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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action中封装了对研究型毕业设计课题《研究计划》的相关操作
 */
public class BksxTabSearchplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Spring注入的Service借口
	 */
	private BksxTabSearchplanManager bksxTabSearchplanManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * 《研究计划书》相关属性
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
	 * @return SUCCESS 转向研究计划列表<br>
	 *         根据学生学号查找《研究计划》
	 */
	public String getSearchPlanByStuNum() {
		// 由session中获取的用户Id
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
	 * @return SUCCESS 转向保存计划成功JSP页面<br>
	 *         保存《研究计划书》
	 */
	public String savePlan() {
		// 由session中获取的当前用户ID
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
	 * @return SUCCESS 转向更新《研究计划书》的JSP页面<br>
	 *         更新预处理，得到需更新的研究计划对象
	 */
	public String preUpdatePlan() {
		// 由Session获取当前用户
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
	 * @return SUCCESS 转向更新后的JSP页面<br>
	 * 
	 * 更新《研究计划书》
	 */
	public String updatePlan() {
		// 当开始时间大于结束时间是，将两者交换
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
	 * 该类成员变量的Get与Set方法
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
