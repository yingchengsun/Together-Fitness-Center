package com.xdsc.action.mail_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.dao.mail_system.ContactDaoInterface;
import com.xdsc.model.*;
import com.xdsc.util.mail_system.PageListHolder;

/**
 * @author ֣��˫ 2010-04-30
 * 
 * @version 1.1
 *
 */
public class ContactAction extends ActionSupport {
	
	
	/**
	 * ͨѶ¼�������
	 */
	private int CId;
	private String CName;
	private String CPassword;
	private String CUsername;
	
	
	
	/**
	 * �����ݿ���н�����Ķ���
	 */
	ContactDaoInterface contactDao;

	public ContactDaoInterface getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDaoInterface contactDao) {
		this.contactDao = contactDao;
	}
	
	
	/**�鿴���е��˻���Ϣ ���з�ҳ����
	 * @return SUCCESS ��ʾͨѶ¼�б��ҳ��
	 */
	public String contactAll(){
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactDao.findContact();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**��ҳ������ ��Ӧ���[ǰһҳ]�ĺ���
	 * @return SUCCESS ��ʾǰһҳ�б�
	 */
	public String previous(){
		HttpServletRequest request = ServletActionContext.getRequest();

		PageListHolder ContList =(PageListHolder) request.getSession().getAttribute("ViewContacts");
		ContList.previousPage();
		List<Contact> contactList = ContList.getPageList();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**��ҳ������ ��Ӧ���[��һҳ]�ĺ���
	 * @return SUCCESS ��ʾ��һҳ�б�
	 */
	public String next(){
		HttpServletRequest request = ServletActionContext.getRequest();

		PageListHolder ContList =(PageListHolder) request.getSession().getAttribute("ViewContacts");
		ContList.nextPage();
		List<Contact> contactList = ContList.getPageList();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**����ͨѶ¼
	 * @return SUCCESS ���ط���������ͨѶ¼��Ŀ
	 */
	public String contactConfig(){
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactDao.findContact();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	
	/**ͨ���û�ѡ��������roleId ���þ��иý�ɫ��ͨѶ¼
	 * @return SUCCESS ���ط���������ͨѶ¼��Ŀ
	 */
	public String contactConfigByRole(){
		HttpServletRequest request = ServletActionContext.getRequest();
//		int roleId =Integer.parseInt(request.getParameter("roleId"));
		List classList = contactDao.findByClass();
		
		//2010-06-01
		String role =(String) request.getSession().getAttribute("role");
		
		System.out.println("2010-06-01 shuang "+role);
		if("STUDENT".equals(role)){
			TabStudents student = (TabStudents) request.getSession().getAttribute("student");
			TabClasses classnumber = student.getTabClasses();
			//System.out.println("YYYYYYYYYY"+classnumber);
			List groupList = new ArrayList();
			for(int i = 0; i<classList.size();i++){
				TabClasses tclass = (TabClasses)classList.get(i);
				if(tclass.getFClassNumber().equals(classnumber.getFClassNumber())){
					groupList.add(tclass);
				}
			}
			//System.out.println("YYYYYYYYYYYYYYYY"+groupList.size());
			request.setAttribute("groupList", groupList);
		}
		
		else if("TEACHER".equals(role)){
			TabTeachers teacher = (TabTeachers) request.getSession().getAttribute("teacher");
			String gradenumber = teacher.getTabGrade().getFGradeNum();
//			String gradename = teacher.getTabGrade().getFGradeName();
			if(null==gradenumber){
				System.out.println("The gradenumber is null....");
				request.setAttribute("groupList", classList);
			}
			else{
				String year = gradenumber.substring(2);
				System.out.println("YYYYYYYY"+year);
				List gradeList = new ArrayList();
				for(int i = 0; i<classList.size();i++){
					TabClasses tclass = (TabClasses)classList.get(i);
					if(tclass.getFClassNumber().contains(year)){
						gradeList.add(tclass);
					}
				}
				request.setAttribute("groupList", gradeList);
			}
		}
		else{
			request.setAttribute("groupList", classList);
			System.out.println("%%%%%%%%"+classList.size());
		}
		return SUCCESS;
	}
	
	
	
	/**����µ�ͨѶ¼��Ŀ
	 * @return SUCCESS ���һ����¼�����ݿ⣬���ҷ��ص��ɹ���ʾҳ��
	 */
	public String addContact(){
		Contact contact = new Contact();
		contact.setCName(CName);
		contact.setCPassword(CPassword);
		contact.setCUsername(CUsername);
		contactDao.addContact(contact);
		return SUCCESS;
	}
	
	
	/**Ԥ��ѯ��� ����cid��ѯ���ݿ�
	 * @return SUCCESS �޸ı����ҳ�棬���Ѿ�����ѯ�Ľ�����
	 */
	public String preupdateContact(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid= Integer.parseInt(request.getParameter("cid"));
		Contact contact = contactDao.findById(cid);
		System.out.println("In ContactAction preupdateContact...");
		request.setAttribute("contact", contact);
		return SUCCESS;
	}
//	//���²���
//	public String updateContact(){
//		Contact contact = contactDao.findById(CId);
//		System.out.println("In ContactAction updateContact..."+contact);
//		contact.setCName(CName);
//		contact.setCPassword(CPassword);
//		contact.setCUsername(CUsername);
//		contactDao.updateContact(contact);
//		return SUCCESS;
//	}
	
	
	/**���²���
	 * @return �޸ĺ�̨���ݿ������Ŀ����ʾ�޸ĳɹ���ҳ��
	 */
	public String updateContact(){
		Contact contact = contactDao.findById(CId);
		contact.setCName(CName);
		contact.setCPassword(CPassword);
		contact.setCUsername(CUsername);
		contactDao.updateContact(contact);
		return SUCCESS;
	}
	

	/**ɾ����̨���ݿ��ƶ���Ŀ�ķ���
	 * @return ɾ���ɹ������ص��б���ʾҳ��
	 */
	public String deleteContact(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid= Integer.parseInt(request.getParameter("cid"));
		Contact contact = contactDao.findById(cid);
		contactDao.deleteContact(contact);
		return SUCCESS;
		
	}

	public int getCId() {
		return CId;
	}

	public String getCName() {
		return CName;
	}

	public String getCPassword() {
		return CPassword;
	}

	public String getCUsername() {
		return CUsername;
	}

	public void setCId(int id) {
		CId = id;
	}

	public void setCName(String name) {
		CName = name;
	}

	public void setCPassword(String password) {
		CPassword = password;
	}

	public void setCUsername(String username) {
		CUsername = username;
	}
	
	
}
