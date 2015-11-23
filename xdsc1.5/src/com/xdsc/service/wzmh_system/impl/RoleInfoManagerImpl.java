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
 * ��ɫ��Ϣչʾ
 * @author �·�
 *
 */
public class RoleInfoManagerImpl implements
		com.xdsc.service.wzmh_system.RoleInfoManager {
	private EntityDAO entityDAO;
	private int roletype = 0;// ��¼�û���ɫ���� ��ʦ 1 ��ʦ 1 ����Ա 1������4���ҳ�
	// 5����ҵ6��������7���о���8
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
	 * ��ɫ��Ϣչʾ
	 * @param �û��˺�
	 * @param ��ɫ�б�
	 * @return jsp����
	 */
	public String getRoleInfo(String id, List<MhqxTabRole> rolelist) {
		roletype = 0;
		String returnValue = "";
		Table table = new Table(1, 1);// 2Ϊһ�м�����ǩ 3 Ϊһ�м���
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.isEmpty())
				return "<font color=\"red\">��û�б༭���õĽ�ɫ������ϵ����Ա��</font>";
			MhqxTabRole role = rolelist.get(i);
			String name = role.getFRoleName();
			System.out.println("role name:" + name);
			if (name.equals("��ʦ") || name.equals("��ʦ") || name.equals("����Ա"))
			{
				roletype = 1;
				break;
			}
			if (name.equals("����"))
				roletype = 4;
			if (name.equals("�ҳ�"))
				roletype = 5;
			if (name.equals("��ҵ"))
				roletype = 6;
			if (name.equals("������") || name.equals("ѧ��"))
			{
				roletype = 7;
				break;
			}
			if (name.equals("�о���"))
			{
				roletype = 8;
				break;
			}
			if (name.lastIndexOf("����Ա") >= 0)
				isAdimin = true;
			System.out.println(isAdimin + name + " name.lastIndexOf "
					+ name.lastIndexOf("����Ա"));
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("roletype", roletype);
		session.setAttribute("isAdimin", isAdimin);

		if (roletype == 1 )// ��ʦ
		{
			TabTeachers teacher = entityDAO.findTeacherByID(id);
			if (teacher == null)
			{
				returnValue+="<tr><font color=\"red\">���Ľ�ʦ��ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
				returnValue += new Top("������Ϣ").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"�༭")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"�޸�����"));
				 
				return returnValue;
			}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table.addAtag(new Atag[] {
					new AItem("����   :", teacher.getFTeacherName()),
					new AItem("ְ���� :", teacher.getFTeacherNumber()),
					new AItem("�Ա�   :", teacher.getFTeacherSex()),
					new AItem("��������:",
							teacher.getFTeacherBirthday() == null ? ""
									: teacher.getFTeacherBirthday()
											.toLocaleString().substring(0, 10)),
					new AItem("ѧ��   :", teacher.getFTeacherXueLi()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�绰   :", teacher.getFTeacherTel()),
					new AItem("�ֻ�   :", teacher.getFTeacherPhone()),
					new AItem("Email :", teacher.getFTeacherEmail()),
					new AItem("��ϵ��ַ:", teacher.getFTeacherAddress()),
					new AItem("�����ص�:", teacher.getFTeacherWorkPlace()) });
			returnValue += table;
			returnValue += new Top("����");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�о�����:", teacher.getFTeacherResearch()),
					new AItem("ְλ   :", teacher.getFTeacherPosition()),
					new AItem("ְ��   :", teacher.getFTeacherZhiCheng())

			});
			returnValue += table;
		}
		if (roletype == 4)// У������ �ų�ѧ������ʦ�����̵İ���
		{
			JfptTabOtherassist assist = entityDAO.findOtherassistByID(id);
			if (assist == null)
			{ returnValue+="<tr><font color=\"red\">�������̽�ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
				returnValue += new Top("������Ϣ").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"�༭")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"�޸�����"));
				
				return returnValue;
				}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table.addAtag(new Atag[] {
					new AItem("����   :", assist.getFName()),
					new AItem("�Ա�   :", assist.getFSex()),
					new AItem("����   :", assist.getFAge() == null ? "" : assist
							.getFAge().toString()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�绰   :", assist.getFTelephone()),
					new AItem("Email :", assist.getFEmailAddress()) });
			returnValue += table;
		}
		if (roletype == 5)// �ҳ�
		{
			XsglTabParents parent = entityDAO.findParentsByID(id);
			if (parent == null)
				return "<tr><font color=\"red\">��û�б༭�ҳ���Ӧ��Ϣ�����ȱ༭��</font></tr>";
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����")).addLink(
									new ALink("LINK21", "showPIAction!editPersonalInfo.action",
									"��ѯ������Ů�ĸ�����Ϣ"));
			table.addAtag(new Atag[] {
					new AItem("����   :", parent.getFParentName()),
					new AItem("�ʺ�   :", parent.getFParentId()) });
			returnValue += table;
		}
		if (roletype == 6)// ��ҵ
		{
			TabCompany company = entityDAO.findCompanyByID(id);
			if (company == null)
			{
				
				returnValue+="<tr><font color=\"red\">������ҵ��ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
				returnValue += new Top("������Ϣ").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"�༭")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"�޸�����"));
				 
				return returnValue;
			}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table.addAtag(new Atag[] {
					new AItem("����   :", company.getFCompanyNumber()),
					new AItem("��˾����   :", company.getFCompanyName()),
					new AItem("��������:", company.getFCooperateInfo()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("��ϵ��  :", company.getFConnectPerson()),
					new AItem("�绰   :", company.getFTelephone()),
					new AItem("Email :", company.getFEmailAddress()),
					new AItem("��ַ   :", company.getFAddress()) });
			returnValue += table;
			returnValue += new Top("����");
			table.clear();
			table.addAtag(new Atag[] { new AItem("��ϸ��Ϣ   :", company
					.getFInformation()) });
			returnValue += table;
		}
		if (roletype == 7)// ������
		{
			TabStudents student = entityDAO.findStudentByID(id);

			TabUndergraduate undergraduate = entityDAO
					.findUndergraduateByID(id);
			if (student == null)
				{
				  returnValue+="<tr><font color=\"red\">����ѧ����ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
					returnValue += new Top("������Ϣ").addLink(
							new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
									"�༭")).addLink(
							new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
									"�޸�����"));
					
					return returnValue;
				}
			if(undergraduate == null)
			{
				undergraduate = new TabUndergraduate();
			}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table
					.addAtag(new Atag[] {
							new AItem("����   :", student.getFStudentName()),
							new AItem("�ʺ�   :", student.getFStudentNumber()),
							new AItem("���   :", "������"),
							new AItem("�༶   :",
									student.getTabClasses() == null ? ""
											: student.getTabClasses()
													.getFClassName()),
							new AItem("�Ա�   :", student.getFStudentSex()),
							new AItem("��������   :",
									student.getFStudentBirthday() == null ? ""
											: student.getFStudentBirthday()
													.toLocaleString()
													.substring(0, 10)),
							new AItem("רҵ   :", student.getFStudentMajor()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�ֻ�   :", student.getFStudentTel()),
					new AItem("Email :", student.getFStudentEmail()),
					new AItem("�̶��绰 :", student.getFHomeTel()),
					new AItem("����   :", student.getFStudentDormitory()) });
			returnValue += table;
			returnValue += new Top("����");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("����   :", undergraduate.getFStudentHighSchool()),
					new AItem("�߿�����:", undergraduate.getFStudentHscore()),
					new AItem("�Ƿ��һ־Ը:", undergraduate.getFIsFirstChoice()) });
			returnValue += table;
		}
		if (roletype == 8)// �о���
		{
			TabStudents student = entityDAO.findStudentByID(id);
			
			TabPostgraduate postgraduate = entityDAO.findPostgraduateByID(id);
			if (student == null){		
			returnValue+="<tr><font color=\"red\">����ѧ����ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			
			return returnValue;
		}
			if(postgraduate==null)
			{
				postgraduate=new TabPostgraduate();
			}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table
					.addAtag(new Atag[] {
							new AItem("����   :", student.getFStudentName()),
							new AItem("�ʺ�   :", student.getFStudentNumber()),
							new AItem("���   :", "�о���"),
							new AItem("�༶   :",
									student.getTabClasses() == null ? ""
											: student.getTabClasses()
													.getFClassName()),
							new AItem("�Ա�   :", student.getFStudentSex()),
							new AItem("��������   :",
									student.getFStudentBirthday() == null ? ""
											: student.getFStudentBirthday()
													.toLocaleString()
													.substring(0, 10)),
							new AItem("רҵ   :", student.getFStudentMajor()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�ֻ�   :", student.getFStudentTel()),
					new AItem("Email :", student.getFStudentEmail()),
					new AItem("�̶��绰 :", student.getFHomeTel()),
					new AItem("����   :", student.getFStudentDormitory()) });
			returnValue += table;
			returnValue += new Top("����");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("��ʦ   :", postgraduate.getTabTeachers()==null?"":
						 postgraduate.getTabTeachers().getFTeacherName()),
					new AItem("��ҵѧУ:", postgraduate.getFStudentExSchool()),
					new AItem("��ҵ����:", postgraduate.getFStudentEscore()),
					new AItem("�ȼ�   :", postgraduate.getFStudentErank()),
					new AItem("���   :", postgraduate.getFType()),
					new AItem("�Ƿ��һ־Ը:", postgraduate.getFIsFirstChoice()) });
			returnValue += table;
		}
		if (isAdimin&&roletype==0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null){
				returnValue+="<tr><font color=\"red\">���Ĺ���Ա��ɫû�б༭������Ϣ�����ȱ༭��</font></tr>";
				returnValue += new Top("������Ϣ").addLink(
						new ALink("LINK21", "showPIAction!editPersonalInfo.action?",
								"�༭")).addLink(
						new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
								"�޸�����"));
				return returnValue;
			}
			returnValue += new Top("������Ϣ").addLink(
					new ALink("LINK21", "showPIAction!editPersonalInfo.action",
							"�༭")).addLink(
					new ALink("LINK21", "1_mhqx/selfPage/changePassword.jsp",
							"�޸�����"));
			table.addAtag(new Atag[] {
					new AItem("�ʺ�   :",  admin.getFAdminNumber()
							),
					new AItem("����   :",  admin.getFName()),
					new AItem("�Ա�   :",  admin.getFSex()),
					new AItem("����   :", admin.getFAge() == null ? ""
							: admin.getFAge().toString()),
					new AItem("����   :",  admin.getFType()),
					new AItem("�Ƿ����ܹ���Ա   :",  admin.getFBoss()) });
			returnValue += table;
			returnValue += new Top("��ϵ��ʽ");
			table.clear();
			table.addAtag(new Atag[] {
					new AItem("�绰   :",  admin.getFTelephone()),
					new AItem("Email :",  admin
							.getFEmailAddress()) });
			returnValue += table;
		}
		if (isAdimin&&roletype!=0) {
			TabAdministrator admin = entityDAO.findAdministratorByID(id);
			if (admin == null)
				return returnValue+"���Ĺ���Ա��ɫû�б༭��Ӧ��Ϣ������ϵ�߼�����Ա��" ;
			table.addAtag(new Atag[] {
					new AItem("����Ա����:",  admin.getFType()),
			 });
			returnValue += table;
		}
		if (returnValue.length() == 0)
			return "��û�б༭��Ӧ��Ϣ������ϵ����Ա!" ;
		System.out.println(returnValue);
		return returnValue;
	}
}
