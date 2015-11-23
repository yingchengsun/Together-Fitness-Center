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
 * @author 郑灿双 2010-04-30
 * 
 * @version 1.1
 *
 */
public class ContactAction extends ActionSupport {
	
	
	/**
	 * 通讯录相关属性
	 */
	private int CId;
	private String CName;
	private String CPassword;
	private String CUsername;
	
	
	
	/**
	 * 与数据库进行交互类的对象
	 */
	ContactDaoInterface contactDao;

	public ContactDaoInterface getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDaoInterface contactDao) {
		this.contactDao = contactDao;
	}
	
	
	/**查看所有的账户信息 配有分页功能
	 * @return SUCCESS 显示通讯录列表的页面
	 */
	public String contactAll(){
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactDao.findContact();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**分页功能中 响应点击[前一页]的函数
	 * @return SUCCESS 显示前一页列表
	 */
	public String previous(){
		HttpServletRequest request = ServletActionContext.getRequest();

		PageListHolder ContList =(PageListHolder) request.getSession().getAttribute("ViewContacts");
		ContList.previousPage();
		List<Contact> contactList = ContList.getPageList();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**分页功能中 响应点击[后一页]的函数
	 * @return SUCCESS 显示后一页列表
	 */
	public String next(){
		HttpServletRequest request = ServletActionContext.getRequest();

		PageListHolder ContList =(PageListHolder) request.getSession().getAttribute("ViewContacts");
		ContList.nextPage();
		List<Contact> contactList = ContList.getPageList();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	/**配置通讯录
	 * @return SUCCESS 返回符合条件的通讯录条目
	 */
	public String contactConfig(){
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactDao.findContact();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("contactList", contactList);
		return SUCCESS;
	}
	
	
	/**通过用户选择而传入的roleId 配置具有该角色的通讯录
	 * @return SUCCESS 返回符合条件的通讯录条目
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
	
	
	
	/**添加新的通讯录条目
	 * @return SUCCESS 添加一条记录到数据库，并且返回到成功提示页面
	 */
	public String addContact(){
		Contact contact = new Contact();
		contact.setCName(CName);
		contact.setCPassword(CPassword);
		contact.setCUsername(CUsername);
		contactDao.addContact(contact);
		return SUCCESS;
	}
	
	
	/**预查询结果 根据cid查询数据库
	 * @return SUCCESS 修改表项的页面，表单已经被查询的结果填充
	 */
	public String preupdateContact(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid= Integer.parseInt(request.getParameter("cid"));
		Contact contact = contactDao.findById(cid);
		System.out.println("In ContactAction preupdateContact...");
		request.setAttribute("contact", contact);
		return SUCCESS;
	}
//	//更新操作
//	public String updateContact(){
//		Contact contact = contactDao.findById(CId);
//		System.out.println("In ContactAction updateContact..."+contact);
//		contact.setCName(CName);
//		contact.setCPassword(CPassword);
//		contact.setCUsername(CUsername);
//		contactDao.updateContact(contact);
//		return SUCCESS;
//	}
	
	
	/**更新操作
	 * @return 修改后台数据库相关条目，提示修改成功的页面
	 */
	public String updateContact(){
		Contact contact = contactDao.findById(CId);
		contact.setCName(CName);
		contact.setCPassword(CPassword);
		contact.setCUsername(CUsername);
		contactDao.updateContact(contact);
		return SUCCESS;
	}
	

	/**删除后台数据库制定条目的方法
	 * @return 删除成功，返回到列表显示页面
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
