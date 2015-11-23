package com.xdsc.action.sjjx_system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.SjjxTabCourselab;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabGrade;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.service.jiaofu.CorrespondingDeployManager;
import com.xdsc.service.sjjx_system.SjjxTabClassesManager;
import com.xdsc.service.sjjx_system.SjjxTabCourseManager;
import com.xdsc.service.sjjx_system.SjjxTabCourselabManager;
import com.xdsc.service.sjjx_system.SjjxTabDirectionManager;
import com.xdsc.service.sjjx_system.SjjxTabGradeManager;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;
import com.xdsc.service.sjjx_system.SjjxTabTeachersManager;
import com.xdsc.service.sjjx_system.SjjxTabTeacherstotypeManager;
import com.xdsc.sjjx_system.util.DateConvert;
import com.xdsc.sjjx_system.util.PageListHolder;

/**
 * 对实验安排信息进行操作的Action
 * 
 * @author 陈雪
 * @version 1.1
 */

public class SjjxTabCourselabAction extends ActionSupport {

	/**
	 * Spring 注入的Service层的接口
	 */
	private SjjxTabCourselabManager sjjxTabCourselabManager;
	private SjjxTabLabManager sjjxTabLabManager;
	private SjjxTabCourseManager sjjxTabCourseManager;
	private SjjxTabTeachersManager sjjxTabTeachersManager;
	private SjjxTabClassesManager sjjxTabClassesManager;
	private SjjxTabDirectionManager sjjxTabDirectionManager;
	private SjjxTabGradeManager sjjxTabGradeManager;
	private SjjxTabTeacherstotypeManager sjjxTabTeacherstotypeManager;
	private CorrespondingDeployManager correspondingDeployManager;

	/**
	 * 实验安排信息相关属性
	 */
	private Integer FNumber;
	private SjjxTabLab sjjxTabLab;
	private TabTeachers tabTeachers;
	private TabCourse tabCourse;
	private TabGrade tabGrade;
	private TabClasses tabClasses;
	private TabDirection tabDirection;
	private TabTeacherstotype tabTeacherstotype;
	private String FTypeName;

	// 2010-06-01
	private String Fxiaoqu;
	private int Frenshu;
	private int[] select;

	private String FDate;
	private String FExactTime;
	private Integer FDirectionId;
	private String FLabName;
	private int FLabId;
	private String FCourseName;
	private String FTeacherName;

	private String FClassNumber;
	private String FDirectionName;
	private String FGradeName;
	private String exactTime;
	private String FTeacherNumber;

	/**
	 * 用于接收查询条件的变量
	 */
	private String search_item;
	private int search_item1;

	/**
	 * 得到实验安排信息列表
	 * 
	 * @return SUCCESS 显示列表
	 */
	public String getCourseLabList() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");
		List list = sjjxTabCourselabManager.getCourseLabList();

		if (list.isEmpty()) {
			request.put("isempty", new String("3"));
		} else {
			PageListHolder list_all = new PageListHolder(list);
			list_all.setPageSize(10);
			List list_current = list_all.getPageList();

			session.put("courseLabAll", list_all);
			request.put("courselablist", list_current);

			List list_type = sjjxTabTeacherstotypeManager.getTeacherByType();
			List list_teacher = new ArrayList();
			if (null != list_type && list_type.size() > 0) {
				for (int i = 0; i < list_type.size(); i++) {

					TabTeacherstotype temp = (TabTeacherstotype) list_type
							.get(i);
					if (temp.getTabTeacherstype().getFTypeName().equals(
							new String("带实验课教师")))
						list_teacher.add(sjjxTabTeachersManager
								.getTeacherByTeacherNumber(temp
										.getTabTeachers().getFTeacherNumber()));
				}
			}
			List list_lab = sjjxTabLabManager.getLabList();
			request.put("list_teacher", list_teacher);
			request.put("list_lab", list_lab);
		}
		return SUCCESS;
	}

	/**
	 * 分页功能中 响应点击[前一页]的函数
	 * 
	 * @return SUCCESS 显示前一页列表
	 */
	public String previousC() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");

		PageListHolder list_all = (PageListHolder) session.get("courseLabAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("courselablist", list_current);

		List list_type = sjjxTabTeacherstotypeManager.getTeacherByType();
		List list_teacher = new ArrayList();
		if (null != list_type && list_type.size() > 0) {
			for (int i = 0; i < list_type.size(); i++) {

				TabTeacherstotype temp = (TabTeacherstotype) list_type.get(i);
				if (temp.getTabTeacherstype().getFTypeName().equals(
						new String("带实验课教师")))
					list_teacher.add(sjjxTabTeachersManager
							.getTeacherByTeacherNumber(temp.getTabTeachers()
									.getFTeacherNumber()));
			}
		}
		List list_lab = sjjxTabLabManager.getLabList();

		request.put("list_teacher", list_teacher);
		request.put("list_lab", list_lab);
		return SUCCESS;
	}

	/**
	 * 分页功能中 响应点击[后一页]的函数
	 * 
	 * @return SUCCESS 显示后一页列表
	 */
	public String nextC() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");
		PageListHolder list_all = (PageListHolder) session.get("courseLabAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("courselablist", list_current);

		List list_type = sjjxTabTeacherstotypeManager.getTeacherByType();
		List list_teacher = new ArrayList();
		if (null != list_type && list_type.size() > 0) {
			for (int i = 0; i < list_type.size(); i++) {

				TabTeacherstotype temp = (TabTeacherstotype) list_type.get(i);
				if (temp.getTabTeacherstype().getFTypeName().equals(
						new String("带实验课教师")))
					list_teacher.add(sjjxTabTeachersManager
							.getTeacherByTeacherNumber(temp.getTabTeachers()
									.getFTeacherNumber()));
			}
		}
		List list_lab = sjjxTabLabManager.getLabList();

		request.put("list_teacher", list_teacher);
		request.put("list_lab", list_lab);

		return SUCCESS;
	}

	/**
	 * 预定机房时增添新的实验安排信息
	 * 
	 * @return SUCCESS 添加成功
	 * 
	 */
	public String addCourseLabInfo() {

		tabCourse = (TabCourse) sjjxTabCourseManager
				.getCourseByCourseName(FCourseName);

		tabClasses = (TabClasses) sjjxTabClassesManager
				.getClassesByClassNum(FClassNumber);

		tabTeachers = (TabTeachers) sjjxTabTeachersManager
				.getTeacherByTeacherNumber(FTeacherNumber);

		for (int i = 0; i < select.length; i++) {
			SjjxTabCourselab courseLab = new SjjxTabCourselab();
			DateConvert dateConvert = new DateConvert();

			try {
				Date sql_date = dateConvert.dateConvert(FDate);
				courseLab.setFDate(sql_date);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			courseLab.setTabClasses(tabClasses);
			courseLab.setTabCourse(tabCourse);
			courseLab.setSjjxTabLab(sjjxTabLabManager.getLabByLabId(select[i]));
			courseLab.setFExactTime(FExactTime);
			courseLab.setTabTeachers(tabTeachers);
			try {
				sjjxTabCourselabManager.saveCourseLab(courseLab);
			} catch (DataIntegrityViolationException e) {
				return ERROR;
			}

		}

		return SUCCESS;
	}

	/**
	 * 手动添加新的实验安排信息
	 * 
	 * @return SUCCESS 成功添加一条记录
	 */
	public String addCourseLabInfo1() {
		SjjxTabCourselab courseLab = new SjjxTabCourselab();

		tabTeachers = (TabTeachers) sjjxTabTeachersManager
				.getTeacherByTeacherName(FTeacherName);
		if (null != tabTeachers) {
			courseLab.setTabTeachers(tabTeachers);
			sjjxTabLab = (SjjxTabLab) sjjxTabLabManager.getLabByLabId(FLabId);
			if (null != sjjxTabLab) {
				courseLab.setSjjxTabLab(sjjxTabLab);
				tabCourse = (TabCourse) sjjxTabCourseManager
						.getCourseByCourseName(FCourseName);
				if (null != tabCourse) {
					courseLab.setTabCourse(tabCourse);
					tabClasses = (TabClasses) sjjxTabClassesManager
							.getClassesByClassNum(FClassNumber);
					courseLab.setTabClasses(tabClasses);

					// 时间格式的转换
					DateConvert dateConvert = new DateConvert();

					try {
						Date sql_date = dateConvert.dateConvert(FDate);
						courseLab.setFDate(sql_date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (exactTime.equals("0")) {
						courseLab.setFExactTime("下午");
					} else {
						courseLab.setFExactTime("晚上");
					}

				} else
					return INPUT;
			} else
				return INPUT;
		} else
			return INPUT;

		try {
			sjjxTabCourselabManager.saveCourseLab(courseLab);
		} catch (DataIntegrityViolationException e) {
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * 通过教师名称查找对应的实验安排信息
	 * 
	 * @return SUCCESS 得到对应信息列表
	 * 
	 */
	public String showCourseLab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map) ActionContext.getContext().get("session");

		String search_item_str;
		search_item_str = sjjxTabTeachersManager.getTeacherByTeacherNumber(
				search_item).getFTeacherName();
		List list = sjjxTabCourselabManager
				.getCourseLabByTeacherName(search_item_str);

		if (list.isEmpty()) {
			request.setAttribute("isempty", new String("1"));
		}

		PageListHolder list_all = new PageListHolder(list);

		list_all.setPageSize(10);
		List list_current = list_all.getPageList();

		session.put("courseLabAll", list_all);
		request.setAttribute("courselablist", list_current);

		List list_type = sjjxTabTeacherstotypeManager.getTeacherByType();
		List list_teacher = new ArrayList();
		if (null != list_type && list_type.size() > 0) {
			for (int i = 0; i < list_type.size(); i++) {

				TabTeacherstotype temp = (TabTeacherstotype) list_type.get(i);
				if (temp.getTabTeacherstype().getFTypeName().equals(
						new String("带实验课教师")))
					list_teacher.add(sjjxTabTeachersManager
							.getTeacherByTeacherNumber(temp.getTabTeachers()
									.getFTeacherNumber()));
			}
		}
		List list_lab = sjjxTabLabManager.getLabList();

		request.setAttribute("list_teacher", list_teacher);
		request.setAttribute("list_lab", list_lab);

		return SUCCESS;
	}

	/**
	 * 通过实验室名称查找对应的实验安排信息
	 * 
	 * @return SUCCESS 得到对应信息列表
	 * 
	 */
	public String showCourseLab1() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map) ActionContext.getContext().get("session");

		String search_item_str;
		search_item_str = sjjxTabLabManager.getLabByLabId(search_item1)
				.getFLabName();
		List list = sjjxTabCourselabManager
				.getCourseLabByLabName(search_item_str);

		if (list.isEmpty()) {
			request.setAttribute("isempty", new String("2"));
		}

		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();

		session.put("courseLabAll", list_all);
		request.setAttribute("courselablist", list_current);

		List list_type = sjjxTabTeacherstotypeManager.getTeacherByType();
		List list_teacher = new ArrayList();
		if (null != list_type && list_type.size() > 0) {
			for (int i = 0; i < list_type.size(); i++) {

				TabTeacherstotype temp = (TabTeacherstotype) list_type.get(i);
				if (temp.getTabTeacherstype().getFTypeName().equals(
						new String("带实验课教师")))
					list_teacher.add(sjjxTabTeachersManager
							.getTeacherByTeacherNumber(temp.getTabTeachers()
									.getFTeacherNumber()));
			}
		}
		List list_lab = sjjxTabLabManager.getLabList();

		request.setAttribute("list_teacher", list_teacher);
		request.setAttribute("list_lab", list_lab);

		return SUCCESS;
	}

	/**
	 * 通过实验室Id查找对应的实验安排信息
	 * 
	 * @return SUCCESS 得到对应信息列表
	 * 
	 */
	public String showCourseLab2() {

		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map) ActionContext.getContext().get("session");
		int lab_id = Integer.parseInt(request.getParameter("lab_id"));
		List<SjjxTabCourselab> courselab_list = sjjxTabCourselabManager
				.getCourseLabByLabId(lab_id);
		// 如果查找到的List为空，则不显示内容
		if (courselab_list.isEmpty()) {
			request.setAttribute("isempty", new String("1"));

		} else {
			PageListHolder list_all = new PageListHolder(courselab_list);
			list_all.setPageSize(10);
			List list_current = list_all.getPageList();

			session.put("courseLabAll", list_all);
			request.setAttribute("courselablist", list_current);
		}
		return SUCCESS;
	}

	/**
	 * 通过自增Id查找对应的实验安排信息
	 * 
	 * @return SUCCESS 得到对应信息列表
	 * 
	 */
	public String showCourseLab3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int number = (Integer) request.getAttribute("id");
		SjjxTabCourselab courseLab = (SjjxTabCourselab) sjjxTabCourselabManager
				.getCourseLabById(number);
		request.setAttribute("courselab", courseLab);
		return SUCCESS;
	}

	/**
	 * 通过查找Id将相应的实验安排信息删除
	 * 
	 * @return SUCCESS 成功从列表中删除对应记录
	 * 
	 */
	public String deleteCourseLab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("cid"));
		sjjxTabCourselabManager.deleteCourseLab(sjjxTabCourselabManager
				.getCourseLabById(id));
		return SUCCESS;
	}

	/**
	 * 预更新处理 ，通过Id得到需要的对象
	 * 
	 * @return SUCCESS 转至更新页面
	 * 
	 */
	public String preUpdateCourseLab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("cid"));
		request.setAttribute("courselab", sjjxTabCourselabManager
				.getCourseLabById(id));
		return SUCCESS;
	}

	/**
	 * 更新实验安排信息
	 * 
	 * @return SUCCESS 成功更新一条记录
	 * 
	 */
	public String updateCourseLab() {
		SjjxTabCourselab courseLab = sjjxTabCourselabManager
				.getCourseLabById(FNumber);

		tabTeachers = (TabTeachers) sjjxTabTeachersManager
				.getTeacherByTeacherName(FTeacherName);
		if (null != tabTeachers) {
			courseLab.setTabTeachers(tabTeachers);
			sjjxTabLab = (SjjxTabLab) sjjxTabLabManager.getLabByLabId(FLabId);
			if (null != sjjxTabLab) {
				courseLab.setSjjxTabLab(sjjxTabLab);
				tabClasses = (TabClasses) sjjxTabClassesManager
						.getClassesByClassNum(FClassNumber);
				if (null != tabClasses) {
					courseLab.setTabClasses(tabClasses);

					tabCourse = (TabCourse) sjjxTabCourseManager
							.getCourseByCourseName(FCourseName);
					courseLab.setTabCourse(tabCourse);

					// 时间格式的转换
					DateConvert dateConvert = new DateConvert();

					try {
						Date sql_date = dateConvert.dateConvert(FDate);
						courseLab.setFDate(sql_date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (exactTime.equals("0")) {
						courseLab.setFExactTime("下午");
					} else {
						courseLab.setFExactTime("晚上");
					}

				} else
					return INPUT;
			} else
				return INPUT;
		} else
			return INPUT;
		try {
			sjjxTabCourselabManager.updateCourseLab(courseLab);
		} catch (DataIntegrityViolationException e) {
			return ERROR;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", courseLab.getFNumber());
		return SUCCESS;
	}

	/**
	 * 将列表中的全部实验安排信息删除
	 * 
	 * @return SUCCESS 成功从列表中删除全部记录
	 */
	public String deleteCourseLabAll() {
		List<SjjxTabCourselab> CLlist = sjjxTabCourselabManager
				.getCourseLabList();
		CLlist.toArray();
		int size = CLlist.size();
		for (int i = 0; i < size; i++) {
			SjjxTabCourselab courseLab = sjjxTabCourselabManager
					.getCourseLabById(CLlist.get(i).getFNumber());
			sjjxTabCourselabManager.deleteCourseLab(courseLab);
		}
		return SUCCESS;
	}

	/**
	 * 进行机房预定的方法
	 * 
	 * @return SUCCESS
	 * 
	 */
	public String unique() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List info_List = sjjxTabCourselabManager.getCourseLabList();
		if ("south".equals(Fxiaoqu)) {
			Fxiaoqu = "南校区";
		} else if ("north".equals(Fxiaoqu)) {
			Fxiaoqu = "北校区";
		}

		if ("pm".equals(FExactTime)) {
			FExactTime = "下午";
		} else if ("ev".equals(FExactTime)) {
			FExactTime = "晚上";
		}

		List list_location = sjjxTabLabManager.getLabList();
		List<SjjxTabLab> list_lab = new ArrayList();
		if (list_location.size() > 0) {
			for (int i = 0; i < list_location.size(); i++) {
				SjjxTabLab lab = (SjjxTabLab) list_location.get(i);
				if (Fxiaoqu.equals(lab.getFLabLocation().toString())) {
					list_lab.add(lab);
				}
			}
		}
		System.out.println("aa" + list_lab.size());

		Iterator it = info_List.iterator();
		while (it.hasNext()) {
			SjjxTabCourselab sjjx = (SjjxTabCourselab) it.next();
			System.out.println("in unique to print the Fdate"
					+ sjjx.getFDate().toString());
			if ((sjjx.getFDate().toString().split(" ")[0].equals(FDate))
					&& (sjjx.getFExactTime().toString().equals(FExactTime))
					&& (sjjx.getSjjxTabLab().getFLabLocation().toString()
							.equals(Fxiaoqu))) {
				if (list_lab.size() > 0) {
					for (int i = 0; i < list_lab.size(); i++) {
						System.out.println(list_lab.get(i).getFLabId()==sjjx.getSjjxTabLab()
								.getFLabId());
						if (list_lab.get(i).getFLabId().equals(sjjx.getSjjxTabLab().getFLabId())) {
							System.out
									.print("############# remove the certain lab...");
							list_lab.remove(i);
						}
					}
					System.out.println(list_lab.size());
				}
			}
		}

		// System.out.println("dd"+list_lab.size());

		int sum = 0;
		for (int i = 0; i < list_lab.size(); i++) {
			SjjxTabLab sjjxlab = (SjjxTabLab) list_lab.get(i);
			sum += sjjxlab.getFSeatNumber();
		}
		if (sum < Frenshu) {
			request.setAttribute("notenough", new String("1"));
		}
		request.setAttribute("lab_List", list_lab);
		request.setAttribute("FDate", FDate);
		request.setAttribute("FExactTime", FExactTime);
		request.setAttribute("FClassNumber", FClassNumber);
		request.setAttribute("FCourseName", FCourseName);

		return SUCCESS;

	}

	/**
	 * 根据教师登录Id获得该教师所教课程班级信息
	 * 
	 * @return SUCCESS
	 */
	public String search() {

		HttpServletRequest request = ServletActionContext.getRequest();
		List list = correspondingDeployManager.findTeacherDeployInfo();
		String userNumber = (String) request.getSession().getAttribute(
				"userNumber");
		for (int i = 0; i < list.size(); i++) {
			JfptTabTeacherassociate je = (JfptTabTeacherassociate) list.get(i);
			if (!(je.getTabTeachers().getFTeacherNumber().equals(userNumber))) {
				list.remove(i);
			}
		}
		List class_list = new ArrayList();
		List course_list = new ArrayList();
		for (int j = 0; j < list.size(); j++) {
			JfptTabTeacherassociate je = (JfptTabTeacherassociate) list.get(j);
			if (!class_list.contains(je.getTabClasses())) {
				class_list.add(je.getTabClasses());
			}
			if (!course_list.contains(je.getTabCourse())) {
				course_list.add(je.getTabCourse());
			}
		}

		request.setAttribute("class_list", class_list);
		request.setAttribute("course_list", course_list);
		return SUCCESS;
	}

	/**
	 * 通过教师登录Id得到该教师的实验安排记录
	 * 
	 * @return SUCCESS
	 */
	public String courseLabT() {

		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map) ActionContext.getContext().get("session");
		String userNumber = (String) request.getSession().getAttribute(
				"userNumber");
		List<SjjxTabCourselab> courseLab = sjjxTabCourselabManager
				.getCourseLabByTeacherNum(userNumber);
		if (courseLab.isEmpty()) {
			request.setAttribute("isempty", new String("1"));

		} else {
			PageListHolder list_all = new PageListHolder(courseLab);
			list_all.setPageSize(5);
			List list_current = list_all.getPageList();

			session.put("courseLabAll", list_all);
			request.setAttribute("courseLabList", list_current);
		}
		return SUCCESS;
	}
	
	public String nextT() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");
		PageListHolder list_all = (PageListHolder) session.get("courseLabAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("courseLabList", list_current);
		return SUCCESS;
	}
	
	public String previousT() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session = (Map) ActionContext.getContext().get("session");
		PageListHolder list_all = (PageListHolder) session.get("courseLabAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("courseLabList", list_current);
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public int getFLabId() {
		return FLabId;
	}

	public void setFLabId(int labId) {
		FLabId = labId;
	}

	public SjjxTabCourselabManager getSjjxTabCourselabManager() {
		return sjjxTabCourselabManager;
	}

	public void setSjjxTabCourselabManager(
			SjjxTabCourselabManager sjjxTabCourselabManager) {
		this.sjjxTabCourselabManager = sjjxTabCourselabManager;
	}

	public SjjxTabCourseManager getSjjxTabCourseManager() {
		return sjjxTabCourseManager;
	}

	public void setSjjxTabCourseManager(
			SjjxTabCourseManager sjjxTabCourseManager) {
		this.sjjxTabCourseManager = sjjxTabCourseManager;
	}

	public SjjxTabTeachersManager getSjjxTabTeachersManager() {
		return sjjxTabTeachersManager;
	}

	public void setSjjxTabTeachersManager(
			SjjxTabTeachersManager sjjxTabTeachersManager) {
		this.sjjxTabTeachersManager = sjjxTabTeachersManager;
	}

	public SjjxTabClassesManager getSjjxTabClassesManager() {
		return sjjxTabClassesManager;
	}

	public void setSjjxTabClassesManager(
			SjjxTabClassesManager sjjxTabClassesManager) {
		this.sjjxTabClassesManager = sjjxTabClassesManager;
	}

	public SjjxTabDirectionManager getSjjxTabDirectionManager() {
		return sjjxTabDirectionManager;
	}

	public void setSjjxTabDirectionManager(
			SjjxTabDirectionManager sjjxTabDirectionManager) {
		this.sjjxTabDirectionManager = sjjxTabDirectionManager;
	}

	public SjjxTabGradeManager getSjjxTabGradeManager() {
		return sjjxTabGradeManager;
	}

	public void setSjjxTabGradeManager(SjjxTabGradeManager sjjxTabGradeManager) {
		this.sjjxTabGradeManager = sjjxTabGradeManager;
	}

	public String getFGradeName() {
		return FGradeName;
	}

	public void setFGradeName(String gradeName) {
		FGradeName = gradeName;
	}

	public String getFDirectionName() {
		return FDirectionName;
	}

	public void setFDirectionName(String directionName) {
		FDirectionName = directionName;
	}

	public TabGrade getTabGrade() {
		return tabGrade;
	}

	public void setTabGrade(TabGrade tabGrade) {
		this.tabGrade = tabGrade;
	}

	public TabClasses getTabClasses() {
		return tabClasses;
	}

	public void setTabClasses(TabClasses tabClasses) {
		this.tabClasses = tabClasses;
	}

	public TabDirection getTabDirection() {
		return tabDirection;
	}

	public void setTabDirection(TabDirection tabDirection) {
		this.tabDirection = tabDirection;
	}

	public String getFExactTime() {
		return FExactTime;
	}

	public void setFExactTime(String exactTime) {
		FExactTime = exactTime;
	}

	public int getSearch_item1() {
		return search_item1;
	}

	public void setSearch_item1(int searchItem1) {
		search_item1 = searchItem1;
	}

	public String getSearch_item() {
		return search_item;
	}

	public void setSearch_item(String searchItem) {
		search_item = searchItem;
	}

	public String getFLabName() {
		return FLabName;
	}

	public void setFLabName(String labName) {
		FLabName = labName;
	}

	public String getFCourseName() {
		return FCourseName;
	}

	public void setFCourseName(String courseName) {
		FCourseName = courseName;
	}

	public String getFTeacherName() {
		return FTeacherName;
	}

	public void setFTeacherName(String teacherName) {
		FTeacherName = teacherName;
	}

	public SjjxTabLabManager getSjjxTabLabManager() {
		return sjjxTabLabManager;
	}

	public void setSjjxTabLabManager(SjjxTabLabManager sjjxTabLabManager) {
		this.sjjxTabLabManager = sjjxTabLabManager;
	}

	public Integer getFNumber() {
		return FNumber;
	}

	public void setFNumber(Integer number) {
		FNumber = number;
	}

	public SjjxTabLab getSjjxTabLab() {
		return sjjxTabLab;
	}

	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}

	public TabTeachers getTabTeachers() {
		return tabTeachers;
	}

	public void setTabTeachers(TabTeachers tabTeachers) {
		this.tabTeachers = tabTeachers;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFDate() {
		return FDate;
	}

	public void setFDate(String date) {
		FDate = date;
	}

	public Integer getFDirectionId() {
		return FDirectionId;
	}

	public void setFDirectionId(Integer directionId) {
		FDirectionId = directionId;
	}

	public String getExactTime() {
		return exactTime;
	}

	public void setExactTime(String exactTime) {
		this.exactTime = exactTime;
	}

	public String getFClassNumber() {
		return FClassNumber;
	}

	public void setFClassNumber(String classNumber) {
		FClassNumber = classNumber;
	}

	public SjjxTabTeacherstotypeManager getSjjxTabTeacherstotypeManager() {
		return sjjxTabTeacherstotypeManager;
	}

	public void setSjjxTabTeacherstotypeManager(
			SjjxTabTeacherstotypeManager sjjxTabTeacherstotypeManager) {
		this.sjjxTabTeacherstotypeManager = sjjxTabTeacherstotypeManager;
	}

	public TabTeacherstotype getTabTeacherstotype() {
		return tabTeacherstotype;
	}

	public void setTabTeacherstotype(TabTeacherstotype tabTeacherstotype) {
		this.tabTeacherstotype = tabTeacherstotype;
	}

	public String getFTypeName() {
		return FTypeName;
	}

	public void setFTypeName(String fTypeName) {
		FTypeName = fTypeName;
	}

	public synchronized String getFxiaoqu() {
		return Fxiaoqu;
	}

	public synchronized void setFxiaoqu(String fxiaoqu) {
		Fxiaoqu = fxiaoqu;
	}

	public synchronized int getFrenshu() {
		return Frenshu;
	}

	public synchronized void setFrenshu(int frenshu) {
		Frenshu = frenshu;
	}

	public synchronized int[] getSelect() {
		return select;
	}

	public synchronized void setSelect(int[] select) {
		this.select = select;
	}

	public synchronized CorrespondingDeployManager getCorrespondingDeployManager() {
		return correspondingDeployManager;
	}

	public synchronized void setCorrespondingDeployManager(
			CorrespondingDeployManager correspondingDeployManager) {
		this.correspondingDeployManager = correspondingDeployManager;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String fTeacherNumber) {
		FTeacherNumber = fTeacherNumber;
	}

}
