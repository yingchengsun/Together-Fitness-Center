package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
import com.xdsc.service.mail_system.MailServer;
public class MhqxTabUserAction extends ActionSupport {
	private String id;
	/**用户ID*/
	private int userid;
	private List<MhqxTabUser> userlist = new ArrayList<MhqxTabUser>();
	/**用户表操作对象*/
	private MhqxTabUserManager usermanager;
	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**用户表操作对象*/
	private MhqxTabUser user;
	/**用户密码*/
	private String Userpassword;
	/**确认密码*/
	private String confirmpassword;
	/**用户账号*/
	private String Usernumber;
	/**用于查询的用户账号*/
	private String searchusernumber;
	/**错误提示消息*/
	private String message = new String("");
	/***/
	private MhqxTabRoleUserManager userrolemanager;
	
	private MhqxTabRolefunctionManager rolefunctionmanager;
	
	private MhqxTabUserfunction userfunction;
	
	private List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction> ();
	
	private MhqxTabUserfunctionManager userfunctionmanager;
	
	private List<MhqxTabRoleuser> roleuserlist = new ArrayList<MhqxTabRoleuser>();
	
	private List<String> deletelist = new ArrayList<String>(); 
	
	private List<MhqxTabFunction> functionlist[] = new List[50];
	
	private List<MhqxTabFunction> ownfunctionlist[] = new List[50];
	
	private List<MhqxTabModuleuser> usermodulelist = new ArrayList<MhqxTabModuleuser>(); 
	
	private MhqxTabModuleuserManager usermodulemanager ;
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	
	private List<MhqxTabModule> unownmodulelist = new ArrayList<MhqxTabModule>();
	
	private MhqxTabModuleManager modulemanager ;

	private int flag[][];
	
	public String getSearchusernumber() {
		return searchusernumber;
	}
	public void setSearchusernumber(String searchusernumber) {
		this.searchusernumber = searchusernumber;
	}
	public String getUsernumber() {
		return Usernumber;
	}
	public void setUsernumber(String usernumber) {
		Usernumber = usernumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<MhqxTabUser> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<MhqxTabUser> userlist) {
		this.userlist = userlist;
	}
	public MhqxTabUserManager getUsermanager() {
		return usermanager;
	}
	public void setUsermanager(MhqxTabUserManager usermanager) {
		this.usermanager = usermanager;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public MhqxTabUser getUser() {
		return user;
	}
	public void setUser(MhqxTabUser user) {
		this.user = user;
	}
	public String getUserpassword() {
		return Userpassword;
	}
	public void setUserpassword(String userpassword) {
		Userpassword = userpassword;
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDeletelist() {
		return deletelist;
	}
	public void setDeletelist(List<String> deletelist) {
		this.deletelist = deletelist;
	}
	public String searchuser()
	{
		this.userlist = this.usermanager.findById(searchusernumber);
		return "searchuser";
	}

	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}
	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
	}
	
	public List<MhqxTabRoleuser> getRoleuserlist() {
		return roleuserlist;
	}
	public void setRoleuserlist(List<MhqxTabRoleuser> roleuserlist) {
		this.roleuserlist = roleuserlist;
	}
	public List<MhqxTabFunction>[] getFunctionlist() {
		return functionlist;
	}
	public void setFunctionlist(List<MhqxTabFunction>[] functionlist) {
		this.functionlist = functionlist;
	}
	
	public MhqxTabRolefunctionManager getRolefunctionmanager() {
		return rolefunctionmanager;
	}
	public void setRolefunctionmanager(
			MhqxTabRolefunctionManager rolefunctionmanager) {
		this.rolefunctionmanager = rolefunctionmanager;
	}

	
	public MhqxTabUserfunction getUserfunction() {
		return userfunction;
	}
	public void setUserfunction(MhqxTabUserfunction userfunction) {
		this.userfunction = userfunction;
	}
	public List<MhqxTabUserfunction> getUserfunctionlist() {
		return userfunctionlist;
	}
	public void setUserfunctionlist(List<MhqxTabUserfunction> userfunctionlist) {
		this.userfunctionlist = userfunctionlist;
	}
	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}
	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}

	public int[][] getFlag() {
		return flag;
	}
	public void setFlag(int[][] flag) {
		this.flag = flag;
	}
	
	public List<MhqxTabFunction>[] getOwnfunctionlist() {
		return ownfunctionlist;
	}
	public void setOwnfunctionlist(List<MhqxTabFunction>[] ownfunctionlist) {
		this.ownfunctionlist = ownfunctionlist;
	}
	
	public List<MhqxTabModuleuser> getUsermodulelist() {
		return usermodulelist;
	}
	public void setUsermodulelist(List<MhqxTabModuleuser> usermodulelist) {
		this.usermodulelist = usermodulelist;
	}
	public MhqxTabModuleuserManager getUsermodulemanager() {
		return usermodulemanager;
	}
	public void setUsermodulemanager(MhqxTabModuleuserManager usermodulemanager) {
		this.usermodulemanager = usermodulemanager;
	}
	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}
	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}
	public List<MhqxTabModule> getUnownmodulelist() {
		return unownmodulelist;
	}
	public void setUnownmodulelist(List<MhqxTabModule> unownmodulelist) {
		this.unownmodulelist = unownmodulelist;
	}
	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}
	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}
	/**
	 * <p>分页显示用户列表<br>
	 * @return action result
	 */
	public String showuserlist()
	{
		this.userlist = usermanager.findAll();
		int pages = 10;
		int listlength = this.userlist.size();
		if(listlength==0)
			return "showuserlist";
		if (listlength % pages == 0) {
			this.lastPage = listlength / pages;
		} else {
			this.lastPage = listlength / pages + 1;
		}
		if (this.p < 1)
			this.p = 1;
		if (this.p > this.lastPage)
			this.p = this.lastPage;
		int startIndex = (this.p - 1) * pages;
		int endIndex = startIndex + pages;
		if (endIndex >= listlength)
			endIndex = listlength;
		this.userlist = this.userlist.subList(startIndex, endIndex);		
		return "showuserlist";		
	}
	/**
	 * <p>多选删除用户条目<br>
	 * @return action result
	 */
	public String multipledelete()
	{
		MhqxTabUser user = new MhqxTabUser();
		if (this.deletelist.size()==0)
			return "multipledelete";
		Iterator<String> iterator = deletelist.iterator();
		MailServer mailServer = new MailServer();
		while(iterator.hasNext())
		{
			user = this.usermanager.findById(iterator.next()).iterator().next();
			this.usermanager.delete(user);
			//*********
			//删除邮件服务器上的记录
			
			mailServer.deleteUser(user.getFUserNumber());
			//*********
		}
		System.out.println("the delete number is :"+deletelist.size());
		return "multipledelete";
	}
	/**
	 * <p>删除单个用户条目<br>
	 * @return action result
	 */
	public String deleteuser()
	{
		List<MhqxTabUser> userlist = this.usermanager.findById(id);
		Iterator<MhqxTabUser> puser = userlist.iterator();
		user = puser.next();
		this.usermanager.delete(user);
		
		//*********
		//删除邮件服务器上的记录
		MailServer mailServer = new MailServer();
		mailServer.deleteUser(user.getFUserNumber());
		//*********
		
		return "delete";
	}
	/**
	 * <p>修改用户用户条目<br>
	 * @return action result
	 */
	public String modifyuser()
	{
		List<MhqxTabUser> userlist = this.usermanager.findById(id);
		Iterator<MhqxTabUser> puser = userlist.iterator();
		this.user = puser.next();
		System.out.println("user id:"+user.getFUserNumber());
		System.out.println("user password:"+user.getFUserPassword());
		return "modify";
	}
	/**
	 * <p>更新用户条目<br>
	 * @return action result
	 */
	public String updateuser()
	{
		this.usermanager.update(user);
		return "update";
	}
	/**
	 * <p>添加用户条目<br>
	 * @return action result
	 */
	public String adduser()
	{
		System.out.println("adduser");
		HttpSession session = ServletActionContext.getRequest().getSession();

		session.setAttribute("UserNumber", Usernumber);
		MhqxTabUser user = new MhqxTabUser();
		user.setFUserNumber(Usernumber);
		user.setFUserPassword(Userpassword);
		List<MhqxTabUser> userlist = this.usermanager.findById(Usernumber);
		if(userlist.size()!=0)
		{
			System.out.println("the user exists!");
			message = new String("the user exists!");
			return "error";
		}
		this.message=null;
		this.usermanager.save(user);
		
		//*****************
		//向邮件服务器注册新用户
		MailServer mailServer = new MailServer();
		mailServer.addUser(Usernumber, Userpassword);
		//******************

		return "add";
	}
	public String showUserRoleFunction()
	{
		
		this.roleuserlist = this.userrolemanager.findByUserNumber(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("FUserNumber", id);
		int roleid = 0;
		this.userfunctionlist = this.userfunctionmanager.findMhqxTabUserfunctionByUserNumber(id);
		int tag= 0 ;
		for(int i = 0 ;i<this.roleuserlist.size();i++)
		{
			roleid = this.roleuserlist.get(i).getMhqxTabRole().getFRoleId();
			List<MhqxTabRolefunction>  rolefunctionlist =  this.rolefunctionmanager.findByRoleId(roleid);
			this.functionlist[i] = new ArrayList();
			this.ownfunctionlist[i] = new ArrayList();
	
			for(int k = 0;k<rolefunctionlist.size();k++)
			{
				tag= 0 ;
				MhqxTabRolefunction rolefunction  = rolefunctionlist.get(k);
				for(int j = 0;j<this.userfunctionlist.size();j++)
				{
					if(this.userfunctionlist.get(j).getMhqxTabFunction().getFFunctionId().equals(rolefunction.getMhqxTabFunction().getFFunctionId()))
					{
						this.ownfunctionlist[i].add(rolefunction.getMhqxTabFunction());
						tag = 1;
					}
				}
				if (tag==0) {
					this.functionlist[i].add(rolefunction.getMhqxTabFunction());
				}
			}
		}
		this.unownmodulelist.clear();
		this.usermodulelist.clear();
		this.usermodulelist = this.usermodulemanager.findMhqxTabModuleuserByUserNumber(id);
		this.modulelist = this.modulemanager.findAll();
		
		Iterator<MhqxTabModule> moduleiterator = this.modulelist.iterator();
		int tag2 = 0;
		for(int n = 0;n<this.modulelist.size();n++)
		{
			tag2 = 0;
			MhqxTabModule module = this.modulelist.get(n);
			for(int i = 0;i<this.usermodulelist.size();i++)
			{
				if(module.getFModuleId().equals(this.usermodulelist.get(i).getMhqxTabModule().getFModuleId()))
				{
					tag2=1;
				}
			}
			if(tag2==0)
			{
				this.unownmodulelist.add(module);
			}
		}
		return "showUserRoleFunction";
	}

	public void validateAdduser() {
		// TODO Auto-generated method stub
		System.out.println("validateAdduser");
		this.clearFieldErrors();
		if(!confirmpassword.equals(Userpassword))
		{
			System.out.println("confirmpassword"+confirmpassword);
			System.out.println("Userpassword"+Userpassword);
			addFieldError("confirmpassword", "输入的密码不一致");
		}
		if(this.Usernumber.equals("")||this.Usernumber==null)
		{
			addFieldError("Usernumber","不能为空");
		}
		if(this.confirmpassword.equals("")||this.confirmpassword==null)
		{
			addFieldError("confirmpassword","不能为空");
		}
		if(this.Userpassword.equals("")||this.Userpassword==null)
		{
			addFieldError("Userpassword","不能为空");
		}
	}
	
}
