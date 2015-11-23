package com.xdsc.action.xsgl_system;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabGrade;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.util.PageListHolder;

/**
 * 各年级信息
 * 
 * @author 杨盼盼
 * @version 1.1
 */
public class XsglTabGradeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private XsglTabGradeManager xsglTabGradeManager;
	private XsglTabTeachersManager xsglTabTeachersManager;

	private Integer FGradeId;
	private String FGradeNum;
	private String FGradeName;
	private Integer FGradeMaleNum;
	private Integer FGradeFemaleNum;
	private Integer FGradeTotalNum;
	private Set tabTeacherses = new HashSet(0);
	private String[] FTeacherName;

	private String gradeType; // 研究生或本科生
	private String teacherName0;
	private String teacherName1;
	private String teacherName2;

	public String getTeacherName0() {
		return teacherName0;
	}

	public void setTeacherName0(String teacherName0) {
		this.teacherName0 = teacherName0;
	}

	public String getTeacherName1() {
		return teacherName1;
	}

	public void setTeacherName1(String teacherName1) {
		this.teacherName1 = teacherName1;
	}

	public String getTeacherName2() {
		return teacherName2;
	}

	public void setTeacherName2(String teacherName2) {
		this.teacherName2 = teacherName2;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public String[] getFTeacherName() {
		return FTeacherName;
	}

	public void setFTeacherName(String[] teacherName) {
		FTeacherName = teacherName;
	}

	public String getFGradeNum() {
		return FGradeNum;
	}

	public void setFGradeNum(String gradeNum) {
		FGradeNum = gradeNum;
	}

	public String getFGradeName() {
		return FGradeName;
	}

	public void setFGradeName(String gradeName) {
		FGradeName = gradeName;
	}

	public Integer getFGradeMaleNum() {
		return FGradeMaleNum;
	}

	public void setFGradeMaleNum(Integer gradeMaleNum) {
		FGradeMaleNum = gradeMaleNum;
	}

	public Integer getFGradeFemaleNum() {
		return FGradeFemaleNum;
	}

	public void setFGradeFemaleNum(Integer gradeFemaleNum) {
		FGradeFemaleNum = gradeFemaleNum;
	}

	public Integer getFGradeTotalNum() {
		return FGradeTotalNum;
	}

	public void setFGradeTotalNum(Integer gradeTotalNum) {
		FGradeTotalNum = gradeTotalNum;
	}

	public Integer getFGradeId() {
		return FGradeId;
	}

	public void setFGradeId(Integer gradeId) {
		FGradeId = gradeId;
	}

	public Set getTabTeacherses() {
		return tabTeacherses;
	}

	public void setTabTeacherses(Set tabTeacherses) {
		this.tabTeacherses = tabTeacherses;
	}

	public XsglTabGradeManager getXsglTabGradeManager() {
		return xsglTabGradeManager;
	}

	public void setXsglTabGradeManager(XsglTabGradeManager xsglTabGradeManager) {
		this.xsglTabGradeManager = xsglTabGradeManager;
	}

	public XsglTabTeachersManager getXsglTabTeachersManager() {
		return xsglTabTeachersManager;
	}

	public void setXsglTabTeachersManager(
			XsglTabTeachersManager xsglTabTeachersManager) {
		this.xsglTabTeachersManager = xsglTabTeachersManager;
	}

	/**
	 * 获取本科生各年级信息
	 * 
	 * @return SUCCESS 获取成功
	 */
	public String getGradeListByUndergraduate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("gradeList", xsglTabGradeManager
				.getGradeListByUndergraduate());
		return SUCCESS;
	}

	/**
	 * 获取研究生各年级信息
	 * 
	 * @return SUCCESS 获取成功
	 */
	public String getGradeListByPostgraduate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("gradeList", xsglTabGradeManager
				.getGradeListByPostgraduate());
		return SUCCESS;
	}

	/**
	 * 获取所有年级信息
	 * 
	 * @return SUCCESS 获取成功
	 */
	public String getGradeList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map) ActionContext.getContext().get("session");
		List list = xsglTabGradeManager.getGradeList();
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("gradeAll", list_all);
		request.setAttribute("gradeList", list_current);
		return SUCCESS;
	}

	/**
	 * 前翻页
	 * 
	 * @return SUCCESS 前翻页成功
	 */
	public String gradePrevious() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");

		PageListHolder list_all = (PageListHolder) session.get("gradeAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("gradeList", list_current);

		return SUCCESS;
	}

	/**
	 * 后翻页
	 * 
	 * @return SUCCESS 后翻页成功
	 */
	public String gradeNext() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");

		PageListHolder list_all = (PageListHolder) session.get("gradeAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("gradeList", list_current);

		return SUCCESS;
	}

	/**
	 * 添加一个年级
	 * 
	 * @return SUCCESS 添加成功
	 * @return INPUT 输入出错，添加失败
	 */
	public String addGrade() {
		if (xsglTabGradeManager.getGradeByGradeName(FGradeName) != null) {
			return INPUT;
		} else {
			TabGrade grade = new TabGrade();
			// teacherName1 辅导员名字串
			String[] name = teacherName1.split("/");
			for (int i = 0; i < name.length; i++) {
				grade.getTabTeacherses().add(
						xsglTabTeachersManager.getTeacherByTeaName(name[i]));
			}
			grade.setFGradeNum(FGradeNum);
			grade.setFGradeName(FGradeName);
			grade.setFGradeTotalNum(FGradeTotalNum);
			grade.setFGradeMaleNum(FGradeMaleNum);
			grade.setFGradeFemaleNum(FGradeFemaleNum);
			xsglTabGradeManager.saveGrade(grade);

			// 学生类型为本科生，添加班主任
			if (gradeType.equals("0")) {
				grade.getTabTeacherses().add(
						xsglTabTeachersManager
								.getTeacherByTeaName(teacherName0));
				TabTeachers t = xsglTabTeachersManager
						.getTeacherByTeaName(teacherName0);
				if (t != null) {
					t.setTabGrade(grade);
					xsglTabTeachersManager.updateTeacher(t);
				} else
					return INPUT;
			}
			for (int i = 0; i < name.length; i++) {
				System.out.println("######### name[" + i + "]===" + name[i]);
				TabTeachers t = xsglTabTeachersManager
						.getTeacherByTeaName(name[i]);
				if (t != null) {
					t.setTabGrade(grade);
					xsglTabTeachersManager.updateTeacher(t);
				} else
					return INPUT;
			}
			return SUCCESS;
		}
	}

	/**
	 * 预更新一个年级信息
	 * 
	 * @return SUCCESS 确定更新对象
	 */
	public String preUpdateGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int gradeId = Integer.parseInt(request.getParameter("gradeid"));
		request.setAttribute("grade", xsglTabGradeManager
				.getGradeByGradeId(gradeId));
		return SUCCESS;
	}

	/**
	 * 更新一个年级信息
	 * 
	 * @return SUCCESS 更新成功
	 */
	public String updateGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int gradeid = Integer.parseInt(request.getParameter("gradeID"));
		TabGrade grade = xsglTabGradeManager.getGradeByGradeId(gradeid);

		Iterator it = grade.getTabTeacherses().iterator();
		while (it.hasNext()) {
			TabTeachers t = (TabTeachers) it.next();
			t.setTabGrade(null);
			xsglTabTeachersManager.updateTeacher(t);
		}

		System.out.println("%#^%$^&%^&$&^$&^$&^%&^%&^"
				+ grade.getTabTeacherses().size());
		grade.getTabTeacherses().clear();
		System.out.println(grade.getTabTeacherses().size());
		Set ts = new HashSet();
		for (int i = 0; i < FTeacherName.length; i++) {
			ts.add(xsglTabTeachersManager.getTeacherByTeaName(FTeacherName[i]));
		}
		grade.setFGradeNum(FGradeNum);
		grade.setFGradeName(FGradeName);
		grade.setFGradeTotalNum(FGradeTotalNum);
		grade.setFGradeMaleNum(FGradeMaleNum);
		grade.setFGradeFemaleNum(FGradeFemaleNum);
		grade.setTabTeacherses(ts);
		xsglTabGradeManager.updateGrade(grade);

		for (int i = 0; i < FTeacherName.length; i++) {
			TabTeachers t = xsglTabTeachersManager
					.getTeacherByTeaName(FTeacherName[i]);
			if (t != null) {
				t.setTabGrade(grade);
				xsglTabTeachersManager.updateTeacher(t);
			} else
				return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 删除一个年级
	 * 
	 * @return SUCCESS 删除成功
	 */
	public String deleteGrade() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int gradeId = Integer.parseInt(request.getParameter("gradeid"));
		xsglTabGradeManager.deleteGrade((TabGrade) xsglTabGradeManager
				.getGradeByGradeId(gradeId));
		return SUCCESS;
	}

}
