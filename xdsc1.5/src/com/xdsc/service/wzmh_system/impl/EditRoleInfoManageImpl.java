package com.xdsc.service.wzmh_system.impl;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.wzmh_system.EntityDAO;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabAdministrator;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.wzmh_system.EditRoleInfoManage;
import com.xdsc.wzmh_system.util.AItem;
import com.xdsc.wzmh_system.util.ALink;
import com.xdsc.wzmh_system.util.Alabel;
import com.xdsc.wzmh_system.util.Atag;
import com.xdsc.wzmh_system.util.Fckeditor;
import com.xdsc.wzmh_system.util.Table;
import com.xdsc.wzmh_system.util.Top;
/**
 * 编辑角色信息
 * @author 陈丰
 *
 */
public class EditRoleInfoManageImpl implements EditRoleInfoManage {
	private EntityDAO entityDAO;
	public EntityDAO getEntityDAO() {
		return entityDAO;
	}
	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}
	/**
	 * 编辑角色信息
	 * @param 角色类型编号 管理员 0，教师、导师、辅导员 1，助教4，家长 5，企业6，本科生7，研究生8
	 * @param 用户账号
	 * @param 是否为管理员
	 * @return jsp代码
	 */
	public String editRole(int roletype, String id, boolean isAdimin) {
		String returnValue = "";
		Table table = new Table(1, 1);// 2为一列几个标签 3 为一行几列
		if (roletype == 1)// 教师
		{
			TabTeachers teacher = entityDAO.findTeacherByID(id);
			if(teacher == null)
			{
				teacher = new TabTeachers();
			}
			returnValue += new Top("用户信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", "TeacherName", teacher
							.getFTeacherName(), 6),
					new AItem("性别   :", "TeacherSex", teacher.getFTeacherSex(),
							6),
					new AItem("出生年月:", "TeacherBirthday", teacher
							.getFTeacherBirthday() == null ? "" : teacher
							.getFTeacherBirthday().toLocaleString(), 10) });
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("电话   :", "TeacherTel", teacher.getFTeacherTel(),
							10),
					new AItem("手机   :", "TeacherPhone", teacher
							.getFTeacherPhone(), 10),
					new AItem("Email :", "TeacherEmail", teacher
							.getFTeacherEmail(), 15),
					new AItem("联系地址:", "TeacherAddress", teacher
							.getFTeacherAddress(), 15),
					new AItem("工作地点:", "TeacherWorkPlace", teacher
							.getFTeacherWorkPlace(), 15) });
			returnValue += table;
			returnValue += new Top("其他");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("学历   :", "TeacherXueLi", teacher
							.getFTeacherXueLi(), 6),
					new AItem("研究方向:", "TeacherResearch", teacher
							.getFTeacherResearch(), 6),
					new AItem("职位   :", "TeacherPosition", teacher
							.getFTeacherPosition(), 6),
					new AItem("职称   :", "TeacherZhiCheng", teacher
							.getFTeacherZhiCheng(), 6) });
			returnValue += table;
		}
		if (roletype == 4)// 校外助教 排除学生及教师当助教的案例
		{
			JfptTabOtherassist assist = entityDAO.findOtherassistByID(id);
			if(assist==null)
			{
				assist= new JfptTabOtherassist();
			}
			returnValue += new Top("用户信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table
					.addAtag(new Atag[] {
							new AItem("姓名   :", "Name", assist.getFName(), 6),
							new AItem("性别   :", "Sex", assist.getFSex(), 6),
							new AItem("年龄   :", "Age",
									assist.getFAge() == null ? "" : assist
											.getFAge().toString(), 6)});
					returnValue += table;
					returnValue += new Top("联系方式");
					table.clear();
					table.addAtag(new Atag[] {
							new AItem("电话   :", "Telephone", assist
									.getFTelephone(), 10),
							new AItem("Email :", "EmailAddress", assist
									.getFEmailAddress(), 15) });
			returnValue += table;
		}
		if (roletype == 5)// 家长
		{
			XsglTabParents parent = entityDAO.findParentsByID(id);
			return "<tr><font color=\"red\">抱歉  家长暂无可编辑的信息！</font></tr>";
		}
		if (roletype == 6)// 企业
		{
			TabCompany company = entityDAO.findCompanyByID(id);
			if (company == null)
				{
				company = new TabCompany();
				}
			returnValue += new Top("用户信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", "CompanyNumber", company
							.getFCompanyNumber(), 6),
					new AItem("公司名称   :", "CompanyName", company
							.getFCompanyName(), 6),new AItem("合作信息:", "CooperateInfo", company
									.getFCooperateInfo(), 15)});
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("联系人  :", "ConnectPerson", company
							.getFConnectPerson(), 6),
					new AItem("电话   :", "Telephone", company.getFTelephone(),
							10),
					new AItem("Email :", "EmailAddress", company
							.getFEmailAddress(), 15),
					new AItem("地址   :", "Address", company.getFAddress(), 15)});
			returnValue += table;

		}
		if (roletype == 7)// 本科生
		{
			TabStudents student = entityDAO.findStudentByID(id);
			if (student == null)
			{
				student = new TabStudents();
			}
			TabUndergraduate undergraduate = entityDAO
					.findUndergraduateByID(id);
			if (undergraduate == null)
			{
				undergraduate = new TabUndergraduate();
			}
			returnValue += new Top("个人信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table.addAtag(new Atag[] { new AItem("姓名   :", "StudentName",
					student.getFStudentName(), 6)
			 ,
				
					 new AItem("类别 :", "本科生"),
					 new AItem("班级 :", 
					 student.getTabClasses()==null?"":
					 student.getTabClasses().getFClassName()),
					 new AItem("性别 :",  student.getFStudentSex()
					 ),
					 new AItem("出生年月 :", student
					 .getFStudentBirthday()==null?"":student
					 .getFStudentBirthday().toLocaleString().substring(0,10)
					 ),
					 new AItem("专业 :", student
					 .getFStudentMajor())
					});
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("手机   :", "StudentTel", student.getFStudentTel(),
							10),
					new AItem("Email :", "StudentEmail", student
							.getFStudentEmail(), 15),
					new AItem("固定电话 :", "HomeTel", student.getFHomeTel(), 10),
					new AItem("宿舍   :", "StudentDormitory", student
							.getFStudentDormitory(), 10) });
			returnValue += table;
			 returnValue+=new Top("其他");
			 table.clear();
			 table.addAtag(new Atag[] {
			 new AItem("高中 :",  undergraduate
			 .getFStudentHighSchool()),
			 new AItem("高考分数:",  undergraduate
			 .getFStudentHscore()),
			 new AItem("是否第一志愿:",  undergraduate
			 .getFIsFirstChoice())});
			 returnValue+=table;
			
		}
		if (roletype == 8)// 研究生
		{
			TabStudents student = entityDAO.findStudentByID(id);
			
			TabPostgraduate postgraduate = entityDAO.findPostgraduateByID(id);
			if (student == null)
			{
			student = new TabStudents();
			}
			if (postgraduate == null)
			{
				postgraduate = new TabPostgraduate();
			}
			returnValue += new Top("用户信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", "StudentName", student
							.getFStudentName(), 6)
					,
				
					 new AItem("类别 :", "研究生"),
					 new AItem("班级 :", 
					 student.getTabClasses()==null?"":
					 student.getTabClasses().getFClassName()),
					 new AItem("性别 :", student.getFStudentSex()
					 ),
					 new AItem("出生年月 :",  student
					 .getFStudentBirthday()==null?"":student
					 .getFStudentBirthday().toLocaleString().substring(0,10)
					 ),
					 new AItem("专业 :",  student
					 .getFStudentMajor())
							});
					returnValue += table;
					returnValue += new Top("联系方式");
					table.clear();
					table.addAtag(new Atag[] {
					new AItem("手机   :", "StudentTel", student.getFStudentTel(),
							10),
					new AItem("Email :", "StudentEmail", student
							.getFStudentEmail(), 15),
					new AItem("固定电话 :", "HomeTel", student.getFHomeTel(), 10),
					new AItem("宿舍   :", "StudentDormitory", student
							.getFStudentDormitory(), 10)});
					returnValue += table;
					returnValue += new Top("其他");
					table.clear();
					table.addAtag(new Atag[] {
					 new AItem("導師 :", postgraduate
					 .getTabTeachers()==null?"":postgraduate
							 .getTabTeachers().getFTeacherName()),
					 new AItem("毕业学校:", postgraduate
					 .getFStudentExSchool()),
					 new AItem("毕业分数:",  postgraduate
					 .getFStudentEscore()),
					 new AItem("等级 :",postgraduate
					 .getFStudentErank()),
					 new AItem("类别 :", postgraduate.getFType()),
					 new AItem("是否第一志愿:", postgraduate
					 .getFIsFirstChoice())
					});
			returnValue += table;
		}
		if (isAdimin && roletype == 0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null)
			{			
				admin = new TabAdministrator();	
			}
			returnValue += new Top("用户信息").addLink(new ALink("LINK21",
					"showPIAction!showPersonalInfo.action", "返回"));
			table.addAtag(new Atag[] {
					new AItem("姓名   :", "Name", admin.getFName(), 10),
					new AItem("性别   :", "Sex", admin.getFSex(), 10),
					new AItem("年龄   :", "Age", admin.getFAge() == null ? ""
							: admin.getFAge().toString(), 10),
					 new AItem("类型 :",  admin.getFType()
					 ),
					new AItem("是否是总管理员   :", "Boss", admin.getFBoss(), 10)});
			returnValue += table;
			returnValue += new Top("联系方式");
			table.clear();
			table.addAtag(new Atag[]{
					new AItem("电话   :", "Telephone", admin.getFTelephone(), 20),
					new AItem("Email :", "EmailAddress", admin
							.getFEmailAddress(), 20) });
			returnValue += table;
		}
		if (returnValue.length() == 0)
			return "<tr><font color=\"red\">您没有配置相应角色，请联系管理员!</font></tr>";
		return returnValue;
	}

}
