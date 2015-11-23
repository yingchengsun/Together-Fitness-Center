package com.xdsc.service.wzmh_system.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.wzmh_system.EntityDAO;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.TabAdministrator;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.wzmh_system.GetBasicInfoManager;
import com.xdsc.util.Constant;

/**
 * 获取用户基本信息 提示问候语
 * 
 * @author 陈丰
 *
 */
public class GetBasicInfoManagerImpl implements GetBasicInfoManager {
	private EntityDAO entityDAO;

	public EntityDAO getEntityDAO() {
		return entityDAO;
	}
	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}
	
	
	
	/**
	 * 提取当前时间 用户提示
	 * @return 问候语
	 */
	public String getWelcome(){
		Date d = new Date();
		int hour=d.getHours();
		
		System.out.println("当前时间："+d.getHours());
		String welcome=" ";
		if(hour>=6&&hour<12)
			welcome+="上午好";
		if(hour>=12&&hour<14)
			welcome+="中午好";
		if(hour>=14&&hour<18)
			welcome+="下午好";
		if(hour>=18&&hour<22)
			welcome+="晚上好";
		if((hour>=22&&hour<24)||(hour>=0&&hour<6))
			welcome+="夜深了，请注意休息";
			return "";
	}
	
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.wzmh_system.GetBasicInfoManager#getInfo(java.lang.String, java.util.List)
	 */
	public void getInfo(String id, List<MhqxTabRole> rolelist) {
		System.out.println("测试+++++++++++++"+id);
		
		int roletype = 0;
		boolean isAdimin = false;
		HttpSession session = ServletActionContext.getRequest().getSession();
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.isEmpty())
				return;
			MhqxTabRole role = rolelist.get(i);
			String name = role.getFRoleName();

			if (name.equals("教师") || name.equals("导师") || name.equals("辅导员"))
			{
				roletype = 1;
				break;
			}
			if (name.equals("助教"))
				roletype = 4;
			if (name.equals("家长"))
				roletype = 5;
			if (name.equals("企业"))
				roletype = 6;
			if (name.equals("本科生") || name.equals("学生"))
			{
				roletype = 7;
				break;
			}
			if (name.equals("研究生"))
			{
				roletype = 8;
				break;
			}
			if (name.lastIndexOf("管理员") >= 0)
				isAdimin = true;
		}
		session.setAttribute(Constant.Welcome,"您好，您的个人信息不完整，请先编辑个人信息！");
		if (roletype == 1 )// 教师
		{
			TabTeachers teacher = entityDAO.findTeacherByID(id);
			if (teacher == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+teacher.getFTeacherName()+getWelcome());
		}
		if (roletype == 4)// 校外助教 排除学生及教师当助教的案例
		{
			JfptTabOtherassist assist = entityDAO.findOtherassistByID(id);
			if (assist == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+assist.getFName()+getWelcome());
		}
		if (roletype == 5)// 家长
		{
			XsglTabParents parent = entityDAO.findParentsByID(id);
			if (parent == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+parent.getFParentName()+getWelcome());
		}
		if (roletype == 6)// 企业
		{
			TabCompany company = entityDAO.findCompanyByID(id);
			if (company == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+company.getFCompanyName()+getWelcome());
		}
		if (roletype == 7)// 本科生
		{
			TabStudents student = entityDAO.findStudentByID(id);
			if (student == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+student.getFStudentName()+getWelcome());
		}
		if (roletype == 8)// 研究生
		{
			TabStudents student = entityDAO.findStudentByID(id);
			if (student == null)
				return;
			session.setAttribute(Constant.Welcome,"欢迎您！"+ student.getFStudentName()+getWelcome());
		}
		if (isAdimin&&roletype==0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null)
				return;
			session.setAttribute(Constant.Welcome,admin.getFName());
		}
		System.out.println(session.getAttribute(Constant.Welcome));
	}
}
