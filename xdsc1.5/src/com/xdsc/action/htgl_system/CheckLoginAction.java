package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabRemind;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;
import com.xdsc.service.bksx_system.TabTeachersManager;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
import com.xdsc.service.mail_system.POP3Help;
import com.xdsc.service.wzmh_system.GetBasicInfoManager;

import com.xdsc.service.xsgl_system.XsglTabParentsManager;
import com.xdsc.service.xsgl_system.XsglTabTeachersManager;
import com.xdsc.check.AppException;
import com.xdsc.dao.mail_system.*;

/**
 * 
 * @author WenboTse
 * @version 1.1
 */
public class CheckLoginAction extends ActionSupport {
	/** 用户账号 */
	private String usernumber;
	/** 用户密码 */
	private String password;
	/** 模块ID */
	private int moduleid;
	/** 用户操作对象 */
	private MhqxTabUserManager usermanager;
	/** 用户功能操作对象 */
	private MhqxTabUserfunctionManager userfunctionmanager;
	/** 用户模块操作对象 */
	private MhqxTabModuleuserManager moduleusermanager;
	/** 功能操作对象 */
	private MhqxTabFunctionManager functionmanager;
	/** 学生操作对象 */
	private TabStudentsManager tabStudentsManager;
	/** 教师操作对象 */
	private TabTeachersManager tabTeachersManager;
	/** 学生指导导师表操作对象 */
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	/** 用户角色操作对象 */
	private MhqxTabRoleUserManager userrolemanager;

	private GetBasicInfoManager basicInfoManager;

	private String uri;
	/**
	 * 邮件管理的DAO
	 */
	private MailManagerDaoInterface mailManagerDao;

	private MhqxTabUser user;

	private List<MhqxTabModuleuser> usermodulelist = new ArrayList<MhqxTabModuleuser>();

	private List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction>();

	private List<MhqxTabFunction> functionlist = new ArrayList<MhqxTabFunction>();

	private List<MhqxTabFunction> subList[] = new ArrayList[15];// 所有子菜单

	private List<MhqxTabFunction> firstList = new ArrayList<MhqxTabFunction>();// 一级菜单

	private List<MhqxTabUserfunction> sublist[] = new ArrayList[15];

	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();

	private MhqxTabModule module;
	
	private com.xdsc.service.wzmh_system.CssManager cssManagerImpl; //管理个人主页风格
	

	private XsglTabParentsManager xsglTabParentsManager;

	private XsglTabTeachersManager xsglTabTeachersManager;
	

	public GetBasicInfoManager getBasicInfoManager() {
		return basicInfoManager;
	}

	public void setBasicInfoManager(GetBasicInfoManager basicInfoManager) {
		this.basicInfoManager = basicInfoManager;
	}

	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}

	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

	public TabTeachersManager getTabTeachersManager() {
		return tabTeachersManager;
	}



	public synchronized com.xdsc.service.wzmh_system.CssManager getCssManagerImpl() {
		return cssManagerImpl;
	}

	public synchronized void setCssManagerImpl(
			com.xdsc.service.wzmh_system.CssManager cssManagerImpl) {
		this.cssManagerImpl = cssManagerImpl;
	}

	public void setTabTeachersManager(TabTeachersManager tabTeachersManager) {
		this.tabTeachersManager = tabTeachersManager;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public MhqxTabModule getModule() {
		return module;
	}

	public void setModule(MhqxTabModule module) {
		this.module = module;
	}

	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}

	public List<MhqxTabUserfunction>[] getSublist() {
		return sublist;
	}

	public void setSublist(List<MhqxTabUserfunction>[] sublist) {
		this.sublist = sublist;
	}

	public List<MhqxTabFunction>[] getSubList() {
		return subList;
	}

	public void setSubList(List<MhqxTabFunction>[] subList) {
		this.subList = subList;
	}

	public List<MhqxTabFunction> getFirstList() {
		return firstList;
	}

	public void setFirstList(List<MhqxTabFunction> firstList) {
		this.firstList = firstList;
	}

	public MhqxTabFunctionManager getFunctionmanager() {
		return functionmanager;
	}

	public void setFunctionmanager(MhqxTabFunctionManager functionmanager) {
		this.functionmanager = functionmanager;
	}

	public List<MhqxTabFunction> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(List<MhqxTabFunction> functionlist) {
		this.functionlist = functionlist;
	}

	public int getModuleid() {
		return moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public synchronized XsglTabParentsManager getXsglTabParentsManager() {
		return xsglTabParentsManager;
	}

	public synchronized void setXsglTabParentsManager(
			XsglTabParentsManager xsglTabParentsManager) {
		this.xsglTabParentsManager = xsglTabParentsManager;
	}

	public synchronized XsglTabTeachersManager getXsglTabTeachersManager() {
		return xsglTabTeachersManager;
	}

	public synchronized void setXsglTabTeachersManager(
			XsglTabTeachersManager xsglTabTeachersManager) {
		this.xsglTabTeachersManager = xsglTabTeachersManager;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MhqxTabUser getUser() {
		return user;
	}

	public void setUser(MhqxTabUser user) {
		this.user = user;
	}

	public MhqxTabUserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(MhqxTabUserManager usermanager) {
		this.usermanager = usermanager;
	}

	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}

	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}

	public MhqxTabModuleuserManager getModuleusermanager() {
		return moduleusermanager;
	}

	public void setModuleusermanager(MhqxTabModuleuserManager moduleusermanager) {
		this.moduleusermanager = moduleusermanager;
	}

	public List<MhqxTabModuleuser> getUsermodulelist() {
		return usermodulelist;
	}

	public void setUsermodulelist(List<MhqxTabModuleuser> usermodulelist) {
		this.usermodulelist = usermodulelist;
	}

	public List<MhqxTabUserfunction> getUserfunctionlist() {
		return userfunctionlist;
	}

	public void setUserfunctionlist(List<MhqxTabUserfunction> userfunctionlist) {
		this.userfunctionlist = userfunctionlist;
	}

	public MailManagerDaoInterface getMailManagerDao() {
		return mailManagerDao;
	}

	public void setMailManagerDao(MailManagerDaoInterface mailManagerDao) {
		this.mailManagerDao = mailManagerDao;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	
	
	
	/**
	 * 重新登录 用于改变页面风格
	 * @return
	 */
	public String relogin()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		setColor(session);
		return "relogin";
	}
	
	
	
	
	/**
	 * <p>
	 * 锟斤拷锟斤拷没锟斤拷锟铰�<br>
	 * 
	 * @return 锟斤拷录锟缴癸拷锟斤拷action result
	 */
	public String checklogin() {
		this.userfunctionlist.clear();
		this.usermodulelist.clear();

		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();

		if(usernumber==null&&session.getAttribute("FUserNumber")!=null&&session.getAttribute("password")!=null) //重新登录
		{
			usernumber=session.getAttribute("FUserNumber").toString();
			password=session.getAttribute("password").toString();
		}
		
		
		List<MhqxTabRole> rolelist = new ArrayList();
		List<MhqxTabRoleuser> li = userrolemanager.findByUserNumber(usernumber);
		for (MhqxTabRoleuser ru : li)
			rolelist.add(ru.getMhqxTabRole());
		
		basicInfoManager.getInfo(usernumber, rolelist);

		uri = (String) session.getAttribute("url");

		MhqxTabUser muser = null;
		if (usermanager.findById(usernumber) != null
				&& usermanager.findById(usernumber).size() != 0) {
			muser = usermanager.findById(usernumber).get(0);
		}
		else{		
			new AppException("用户不存在");
			return ERROR;
		}
		if (muser != null && password.equals(muser.getFUserPassword())) {

			session.setAttribute("FUserNumber", usernumber);
			session.setAttribute("userNumber", usernumber);

			if (IsThisRole(usernumber, "本科生")) {
				session.setAttribute("student", tabStudentsManager
						.getStudentById(usernumber));
				session.setAttribute("role", "STUDENT");
				BksxTabSubstugui substugui = bksxTabSubstuguiManager
						.getSubstuguiByStuNum(usernumber);
				if (substugui != null) {
					BksxTabProject project = substugui.getBksxTabProject();
					if (project != null)
						session.setAttribute("subject", "project");
					else
						session.setAttribute("subject", "reaserch");
				} else {
					session.setAttribute("showAvaliable", "Y");
				}
			} else if (IsThisRole(usernumber, "毕设系统管理员")) {
				session.setAttribute("role", "ADMIN");
			} else if (IsThisRole(usernumber, "导师")) {
				session.setAttribute("teacher", tabTeachersManager
						.getTeacherById(usernumber));
				session.setAttribute("role", "TEACHER");
			}
			
			
			//xsgl
			if(IsThisRole(usernumber,"辅导员"))
			{
				session.setAttribute("role", "TEACHER");
				session.setAttribute("teacher", xsglTabTeachersManager.getTeacherByTeaNum(usernumber).get(0));
				System.out.println("2010-06-01 shuang");
			}
			else if(IsThisRole(usernumber,"家长"))
			{
				session.setAttribute("parent", xsglTabParentsManager.getParentById(usernumber));
			}
			else if(IsThisRole(usernumber,"学生管理系统管理员"))
			{
				
			}
			
			
			
			/** mail */
			// 锟斤拷锟斤拷锟斤拷sohu锟斤拷pop3锟斤拷锟斤拷锟斤拷
			String host = new String("localhost");
			String smtpServer = new String("localhost");
			request.getSession().setAttribute("host", host);
			// 锟斤拷锟斤拷锟斤拷sohu锟斤拷smtp锟斤拷锟斤拷锟斤拷
			request.getSession().setAttribute("smtpServer", smtpServer);
			// 锟矫碉拷锟斤拷应锟斤拷锟斤拷锟斤拷

			request.getSession().setAttribute("username", usernumber);
			request.getSession().setAttribute("password", password);

			POP3Help pop3 = new POP3Help();
			Folder folder = pop3.getFolder(host, usernumber, password);
			if (folder != null) {
				// 锟斤拷锟斤拷锟斤拷浠帮拷堑玫锟斤拷始锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷讯锟斤拷始锟斤拷锟斤拷锟�
				int countOfSeen = mailManagerDao.findCountOfSeen(usernumber);
				// 锟矫碉拷锟绞硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟绞硷拷锟斤拷锟斤拷
				int countOfInbox = 0;
				try {
					countOfInbox = folder.getMessageCount();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// }锟斤拷锟�锟侥诧拷值锟斤拷锟斤拷未锟斤拷锟绞硷拷锟斤拷锟斤拷
				int countOfNew = countOfInbox - countOfSeen;

//				System.out
//						.println("In ManagerAction to count the number of new mails:"
//								+ countOfNew);
				request.getSession().setAttribute("countOfNew", countOfNew);
				request.getSession().setAttribute("folder", folder);
			}
//			else{
//				new AppException("邮件服务器未启动或登录失败");
//				return ERROR;
//			}
		} else {
			new AppException("密码错误");
			return ERROR;
		}
		session.setAttribute("password", password);
		setColor(session);
		AppException.clear();
		session.setAttribute("isLogin", "true");
		if (uri != null && uri.lastIndexOf(".action") >= 0) {
			System.out.println("action跳转");
			return "checkactionlogin";
		}
		System.out.println("jsp跳转");
		// return "checklogin";
		return SUCCESS;
	}

	
	/**
	 * 初始化个人主页背景色
	 * @param session
	 */
	public void setColor(HttpSession session)
	{
		MhqxTabRemind css=cssManagerImpl.findbyusernumber(usernumber);
		if(css==null)
		{
			session.setAttribute("css", "blue");
			session.setAttribute("color","royalblue");
		}
		else{
		session.setAttribute("css", css.getFRemindUrl());
		String color ="dark"+css.getFRemindUrl();
		if("purple".equals(css.getFRemindUrl()))
		{
			color="violet";
		}
		if("black".equals(css.getFRemindUrl()))
		{
			color="black";
		}
		if("blue".equals(css.getFRemindUrl()))
		{
			color="royalblue";
		}
		if("red5".equals(css.getFRemindUrl()))
		{
			color="#FF6666";
		}
		if("olive".equals(css.getFRemindUrl()))
		{
			color="#66CC00";
		}
		if("darkgray".equals(css.getFRemindUrl()))
		{
			color="darkgray";
		}
		session.setAttribute("color",color);
		}	
	}
	
	
	/**
	 * <p>
	 * 锟叫讹拷锟矫伙拷锟斤拷色<br>
	 * 
	 * @return 锟斤拷锟矫伙拷拥锟叫该斤拷色时锟斤拷锟斤拷true,锟斤拷锟津返伙拷false.
	 */
	public boolean IsThisRole(String userNumber, String role) {
		List list = userrolemanager.findByUserNumber(userNumber);
		for (int i = 0; i < list.size(); i++) {
			if ((((MhqxTabRoleuser) list.get(i)).getMhqxTabRole()
					.getFRoleName().equals(role)))
				return true;
		}
		return false;
	}


}
