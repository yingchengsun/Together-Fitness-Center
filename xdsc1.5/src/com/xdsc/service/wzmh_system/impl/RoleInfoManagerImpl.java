package com.xdsc.service.wzmh_system.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.wzmh_system.EntityDAO;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.TabAdministrator;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.wzmh_system.util.AItem;
import com.xdsc.wzmh_system.util.ALink;
import com.xdsc.wzmh_system.util.Atag;
import com.xdsc.wzmh_system.util.Table;
import com.xdsc.wzmh_system.util.Top;

/**
 * 角色信息展示
 * @author 陈丰
 *
 */
public class RoleInfoManagerImpl implements
		com.xdsc.service.wzmh_system.RoleInfoManager {
	private EntityDAO entityDAO;
	private int roletype = 0;// 记录用户角色编码 教师 1 导师 1 辅导员 1，助教4，家长
	// 5，企业6，本科生7，研究生8
	private boolean isAdimin = false;
	private MhqxTabRoleUserManager roleusermanager;
	

	public MhqxTabRoleUserManager getRoleusermanager() {
		return roleusermanager;
	}

	public void setRoleusermanager(MhqxTabRoleUserManager roleusermanager) {
		this.roleusermanager = roleusermanager;
	}

	public EntityDAO getEntityDAO() {
		return entityDAO;
	}

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	/**
	 * 角色信息展示
	 * @param 用户账号
	 * @param 角色列表
	 * @return jsp代码
	 */
	public String getRoleInfo(String id, List<MhqxTabRole> rolelist) {
		roletype = 0;
		String returnValue = "";
		Table table = new Table(1, 1);// 2为一列几个标签 3 为一行几列
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.isEmpty())
				return "<font color=\"red\">您没有编辑可用的角色，请联系管理员！</font>";
			MhqxTabRole role = rolelist.get(i);
			String name = role.getFRoleName();
			System.out.println("role name:" + name);
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
			System.out.println(isAdimin + name + " name.lastIndexOf "
					+ name.lastIndexOf("管理员"));
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("roletype", roletype);
		session.setAttribute("isAdimin", isAdimin);

		if (roletype == 1 )// 教师
		{
			TabTeachers teacher = entityDAO.findTeacherByID(id);
			if (teacher == null)
			{
				returnValue+="<tr><font color=\"red\">您的教师角色没有编辑完整信息，请先编辑！</font></tr>";
				returnValue += new Top("个人信息").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"编辑")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"修改密码"));
				 
				return returnValue;
			}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", teacher.getFTeacherName()),
					new AItem("职工号 :", teacher.getFTeacherNumber()),
					new AItem("性别   :", teacher.getFTeacherSex()),
					new AItem("出生年月:",
							teacher.getFTeacherBirthday() == null ? ""
									: teacher.getFTeacherBirthday()
											.toLocaleString().substring(0, 10)),
					new AItem("学历   :", teacher.getFTeacherXueLi()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("电话   :", teacher.getFTeacherTel()),
					new AItem("手机   :", teacher.getFTeacherPhone()),
					new AItem("Email :", teacher.getFTeacherEmail()),
					new AItem("联系地址:", teacher.getFTeacherAddress()),
					new AItem("工作地点:", teacher.getFTeacherWorkPlace()) });
			returnValue += table;
			returnValue += new Top("其他");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("研究方向:", teacher.getFTeacherResearch()),
					new AItem("职位   :", teacher.getFTeacherPosition()),
					new AItem("职称   :", teacher.getFTeacherZhiCheng())

			});
			returnValue += table;
		}
		if (roletype == 4)// 校外助教 排除学生及教师当助教的案例
		{
			JfptTabOtherassist assist = entityDAO.findOtherassistByID(id);
			if (assist == null)
			{ returnValue+="<tr><font color=\"red\">您的助教角色没有编辑完整信息，请先编辑！</font></tr>";
				returnValue += new Top("个人信息").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"编辑")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"修改密码"));
				
				return returnValue;
				}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", assist.getFName()),
					new AItem("性别   :", assist.getFSex()),
					new AItem("年龄   :", assist.getFAge() == null ? "" : assist
							.getFAge().toString()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("电话   :", assist.getFTelephone()),
					new AItem("Email :", assist.getFEmailAddress()) });
			returnValue += table;
		}
		if (roletype == 5)// 家长
		{
			XsglTabParents parent = entityDAO.findParentsByID(id);
			if (parent == null)
				return "<tr><font color=\"red\">您没有编辑家长相应信息，请先编辑！</font></tr>";
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码")).addLink(
									new ALink("LINK21", "showPIAction!editPersonalInfo.action",
									"查询您的子女的个人信息"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", parent.getFParentName()),
					new AItem("帐号   :", parent.getFParentId()) });
			returnValue += table;
		}
		if (roletype == 6)// 企业
		{
			TabCompany company = entityDAO.findCompanyByID(id);
			if (company == null)
			{
				
				returnValue+="<tr><font color=\"red\">您的企业角色没有编辑完整信息，请先编辑！</font></tr>";
				returnValue += new Top("个人信息").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"编辑")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"修改密码"));
				 
				return returnValue;
			}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", company.getFCompanyNumber()),
					new AItem("公司名称   :", company.getFCompanyName()),
					new AItem("合作内容:", company.getFCooperateInfo()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("联系人  :", company.getFConnectPerson()),
					new AItem("电话   :", company.getFTelephone()),
					new AItem("Email :", company.getFEmailAddress()),
					new AItem("地址   :", company.getFAddress()) });
			returnValue += table;
			returnValue += new Top("其他");
			table.clear();
			table.addAtag(new Atag[] { new AItem("详细信息   :", company
					.getFInformation()) });
			returnValue += table;
		}
		if (roletype == 7)// 本科生
		{
			TabStudents student = entityDAO.findStudentByID(id);

			TabUndergraduate undergraduate = entityDAO
					.findUndergraduateByID(id);
			if (student == null)
				{
				  returnValue+="<tr><font color=\"red\">您的学生角色没有编辑完整信息，请先编辑！</font></tr>";
					returnValue += new Top("个人信息").addLink(
							new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
									"编辑")).addLink(
							new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
									"修改密码"));
					
					return returnValue;
				}
			if(undergraduate == null)
			{
				undergraduate = new TabUndergraduate();
			}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table
					.addAtag(new Atag[] {
							new AItem("姓名   :", student.getFStudentName()),
							new AItem("帐号   :", student.getFStudentNumber()),
							new AItem("类别   :", "本科生"),
							new AItem("班级   :",
									student.getTabClasses() == null ? ""
											: student.getTabClasses()
													.getFClassName()),
							new AItem("性别   :", student.getFStudentSex()),
							new AItem("出生年月   :",
									student.getFStudentBirthday() == null ? ""
											: student.getFStudentBirthday()
													.toLocaleString()
													.substring(0, 10)),
							new AItem("专业   :", student.getFStudentMajor()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("手机   :", student.getFStudentTel()),
					new AItem("Email :", student.getFStudentEmail()),
					new AItem("固定电话 :", student.getFHomeTel()),
					new AItem("宿舍   :", student.getFStudentDormitory()) });
			returnValue += table;
			returnValue += new Top("其他");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("高中   :", undergraduate.getFStudentHighSchool()),
					new AItem("高考分数:", undergraduate.getFStudentHscore()),
					new AItem("是否第一志愿:", undergraduate.getFIsFirstChoice()) });
			returnValue += table;
		}
		if (roletype == 8)// 研究生
		{
			TabStudents student = entityDAO.findStudentByID(id);
			
			TabPostgraduate postgraduate = entityDAO.findPostgraduateByID(id);
			if (student == null){		
			returnValue+="<tr><font color=\"red\">您的学生角色没有编辑完整信息，请先编辑！</font></tr>";
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			
			return returnValue;
		}
			if(postgraduate==null)
			{
				postgraduate=new TabPostgraduate();
			}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table
					.addAtag(new Atag[] {
							new AItem("姓名   :", student.getFStudentName()),
							new AItem("帐号   :", student.getFStudentNumber()),
							new AItem("类别   :", "研究生"),
							new AItem("班级   :",
									student.getTabClasses() == null ? ""
											: student.getTabClasses()
													.getFClassName()),
							new AItem("性别   :", student.getFStudentSex()),
							new AItem("出生年月   :",
									student.getFStudentBirthday() == null ? ""
											: student.getFStudentBirthday()
													.toLocaleString()
													.substring(0, 10)),
							new AItem("专业   :", student.getFStudentMajor()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("手机   :", student.getFStudentTel()),
					new AItem("Email :", student.getFStudentEmail()),
					new AItem("固定电话 :", student.getFHomeTel()),
					new AItem("宿舍   :", student.getFStudentDormitory()) });
			returnValue += table;
			returnValue += new Top("其他");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("导师   :", postgraduate.getTabTeachers()==null?"":
						 postgraduate.getTabTeachers().getFTeacherName()),
					new AItem("毕业学校:", postgraduate.getFStudentExSchool()),
					new AItem("毕业分数:", postgraduate.getFStudentEscore()),
					new AItem("等级   :", postgraduate.getFStudentErank()),
					new AItem("类别   :", postgraduate.getFType()),
					new AItem("是否第一志愿:", postgraduate.getFIsFirstChoice()) });
			returnValue += table;
		}
		if (isAdimin&&roletype==0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null){
				returnValue+="<tr><font color=\"red\">您的管理员角色没有编辑完整信息，请先编辑！</font></tr>";
				returnValue += new Top("个人信息").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"编辑")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"修改密码"));
				return returnValue;
			}
			returnValue += new Top("个人信息").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"编辑")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"修改密码"));
			table.addAtag(new Atag[] {
					new AItem("帐号   :",  admin.getFAdminNumber()
							),
					new AItem("姓名   :",  admin.getFName()),
					new AItem("性别   :",  admin.getFSex()),
					new AItem("年龄   :", admin.getFAge() == null ? ""
							: admin.getFAge().toString()),
					new AItem("类型   :",  admin.getFType()),
					new AItem("是否是总管理员   :",  admin.getFBoss()) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("电话   :",  admin.getFTelephone()),
					new AItem("Email :",  admin
							.getFEmailAddress()) });
			returnValue += table;
		}
		if (isAdimin&&roletype!=0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null)
				return returnValue+"您的管理员角色没有编辑相应性息，请联系高级管理员！" ;
			table.addAtag(new Atag[] {
					new AItem("管理员类型:",  admin.getFType()),
			 });
			returnValue += table;
		}
		if (returnValue.length() == 0)
			return "您没有编辑相应性息，请联系管理员!" ;
		System.out.println(returnValue);
		return returnValue;
	}
}
