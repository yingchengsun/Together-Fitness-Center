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
 * ��ȡ�û�������Ϣ ��ʾ�ʺ���
 * 
 * @author �·�
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
	 * ��ȡ��ǰʱ�� �û���ʾ
	 * @return �ʺ���
	 */
	public String getWelcome(){
		Date d = new Date();
		int hour=d.getHours();
		
		System.out.println("��ǰʱ�䣺"+d.getHours());
		String welcome=" ";
		if(hour>=6&&hour<12)
			welcome+="�����";
		if(hour>=12&&hour<14)
			welcome+="�����";
		if(hour>=14&&hour<18)
			welcome+="�����";
		if(hour>=18&&hour<22)
			welcome+="���Ϻ�";
		if((hour>=22&&hour<24)||(hour>=0&&hour<6))
			welcome+="ҹ���ˣ���ע����Ϣ";
			return "";
	}
	
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.wzmh_system.GetBasicInfoManager#getInfo(java.lang.String, java.util.List)
	 */
	public void getInfo(String id, List<MhqxTabRole> rolelist) {
		System.out.println("����+++++++++++++"+id);
		
		int roletype = 0;
		boolean isAdimin = false;
		HttpSession session = ServletActionContext.getRequest().getSession();
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.isEmpty())
				return;
			MhqxTabRole role = rolelist.get(i);
			String name = role.getFRoleName();

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
		}
		session.setAttribute(Constant.Welcome,"���ã����ĸ�����Ϣ�����������ȱ༭������Ϣ��");
		if (roletype == 1 )// ��ʦ
		{
			TabTeachers teacher = entityDAO.findTeacherByID(id);
			if (teacher == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+teacher.getFTeacherName()+getWelcome());
		}
		if (roletype == 4)// У������ �ų�ѧ������ʦ�����̵İ���
		{
			JfptTabOtherassist assist = entityDAO.findOtherassistByID(id);
			if (assist == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+assist.getFName()+getWelcome());
		}
		if (roletype == 5)// �ҳ�
		{
			XsglTabParents parent = entityDAO.findParentsByID(id);
			if (parent == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+parent.getFParentName()+getWelcome());
		}
		if (roletype == 6)// ��ҵ
		{
			TabCompany company = entityDAO.findCompanyByID(id);
			if (company == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+company.getFCompanyName()+getWelcome());
		}
		if (roletype == 7)// ������
		{
			TabStudents student = entityDAO.findStudentByID(id);
			if (student == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+student.getFStudentName()+getWelcome());
		}
		if (roletype == 8)// �о���
		{
			TabStudents student = entityDAO.findStudentByID(id);
			if (student == null)
				return;
			session.setAttribute(Constant.Welcome,"��ӭ����"+ student.getFStudentName()+getWelcome());
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
